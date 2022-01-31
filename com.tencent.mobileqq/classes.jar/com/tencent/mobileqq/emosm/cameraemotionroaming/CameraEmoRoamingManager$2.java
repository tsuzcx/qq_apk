package com.tencent.mobileqq.emosm.cameraemotionroaming;

import alph;
import apno;
import apnv;
import java.util.List;

public class CameraEmoRoamingManager$2
  implements Runnable
{
  public CameraEmoRoamingManager$2(apno paramapno, apnv paramapnv, alph paramalph) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_Apnv.a("needDel");
    if (localList.size() > 0) {
      this.jdField_a_of_type_Alph.a(localList, true);
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