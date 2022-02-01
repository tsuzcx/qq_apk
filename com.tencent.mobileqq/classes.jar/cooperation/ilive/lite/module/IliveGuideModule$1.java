package cooperation.ilive.lite.module;

import android.os.Bundle;
import com.tencent.falco.utils.ThreadCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class IliveGuideModule$1
  implements IliveLiteEventCenter.Observer
{
  IliveGuideModule$1(IliveGuideModule paramIliveGuideModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    if (paramString.equals("ACTION_SHOW_GUIDE"))
    {
      ThreadCenter.postDefaultUITask(new IliveGuideModule.1.1(this));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveGuideModule.1
 * JD-Core Version:    0.7.0.1
 */