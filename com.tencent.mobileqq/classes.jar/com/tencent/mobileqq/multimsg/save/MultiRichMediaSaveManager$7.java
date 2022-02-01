package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$7
  extends UiCallBack.DownAdapter
{
  MultiRichMediaSaveManager$7(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, String paramString, FileSaveReq paramFileSaveReq) {}
  
  public void a(int paramInt)
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
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadShortVideo key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt);
    }
    int j = 0;
    String str2 = "";
    String str1 = str2;
    int i = j;
    if (paramShortVideoResult != null)
    {
      str1 = str2;
      i = j;
      if (paramShortVideoResult.a != null)
      {
        i = paramShortVideoResult.a.a;
        str1 = paramShortVideoResult.a.b;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt, i, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.7
 * JD-Core Version:    0.7.0.1
 */