package com.tencent.mobileqq.emosm.cameraemotionroaming;

import asfw;
import asgc;
import java.util.ArrayList;

public class CameraEmoIpcServer$1
  implements Runnable
{
  public CameraEmoIpcServer$1(asfw paramasfw, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    if (this.a != null)
    {
      asgc.a().a(this.b, this.c, this.a, this.d);
      return;
    }
    asgc.a().a(this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer.1
 * JD-Core Version:    0.7.0.1
 */