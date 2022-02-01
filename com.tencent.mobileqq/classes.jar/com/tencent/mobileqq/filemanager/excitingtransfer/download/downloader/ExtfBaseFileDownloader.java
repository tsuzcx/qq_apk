package com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class ExtfBaseFileDownloader
  implements IExcitingTransferRecvListener
{
  protected boolean a = true;
  protected long b = 0L;
  protected long c = 0L;
  protected final QQAppInterface d;
  protected final long e;
  protected final int f;
  protected final long g;
  protected final ExtfDownloadFileInfo h;
  protected ExcitingTransferDownloadCompletedInfo i;
  protected int j = 201;
  protected String k = "";
  private IExtfDownloaderSink l;
  
  public ExtfBaseFileDownloader(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, ExtfDownloadFileInfo paramExtfDownloadFileInfo)
  {
    this.d = paramQQAppInterface;
    this.g = paramLong1;
    this.h = paramExtfDownloadFileInfo;
    this.e = paramLong2;
    this.f = paramInt;
    this.a = true;
  }
  
  private void b(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.a) {
      return;
    }
    if (this.b != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.b);
      this.b = 0L;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.3(this, paramInt, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
  }
  
  protected abstract ExcitingTransferDownloadConfig a();
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("] *_* *_* onFailure errcode:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.l;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    IExtfDownloaderSink localIExtfDownloaderSink = this.l;
    if (localIExtfDownloaderSink != null) {
      localIExtfDownloaderSink.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(IExtfDownloaderSink paramIExtfDownloaderSink)
  {
    this.l = paramIExtfDownloaderSink;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("] ^_^ ^_^ onSuccess");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.l;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a(0, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  public boolean b()
  {
    this.i = null;
    this.c = 0L;
    this.j = 201;
    Object localObject = g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("] startDownloadFile >>>>");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("] reqInfo   = {");
    localStringBuilder.append(((ExcitingTransferDownloadReqInfo)localObject).toString());
    localStringBuilder.append("}");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    long l1 = ExcitingTransferEngine.getInstance().recvFileEx((ExcitingTransferDownloadReqInfo)localObject, a(), this);
    if (l1 == -1L)
    {
      this.a = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("] startDownloadFile fail");
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.a = false;
    this.b = l1;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("] startDownloadFile excitingId:");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  public void c()
  {
    if (this.a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("] stopDownloadFile ^^^^");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    this.a = true;
    if (this.b != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.b);
      this.b = 0L;
    }
  }
  
  protected String d()
  {
    return FMSettings.a().getDefaultRecvPath();
  }
  
  protected abstract String e();
  
  protected String f()
  {
    if (this.h != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cookie:t=0;v=");
      localStringBuilder.append(AppSetting.d());
      localStringBuilder.append(";");
      localStringBuilder.append(this.h.g());
      localStringBuilder.append(";\r\n");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  protected ExcitingTransferDownloadReqInfo g()
  {
    ExcitingTransferDownloadReqInfo localExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
    Object localObject = this.h;
    if (localObject != null)
    {
      localExcitingTransferDownloadReqInfo.fileSize = ((ExtfDownloadFileInfo)localObject).c();
      localExcitingTransferDownloadReqInfo.md5 = this.h.d();
      localExcitingTransferDownloadReqInfo.isSupportHttps = this.h.h();
      localExcitingTransferDownloadReqInfo.sslCName = this.h.i();
      localExcitingTransferDownloadReqInfo.strFileName = this.h.b();
      if (this.h.e() != null) {
        localExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])this.h.e().toArray(new ExcitingTransferHostInfo[this.h.e().size()]));
      }
      localExcitingTransferDownloadReqInfo.strFileName = this.h.b();
      localExcitingTransferDownloadReqInfo.serverPath = this.h.f();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("] getDownloadInfo mFileInfo = null ^^^^");
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    localExcitingTransferDownloadReqInfo.strCookie = f();
    localExcitingTransferDownloadReqInfo.strTempFilePath = e();
    localExcitingTransferDownloadReqInfo.strSaveFileDir = d();
    a(localExcitingTransferDownloadReqInfo);
    return localExcitingTransferDownloadReqInfo;
  }
  
  public long h()
  {
    return this.c;
  }
  
  public ExcitingTransferDownloadCompletedInfo i()
  {
    return this.i;
  }
  
  public int j()
  {
    return this.j;
  }
  
  public void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (this.a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("] ^_^ OnOneSlotComplete:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" RP:");
    String str = "";
    if (paramExcitingTransferOneSlotComplete != null) {
      localObject = paramExcitingTransferOneSlotComplete.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    Object localObject = str;
    if (paramExcitingTransferOneSlotComplete != null) {
      localObject = paramExcitingTransferOneSlotComplete.mstrIp;
    }
    this.k = ((String)localObject);
    localObject = this.l;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a(paramInt, paramExcitingTransferOneSlotComplete);
    }
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.a) {
      return;
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("] onExcitingDownloadResult suc:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" RP:");
    String str = "";
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      localObject = paramExcitingTransferDownloadCompletedInfo.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    if (bool)
    {
      localObject = this.h;
      if (localObject != null) {
        this.c = ((ExtfDownloadFileInfo)localObject).c();
      }
    }
    this.i = paramExcitingTransferDownloadCompletedInfo;
    this.j = paramInt;
    this.b = 0L;
    Object localObject = str;
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      localObject = paramExcitingTransferDownloadCompletedInfo.mstrLastServerHost;
    }
    this.k = ((String)localObject);
    if (bool)
    {
      ThreadManager.post(new ExtfBaseFileDownloader.2(this, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
      return;
    }
    b(paramInt, paramExcitingTransferDownloadCompletedInfo);
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.a) {
      return;
    }
    this.c = paramLong2;
    ThreadManager.post(new ExtfBaseFileDownloader.1(this, paramLong1, paramLong3), 5, null, false);
  }
  
  public void onRecvStart()
  {
    if (this.a) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("] onExcitingSendStart.");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.l;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).c();
    }
  }
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if (this.a) {
      return;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.4(this, paramExcitingTransferDownloadSpeedInfo), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader
 * JD-Core Version:    0.7.0.1
 */