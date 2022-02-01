package com.tencent.mobileqq.extendfriend;

import arhs;
import arhu;
import arhy;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.QLog;
import lbc;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(arhu paramarhu, arhs paramarhs) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = this.a.b;
    localHttpNetReq.mHttpMethod = 0;
    String str = arhu.a(this.this$0, this.a.c);
    arhu.a(this.this$0, str);
    localHttpNetReq.mOutPath = str;
    localHttpNetReq.setUserData(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.a + " url: " + this.a.b + " w:" + localHttpNetReq.mOutPath);
    localHttpNetReq.mCallback = new arhy(this);
    lbc.a().sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */