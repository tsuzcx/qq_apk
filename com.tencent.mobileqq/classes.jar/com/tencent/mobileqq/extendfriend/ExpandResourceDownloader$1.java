package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
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
    int i = 1;
    Object localObject = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ExpandResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramNetResp.mResult) }));
    }
    ExpandResourceDownloader.a(this.a).set(paramNetResp.mResult);
    long l = System.currentTimeMillis() - ExpandResourceDownloader.a(this.a);
    switch (paramNetResp.mResult)
    {
    default: 
      return;
    case 0: 
      ExpandResourceDownloader.a(this.a, 0, ExpandResourceDownloader.a(this.a), l, "");
      ExpandResourceDownloader.a(this.a).preDownloadSuccess((String)localObject, paramNetResp.mTotalFileLen);
      paramNetResp = (HttpNetReq)paramNetResp.mReq;
      boolean bool2 = ExpandResourceDownloader.a(this.a, paramNetResp.mOutPath, ExpandResourceDownloader.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(ExpandResourceDownloader.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = ExpandResourceDownloader.b(this.a, paramNetResp.mOutPath, ExpandResourceDownloader.a());
        boolean bool3 = ExpandResourceDownloader.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExpandResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (ExpandResourceDownloader.a(this.a) != null)
        {
          paramNetResp = ExpandResourceDownloader.a(this.a);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            paramNetResp.a(bool1);
          }
        }
        else
        {
          paramNetResp = ExtendFriendReport.a();
          if ((!bool4) || (!bool3)) {
            break label344;
          }
          bool1 = true;
          label316:
          if (bool3) {
            break label350;
          }
          label321:
          paramNetResp.b(bool1, i);
        }
      }
      for (;;)
      {
        ExtendFriendReport.a().a(bool2, 0);
        return;
        bool1 = false;
        break;
        label344:
        bool1 = false;
        break label316;
        label350:
        i = 0;
        break label321;
        if (QLog.isColorLevel()) {
          QLog.e("ExpandResourceDownloader", 2, "onResp ResultOk file check invalid.");
        }
        ExpandResourceDownloader.a(this.a, paramNetResp.mOutPath);
        if (ExpandResourceDownloader.a(this.a) != null) {
          ExpandResourceDownloader.a(this.a).a(false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("ExpandResourceDownloader", 2, "download fail " + paramNetResp.mErrDesc);
    }
    ExpandResourceDownloader.a(this.a, paramNetResp.mErrCode, ExpandResourceDownloader.a(this.a), l, paramNetResp.mErrDesc);
    ExpandResourceDownloader.a(this.a).preDownloadSuccess((String)localObject, -1L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExpandResourceDownloader.1
 * JD-Core Version:    0.7.0.1
 */