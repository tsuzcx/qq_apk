package com.tencent.mobileqq.nearby;

import axpp;
import ayob;
import bbbq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class NearbyProxy$1
  implements Runnable
{
  public NearbyProxy$1(axpp paramaxpp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProxy", 2, "receive msg_notify_new_msg in Main,updateNearbyNumAppinfo start..");
    }
    ((bbbq)this.this$0.a.getManager(QQManagerFactory.MGR_RED_TOUCH)).a = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ayob.a(this.this$0.a, true);
    this.this$0.a(4102, new Object[] { localAppInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.1
 * JD-Core Version:    0.7.0.1
 */