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

class ExtendFriendResourceDownloader$2
  implements HttpEngineTask.IHttpEngineTask
{
  ExtendFriendResourceDownloader$2(ExtendFriendResourceDownloader paramExtendFriendResourceDownloader) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramHttpEngineTask.httpReq.mReqUrl }));
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    int i = 1;
    Object localObject = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramNetResp.mResult) }));
    }
    switch (paramNetResp.mResult)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (ExtendFriendResourceDownloader.a(this.a) != null) {
        ExtendFriendResourceDownloader.a(this.a).preDownloadSuccess((String)localObject, paramNetResp.mTotalFileLen);
      }
      paramNetResp = (HttpNetReq)paramNetResp.mReq;
      boolean bool2 = ExtendFriendResourceDownloader.a(this.a, paramNetResp.mOutPath, ExtendFriendResourceDownloader.a(this.a));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(ExtendFriendResourceDownloader.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = ExtendFriendResourceDownloader.b(this.a, paramNetResp.mOutPath, ExtendFriendResourceDownloader.a());
        boolean bool3 = ExtendFriendResourceDownloader.a(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (ExtendFriendResourceDownloader.a(this.a) != null)
        {
          paramNetResp = ExtendFriendResourceDownloader.a(this.a);
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
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          paramNetResp.b(bool1, i);
        }
      }
      for (;;)
      {
        ExtendFriendReport.a().a(bool2, 0);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label277;
        i = 0;
        break label282;
        if (QLog.isColorLevel()) {
          QLog.e("ExtendFriendResourceDownloader", 2, "onResp ResultOk file check invalid.");
        }
        ExtendFriendResourceDownloader.a(this.a, paramNetResp.mOutPath);
        if (ExtendFriendResourceDownloader.a(this.a) != null) {
          ExtendFriendResourceDownloader.a(this.a).a(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + paramNetResp.mErrDesc);
      }
    } while (ExtendFriendResourceDownloader.a(this.a) == null);
    ExtendFriendResourceDownloader.a(this.a).preDownloadSuccess((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.2
 * JD-Core Version:    0.7.0.1
 */