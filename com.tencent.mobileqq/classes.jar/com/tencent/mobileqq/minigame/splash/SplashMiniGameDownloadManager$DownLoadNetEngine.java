package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import beuq;
import bevl;
import bevm;
import bezv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nof;

public class SplashMiniGameDownloadManager$DownLoadNetEngine
  implements beuq
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
  
  public void onResp(bevm parambevm)
  {
    try
    {
      if (parambevm.a == 0)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.resPath))
        {
          parambevm = new File(this.resPath);
          if (parambevm.exists())
          {
            long l = parambevm.length();
            bezv localbezv = (bezv)this.app.getManager(193);
            if (localbezv.a())
            {
              QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
              localbezv.a(this.downloadurl, l);
            }
            if (this.type == 0)
            {
              nof.a(parambevm, parambevm.getParent() + File.separator);
              this.resPath = (parambevm.getParent() + File.separator + "splash.png");
            }
            SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
            return;
          }
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
        }
      }
      else if (parambevm.a == 1)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception parambevm) {}
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */