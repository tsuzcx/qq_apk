package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.filemanager.multisave.QFileMultiSaveReq;
import com.tencent.mobileqq.filemanager.multisave.QFileSaveReqUiCallback;

class MultiRichMediaSaveManager$5
  implements QFileSaveReqUiCallback
{
  MultiRichMediaSaveManager$5(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq != null) && (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.a();
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.5
 * JD-Core Version:    0.7.0.1
 */