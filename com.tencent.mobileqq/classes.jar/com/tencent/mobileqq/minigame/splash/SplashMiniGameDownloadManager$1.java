package com.tencent.mobileqq.minigame.splash;

import bdvs;
import bdwv;
import beat;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class SplashMiniGameDownloadManager$1
  extends beat
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
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = new SplashMiniGameDownloadManager.DownLoadNetEngine(this.app, this.val$appid, this.val$contentType, this.val$path, this.val$downloadUrl);
    localbdvs.jdField_a_of_type_JavaLangString = this.val$downloadUrl;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.c = this.val$path;
    ((bdwv)this.app.getNetEngine(0)).a(localbdvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */