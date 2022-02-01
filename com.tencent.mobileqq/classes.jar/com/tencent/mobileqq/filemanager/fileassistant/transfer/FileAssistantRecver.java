package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CFileDownloader;
import com.tencent.mobileqq.filemanager.fileassistant.data.FileAssistantResultCallbak;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class FileAssistantRecver
{
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  IFileHttpBase jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase = null;
  WLANRecver jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver = null;
  private WeakReference<FileAssistantResultCallbak> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  FileAssistantRecver(QQAppInterface paramQQAppInterface, FileAssistantResultCallbak paramFileAssistantResultCallbak, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFileAssistantResultCallbak);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcServerIP == 0) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcServerPort < 0) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcUrlNotify != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcUrlNotify.length == 0) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcTokenKey != null) {
        return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcTokenKey.length != 0;
      }
    }
    return false;
  }
  
  private boolean b()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
  }
  
  private void f()
  {
    if (((IExcitingTransferAdapter)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IExcitingTransferAdapter.class, "")).isEnableC2CDownload()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase = new C2CFileDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    g();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new FileAssistantRecver.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  private void h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWlanRecv:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
    i();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver = new WLANRecver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null)
    {
      QLog.w("FileAssistantRecver<FileAssistant>.NFRV", 1, "why initObserver call two times?");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new FileAssistantRecver.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  private void j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOfflineRecv:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
    f();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase.g();
  }
  
  private void k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFileInvalid:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    ThreadManager.getUIHandler().post(new FileAssistantRecver.3(this));
    localObject = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public long a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.nSessionId;
    }
    return 0L;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFailed:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver;
    if (localObject != null) {
      ((WLANRecver)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase;
    if (localObject != null) {
      ((IFileHttpBase)localObject).e();
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    localObject = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public boolean a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("equal id[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localStringBuilder.append("]");
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId == paramLong;
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destory:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv entiry is null!");
      FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFileAssistantResultCallbak != null) {
        localFileAssistantResultCallbak.a(this);
      }
      return;
    }
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, wlanInfo is full");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver == null) {
      h();
    }
    if (b())
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, offlineInfo is full");
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isStartWlan)
      {
        j();
        return;
      }
    }
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, unknow download type");
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "wlanRecver cancel");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "offlineDownloader cancel");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase.f();
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localObject = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "call onRecvComplete");
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void e()
  {
    StringBuilder localStringBuilder;
    int i;
    if (a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doRetryRecv NFC:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
      i();
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      i = 0;
    }
    else
    {
      i = 1;
    }
    if (b())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doRetryRecv Offline:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
      j();
      i = 0;
    }
    if (i != 0)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv but info is null");
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver
 * JD-Core Version:    0.7.0.1
 */