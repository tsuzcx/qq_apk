package com.tencent.open;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.util.AuthModelUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqconnect.wtlogin.Login;
import eipc.EIPCClient;
import eipc.EIPCResult;
import mqq.app.MobileQQ;
import mqq.manager.VerifyCodeManager;
import mqq.os.MqqHandler;

public class OpenSdkQIPCClient
  extends BaseOpenSdkQIPCClient
{
  private static boolean a = false;
  private BroadcastReceiver b = new OpenSdkQIPCClient.3(this);
  
  public OpenSdkQIPCClient(String paramString)
  {
    super(paramString);
  }
  
  private void a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      SSOLog.b("OpenSdkQIPCClient", new Object[] { "doWtLogin params==null" });
      a("", paramInt, 1005, -102);
      return;
    }
    String str1 = paramBundle.getString("uin");
    String str2 = paramBundle.getString("passwd");
    String str3 = paramBundle.getString("appid");
    if (TextUtils.isEmpty(str2)) {
      paramBundle = "empty";
    } else {
      paramBundle = "****";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWtLogin uin=");
    localStringBuilder.append(AuthorityUtil.a(str1));
    localStringBuilder.append(", maskPasswd=");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(", appId=");
    localStringBuilder.append(str3);
    SSOLog.a("OpenSdkQIPCClient", new Object[] { localStringBuilder.toString() });
    if (OpenSdkIFrameProcessor.a()) {
      MobileQQ.getContext().registerReceiver(this.b, new IntentFilter("mqq.opensdk.intent.action.PUZZLEVERIFYCODE"));
    }
    AuthModelUtil.a(str3, str1, str2, new OpenSdkQIPCClient.2(this, paramInt));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("backToMainProcess uin=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    ((StringBuilder)localObject).append(", ssoResult=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", epicCode=");
    ((StringBuilder)localObject).append(paramInt3);
    SSOLog.a("OpenSdkQIPCClient", new Object[] { ((StringBuilder)localObject).toString() });
    try
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("uin", paramString);
      ((Bundle)localObject).putInt("key_sso_ret", paramInt2);
      callbackResult(paramInt1, EIPCResult.createResult(paramInt3, (Bundle)localObject));
      if (OpenSdkIFrameProcessor.a())
      {
        MobileQQ.getContext().unregisterReceiver(this.b);
        return;
      }
    }
    catch (Exception paramString)
    {
      SSOLog.c("OpenSdkQIPCClient", "Exception", paramString);
    }
  }
  
  public static OpenSdkQIPCClient b()
  {
    return OpenSdkQIPCClient.Holder.a;
  }
  
  private void b(Bundle paramBundle)
  {
    SSOLog.a("OpenSdkQIPCClient", new Object[] { "submitPuzzleVerifyCode" });
    if (paramBundle == null)
    {
      SSOLog.b("OpenSdkQIPCClient", new Object[] { "submitPuzzleVerifyCode params==null" });
      return;
    }
    int i = paramBundle.getInt("seq");
    paramBundle = paramBundle.getString("ticket");
    Object localObject = (AppInterface)BaseApplicationImpl.sApplication.peekAppRuntime();
    VerifyCodeManager localVerifyCodeManager = (VerifyCodeManager)((AppInterface)localObject).getManager(6);
    if (localVerifyCodeManager == null)
    {
      SSOLog.b("OpenSdkQIPCClient", new Object[] { "submitPuzzleVerifyCode verifyCodeManager==null" });
      return;
    }
    localObject = ((AppInterface)localObject).getHandler(Login.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(2002);
    }
    localVerifyCodeManager.submitPuzzleVerifyCodeTicket(i, paramBundle);
  }
  
  public static void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("registerModule isRegisterModule=");
    localStringBuilder.append(a);
    SSOLog.b("OpenSdkQIPCClient", localStringBuilder.toString());
    if (!a)
    {
      QIPCClientHelper.getInstance().getClient().registerModule(b());
      QIPCClientHelper.getInstance().getClient().connect(new OpenSdkQIPCClient.1());
      a = true;
    }
  }
  
  public static void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterModule isRegisterModule=");
    localStringBuilder.append(a);
    SSOLog.a("OpenSdkQIPCClient", new Object[] { localStringBuilder.toString() });
    if (a)
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(b());
      a = false;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCall action=");
    localStringBuilder.append(paramString);
    SSOLog.a("OpenSdkQIPCClient", new Object[] { localStringBuilder.toString() });
    if ("action_to_wt_login".equals(paramString)) {
      a(paramBundle, paramInt);
    } else if ("action_submit_puzzle_verify_code".equals(paramString)) {
      b(paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.OpenSdkQIPCClient
 * JD-Core Version:    0.7.0.1
 */