package com.tencent.mobileqq.persistence.backup.impl;

import java.io.File;
import mqq.app.AppRuntime;

class DBBackupServiceImpl$1
  implements Runnable
{
  DBBackupServiceImpl$1(DBBackupServiceImpl paramDBBackupServiceImpl, AppRuntime paramAppRuntime, File paramFile1, File paramFile2, File paramFile3) {}
  
  public void run()
  {
    boolean bool = DBBackupServiceImpl.access$000(this.this$0, this.a, this.b, this.c);
    DBBackupServiceImpl.access$100(this.this$0, bool, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */