package com.tencent.mobileqq.location.ui;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class LocationShareController$3
  extends TroopObserver
{
  LocationShareController$3(LocationShareController paramLocationShareController) {}
  
  public void onPassiveExit(String paramString, int paramInt)
  {
    super.onPassiveExit(paramString, paramInt);
    if ((LocationShareController.a(this.a).a() == 1) && (LocationShareController.a(this.a).a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      if (LocationShareController.a(this.a) != null)
      {
        LocationShareController.a(this.a).finish();
        QQToast.a(LocationShareController.a(this.a), 2131693157, 1).a();
      }
      LocationShareController.a(LocationShareController.a(this.a), 1, paramString);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    super.onTroopManagerSuccess(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0)) {
      LocationShareController.a(LocationShareController.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.3
 * JD-Core Version:    0.7.0.1
 */