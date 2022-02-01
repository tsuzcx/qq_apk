package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.filemanager.multisave.QFileSaveReqUiCallback;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$9
  implements QFileSaveReqUiCallback
{
  MultiRichMediaSaveManager$9(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, String paramString, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq;
    if ((localObject != null) && (((FileSaveReq)localObject).a != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.a();
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a((String)localObject);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a((String)localObject, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadFile key = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.9
 * JD-Core Version:    0.7.0.1
 */