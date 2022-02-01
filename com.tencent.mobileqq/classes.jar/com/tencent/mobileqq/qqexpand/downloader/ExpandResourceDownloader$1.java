package com.tencent.mobileqq.qqexpand.downloader;

import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class ExpandResourceDownloader$1
  implements HttpEngineTask.IHttpEngineTask
{
  ExpandResourceDownloader$1(ExpandResourceDownloader paramExpandResourceDownloader) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    ExpandResourceDownloader.a(this.a, System.currentTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramHttpEngineTask.httpReq.mReqUrl }));
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject1 = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject1, Integer.valueOf(paramNetResp.mResult) }));
    }
    ExpandResourceDownloader.a(this.a).set(paramNetResp.mResult);
    long l = System.currentTimeMillis() - ExpandResourceDownloader.a(this.a);
    int i = paramNetResp.mResult;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("download fail ");
        ((StringBuilder)localObject2).append(paramNetResp.mErrDesc);
        QLog.e("ExpandResourceDownloader", 2, ((StringBuilder)localObject2).toString());
      }
      ExpandResourceDownloader.a(this.a, paramNetResp.mErrCode, ExpandResourceDownloader.a(this.a), l, paramNetResp.mErrDesc);
      ExpandResourceDownloader.a(this.a).preDownloadSuccess((String)localObject1, -1L);
      return;
    }
    Object localObject2 = this.a;
    ExpandResourceDownloader.a((ExpandResourceDownloader)localObject2, 0, ExpandResourceDownloader.a((ExpandResourceDownloader)localObject2), l, "");
    ExpandResourceDownloader.a(this.a).preDownloadSuccess((String)localObject1, paramNetResp.mTotalFileLen);
    paramNetResp = (HttpNetReq)paramNetResp.mReq;
    boolean bool2 = ExpandResourceDownloader.a(this.a, paramNetResp.mOutPath, ExpandResourceDownloader.a(this.a));
    if (bool2)
    {
      localObject1 = new File(ExpandResourceDownloader.b(this.a));
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      boolean bool4 = ExpandResourceDownloader.b(this.a, paramNetResp.mOutPath, ExpandResourceDownloader.b(this.a));
      boolean bool3 = ExpandResourceDownloader.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("ExpandResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      }
      boolean bool1;
      if (ExpandResourceDownloader.a(this.a) != null)
      {
        paramNetResp = ExpandResourceDownloader.a(this.a);
        if ((bool4) && (bool3)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramNetResp.a(bool1);
      }
      paramNetResp = ExtendFriendReport.a();
      if ((bool4) && (bool3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramNetResp.b(bool1, bool3 ^ true);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("ExpandResourceDownloader", 2, "onResp ResultOk file check invalid.");
      }
      ExpandResourceDownloader.a(this.a, paramNetResp.mOutPath);
      if (ExpandResourceDownloader.a(this.a) != null) {
        ExpandResourceDownloader.a(this.a).a(false);
      }
    }
    ExtendFriendReport.a().a(bool2, 0);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    ExpandResourceDownloader.b(this.a, paramLong1);
    ExpandResourceDownloader.c(this.a, paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExpandResourceDownloader.1
 * JD-Core Version:    0.7.0.1
 */