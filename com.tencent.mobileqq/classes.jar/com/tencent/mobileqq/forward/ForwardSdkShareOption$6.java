package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import aryl;
import asdb;
import com.tencent.qphone.base.util.QLog;

public class ForwardSdkShareOption$6
  implements Runnable
{
  public ForwardSdkShareOption$6(asdb paramasdb) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--fetch openid timeout");
      }
      this.this$0.j = true;
      this.this$0.x();
    } while (!asdb.a(this.this$0));
    this.this$0.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
    this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
    this.this$0.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", aryl.e.intValue());
    this.this$0.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.6
 * JD-Core Version:    0.7.0.1
 */