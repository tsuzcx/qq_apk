package com.tencent.mobileqq.nearby;

import auwd;
import avuf;
import axlx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class NearbyProxy$1
  implements Runnable
{
  public NearbyProxy$1(auwd paramauwd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyProxy", 2, "receive msg_notify_new_msg in Main,updateNearbyNumAppinfo start..");
    }
    ((axlx)this.this$0.a.getManager(36)).a = true;
    BusinessInfoCheckUpdate.AppInfo localAppInfo = avuf.a(this.this$0.a, true);
    this.this$0.a(4102, new Object[] { localAppInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.1
 * JD-Core Version:    0.7.0.1
 */