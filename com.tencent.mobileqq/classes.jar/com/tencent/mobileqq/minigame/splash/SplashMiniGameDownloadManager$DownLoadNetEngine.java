package com.tencent.mobileqq.minigame.splash;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SplashMiniGameDownloadManager$DownLoadNetEngine
  implements INetEngineListener
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
  
  public void onResp(NetResp paramNetResp)
  {
    try
    {
      int i = paramNetResp.mResult;
      if (i == 0)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.resPath))
        {
          paramNetResp = new File(this.resPath);
          if (paramNetResp.exists())
          {
            long l = paramNetResp.length();
            Object localObject = (IPreDownloadController)this.app.getRuntimeService(IPreDownloadController.class);
            if (((IPreDownloadController)localObject).isEnable())
            {
              QLog.i("SplashMiniGameDownloadMgr", 1, "preDownloadSuccess");
              ((IPreDownloadController)localObject).preDownloadSuccess(this.downloadurl, l);
            }
            if (this.type == 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramNetResp.getParent());
              ((StringBuilder)localObject).append(File.separator);
              ZipUtils.unZipFile(paramNetResp, ((StringBuilder)localObject).toString());
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramNetResp.getParent());
              ((StringBuilder)localObject).append(File.separator);
              ((StringBuilder)localObject).append("splash.png");
              this.resPath = ((StringBuilder)localObject).toString();
            }
            SplashMiniGameUtil.downloadSuccess(this.appid, this.type, this.resPath);
            return;
          }
          QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile check not exist");
        }
      }
      else if (paramNetResp.mResult == 1)
      {
        QLog.i("SplashMiniGameDownloadMgr", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramNetResp) {}
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */