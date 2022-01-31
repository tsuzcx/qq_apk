import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.HashMap;

class mzw
  implements ITMAssistantDownloadClientListener
{
  mzw(mzv parammzv) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    if (paramTMAssistantDownloadClient == null) {}
    do
    {
      return;
      paramTMAssistantDownloadClient = (mzq)mzv.a().get(paramString);
    } while ((paramTMAssistantDownloadClient == null) || (paramTMAssistantDownloadClient.a == null));
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    paramTMAssistantDownloadClient.a.progress(i);
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OfflineDownload", 2, "task onDownloadSDKTaskStateChanged + url = " + paramString1 + ", state = " + paramInt1 + ", errorCode = " + paramInt2);
    }
    if (paramTMAssistantDownloadClient == null) {
      this.a.a(null, paramString1, null, -1, "client is null, " + paramString2);
    }
    do
    {
      do
      {
        do
        {
          return;
          paramString2 = (mzq)mzv.a().get(paramString1);
          if ((paramString2 == null) || (paramString2.a == null))
          {
            this.a.a(null, paramString1, null, -1, "download info is null or callback is null");
            return;
          }
          switch (paramInt1)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("OfflineDownload", 2, "task downloading + url = " + paramString1);
        return;
        this.a.a(paramTMAssistantDownloadClient, paramString2, paramString1);
        return;
        this.a.a(paramString2.a, paramString1, paramString2.c, paramInt2, "offline zip download fail");
        try
        {
          this.a.a.cancelDownloadTask(paramString1);
          return;
        }
        catch (Exception paramTMAssistantDownloadClient) {}
      } while (!QLog.isDevelopLevel());
      QLog.d("OfflineDownload", 4, paramTMAssistantDownloadClient.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("OfflineDownload", 2, "task paused + url = " + paramString1);
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mzw
 * JD-Core Version:    0.7.0.1
 */