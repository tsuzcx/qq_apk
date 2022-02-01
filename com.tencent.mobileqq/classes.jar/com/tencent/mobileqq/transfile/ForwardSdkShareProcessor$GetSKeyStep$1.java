package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import atqa;
import bhwf;
import bibo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.SSOAccountObserver;

class ForwardSdkShareProcessor$GetSKeyStep$1
  extends SSOAccountObserver
{
  ForwardSdkShareProcessor$GetSKeyStep$1(ForwardSdkShareProcessor.GetSKeyStep paramGetSKeyStep) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onFailed|account=" + paramString + ",ret=" + paramInt2);
    if (this.this$1.this$0.mForwardType == 11) {
      atqa.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.this$1.this$0.setError(9401, "get sKey failed");
    this.this$1.doError();
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.i("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onGetTicketNoPasswd|account=" + bhwf.a(paramString) + ",type=" + paramInt);
    if (this.this$1.this$0.mForwardType == 11) {
      atqa.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, true);
    }
    long l = System.currentTimeMillis();
    if (paramInt == 4096)
    {
      ForwardSdkShareProcessor.access$202(this.this$1.this$0, new String(paramArrayOfByte));
      ForwardSdkShareProcessor.GetSKeyStep.access$300(this.this$1).set(true);
      bibo.a(paramString, l);
      this.this$1.doNextStep();
      return;
    }
    this.this$1.this$0.setError(9401, "get sKey failed");
    this.this$1.doError();
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.w("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|onUserCancel|action=" + paramInt);
    if (this.this$1.this$0.mForwardType == 11) {
      atqa.a("KEY_SSO_GET_TICKET_NO_PASSWD", paramBundle, false);
    }
    this.this$1.this$0.setError(9401, "onUserCancel");
    this.this$1.doError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetSKeyStep.1
 * JD-Core Version:    0.7.0.1
 */