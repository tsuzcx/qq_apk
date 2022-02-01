package com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services;

import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;

class ODRoomSwitchService$2
  implements ODRoomSwitchService.IGetNeighborRoomListener
{
  ODRoomSwitchService$2(ODRoomSwitchService paramODRoomSwitchService) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(List<SwitchRoomInfo> paramList)
  {
    ODRoomSwitchService localODRoomSwitchService = this.a;
    paramList = ODRoomSwitchService.a(localODRoomSwitchService, ODRoomSwitchService.a(localODRoomSwitchService), paramList);
    ThreadManager.getUIHandler().post(new ODRoomSwitchService.2.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.services.ODRoomSwitchService.2
 * JD-Core Version:    0.7.0.1
 */