package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Handler;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class UniformDownloaderAppBabySdk$4
  implements ITMAssistantDownloadClientListener
{
  UniformDownloaderAppBabySdk$4(UniformDownloaderAppBabySdk paramUniformDownloaderAppBabySdk) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    UniformDownloaderAppBabySdk.b(this.a);
    if (!UniformDownloaderAppBabySdk.a(this.a).post(new UniformDownloaderAppBabySdk.4.1(this, paramString, paramLong1, paramLong2))) {
      QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Object localObject1 = UniformDownloaderAppBabySdk.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL] inPDownloadSDKTaskStateChanged  state:[");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append("] errcode:[");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append("] errStr:[");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("] url:[");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("]");
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    int k = 0;
    int j = 0;
    localObject2 = null;
    localObject1 = "";
    int i;
    if ((paramTMAssistantDownloadClient != null) && (4 == paramInt1))
    {
      i = 22;
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = paramTMAssistantDownloadClient.getDownloadTaskState(paramString1);
        i = 0;
        paramTMAssistantDownloadClient = (TMAssistantDownloadClient)localObject1;
        localObject1 = localTMAssistantDownloadTaskInfo;
      }
      catch (Exception paramTMAssistantDownloadClient)
      {
        paramTMAssistantDownloadClient.printStackTrace();
        paramTMAssistantDownloadClient = UDConstants.a(22);
        localObject1 = null;
        j = 1;
      }
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
      }
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = null;
      i = 0;
      paramTMAssistantDownloadClient = (TMAssistantDownloadClient)localObject1;
      j = k;
    }
    UniformDownloaderAppBabySdk.b(this.a);
    if (j != 0)
    {
      if (!UniformDownloaderAppBabySdk.a(this.a).post(new UniformDownloaderAppBabySdk.4.2(this, paramString1, i, paramTMAssistantDownloadClient))) {
        QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. haveErr and thread error!!");
      }
    }
    else if ((UniformDownloaderAppBabySdk.a(this.a) != null) && (!UniformDownloaderAppBabySdk.a(this.a).post(new UniformDownloaderAppBabySdk.4.3(this, paramString1, paramInt1, paramInt2, paramString2, (String)localObject2)))) {
      QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDownloadSDKTaskProgressChanged. thread error!!");
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] ABSdkdownload service invalid ");
    UniformDownloaderAppBabySdk.b(this.a);
    if (!UniformDownloaderAppBabySdk.a(this.a).post(new UniformDownloaderAppBabySdk.4.4(this))) {
      QLog.e(UniformDownloaderAppBabySdk.a, 1, "[UniformDL] OnDwonloadSDKServiceInvalid. thread error!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.4
 * JD-Core Version:    0.7.0.1
 */