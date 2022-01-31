package com.tencent.mobileqq.minigame.splash;

import baub;
import bavh;
import bazx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class SplashMiniGameDownloadManager$1
  extends bazx
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
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = new SplashMiniGameDownloadManager.DownLoadNetEngine(this.app, this.val$appid, this.val$contentType, this.val$path, this.val$downloadUrl);
    localbaub.jdField_a_of_type_JavaLangString = this.val$downloadUrl;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.c = this.val$path;
    ((bavh)this.app.getNetEngine(0)).a(localbaub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */