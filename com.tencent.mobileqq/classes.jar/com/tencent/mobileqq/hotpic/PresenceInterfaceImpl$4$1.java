package com.tencent.mobileqq.hotpic;

import com.tencent.qphone.base.util.QLog;

class PresenceInterfaceImpl$4$1
  implements Runnable
{
  PresenceInterfaceImpl$4$1(PresenceInterfaceImpl.4 param4) {}
  
  public void run()
  {
    PresenceInterfaceImpl.a(this.a.b, true);
    PresenceInterfaceImpl.b(this.a.a, false);
    this.a.b.c.b(-11);
    QLog.d("PresenceInterfaceImpl", 2, "saveUserPermission false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.4.1
 * JD-Core Version:    0.7.0.1
 */