package com.tencent.mobileqq.location.window;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.callback.IFloatMapCallback;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FloatLocationShareCallback
  implements IFloatMapCallback
{
  public void a()
  {
    try
    {
      IFloatMapService localIFloatMapService = (IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "");
      if (localIFloatMapService != null) {
        localIFloatMapService.quitFloat(-1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FloatLocationShareCallback", 1, "stopLocationSharing: failed. ", localThrowable);
    }
  }
  
  public boolean a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey)
  {
    return ((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).enterFloat(paramQBaseActivity, paramRoomKey);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatLocationShareCallback
 * JD-Core Version:    0.7.0.1
 */