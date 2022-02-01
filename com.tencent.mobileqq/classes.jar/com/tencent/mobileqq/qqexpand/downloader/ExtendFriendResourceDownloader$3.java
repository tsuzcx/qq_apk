package com.tencent.mobileqq.qqexpand.downloader;

import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendResourceDownloader$3
  implements Runnable
{
  ExtendFriendResourceDownloader$3(ExtendFriendResourceDownloader paramExtendFriendResourceDownloader, LimitChatRes paramLimitChatRes) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = this.a.b;
    localHttpNetReq.mHttpMethod = 0;
    Object localObject = ExtendFriendResourceDownloader.a(this.this$0, this.a.c);
    ExtendFriendResourceDownloader.a(this.this$0, (String)localObject);
    localHttpNetReq.mOutPath = ((String)localObject);
    localHttpNetReq.setUserData(this.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Limitchatres start download : ");
    ((StringBuilder)localObject).append(this.a.a);
    ((StringBuilder)localObject).append(" url: ");
    ((StringBuilder)localObject).append(this.a.b);
    ((StringBuilder)localObject).append(" w:");
    ((StringBuilder)localObject).append(localHttpNetReq.mOutPath);
    QLog.d("ExtendFriendResourceDownloader", 2, ((StringBuilder)localObject).toString());
    localHttpNetReq.mCallback = new ExtendFriendResourceDownloader.3.1(this);
    AVNetEngine.a().sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader.3
 * JD-Core Version:    0.7.0.1
 */