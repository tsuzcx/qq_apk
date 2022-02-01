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
    int j = 0;
    String str = "";
    int i;
    if (paramDownResult != null)
    {
      int k = paramDownResult.jdField_a_of_type_Int;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isFilePreDownload picReq result = ");
        localStringBuilder.append(k);
        QLog.d("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
      }
      i = k;
      if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
      {
        j = paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int;
        str = paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b;
        i = k;
      }
    }
    else
    {
      i = 0;
    }
    MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, i, j, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.3
 * JD-Core Version:    0.7.0.1
 */