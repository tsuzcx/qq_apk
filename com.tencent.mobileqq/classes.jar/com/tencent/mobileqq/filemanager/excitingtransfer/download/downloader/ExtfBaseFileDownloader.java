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
  protected final int a;
  protected long a;
  protected final QQAppInterface a;
  protected final ExtfDownloadFileInfo a;
  private IExtfDownloaderSink a;
  protected ExcitingTransferDownloadCompletedInfo a;
  protected String a;
  protected boolean a;
  protected int b;
  protected long b;
  protected final long c;
  protected final long d;
  
  public ExtfBaseFileDownloader(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, ExtfDownloadFileInfo paramExtfDownloadFileInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 201;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo = paramExtfDownloadFileInfo;
    this.c = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Long != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.3(this, paramInt, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public ExcitingTransferDownloadCompletedInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
  }
  
  protected abstract ExcitingTransferDownloadConfig a();
  
  protected ExcitingTransferDownloadReqInfo a()
  {
    ExcitingTransferDownloadReqInfo localExcitingTransferDownloadReqInfo = new ExcitingTransferDownloadReqInfo();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo;
    if (localObject != null)
    {
      localExcitingTransferDownloadReqInfo.fileSize = ((ExtfDownloadFileInfo)localObject).a();
      localExcitingTransferDownloadReqInfo.md5 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a();
      localExcitingTransferDownloadReqInfo.isSupportHttps = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.b();
      localExcitingTransferDownloadReqInfo.sslCName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.d();
      localExcitingTransferDownloadReqInfo.strFileName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a() != null) {
        localExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a().toArray(new ExcitingTransferHostInfo[this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a().size()]));
      }
      localExcitingTransferDownloadReqInfo.strFileName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.a();
      localExcitingTransferDownloadReqInfo.serverPath = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.b();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("] getDownloadInfo mFileInfo = null ^^^^");
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    localExcitingTransferDownloadReqInfo.strCookie = c();
    localExcitingTransferDownloadReqInfo.strTempFilePath = b();
    localExcitingTransferDownloadReqInfo.strSaveFileDir = a();
    a(localExcitingTransferDownloadReqInfo);
    return localExcitingTransferDownloadReqInfo;
  }
  
  protected String a()
  {
    return FMSettings.a().getDefaultRecvPath();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("] stopDownloadFile ^^^^");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Long != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] *_* *_* onFailure errcode:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderIExtfDownloaderSink;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    IExtfDownloaderSink localIExtfDownloaderSink = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderIExtfDownloaderSink;
    if (localIExtfDownloaderSink != null) {
      localIExtfDownloaderSink.a(paramLong1, paramLong2, paramLong3);
    }
  }
  
  public void a(IExtfDownloaderSink paramIExtfDownloaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderIExtfDownloaderSink = paramIExtfDownloaderSink;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] ^_^ ^_^ onSuccess");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderIExtfDownloaderSink;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a(0, paramExcitingTransferDownloadCompletedInfo);
    }
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = null;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 201;
    Object localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("] startDownloadFile >>>>");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("] reqInfo   = {");
    localStringBuilder.append(((ExcitingTransferDownloadReqInfo)localObject).toString());
    localStringBuilder.append("}");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, localStringBuilder.toString());
    long l = ExcitingTransferEngine.getInstance().recvFileEx((ExcitingTransferDownloadReqInfo)localObject, a(), this);
    if (l == -1L)
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("] startDownloadFile fail");
      QLog.e("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = l;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] startDownloadFile excitingId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  protected abstract String b();
  
  protected String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cookie:t=0;v=");
      localStringBuilder.append(AppSetting.a());
      localStringBuilder.append(";");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo.c());
      localStringBuilder.append(";\r\n");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.d);
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
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderIExtfDownloaderSink;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a(paramInt, paramExcitingTransferOneSlotComplete);
    }
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
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
    localStringBuilder.append(this.d);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderExtfDownloadFileInfo;
      if (localObject != null) {
        this.jdField_b_of_type_Long = ((ExtfDownloadFileInfo)localObject).a();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = 0L;
    Object localObject = str;
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      localObject = paramExcitingTransferDownloadCompletedInfo.mstrLastServerHost;
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (bool)
    {
      ThreadManager.post(new ExtfBaseFileDownloader.2(this, paramExcitingTransferDownloadCompletedInfo), 5, null, false);
      return;
    }
    b(paramInt, paramExcitingTransferDownloadCompletedInfo);
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Long = paramLong2;
    ThreadManager.post(new ExtfBaseFileDownloader.1(this, paramLong1, paramLong3), 5, null, false);
  }
  
  public void onRecvStart()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] onExcitingSendStart.");
    QLog.i("ExcitingTransfer.BaseDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferDownloadDownloaderIExtfDownloaderSink;
    if (localObject != null) {
      ((IExtfDownloaderSink)localObject).a();
    }
  }
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManager.post(new ExtfBaseFileDownloader.4(this, paramExcitingTransferDownloadSpeedInfo), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.download.downloader.ExtfBaseFileDownloader
 * JD-Core Version:    0.7.0.1
 */