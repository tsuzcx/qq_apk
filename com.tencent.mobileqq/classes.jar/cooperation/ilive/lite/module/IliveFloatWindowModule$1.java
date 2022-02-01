package cooperation.ilive.lite.module;

import androidx.lifecycle.Observer;
import com.tencent.ilive.audiencepages.room.events.FloatWindowStateEvent;

class IliveFloatWindowModule$1
  implements Observer<FloatWindowStateEvent>
{
  IliveFloatWindowModule$1(IliveFloatWindowModule paramIliveFloatWindowModule) {}
  
  public void a(FloatWindowStateEvent paramFloatWindowStateEvent)
  {
    if (paramFloatWindowStateEvent == null) {
      return;
    }
    if (paramFloatWindowStateEvent.showing)
    {
      IliveFloatWindowModule.a(this.a);
      return;
    }
    IliveFloatWindowModule.a(this.a, paramFloatWindowStateEvent.reason);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveFloatWindowModule.1
 * JD-Core Version:    0.7.0.1
 */