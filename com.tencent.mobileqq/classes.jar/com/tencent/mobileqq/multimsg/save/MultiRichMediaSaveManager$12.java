package com.tencent.mobileqq.multimsg.save;

import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.VideoDownCallback;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

class MultiRichMediaSaveManager$12
  implements ShortVideoPreDownloaderWithSdkSupport.VideoDownCallback
{
  MultiRichMediaSaveManager$12(MultiRichMediaSaveManager paramMultiRichMediaSaveManager, long paramLong, FileSaveReq paramFileSaveReq, String paramString, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("MultiRichMediaSaveManager", 2, "downloadVideo id = " + this.jdField_a_of_type_Long + ", result =" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a != null)
    {
      String str = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.a, "mp4");
      FileSaveResult localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
      if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.jdField_a_of_type_Int = paramInt;
        localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_Int = 3;
        if (paramInt == 0) {
          i = 1;
        }
        localFileSaveResult.jdField_a_of_type_ComTencentMobileqqMultimsgSavePeakDownloadCallBackInfo = new PeakDownloadCallBackInfo(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, i, str, false);
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
    FileSaveResult localFileSaveResult;
    if (this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveFileSaveReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq != null)
    {
      localFileSaveResult = this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString);
      if ((localFileSaveResult != null) && (!localFileSaveResult.jdField_a_of_type_Boolean))
      {
        localFileSaveResult.c = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager.a(this.jdField_a_of_type_JavaLangString, localFileSaveResult);
        if (!MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager)) {
          break label136;
        }
        MultiRichMediaSaveManager.a(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, localFileSaveResult.c);
      }
    }
    return;
    label136:
    MultiRichMediaSaveManager.b(this.jdField_a_of_type_ComTencentMobileqqMultimsgSaveMultiRichMediaSaveManager, localFileSaveResult, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.MultiRichMediaSaveManager.12
 * JD-Core Version:    0.7.0.1
 */