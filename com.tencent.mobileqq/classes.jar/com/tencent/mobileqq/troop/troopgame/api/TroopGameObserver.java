package com.tencent.mobileqq.troop.troopgame.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;

public class TroopGameObserver
  implements BusinessObserver
{
  public static final int a;
  private static int b = 0;
  
  static
  {
    int i = b;
    b = i + 1;
    a = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    if (paramInt != a) {
      return;
    }
    Object localObject;
    if (paramObject != null)
    {
      localObject = (Object[])paramObject;
      if (localObject.length == 3) {
        if (!(localObject[0] instanceof String)) {
          break label123;
        }
      }
    }
    label123:
    for (paramObject = (String)localObject[0];; paramObject = null)
    {
      paramInt = i;
      if ((localObject[1] instanceof Integer)) {
        paramInt = ((Integer)localObject[1]).intValue();
      }
      if ((localObject[2] instanceof TroopGameActivityInfo)) {}
      for (localObject = (TroopGameActivityInfo)localObject[2];; localObject = null)
      {
        a(paramObject, paramInt, (TroopGameActivityInfo)localObject);
        return;
        a(null, 0, null);
        return;
        a(null, 0, null);
        return;
      }
    }
  }
  
  public void a(String paramString, int paramInt, TroopGameActivityInfo paramTroopGameActivityInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver
 * JD-Core Version:    0.7.0.1
 */