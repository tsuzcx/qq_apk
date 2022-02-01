package com.tencent.mobileqq.studyroom.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.studyroom.api.IStudyRoomPicUploadListener;
import com.tencent.mobileqq.studyroom.api.IStudyRoomUploader;
import com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploadUtil;
import com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploader;
import com.tencent.qphone.base.util.QLog;

public class StudyRoomUploaderImpl
  implements IStudyRoomUploader
{
  private static final String TAG = "StudyRoomUploader";
  
  public void cancelPicUpload(Bundle paramBundle)
  {
    StudyRoomPicUploadUtil.a(paramBundle.getString("localPath"));
  }
  
  public boolean isPicUploadEnd(Bundle paramBundle)
  {
    return StudyRoomPicUploadUtil.a(paramBundle);
  }
  
  public void startPicUpload(Bundle paramBundle, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener)
  {
    int i = paramBundle.getInt("seq");
    String str = paramBundle.getString("localPath");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSG_STUDY_ROOM_PIC_UPLOAD seq=");
      localStringBuilder.append(i);
      QLog.d("StudyRoomUploader", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSG_STUDY_ROOM_PIC_UPLOAD UpPath=");
      localStringBuilder.append(str);
      QLog.d("StudyRoomUploader", 2, localStringBuilder.toString());
    }
    if (StudyRoomPicUploadUtil.b(str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StudyRoomUploader", 2, "isUploading ERROR_IS_UPLOADING");
      }
      StudyRoomPicUploadUtil.a(paramBundle, 102, "已经在上传中", false);
      paramIStudyRoomPicUploadListener.a(102, "已经在上传中");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StudyRoomUploader", 2, "StudyRoomPicUploader startUpload");
    }
    paramBundle = new StudyRoomPicUploader(str, new StudyRoomUploaderImpl.1(this, paramBundle, paramIStudyRoomPicUploadListener));
    StudyRoomPicUploadUtil.a(str, paramBundle);
    paramBundle.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomUploaderImpl
 * JD-Core Version:    0.7.0.1
 */