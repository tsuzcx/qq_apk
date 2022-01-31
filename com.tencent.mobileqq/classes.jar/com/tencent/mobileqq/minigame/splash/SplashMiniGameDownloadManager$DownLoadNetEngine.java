package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import baug;
import bave;
import bavf;
import bbaa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ndr;

public class SplashMiniGameDownloadManager$DownLoadNetEngine
  implements baug
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
  
  public void onResp(bavf parambavf)
  {
    try
    {
      if (parambavf.a == 0)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.resPath))
        {
          parambavf = new File(this.resPath);
          if (parambavf.exists())
          {
            long l = parambavf.length();
            bbaa localbbaa = (bbaa)this.app.getManager(193);
            if (localbbaa.a())
            {
              QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
              localbbaa.a(this.downloadurl, l);
            }
            if (this.type == 0)
            {
              ndr.a(parambavf, parambavf.getParent() + File.separator);
              this.resPath = (parambavf.getParent() + File.separator + "splash.png");
            }
            SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
            return;
          }
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
        }
      }
      else if (parambavf.a == 1)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception parambavf) {}
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */