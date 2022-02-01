package com.tencent.mobileqq.hotpic;

import com.tencent.qphone.base.util.QLog;

class PresenceInterfaceImpl$3$1
  implements Runnable
{
  PresenceInterfaceImpl$3$1(PresenceInterfaceImpl.3 param3) {}
  
  public void run()
  {
    PresenceInterfaceImpl.b(this.a.a, true);
    PresenceInterfaceImpl.a(this.a.b, true);
    this.a.b.a(0, this.a.b.c);
    QLog.d("PresenceInterfaceImpl", 2, "saveUserPermission true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.3.1
 * JD-Core Version:    0.7.0.1
 */