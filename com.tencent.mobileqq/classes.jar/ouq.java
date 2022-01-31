import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ouq
  implements ITMAssistantDownloadClientListener
{
  private List<oup> a = new LinkedList();
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 1: 
      return "DownloadSDKTaskState_WAITING";
    case 2: 
      return "DownloadSDKTaskState_DOWNLOADING";
    case 4: 
      return "DownloadSDKTaskState_SUCCEED";
    case 3: 
      return "DownloadSDKTaskState_PAUSED";
    case 6: 
      return "DownloadSDKTaskState_DELETE";
    }
    return "DownloadSDKTaskState_FAILED";
  }
  
  public void a(oup paramoup)
  {
    if (!this.a.contains(paramoup)) {
      this.a.add(paramoup);
    }
  }
  
  public void b(oup paramoup)
  {
    this.a.remove(paramoup);
  }
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      QLog.d("DownloadListenerDelegate", 2, "[onDownloadSDKTaskProgressChanged] url=" + paramString + " receiveLen=" + paramLong1 + " totalLen=" + paramLong2 + " progress=" + paramLong1 * 1.0D / paramLong2 * 100.0D);
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
          QLog.d("DownloadListenerDelegate", 2, "[onDownloadSDKTaskProgressChanged] url=" + paramString1 + " savedPath= " + paramTMAssistantDownloadClient.mSavePath + " state=" + a(paramInt1) + " errorCode=" + paramInt2 + " errorMsg=" + paramString2);
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext()) {
            ((oup)localIterator.next()).a(paramString1, paramTMAssistantDownloadClient.mSavePath, paramInt1, paramInt2, paramString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ouq
 * JD-Core Version:    0.7.0.1
 */