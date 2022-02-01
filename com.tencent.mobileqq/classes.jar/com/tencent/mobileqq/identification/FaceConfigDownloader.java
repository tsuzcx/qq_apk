package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.qqconnectface.IResourceObserverApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public class FaceConfigDownloader
{
  protected static HttpEngineServiceImpl a;
  
  public static void a(ConfigItem paramConfigItem, String paramString, FaceConfigDownloader.IDownloadCallback paramIDownloadCallback)
  {
    if (paramConfigItem == null) {}
    try
    {
      QLog.e("FaceConfigDownloader", 1, "downloadConfig, item is null");
      return;
    }
    finally {}
    if (a == null)
    {
      localObject = new HttpCommunicator(4);
      ((HttpCommunicator)localObject).start();
      a = new HttpEngineServiceImpl((HttpCommunicator)localObject, false);
    }
    QLog.d("FaceConfigDownloader", 1, new Object[] { "download config, config is : ", paramConfigItem });
    Object localObject = new File(paramString);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new FaceConfigDownloader.FaceDownloadCallback(paramConfigItem, paramIDownloadCallback);
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mReqUrl = FaceConfigManager.a(paramConfigItem);
    paramConfigItem = new StringBuilder();
    paramConfigItem.append(paramString);
    paramConfigItem.append("identification.zip");
    ((HttpNetReq)localObject).mOutPath = paramConfigItem.toString();
    ((HttpNetReq)localObject).mPrioty = 0;
    a.sendReq((NetReq)localObject);
  }
  
  public static void a(AppRuntime paramAppRuntime, FaceConfigDownloader.IConfigObserver paramIConfigObserver)
  {
    ((IResourceObserverApi)QRoute.api(IResourceObserverApi.class)).requestFaceManage(paramAppRuntime, new FaceConfigDownloader.FaceObserver(paramIConfigObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceConfigDownloader
 * JD-Core Version:    0.7.0.1
 */