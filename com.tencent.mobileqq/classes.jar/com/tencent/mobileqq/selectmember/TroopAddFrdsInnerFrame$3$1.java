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
        if (this.jdField_a_of_type_JavaUtilList == null) {
          i = 0;
        } else {
          i = this.jdField_a_of_type_JavaUtilList.size();
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("TroopAddFrdsInnerFrame", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$3.a.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_update_time");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$3.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      localObject = ((SelectMemberActivity)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_last_update_time");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$3.a.b);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
      TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$3.a, this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$3.a.b, this.jdField_a_of_type_JavaUtilList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.3.1
 * JD-Core Version:    0.7.0.1
 */