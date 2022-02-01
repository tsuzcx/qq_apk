package com.tencent.mobileqq.gamecenter.util;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;

class QQGameTroopManager$5
  implements Runnable
{
  QQGameTroopManager$5(QQGameTroopManager paramQQGameTroopManager, Activity paramActivity) {}
  
  public void run()
  {
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).notifyListOrSearchChange(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager.5
 * JD-Core Version:    0.7.0.1
 */