package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWlanSend[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localStringBuilder.append("],filePath:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    localStringBuilder.append(",filename:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  private void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOfflineSend[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localStringBuilder.append("] use extf upload. filename:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    e();
    this.c = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
    Object localObject = new SubMsgType0x4.WlanRecvNotify();
    int i = (int)MessageCache.a();
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_time.set(i);
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint64_file_size.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    ((SubMsgType0x4.WlanRecvNotify)localObject).str_file_name.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_send_client_type.set(QFileAssistantUtils.a());
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_target_client_type.set(QFileAssistantUtils.b());
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint64_session_id.set(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    ((SubMsgType0x4.WlanRecvNotify)localObject).uint32_random.set(Math.abs(new Random().nextInt()));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a((SubMsgType0x4.WlanRecvNotify)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendWlanNotify : ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)localObject).toString());
  }
  
  public long a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.nSessionId;
    }
    return 0L;
  }
  
  public FileManagerEntity a(Bundle paramBundle)
  {
    FileInfo localFileInfo = FileInfo.a(this.jdField_a_of_type_JavaLangString);
    if (localFileInfo == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("filePath maybe not exsited:");
      paramBundle.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("FileAssistantSender<FileAssistant>", 1, paramBundle.toString());
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(localFileInfo);
    String str = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin();
    Object localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId = ((DataLineHandler)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = FileManagerUtil.a().longValue();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq = FileManagerUtil.a();
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    ((FileManagerEntity)localObject).peerUin = str;
    ((FileManagerEntity)localObject).cloudType = 3;
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).bDelInFM = true;
    ((FileManagerEntity)localObject).bSend = true;
    ((FileManagerEntity)localObject).nOpType = 51;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId)) {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "cancel offlineSender");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if ((localObject != null) && (((FileManagerEntity)localObject).status != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.c = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 3, null);
    localObject = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      QLog.i("FileAssistantSender<FileAssistant>", 1, "call onSendComplete");
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) && (QFileAssistantUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize)))
    {
      this.c = true;
      d();
    }
    else
    {
      b(paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("equal id[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localStringBuilder.append("]");
    QLog.i("FileAssistantSender<FileAssistant>", 1, localStringBuilder.toString());
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId == paramLong;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANSender;
    if (localObject != null) {
      ((WLANSender)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.c = false;
    this.d = false;
    localObject = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.c = false;
    this.d = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destory Sender:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantSender<FileAssistant>", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantSender
 * JD-Core Version:    0.7.0.1
 */