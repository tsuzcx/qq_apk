package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.utils.NetworkUtil;

class CameraRoamingStrategy$5
  implements Runnable
{
  CameraRoamingStrategy$5(CameraRoamingStrategy paramCameraRoamingStrategy) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (!NetworkUtil.isNetSupport(this.this$0.a.getApp())) {
        return;
      }
      ((ICameraEmoRoamingManagerService)this.this$0.a.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncRoaming();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.5
 * JD-Core Version:    0.7.0.1
 */