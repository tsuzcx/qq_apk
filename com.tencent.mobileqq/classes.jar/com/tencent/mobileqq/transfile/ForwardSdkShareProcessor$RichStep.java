package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ForwardSdkShareProcessor$RichStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  boolean isDidRich = false;
  AtomicBoolean needRich = new AtomicBoolean(false);
  AtomicInteger retryCount = new AtomicInteger(0);
  
  ForwardSdkShareProcessor$RichStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "RichStep";
    reset();
  }
  
  private void reportAfter(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("report_type", "102");
    ((Bundle)localObject).putString("act_type", "13");
    ((Bundle)localObject).putString("intext_3", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    int i;
    if (paramInt1 != 0) {
      i = 1;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    ((Bundle)localObject).putString("intext_1", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    ((Bundle)localObject).putString("stringext_2", localStringBuilder.toString());
    ((Bundle)localObject).putString("stringext_3", "1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    ((Bundle)localObject).putString("intext_5", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    ((Bundle)localObject).putString("intext_2", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt3);
    ((Bundle)localObject).putString("intext_4", localStringBuilder.toString());
    if (paramInt1 != 0) {
      ((Bundle)localObject).putString("stringext_1", this.this$0.mTargetUrl);
    }
    ReportCenter.a().a((Bundle)localObject, "", this.this$0.app.getCurrentAccountUin(), false, this.this$0.isSdkShare());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RichStep|run|ret=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",lack=");
      ((StringBuilder)localObject).append(ForwardSdkShareProcessor.access$000(this.this$0));
      ((StringBuilder)localObject).append(",cost=");
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      if ((paramInt1 == 0) && (paramLong <= 3000L))
      {
        QLog.d("BaseTransProcessor", 2, (String)localObject);
        return;
      }
      QLog.e("BaseTransProcessor", 2, (String)localObject);
    }
  }
  
  private void reportBefore()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "53");
    localBundle.putString("intext_4", "1");
    localBundle.putString("intext_3", "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ForwardSdkShareProcessor.access$000(this.this$0));
    localBundle.putString("intext_2", localStringBuilder.toString());
    localBundle.putString("stringext_1", this.this$0.mTargetUrl);
    ReportCenter.a().a(localBundle, "", this.this$0.app.getCurrentAccountUin(), false, this.this$0.isSdkShare());
  }
  
  int doRich()
  {
    reportBefore();
    long l = System.currentTimeMillis();
    int n = ForwardSdkShareProcessor.access$000(this.this$0);
    int i = 0;
    int k = -1;
    int j = k;
    try
    {
      Object localObject2 = ShareProcessorUtil.a(this.this$0.mAppContext, this.this$0.mTargetUrl, this.this$0.app.getCurrentAccountUin());
      j = k;
      int m = ((Integer)localObject2[0]).intValue();
      if (m == 0)
      {
        j = m;
        String str1 = (String)localObject2[1];
        j = m;
        String str2 = (String)localObject2[2];
        j = m;
        localObject2 = (String)localObject2[3];
        j = m;
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool) {
          try
          {
            if (TextUtils.isEmpty(this.this$0.mShareTitle))
            {
              ForwardSdkShareProcessor.access$002(this.this$0, ForwardSdkShareProcessor.access$000(this.this$0) & 0xFFFFFFFB);
              this.this$0.mShareTitle = str1;
            }
            k = 4;
          }
          catch (Exception localException1)
          {
            i = 4;
            j = m;
            break label592;
          }
        } else {
          k = 0;
        }
        j = k;
        i = k;
        try
        {
          if (!TextUtils.isEmpty(str2))
          {
            k |= 0x2;
            j = k;
            i = k;
            if (TextUtils.isEmpty(this.this$0.mShareSummary))
            {
              i = k;
              ForwardSdkShareProcessor.access$002(this.this$0, ForwardSdkShareProcessor.access$000(this.this$0) & 0xFFFFFFFD);
              i = k;
              this.this$0.mShareSummary = str2;
              j = k;
            }
          }
          k = j;
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            j |= 0x1;
            k = j;
            i = j;
            if (TextUtils.isEmpty(this.this$0.mRemoteImgUrl))
            {
              k = j;
              i = j;
              if (TextUtils.isEmpty(this.this$0.mLocalImgUrl))
              {
                i = j;
                ForwardSdkShareProcessor.access$002(this.this$0, ForwardSdkShareProcessor.access$000(this.this$0) & 0xFFFFFFFE);
                i = j;
                this.this$0.mRemoteImgUrl = ((String)localObject2);
                k = j;
              }
            }
          }
          i = k;
          this.needRich.set(false);
          i = k;
          Object localObject1 = this.this$0.app.getMessageFacade().b(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq);
          i = k;
          if ((localObject1 instanceof MessageForStructing))
          {
            i = k;
            if ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))
            {
              i = k;
              localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
              i = k;
              if (this.this$0.mShareTitle != null)
              {
                i = k;
                MessageUtils.a(this.this$0.mShareTitle, false);
              }
              i = k;
              if (this.this$0.mShareSummary != null)
              {
                i = k;
                MessageUtils.a(this.this$0.mShareSummary, false);
              }
              i = k;
              ((AbsShareMsg)localObject1).updateTitleSummaryAndCover(this.this$0.mShareTitle, this.this$0.mShareSummary, this.this$0.mRemoteImgUrl);
              i = k;
              this.this$0.app.getMessageFacade().a(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject1).getBytes());
              i = k;
              this.this$0.sendMessageToUpdate(1002);
            }
          }
          i = k;
        }
        catch (Exception localException2)
        {
          j = m;
          break label592;
        }
      }
      j = m;
    }
    catch (Exception localException3)
    {
      i = 0;
      label592:
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 4, localException3, new Object[0]);
      }
    }
    reportAfter(j, System.currentTimeMillis() - l, n, i);
    return j;
  }
  
  protected boolean isFinished()
  {
    return (!this.needRich.get()) || (this.retryCount.get() >= 2);
  }
  
  protected void process()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RichStep|process|neeRich=");
    localStringBuilder.append(this.needRich);
    localStringBuilder.append(",lack=");
    localStringBuilder.append(ForwardSdkShareProcessor.access$000(this.this$0));
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (this.needRich.get())
    {
      this.retryCount.set(0);
      ThreadManager.excute(new ForwardSdkShareProcessor.RichStep.1(this), 128, null, true);
      return;
    }
    doNextStep();
  }
  
  void reset()
  {
    this.retryCount.set(0);
    this.needRich.set(false);
    ForwardSdkShareProcessor localForwardSdkShareProcessor;
    if ((TextUtils.isEmpty(this.this$0.mRemoteImgUrl)) && (TextUtils.isEmpty(this.this$0.mLocalImgUrl)))
    {
      localForwardSdkShareProcessor = this.this$0;
      ForwardSdkShareProcessor.access$002(localForwardSdkShareProcessor, ForwardSdkShareProcessor.access$000(localForwardSdkShareProcessor) | 0x1);
    }
    if (TextUtils.isEmpty(this.this$0.mShareSummary))
    {
      localForwardSdkShareProcessor = this.this$0;
      ForwardSdkShareProcessor.access$002(localForwardSdkShareProcessor, ForwardSdkShareProcessor.access$000(localForwardSdkShareProcessor) | 0x2);
    }
    if (TextUtils.isEmpty(this.this$0.mShareTitle))
    {
      localForwardSdkShareProcessor = this.this$0;
      ForwardSdkShareProcessor.access$002(localForwardSdkShareProcessor, ForwardSdkShareProcessor.access$000(localForwardSdkShareProcessor) | 0x4);
    }
    if (ForwardSdkShareProcessor.access$000(this.this$0) > 0) {
      this.needRich.set(true);
    }
    if (this.this$0.isSdkShare()) {
      this.needRich.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.RichStep
 * JD-Core Version:    0.7.0.1
 */