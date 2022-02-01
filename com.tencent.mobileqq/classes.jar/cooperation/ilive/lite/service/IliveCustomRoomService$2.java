package cooperation.ilive.lite.service;

import android.os.Bundle;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Pair;

class IliveCustomRoomService$2
  implements Runnable
{
  IliveCustomRoomService$2(IliveCustomRoomService paramIliveCustomRoomService, com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo)localObject).extData != null) && (IliveCustomRoomService.a(this.this$0) != null))
    {
      if (this.a.extData.getInt("ext_enter_room_room_type", 0) == 0)
      {
        IliveCustomRoomService.a(this.this$0, this.a, this.b);
        VasStatisticCollector.b("lite_enter_sso", new Pair[0]);
        localObject = new com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo();
        ((com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo)localObject).setRoomId(this.a.roomId);
        IliveCustomRoomService.a(this.this$0).enterRoom((com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo)localObject, false, new IliveCustomRoomService.2.1(this));
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("watchEnterRoom enterRoomInfo data error:");
    ((StringBuilder)localObject).append(this.a);
    QLog.e("IliveReportModule", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.2
 * JD-Core Version:    0.7.0.1
 */