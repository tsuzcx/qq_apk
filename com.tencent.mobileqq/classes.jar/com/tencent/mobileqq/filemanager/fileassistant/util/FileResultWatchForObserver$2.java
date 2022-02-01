package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.qphone.base.util.QLog;

class FileResultWatchForObserver$2
  extends FMObserver
{
  FileResultWatchForObserver$2(FileResultWatchForObserver paramFileResultWatchForObserver, QQAppInterface paramQQAppInterface) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramLong2 + " transfer end, isSucc:" + paramBoolean);
    if (!paramBoolean) {
      return;
    }
    paramString2 = QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramString2 == null)
    {
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramLong2 + " transfer end, datalineUin is null");
      return;
    }
    if (!paramString2.equalsIgnoreCase(paramString1))
    {
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramLong2 + " transfer end, is not datalineUin");
      return;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    if (!FileResultWatchForObserver.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileassistantUtilFileResultWatchForObserver, paramString1))
    {
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramLong2 + " transfer end, is not send to old dataline");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(paramString1);
    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, paramLong2 + " transfer end, forward to old dataline");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.FileResultWatchForObserver.2
 * JD-Core Version:    0.7.0.1
 */