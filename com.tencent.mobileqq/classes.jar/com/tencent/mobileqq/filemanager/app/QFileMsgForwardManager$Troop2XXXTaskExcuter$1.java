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
      paramString1 = new StringBuilder();
      paramString1.append("Troop2XXXTaskExcuter onCopyToResult but has been stopped filename ");
      paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
      return;
    }
    if (paramInt1 == -103)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Troop2XXXTaskExcuter onCopyToResult retCode[");
      paramString1.append(paramInt1);
      paramString1.append("] clientwording[");
      paramString1.append(paramString3);
      paramString1.append("] filename ");
      paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
      QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a), true), false);
      return;
    }
    if ((paramInt1 != 0) && (paramInt1 != -1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("Troop2XXXTaskExcuter onCopyToResult retCode[");
      paramString1.append(paramInt1);
      paramString1.append("] clientwording[");
      paramString1.append(paramString3);
      paramString1.append("] filename ");
      paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
      QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a), false), false);
      return;
    }
    if (!paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Troop2XXXTaskExcuter onCopyToResult return failed filename ");
      paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
      QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a), false), true);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("Troop2XXXTaskExcuter onCopyToResult strNewPath[");
    paramString2.append(paramString1);
    paramString2.append("] busId[");
    paramString2.append(paramInt2);
    paramString2.append("] mnDstBusId[");
    paramString2.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.e(this.a));
    paramString2.append("] filename ");
    paramString2.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString2.toString());
    QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a, paramString1);
    QFileMsgForwardManager.Troop2XXXTaskExcuter.g(this.a).putString("_m_ForwardUuid", QFileMsgForwardManager.Troop2XXXTaskExcuter.f(this.a));
    if (QFileMsgForwardManager.Troop2XXXTaskExcuter.e(this.a) != 102)
    {
      QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a).a(QFileMsgForwardManager.Troop2XXXTaskExcuter.f(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.g(this.a));
      return;
    }
    QFileMsgForwardManager.Troop2XXXTaskExcuter.a(this.a, paramInt2);
    QFileMsgForwardManager.Troop2XXXTaskExcuter.g(this.a).putString("_m_ForwardBusType", String.valueOf(QFileMsgForwardManager.Troop2XXXTaskExcuter.h(this.a)));
    if (!QFileMsgForwardManager.Troop2XXXTaskExcuter.i(this.a).isEmpty()) {}
    try
    {
      paramInt1 = Integer.parseInt(QFileMsgForwardManager.Troop2XXXTaskExcuter.i(this.a));
    }
    catch (NumberFormatException paramString1)
    {
      label550:
      break label550;
    }
    paramString1 = new StringBuilder();
    paramString1.append("Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.i(this.a));
    paramString1.append("] is error filename ");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
    paramInt1 = 0;
    if (!QFileMsgForwardManager.Troop2XXXTaskExcuter.j(this.a).isEmpty()) {}
    try
    {
      paramInt2 = Integer.parseInt(QFileMsgForwardManager.Troop2XXXTaskExcuter.j(this.a));
    }
    catch (NumberFormatException paramString1)
    {
      label641:
      break label641;
    }
    paramString1 = new StringBuilder();
    paramString1.append("Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.j(this.a));
    paramString1.append("] is error filename ");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
    paramInt2 = 0;
    if (!QFileMsgForwardManager.Troop2XXXTaskExcuter.k(this.a).isEmpty()) {}
    try
    {
      i = Integer.parseInt(QFileMsgForwardManager.Troop2XXXTaskExcuter.k(this.a));
    }
    catch (NumberFormatException paramString1)
    {
      int i;
      label733:
      break label733;
    }
    paramString1 = new StringBuilder();
    paramString1.append("Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.k(this.a));
    paramString1.append("] is error filename ");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
    i = 0;
    if (QFileMsgForwardManager.a(this.a.a) == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("Troop2XXXTaskExcuter onCopyToResult mApp is null filename ");
      paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
      QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a).a(QFileMsgForwardManager.a(QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a), false), false);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename ");
    paramString1.append(QFileMsgForwardManager.Troop2XXXTaskExcuter.b(this.a));
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString1.toString());
    QFileMsgForwardManager.a(QFileMsgForwardManager.a(this.a.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.l(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.h(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.f(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.c(this.a), 0, paramInt1, paramInt2, i, false, QFileMsgForwardManager.Troop2XXXTaskExcuter.g(this.a), QFileMsgForwardManager.Troop2XXXTaskExcuter.d(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Troop2XXXTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */