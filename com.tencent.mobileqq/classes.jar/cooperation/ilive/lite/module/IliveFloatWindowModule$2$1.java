package cooperation.ilive.lite.module;

import com.tencent.ilive.LiveSDK;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.LiveEngine;

class IliveFloatWindowModule$2$1
  implements Runnable
{
  IliveFloatWindowModule$2$1(IliveFloatWindowModule.2 param2) {}
  
  public void run()
  {
    try
    {
      LiveEngine localLiveEngine = LiveSDK.liveEngine;
      if (localLiveEngine != null)
      {
        if (localLiveEngine.getFloatRoomManager() == null) {
          return;
        }
        localLiveEngine.getFloatRoomManager().g();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveFloatWindowModule.2.1
 * JD-Core Version:    0.7.0.1
 */