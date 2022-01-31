package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import axrt;
import axsp;
import axsq;
import axxj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mpx;

public class SplashMiniGameDownloadManager$DownLoadNetEngine
  implements axrt
{
  QQAppInterface app;
  String appid;
  String downloadurl;
  String resPath;
  int type;
  
  public SplashMiniGameDownloadManager$DownLoadNetEngine(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.app = paramQQAppInterface;
    this.appid = paramString1;
    this.type = paramInt;
    this.downloadurl = paramString3;
    this.resPath = paramString2;
  }
  
  public void onResp(axsq paramaxsq)
  {
    try
    {
      if (paramaxsq.a == 0)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.resPath))
        {
          paramaxsq = new File(this.resPath);
          if (paramaxsq.exists())
          {
            long l = paramaxsq.length();
            axxj localaxxj = (axxj)this.app.getManager(193);
            if (localaxxj.a())
            {
              QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
              localaxxj.a(this.downloadurl, l);
            }
            if (this.type == 0)
            {
              mpx.a(paramaxsq, paramaxsq.getParent() + File.separator);
              this.resPath = (paramaxsq.getParent() + File.separator + "splash.png");
            }
            SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
            return;
          }
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
        }
      }
      else if (paramaxsq.a == 1)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramaxsq) {}
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */