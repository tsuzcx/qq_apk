package com.tencent.mobileqq.filemanager.excitingtransfer.downloader;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import java.util.concurrent.Executor;

public abstract class BaseDownloader
  implements IFileHttpBase, IExcitingTransferRecvListener
{
  protected int a;
  protected long a;
  protected BaseDataReport a;
  private ExcitingTransferDownloadReqInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo = null;
  protected FMSettings a;
  private boolean jdField_a_of_type_Boolean = true;
  
  public BaseDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport = a(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  protected abstract BaseDataReport a(QQAppInterface paramQQAppInterface);
  
  protected abstract void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo);
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
    finally {}
  }
  
  public void aw_()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      FileManagerUtil.FileExecutor.a().execute(new BaseDownloader.1(this));
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
      return;
    }
    finally {}
  }
  
  public void c()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport.a();
  }
  
  public void d()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport.b();
  }
  
  public void e()
  {
    b();
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Long = ExcitingTransferEngine.getInstance().recvFileEx(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo, ExcitingTransferAdapter.a().a(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
 * JD-Core Version:    0.7.0.1
 */