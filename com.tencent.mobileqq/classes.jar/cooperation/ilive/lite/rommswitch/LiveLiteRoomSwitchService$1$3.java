package cooperation.ilive.lite.rommswitch;

import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import java.util.ArrayList;

class LiveLiteRoomSwitchService$1$3
  implements Runnable
{
  LiveLiteRoomSwitchService$1$3(LiveLiteRoomSwitchService.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.b.a != null) {
      this.b.a.onResult(0, this.a.size(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService.1.3
 * JD-Core Version:    0.7.0.1
 */