package com.tencent.mobileqq.microapp.sdk;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager;
import com.tencent.mobileqq.microapp.apkg.ApkgDebugConstants;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.FakeUrl;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class MiniAppBridgeActivity
  extends PublicBaseFragment
{
  public static final String KEY_LAUNCH_PARAM = "launch_param";
  public static final long MINIAPP_PROCESS_INIT_PRE_TIME = 5000L;
  public static final String TAG = "MiniAppBridgeActivity";
  private MiniAppConfig fromAppConfig;
  private LaunchParam launchParam;
  private QQProgressDialog mDialog;
  private FakeUrl mFakeUrl;
  
  private void handleAbnormal(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAbnormal:");
      localStringBuilder.append(paramString);
      QLog.d("MiniAppBridgeActivity", 2, localStringBuilder.toString());
    }
    if ((getActivity() != null) && (!getActivity().isFinishing()))
    {
      QQToast.makeText(getActivity(), "网络异常，请稍后重试", 0).show();
      getActivity().finish();
    }
  }
  
  private boolean isFromDebugConfig(LaunchParam paramLaunchParam)
  {
    paramLaunchParam = ApkgDebugConstants.getMiniAppConfig(paramLaunchParam.miniAppId, getActivity().app);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isFromDebugConfig :");
      localStringBuilder.append(paramLaunchParam);
      QLog.d("MiniAppBridgeActivity", 2, localStringBuilder.toString());
    }
    if (paramLaunchParam != null)
    {
      ThreadManager.getUIHandler().postDelayed(new MiniAppBridgeActivity.4(this, paramLaunchParam), 100L);
      return true;
    }
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new View(getActivity());
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mDialog.dismiss();
  }
  
  public void onResume()
  {
    super.onResume();
    this.launchParam = ((LaunchParam)getArguments().getSerializable("launch_param"));
    if (this.launchParam == null)
    {
      handleAbnormal("launchParam is null");
      return;
    }
    Object localObject = ManagerProxy.getApkgConfigManager(getActivity().app);
    if (this.launchParam.scene == 1214)
    {
      this.fromAppConfig = ((ApkgConfigManager)localObject).getConfig(this.launchParam.fromMiniAppId);
      if (this.fromAppConfig == null)
      {
        handleAbnormal("fromAppConfig is null");
        return;
      }
    }
    if (isFromDebugConfig(this.launchParam)) {
      return;
    }
    long l = ProcessInfoUtil.b("com.tencent.mobileqq:miniapp");
    WeakReference localWeakReference = new WeakReference(getActivity());
    MiniAppConfig localMiniAppConfig = ((ApkgConfigManager)localObject).getConfig(this.launchParam);
    if ((localMiniAppConfig != null) && (localMiniAppConfig.config != null) && (new File(g.a(localMiniAppConfig.config)).exists()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("miniConfig config exist and valid:");
        ((StringBuilder)localObject).append(localMiniAppConfig);
        QLog.d("MiniAppBridgeActivity", 2, ((StringBuilder)localObject).toString());
      }
      if ((this.launchParam.scene == 1214) && (!ApkgConfigManager.isCanNavigate(localMiniAppConfig, this.fromAppConfig)))
      {
        handleAbnormal("not support navigate 2");
        return;
      }
      if (l <= 5000L) {}
    }
    try
    {
      MiniAppController.startApp(getActivity(), wrapConfig(localMiniAppConfig), null);
      getActivity().finish();
      if (!QLog.isColorLevel()) {
        break label351;
      }
      QLog.d("MiniAppBridgeActivity", 2, "miniapp process exist, launch directly");
      return;
    }
    catch (Throwable localThrowable)
    {
      label286:
      break label286;
    }
    handleAbnormal("start miniapp error");
    return;
    ThreadManager.getUIHandler().postDelayed(new MiniAppBridgeActivity.3(this, localMiniAppConfig, localWeakReference), 100L);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppBridgeActivity", 2, "miniConfig config is null or folder not exist");
    }
    ((ApkgConfigManager)localObject).getNewestConfig(this.launchParam, 0, new MiniAppBridgeActivity.2(this, localWeakReference, l));
    label351:
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mDialog = new QQProgressDialog(getActivity());
    this.mDialog.a("正在加载中...");
    this.mDialog.setOnDismissListener(new MiniAppBridgeActivity.1(this));
    this.mDialog.show();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppBridgeActivity", 2, "MiniAppBridgeActivity 00");
    }
  }
  
  public MiniAppConfig wrapConfig(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig != null)
    {
      if (TextUtils.isEmpty(this.launchParam.entryPath)) {
        this.launchParam.entryPath = null;
      }
      paramMiniAppConfig.launchParam = this.launchParam;
      return paramMiniAppConfig;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity
 * JD-Core Version:    0.7.0.1
 */