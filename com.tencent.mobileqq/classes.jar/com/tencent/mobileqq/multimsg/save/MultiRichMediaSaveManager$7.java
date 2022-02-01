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
        paramInt /= 100;
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
      }
    }
  }
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadShortVideo key = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    int i = 0;
    if ((paramShortVideoResult != null) && (paramShortVideoResult.a != null))
    {
      i = paramShortVideoResult.a.a;
      paramShortVideoResult = paramShortVideoResult.a.b;
    }
    else
    {
      paramShortVideoResult = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt, i, paramShortVideoResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.7
 * JD-Core Version:    0.7.0.1
 */