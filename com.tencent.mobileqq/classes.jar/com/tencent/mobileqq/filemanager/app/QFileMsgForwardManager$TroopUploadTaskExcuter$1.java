package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper.ITroopMultiFwdCallback;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$TroopUploadTaskExcuter$1
  implements QFileTroopTransferWrapper.ITroopMultiFwdCallback
{
  QFileMsgForwardManager$TroopUploadTaskExcuter$1(QFileMsgForwardManager.TroopUploadTaskExcuter paramTroopUploadTaskExcuter) {}
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("TroopUploadTaskExcuter onWorkDone failed canResume[");
      paramBundle.append(paramBoolean);
      paramBundle.append("] errCode[");
      paramBundle.append(paramInt);
      paramBundle.append("] WorkerId[");
      paramBundle.append(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
      paramBundle.append("] filename ");
      paramBundle.append(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramBundle.toString());
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), false), paramBoolean);
      return;
    }
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a, paramBundle.getLong("fileSize"));
    String str1 = paramBundle.getString("strFileId");
    String str2 = paramBundle.getString("strMd5");
    String str3 = paramBundle.getString("strSha");
    paramInt = paramBundle.getInt("width");
    int i = paramBundle.getInt("height");
    int j = paramBundle.getInt("duration");
    int k = paramBundle.getInt("busiId");
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardMd5", str2);
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardSha", str3);
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardBusType", String.valueOf(k));
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardUuid", str1);
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardSize", String.valueOf(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a)));
    if (paramInt != 0) {
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(paramInt));
    }
    if (i != 0) {
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(i));
    }
    if (j != 0) {
      QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardDuration", String.valueOf(j));
    }
    QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    paramBundle = new StringBuilder();
    paramBundle.append("TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[");
    paramBundle.append(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
    paramBundle.append("] filename ");
    paramBundle.append(QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramBundle.toString());
    QFileMsgForwardManager.a(QFileMsgForwardManager.a(this.a.a), QFileMsgForwardManager.TroopUploadTaskExcuter.b(this.a), k, str1, QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), 0, paramInt, i, j, false, QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a), QFileMsgForwardManager.TroopUploadTaskExcuter.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.TroopUploadTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */