package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bbrq;
import bbrr;
import com.tencent.qphone.base.util.QLog;

public class TroopMemberListRefresher$1$1
  implements Runnable
{
  public TroopMemberListRefresher$1$1(bbrr parambbrr) {}
  
  public void run()
  {
    try
    {
      QLog.e("RefreshMemberList", 4, "onUpdateTroopGetMemberList - success");
      String str = bbrq.a(this.a.a, this.a.a.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      this.a.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("last_update_time", 4).edit().putLong("key_last_update_time" + str, System.currentTimeMillis()).commit();
      this.a.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1).sendToTarget();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher.1.1
 * JD-Core Version:    0.7.0.1
 */