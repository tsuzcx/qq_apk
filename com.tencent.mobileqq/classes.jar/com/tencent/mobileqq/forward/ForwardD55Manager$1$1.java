package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.activity.aio.ForwardUtils;
import tencent.im.oidb.oidb_0xd55.RspBody;

class ForwardD55Manager$1$1
  implements Runnable
{
  ForwardD55Manager$1$1(ForwardD55Manager.1 param1, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    AppInfo localAppInfo = new AppInfo();
    oidb_0xd55.RspBody localRspBody = ForwardUtils.c(this.a);
    if (localRspBody != null) {
      AppInfo.a(localRspBody, this.c.a, localAppInfo);
    }
    ForwardD55Manager.a(this.c.c, this.b);
    ForwardD55Manager.a(this.c.c, localAppInfo);
    this.c.c.a(this.c.b, localAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardD55Manager.1.1
 * JD-Core Version:    0.7.0.1
 */