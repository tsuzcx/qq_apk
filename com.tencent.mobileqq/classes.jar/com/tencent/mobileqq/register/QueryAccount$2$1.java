package com.tencent.mobileqq.register;

import amtj;
import android.content.Intent;
import azvp;
import azvq;
import bcef;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qphone.base.util.QLog;

public class QueryAccount$2$1
  implements Runnable
{
  public QueryAccount$2$1(azvq paramazvq, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {}
    do
    {
      return;
      Object localObject1 = localObject2;
      if (!((String)localObject2).startsWith("http://"))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("https://")) {
          localObject1 = "https://" + (String)localObject2;
        }
      }
      localObject2 = new Intent(this.jdField_a_of_type_Azvq.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("is_register_uin", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("register_uin_msg", 104);
      ((Intent)localObject2).putExtra("register_uin_class", this.jdField_a_of_type_Azvq.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass().getName());
      this.jdField_a_of_type_Azvq.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
      ((Intent)localObject2).putExtra("selfSet_leftViewText", amtj.a(2131710332));
      bcef.b(this.jdField_a_of_type_Azvq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800665A", "0X800665A", 0, 0, "", "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("QueryAccount", 2, "class name is " + this.jdField_a_of_type_Azvq.a.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.2.1
 * JD-Core Version:    0.7.0.1
 */