package cooperation.ilive.lite.module;

import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;

class IliveFloatWindowModule$1
  implements Observer<FloatWindowStateEvent>
{
  IliveFloatWindowModule$1(IliveFloatWindowModule paramIliveFloatWindowModule) {}
  
  public void a(FloatWindowStateEvent paramFloatWindowStateEvent)
  {
    if (paramFloatWindowStateEvent == null) {
      return;
    }
    QQLiveCurRoomInfo localQQLiveCurRoomInfo = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037").getCurRoomInfo();
    if (paramFloatWindowStateEvent.showing)
    {
      IliveFloatWindowModule.a(this.a);
      if (localQQLiveCurRoomInfo != null) {
        localQQLiveCurRoomInfo.isFloatWindow = true;
      }
    }
    else
    {
      IliveFloatWindowModule.a(this.a, paramFloatWindowStateEvent.reason);
      if (localQQLiveCurRoomInfo != null) {
        localQQLiveCurRoomInfo.isFloatWindow = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveFloatWindowModule.1
 * JD-Core Version:    0.7.0.1
 */