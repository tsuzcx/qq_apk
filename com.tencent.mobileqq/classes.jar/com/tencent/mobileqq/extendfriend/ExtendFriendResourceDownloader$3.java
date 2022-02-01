package com.tencent.mobileqq.extendfriend;

import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.extendfriend.config.ExpandConfigManager.LimitChatRes;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendResourceDownloader$3
  implements Runnable
{
  ExtendFriendResourceDownloader$3(ExtendFriendResourceDownloader paramExtendFriendResourceDownloader, ExpandConfigManager.LimitChatRes paramLimitChatRes) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = this.a.b;
    localHttpNetReq.mHttpMethod = 0;
    String str = ExtendFriendResourceDownloader.a(this.this$0, this.a.c);
    ExtendFriendResourceDownloader.a(this.this$0, str);
    localHttpNetReq.mOutPath = str;
    localHttpNetReq.setUserData(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.a + " url: " + this.a.b + " w:" + localHttpNetReq.mOutPath);
    localHttpNetReq.mCallback = new ExtendFriendResourceDownloader.3.1(this);
    AVNetEngine.a().sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */