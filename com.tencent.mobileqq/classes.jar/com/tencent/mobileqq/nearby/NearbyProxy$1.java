package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMineHelper;
import com.tencent.mobileqq.redtouch.RedTouchManager;
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
    ((RedTouchManager)this.this$0.a.getManager(QQManagerFactory.MGR_RED_TOUCH)).a = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = NearbyMineHelper.a(this.this$0.a, true);
    this.this$0.a(4102, new Object[] { localAppInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.1
 * JD-Core Version:    0.7.0.1
 */