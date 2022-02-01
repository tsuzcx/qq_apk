package com.tencent.mobileqq.minigame.splash;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

final class SplashMiniGameDownloadManager$1
  extends AbsPreDownloadTask
{
  SplashMiniGameDownloadManager$1(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  public void realCancel()
  {
    QLog.i("SplashMiniGameDownloadMgr", 1, "ctrl realCancel");
  }
  
  public void realStart()
  {
    QLog.i("SplashMiniGameDownloadMgr", 1, "downloadPicAGifAVideoRes appid" + this.val$appid);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new SplashMiniGameDownloadManager.DownLoadNetEngine(this.app, this.val$appid, this.val$contentType, this.val$path, this.val$downloadUrl);
    localHttpNetReq.mReqUrl = this.val$downloadUrl;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = this.val$path;
    ((OldHttpEngine)this.app.getNetEngine(0)).sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */