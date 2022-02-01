package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class DoutuServiceImpl$3
  implements Runnable
{
  DoutuServiceImpl$3(DoutuServiceImpl paramDoutuServiceImpl, String paramString1, String paramString2, DoutuItem paramDoutuItem) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "postGetDoutuList : run begin .");
    }
    try
    {
      if (DoutuServiceImpl.access$000(this.this$0) != null)
      {
        DoutuServiceImpl.access$102(this.this$0, 1);
        NewIntent localNewIntent = new NewIntent(DoutuServiceImpl.access$000(this.this$0).getApp(), DoutuServlet.class);
        localNewIntent.putExtra("KEY_CMD", 1);
        DoutuServiceImpl.access$200(this.this$0, localNewIntent, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem);
        DoutuServiceImpl.access$300(this.this$0, localNewIntent, this.jdField_a_of_type_JavaLangString);
        DoutuServiceImpl.access$000(this.this$0).startServlet(localNewIntent);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DoutuServiceImpl", 1, "postGetDoutuList : error.", localThrowable);
      DoutuServiceImpl.access$102(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */