package cooperation.ilive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
import mqq.os.MqqHandler;

public class IliveLaunchFragment
  extends PublicBaseFragment
  implements IliveDownloadCallback, IlivePluginCallback, IlivePreloadHelper.PreloadEnd
{
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
    IlivePluginDownloadManager.a().c();
  }
  
  private void initData()
  {
    ElapseStat.a("IliveLaunch initData");
    if (getActivity() == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = getActivity().getIntent();
      } while (localObject1 == null);
      localObject2 = ((Intent)localObject1).getBundleExtra("KEY_EXTRAS");
    } while (localObject2 == null);
    long l = ((Bundle)localObject2).getLong("start_time", 0L);
    int i;
    if (l > 0L)
    {
      localObject1 = ((Bundle)localObject2).getString("source");
      i = ((Bundle)localObject2).getInt("page_type", 0);
      if (i != 1) {
        break label138;
      }
      TimeMonitorManager.a().b("ANCHOR_ENTER_ROOM");
    }
    for (;;)
    {
      l = System.currentTimeMillis() - l;
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("source", localObject1);
      ((HashMap)localObject2).put("process_start_time", String.valueOf(l));
      VasStatisticCollector.a("launcher", (Map)localObject2, l);
      ElapseStat.b("IliveLaunch initData");
      return;
      label138:
      if (i == 3) {
        TimeMonitorManager.a().b("WATCH_ENTER_ROOM");
      }
    }
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
    this.mIsSoLoadSuccess = QQVideoPlaySDKManager.b();
    if (!this.mIsSoLoadSuccess)
    {
      QQVideoPlaySDKManager.a();
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
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.runOnUiThread(paramRunnable);
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
    if (!IliveEntranceUtil.b()) {
      ThreadManagerV2.getUIHandlerV2().post(new IliveLaunchFragment.1());
    }
    Intent localIntent;
    do
    {
      return;
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
    } while (!IliveEntranceUtil.a(localIntent.getBooleanExtra("KEY_IS_START_LIVE", false)));
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
    int i = 0;
    ElapseStat.a("IliveLaunch doLoading");
    if (paramBoolean) {
      startPreloadRecord();
    }
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      i = localBundle.getInt("source", 0);
    }
    IlivePluginManager.getInstance().refreshToken(i);
    IlivePreloadHelper.b = true;
    initVideoSDK();
    IlivePluginManager.getInstance().setIlivePluginCallback(this);
    QLog.i("IliveLaunchActivity", 1, "doLoading isPreload = " + paramBoolean + " sPreload = " + IlivePreloadHelper.a);
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
      QLog.e("IliveLaunchActivity", 1, "start enterPlugin error , isLoginSuccess = " + this.mIsPluginFileExist + " isSoLoadSucess = " + this.mIsSoLoadSuccess);
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
    paramContext = "com.tencent.ilivesdk.demo.LauncherActivity";
    if (IlivePreloadHelper.a)
    {
      QLog.i("IliveLaunchActivity", 1, "preload shadow");
      paramContext = "preload";
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
    paramLayoutInflater = null;
    QLog.e("IliveLaunchActivity", 1, "onCreateView");
    ElapseStat.a("IliveLaunch totalLaunch");
    paramViewGroup = getActivity();
    if (paramViewGroup == null) {}
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
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
        doLoading(false, getActivity());
        ElapseStat.b("IliveLaunchActivity");
        paramLayoutInflater = this.mParentLayout;
      }
    }
  }
  
  public void onDestroyView()
  {
    TimeMonitorConfig.a = false;
    IlivePluginDownloadManager.a().a(null);
    IlivePluginDownloadManager.a().a();
    IlivePluginManager.getInstance().onDestory();
    if (this.mIliveShareHelper != null) {
      this.mIliveShareHelper.onDestroy();
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
    paramString.put("errorCode", paramInt + str);
    TimeMonitorManager.a().a("PLUGIN_DOWNLOAD").a("plugin_download_result", paramString);
    QLog.e("IliveLaunchActivity", 1, "onFail code = " + paramInt + " msg = " + str);
    runOnUiThread(new IliveLaunchFragment.10(this, paramInt, str));
  }
  
  public void onPluginActivityCreate()
  {
    ElapseStat.b("IliveLaunch onPluginLaunch");
    QLog.e("IliveLaunchActivity", 1, "onPluginActivityCreate");
    TimeMonitorManager.a().a("PLUGIN_ENTER_TOTAL_TIME").a("ilive_plugin_launch_total_time");
    TimeMonitorConfig.b();
    ElapseStat.b("IliveLaunch totalLaunch");
    if (getActivity() != null) {
      getActivity().finish();
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
      QLog.e("IliveLaunchActivity", 1, "onPluginLoginFail code = " + paramInt + " msg = " + str);
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
    FragmentActivity localFragmentActivity = getActivity();
    QLog.e("IliveLaunchActivity", 1, "onPreloadEnd");
    if (localFragmentActivity == null) {
      return;
    }
    doLoading(false, localFragmentActivity);
  }
  
  public void onProgress(float paramFloat)
  {
    runOnUiThread(new IliveLaunchFragment.9(this, paramFloat));
  }
  
  public void onSuccess()
  {
    QLog.e("IliveLaunchActivity", 1, "shadow onSuccess sPreload = " + IlivePreloadHelper.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", "success");
    TimeMonitorManager.a().a("PLUGIN_DOWNLOAD").a("plugin_download_result", localHashMap);
    if (!IlivePluginDownloadManager.a().b())
    {
      onFail(101, "download success but local apk file is not exist");
      return;
    }
    ElapseStat.a("enterPlugin");
    this.mIsPluginFileExist = true;
    if (getActivity() != null) {
      enterPlugin(getActivity(), getActivity().getIntent());
    }
    for (;;)
    {
      ElapseStat.b("enterPlugin");
      return;
      if (IlivePreloadHelper.a) {
        enterPlugin(BaseApplicationImpl.getContext(), new Intent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment
 * JD-Core Version:    0.7.0.1
 */