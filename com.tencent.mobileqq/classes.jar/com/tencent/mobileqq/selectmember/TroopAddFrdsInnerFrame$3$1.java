package com.tencent.mobileqq.selectmember;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopAddFrdsInnerFrame$3$1
  implements Runnable
{
  TroopAddFrdsInnerFrame$3$1(TroopAddFrdsInnerFrame.3 param3, List paramList) {}
  
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
        QLog.d("TroopAddFrdsInnerFrame", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.b.a.f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_update_time");
      localStringBuilder.append(this.b.a.h.getCurrentAccountUin());
      localObject = ((SelectMemberActivity)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_update_time");
      localStringBuilder.append(this.b.a.c);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      TroopAddFrdsInnerFrame.a(this.b.a, this.b.a.c, this.a);
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
        QLog.e("TroopAddFrdsInnerFrame", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.3.1
 * JD-Core Version:    0.7.0.1
 */