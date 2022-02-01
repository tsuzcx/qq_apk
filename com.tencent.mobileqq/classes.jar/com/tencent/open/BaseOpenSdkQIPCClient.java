package com.tencent.open;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;

public abstract class BaseOpenSdkQIPCClient
  extends QIPCModule
{
  public BaseOpenSdkQIPCClient(String paramString)
  {
    super(paramString);
  }
  
  public static void a()
  {
    SSOLog.b("BaseOpenSdkQIPCClient", "doPtloginCancel");
    QIPCClientHelper.getInstance().callServer("open_sdk_qipc_module", "action_ptlogin_cancel", new Bundle());
  }
  
  public static void a(Bundle paramBundle)
  {
    SSOLog.a("BaseOpenSdkQIPCClient", new Object[] { "onSsoLoginComplete" });
    QIPCClientHelper.getInstance().callServer("open_sdk_qipc_module", "action_on_sso_login_complete", paramBundle);
  }
  
  public static void a(String paramString)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (!(localObject instanceof AbstractOpenSdkAppInterface))
    {
      SSOLog.a("BaseOpenSdkQIPCClient", new Object[] { "clearLoginData !(app instanceof OpenSDKAppInterface)" });
      return;
    }
    AuthMemoryCache.a().a(paramString);
    boolean bool1;
    if (AuthorityUtil.a(paramString, (AppRuntime)localObject, true) != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = AuthorityUtil.a(paramString, (AppRuntime)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearLoginData hasA2=");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", hasD2=");
    localStringBuilder.append(bool2);
    SSOLog.a("BaseOpenSdkQIPCClient", new Object[] { localStringBuilder.toString() });
    if ((bool1) || (bool2))
    {
      localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
      ((WtloginManager)localObject).clearUserFastLoginData(paramString, 16L);
      ((WtloginManager)localObject).refreshMemorySig();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.BaseOpenSdkQIPCClient
 * JD-Core Version:    0.7.0.1
 */