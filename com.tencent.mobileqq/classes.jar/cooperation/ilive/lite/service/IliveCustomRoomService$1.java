package cooperation.ilive.lite.service;

import com.tencent.ilivesdk.roomservice.RoomDataServer;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import kotlin.Pair;

class IliveCustomRoomService$1
  implements Runnable
{
  IliveCustomRoomService$1(IliveCustomRoomService paramIliveCustomRoomService, EnterRoomInfo paramEnterRoomInfo) {}
  
  public void run()
  {
    VasStatisticCollector.b("lite_enter_sso", new Pair[0]);
    RoomDataServer.requestWatchEnterRoom(IliveCustomRoomService.a(this.this$0), IliveCustomRoomService.a(this.this$0), this.a, new IliveCustomRoomService.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService.1
 * JD-Core Version:    0.7.0.1
 */