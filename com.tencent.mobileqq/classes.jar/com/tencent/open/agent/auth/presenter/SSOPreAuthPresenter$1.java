package com.tencent.open.agent.auth.presenter;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;

class SSOPreAuthPresenter$1
  implements OpensdkBusinessObserver
{
  SSOPreAuthPresenter$1(SSOPreAuthPresenter paramSSOPreAuthPresenter, String paramString1, AccountInfo paramAccountInfo, boolean paramBoolean, SSOPreAuthPresenter.PreAuthCallback paramPreAuthCallback, int paramInt, String paramString2, String paramString3, String paramString4, Bundle paramBundle) {}
  
  private void a(int paramInt, String paramString)
  {
    SSOLog.a("SSOPreAuthPresenter", new Object[] { "preAuth onFail mPreAuthRetryCount=", Integer.valueOf(SSOPreAuthPresenter.a(this.j)), ", errorCode=", Integer.valueOf(paramInt) });
    if ((SSOPreAuthPresenter.a(this.j) < this.e) && (paramInt != 110537) && (paramInt != 110509))
    {
      SSOPreAuthPresenter.b(this.j);
      this.j.a(this.f, this.g, this.h, this.i, this.b, this.d, this.e);
      return;
    }
    SSOPreAuthPresenter.a(this.j, 0);
    this.d.a(paramInt, paramString);
  }
  
  private void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    try
    {
      paramArrayOfByte = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte.ret.has()) && (paramArrayOfByte.ret.get() == 0))
      {
        SSOLog.a("SSOPreAuthPresenter", new Object[] { "preAuth mergeFrom success" });
        AuthReporter.a("KEY_PRE_AUTH", this.b, true);
        SSOPreAuthPresenter.a(this.j, paramArrayOfByte);
        SSOPreAuthPresenter.a(this.j, 0);
        this.d.a();
        return;
      }
      SSOLog.a("SSOPreAuthPresenter", new Object[] { "preAuth mergeFrom fail ret=", Integer.valueOf(paramArrayOfByte.ret.get()), ", msg=", paramArrayOfByte.msg.get() });
      AuthReporter.a("KEY_PRE_AUTH", this.b, false);
      a(paramArrayOfByte.ret.get(), paramArrayOfByte.msg.get());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      SSOLog.c("SSOPreAuthPresenter", "Exception", paramArrayOfByte);
      AuthReporter.a("KEY_PRE_AUTH", this.b, false);
      a(paramBundle.getInt("code", -1), "");
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    SSOLog.a("SSOPreAuthPresenter", new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(SSOPreAuthPresenter.a(this.j)), ", cmd=", this.a });
    if (!paramBoolean)
    {
      AuthReporter.a("KEY_PRE_AUTH", this.b, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = AuthorityUtil.a(paramBundle, this.c, this.b);
    if (arrayOfByte == null)
    {
      AuthReporter.a("KEY_PRE_AUTH", this.b, false);
      a(paramBundle.getInt("code", -1), "");
      return;
    }
    a(paramBundle, arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SSOPreAuthPresenter.1
 * JD-Core Version:    0.7.0.1
 */