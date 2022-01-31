package com.tencent.mobileqq.minigame.splash;

import ayrv;
import aysz;
import ayxn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class SplashMiniGameDownloadManager$1
  extends ayxn
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
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = new SplashMiniGameDownloadManager.DownLoadNetEngine(this.app, this.val$appid, this.val$contentType, this.val$path, this.val$downloadUrl);
    localayrv.jdField_a_of_type_JavaLangString = this.val$downloadUrl;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.c = this.val$path;
    ((aysz)this.app.getNetEngine(0)).a(localayrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */