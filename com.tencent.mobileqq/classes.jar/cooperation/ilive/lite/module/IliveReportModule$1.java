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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitRoom roomCloseEvent = ");
    ((StringBuilder)localObject).append(paramRoomCloseEvent.sceneId);
    ((StringBuilder)localObject).append(" roomId = ");
    ((StringBuilder)localObject).append(IliveReportModule.a(this.a));
    QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    IliveReportModule.a((IliveReportModule)localObject, IliveReportModule.a((IliveReportModule)localObject), paramRoomCloseEvent.sceneId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule.1
 * JD-Core Version:    0.7.0.1
 */