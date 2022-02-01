package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuServlet;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class DoutuServiceImpl$4
  implements Runnable
{
  DoutuServiceImpl$4(DoutuServiceImpl paramDoutuServiceImpl, DoutuItem paramDoutuItem, long paramLong, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("postGetRecommendPicList item:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.toString());
      ((StringBuilder)localObject).append(", timeKey:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", uinType:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", uin:");
      ((StringBuilder)localObject).append(this.b);
      QLog.i("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(DoutuServiceImpl.access$000(this.this$0).getApp(), DoutuServlet.class);
    DoutuServiceImpl.access$200(this.this$0, (NewIntent)localObject, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem);
    ((NewIntent)localObject).putExtra("KEY_MD5", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.b);
    ((NewIntent)localObject).putExtra("key_url", this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuItem.c);
    ((NewIntent)localObject).putExtra("KEY_CMD", 6);
    ((NewIntent)localObject).putExtra("key_sequence", this.jdField_a_of_type_Long);
    DoutuServiceImpl.access$300(this.this$0, (NewIntent)localObject, this.b);
    DoutuServiceImpl.access$000(this.this$0).startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */