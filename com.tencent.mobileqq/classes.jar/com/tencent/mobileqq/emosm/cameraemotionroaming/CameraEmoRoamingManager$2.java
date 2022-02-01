package com.tencent.mobileqq.emosm.cameraemotionroaming;

import amos;
import aqzw;
import arad;
import java.util.List;

public class CameraEmoRoamingManager$2
  implements Runnable
{
  public CameraEmoRoamingManager$2(aqzw paramaqzw, arad paramarad, amos paramamos) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_Arad.a("needDel");
    if (localList.size() > 0) {
      this.jdField_a_of_type_Amos.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2
 * JD-Core Version:    0.7.0.1
 */