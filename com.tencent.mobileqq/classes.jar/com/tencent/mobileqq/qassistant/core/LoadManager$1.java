package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

final class LoadManager$1
  implements Runnable
{
  LoadManager$1(String paramString1, File paramFile, String paramString2, AtomicBoolean paramAtomicBoolean, LoadManager.LoadCallBack paramLoadCallBack, String paramString3) {}
  
  public void run()
  {
    try
    {
      Object localObject = new HttpNetReq();
      ((HttpNetReq)localObject).mCallback = new LoadManager.1.1(this);
      ((HttpNetReq)localObject).mReqUrl = this.f;
      ((HttpNetReq)localObject).mHttpMethod = 0;
      ((HttpNetReq)localObject).mOutPath = this.b.getPath();
      ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)AssistantUtils.c().getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DownLoadZipFile startDownloadZipFile, url: ");
      localStringBuilder.append(this.f);
      AssistantUtils.a((String)localObject, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.d.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.LoadManager.1
 * JD-Core Version:    0.7.0.1
 */