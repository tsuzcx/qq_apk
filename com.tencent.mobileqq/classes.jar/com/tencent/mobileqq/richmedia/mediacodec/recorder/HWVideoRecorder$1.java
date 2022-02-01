package com.tencent.mobileqq.richmedia.mediacodec.recorder;

import com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil.ThumbnailCallback;
import com.tencent.qphone.base.util.QLog;

class HWVideoRecorder$1
  implements ThumbnailUtil.ThumbnailCallback
{
  HWVideoRecorder$1(HWVideoRecorder paramHWVideoRecorder) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    HWVideoRecorder.a(this.a, true);
    if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
      QLog.d("HWVideoRecorder", 2, "Generate thumbnail result. success = " + paramBoolean + " ; file path = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder.1
 * JD-Core Version:    0.7.0.1
 */