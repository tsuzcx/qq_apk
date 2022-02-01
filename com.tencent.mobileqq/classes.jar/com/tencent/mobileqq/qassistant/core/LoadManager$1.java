package com.tencent.mobileqq.qassistant.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

final class LoadManager$1
  implements Runnable
{
  LoadManager$1(String paramString1, File paramFile, String paramString2, AtomicBoolean paramAtomicBoolean, LoadManager.LoadCallBack paramLoadCallBack, String paramString3) {}
  
  public void run()
  {
    try
    {
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new LoadManager.1.1(this);
      localHttpNetReq.mReqUrl = this.c;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = this.jdField_a_of_type_JavaIoFile.getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)AssistantUtils.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      AssistantUtils.a(this.jdField_a_of_type_JavaLangString, "DownLoadZipFile startDownloadZipFile, url: " + this.c);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.LoadManager.1
 * JD-Core Version:    0.7.0.1
 */