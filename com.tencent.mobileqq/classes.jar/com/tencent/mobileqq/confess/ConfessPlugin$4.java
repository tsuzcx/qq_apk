package com.tencent.mobileqq.confess;

import com.tencent.qphone.base.util.QLog;

class ConfessPlugin$4
  implements Runnable
{
  ConfessPlugin$4(ConfessPlugin paramConfessPlugin) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessPlugin", 4, "mProcessShareRunable mLastShareData:" + this.this$0.jdField_a_of_type_OrgJsonJSONObject + " mHeaderLoader:" + this.this$0.jdField_a_of_type_Alis);
    }
    if ((this.this$0.jdField_a_of_type_OrgJsonJSONObject == null) || (this.this$0.jdField_a_of_type_Alis == null)) {
      return;
    }
    ConfessPlugin.a(this.this$0, this.this$0.jdField_a_of_type_OrgJsonJSONObject);
    this.this$0.jdField_a_of_type_OrgJsonJSONObject = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessPlugin.4
 * JD-Core Version:    0.7.0.1
 */