package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$4
  implements DownCallBack
{
  MultiRichMediaSaveManager$4(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.a);
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.c = (paramInt / 100);
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt / 100);
      }
    }
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    int i = 0;
    String str = "";
    int k;
    if (paramDownResult != null)
    {
      k = paramDownResult.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MultiRichMediaSaveManager", 2, "isFilePreDownload shortVideoReq result = " + k);
      }
      j = k;
      if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
      {
        i = paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int;
        str = paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b;
      }
    }
    for (int j = k;; j = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, j, i, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.4
 * JD-Core Version:    0.7.0.1
 */