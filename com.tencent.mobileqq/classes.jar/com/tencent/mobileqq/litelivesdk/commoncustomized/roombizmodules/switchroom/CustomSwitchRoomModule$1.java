package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;

class CustomSwitchRoomModule$1
  implements Runnable
{
  CustomSwitchRoomModule$1(CustomSwitchRoomModule paramCustomSwitchRoomModule) {}
  
  public void run()
  {
    if (CustomSwitchRoomModule.a(this.this$0) != null) {
      CustomSwitchRoomModule.a(this.this$0).doQueryRoomList();
    }
    if (this.this$0.a()) {
      ThreadCenter.postDelayedUITask(this.this$0, CustomSwitchRoomModule.a(this.this$0), 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.switchroom.CustomSwitchRoomModule.1
 * JD-Core Version:    0.7.0.1
 */