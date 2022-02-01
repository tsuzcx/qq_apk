package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  ForwardSdkShareProcessor$UrlExchangeStep$1(ForwardSdkShareProcessor.UrlExchangeStep paramUrlExchangeStep) {}
  
  public void run()
  {
    Object localObject1 = this.this$1;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("UrlExchangeStep|run,retry=");
    ((StringBuilder)localObject2).append(ForwardSdkShareProcessor.UrlExchangeStep.access$1400(this.this$1));
    ((ForwardSdkShareProcessor.UrlExchangeStep)localObject1).qlog(((StringBuilder)localObject2).toString());
    if (this.this$1.isCancelled.get())
    {
      this.this$1.doCancel();
      return;
    }
    Object localObject3 = new Bundle();
    localObject2 = this.this$1.this$0.app.getCurrentUin();
    if ((!ForwardSdkShareProcessor.access$900(this.this$1.this$0).get()) && (TextUtils.isEmpty(this.this$1.this$0.mRemoteImgUrl))) {
      i = 0;
    } else {
      i = this.this$1.this$0.mRemoteImgUrl.length();
    }
    ((Bundle)localObject3).putString("report_type", "102");
    ((Bundle)localObject3).putString("act_type", "52");
    localObject1 = "0";
    ((Bundle)localObject3).putString("intext_3", "0");
    ((Bundle)localObject3).putString("stringext_1", this.this$1.this$0.mTargetUrl);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(i);
    ((Bundle)localObject3).putString("intext_4", ((StringBuilder)localObject4).toString());
    ReportCenter.a().a((Bundle)localObject3, "", (String)localObject2, false, this.this$1.this$0.isSdkShare());
    long l = System.currentTimeMillis();
    ForwardStatisticsReporter.a("batch_url_exchange");
    localObject4 = new Bundle();
    localObject3 = HttpUtil.batchUrlExchange(this.this$1.this$0.mAppContext, (String)localObject2, ForwardSdkShareProcessor.access$200(this.this$1.this$0), 1, this.this$1.this$0.mUrlMap, (Bundle)localObject4);
    l = System.currentTimeMillis() - l;
    boolean bool = ((Bundle)localObject4).getBoolean("isSuccess");
    int i = ((Bundle)localObject4).getInt("retcode", -1);
    ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1).set(i);
    localObject4 = new HashMap();
    ((HashMap)localObject4).put("param_ret_code", Integer.toString(i));
    ForwardStatisticsReporter.a("batch_url_exchange", (String)localObject2, (HashMap)localObject4, bool);
    localObject4 = this.this$1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlExchangeStep|run,suc=");
    localStringBuilder.append(bool);
    localStringBuilder.append(",ret=");
    localStringBuilder.append(ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1));
    localStringBuilder.append(",cost=");
    localStringBuilder.append(l);
    ((ForwardSdkShareProcessor.UrlExchangeStep)localObject4).qlog(localStringBuilder.toString());
    localObject4 = new Bundle();
    ((Bundle)localObject4).putString("report_type", "102");
    ((Bundle)localObject4).putString("act_type", "12");
    ((Bundle)localObject4).putString("intext_3", "0");
    if (!bool) {
      localObject1 = "1";
    }
    ((Bundle)localObject4).putString("intext_1", (String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1));
    ((Bundle)localObject4).putString("intext_2", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(l);
    ((Bundle)localObject4).putString("intext_5", ((StringBuilder)localObject1).toString());
    if (!bool) {
      ((Bundle)localObject4).putString("stringext_1", this.this$1.this$0.mTargetUrl);
    }
    ReportCenter.a().a((Bundle)localObject4, "", (String)localObject2, false, this.this$1.this$0.isSdkShare());
    if (bool)
    {
      this.this$1.this$0.mUrlMap.putAll((Map)localObject3);
      this.this$1.this$0.mIsAllUrlShort.set(true);
      localObject1 = this.this$1;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("UrlExchangeStep|run,url=");
      ((StringBuilder)localObject3).append(this.this$1.this$0.mUrlMap.toString());
      ((ForwardSdkShareProcessor.UrlExchangeStep)localObject1).qlog(((StringBuilder)localObject3).toString());
      localObject1 = (String)this.this$1.this$0.mUrlMap.get("imageUrl");
      if (localObject1 != null)
      {
        ForwardStatisticsReporter.a("reuse_image_for_aio");
        ShareProcessorUtil.a(false, this.this$1.this$0.mRemoteImgUrl, this.this$1.this$0.mRemoteImgUrl, (String)localObject1);
        ForwardStatisticsReporter.a("reuse_image_for_aio", (String)localObject2, true);
      }
    }
    else
    {
      if ((ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1).get() == 100000) && (ForwardSdkShareProcessor.access$1200(this.this$1.this$0) < 2))
      {
        ForwardSdkShareProcessor.access$1208(this.this$1.this$0);
        ForwardSdkShareProcessor.access$202(this.this$1.this$0, null);
        ForwardSdkShareProcessor.access$102(this.this$1.this$0, true);
        ForwardSdkShareProcessor.access$1300(this.this$1.this$0);
        return;
      }
      if ((ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1).get() == -1) && (ForwardSdkShareProcessor.UrlExchangeStep.access$1400(this.this$1).getAndIncrement() < 2))
      {
        run();
        return;
      }
    }
    if (!bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("UrlExchangeStep|ret=");
      ((StringBuilder)localObject1).append(ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1));
      ((StringBuilder)localObject1).append(",cost=");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(",url=");
      ((StringBuilder)localObject1).append(this.this$1.this$0.mUrlMap.toString());
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.this$1.this$0.app.getMessageFacade().b(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq);
    if ((localObject1 != null) && ((localObject1 instanceof MessageForStructing)))
    {
      localObject1 = (MessageForStructing)localObject1;
      if ((((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))
      {
        localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
        localObject2 = (String)this.this$1.this$0.mUrlMap.get("targetUrl");
        if (localObject2 != null) {
          ((AbsShareMsg)localObject1).mMsgUrl = ((String)localObject2);
        }
        localObject2 = (String)this.this$1.this$0.mUrlMap.get("sourceUrl");
        if (localObject2 != null) {
          ((AbsShareMsg)localObject1).mSourceUrl = ((String)localObject2);
        }
        localObject2 = (String)this.this$1.this$0.mUrlMap.get("sourceIcon");
        if (localObject2 != null) {
          ((AbsShareMsg)localObject1).mSourceIcon = ((String)localObject2);
        }
        localObject2 = (String)this.this$1.this$0.mUrlMap.get("audioUrl");
        if (localObject2 != null) {
          ((AbsShareMsg)localObject1).mContentSrc = ((String)localObject2);
        }
        localObject2 = (String)this.this$1.this$0.mUrlMap.get("imageUrl");
        if (localObject2 != null)
        {
          ((AbsShareMsg)localObject1).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject1).updateCover((String)localObject2);
        }
        if (this.this$1.this$0.mIsAllUrlShort.get()) {
          ((AbsShareMsg)localObject1).shareData.shortUrlStatus = 1;
        }
        this.this$1.this$0.app.getMessageFacade().a(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject1).getBytes());
      }
    }
    this.this$1.doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */