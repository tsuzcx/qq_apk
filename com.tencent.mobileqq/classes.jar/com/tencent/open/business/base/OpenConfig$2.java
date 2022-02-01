package com.tencent.open.business.base;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import org.json.JSONObject;

class OpenConfig$2
  implements Runnable
{
  OpenConfig$2(OpenConfig paramOpenConfig, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.a(HttpBaseUtil.a("https://qappcenterv6.3g.qq.com/cgi-bin/mapp/mapp_policy_config", "GET", this.a).a);
      LogUtility.c("OpenConfig", localJSONObject.toString());
      this.this$0.a(localJSONObject);
      this.this$0.a = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtility.e("OpenConfig", localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.2
 * JD-Core Version:    0.7.0.1
 */