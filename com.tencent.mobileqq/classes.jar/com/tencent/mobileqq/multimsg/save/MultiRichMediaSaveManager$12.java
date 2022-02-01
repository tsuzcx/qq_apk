package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.VideoDownCallback;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$12
  implements VideoDownCallback
{
  MultiRichMediaSaveManager$12(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, long paramLong, FileSaveReq paramFileSaveReq, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadVideo id = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", result =");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a != null)
    {
      localObject = SVUtils.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a, "mp4");
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
      if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.jdField_a_of_type_Int = paramInt;
        localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
        localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo = new PeakDownloadCallBackInfo(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, (String)localObject, false);
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, localFileSaveResult);
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, 0, 0, "");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a.videoFileSize, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
    {
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
      if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, localFileSaveResult);
        if (MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager))
        {
          MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, localFileSaveResult.c);
          return;
        }
        MultiRichMediaSaveManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.12
 * JD-Core Version:    0.7.0.1
 */