package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class CameraEmoSingleSend$1
  extends TimerTask
{
  CameraEmoSingleSend$1(CameraEmoSingleSend paramCameraEmoSingleSend) {}
  
  public void run()
  {
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "timer cancel, emoPath:", CameraEmoSingleSend.a(this.this$0).emoPath });
    CameraEmoSingleSend.a(this.this$0, true);
    CameraEmoSingleSend.a(this.this$0, false, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend.1
 * JD-Core Version:    0.7.0.1
 */