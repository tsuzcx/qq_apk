package com.tencent.mobileqq.emosm.cameraemotionroaming;

import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import java.util.List;

class CameraEmoRoamingManager$2
  implements Runnable
{
  CameraEmoRoamingManager$2(CameraEmoRoamingManager paramCameraEmoRoamingManager, CameraEmotionRoamingDBManager paramCameraEmotionRoamingDBManager, CameraEmoRoamingHandler paramCameraEmoRoamingHandler) {}
  
  public void run()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager.a("needDel");
    if (localList.size() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingHandler.a(localList, true);
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