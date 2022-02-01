package com.tencent.mobileqq.kandian.glue.video;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class VideoVolumeControl$MyPhoneStateListener
  extends PhoneStateListener
{
  VideoVolumeControl$MyPhoneStateListener(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onCallStateChanged:");
      paramString.append(paramInt);
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, paramString.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.a.checkPlayStateWhenPhoneCome(true);
        return;
      }
      this.a.checkPlayStateWhenPhoneCome(true);
      return;
    }
    this.a.checkPlayStateAfterPhoneCall();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl.MyPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */