package com.tencent.mobileqq.pushdialog;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;

class PushDialogDbUtil$2
  implements Runnable
{
  PushDialogDbUtil$2(PushDialogDbUtil paramPushDialogDbUtil, EntityManager paramEntityManager, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    synchronized (PushDialogDbUtil.a(this.this$0))
    {
      this.a.remove(this.b);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("PushDialogTemplate delete: ");
        ((StringBuilder)???).append(new Date(this.b.time));
        ((StringBuilder)???).append(",");
        ((StringBuilder)???).append(this.b.mUin);
        ((StringBuilder)???).append(",");
        ((StringBuilder)???).append(this.b.c2c_type);
        QLog.d("PushDialogDbUtil", 3, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.2
 * JD-Core Version:    0.7.0.1
 */