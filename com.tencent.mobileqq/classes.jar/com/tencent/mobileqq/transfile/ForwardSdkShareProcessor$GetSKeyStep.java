package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.open.agent.util.AuthorityUtil;
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
    Object localObject = this.this$0.app.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetSKeyStep|process|account=");
    localStringBuilder.append(AuthorityUtil.a((String)localObject));
    localStringBuilder.append(",refresh=");
    localStringBuilder.append(ForwardSdkShareProcessor.access$100(this.this$0));
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (!this.this$0.isAppValid())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("illegal app = ");
      ((StringBuilder)localObject).append(this.this$0.app);
      QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
      this.this$0.mProcessorReport.setError(9366, "illegal app", null, null);
      doError();
      return;
    }
    if (!ForwardSdkShareProcessor.access$100(this.this$0))
    {
      localObject = ((TicketManager)this.this$0.app.getManager(2)).getSkey((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = 0;
        ForwardSdkShareProcessor.access$202(this.this$0, (String)localObject);
        this.isSKeyReady.set(true);
        doNextStep();
        break label214;
      }
    }
    int i = 1;
    label214:
    if (i != 0)
    {
      if (this.this$0.isSdkShare()) {
        ForwardStatisticsReporter.a("KEY_SSO_GET_TICKET_NO_PASSWD");
      }
      this.this$0.app.ssoGetTicketNoPasswd(this.this$0.app.getCurrentAccountUin(), 4096, this.mAccountObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetSKeyStep
 * JD-Core Version:    0.7.0.1
 */