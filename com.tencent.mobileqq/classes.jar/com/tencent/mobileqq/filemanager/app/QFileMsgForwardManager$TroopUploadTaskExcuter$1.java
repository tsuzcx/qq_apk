package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.ITroopFileUploadWorker;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.ITroopFileUploadWorkerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class QFileMsgForwardManager$TroopUploadTaskExcuter$1
  implements TroopFileUploadMgr.ITroopFileUploadWorkerListener
{
  QFileMsgForwardManager$TroopUploadTaskExcuter$1(QFileMsgForwardManager.TroopUploadTaskExcuter paramTroopUploadTaskExcuter) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileUploadMgr.ITroopFileUploadWorker paramITroopFileUploadWorker)
  {
    if (QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a) + "] filename " + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramITroopFileUploadWorker.d();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a) + "] filename " + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramITroopFileUploadWorker.c();
    String str1 = paramITroopFileUploadWorker.d();
    paramInt = paramITroopFileUploadWorker.a();
    String str2 = paramITroopFileUploadWorker.a();
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a, paramITroopFileUploadWorker.b());
    int i = paramITroopFileUploadWorker.b();
    int j = paramITroopFileUploadWorker.c();
    int k = paramITroopFileUploadWorker.d();
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardMd5", paramUUID);
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardSha", str1);
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardUuid", str2);
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardSize", String.valueOf(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a)));
    if (i != 0) {
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (QFileMsgForwardManager.a(this.a.a) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a) + "] filename " + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a) + "] filename " + QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
    QFileMsgForwardManager.a(QFileMsgForwardManager.a(this.a.a), QFileMsgForwardManager.TroopUploadTaskExcuter.b(this.a), paramInt, str2, QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), 0, i, j, k, false, QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.TroopUploadTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */