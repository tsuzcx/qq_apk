package com.tencent.mobileqq.portal;

import com.tencent.qphone.base.util.QLog;

class PortalManager$2
  implements Runnable
{
  PortalManager$2(PortalManager paramPortalManager, PortalManager.RedPacketConfig paramRedPacketConfig) {}
  
  public void run()
  {
    try
    {
      PortalManager.a(this.this$0, this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PortalManager", 2, "report exception =" + localThrowable.getMessage());
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.2
 * JD-Core Version:    0.7.0.1
 */