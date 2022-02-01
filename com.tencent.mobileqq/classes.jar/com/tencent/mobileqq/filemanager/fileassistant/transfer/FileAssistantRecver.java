package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcServerIP == 0) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcServerPort < 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcUrlNotify == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcUrlNotify.length == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcTokenKey == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nfcTokenKey.length == 0)) {
      return false;
    }
    return true;
  }
  
  private boolean b()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
  }
  
  private void f()
  {
    if (ExcitingTransferAdapter.a().b()) {}
    for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase = new C2CFileDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase = new FileManagerRSWorker(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity))
    {
      g();
      return;
    }
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
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doWlanRecv:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
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
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doOfflineRecv:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    f();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase.aw_();
  }
  
  private void k()
  {
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "setFileInvalid:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    ThreadManager.getUIHandler().post(new FileAssistantRecver.3(this));
    FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFileAssistantResultCallbak != null) {
      localFileAssistantResultCallbak.a(this);
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    }
    return 0L;
  }
  
  public void a()
  {
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "setFailed:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase.e();
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFileAssistantResultCallbak != null) {
      localFileAssistantResultCallbak.a(this);
    }
  }
  
  public boolean a(long paramLong)
  {
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "equal id[" + paramLong + "," + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]");
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId == paramLong;
  }
  
  public void b()
  {
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "destory:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    if (this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
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
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "userCancel:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "wlanRecver cancel");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantTransferWLANRecver.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "offlineDownloader cancel");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationIFileHttpBase.d();
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localFileAssistantResultCallbak != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "call onRecvComplete");
      localFileAssistantResultCallbak.a(this);
    }
  }
  
  public void e()
  {
    int j = 0;
    if (a())
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv NFC:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      i();
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (int i = 0;; i = 1)
    {
      if (b())
      {
        QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv Offline:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        j();
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv but info is null");
          k();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver
 * JD-Core Version:    0.7.0.1
 */