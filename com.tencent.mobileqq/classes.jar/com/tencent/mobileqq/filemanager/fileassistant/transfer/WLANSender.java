package com.tencent.mobileqq.filemanager.fileassistant.transfer;

import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IThumbResult;
import java.util.concurrent.Executor;

public class WLANSender
  implements FileManagerUtil.IThumbResult
{
  Session jdField_a_of_type_ComTencentLitetransfersdkSession = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  boolean jdField_a_of_type_Boolean = false;
  
  public void a()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.dlGroupId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    FileManagerUtil.a(paramFileManagerEntity.getFilePath(), 384, 384, this);
  }
  
  public void a(String paramString)
  {
    paramString = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    FileManagerUtil.FileExecutor.a().execute(new WLANSender.1(this, paramString));
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentLitetransfersdkSession == null) {}
    while (this.jdField_a_of_type_ComTencentLitetransfersdkSession.uSessionID != paramLong) {
      return false;
    }
    return true;
  }
  
  public void b()
  {
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.transfer.WLANSender
 * JD-Core Version:    0.7.0.1
 */