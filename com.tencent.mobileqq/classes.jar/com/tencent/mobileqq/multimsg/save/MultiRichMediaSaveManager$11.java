package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$11
  extends UiCallBack.DownAdapter
{
  MultiRichMediaSaveManager$11(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString1, String paramString2) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadRawImage id = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", result = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (!((FileSaveResult)localObject).jdField_a_of_type_Boolean))
    {
      ((FileSaveResult)localObject).jdField_a_of_type_Int = paramInt;
      if (paramInt == 0) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      ((FileSaveResult)localObject).jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int = 1;
      boolean bool;
      if (paramPicResult != null)
      {
        ((FileSaveResult)localObject).jdField_a_of_type_Int = paramPicResult.jdField_a_of_type_Int;
        if ((paramPicResult.jdField_a_of_type_Int != 0) && (paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null))
        {
          ((FileSaveResult)localObject).jdField_b_of_type_Int = paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int;
          ((FileSaveResult)localObject).jdField_a_of_type_JavaLangString = paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString;
        }
        if (paramPicResult.jdField_a_of_type_Int == 0) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        bool = paramPicResult.jdField_a_of_type_Boolean;
      }
      else
      {
        bool = false;
      }
      ((FileSaveResult)localObject).jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo = new PeakDownloadCallBackInfo(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, (FileSaveResult)localObject);
      MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, ((FileSaveResult)localObject).jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, 0, ((FileSaveResult)localObject).jdField_b_of_type_Int, ((FileSaveResult)localObject).jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
    if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
    {
      if (MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager))
      {
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt);
        return;
      }
      paramInt /= 100;
      localFileSaveResult.c = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, localFileSaveResult);
      MultiRichMediaSaveManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.11
 * JD-Core Version:    0.7.0.1
 */