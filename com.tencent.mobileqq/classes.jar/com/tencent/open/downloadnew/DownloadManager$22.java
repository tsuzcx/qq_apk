package com.tencent.open.downloadnew;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class DownloadManager$22
  implements ITMAssistantDownloadLogListener
{
  SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
  
  DownloadManager$22(DownloadManager paramDownloadManager) {}
  
  public void onLog(ArrayList<TMAssistantDownloadLogInfo> paramArrayList)
  {
    if ((paramArrayList == null) && (QLog.isColorLevel())) {
      QLog.i("DownloadManager_", 2, "logList is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.22
 * JD-Core Version:    0.7.0.1
 */