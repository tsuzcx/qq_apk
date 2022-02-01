package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ForwardSdkShareProcessor$UrlExchangeStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private AtomicInteger retCode = new AtomicInteger(-1);
  private AtomicInteger retryCount = new AtomicInteger(0);
  
  ForwardSdkShareProcessor$UrlExchangeStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "UrlExchangeStep";
  }
  
  protected Runnable buildJob()
  {
    return new ForwardSdkShareProcessor.UrlExchangeStep.1(this);
  }
  
  protected boolean isFinished()
  {
    return (this.this$0.mIsAllUrlShort.get()) || (this.retCode.get() != -1) || (this.retryCount.get() >= 2);
  }
  
  protected void process()
  {
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    if (this.this$0.isSdkShare())
    {
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ServerShareOpen, skip UrlExchangeStep");
      this.this$0.mIsAllUrlShort.set(true);
      doNextStep();
      return;
    }
    if ((!TextUtils.isEmpty(this.this$0.mTargetUrl)) && (this.this$0.mTargetUrl.length() > 150)) {
      this.this$0.mUrlMap.put("targetUrl", this.this$0.mTargetUrl);
    }
    if (!TextUtils.isEmpty(this.this$0.mAppInfo.sourceUrl)) {
      this.this$0.mUrlMap.put("sourceUrl", this.this$0.mAppInfo.sourceUrl);
    }
    if (!TextUtils.isEmpty(this.this$0.mAppInfo.sourceIconSmall)) {
      this.this$0.mUrlMap.put("sourceIcon", this.this$0.mAppInfo.sourceIconSmall);
    }
    if ((this.this$0.mServiceType == 2) && (HttpUtil.isValidUrl(this.this$0.mAudioUrl))) {
      this.this$0.mUrlMap.put("audioUrl", this.this$0.mAudioUrl);
    }
    if (TextUtils.isEmpty(this.this$0.mRemoteImgUrl))
    {
      localObject = this.this$0;
      ((ForwardSdkShareProcessor)localObject).mRemoteImgUrl = ((ForwardSdkShareProcessor)localObject).mAppInfo.sourceIconBig;
      ForwardSdkShareProcessor.access$900(this.this$0).set(false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UrlExchangeStep|use app icon:");
      ((StringBuilder)localObject).append(this.this$0.mRemoteImgUrl);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject).toString());
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (TextUtils.isEmpty(this.this$0.mRemoteImgUrl)) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      localBundle.putString("intext_1", (String)localObject);
      localObject = ReportCenter.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ForwardSdkShareProcessor.access$400(this.this$0));
      ((ReportCenter)localObject).a(localBundle, localStringBuilder.toString(), this.this$0.app.getCurrentUin(), false, this.this$0.isSdkShare());
    }
    if ((!ForwardSdkShareProcessor.access$900(this.this$0).get()) && (HttpUtil.isValidUrl(this.this$0.mRemoteImgUrl))) {
      this.this$0.mUrlMap.put("imageUrl", this.this$0.mRemoteImgUrl);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("UrlExchangeStep|process|url=");
    ((StringBuilder)localObject).append(this.this$0.mUrlMap.toString());
    qlog(((StringBuilder)localObject).toString());
    if (this.this$0.mUrlMap.isEmpty())
    {
      this.this$0.mIsAllUrlShort.set(true);
      doNextStep();
      return;
    }
    ThreadManager.excute(buildJob(), 128, null, true);
  }
  
  protected void qlog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep
 * JD-Core Version:    0.7.0.1
 */