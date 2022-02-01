package cooperation.ilive.lite.module;

import android.os.Bundle;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class IliveReportModule$4
  implements IliveLiteEventCenter.Observer
{
  IliveReportModule$4(IliveReportModule paramIliveReportModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    QLog.e("IliveReportModule", 1, "IliveLiteEventCenter onCall , action = " + paramString);
    if ((paramString.equals("ACTION_BACK_PRESS")) && (this.a.getEvent() != null) && (IliveReportModule.a(this.a)))
    {
      this.a.getEvent().post(new RoomCloseEvent((short)4));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.4
 * JD-Core Version:    0.7.0.1
 */