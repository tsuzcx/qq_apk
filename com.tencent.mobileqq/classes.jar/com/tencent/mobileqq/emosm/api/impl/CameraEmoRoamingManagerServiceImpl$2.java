package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import java.util.List;

class CameraEmoRoamingManagerServiceImpl$2
  implements Runnable
{
  CameraEmoRoamingManagerServiceImpl$2(CameraEmoRoamingManagerServiceImpl paramCameraEmoRoamingManagerServiceImpl, ICameraEmotionRoamingDBManagerService paramICameraEmotionRoamingDBManagerService, CameraEmoRoamingHandler paramCameraEmoRoamingHandler) {}
  
  public void run()
  {
    List localList = this.a.getCustomEmoticonResIdsByType("needDel");
    if (localList.size() > 0)
    {
      this.b.a(localList, true);
      return;
    }
    if (localList.size() == 0) {
      this.this$0.syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CameraEmoRoamingManagerServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */