package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class TroopShortcutBarObserver
  implements BusinessObserver
{
  public TroopShortcutBarObserver(QQAppInterface paramQQAppInterface) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1) {}
  
  protected void a(TroopInfo paramTroopInfo, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), paramBoolean, ((Integer)paramObject[1]).intValue());
      return;
    case 3: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
      return;
    case 4: 
      arrayOfObject = (Object[])paramObject;
      if (arrayOfObject[1] == null) {
        break;
      }
    }
    for (paramObject = (List)arrayOfObject[1];; paramObject = null)
    {
      if (arrayOfObject[2] != null) {}
      for (List localList = (List)arrayOfObject[2];; localList = null)
      {
        a(((Long)arrayOfObject[0]).longValue(), paramBoolean, paramObject, localList);
        return;
        a((TroopInfo)((Object[])(Object[])paramObject)[0], paramBoolean);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver
 * JD-Core Version:    0.7.0.1
 */