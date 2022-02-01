package com.tencent.open.agent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.open.OpenSdkQIPCClient;
import com.tencent.open.agent.strategy.ActionFactory;
import com.tencent.open.agent.strategy.IAgentAction;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@RoutePage(desc="互联Agent代理页面", path="/base/connectAgent")
public class AgentActivity
  extends BaseActivity
{
  private static final String TAG = "AgentActivity";
  private boolean mIsBackToAPP = false;
  private boolean mOnResumeIsInited = false;
  private QQProgressDialog mProgress;
  private int mWaitingCallbackCount;
  
  private boolean handleAction()
  {
    waitAppRuntime().a(new AgentActivity.2(this));
    String str = AuthParamUtil.b(getIntent(), "key_action");
    SSOLog.a("AgentActivity", new Object[] { "handleAction action=", str });
    ActionFactory.a(str).a(this);
    return true;
  }
  
  private void onQrCodeLoginSuccess(int paramInt, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("param_qr_code_url");
    paramIntent.putExtra("key_error_code", 0);
    paramIntent.putExtra("key_response", AuthorityUtil.c(str).toString());
    super.setResult(paramInt, paramIntent);
    super.finish();
    this.mIsBackToAPP = true;
  }
  
  private OpenSDKAppInterface waitAppRuntime()
  {
    OpenSDKAppInterface localOpenSDKAppInterface = (OpenSDKAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("waitAppRuntime app=");
    localStringBuilder.append(localOpenSDKAppInterface.hashCode());
    SSOLog.a("AgentActivity", new Object[] { localStringBuilder.toString() });
    return localOpenSDKAppInterface;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    SSOLog.a("AgentActivity", new Object[] { "onCreate" });
    super.doOnCreate(paramBundle);
    OpenSdkQIPCClient.c();
    ForwardStatisticsReporter.b();
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_1_TOTAL");
    ForwardStatisticsReporter.a("KEY_AUTHORITY_TOTAL");
    this.mProgress = AuthUIUtil.a(this, this.mProgress, 2131627753);
    this.mProgress.a(new AgentActivity.1(this));
    if ((super.getIntent() != null) && (paramBundle == null)) {
      return handleAction();
    }
    SSOLog.a("AgentActivity", new Object[] { "onCreate super.getIntent() == null || savedInstanceState != null" });
    AuthReporter.a(1, "LOGIN_CHECK_AGENT", null, null, 0, "AgentActivity getIntent is null");
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    boolean bool = this.mOnResumeIsInited;
    int i = this.mWaitingCallbackCount;
    Boolean localBoolean;
    if (getAppInterface() == null) {
      localBoolean = null;
    } else {
      localBoolean = Boolean.valueOf(getAppInterface().isLogin());
    }
    SSOLog.a("AgentActivity", new Object[] { "onResume mOnResumeIsInited=", Boolean.valueOf(bool), ", mWaitingCallbackCount=", Integer.valueOf(i), ", isLogin=", localBoolean });
    if ((this.mOnResumeIsInited) && (this.mWaitingCallbackCount == 0))
    {
      setResult(0);
      finish();
      this.mIsBackToAPP = true;
      return;
    }
    this.mOnResumeIsInited = true;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResult, requestCode: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" | resultCode: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" | data: ");
    localStringBuilder.append(paramIntent);
    SSOLog.a("AgentActivity", new Object[] { localStringBuilder.toString() });
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_is_qr_code_login", false)))
    {
      onQrCodeLoginSuccess(paramInt2, paramIntent);
      return;
    }
    super.setResult(paramInt2, paramIntent);
    super.finish();
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("moveTaskToBack", false))) {
      moveTaskToBack(true);
    }
    this.mIsBackToAPP = true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDestroy()
  {
    SSOLog.a("AgentActivity", new Object[] { "-->onDestroy" });
    super.onDestroy();
    AuthUIUtil.a(this, this.mProgress);
    waitAppRuntime().a(4, null);
    waitAppRuntime().b();
    if (this.mIsBackToAPP)
    {
      if (!GesturePWDUtils.isAppOnForeground(this)) {
        GesturePWDUtils.setAppForground(this, false);
      }
      EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_on_agent_activity_destroy", new Bundle());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDestroy] ipc result: ");
      localStringBuilder.append(localEIPCResult.code);
      SSOLog.a("AgentActivity", new Object[] { localStringBuilder.toString() });
    }
    OpenSdkQIPCClient.d();
    if (this.mIsBackToAPP)
    {
      QLog.flushLog(true);
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */