package com.tencent.mobileqq.location.net;

import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.qphone.base.util.QLog;

class LocationHandler$1
  extends TroopMngObserver
{
  LocationHandler$1(LocationHandler paramLocationHandler) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramInt1, paramInt2, paramString);
    if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, new Object[] { "onTroopManagerSuccess: invoked. 主动退群 or 解散群", " reqtype: ", Integer.valueOf(paramInt1), " troopUin: ", paramString });
      }
      LocationShareViewModel.a(LocationHandler.a(this.a), 1, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.1
 * JD-Core Version:    0.7.0.1
 */