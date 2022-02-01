package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;

class CameraEmoSingleSend$3
  implements CameraEmoRoamingManager.ICameraEmoAddCallBack
{
  CameraEmoSingleSend$3(CameraEmoSingleSend paramCameraEmoSingleSend) {}
  
  public void a(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    boolean bool = true;
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "onAddEmoFinish, result:", Integer.valueOf(paramInt), " emoId:", Integer.valueOf(paramCameraEmotionData.emoId), " originalId:", Integer.valueOf(CameraEmoSingleSend.a(this.a).emoId) });
    if (paramInt == 0) {}
    for (;;)
    {
      CameraEmoSingleSend.a(this.a, bool, paramInt);
      this.a.a(String.valueOf(paramInt), 2);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend.3
 * JD-Core Version:    0.7.0.1
 */