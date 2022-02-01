package com.tencent.mobileqq.msgbackup.controller;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupTimeStats;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
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
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2);
    }
    MsgBackupManager.a(this.a, paramInt2);
    MsgBackupManager.b(this.a, paramInt1);
    if (paramInt1 != paramInt2) {}
    for (int i = paramInt1 + 1;; i = paramInt1)
    {
      String str1;
      String str2;
      if (MsgBackupManager.a(this.a) == 1)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690649);
        str2 = i + "/" + MsgBackupManager.b;
      }
      for (;;)
      {
        str1 = String.format(str1, new Object[] { str2, MsgBackupUtil.a(MsgBackupManager.a(this.a)) + "B/s" });
        i = MsgBackupAuthProcessor.a().a();
        if (paramInt1 != paramInt2) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "sessioncompleted >>>>>>>>>>>>>>>>>");
        }
        MsgBackupManager.m();
        this.a.a(BaseActivity.sTopActivity, i);
        return;
        if (MsgBackupManager.a(this.a) == 3)
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690651);
          str2 = i + "/" + MsgBackupManager.b;
        }
        else
        {
          str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690651);
          str2 = i + "/" + MsgBackupManager.b;
        }
      }
      this.a.b(i, str1);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "speedState!!! increment = " + paramLong);
    }
    MsgBackupManager.a(this.a, paramLong);
    int j = MsgBackupManager.b(this.a);
    int i = j;
    if (j != MsgBackupManager.b) {
      i = j + 1;
    }
    String str1;
    String str2;
    if (MsgBackupManager.a(this.a) == 1)
    {
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690649);
      str2 = i + "/" + MsgBackupManager.b;
    }
    for (;;)
    {
      str1 = String.format(str1, new Object[] { str2, MsgBackupUtil.a(MsgBackupManager.a(this.a)) + "B/S" });
      this.a.b(MsgBackupAuthProcessor.a().a(), str1);
      return;
      if (MsgBackupManager.a(this.a) == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690651);
        str2 = i + "/" + MsgBackupManager.b;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690651);
        str2 = i + "/" + MsgBackupManager.b;
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    MsgBackupUtil.b("MsgBackup.BackupAndMigrateManager", "transportStart is called! isStart = %b", new Object[] { Boolean.valueOf(paramBoolean) });
    MsgBackupTimeStats.b();
    MsgBackupTimeStats.a(null, "total_transport_cost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.4
 * JD-Core Version:    0.7.0.1
 */