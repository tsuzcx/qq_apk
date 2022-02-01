package com.tencent.mobileqq.filemanager.excitingtransfer.downloader;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.FileExecutor;
import java.util.concurrent.Executor;

public abstract class BaseDownloader
  implements IFileHttpBase, IExcitingTransferRecvListener
{
  protected int a;
  protected long a;
  protected IFMSettings a;
  protected BaseDataReport a;
  private ExcitingTransferDownloadReqInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo = null;
  private boolean jdField_a_of_type_Boolean = true;
  
  public BaseDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFMSettings = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport = a(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  protected abstract BaseDataReport a(QQAppInterface paramQQAppInterface);
  
  protected void a()
  {
    this.jdField_a_of_type_Long = ExcitingTransferEngine.getInstance().recvFileEx(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo, ((IExcitingTransferAdapter)QQFileManagerUtil.a().getRuntimeService(IExcitingTransferAdapter.class, "")).getC2CDownloadConfig(), this);
  }
  
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
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
      return;
    }
    finally {}
  }
  
  public void d()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport.a();
  }
  
  public void e()
  {
    c();
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferBaseDataReport.b();
  }
  
  public void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      QQFileManagerUtil.FileExecutor.a().execute(new BaseDownloader.1(this));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
 * JD-Core Version:    0.7.0.1
 */