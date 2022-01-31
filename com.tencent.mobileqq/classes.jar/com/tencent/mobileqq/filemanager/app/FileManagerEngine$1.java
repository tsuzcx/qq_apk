package com.tencent.mobileqq.filemanager.app;

import aodw;
import aoig;
import aoik;
import apck;
import awao;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FileManagerEngine$1
  implements Runnable
{
  public FileManagerEngine$1(aodw paramaodw, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, long paramLong) {}
  
  public void run()
  {
    apck.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.a.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, true, this.c, 0L, true, this.jdField_a_of_type_Int, this.d, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgSeq, null, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, -1L, awao.a());
    }
    if (this.jdField_a_of_type_Boolean) {
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] SendLocalfile[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "], peerType[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType + "]");
    }
    for (;;)
    {
      this.this$0.a.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      QLog.i("FileManagerEngine<FileAssistant>", 1, "=_=k Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] SendLocalfileToWeiyun[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */