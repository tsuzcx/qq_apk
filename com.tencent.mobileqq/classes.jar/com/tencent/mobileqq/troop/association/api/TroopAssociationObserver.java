package com.tencent.mobileqq.troop.association.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.association.data.AllianceItem;

public class TroopAssociationObserver
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
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 4) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof Integer)) && ((paramObject[2] instanceof Long)) && ((paramObject[3] instanceof AllianceItem)))
      {
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), (AllianceItem)paramObject[3]);
        return;
      }
      a(false, "", -1, -1L, null);
      return;
    }
    a(false, "", -1, -1L, null);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.association.api.TroopAssociationObserver
 * JD-Core Version:    0.7.0.1
 */