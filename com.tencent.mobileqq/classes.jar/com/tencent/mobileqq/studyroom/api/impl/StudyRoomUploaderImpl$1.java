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
    StudyRoomPicUploadUtil.a(this.a, paramInt);
    this.b.a(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    StudyRoomPicUploadUtil.a(this.a, paramInt, paramString, true);
    this.b.a(paramInt, paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    StudyRoomPicUploadUtil.a(this.a, paramString1, paramString2);
    this.b.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomUploaderImpl.1
 * JD-Core Version:    0.7.0.1
 */