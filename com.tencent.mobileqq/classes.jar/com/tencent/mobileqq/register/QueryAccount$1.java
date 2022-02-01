package com.tencent.mobileqq.register;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.statistics.ReportController;

class QueryAccount$1
  implements Runnable
{
  QueryAccount$1(QueryAccount paramQueryAccount, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      if (((String)localObject2).length() <= 0) {
        return;
      }
      Object localObject1 = localObject2;
      if (!((String)localObject2).startsWith("http://"))
      {
        localObject1 = localObject2;
        if (!((String)localObject2).startsWith("https://"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131711171));
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      LoginUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, (Intent)localObject2, "/base/browser");
      ReportController.b(this.this$0.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800665B", "0X800665B", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.1
 * JD-Core Version:    0.7.0.1
 */