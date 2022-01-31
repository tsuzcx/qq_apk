package com.tencent.mobileqq.emosm.cameraemotionroaming;

import anbf;
import anbl;
import java.util.ArrayList;

public class CameraEmoIpcServer$1
  implements Runnable
{
  public CameraEmoIpcServer$1(anbf paramanbf, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3) {}
  
  public void run()
  {
    if (this.a != null)
    {
      anbl.a(this.b, this.c, this.a);
      return;
    }
    anbl.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer.1
 * JD-Core Version:    0.7.0.1
 */