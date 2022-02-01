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
    Object localObject = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramNetResp.mResult) }));
    }
    int i = paramNetResp.mResult;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("download fail ");
        localStringBuilder.append(paramNetResp.mErrDesc);
        QLog.e("ExtendFriendResourceDownloader", 2, localStringBuilder.toString());
      }
      if (ExtendFriendResourceDownloader.a(this.a) != null) {
        ExtendFriendResourceDownloader.a(this.a).preDownloadSuccess((String)localObject, -1L);
      }
    }
    else
    {
      if (ExtendFriendResourceDownloader.a(this.a) != null) {
        ExtendFriendResourceDownloader.a(this.a).preDownloadSuccess((String)localObject, paramNetResp.mTotalFileLen);
      }
      paramNetResp = (HttpNetReq)paramNetResp.mReq;
      boolean bool2 = ExtendFriendResourceDownloader.a(this.a, paramNetResp.mOutPath, ExtendFriendResourceDownloader.b(this.a));
      if (bool2)
      {
        localObject = new File(ExtendFriendResourceDownloader.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = ExtendFriendResourceDownloader.b(this.a, paramNetResp.mOutPath, ExtendFriendResourceDownloader.a());
        boolean bool3 = ExtendFriendResourceDownloader.c(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        boolean bool1;
        if (ExtendFriendResourceDownloader.d(this.a) != null)
        {
          paramNetResp = ExtendFriendResourceDownloader.d(this.a);
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
          QLog.e("ExtendFriendResourceDownloader", 2, "onResp ResultOk file check invalid.");
        }
        ExtendFriendResourceDownloader.a(this.a, paramNetResp.mOutPath);
        if (ExtendFriendResourceDownloader.d(this.a) != null) {
          ExtendFriendResourceDownloader.d(this.a).a(false);
        }
      }
      ExtendFriendReport.a().a(bool2, 0);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.downloader.ExtendFriendResourceDownloader.2
 * JD-Core Version:    0.7.0.1
 */