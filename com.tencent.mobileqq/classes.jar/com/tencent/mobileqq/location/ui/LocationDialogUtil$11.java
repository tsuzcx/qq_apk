package com.tencent.mobileqq.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.location.net.RoomOperateHandler;
import com.tencent.mobileqq.statistics.ReportController;

final class LocationDialogUtil$11
  implements DialogInterface.OnClickListener
{
  LocationDialogUtil$11(int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocationShareRoomManager.a().b.a(3, this.a, this.b);
    paramDialogInterface = new LocationRoom.RoomKey(this.a, this.b);
    LocationShareLocationManager.a().a(paramDialogInterface, true);
    ReportController.b(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.11
 * JD-Core Version:    0.7.0.1
 */