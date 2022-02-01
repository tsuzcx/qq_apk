package com.tencent.mobileqq.minigame.splash;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;

public class SplashMiniGameDownloadManager
{
  public static final int RES_TYPE_PIC = 0;
  public static final int RES_TYPE_VIDEO = 1;
  public static final String TAG = "SplashMiniGameDownloadMgr";
  
  public static void downloadRes(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    for (;;)
    {
      try
      {
        PreDownloadController localPreDownloadController = (PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        if (localPreDownloadController.isEnable())
        {
          String str = "minigame_splash_png";
          if (paramInt == 1)
          {
            str = "minigame_splash_video";
            i = 10087;
            QLog.i("SplashMiniGameDownloadMgr", 1, "downloadPicAGifAVideoRes request appid" + paramString1);
            localPreDownloadController.requestPreDownload(i, "prd", paramString2, 0, paramString2, paramString3, 2, 0, false, new SplashMiniGameDownloadManager.1(paramQQAppInterface, str, paramString1, paramInt, paramString3, paramString2));
          }
        }
        else
        {
          QLog.i("SplashMiniGameDownloadMgr", 1, "ctrl.isEnable() = false");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      int i = 10086;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager
 * JD-Core Version:    0.7.0.1
 */