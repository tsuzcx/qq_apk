package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtFileAssistOfflineSendWorker;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.WlanRecvNotify;

public class FileAssistantSender
{
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private OfflineSendWorker jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker = null;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
  private WLANSender jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private String jdField_a_of_type_JavaLangString = null;
  private WeakReference<FileAssistantResultCallbak> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public FileAssistantSender(QQAppInterface paramQQAppInterface, FileAssistantResultCallbak paramFileAssistantResultCallbak, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFileAssistantResultCallbak);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
  }
  
  FileAssistantSender(QQAppInterface paramQQAppInterface, FileAssistantResultCallbak paramFileAssistantResultCallbak, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFileAssistantResultCallbak);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Runnable a()
  {
    return new FileAssistantSender.1(this);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == -10112) || (paramInt == -25087) || (paramInt == -98090);
  }
  
  private void b(boolean paramBoolean)
  {
    f();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender = new WLANSender();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isStartWlan = true;
    QLog.i("FileAssistantSender<FileAssistant>", 1, "doWlanSend[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],filePath:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + ",filename:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker = new ExtFileAssistOfflineSendWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    QLog.i("FileAssistantSender<FileAssistant>", 1, "doOfflineSend[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] use extf upload. filename:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    e();
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker.aw_();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new FileAssistantSender.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new FileAssistantSender.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  private void g()
  {
    if (this.b)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "sendWlanNotify failed, isSendWlanNotify:true");
      return;
    }
    this.b = true;
    SubMsgType0x4.WlanRecvNotify localWlanRecvNotify = new SubMsgType0x4.WlanRecvNotify();
    int i = (int)MessageCache.a();
    localWlanRecvNotify.uint32_time.set(i);
    localWlanRecvNotify.uint64_file_size.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localWlanRecvNotify.str_file_name.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localWlanRecvNotify.uint32_send_client_type.set(QFileAssistantUtils.a());
    localWlanRecvNotify.uint32_target_client_type.set(QFileAssistantUtils.b());
    localWlanRecvNotify.uint64_session_id.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localWlanRecvNotify.uint32_random.set(Math.abs(new Random().nextInt()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(localWlanRecvNotify);
    QLog.i("FileAssistantSender<FileAssistant>", 1, "sendWlanNotify : " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    }
    return 0L;
  }
  
  public FileManagerEntity a(Bundle paramBundle)
  {
    FileInfo localFileInfo = FileInfo.a(this.jdField_a_of_type_JavaLangString);
    if (localFileInfo == null)
    {
      QLog.e("FileAssistantSender<FileAssistant>", 1, "filePath maybe not exsited:" + this.jdField_a_of_type_JavaLangString);
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(localFileInfo);
    String str = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId = localDataLineHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = FileManagerUtil.a().longValue();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = FileManagerUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = str;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType = 51;
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("forward_origin_uni_seq", -1L);
      int i = paramBundle.getInt("forward_id", -1);
      ForwardOrderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, l, i);
    }
    ThreadManager.getFileThreadHandler().post(new FileAssistantSender.4(this, str, localFileInfo));
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "remove offlineSenderStartTimer");
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel mWlanSender");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel offlineSender");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker.d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.c = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
    FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFileAssistantResultCallbak != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "call onSendComplete");
      localFileAssistantResultCallbak.a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) && (QFileAssistantUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize)))
    {
      this.c = true;
      d();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      return;
      b(paramBoolean);
    }
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FileAssistantSender<FileAssistant>", 1, "equal id[" + paramLong + "," + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId == paramLong;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOfflineSendWorker.c();
    }
    this.c = false;
    this.d = false;
    FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFileAssistantResultCallbak != null) {
      localFileAssistantResultCallbak.a(this);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.c = false;
    this.d = false;
    QLog.i("FileAssistantSender<FileAssistant>", 1, "destory Sender:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender
 * JD-Core Version:    0.7.0.1
 */