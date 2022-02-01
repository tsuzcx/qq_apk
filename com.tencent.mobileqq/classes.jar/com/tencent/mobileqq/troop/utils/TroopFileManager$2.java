package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.util.Map;

class TroopFileManager$2
  extends BizTroopObserver
{
  TroopFileManager$2(TroopFileManager paramTroopFileManager) {}
  
  protected void a(Object arg1)
  {
    Object localObject2;
    if (??? != null)
    {
      if (!(??? instanceof TroopFileStatusInfo)) {
        return;
      }
      localObject2 = (TroopFileStatusInfo)???;
    }
    for (;;)
    {
      synchronized (this.b)
      {
        if (((TroopFileStatusInfo)localObject2).d != this.b.b) {
          return;
        }
        TroopFileInfo localTroopFileInfo1 = (TroopFileInfo)this.b.e.get(((TroopFileStatusInfo)localObject2).a);
        if ((!a) && (localTroopFileInfo1 == null)) {
          throw new AssertionError();
        }
        if (localTroopFileInfo1 == null) {
          return;
        }
        int i = localTroopFileInfo1.p;
        if ((localTroopFileInfo1.c == null) && (((TroopFileStatusInfo)localObject2).r != null)) {
          this.b.f.put(((TroopFileStatusInfo)localObject2).r, localTroopFileInfo1);
        }
        localTroopFileInfo1.a((TroopFileStatusInfo)localObject2, this.b.c);
        if (((TroopFileStatusInfo)localObject2).e == 12)
        {
          localObject2 = (TroopFileInfo)this.b.f.get(localTroopFileInfo1.o);
          if (localObject2 != null) {
            ((TroopFileInfo)localObject2).a(localTroopFileInfo1);
          }
          this.b.e(localTroopFileInfo1);
          return;
        }
        boolean bool2 = localTroopFileInfo1.v;
        bool1 = true;
        if (bool2)
        {
          if (((TroopFileStatusInfo)localObject2).e != 11) {
            break label410;
          }
          localTroopFileInfo1.v = bool1;
        }
        else if ((((TroopFileStatusInfo)localObject2).e == 11) && (localTroopFileInfo1.p != 11))
        {
          localTroopFileInfo1.v = true;
        }
        if (!"/".equals(localTroopFileInfo1.o))
        {
          TroopFileInfo localTroopFileInfo2 = (TroopFileInfo)this.b.f.get(localTroopFileInfo1.o);
          if ((localTroopFileInfo2 != null) && ((localTroopFileInfo1.p == 9) || (localTroopFileInfo1.p == 10) || (localTroopFileInfo1.p == 11))) {
            localTroopFileInfo2.a(localTroopFileInfo1);
          }
        }
        if ((((TroopFileStatusInfo)localObject2).e == 6) && (i != 6))
        {
          localTroopFileInfo1.a((int)NetConnInfoCenter.getServerTime());
          localTroopFileInfo1.b((int)NetConnInfoCenter.getServerTime());
          this.b.f(localTroopFileInfo1);
        }
        this.b.e(localTroopFileInfo1);
        return;
      }
      return;
      label410:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.2
 * JD-Core Version:    0.7.0.1
 */