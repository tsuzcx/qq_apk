package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.VideoDownCallback;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$8
  implements ShortVideoPreDownloaderWithSdkSupport.VideoDownCallback
{
  MultiRichMediaSaveManager$8(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, FileSaveReq paramFileSaveReq, String paramString) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onComplete, key = " + this.jdField_a_of_type_JavaLangString + ", result = " + paramInt + " , uniseq = " + this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq, paramInt, 0, "");
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (QLog.isColorLevel())) {
      QLog.d("MultiRichMediaSaveManager", 2, "downloadVideo onProgress , key = " + this.jdField_a_of_type_JavaLangString + ", pos = " + paramInt + " , uniseq = " + this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo);
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str);
      if ((localFileSaveResult != null) && (!localFileSaveResult.a))
      {
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(str, localFileSaveResult);
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, localFileSaveResult.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.8
 * JD-Core Version:    0.7.0.1
 */