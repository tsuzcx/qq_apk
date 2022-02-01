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
  IFileHttpBase a = null;
  WLANRecver b = null;
  private QQAppInterface c;
  private WeakReference<FileAssistantResultCallbak> d;
  private DataLineObserver e = null;
  private FMObserver f = null;
  private FileManagerEntity g;
  private boolean h = false;
  private boolean i = false;
  
  FileAssistantRecver(QQAppInterface paramQQAppInterface, FileAssistantResultCallbak paramFileAssistantResultCallbak, FileManagerEntity paramFileManagerEntity)
  {
    this.c = paramQQAppInterface;
    this.d = new WeakReference(paramFileAssistantResultCallbak);
    this.g = paramFileManagerEntity;
  }
  
  private void g()
  {
    if (((IExcitingTransferAdapter)this.c.getRuntimeService(IExcitingTransferAdapter.class, "")).isEnableC2CDownload()) {
      this.a = new C2CFileDownloader(this.c, this.g);
    } else {
      this.a = new FileManagerRSWorker(this.c, this.g);
    }
    h();
  }
  
  private void h()
  {
    if (this.f != null) {
      return;
    }
    this.f = new FileAssistantRecver.1(this);
    this.c.getFileManagerNotifyCenter().addObserver(this.f);
  }
  
  private void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWlanRecv:");
    localStringBuilder.append(this.g.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
    j();
    this.b = new WLANRecver(this.c, this.g);
  }
  
  private void j()
  {
    if (this.e != null)
    {
      QLog.w("FileAssistantRecver<FileAssistant>.NFRV", 1, "why initObserver call two times?");
      return;
    }
    this.e = new FileAssistantRecver.2(this);
    this.c.addObserver(this.e);
  }
  
  private boolean k()
  {
    if (this.g.nfcServerIP == 0) {
      return false;
    }
    if (this.g.nfcServerPort < 0) {
      return false;
    }
    if (this.g.nfcUrlNotify != null)
    {
      if (this.g.nfcUrlNotify.length == 0) {
        return false;
      }
      if (this.g.nfcTokenKey != null) {
        return this.g.nfcTokenKey.length != 0;
      }
    }
    return false;
  }
  
  private void l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOfflineRecv:");
    localStringBuilder.append(this.g.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
    g();
    this.h = true;
    this.a.m();
  }
  
  private boolean m()
  {
    return !TextUtils.isEmpty(this.g.Uuid);
  }
  
  private void n()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFileInvalid:");
    ((StringBuilder)localObject).append(this.g.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    this.g.status = 16;
    this.c.getFileManagerDataCenter().c(this.g);
    ThreadManager.getUIHandler().post(new FileAssistantRecver.3(this));
    localObject = (FileAssistantResultCallbak)this.d.get();
    if (localObject != null) {
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFailed:");
    ((StringBuilder)localObject).append(this.g.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (localObject != null) {
      ((WLANRecver)localObject).a();
    }
    localObject = this.a;
    if (localObject != null) {
      ((IFileHttpBase)localObject).k();
    }
    this.h = false;
    this.i = false;
    localObject = (FileAssistantResultCallbak)this.d.get();
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
    localStringBuilder.append(this.g.nSessionId);
    localStringBuilder.append("]");
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
    return this.g.nSessionId == paramLong;
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destory:");
    ((StringBuilder)localObject).append(this.g.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    this.h = false;
    this.i = false;
    localObject = this.e;
    if (localObject != null)
    {
      this.c.removeObserver((BusinessObserver)localObject);
      this.e = null;
    }
    if (this.f != null)
    {
      this.c.getFileManagerNotifyCenter().deleteObserver(this.f);
      this.f = null;
    }
  }
  
  public void c()
  {
    if (this.g == null)
    {
      QLog.e("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv entiry is null!");
      FileAssistantResultCallbak localFileAssistantResultCallbak = (FileAssistantResultCallbak)this.d.get();
      if (localFileAssistantResultCallbak != null) {
        localFileAssistantResultCallbak.a(this);
      }
      return;
    }
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, wlanInfo is full");
    if (this.b == null) {
      i();
    }
    if (m())
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, offlineInfo is full");
      if (!this.g.isStartWlan)
      {
        l();
        return;
      }
    }
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRecv, unknow download type");
  }
  
  public void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("userCancel:");
    ((StringBuilder)localObject).append(this.g.nSessionId);
    QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, ((StringBuilder)localObject).toString());
    if (this.b != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "wlanRecver cancel");
      this.b.b();
    }
    if (this.a != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "offlineDownloader cancel");
      this.a.l();
    }
    this.h = false;
    this.i = false;
    this.g.status = 3;
    this.c.getFileManagerDataCenter().c(this.g);
    localObject = (FileAssistantResultCallbak)this.d.get();
    if (localObject != null)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "call onRecvComplete");
      ((FileAssistantResultCallbak)localObject).a(this);
    }
  }
  
  public void e()
  {
    StringBuilder localStringBuilder;
    int j;
    if (k())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doRetryRecv NFC:");
      localStringBuilder.append(this.g.nSessionId);
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
      j();
      ((DataLineHandler)this.c.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).e(this.g);
      j = 0;
    }
    else
    {
      j = 1;
    }
    if (m())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doRetryRecv Offline:");
      localStringBuilder.append(this.g.nSessionId);
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, localStringBuilder.toString());
      l();
      j = 0;
    }
    if (j != 0)
    {
      QLog.i("FileAssistantRecver<FileAssistant>.NFRV", 1, "doRetryRecv but info is null");
      n();
    }
  }
  
  public long f()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.nSessionId;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.FileAssistantRecver
 * JD-Core Version:    0.7.0.1
 */