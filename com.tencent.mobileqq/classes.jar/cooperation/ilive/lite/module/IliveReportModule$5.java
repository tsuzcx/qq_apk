package cooperation.ilive.lite.module;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper;

class IliveReportModule$5
  implements IliveLiteEventCenter.Observer
{
  IliveReportModule$5(IliveReportModule paramIliveReportModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IliveLiteEventCenter onCall , action = ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.e("IliveReportModule", 1, (String)localObject);
    if (!IliveReportModule.b(this.a)) {
      return false;
    }
    if (paramString.equals("ACTION_BACK_PRESS"))
    {
      if (IliveFloatWindowHelper.a((Activity)IliveReportModule.a(this.a), IliveReportModule.a(this.a))) {
        return true;
      }
      IliveReportModule.a(this.a);
      return true;
    }
    if ((paramString.equals("ACTION_SSO_ENTER_ROOM")) && (paramBundle != null))
    {
      paramString = this.a;
      if (paramBundle.getInt("media_status") == 1) {
        bool = false;
      }
      IliveReportModule.a(paramString, bool);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.5
 * JD-Core Version:    0.7.0.1
 */