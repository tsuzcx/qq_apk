package com.tencent.mobileqq.troop.logic;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HWTroopUtils.OnHomeworkTroopIdentityCheckListener;

class HomeworkTroopController$5
  implements HWTroopUtils.OnHomeworkTroopIdentityCheckListener
{
  HomeworkTroopController$5(HomeworkTroopController paramHomeworkTroopController, TroopChatPie paramTroopChatPie) {}
  
  public void a(int paramInt)
  {
    if (!((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramInt)) {
      this.b.b(this.a);
    }
    this.b.e(HWTroopUtils.a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController.5
 * JD-Core Version:    0.7.0.1
 */