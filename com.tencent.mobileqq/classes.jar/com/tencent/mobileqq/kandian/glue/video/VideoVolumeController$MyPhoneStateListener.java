package com.tencent.mobileqq.kandian.glue.video;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class VideoVolumeController$MyPhoneStateListener
  extends PhoneStateListener
{
  VideoVolumeController$MyPhoneStateListener(VideoVolumeController paramVideoVolumeController) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onCallStateChanged:");
      paramString.append(paramInt);
      QLog.d("VideoVolumeController", 2, paramString.toString());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.a.checkPlayStateWhenPhoneCome(true);
      return;
    }
    this.a.checkPlayStateWhenPhoneCome(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeController.MyPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */