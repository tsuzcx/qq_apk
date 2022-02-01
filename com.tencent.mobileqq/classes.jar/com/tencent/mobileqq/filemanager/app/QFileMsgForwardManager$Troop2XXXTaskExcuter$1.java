package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Troop2XXXTaskExcuter$1
  extends TroopFileReqCopyToObserver
{
  QFileMsgForwardManager$Troop2XXXTaskExcuter$1(QFileMsgForwardManager.Troop2XXXTaskExcuter paramTroop2XXXTaskExcuter) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    if (QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
      return;
    }
    if (paramInt1 == -103)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
      QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + paramInt1 + "] clientwording[" + paramString3 + "] filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
      QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
      QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a), false), true);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + paramString1 + "] busId[" + paramInt2 + "] mnDstBusId[" + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a) + "] filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
    QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a, paramString1);
    QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).putString("_m_ForwardUuid", QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
    if (QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a) != 102)
    {
      QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).a(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
      return;
    }
    QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a, paramInt2);
    QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).putString("_m_ForwardBusType", String.valueOf(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a)));
    paramInt2 = 0;
    paramInt1 = paramInt2;
    if (!QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a));
      i = 0;
      paramInt2 = i;
      if (QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a).isEmpty()) {}
    }
    catch (NumberFormatException paramString1)
    {
      try
      {
        paramInt2 = Integer.parseInt(QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a));
        j = 0;
        i = j;
        if (QFileMsgForwardManager.Troop2XXXTaskExcuter.e(this.a).isEmpty()) {}
      }
      catch (NumberFormatException paramString1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(QFileMsgForwardManager.Troop2XXXTaskExcuter.e(this.a));
            if (QFileMsgForwardManager.a(this.a.a) != null) {
              break;
            }
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
            QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a), false), false);
            return;
            paramString1 = paramString1;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a) + "] is error filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
            paramInt1 = paramInt2;
          }
          paramString1 = paramString1;
          QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a) + "] is error filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
          paramInt2 = i;
        }
        catch (NumberFormatException paramString1)
        {
          int i;
          for (;;)
          {
            int j;
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + QFileMsgForwardManager.Troop2XXXTaskExcuter.e(this.a) + "] is error filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
            i = j;
          }
          QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
          QFileMsgForwardManager.a(QFileMsgForwardManager.a(this.a.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a), 0, paramInt1, paramInt2, i, false, QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Troop2XXXTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */