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
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (((SharedPreferences)localObject).getBoolean(str + DBFixManager.d, false))
    {
      this.this$0.a();
      if ((((SharedPreferences)localObject).getInt(str + DBFixManager.e, 0) < DBFixManager.jdField_a_of_type_Int) && (DBFixManager.jdField_a_of_type_Boolean)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new DBFixManager.1.1(this));
      }
    }
    else
    {
      return;
    }
    QLog.d(DBFixManager.a(), 1, "DBFixDialogUI 1, max count, delete db");
    this.this$0.b(false);
    this.this$0.c();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.d);
    ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.e);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager.1
 * JD-Core Version:    0.7.0.1
 */