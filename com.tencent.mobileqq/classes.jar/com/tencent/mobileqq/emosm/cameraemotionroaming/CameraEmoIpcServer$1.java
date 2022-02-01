package com.tencent.mobileqq.emosm.cameraemotionroaming;

import java.util.ArrayList;

class CameraEmoIpcServer$1
  implements Runnable
{
  CameraEmoIpcServer$1(CameraEmoIpcServer paramCameraEmoIpcServer, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    if (this.a != null)
    {
      CameraEmoSendControl.a().a(this.b, this.c, this.a, this.d);
      return;
    }
    CameraEmoSendControl.a().a(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer.1
 * JD-Core Version:    0.7.0.1
 */