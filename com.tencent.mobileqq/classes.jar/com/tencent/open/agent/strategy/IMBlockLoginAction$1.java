package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.open.BaseOpenSdkQIPCClient;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import mqq.observer.SSOAccountObserver;

class IMBlockLoginAction$1
  extends SSOAccountObserver
{
  IMBlockLoginAction$1(IMBlockLoginAction paramIMBlockLoginAction, boolean paramBoolean, AbstractOpenSdkAppInterface paramAbstractOpenSdkAppInterface, Activity paramActivity) {}
  
  private void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_sso_ret", paramInt);
    localBundle.putString("uin", paramString);
    localBundle.putBoolean("is_from_login", this.a);
    BaseOpenSdkQIPCClient.a(localBundle);
    this.b.a(2, null);
    IMBlockLoginAction.a(this.d, this.c);
  }
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    SSOLog.a("IMBlockLoginAction", new Object[] { "-->onFailed--", AuthorityUtil.a(paramString) });
    a(paramString, paramInt2);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    SSOLog.a("IMBlockLoginAction", new Object[] { "-->onLoginSuccess--", AuthorityUtil.a(paramString) });
    OpenProxy.a().a(paramString);
    BaseOpenSdkQIPCClient.a(paramString);
    a(paramString, 0);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    SSOLog.a("IMBlockLoginAction", new Object[] { "-->onUserCancel--", AuthorityUtil.a(paramString) });
    a(paramString, 2006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.IMBlockLoginAction.1
 * JD-Core Version:    0.7.0.1
 */