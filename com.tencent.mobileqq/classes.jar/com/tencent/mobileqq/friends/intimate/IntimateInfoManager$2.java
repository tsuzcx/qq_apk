package com.tencent.mobileqq.friends.intimate;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class IntimateInfoManager$2
  implements HttpEngineTask.IHttpEngineTask
{
  IntimateInfoManager$2(IntimateInfoManager paramIntimateInfoManager) {}
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramHttpEngineTask.httpReq.mReqUrl }));
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = ((HttpNetReq)paramNetResp.mReq).mReqUrl;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramNetResp.mResult) }));
    }
    switch (paramNetResp.mResult)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (IntimateInfoManager.a(this.a) != null) {
          IntimateInfoManager.a(this.a).preDownloadSuccess((String)localObject, paramNetResp.mTotalFileLen);
        }
        paramNetResp = (HttpNetReq)paramNetResp.mReq;
        if (!IntimateInfoManager.a(this.a, paramNetResp.mOutPath, IntimateInfoManager.a(this.a))) {
          break;
        }
        localObject = new File(IntimateInfoManager.a());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = IntimateInfoManager.b(this.a, paramNetResp.mOutPath, IntimateInfoManager.a());
        bool2 = IntimateInfoManager.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      IntimateInfoManager.a(this.a, paramNetResp.mOutPath);
      return;
    } while (IntimateInfoManager.a(this.a) == null);
    IntimateInfoManager.a(this.a).preDownloadSuccess((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((HttpNetReq)paramNetReq).mReqUrl, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimateInfoManager.2
 * JD-Core Version:    0.7.0.1
 */