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
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadRawImage id = " + this.jdField_a_of_type_Long + ", result = " + paramInt);
    }
    FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
    if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
    {
      localFileSaveResult.jdField_a_of_type_Int = paramInt;
      if (paramInt != 0) {
        break label226;
      }
      paramInt = 1;
      localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int = 1;
      if (paramPicResult == null) {
        break label236;
      }
      localFileSaveResult.jdField_a_of_type_Int = paramPicResult.jdField_a_of_type_Int;
      if ((paramPicResult.jdField_a_of_type_Int != 0) && (paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null))
      {
        localFileSaveResult.jdField_b_of_type_Int = paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_Int;
        localFileSaveResult.jdField_a_of_type_JavaLangString = paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString;
      }
      if (paramPicResult.jdField_a_of_type_Int != 0) {
        break label231;
      }
      paramInt = i;
    }
    label152:
    label226:
    label231:
    label236:
    for (boolean bool = paramPicResult.jdField_a_of_type_Boolean;; bool = false)
    {
      localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo = new PeakDownloadCallBackInfo(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_JavaLangString, bool);
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, localFileSaveResult);
      MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, 0, localFileSaveResult.jdField_b_of_type_Int, localFileSaveResult.jdField_a_of_type_JavaLangString);
      return;
      paramInt = 2;
      break;
      paramInt = 2;
      break label152;
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
      if (MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager)) {
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt);
      }
    }
    else {
      return;
    }
    paramInt /= 100;
    localFileSaveResult.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, localFileSaveResult);
    MultiRichMediaSaveManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.11
 * JD-Core Version:    0.7.0.1
 */