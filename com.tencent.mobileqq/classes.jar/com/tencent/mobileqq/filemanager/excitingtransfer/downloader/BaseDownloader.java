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
  protected BaseDataReport a = a(paramQQAppInterface);
  protected int b = 0;
  protected IFMSettings c = null;
  protected long d = -1L;
  private ExcitingTransferDownloadReqInfo e = null;
  private boolean f = true;
  
  public BaseDownloader(QQAppInterface paramQQAppInterface) {}
  
  protected abstract BaseDataReport a(QQAppInterface paramQQAppInterface);
  
  protected abstract void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo);
  
  public boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally {}
  }
  
  public int b()
  {
    return 1;
  }
  
  protected void d()
  {
    this.d = ExcitingTransferEngine.getInstance().recvFileEx(this.e, ((IExcitingTransferAdapter)QQFileManagerUtil.f().getRuntimeService(IExcitingTransferAdapter.class, "")).getC2CDownloadConfig(), this);
  }
  
  public void f()
  {
    try
    {
      this.f = true;
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.d);
      return;
    }
    finally {}
  }
  
  public void j()
  {
    f();
    this.a.d();
  }
  
  public void k()
  {
    f();
  }
  
  public void l()
  {
    f();
    this.a.e();
  }
  
  public void m()
  {
    try
    {
      this.f = false;
      QQFileManagerUtil.FileExecutor.a().execute(new BaseDownloader.1(this));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.downloader.BaseDownloader
 * JD-Core Version:    0.7.0.1
 */