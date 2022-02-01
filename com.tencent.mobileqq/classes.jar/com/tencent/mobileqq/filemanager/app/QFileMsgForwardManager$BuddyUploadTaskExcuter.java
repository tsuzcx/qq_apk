package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.C2CFileMultiFwdInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class QFileMsgForwardManager$BuddyUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected String a;
  protected String b;
  protected long c;
  private long e;
  private Bundle f;
  
  public QFileMsgForwardManager$BuddyUploadTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
  {
    super(paramQFileMsgForwardManager);
    this.a = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.c = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    paramQFileMsgForwardManager = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.f = new Bundle();
    this.f.putString("_m_ForwardImgWidth", paramQFileMsgForwardManager);
    this.f.putString("_m_ForwardImgHeight", paramMessageRecord);
  }
  
  void a(String paramString, int paramInt)
  {
    QFileMsgForwardManager.a(this.d).getFileManagerEngine().j().a(this.e);
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    this.f.putString("_m_ForwardFileType", "1");
    this.f.putString("_m_ForwardReceiverUin", paramString);
    this.f.putString("_m_ForwardFileName", this.a);
    this.c = FileManagerUtil.h(this.b);
    QFileC2CTransferWrapper.C2CFileMultiFwdInfo localC2CFileMultiFwdInfo = new QFileC2CTransferWrapper.C2CFileMultiFwdInfo();
    localC2CFileMultiFwdInfo.a = this.b;
    localC2CFileMultiFwdInfo.c = paramString;
    localC2CFileMultiFwdInfo.b = paramInt;
    this.e = QFileMsgForwardManager.a(this.d).getFileManagerEngine().j().a(localC2CFileMultiFwdInfo, new QFileMsgForwardManager.BuddyUploadTaskExcuter.1(this, paramOnUploadCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */