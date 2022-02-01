package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class TroopMemberListRefresher$1$1
  implements Runnable
{
  TroopMemberListRefresher$1$1(TroopMemberListRefresher.1 param1) {}
  
  public void run()
  {
    try
    {
      QLog.e("RefreshMemberList", 4, "onUpdateTroopGetMemberList - success");
      String str = TroopMemberListRefresher.a(this.a.a, this.a.a.b);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      SharedPreferences.Editor localEditor = this.a.a.c.getSharedPreferences("last_update_time", 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_update_time");
      localStringBuilder.append(str);
      localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      this.a.a.d.obtainMessage(1).sendToTarget();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher.1.1
 * JD-Core Version:    0.7.0.1
 */