package com.tencent.mobileqq.studyroom.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.studyroom.api.IStudyRoomPicUploadListener;
import com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploadUtil;

class StudyRoomUploaderImpl$1
  implements IStudyRoomPicUploadListener
{
  StudyRoomUploaderImpl$1(StudyRoomUploaderImpl paramStudyRoomUploaderImpl, Bundle paramBundle, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener) {}
  
  public void a(int paramInt)
  {
    StudyRoomPicUploadUtil.a(this.jdField_a_of_type_AndroidOsBundle, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener.a(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    StudyRoomPicUploadUtil.a(this.jdField_a_of_type_AndroidOsBundle, paramInt, paramString, true);
    this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener.a(paramInt, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    StudyRoomPicUploadUtil.a(this.jdField_a_of_type_AndroidOsBundle, paramString1, paramString2);
    this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomUploaderImpl.1
 * JD-Core Version:    0.7.0.1
 */