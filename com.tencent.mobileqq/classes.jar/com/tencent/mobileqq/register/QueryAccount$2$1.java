package com.tencent.mobileqq.register;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class QueryAccount$2$1
  implements Runnable
{
  QueryAccount$2$1(QueryAccount.2 param2, String paramString) {}
  
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
      ((Intent)localObject2).putExtra("is_register_uin", true);
      ((Intent)localObject2).putExtra("isShowAd", false);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("register_uin_msg", 104);
      ((Intent)localObject2).putExtra("register_uin_class", this.b.a.h.getClass().getName());
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      LoginUtils.a(this.b.a.h, (Intent)localObject2, "/base/browser");
      ((Intent)localObject2).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
      ReportController.b(this.b.a.g, "CliOper", "", "", "0X800665A", "0X800665A", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("class name is ");
        ((StringBuilder)localObject1).append(this.b.a.h.getClass().getName());
        QLog.d("QueryAccount", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.2.1
 * JD-Core Version:    0.7.0.1
 */