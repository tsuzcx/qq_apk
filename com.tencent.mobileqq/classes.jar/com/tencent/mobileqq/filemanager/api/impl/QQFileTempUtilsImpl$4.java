package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class QQFileTempUtilsImpl$4
  extends DataLineObserver
{
  private Map<Long, FileManagerEntity> b = new HashMap();
  
  QQFileTempUtilsImpl$4(QQFileTempUtilsImpl paramQQFileTempUtilsImpl) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    FileManagerEntity localFileManagerEntity = b(paramLong);
    if (localFileManagerEntity == null) {
      return;
    }
    localFileManagerEntity.fProgress = paramFloat;
    this.a.notifyItemStatus(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, AppConstants.DATALINE_PC_UIN, 6000, 16, null, 0, null);
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramString = b(paramLong1);
    if (paramString == null) {
      return;
    }
    paramString.status = 2;
    this.a.notifyItemStatus(paramString.uniseq, paramString.nSessionId, AppConstants.DATALINE_PC_UIN, 6000, 10, null, 0, null);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    paramString = b(paramLong);
    if (paramString == null) {
      return;
    }
    if (paramBoolean) {
      paramString.status = 1;
    } else {
      paramString.status = 0;
    }
    ((IQQFileDataCenter)((QQAppInterface)this.a.getApp()).getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onRecvFile,entity.cloudtype:");
    ((StringBuilder)localObject).append(paramString.cloudType);
    ((StringBuilder)localObject).append(",filepath:");
    ((StringBuilder)localObject).append(paramString.getFilePath());
    QLog.e("QQFileTempUtilsImpl<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    localObject = this.a;
    paramLong = paramString.uniseq;
    long l = paramString.nSessionId;
    paramString = AppConstants.DATALINE_PC_UIN;
    int i;
    if (paramBoolean) {
      i = 11;
    } else {
      i = 12;
    }
    ((QQFileTempUtilsImpl)localObject).notifyItemStatus(paramLong, l, paramString, 6000, i, null, 0, null);
  }
  
  FileManagerEntity b(long paramLong)
  {
    if (this.b.containsKey(Long.valueOf(paramLong))) {
      return (FileManagerEntity)this.b.get(Long.valueOf(paramLong));
    }
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)this.a.getApp()).getFileManagerDataCenter().a(paramLong, AppConstants.DATALINE_PC_UIN, 6000, -1L);
    this.b.put(Long.valueOf(paramLong), localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.b(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramString = b(paramLong1);
    if (paramString == null) {
      return;
    }
    paramString.status = 2;
    this.a.notifyItemStatus(paramString.uniseq, paramString.nSessionId, AppConstants.DATALINE_PC_UIN, 6000, 10, null, 0, null);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    super.a(paramBoolean, paramLong, paramString);
    paramString = b(paramLong);
    if (paramString == null) {
      return;
    }
    if (paramBoolean) {
      paramString.status = 1;
    } else {
      paramString.status = 0;
    }
    ((IQQFileDataCenter)this.a.getApp().getRuntimeService(IQQFileDataCenter.class, "")).updateFileEntity(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onSendFile,entity.cloudtype:");
    ((StringBuilder)localObject).append(paramString.cloudType);
    ((StringBuilder)localObject).append(",filepath:");
    ((StringBuilder)localObject).append(paramString.getFilePath());
    QLog.e("QQFileTempUtilsImpl<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    localObject = this.a;
    paramLong = paramString.uniseq;
    long l = paramString.nSessionId;
    paramString = AppConstants.DATALINE_PC_UIN;
    int i;
    if (paramBoolean) {
      i = 11;
    } else {
      i = 12;
    }
    ((QQFileTempUtilsImpl)localObject).notifyItemStatus(paramLong, l, paramString, 6000, i, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl.4
 * JD-Core Version:    0.7.0.1
 */