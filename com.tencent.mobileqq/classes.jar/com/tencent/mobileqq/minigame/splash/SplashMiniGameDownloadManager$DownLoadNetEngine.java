package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import aysa;
import aysw;
import aysx;
import ayxq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nay;

public class SplashMiniGameDownloadManager$DownLoadNetEngine
  implements aysa
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
  
  public void onResp(aysx paramaysx)
  {
    try
    {
      if (paramaysx.a == 0)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.resPath))
        {
          paramaysx = new File(this.resPath);
          if (paramaysx.exists())
          {
            long l = paramaysx.length();
            ayxq localayxq = (ayxq)this.app.getManager(193);
            if (localayxq.a())
            {
              QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
              localayxq.a(this.downloadurl, l);
            }
            if (this.type == 0)
            {
              nay.a(paramaysx, paramaysx.getParent() + File.separator);
              this.resPath = (paramaysx.getParent() + File.separator + "splash.png");
            }
            SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
            return;
          }
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
        }
      }
      else if (paramaysx.a == 1)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramaysx) {}
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */