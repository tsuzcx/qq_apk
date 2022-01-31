package com.tencent.mobileqq.register;

import ajyc;
import android.content.Intent;
import avpw;
import axqw;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;

public class QueryAccount$1
  implements Runnable
{
  public QueryAccount$1(avpw paramavpw, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.a;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
      return;
    }
    Object localObject1 = localObject2;
    if (!((String)localObject2).startsWith("http://")) {
      localObject1 = "http://" + (String)localObject2;
    }
    localObject2 = new Intent(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("selfSet_leftViewText", ajyc.a(2131711221));
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    axqw.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800665B", "0X800665B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.1
 * JD-Core Version:    0.7.0.1
 */