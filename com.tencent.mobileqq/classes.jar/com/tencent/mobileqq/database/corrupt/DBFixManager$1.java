package com.tencent.mobileqq.database.corrupt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class DBFixManager$1
  implements Runnable
{
  DBFixManager$1(DBFixManager paramDBFixManager) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getApplication().getSharedPreferences(DBFixManager.d, 0);
    String str = this.this$0.a.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(DBFixManager.f);
    if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
    {
      this.this$0.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(DBFixManager.g);
      if ((((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0) < DBFixManager.h) && (DBFixManager.j))
      {
        this.this$0.a.runOnUiThread(new DBFixManager.1.1(this));
        return;
      }
      QLog.d(DBFixManager.f(), 1, "DBFixDialogUI 1, max count, delete db");
      this.this$0.b(false);
      this.this$0.c();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(DBFixManager.f);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(DBFixManager.g);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager.1
 * JD-Core Version:    0.7.0.1
 */