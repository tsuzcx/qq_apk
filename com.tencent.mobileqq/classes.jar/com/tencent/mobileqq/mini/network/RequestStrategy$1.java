package com.tencent.mobileqq.mini.network;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class RequestStrategy$1
  implements Runnable
{
  RequestStrategy$1(RequestStrategy paramRequestStrategy) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    boolean bool = true;
    if (NetConnInfoCenter.getActiveNetIpFamily(true) != 2) {
      bool = false;
    }
    RequestStrategy.access$002((RequestStrategy)localObject, bool);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateIPv6Status ipv6: ");
    ((StringBuilder)localObject).append(RequestStrategy.access$000(this.this$0));
    QLog.d("MiniAppInterface", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.RequestStrategy.1
 * JD-Core Version:    0.7.0.1
 */