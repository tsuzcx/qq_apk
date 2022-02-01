package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.app.CameraEmoRoamingObserver;

class CameraRoamingStrategy$4
  extends CameraEmoRoamingObserver
{
  CameraRoamingStrategy$4(CameraRoamingStrategy paramCameraRoamingStrategy) {}
  
  protected void doOnDeleteEmoResult(int paramInt)
  {
    CameraRoamingStrategy.a(this.a, false);
    if (this.a.a != null) {
      this.a.a.k();
    }
  }
  
  protected void doOnGetEmoListResult(int paramInt)
  {
    if ((paramInt == 0) && (this.a.a != null)) {
      this.a.a.k();
    }
  }
  
  protected void onCameraEmoSend(boolean paramBoolean, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.4
 * JD-Core Version:    0.7.0.1
 */