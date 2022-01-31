package com.tencent.mobileqq.nearby;

import atat;
import atyq;
import avpq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class NearbyProxy$1
  implements Runnable
{
  public NearbyProxy$1(atat paramatat) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProxy", 2, "receive msg_notify_new_msg in Main,updateNearbyNumAppinfo start..");
    }
    ((avpq)this.this$0.a.getManager(36)).a = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = atyq.a(this.this$0.a, true);
    this.this$0.a(4102, new Object[] { localAppInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.1
 * JD-Core Version:    0.7.0.1
 */