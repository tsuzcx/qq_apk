package com.tencent.mobileqq.videocodec.mediacodec.recorder;

import com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil.ThumbnailCallback;
import com.tencent.qphone.base.util.QLog;

class HWVideoRecorder$1
  implements ThumbnailUtil.ThumbnailCallback
{
  HWVideoRecorder$1(HWVideoRecorder paramHWVideoRecorder) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    HWVideoRecorder.a(this.a, true);
    if ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Generate thumbnail result. success = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ; file path = ");
      localStringBuilder.append(paramString);
      QLog.d("HWVideoRecorder", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder.1
 * JD-Core Version:    0.7.0.1
 */