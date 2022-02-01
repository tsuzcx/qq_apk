package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import atqa;
import bhwf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.TicketManager;
import mqq.observer.SSOAccountObserver;

class ForwardSdkShareProcessor$GetSKeyStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private AtomicBoolean isSKeyReady = new AtomicBoolean(false);
  SSOAccountObserver mAccountObserver = new ForwardSdkShareProcessor.GetSKeyStep.1(this);
  
  ForwardSdkShareProcessor$GetSKeyStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "GetSKeyStep";
  }
  
  protected boolean isFinished()
  {
    return (this.isSKeyReady.get()) && (!TextUtils.isEmpty(ForwardSdkShareProcessor.access$200(this.this$0)));
  }
  
  protected void process()
  {
    String str = this.this$0.app.getCurrentAccountUin();
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetSKeyStep|process|account=" + bhwf.a(str) + ",refresh=" + ForwardSdkShareProcessor.access$100(this.this$0));
    if (this.isCancelled.get()) {
      doCancel();
    }
    for (;;)
    {
      return;
      if (!this.this$0.isAppValid())
      {
        QLog.d("Q.share.ForwardSdkShareProcessor", 1, "illegal app = " + this.this$0.app);
        this.this$0.setError(9366, "illegal app");
        doError();
        return;
      }
      int i;
      if (!ForwardSdkShareProcessor.access$100(this.this$0))
      {
        str = ((TicketManager)this.this$0.app.getManager(2)).getSkey(str);
        if (!TextUtils.isEmpty(str))
        {
          i = 0;
          ForwardSdkShareProcessor.access$202(this.this$0, str);
          this.isSKeyReady.set(true);
          doNextStep();
        }
      }
      while (i != 0)
      {
        if (this.this$0.mForwardType == 11) {
          atqa.a("KEY_SSO_GET_TICKET_NO_PASSWD");
        }
        this.this$0.app.ssoGetTicketNoPasswd(this.this$0.app.getCurrentAccountUin(), 4096, this.mAccountObserver);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetSKeyStep
 * JD-Core Version:    0.7.0.1
 */