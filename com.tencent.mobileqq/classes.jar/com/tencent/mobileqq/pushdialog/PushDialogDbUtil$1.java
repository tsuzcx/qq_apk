package com.tencent.mobileqq.pushdialog;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Date;
import java.util.List;

class PushDialogDbUtil$1
  implements Runnable
{
  PushDialogDbUtil$1(PushDialogDbUtil paramPushDialogDbUtil, EntityManager paramEntityManager, String[] paramArrayOfString, long paramLong1, long paramLong2, PushDialogDbUtil.OnPushDialogDbAction paramOnPushDialogDbAction) {}
  
  public void run()
  {
    synchronized (PushDialogDbUtil.a(this.this$0))
    {
      List localList = this.a.query(PushDialogTemplate.class, true, "mUin=? AND time>=?", this.b, null, null, null, null);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("PushDialogTemplate query: ");
        ((StringBuilder)???).append(this.c);
        ((StringBuilder)???).append(", queryTime: ");
        ((StringBuilder)???).append(new Date(this.d));
        QLog.d("PushDialogDbUtil", 3, ((StringBuilder)???).toString());
      }
      ??? = this.e;
      if (??? != null) {
        ((PushDialogDbUtil.OnPushDialogDbAction)???).a(localList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogDbUtil.1
 * JD-Core Version:    0.7.0.1
 */