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
import bapt;
import bhpu;
import bluh;
import blui;
import bluk;
import blul;
import bluo;
import blvi;
import blvj;
import blvk;
import blvl;
import blvm;
import blvn;
import blvo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.ilive.plugin.IlivePluginCallback;
import cooperation.ilive.plugin.IlivePluginManager;
import cooperation.ilive.share.IliveShareHelper;
import eipc.EIPCClient;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class IliveLaunchFragment
  extends PublicBaseFragment
  implements bluh, blvo, IlivePluginCallback
{
  private static final String TAG = "IliveLaunchActivity";
  private static EnterCallback mEnterCallback = new bluk();
  private static long mStartTimeMillis;
  private boolean isPreloadModel;
  private IliveShareHelper mIliveShareHelper;
  private volatile boolean mIsPluginFileExist;
  private volatile boolean mIsSoLoadSuccess;
  private ProgressBar mLoadingProgressBar;
  private TextView mLoadingText;
  private FrameLayout mParentLayout;
  
  private void cancelPreDownload()
  {
    QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "action_cancel_pre_load", null, null);
  }
  
  private void cancelPreload()
  {
    if (blvn.a)
    {
      QLog.i("IliveLaunchActivity", 1, "preload cancle", new Throwable());
      blvn.a = false;
      blvn.a();
    }
  }
  
  private void downloadPlugin()
  {
    blvk.a().b("PLUGIN_DOWNLOAD");
    cancelPreDownload();
    blul.a().c();
  }
  
  private void initData()
  {
    blvl.a("IliveLaunch initData");
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
      blvk.a().b("ANCHOR_ENTER_ROOM");
    }
    for (;;)
    {
      l = System.currentTimeMillis() - l;
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("source", localObject1);
      ((HashMap)localObject2).put("process_start_time", String.valueOf(l));
      bhpu.a("launcher", (Map)localObject2, l);
      blvl.b("IliveLaunch initData");
      return;
      label138:
      if (i == 3) {
        blvk.a().b("WATCH_ENTER_ROOM");
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
    blvl.a("IliveLaunch initVideoSDK");
    long l = System.currentTimeMillis();
    this.mIsSoLoadSuccess = bapt.b();
    if (!this.mIsSoLoadSuccess)
    {
      bapt.a();
      LoadSoUtil.loadSo(new blui(this, l));
    }
  }
  
  private static void preloadEnd()
  {
    QLog.i("IliveLaunchActivity", 1, "preload end");
    blvn.a = false;
    blvn.a();
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
    if (!blvm.b()) {
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
    } while (!blvm.a(localIntent.getBooleanExtra("KEY_IS_START_LIVE", false)));
    if (!blvm.a(500))
    {
      QLog.e("IliveLaunchActivity", 1, "startSelf isClickEnable = false");
      return;
    }
    localIntent.setClass(paramContext, PublicTransFragmentActivityForTool.class);
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
    blvl.a("IliveLaunch doLoading");
    if (paramBoolean) {
      startPreloadRecord();
    }
    IliveAppInterface.a();
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      i = localBundle.getInt("source", 0);
    }
    IlivePluginManager.getInstance().refreshToken(i);
    blvn.b = true;
    initVideoSDK();
    IlivePluginManager.getInstance().setIlivePluginCallback(this);
    QLog.i("IliveLaunchActivity", 1, "doLoading isPreload = " + paramBoolean + " sPreload = " + blvn.a);
    if ((!paramBoolean) && (blvn.a))
    {
      QLog.i("IliveLaunchActivity", 1, "wait fo preload");
      blvn.a(this);
      showLoadingUI();
      return;
    }
    ThreadManagerV2.executeOnSubThread(new IliveLaunchFragment.3(this, paramContext, paramBoolean));
    blvl.b("IliveLaunch doLoading");
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
    blvk.a().b("PLUGIN_LOAD");
    paramContext = "com.tencent.ilivesdk.demo.LauncherActivity";
    if (blvn.a)
    {
      QLog.i("IliveLaunchActivity", 1, "preload shadow");
      paramContext = "preload";
    }
    bluo.a(BaseApplicationImpl.getContext(), paramIntent, paramContext, mEnterCallback);
  }
  
  protected void finalize()
  {
    if (this.isPreloadModel)
    {
      blvn.a = false;
      QLog.e("IliveLaunchActivity", 1, "finalize and reset  sIsPrelad");
    }
    super.finalize();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = null;
    QLog.e("IliveLaunchActivity", 1, "onCreateView");
    blvl.a("IliveLaunch totalLaunch");
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
      blvl.a("IliveLaunchActivity");
      if (paramViewGroup.getIntent().getIntExtra("share", 0) == 1)
      {
        this.mIliveShareHelper = new IliveShareHelper(paramViewGroup, paramViewGroup.getIntent().getExtras());
        this.mIliveShareHelper.showActionSheet();
      }
      else
      {
        blvk.a().b("PLUGIN_ENTER_TOTAL_TIME");
        blvi.a();
        this.mParentLayout = new FrameLayout(paramViewGroup);
        doLoading(false, getActivity());
        blvl.b("IliveLaunchActivity");
        paramLayoutInflater = this.mParentLayout;
      }
    }
  }
  
  public void onDestroyView()
  {
    blvi.a = false;
    blul.a().a(null);
    blul.a().a();
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
    blvk.a().a("PLUGIN_DOWNLOAD").a("plugin_download_result", paramString);
    QLog.e("IliveLaunchActivity", 1, "onFail code = " + paramInt + " msg = " + str);
    runOnUiThread(new IliveLaunchFragment.10(this, paramInt, str));
  }
  
  public void onPluginActivityCreate()
  {
    blvl.b("IliveLaunch onPluginLaunch");
    QLog.e("IliveLaunchActivity", 1, "onPluginActivityCreate");
    blvk.a().a("PLUGIN_ENTER_TOTAL_TIME").a("ilive_plugin_launch_total_time");
    blvi.b();
    blvl.b("IliveLaunch totalLaunch");
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
    blvl.a("IliveLaunch onPluginLaunch");
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
    QLog.e("IliveLaunchActivity", 1, "shadow onSuccess sPreload = " + blvn.a);
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", "success");
    blvk.a().a("PLUGIN_DOWNLOAD").a("plugin_download_result", localHashMap);
    if (!blul.a().b())
    {
      onFail(101, "download success but local apk file is not exist");
      return;
    }
    blvl.a("enterPlugin");
    this.mIsPluginFileExist = true;
    if (getActivity() != null) {
      enterPlugin(getActivity(), getActivity().getIntent());
    }
    for (;;)
    {
      blvl.b("enterPlugin");
      return;
      if (blvn.a) {
        enterPlugin(BaseApplicationImpl.getContext(), new Intent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IliveLaunchFragment
 * JD-Core Version:    0.7.0.1
 */