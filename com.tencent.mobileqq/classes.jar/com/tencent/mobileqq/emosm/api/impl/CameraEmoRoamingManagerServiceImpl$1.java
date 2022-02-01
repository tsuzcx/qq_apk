package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.app.CameraEmoRoamingObserver;
import com.tencent.mobileqq.data.CameraEmotionData;

class CameraEmoRoamingManagerServiceImpl$1
  extends CameraEmoRoamingObserver
{
  CameraEmoRoamingManagerServiceImpl$1(CameraEmoRoamingManagerServiceImpl paramCameraEmoRoamingManagerServiceImpl) {}
  
  protected void doOnAddEmoResult(int paramInt, CameraEmotionData paramCameraEmotionData)
  {
    this.a.onUploadCameraEmoCallBack(paramInt, paramCameraEmotionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CameraEmoRoamingManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */