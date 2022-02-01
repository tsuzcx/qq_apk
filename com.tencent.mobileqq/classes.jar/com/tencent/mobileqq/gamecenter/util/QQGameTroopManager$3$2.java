package com.tencent.mobileqq.gamecenter.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;

class QQGameTroopManager$3$2
  implements Runnable
{
  QQGameTroopManager$3$2(QQGameTroopManager.3 param3) {}
  
  public void run()
  {
    if (QQGameTroopManager.a(this.a.a) != null) {
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).notifyListOrSearchChange(QQGameTroopManager.a(this.a.a), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.3.2
 * JD-Core Version:    0.7.0.1
 */