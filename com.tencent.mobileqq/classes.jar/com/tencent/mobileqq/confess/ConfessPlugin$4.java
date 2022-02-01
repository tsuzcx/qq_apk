package com.tencent.mobileqq.confess;

import com.tencent.qphone.base.util.QLog;

class ConfessPlugin$4
  implements Runnable
{
  ConfessPlugin$4(ConfessPlugin paramConfessPlugin) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mProcessShareRunable mLastShareData:");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_OrgJsonJSONObject);
      ((StringBuilder)localObject).append(" mHeaderLoader:");
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader);
      QLog.i("ConfessPlugin", 4, ((StringBuilder)localObject).toString());
    }
    if (this.this$0.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader == null) {
        return;
      }
      localObject = this.this$0;
      ConfessPlugin.a((ConfessPlugin)localObject, ((ConfessPlugin)localObject).jdField_a_of_type_OrgJsonJSONObject);
      this.this$0.jdField_a_of_type_OrgJsonJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.4
 * JD-Core Version:    0.7.0.1
 */