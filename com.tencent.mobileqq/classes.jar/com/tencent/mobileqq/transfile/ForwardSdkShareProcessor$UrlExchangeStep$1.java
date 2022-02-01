package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.text.TextUtils;
import atqa;
import bhvw;
import bhzo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ForwardSdkShareProcessor$UrlExchangeStep$1
  implements Runnable
{
  ForwardSdkShareProcessor$UrlExchangeStep$1(ForwardSdkShareProcessor.UrlExchangeStep paramUrlExchangeStep) {}
  
  public void run()
  {
    this.this$1.qlog("UrlExchangeStep|run,retry=" + ForwardSdkShareProcessor.UrlExchangeStep.access$1400(this.this$1));
    if (this.this$1.isCancelled.get())
    {
      this.this$1.doCancel();
      return;
    }
    Object localObject = new Bundle();
    String str = this.this$1.this$0.app.getCurrentUin();
    int i;
    long l;
    boolean bool;
    if ((!ForwardSdkShareProcessor.access$900(this.this$1.this$0).get()) && (TextUtils.isEmpty(this.this$1.this$0.mRemoteImgUrl)))
    {
      i = 0;
      ((Bundle)localObject).putString("report_type", "102");
      ((Bundle)localObject).putString("act_type", "52");
      ((Bundle)localObject).putString("intext_3", "0");
      ((Bundle)localObject).putString("stringext_1", this.this$1.this$0.mTargetUrl);
      ((Bundle)localObject).putString("intext_4", "" + i);
      bhvw.a().a((Bundle)localObject, "", str, false);
      l = System.currentTimeMillis();
      atqa.a("batch_url_exchange");
      localObject = new Bundle();
      HashMap localHashMap = HttpUtil.batchUrlExchange(this.this$1.this$0.mAppContext, str, ForwardSdkShareProcessor.access$200(this.this$1.this$0), 1, this.this$1.this$0.mUrlMap, (Bundle)localObject);
      l = System.currentTimeMillis() - l;
      bool = ((Bundle)localObject).getBoolean("isSuccess");
      i = ((Bundle)localObject).getInt("retcode", -1);
      ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1).set(i);
      localObject = new HashMap();
      ((HashMap)localObject).put("param_ret_code", Integer.toString(i));
      atqa.a("batch_url_exchange", str, (HashMap)localObject, bool);
      this.this$1.qlog("UrlExchangeStep|run,suc=" + bool + ",ret=" + ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1) + ",cost=" + l);
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "12");
      localBundle.putString("intext_3", "0");
      if (!bool) {
        break label1099;
      }
      localObject = "0";
      label415:
      localBundle.putString("intext_1", (String)localObject);
      localBundle.putString("intext_2", "" + ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1));
      localBundle.putString("intext_5", "" + l);
      if (!bool) {
        localBundle.putString("stringext_1", this.this$1.this$0.mTargetUrl);
      }
      bhvw.a().a(localBundle, "", str, false);
      if (!bool) {
        break label1107;
      }
      this.this$1.this$0.mUrlMap.putAll(localHashMap);
      this.this$1.this$0.mIsAllUrlShort.set(true);
      this.this$1.qlog("UrlExchangeStep|run,url=" + this.this$1.this$0.mUrlMap.toString());
      localObject = (String)this.this$1.this$0.mUrlMap.get("imageUrl");
      if (localObject != null)
      {
        atqa.a("reuse_image_for_aio");
        bhzo.a(false, this.this$1.this$0.mRemoteImgUrl, this.this$1.this$0.mRemoteImgUrl, (String)localObject);
        atqa.a("reuse_image_for_aio", str, true);
      }
    }
    label1099:
    label1107:
    do
    {
      if (!bool) {
        QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|ret=" + ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1) + ",cost=" + l + ",url=" + this.this$1.this$0.mUrlMap.toString());
      }
      localObject = this.this$1.this$0.app.getMessageFacade().queryMsgItemByUniseq(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq);
      if ((localObject != null) && ((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        str = (String)this.this$1.this$0.mUrlMap.get("targetUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mMsgUrl = str;
        }
        str = (String)this.this$1.this$0.mUrlMap.get("sourceUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceUrl = str;
        }
        str = (String)this.this$1.this$0.mUrlMap.get("sourceIcon");
        if (str != null) {
          ((AbsShareMsg)localObject).mSourceIcon = str;
        }
        str = (String)this.this$1.this$0.mUrlMap.get("audioUrl");
        if (str != null) {
          ((AbsShareMsg)localObject).mContentSrc = str;
        }
        str = (String)this.this$1.this$0.mUrlMap.get("imageUrl");
        if (str != null)
        {
          ((AbsShareMsg)localObject).shareData.imageUrlStatus = 1;
          ((AbsShareMsg)localObject).updateCover(str);
        }
        if (this.this$1.this$0.mIsAllUrlShort.get()) {
          ((AbsShareMsg)localObject).shareData.shortUrlStatus = 1;
        }
        this.this$1.this$0.app.getMessageFacade().updateMsgContentByUniseq(this.this$1.this$0.mUiRequest.mPeerUin, this.this$1.this$0.mUiRequest.mUinType, this.this$1.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject).getBytes());
      }
      this.this$1.doNextStep();
      return;
      i = this.this$1.this$0.mRemoteImgUrl.length();
      break;
      localObject = "1";
      break label415;
      if ((ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1).get() == 100000) && (ForwardSdkShareProcessor.access$1200(this.this$1.this$0) < 2))
      {
        ForwardSdkShareProcessor.access$1208(this.this$1.this$0);
        ForwardSdkShareProcessor.access$202(this.this$1.this$0, null);
        ForwardSdkShareProcessor.access$102(this.this$1.this$0, true);
        ForwardSdkShareProcessor.access$1300(this.this$1.this$0);
        return;
      }
    } while ((ForwardSdkShareProcessor.UrlExchangeStep.access$1500(this.this$1).get() != -1) || (ForwardSdkShareProcessor.UrlExchangeStep.access$1400(this.this$1).getAndIncrement() >= 2));
    ThreadManager.post(this, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.UrlExchangeStep.1
 * JD-Core Version:    0.7.0.1
 */