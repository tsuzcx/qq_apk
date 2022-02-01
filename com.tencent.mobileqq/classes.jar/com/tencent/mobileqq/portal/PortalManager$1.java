package com.tencent.mobileqq.portal;

import com.tencent.qphone.base.util.QLog;

class PortalManager$1
  implements Runnable
{
  PortalManager$1(PortalManager paramPortalManager, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    if (this.this$0.g != null)
    {
      long l1 = this.a;
      long l2;
      if ((l1 > 0L) && (l1 <= 60000L))
      {
        l1 = PortalManager.a;
        l2 = this.a;
        if (l1 != l2)
        {
          PortalManager.a = l2;
          if (this.this$0.g.grebInterval != PortalManager.a)
          {
            this.this$0.g.grebInterval = PortalManager.a;
            j = 1;
            break label88;
          }
        }
      }
      int j = 0;
      label88:
      int i = j;
      if (this.b != -1L)
      {
        l1 = PortalManager.b;
        l2 = this.b;
        i = j;
        if (l1 != l2)
        {
          PortalManager.b = l2;
          i = j;
          if (this.this$0.g.reportActiveInterval != PortalManager.b)
          {
            this.this$0.g.reportActiveInterval = PortalManager.b;
            i = 1;
          }
        }
      }
      j = i;
      if (this.c != -1L)
      {
        l1 = PortalManager.c;
        l2 = this.c;
        j = i;
        if (l1 != l2)
        {
          PortalManager.c = l2;
          j = i;
          if (this.this$0.g.reportNormalInterval != PortalManager.c)
          {
            this.this$0.g.reportNormalInterval = PortalManager.c;
            j = 1;
          }
        }
      }
      Object localObject;
      if (j != 0)
      {
        localObject = this.this$0;
        ((PortalManager)localObject).a(false, 6, 1000L, ((PortalManager)localObject).g);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sGrabInterval = ");
        ((StringBuilder)localObject).append(PortalManager.a);
        ((StringBuilder)localObject).append(",sReportActiveInterval = ");
        ((StringBuilder)localObject).append(PortalManager.b);
        ((StringBuilder)localObject).append(",sReportNormalInterval = ");
        ((StringBuilder)localObject).append(PortalManager.c);
        QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.1
 * JD-Core Version:    0.7.0.1
 */