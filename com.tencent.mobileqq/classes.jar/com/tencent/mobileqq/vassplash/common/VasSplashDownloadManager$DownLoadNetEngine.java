package com.tencent.mobileqq.vassplash.common;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VasSplashDownloadManager$DownLoadNetEngine
  implements INetEngineListener
{
  int a;
  String b;
  String c;
  String d;
  String e;
  QQAppInterface f;
  
  public VasSplashDownloadManager$DownLoadNetEngine(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.f = paramQQAppInterface;
    this.b = paramString1;
    this.a = paramInt;
    this.c = paramString4;
    this.e = paramString2;
    this.d = paramString3;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    try
    {
      int i = paramNetResp.mResult;
      if (i == 0)
      {
        QLog.i("splash.tag.QSplash@VasSplashDownloadManager", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.e))
        {
          if (SplashItem.a(this.e, false))
          {
            paramNetResp = new File(this.e);
            paramNetResp.renameTo(new File(this.e.substring(0, this.e.lastIndexOf("."))));
            long l = paramNetResp.length();
            paramNetResp = (IPreDownloadController)this.f.getRuntimeService(IPreDownloadController.class);
            if (paramNetResp.isEnable())
            {
              QLog.i("QSplash@VasSplashUtil", 1, "preDownloadSuccess");
              paramNetResp.preDownloadSuccess(this.c, l);
            }
            VasSplashDownloadManager.a(this.f.getAccount(), this.b);
            return;
          }
          VasSplashDownloadManager.a(this.c, this.f, this.b);
          QLog.i("QSplash@VasSplashUtil", 1, "ResFile check not exist");
        }
      }
      else if (paramNetResp.mResult == 1)
      {
        VasSplashDownloadManager.a(this.c, this.f, this.b);
        QLog.i("QSplash@VasSplashUtil", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramNetResp) {}
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashDownloadManager.DownLoadNetEngine
 * JD-Core Version:    0.7.0.1
 */