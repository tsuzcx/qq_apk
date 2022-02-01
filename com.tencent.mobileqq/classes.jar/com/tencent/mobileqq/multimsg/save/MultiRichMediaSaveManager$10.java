package com.tencent.mobileqq.multimsg.save;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq.ISaveFileCallBack;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$10
  implements QFileMultiSaveReq.ISaveFileCallBack
{
  MultiRichMediaSaveManager$10(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, QFileMultiSaveReq paramQFileMultiSaveReq) {}
  
  public void a()
  {
    Message localMessage = MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager).obtainMessage(1);
    FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a());
    if (localFileSaveResult != null)
    {
      localFileSaveResult.jdField_a_of_type_Int = 0;
      localMessage.obj = localFileSaveResult;
      MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveVideoFile fail, errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ,errorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerMultisaveQFileMultiSaveReq.a());
    if (localObject != null)
    {
      ((FileSaveResult)localObject).jdField_a_of_type_Int = -1;
      ((FileSaveResult)localObject).b = paramInt;
      ((FileSaveResult)localObject).jdField_a_of_type_JavaLangString = paramString;
      MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, (FileSaveResult)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.10
 * JD-Core Version:    0.7.0.1
 */