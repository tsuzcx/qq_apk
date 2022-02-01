package com.tencent.mobileqq.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;

class LocationDialogUtil$9$1
  implements DialogInterface.OnClickListener
{
  LocationDialogUtil$9$1(LocationDialogUtil.9 param9) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocationHandler.a().a(new LocationRoom.RoomKey(this.a.c, this.a.d));
    LocationShareRoomManager.a().a(true);
    LocationShareRoomManager.a().a(this.a.c, this.a.d);
    LocationShareFragment.a(this.a.a, this.a.c, this.a.d, this.a.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.9.1
 * JD-Core Version:    0.7.0.1
 */