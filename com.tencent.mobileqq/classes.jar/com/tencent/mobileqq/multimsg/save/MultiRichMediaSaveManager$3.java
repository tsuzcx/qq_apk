package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$3
  implements DownCallBack
{
  MultiRichMediaSaveManager$3(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt);
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    int j;
    int i;
    if (paramDownResult != null)
    {
      j = paramDownResult.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload picReq result = " + j);
      }
      if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
      {
        i = paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int;
        paramDownResult = paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b;
      }
    }
    for (;;)
    {
      MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, j, i, paramDownResult);
      return;
      i = 0;
      paramDownResult = "";
      continue;
      j = 0;
      i = 0;
      paramDownResult = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.3
 * JD-Core Version:    0.7.0.1
 */