package com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class GestureMgrAppDownload$DownloadContrl$1
  implements INetEngineListener
{
  GestureMgrAppDownload$DownloadContrl$1(GestureMgrAppDownload.DownloadContrl paramDownloadContrl, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.e.f == localHttpNetReq) {
      this.e.f = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.a }));
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, str, false);
          GestureMgrAppDownload.a(this.b, this.c);
          i = 1;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          i = 0;
        }
        paramNetResp.delete();
        break label157;
      }
    }
    int i = 0;
    label157:
    if (i != 0)
    {
      GestureMgrAppDownload.a(100 / this.e.c + this.e.d);
      paramNetResp = this.e;
      paramNetResp.d += 100 / this.e.c;
      if (!this.e.a(this.b, this.d - 1)) {
        this.e.a = false;
      }
    }
    else
    {
      GestureMgrAppDownload.a(-1);
      this.e.a = false;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    } else if (paramLong1 >= paramLong2) {
      i = 99;
    } else {
      i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    GestureMgrAppDownload.a(i / this.e.c + this.e.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload.DownloadContrl.1
 * JD-Core Version:    0.7.0.1
 */