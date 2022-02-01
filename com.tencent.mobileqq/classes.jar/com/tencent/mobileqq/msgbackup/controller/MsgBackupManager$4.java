package com.tencent.mobileqq.msgbackup.controller;

import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MsgBackupManager$4
  implements IMsgBackupUICallback
{
  MsgBackupManager$4(MsgBackupManager paramMsgBackupManager) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      MsgBackupTimeStats.a("total_transport_cost", null);
      MsgBackupTimeStats.a();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sessionProgress!!! finishedSessions = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", totalSession");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
    }
    MsgBackupManager.a(this.a, paramInt2);
    MsgBackupManager.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {
      i = paramInt1 + 1;
    } else {
      i = paramInt1;
    }
    String str;
    if (MsgBackupManager.b(this.a) == 1)
    {
      str = BaseApplication.getContext().getResources().getString(2131887488);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MsgBackupManager.i);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (MsgBackupManager.b(this.a) == 3)
    {
      str = BaseApplication.getContext().getResources().getString(2131887490);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MsgBackupManager.i);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      str = BaseApplication.getContext().getResources().getString(2131887490);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MsgBackupManager.i);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupUtil.a(MsgBackupManager.c(this.a)));
    localStringBuilder.append("B/s");
    Object localObject = String.format(str, new Object[] { localObject, localStringBuilder.toString() });
    int i = MsgBackupAuthProcessor.a().c();
    if (paramInt1 == paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
      }
      MsgBackupManager.q();
      this.a.a(QBaseActivity.sTopActivity, i);
      return;
    }
    this.a.b(i, (String)localObject);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("speedState!!! increment = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
    }
    MsgBackupManager.a(this.a, paramLong);
    int j = MsgBackupManager.d(this.a);
    int i = j;
    if (j != MsgBackupManager.i) {
      i = j + 1;
    }
    String str;
    if (MsgBackupManager.b(this.a) == 1)
    {
      str = BaseApplication.getContext().getString(2131887488);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MsgBackupManager.i);
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (MsgBackupManager.b(this.a) == 3)
    {
      str = BaseApplication.getContext().getResources().getString(2131887490);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MsgBackupManager.i);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      str = BaseApplication.getContext().getResources().getString(2131887490);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(MsgBackupManager.i);
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupUtil.a(MsgBackupManager.c(this.a)));
    localStringBuilder.append("B/S");
    Object localObject = String.format(str, new Object[] { localObject, localStringBuilder.toString() });
    this.a.b(MsgBackupAuthProcessor.a().c(), (String)localObject);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c(boolean paramBoolean)
  {
    MsgBackupUtil.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MsgBackupTimeStats.b();
    MsgBackupTimeStats.a(null, "total_transport_cost");
  }
  
  public void m_(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.4
 * JD-Core Version:    0.7.0.1
 */