package com.tencent.mobileqq.database.corrupt;

import com.tencent.dbfix.DBFix;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DBFixConfigActivity$7$1
  implements Runnable
{
  DBFixConfigActivity$7$1(DBFixConfigActivity.7 param7, File paramFile) {}
  
  public void run()
  {
    Object localObject = this.a.getAbsolutePath();
    QLog.d(DBFixConfigActivity.a, 1, new Object[] { "checkCorruptDB path: ", localObject });
    localObject = DBFix.getInstance().doIntegrityCheck((String)localObject);
    QLog.d(DBFixConfigActivity.a, 1, new Object[] { "checkCorruptDB result: ", localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.7.1
 * JD-Core Version:    0.7.0.1
 */