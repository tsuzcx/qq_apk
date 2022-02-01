package cooperation.ilive.lite.module;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.qphone.base.util.QLog;

class IliveReportModule$1
  implements Observer<RoomCloseEvent>
{
  IliveReportModule$1(IliveReportModule paramIliveReportModule) {}
  
  public void a(@Nullable RoomCloseEvent paramRoomCloseEvent)
  {
    QLog.e("IliveReportModule", 1, "onExitRoom roomCloseEvent = " + paramRoomCloseEvent.sceneId + " roomId = " + IliveReportModule.a(this.a));
    IliveReportModule.a(this.a, IliveReportModule.a(this.a), paramRoomCloseEvent.sceneId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.1
 * JD-Core Version:    0.7.0.1
 */