package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import bjgx;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
    Bundle localBundle;
    if (TextUtils.isEmpty(this.this$0.mRemoteImgUrl))
    {
      this.this$0.mRemoteImgUrl = this.this$0.mAppInfo.sourceIconBig;
      ForwardSdkShareProcessor.access$900(this.this$0).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + this.this$0.mRemoteImgUrl);
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(this.this$0.mRemoteImgUrl)) {
        break label496;
      }
    }
    label496:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      bjgx.a().a(localBundle, "" + ForwardSdkShareProcessor.access$400(this.this$0), this.this$0.app.getCurrentUin(), false, this.this$0.isSdkShare());
      if ((!ForwardSdkShareProcessor.access$900(this.this$0).get()) && (HttpUtil.isValidUrl(this.this$0.mRemoteImgUrl))) {
        this.this$0.mUrlMap.put("imageUrl", this.this$0.mRemoteImgUrl);
      }
      qlog("UrlExchangeStep|process|url=" + this.this$0.mUrlMap.toString());
      if (!this.this$0.mUrlMap.isEmpty()) {
        break;
      }
      this.this$0.mIsAllUrlShort.set(true);
      doNextStep();
      return;
    }
    ThreadManager.post(buildJob(), 8, null, true);
  }
  
  protected void qlog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep
 * JD-Core Version:    0.7.0.1
 */