package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class FileAssistantSender$3
  extends DataLineObserver
{
  FileAssistantSender$3(FileAssistantSender paramFileAssistantSender) {}
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (!FileAssistantSender.a(this.a).a(paramLong)) {}
    do
    {
      return;
      FileAssistantSender.b(this.a);
      QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanConnect:" + FileAssistantSender.a(this.a).nSessionId + ", channelType:" + paramInt1 + ", connStep:" + paramInt2);
      if (FileAssistantSender.a(this.a) == null)
      {
        ThreadManager.getUIHandler().removeCallbacks(FileAssistantSender.b(this.a));
        QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanConnect cancel timer:" + FileAssistantSender.a(this.a).nSessionId + "]");
        return;
      }
      QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanConnect[" + FileAssistantSender.a(this.a).nSessionId + "] timer is started,tryCancel");
    } while (!FileAssistantSender.a(this.a).f());
    FileAssistantSender.a(this.a, false);
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (!FileAssistantSender.a(this.a).a(paramSession.uSessionID)) {
      return;
    }
    QLog.i("FileAssistantSender<FileAssistant>", 1, "onServiceSessionProgress:" + FileAssistantSender.a(this.a).nSessionId + ", fProgress:" + paramFloat);
    FileAssistantSender.a(this.a).fProgress = paramFloat;
    FileAssistantSender.a(this.a).getFileManagerNotifyCenter().a(FileAssistantSender.a(this.a).uniseq, FileAssistantSender.a(this.a).nSessionId, FileAssistantSender.a(this.a).peerUin, FileAssistantSender.a(this.a).peerType, 16, null, 0, null);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (!paramSession.isFileAssist) {
      break label7;
    }
    label7:
    while (paramSession.uSessionID != FileAssistantSender.a(this.a).nSessionId) {
      return;
    }
    FileAssistantSender.c(this.a, false);
    QLog.i("FileAssistantSender<FileAssistant>", 1, "onServiceSessionComplete:" + FileAssistantSender.a(this.a).nSessionId + ", isSucc:" + paramBoolean);
    if (FileAssistantSender.c(this.a))
    {
      if (!paramBoolean)
      {
        QLog.i("FileAssistantSender<FileAssistant>", 1, "onServiceSessionComplete:" + FileAssistantSender.a(this.a).nSessionId + ", wanLan faild, offline is working continue!");
        return;
      }
      if ((FileAssistantSender.a(this.a) != null) && (FileAssistantSender.a(this.a).f())) {
        FileAssistantSender.a(this.a, false);
      }
    }
    FileManagerEntity localFileManagerEntity;
    if (FileAssistantSender.a(this.a).status != 1)
    {
      localFileManagerEntity = FileAssistantSender.a(this.a);
      if (!paramBoolean) {
        break label413;
      }
    }
    label413:
    for (int i = 1;; i = 0)
    {
      localFileManagerEntity.status = i;
      FileAssistantSender.a(this.a).getFileManagerDataCenter().c(FileAssistantSender.a(this.a));
      FileAssistantSender.a(this.a).getFileManagerNotifyCenter().a(FileAssistantSender.a(this.a).uniseq, FileAssistantSender.a(this.a).nSessionId, FileAssistantSender.a(this.a).peerUin, FileAssistantSender.a(this.a).peerType, 14, new Object[] { FileAssistantSender.a(this.a), Long.valueOf(FileAssistantSender.a(this.a).fileSize), Boolean.valueOf(true), "" }, 0, null);
      ((DataLineHandler)FileAssistantSender.a(this.a).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(2, paramBoolean, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), FileAssistantSender.a(this.a).getFilePath() });
      if (paramBoolean) {
        FileAssistantSender.b(this.a);
      }
      paramSession = (FileAssistantResultCallbak)FileAssistantSender.a(this.a).get();
      if (paramSession == null) {
        break;
      }
      paramSession.a(this.a);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if (!FileAssistantSender.a(this.a).a(paramLong)) {
      return;
    }
    FileAssistantSender.c(this.a, true);
    if (FileAssistantSender.b(this.a))
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanStartRun:" + FileAssistantSender.a(this.a).nSessionId + ",config isNotEnoughtSpace[" + FileAssistantSender.b(this.a) + "] stop start offline!");
      return;
    }
    if (((IQFileConfigManager)FileAssistantSender.a(this.a).getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly())
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, FileAssistantSender.a(this.a).nSessionId + ":run only wlan mode, waiting for connect!");
      return;
    }
    QLog.i("FileAssistantSender<FileAssistant>", 1, "onWlanStartRun:" + FileAssistantSender.a(this.a).nSessionId + ", start offline timer, wait 3s!");
    synchronized (this.a)
    {
      FileAssistantSender.a(this.a, FileAssistantSender.a(this.a));
      paramLong = QFileAssistantUtils.b(FileAssistantSender.a(this.a));
      ThreadManager.getUIHandler().postDelayed(FileAssistantSender.b(this.a), paramLong);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender.3
 * JD-Core Version:    0.7.0.1
 */