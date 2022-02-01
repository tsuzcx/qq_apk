package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Troop2XXXTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  private String b;
  private String c;
  private String d;
  private String e;
  private long f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String l;
  private String m;
  private String n;
  private boolean o = false;
  private int p;
  private Bundle q;
  private long r;
  private QFileMsgForwardManager.OnUploadCallback s;
  private String t;
  private int u;
  private TroopFileReqCopyToObserver v = new QFileMsgForwardManager.Troop2XXXTaskExcuter.1(this);
  
  private QFileMsgForwardManager$Troop2XXXTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord, int paramInt)
  {
    super(paramQFileMsgForwardManager);
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize");
    this.f = Long.parseLong(this.e);
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    this.h = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.i = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.j = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
    this.l = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
    this.m = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.n = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    paramQFileMsgForwardManager = new StringBuilder();
    paramQFileMsgForwardManager.append("Troop2XXXTaskExcuter begin filename ");
    paramQFileMsgForwardManager.append(this.d);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramQFileMsgForwardManager.toString());
    this.p = paramInt;
  }
  
  void a(String paramString, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("Troop2XXXTaskExcuter stopped filename ");
    paramString.append(this.d);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.o = true;
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if (paramOnUploadCallback == null)
    {
      paramString = new StringBuilder();
      paramString.append("Troop2XXXTaskExcuter run but callback is null filename ");
      paramString.append(this.d);
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Troop2XXXTaskExcuter run filename ");
    localStringBuilder.append(this.d);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    if ("1".equals(this.n))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start Troop2XXXTaskExcuter:");
        paramString.append(this.d);
        paramString.append(" faild, file is upload paused");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      }
      paramOnUploadCallback.a(QFileMsgForwardManager.a(this.f, false), false);
      return;
    }
    this.s = paramOnUploadCallback;
    this.r = Long.parseLong(paramString);
    this.q = new Bundle();
    this.q.putString("_m_ForwardReceiverUin", String.valueOf(this.r));
    paramString = this.c;
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.q.putString("_m_ForwardSha", this.c);
    }
    this.q.putString("_m_ForwardFileName", this.d);
    this.q.putString("_m_ForwardSize", this.e);
    if (FileManagerUtil.n(this.g)) {
      this.q.putString("_m_ForwardFilePath", this.g);
    }
    if (!this.h.isEmpty()) {
      this.q.putString("_m_ForwardImgWidth", this.j);
    }
    if (!this.i.isEmpty()) {
      this.q.putString("_m_ForwardImgHeight", this.j);
    }
    if (!this.j.isEmpty()) {
      this.q.putString("_m_ForwardDuration", this.j);
    }
    if (paramInt == 0) {
      this.q.putString("_m_ForwardFileType", String.valueOf(1));
    } else if (paramInt == 3000) {
      this.q.putString("_m_ForwardFileType", String.valueOf(2));
    } else if (paramInt == 1) {
      this.q.putString("_m_ForwardFileType", String.valueOf(3));
    }
    try
    {
      l1 = Long.parseLong(this.b);
      if (this.m.isEmpty())
      {
        paramString = new StringBuilder();
        paramString.append("Troop2XXXTaskExcuter run but mstrUrl is empty ");
        paramString.append(this.d);
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
        this.s.a(QFileMsgForwardManager.a(this.f, true), false);
      }
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      label567:
      break label633;
    }
    try
    {
      paramInt = Integer.parseInt(this.l);
      paramString = new StringBuilder();
      paramString.append("Troop2XXXTaskExcuter will call reqCopyto filename[");
      paramString.append(this.d);
      paramString.append("], fileuuid[");
      paramString.append(this.m);
      paramString.append("]");
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      TroopFileProtocol.a(QFileMsgForwardManager.a(this.a), l1, paramInt, this.m, this.r, this.p, null, this.v);
      return;
    }
    catch (NumberFormatException paramString)
    {
      break label567;
    }
    paramString = new StringBuilder();
    paramString.append("Troop2XXXTaskExcuter run but nSrcBusId ");
    paramString.append(0);
    paramString.append(" is error filename ");
    paramString.append(this.d);
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.s.a(QFileMsgForwardManager.a(this.f, false), false);
    return;
    label633:
    paramString = new StringBuilder();
    paramString.append("Troop2XXXTaskExcuter run but TroopUin ");
    paramString.append(this.b);
    paramString.append(" is error filename ");
    paramString.append(this.d);
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.s.a(QFileMsgForwardManager.a(this.f, false), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Troop2XXXTaskExcuter
 * JD-Core Version:    0.7.0.1
 */