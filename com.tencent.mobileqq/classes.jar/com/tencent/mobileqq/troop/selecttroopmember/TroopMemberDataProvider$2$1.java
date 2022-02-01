package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopMemberDataProvider$2$1
  implements Runnable
{
  TroopMemberDataProvider$2$1(TroopMemberDataProvider.2 param2, List paramList) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onUpdateTroopGetMemberList:");
        int i;
        if (this.a == null) {
          i = 0;
        } else {
          i = this.a.size();
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.b.a.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_update_time");
      localStringBuilder.append(this.b.a.a.getCurrentAccountUin());
      localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_update_time");
      localStringBuilder.append(this.b.a.c);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      TroopMemberDataProvider.a(this.b.a, this.b.a.c, this.a);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateTroopGetMemberList:");
        localStringBuilder.append(localException.toString());
        QLog.e("TroopMemberDataProvider", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.2.1
 * JD-Core Version:    0.7.0.1
 */