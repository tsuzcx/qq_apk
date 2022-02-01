package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class TroopShortcutBarObserver
  implements BusinessObserver
{
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1) {}
  
  protected void a(TroopInfo paramTroopInfo, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            a((TroopInfo)((Object[])(Object[])paramObject)[0], paramBoolean);
            return;
          }
          Object[] arrayOfObject = (Object[])paramObject;
          paramObject = arrayOfObject[1];
          List localList = null;
          if (paramObject != null) {
            paramObject = (List)arrayOfObject[1];
          } else {
            paramObject = null;
          }
          if (arrayOfObject[2] != null) {
            localList = (List)arrayOfObject[2];
          }
          a(((Long)arrayOfObject[0]).longValue(), paramBoolean, paramObject, localList);
          return;
        }
        a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
        return;
      }
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), paramBoolean, ((Integer)paramObject[1]).intValue());
      return;
    }
    a(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver
 * JD-Core Version:    0.7.0.1
 */