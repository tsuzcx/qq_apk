package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.util;

final class QuickAuthorityConfBean$1
  implements Runnable
{
  QuickAuthorityConfBean$1(boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      util.save_pow_test(BaseApplication.getContext(), this.a);
      if (QLog.isColorLevel())
      {
        QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "pow_test ", Boolean.valueOf(this.a) });
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QuickAuthorityConfProcessor", 2, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QuickAuthorityConfBean.1
 * JD-Core Version:    0.7.0.1
 */