package cooperation.troop_homework.jsp;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.io.File;
import java.util.HashMap;

class TroopHWFileDownloadManager$5
  implements ITMAssistantDownloadClientListener
{
  TroopHWFileDownloadManager$5(TroopHWFileDownloadManager paramTroopHWFileDownloadManager) {}
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    paramTMAssistantDownloadClient = (TroopHWFileDownloadManager.OnDownloadStateListener)TroopHWFileDownloadManager.c(this.a).get(paramString);
    if (paramTMAssistantDownloadClient != null) {
      paramTMAssistantDownloadClient.a(paramString, paramLong1, paramLong2);
    }
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = 4;
    Object localObject2 = "";
    int i;
    if (paramInt1 == 4)
    {
      localObject1 = (String)TroopHWFileDownloadManager.d(this.a).get(paramString1);
      try
      {
        paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.getDownloadTaskState(paramString1);
        if (paramTMAssistantDownloadClient == null) {
          paramTMAssistantDownloadClient = null;
        } else {
          paramTMAssistantDownloadClient = paramTMAssistantDownloadClient.mSavePath;
        }
      }
      catch (Exception paramTMAssistantDownloadClient)
      {
        QLog.e(TroopHWFileDownloadManager.a, 2, paramTMAssistantDownloadClient.toString());
        paramTMAssistantDownloadClient = (TMAssistantDownloadClient)localObject2;
      }
      if (!TextUtils.isEmpty(paramTMAssistantDownloadClient))
      {
        localObject2 = new File(paramTMAssistantDownloadClient);
        StringBuilder localStringBuilder;
        if (((File)localObject2).exists())
        {
          if (((File)localObject2).renameTo(new File((String)localObject1)))
          {
            i = 1;
            break label228;
          }
          localObject2 = TroopHWFileDownloadManager.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file renameTo faild frompath:");
          localStringBuilder.append(paramTMAssistantDownloadClient);
          localStringBuilder.append(" topath:");
          localStringBuilder.append((String)localObject1);
          QLog.e((String)localObject2, 2, localStringBuilder.toString());
        }
        else
        {
          localObject2 = TroopHWFileDownloadManager.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file not exist path:");
          localStringBuilder.append(paramTMAssistantDownloadClient);
          QLog.e((String)localObject2, 2, localStringBuilder.toString());
        }
      }
      else
      {
        QLog.e(TroopHWFileDownloadManager.a, 2, "currentPath is null");
      }
      i = 0;
      label228:
      paramTMAssistantDownloadClient = (TMAssistantDownloadClient)localObject1;
      if (i == 0)
      {
        paramTMAssistantDownloadClient = (TroopHWFileDownloadManager.OnDownloadStateListener)TroopHWFileDownloadManager.c(this.a).get(paramString1);
        if (paramTMAssistantDownloadClient != null) {
          paramTMAssistantDownloadClient.a(paramString1, 6, 0, "", "");
        }
        TroopHWFileDownloadManager.c(this.a).remove(paramString1);
        TroopHWFileDownloadManager.d(this.a).remove(paramString1);
      }
    }
    else
    {
      paramTMAssistantDownloadClient = "";
    }
    Object localObject1 = (TroopHWFileDownloadManager.OnDownloadStateListener)TroopHWFileDownloadManager.c(this.a).get(paramString1);
    if (localObject1 != null)
    {
      i = j;
      switch (paramInt1)
      {
      default: 
        i = 0;
        break;
      case 6: 
        TroopHWFileDownloadManager.c(this.a).remove(paramString1);
        TroopHWFileDownloadManager.d(this.a).remove(paramString1);
        i = 5;
        break;
      case 5: 
        TroopHWFileDownloadManager.c(this.a).remove(paramString1);
        TroopHWFileDownloadManager.d(this.a).remove(paramString1);
        i = 6;
        break;
      case 4: 
        TroopHWFileDownloadManager.c(this.a).remove(paramString1);
        TroopHWFileDownloadManager.d(this.a).remove(paramString1);
        i = 3;
        break;
      case 2: 
        i = 2;
        break;
      case 1: 
        i = 1;
      }
      ((TroopHWFileDownloadManager.OnDownloadStateListener)localObject1).a(paramString1, i, paramInt2, paramString2, paramTMAssistantDownloadClient);
    }
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWFileDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */