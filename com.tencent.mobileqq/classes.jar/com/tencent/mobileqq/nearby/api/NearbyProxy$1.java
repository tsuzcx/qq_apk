package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class NearbyProxy$1
  implements Runnable
{
  NearbyProxy$1(NearbyProxy paramNearbyProxy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProxy", 2, "receive msg_notify_new_msg in Main,updateNearbyNumAppinfo start..");
    }
    com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper.a = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).updateNearbyNumAppinfo(this.this$0.a, true);
    this.this$0.a(4102, new Object[] { localAppInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy.1
 * JD-Core Version:    0.7.0.1
 */