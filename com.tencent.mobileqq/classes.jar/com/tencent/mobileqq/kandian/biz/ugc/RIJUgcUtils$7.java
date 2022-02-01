package com.tencent.mobileqq.kandian.biz.ugc;

import android.app.Activity;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.qphone.base.util.QLog;

final class RIJUgcUtils$7
  implements IUserLevelCallBack
{
  RIJUgcUtils$7(Activity paramActivity) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    RIJUgcUtils.a(this.a, paramUserLevelInfo);
    QLog.e("handleDeliverImageMenuItemClick", 1, "here is trying to go to level settings");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils.7
 * JD-Core Version:    0.7.0.1
 */