package com.tencent.mobileqq.troop.troopgag.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.qphone.base.util.QLog;

public class TroopGagObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopGagObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
    }
    a((GagStatus)paramObject);
  }
  
  protected void a(GagStatus paramGagStatus) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver
 * JD-Core Version:    0.7.0.1
 */