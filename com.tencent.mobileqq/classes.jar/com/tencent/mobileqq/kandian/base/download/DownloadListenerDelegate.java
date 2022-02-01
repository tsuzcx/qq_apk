package com.tencent.mobileqq.kandian.base.download;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DownloadListenerDelegate
  implements ITMAssistantDownloadClientListener
{
  private List<DownloadListener> a = new LinkedList();
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 6: 
      return "DownloadSDKTaskState_DELETE";
    case 5: 
      return "DownloadSDKTaskState_FAILED";
    case 4: 
      return "DownloadSDKTaskState_SUCCEED";
    case 3: 
      return "DownloadSDKTaskState_PAUSED";
    case 2: 
      return "DownloadSDKTaskState_DOWNLOADING";
    }
    return "DownloadSDKTaskState_WAITING";
  }
  
  public void a(DownloadListener paramDownloadListener)
  {
    if (!this.a.contains(paramDownloadListener)) {
      this.a.add(paramDownloadListener);
    }
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    this.a.remove(paramDownloadListener);
  }
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      paramTMAssistantDownloadClient = new StringBuilder();
      paramTMAssistantDownloadClient.append("[onDownloadSDKTaskProgressChanged] url=");
      paramTMAssistantDownloadClient.append(paramString);
      paramTMAssistantDownloadClient.append(" receiveLen=");
      paramTMAssistantDownloadClient.append(paramLong1);
      paramTMAssistantDownloadClient.append(" totalLen=");
      paramTMAssistantDownloadClient.append(paramLong2);
      paramTMAssistantDownloadClient.append(" progress=");
      double d1 = paramLong1;
      Double.isNaN(d1);
      double d2 = paramLong2;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      paramTMAssistantDownloadClient.append(d1 * 100.0D);
      QLog.d("DownloadListenerDelegate", 2, paramTMAssistantDownloadClient.toString());
      return;
    }
    catch (Throwable paramTMAssistantDownloadClient)
    {
      QLog.e("DownloadListenerDelegate", 1, "[onDownloadSDKTaskProgressChanged] ", paramTMAssistantDownloadClient);
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramTMAssistantDownloadClient != null) {
      try
      {
        paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString1);
        if (paramTMAssistantDownloadClient != null)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[onDownloadSDKTaskProgressChanged] url=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(" savedPath= ");
          ((StringBuilder)localObject).append(paramTMAssistantDownloadClient.mSavePath);
          ((StringBuilder)localObject).append(" state=");
          ((StringBuilder)localObject).append(a(paramInt1));
          ((StringBuilder)localObject).append(" errorCode=");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" errorMsg=");
          ((StringBuilder)localObject).append(paramString2);
          QLog.d("DownloadListenerDelegate", 2, ((StringBuilder)localObject).toString());
          localObject = this.a.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((DownloadListener)((Iterator)localObject).next()).a(paramString1, paramTMAssistantDownloadClient.mSavePath, paramInt1, paramInt2, paramString2);
          }
        }
        return;
      }
      catch (Throwable paramTMAssistantDownloadClient)
      {
        QLog.e("DownloadListenerDelegate", 1, "[onDownloadSDKTaskStateChanged] ", paramTMAssistantDownloadClient);
      }
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    QLog.d("DownloadListenerDelegate", 2, "[onDwonloadSDKServiceInvalid] ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.download.DownloadListenerDelegate
 * JD-Core Version:    0.7.0.1
 */