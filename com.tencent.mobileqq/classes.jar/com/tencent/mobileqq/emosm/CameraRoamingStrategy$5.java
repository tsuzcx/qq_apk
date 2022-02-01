package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.mobileqq.utils.NetworkUtil;

class CameraRoamingStrategy$5
  implements Runnable
{
  CameraRoamingStrategy$5(CameraRoamingStrategy paramCameraRoamingStrategy) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!NetworkUtil.d(this.this$0.a.getApp()))) {
      return;
    }
    ((CameraEmoRoamingManager)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */