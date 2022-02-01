package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForwardSdkShareProcessor$SendMsgStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private boolean isFinished;
  
  ForwardSdkShareProcessor$SendMsgStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "SendMsgStep";
  }
  
  protected boolean isFinished()
  {
    return this.isFinished;
  }
  
  protected void process()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|process");
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (!NetworkUtil.a(this.this$0.mAppContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgStep|no network");
      if ((ForwardSdkShareProcessor.access$000(this.this$0) > 0) || (!ForwardSdkShareProcessor.access$1000(this.this$0).get()) || (!this.this$0.mIsAllUrlShort.get()) || (this.this$0.mAppInfo.status != 1))
      {
        this.this$0.setError(9004, "no network");
        doError();
        return;
      }
    }
    Object localObject = this.this$0.app.getMessageFacade().b(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq);
    if (localObject != null) {
      this.this$0.app.getMessageFacade().b((MessageRecord)localObject, null);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "14");
    ((Bundle)localObject).putString("intext_2", "" + ForwardSdkShareProcessor.access$000(this.this$0));
    ((Bundle)localObject).putString("stringext_1", "" + this.this$0.mTargetUrl);
    ((Bundle)localObject).putString("intext_3", "0");
    ReportCenter.a().a((Bundle)localObject, "", this.this$0.app.getCurrentAccountUin(), false, this.this$0.isSdkShare());
    this.isFinished = true;
    doNextStep();
    this.this$0.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.SendMsgStep
 * JD-Core Version:    0.7.0.1
 */