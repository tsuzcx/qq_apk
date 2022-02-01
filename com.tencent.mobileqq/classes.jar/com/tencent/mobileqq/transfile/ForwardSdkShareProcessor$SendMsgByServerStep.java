package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import ayeo;
import ayep;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForwardSdkShareProcessor$SendMsgByServerStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private boolean isFinished;
  
  ForwardSdkShareProcessor$SendMsgByServerStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "SendMsgByServerStep";
  }
  
  protected boolean isFinished()
  {
    return this.isFinished;
  }
  
  protected void process()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|process");
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.this$0.mAppContext))
    {
      QLog.w("Q.share.ForwardSdkShareProcessor", 1, "SendMsgByServerStep|no network");
      if ((ForwardSdkShareProcessor.access$000(this.this$0) > 0) || (!ForwardSdkShareProcessor.access$1000(this.this$0).get()) || (!this.this$0.mIsAllUrlShort.get()) || (this.this$0.mAppInfo.status != 1))
      {
        this.this$0.setError(9004, "no network");
        doError();
        return;
      }
    }
    if ((this.this$0.mUiRequest != null) && (this.this$0.mUiRequest.mUpCallBack != null))
    {
      ayep localayep = new ayep();
      String str2 = (String)this.this$0.mUrlMap.get("audioUrl");
      String str3 = this.this$0.mRemoteImgUrl;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.this$0.mAudioUrl;
      }
      localayep.jdField_a_of_type_JavaLangObject = new String[] { str3, str1 };
      localayep.jdField_a_of_type_Int = 0;
      this.this$0.mUiRequest.mUpCallBack.onSend(localayep);
    }
    this.isFinished = true;
    doNextStep();
    this.this$0.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.SendMsgByServerStep
 * JD-Core Version:    0.7.0.1
 */