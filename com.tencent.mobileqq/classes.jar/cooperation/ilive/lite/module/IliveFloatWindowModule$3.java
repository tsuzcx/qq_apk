package cooperation.ilive.lite.module;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class IliveFloatWindowModule$3
  implements IliveLiteEventCenter.Observer
{
  IliveFloatWindowModule$3(IliveFloatWindowModule paramIliveFloatWindowModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("action =  ");
    paramBundle.append(paramString);
    QLog.i("IliveFloatWindowModule", 1, paramBundle.toString());
    if (paramString.equals("ACTION_ACTIVITY_START"))
    {
      IliveFloatWindowModule.a(this.a, true);
      this.a.onActivityStart(null);
      IliveFloatWindowModule.a(this.a, false);
      return true;
    }
    if (paramString.equals("ACTION_ACTIVITY_STOP"))
    {
      IliveFloatWindowModule.b(this.a, true);
      this.a.onActivityStop(null);
      IliveFloatWindowModule.b(this.a, false);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveFloatWindowModule.3
 * JD-Core Version:    0.7.0.1
 */