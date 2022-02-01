package com.tencent.mobileqq.emosm.cameraemotionroaming;

import anuj;
import asfy;
import asgf;
import java.util.List;

public class CameraEmoRoamingManager$2
  implements Runnable
{
  public CameraEmoRoamingManager$2(asfy paramasfy, asgf paramasgf, anuj paramanuj) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_Asgf.a("needDel");
    if (localList.size() > 0) {
      this.jdField_a_of_type_Anuj.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager.2
 * JD-Core Version:    0.7.0.1
 */