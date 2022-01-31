package com.tencent.mobileqq.filemanager.discoperation;

import adaz;
import adba;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class DiscFileOperator
  extends FileTransferObserver
  implements IFileHttpBase
{
  final int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  public QQAppInterface a;
  FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = null;
  public FileManagerEntity a;
  DiscFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader = null;
  public FileHttpUploder a;
  public FileReportData a;
  final String jdField_a_of_type_JavaLangString = "DiscFileOperator<FileAssistant>";
  public boolean a;
  
  public DiscFileOperator(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData = new FileReportData(paramQQAppInterface.getCurrentAccountUin(), "actDiscussFileUp");
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]notifyUIRefresh[" + paramBoolean + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strApkPackageName))
        {
          str1 = str2;
          if (str2.indexOf(".apk") < 0) {
            str1 = str2 + ".apk";
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
      }
    }
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]checkParam-->Host null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      if (paramLong == 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9048L;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = "onSendDiscFile Host null";
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
        a(false);
        bool = false;
      }
    }
    while ((paramString2 != null) && (paramString2.length() != 0) && (paramString3 != null) && (paramString3.length() != 0)) {
      for (;;)
      {
        return bool;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = ((int)paramLong);
      }
    }
    QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]checkParam-->param error");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    if (paramLong == 0L) {}
    for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9005L;; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = ((int)paramLong))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = "onSendDiscFile param error";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
      a(false);
      return false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.a();
        QLog.i("DiscFileOperator<FileAssistant>.Speed", 1, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "], speed[" + str + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("DiscFileOperator<FileAssistant>", 1, "nID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],onSendDiscFile user canceled!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_d_of_type_Long = System.currentTimeMillis();
    if (!paramBoolean)
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "=_= ^! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onSendDiscFile-->failed");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      if (paramLong == -100001L) {}
      for (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9043L;; this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9045L)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = "server retError";
        if (paramString6 != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c = paramString6;
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
        a(false);
        return;
      }
    }
    QLog.d("DiscFileOperator<FileAssistant>", 2, "=_= ^> [CS Replay]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onSendDiscFile, Go [Upload Step]");
    if (!a(paramLong, paramString4, paramString3, paramString2))
    {
      QLog.d("DiscFileOperator<FileAssistant>", 2, "=_= ^! [Check Param]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]checkParam error!");
      return;
    }
    QLog.i("DiscFileOperator<FileAssistant>", 1, "=_= ^> nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "],retCode[" + String.valueOf(paramLong) + "]");
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.e("DiscFileOperator<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramString6);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, (int)paramLong, paramString6);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader = new DiscFileUploader();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader.a(paramString3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder = new FileHttpUploder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData, paramString4, paramInt, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationDiscFileUploader);
    ThreadManager.post(new adaz(this), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = paramLong.longValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Int = 3000;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.h = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    if (QLog.isColorLevel()) {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "start sendFile:" + MessageCache.a());
    }
    FileManagerUtil.FileExecutor.a().execute(new adba(this));
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9004L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.g = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
  }
  
  public void e()
  {
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileHttpUploder.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.jdField_a_of_type_Long = 9037L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.g = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDiscoperationFileReportData.c();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  public void h()
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator
 * JD-Core Version:    0.7.0.1
 */