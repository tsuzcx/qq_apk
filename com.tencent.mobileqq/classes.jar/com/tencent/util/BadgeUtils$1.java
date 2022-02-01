package com.tencent.util;

import android.content.Context;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

final class BadgeUtils$1
  implements Runnable
{
  BadgeUtils$1(int paramInt1, Context paramContext, int paramInt2) {}
  
  public void run()
  {
    BadgeUtilImpl.setLimitCount(this.jdField_a_of_type_Int);
    try
    {
      BadgeUtilImpl.setBadge(this.jdField_a_of_type_AndroidContentContext, this.b);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BadgeUtilImpl", 2, "badge not support");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.BadgeUtils.1
 * JD-Core Version:    0.7.0.1
 */