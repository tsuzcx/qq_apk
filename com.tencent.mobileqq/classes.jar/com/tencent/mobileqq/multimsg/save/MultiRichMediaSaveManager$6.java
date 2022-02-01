package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$6
  extends UiCallBack.DownAdapter
{
  MultiRichMediaSaveManager$6(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, String paramString, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadPic key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramPicResult != null)
    {
      str1 = str2;
      i = j;
      if (paramPicResult.a != null)
      {
        i = paramPicResult.a.a;
        str1 = paramPicResult.a.b;
      }
    }
    MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt, i, str1);
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.6
 * JD-Core Version:    0.7.0.1
 */