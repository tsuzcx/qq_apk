package com.tencent.mobileqq.location.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class FloatMapServiceImpl$1
  implements View.OnClickListener
{
  FloatMapServiceImpl$1(FloatMapServiceImpl paramFloatMapServiceImpl, LocationRoom.RoomKey paramRoomKey) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.a();
    String str = this.a.b();
    ILocationShareService localILocationShareService = (ILocationShareService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ILocationShareService.class, "");
    localILocationShareService.requestOperateRoom(3, i, str);
    localILocationShareService.stopLocationSharing(i, str, false);
    ReportController.b(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.FloatMapServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */