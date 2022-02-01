package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class OnlineFileSessionWorker$StateBase
{
  protected StateBase a;
  protected boolean a;
  protected boolean b;
  
  OnlineFileSessionWorker$StateBase(OnlineFileSessionWorker paramOnlineFileSessionWorker)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = this;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  StateBase a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase;
  }
  
  protected String a()
  {
    return "StateBase";
  }
  
  protected void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onResumeTrans. ");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(int paramInt)
  {
    Object localObject;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("unknow:");
              ((StringBuilder)localObject).append(String.valueOf(paramInt));
              localObject = ((StringBuilder)localObject).toString();
            }
            else
            {
              localObject = "(pc change to off trans)";
            }
          }
          else {
            localObject = "(pc save to weiyun)";
          }
        }
        else {
          localObject = "(pc cancel send";
        }
      }
      else {
        localObject = "(pc refuse)";
      }
    }
    else {
      localObject = "(pc accept)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("] state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onFileRequestBeHandledByPC.handleType = ");
    localStringBuilder.append((String)localObject);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onSenderUploadProgressNotify. speed:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" progress:");
    localStringBuilder.append(paramInt2);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onSenderUploadException. errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" resason:");
    localStringBuilder.append(paramString);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(long paramLong) {}
  
  protected final void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a());
    localStringBuilder.append("->");
    localStringBuilder.append(paramString);
    localStringBuilder.append(")");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onRecvOnLineFileResult. ret:");
    localStringBuilder.append(paramBoolean);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onRecvOnLineFile.");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    return true;
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      paramString = new StringBuilder();
      paramString.append("OLfilesession[");
      paramString.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      paramString.append("]. recvOnLineFile entity is null");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramString);
    paramString = new StringBuilder();
    paramString.append("OLfilesession[");
    paramString.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    paramString.append("]  state:");
    paramString.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    paramString.append(" can not handle onSenderUploadCompleted. type:");
    paramString.append(paramInt);
    paramString.append("time:");
    paramString.append(paramLong);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, paramString.toString());
    return false;
  }
  
  protected final boolean a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      localStringBuilder.append("]. state:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a());
      localStringBuilder.append(paramString);
      localStringBuilder.append(" entity is null ");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onSenderCancelUpload. ");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onFailedOfLocalSomeThingHappen. type:");
    localStringBuilder.append(paramInt);
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected final void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] make progress entity = null.handleProgressNotify");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramInt2 > 100)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] handleProgressNotify progress > 100. progress=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramInt1 == 0) {}
    while ((paramInt2 <= this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress) && ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress != 0) || (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed > 1.0E-007F)))
    {
      i = 1;
      break;
    }
    int i = 0;
    long l = System.currentTimeMillis();
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("]  handleProgressNotify. state:");
      ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
      ((StringBuilder)localObject).append(". averspeed = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(". progress = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(". nOlSenderProgress =");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress);
      ((StringBuilder)localObject).append(". err notify. return");
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      if (-1 == this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress)
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress = 0;
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = l;
        if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 14) && (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 15))
        {
          this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          return;
        }
        localObject = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
        ((FileManagerEntity)localObject).status = 11;
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
      }
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    b(l);
    float f1 = (100 - paramInt2) / 100.0F / (paramInt1 * 1024 / (float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    float f2 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed = ((0.9F - f2) / f1);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = l;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress = paramInt2;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OLfilesession[");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("]  -----handleProgressNotify. state:");
    ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    ((StringBuilder)localObject).append(". averspeed = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(". progress = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(". fOlRecvSpeed = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed);
    ((StringBuilder)localObject).append("f/s. fOlRecvProgressOnNotify =");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 14) && (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 15))
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.clone();
    ((FileManagerEntity)localObject).status = 11;
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c((FileManagerEntity)localObject);
  }
  
  protected final void b(long paramLong)
  {
    Object localObject;
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] make progress entity = null.makeProgress");
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.b()) {
      return;
    }
    long l1;
    if (0L == this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.d)
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker;
      ((OnlineFileSessionWorker)localObject).d = 102400L;
      l1 = ((OnlineFileSessionWorker)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      long l2 = ((float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize * 0.1F);
      if (l1 > 104857600L)
      {
        localObject = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker;
        ((OnlineFileSessionWorker)localObject).d = (l2 / 60L);
        if (l1 > 524288000L)
        {
          ((OnlineFileSessionWorker)localObject).d = (l2 / 120L);
          if (l1 > 1073741824L) {
            ((OnlineFileSessionWorker)localObject).d = (l2 / 180L);
          }
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] initGoSpeed =");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.d);
      ((StringBuilder)localObject).append("b/s");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    float f1 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvSpeed;
    if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a())
    {
      double d1 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      double d2 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify;
      Double.isNaN(d2);
      Double.isNaN(d1);
      l1 = (d1 * (1.0D - d2) / 102400.0D * 2000.0D);
      f1 = (float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.d / (float)this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    }
    else
    {
      l1 = ((0.9F - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify) * 2000.0F / f1);
    }
    if (l1 <= 30000L) {
      l1 = 30000L;
    }
    if (paramLong - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime > l1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] state:");
      ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
      ((StringBuilder)localObject).append(" the progress maker think time out. timeOutInterval=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("curRecvSpeed = ");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(".lastTime =");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
      ((StringBuilder)localObject).append(". makeTime =");
      ((StringBuilder)localObject).append(paramLong);
      QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a())
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a(true, 0L);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a(true, 0L);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    float f2 = (float)(paramLong - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) / 1000.0F;
    float f3 = f1 * f2;
    float f4 = this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify + f3;
    if (!this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.a())
    {
      if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress <= 0.1F)
      {
        if (Math.abs(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress - 0.1F) < 1.0E-008D) {
          return;
        }
        if (f4 > 0.1F) {
          this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.1F;
        } else {
          this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = f4;
        }
      }
    }
    else
    {
      if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress > 0.9F) {
        return;
      }
      if (Math.abs(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress - 0.9F) < 1.0E-008D) {
        return;
      }
      if (f4 > 0.9F) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.9F;
      } else {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = f4;
      }
    }
    if (paramLong - this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.c > 50000L)
    {
      this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.c = paramLong;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OLfilesession[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] -----state:");
      ((StringBuilder)localObject).append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
      ((StringBuilder)localObject).append(" the making progress of upload is: ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress);
      ((StringBuilder)localObject).append("[curRecvSpeed=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(".maketime=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(".lastTime=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime);
      ((StringBuilder)localObject).append("f/s. makeTime_s=");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append("s. addProgress = ");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(". timeOutInterval=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(". filesize=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      ((StringBuilder)localObject).append(". nOlSenderProgress=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress);
      ((StringBuilder)localObject).append(". fOlRecvProgressOnNotify =");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fOlRecvProgressOnNotify);
      ((StringBuilder)localObject).append(" ] ");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean == true)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("OLfilesession[");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
      localStringBuilder.append("] state change :(");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a());
      localStringBuilder.append(" recv  success response of ask progress");
      QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a());
    localStringBuilder.append(" recv  failed response of ask progress");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.c();
    h();
  }
  
  protected void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onPauseTrans. ");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onSenderReplayComeOnRecv:");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle onRecvButSenderReplayTimeOut:");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("]  state:");
    localStringBuilder.append(OnlineFileSessionWorker.a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker).a());
    localStringBuilder.append(" can not handle doSomeThingOnUploadDone:");
    QLog.w("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
  }
  
  protected void g() {}
  
  protected void h()
  {
    a(4, null);
  }
  
  protected void i()
  {
    a(3, null);
  }
  
  protected void j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OLfilesession[");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker.jdField_a_of_type_Long);
    localStringBuilder.append("] state change :(");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase.a());
    localStringBuilder.append("->StateEnd)");
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker$StateBase = new OnlineFileSessionWorker.StateEnd(this.jdField_b_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionWorker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OnlineFileSessionWorker.StateBase
 * JD-Core Version:    0.7.0.1
 */