package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class QFileMsgForwardManager$DiscUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected String a;
  protected String b;
  protected long c;
  private Bundle e;
  private long f;
  
  QFileMsgForwardManager$DiscUploadTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
  {
    super(paramQFileMsgForwardManager);
    this.a = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.c = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    paramQFileMsgForwardManager = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.e = new Bundle();
    this.e.putString("_m_ForwardImgWidth", paramQFileMsgForwardManager);
    this.e.putString("_m_ForwardImgHeight", paramMessageRecord);
  }
  
  void a(String paramString, int paramInt)
  {
    QFileMsgForwardManager.a(this.d).getFileManagerEngine().l().a(this.f);
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    this.e.putString("_m_ForwardFileType", "2");
    this.e.putString("_m_ForwardReceiverUin", paramString);
    this.e.putString("_m_ForwardFileName", this.a);
    this.c = FileManagerUtil.h(this.b);
    this.f = QFileMsgForwardManager.a(this.d).getFileManagerEngine().l().a(this.b, paramString, new QFileMsgForwardManager.DiscUploadTaskExcuter.1(this, paramOnUploadCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.DiscUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */