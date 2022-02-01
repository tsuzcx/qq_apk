package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData.GiftDataBean;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData.GiftDataBean.DataForClientBean;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class AIOAnimationControlManager$7
  implements Function0<Unit>
{
  AIOAnimationControlManager$7(AIOAnimationControlManager paramAIOAnimationControlManager, TroopGiftData paramTroopGiftData) {}
  
  public Unit a()
  {
    Object localObject1 = this.b;
    ((AIOAnimationControlManager)localObject1).a = 1;
    localObject1 = (List)((AIOAnimationControlManager)localObject1).e.get(this.a.giftData.dataForClient.troopUin);
    if (localObject1 != null) {
      try
      {
        ((List)localObject1).remove(this.a);
      }
      finally {}
    }
    if (localObject2.size() != 0) {
      this.b.j();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.7
 * JD-Core Version:    0.7.0.1
 */