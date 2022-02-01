package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class WLANRecver
{
  QQAppInterface a;
  FileManagerEntity b;
  
  public WLANRecver(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.a = paramQQAppInterface;
    this.b = paramFileManagerEntity;
  }
  
  public void a()
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).k(32);
  }
  
  public void b()
  {
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(this.b.dlGroupId, this.b.nSessionId, false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userCancel:");
    localStringBuilder.append(this.b.nSessionId);
    localStringBuilder.append(", grpId:");
    localStringBuilder.append(this.b.dlGroupId);
    localStringBuilder.append(",");
    QLog.w("WLANRecver<FileAssistant>", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.WLANRecver
 * JD-Core Version:    0.7.0.1
 */