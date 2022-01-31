package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import aysc;
import aysy;
import aysz;
import ayxs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nav;

public class SplashMiniGameDownloadManager$DownLoadNetEngine
  implements aysc
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
  
  public void onResp(aysz paramaysz)
  {
    try
    {
      if (paramaysz.a == 0)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.resPath))
        {
          paramaysz = new File(this.resPath);
          if (paramaysz.exists())
          {
            long l = paramaysz.length();
            ayxs localayxs = (ayxs)this.app.getManager(193);
            if (localayxs.a())
            {
              QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
              localayxs.a(this.downloadurl, l);
            }
            if (this.type == 0)
            {
              nav.a(paramaysz, paramaysz.getParent() + File.separator);
              this.resPath = (paramaysz.getParent() + File.separator + "splash.png");
            }
            SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
            return;
          }
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
        }
      }
      else if (paramaysz.a == 1)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramaysz) {}
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */