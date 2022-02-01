package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.VideoDownCallback;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$8
  implements VideoDownCallback
{
  MultiRichMediaSaveManager$8(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadVideo onComplete, key = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , uniseq = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      QLog.d("MultiRichMediaSaveManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadVideo onProgress , key = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", pos = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" , uniseq = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      QLog.d("MultiRichMediaSaveManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a((String)localObject);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a((String)localObject, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, localFileSaveResult.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.8
 * JD-Core Version:    0.7.0.1
 */