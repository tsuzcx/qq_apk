package cooperation.ilive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.plugin.IlivePluginCallback;
import cooperation.ilive.plugin.IlivePluginManager;
import cooperation.ilive.share.IliveShareHelper;
import cooperation.ilive.time.TimeMonitorConfig;
import cooperation.ilive.time.TimeMonitorData;
import cooperation.ilive.time.TimeMonitorManager;
import cooperation.ilive.util.ElapseStat;
import cooperation.ilive.util.IliveEntranceUtil;
import cooperation.ilive.util.IlivePreloadHelper;
import cooperation.ilive.util.IlivePreloadHelper.PreloadEnd;
import eipc.EIPCClient;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class IliveLaunchFragment
  extends PublicBaseFragment
  implements IliveDownloadCallback, IlivePluginCallback, IlivePreloadHelper.PreloadEnd
{
  private static final String ACTION_CLOSE_PREPARE_FRAGMENT = "qqlive_anchor_prepare_fragment";
  private static final String KEY_BROADCAST_SEND_TIME = "broadcast_send_time";
  private static final String TAG = "IliveLaunchActivity";
  private static EnterCallback mEnterCallback = new IliveLaunchFragment.7();
  private static long mStartTimeMillis;
  private boolean isPreloadModel = false;
  private IliveShareHelper mIliveShareHelper;
  private volatile boolean mIsPluginFileExist = false;
  private volatile boolean mIsSoLoadSuccess = false;
  private ProgressBar mLoadingProgressBar;
  private TextView mLoadingText;
  private FrameLayout mParentLayout;
  
  private void cancelPreDownload()
  {
    QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "action_cancel_pre_load", null, null);
  }
  
  private void cancelPreload()
  {
    if (IlivePreloadHelper.a)
    {
      QLog.i("IliveLaunchActivity", 1, "preload cancle", new Throwable());
      IlivePreloadHelper.a = false;
      IlivePreloadHelper.a();
    }
  }
  
  private void downloadPlugin()
  {
    TimeMonitorManager.a().b("PLUGIN_DOWNLOAD");
    cancelPreDownload();
    IlivePluginDownloadManager.a().l();
  }
  
  private void initData()
  {
    ElapseStat.a("IliveLaunch initData");
    if (getBaseActivity() == null) {
      return;
    }
    Object localObject1 = getBaseActivity().getIntent();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((Intent)localObject1).getBundleExtra("KEY_EXTRAS");
    if (localObject2 == null) {
      return;
    }
    long l = ((Bundle)localObject2).getLong("start_time", 0L);
    if (l > 0L)
    {
      localObject1 = ((Bundle)localObject2).getString("source");
      int i = ((Bundle)localObject2).getInt("page_type", 0);
      if (i == 1) {
        TimeMonitorManager.a().b("ANCHOR_ENTER_ROOM");
      } else if (i == 3) {
        TimeMonitorManager.a().b("WATCH_ENTER_ROOM");
      }
      l = System.currentTimeMillis() - l;
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("source", localObject1);
      ((HashMap)localObject2).put("process_start_time", String.valueOf(l));
      VasStatisticCollector.a("launcher", (Map)localObject2, l);
    }
    ElapseStat.b("IliveLaunch initData");
  }
  
  private void initTransparentStateBar(Activity paramActivity)
  {
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        if ((Build.VERSION.SDK_INT >= 21) && (!OSUtils.isEMUI3_1()))
        {
          paramActivity.getWindow().clearFlags(67108864);
          paramActivity.getWindow().addFlags(-2147483648);
          paramActivity.getWindow().setStatusBarColor(0);
          return;
        }
        paramActivity.getWindow().addFlags(4194304);
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private void initVideoSDK()
  {
    ElapseStat.a("IliveLaunch initVideoSDK");
    long l = System.currentTimeMillis();
    this.mIsSoLoadSuccess = QQVideoPlaySDKManager.isSoLoadSucess();
    if (!this.mIsSoLoadSuccess)
    {
      QQVideoPlaySDKManager.initQQImp();
      LoadSoUtil.loadSo(new IliveLaunchFragment.5(this, l));
    }
  }
  
  private static void preloadEnd()
  {
    QLog.i("IliveLaunchActivity", 1, "preload end");
    IlivePreloadHelper.a = false;
    IlivePreloadHelper.a();
    long l1 = System.currentTimeMillis();
    long l2 = mStartTimeMillis;
    ThreadManager.getFileThreadHandler().post(new IliveLaunchFragment.8(l1 - l2));
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity != null) {
      localBaseActivity.runOnUiThread(paramRunnable);
    }
  }
  
  private void showLoadingUI()
  {
    runOnUiThread(new IliveLaunchFragment.6(this));
  }
  
  private void startPreloadRecord()
  {
    this.isPreloadModel = true;
    mStartTimeMillis = System.currentTimeMillis();
    ThreadManager.getFileThreadHandler().post(new IliveLaunchFragment.4(this));
  }
  
  public static void startSelf(Context paramContext, Intent paramIntent)
  {
    if (!IliveEntranceUtil.b())
    {
      ThreadManagerV2.getUIHandlerV2().post(new IliveLaunchFragment.1());
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (!IliveEntranceUtil.a(localIntent.getBooleanExtra("KEY_IS_START_LIVE", false))) {
      return;
    }
    if (!IliveEntranceUtil.a(500))
    {
      QLog.e("IliveLaunchActivity", 1, "startSelf isClickEnable = false");
      return;
    }
    localIntent.setClass(paramContext, PublicTransFragmentActivityForTool.class);
    localIntent.putExtra("moduleId", "ilive_plugin");
    localIntent.putExtra("public_fragment_class", IliveLaunchFragment.class.getName());
    localIntent.addFlags(536870912);
    paramContext.startActivity(localIntent);
  }
  
  private void updateTransparentStateBar(Activity paramActivity)
  {
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        if ((Build.VERSION.SDK_INT >= 21) && (!OSUtils.isEMUI3_1()))
        {
          paramActivity.getWindow().clearFlags(67108864);
          paramActivity.getWindow().addFlags(-2147483648);
          paramActivity.getWindow().setStatusBarColor(Color.parseColor("#A96E4B"));
          return;
        }
        paramActivity.getWindow().addFlags(4194304);
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public void doLoading(boolean paramBoolean, Context paramContext)
  {
    ElapseStat.a("IliveLaunch doLoading");
    if (paramBoolean) {
      startPreloadRecord();
    }
    Object localObject = getArguments();
    int i = 0;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("source", 0);
    }
    IlivePluginManager.getInstance().refreshToken(i);
    IlivePreloadHelper.b = true;
    initVideoSDK();
    IlivePluginManager.getInstance().setIlivePluginCallback(this);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doLoading isPreload = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" sPreload = ");
    ((StringBuilder)localObject).append(IlivePreloadHelper.a);
    QLog.i("IliveLaunchActivity", 1, ((StringBuilder)localObject).toString());
    if ((!paramBoolean) && (IlivePreloadHelper.a))
    {
      QLog.i("IliveLaunchActivity", 1, "wait fo preload");
      IlivePreloadHelper.a(this);
      showLoadingUI();
      return;
    }
    ThreadManagerV2.executeOnSubThread(new IliveLaunchFragment.3(this, paramContext, paramBoolean));
    ElapseStat.b("IliveLaunch doLoading");
  }
  
  public void enterPlugin(Context paramContext, Intent paramIntent)
  {
    if (!this.mIsPluginFileExist)
    {
      paramContext = new StringBuilder();
      paramContext.append("start enterPlugin error , isLoginSuccess = ");
      paramContext.append(this.mIsPluginFileExist);
      paramContext.append(" isSoLoadSucess = ");
      paramContext.append(this.mIsSoLoadSuccess);
      QLog.e("IliveLaunchActivity", 1, paramContext.toString());
      return;
    }
    QLog.e("IliveLaunchActivity", 1, "start enterPlugin");
    if (paramContext == null)
    {
      QLog.e("IliveLaunchActivity", 1, "enterPlugin activity = null");
      return;
    }
    if (paramIntent != null) {
      paramIntent.putExtra("KEY_EXTRAS", paramIntent.getBundleExtra("KEY_EXTRAS"));
    }
    TimeMonitorManager.a().b("PLUGIN_LOAD");
    if (IlivePreloadHelper.a)
    {
      QLog.i("IliveLaunchActivity", 1, "preload shadow");
      paramContext = "preload";
    }
    else
    {
      paramContext = "com.tencent.ilivesdk.demo.LauncherActivity";
    }
    IlivePluginHelper.a(BaseApplicationImpl.getContext(), paramIntent, paramContext, mEnterCallback);
  }
  
  protected void finalize()
  {
    if (this.isPreloadModel)
    {
      IlivePreloadHelper.a = false;
      QLog.e("IliveLaunchActivity", 1, "finalize and reset  sIsPrelad");
    }
    super.finalize();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.e("IliveLaunchActivity", 1, "onCreateView");
    ElapseStat.a("IliveLaunch totalLaunch");
    paramViewGroup = getBaseActivity();
    paramLayoutInflater = null;
    if (paramViewGroup != null)
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramViewGroup.getWindow().addFlags(67108864);
        paramViewGroup.getWindow().addFlags(134217728);
      }
      ThreadManagerV2.executeOnSubThread(new IliveLaunchFragment.2(this));
      initTransparentStateBar(paramViewGroup);
      ElapseStat.a("IliveLaunchActivity");
      if (paramViewGroup.getIntent().getIntExtra("share", 0) == 1)
      {
        this.mIliveShareHelper = new IliveShareHelper(paramViewGroup, paramViewGroup.getIntent().getExtras());
        this.mIliveShareHelper.showActionSheet();
      }
      else
      {
        TimeMonitorManager.a().b("PLUGIN_ENTER_TOTAL_TIME");
        TimeMonitorConfig.a();
        this.mParentLayout = new FrameLayout(paramViewGroup);
        doLoading(false, getBaseActivity());
        ElapseStat.b("IliveLaunchActivity");
        paramLayoutInflater = this.mParentLayout;
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    TimeMonitorConfig.a = false;
    IlivePluginDownloadManager.a().a(null);
    IlivePluginDownloadManager.a().g();
    IlivePluginManager.getInstance().onDestory();
    IliveShareHelper localIliveShareHelper = this.mIliveShareHelper;
    if (localIliveShareHelper != null) {
      localIliveShareHelper.onDestroy();
    }
    super.onDestroyView();
  }
  
  public void onFail(int paramInt, String paramString)
  {
    cancelPreload();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new HashMap();
    paramString.put("status", "fail");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(str);
    paramString.put("errorCode", localStringBuilder.toString());
    TimeMonitorManager.a().d("PLUGIN_DOWNLOAD").a("plugin_download_result", paramString);
    paramString = new StringBuilder();
    paramString.append("onFail code = ");
    paramString.append(paramInt);
    paramString.append(" msg = ");
    paramString.append(str);
    QLog.e("IliveLaunchActivity", 1, paramString.toString());
    runOnUiThread(new IliveLaunchFragment.10(this, paramInt, str));
  }
  
  public void onPluginActivityCreate()
  {
    ElapseStat.b("IliveLaunch onPluginLaunch");
    QLog.e("IliveLaunchActivity", 1, "onPluginActivityCreate");
    TimeMonitorManager.a().d("PLUGIN_ENTER_TOTAL_TIME").b("ilive_plugin_launch_total_time");
    TimeMonitorConfig.b();
    ElapseStat.b("IliveLaunch totalLaunch");
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
    try
    {
      Intent localIntent = new Intent("qqlive_anchor_prepare_fragment");
      localIntent.putExtra("broadcast_send_time", System.currentTimeMillis());
      MobileQQ.sMobileQQ.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("IliveLaunchActivity", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onPluginLoginFail(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      cancelPreload();
      paramString = new StringBuilder();
      paramString.append("onPluginLoginFail code = ");
      paramString.append(paramInt);
      paramString.append(" msg = ");
      paramString.append(str);
      QLog.e("IliveLaunchActivity", 1, paramString.toString());
      runOnUiThread(new IliveLaunchFragment.13(this, paramInt));
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onPluginLoginStart()
  {
    QLog.e("IliveLaunchActivity", 1, "onPluginLoginStart");
    if (IlivePluginManager.sIsFastStart) {
      return;
    }
    runOnUiThread(new IliveLaunchFragment.11(this));
  }
  
  public void onPluginLoginSuccess()
  {
    QLog.e("IliveLaunchActivity", 1, "onPluginLoginSuccess login success");
    ElapseStat.a("IliveLaunch onPluginLaunch");
    runOnUiThread(new IliveLaunchFragment.12(this));
  }
  
  public void onPreloadEnd()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    QLog.e("IliveLaunchActivity", 1, "onPreloadEnd");
    if (localBaseActivity == null) {
      return;
    }
    doLoading(false, localBaseActivity);
  }
  
  public void onProgress(float paramFloat)
  {
    runOnUiThread(new IliveLaunchFragment.9(this, paramFloat));
  }
  
  public void onSuccess()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shadow onSuccess sPreload = ");
    ((StringBuilder)localObject).append(IlivePreloadHelper.a);
    QLog.e("IliveLaunchActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new HashMap();
    ((HashMap)localObject).put("status", "success");
    TimeMonitorManager.a().d("PLUGIN_DOWNLOAD").a("plugin_download_result", (HashMap)localObject);
    if (!IlivePluginDownloadManager.a().k())
    {
      onFail(101, "download success but local apk file is not exist");
      return;
    }
    ElapseStat.a("enterPlugin");
    this.mIsPluginFileExist = true;
    if (getBaseActivity() != null) {
      enterPlugin(getBaseActivity(), getBaseActivity().getIntent());
    } else if (IlivePreloadHelper.a) {
      enterPlugin(BaseApplicationImpl.getContext(), new Intent());
    }
    ElapseStat.b("enterPlugin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment
 * JD-Core Version:    0.7.0.1
 */