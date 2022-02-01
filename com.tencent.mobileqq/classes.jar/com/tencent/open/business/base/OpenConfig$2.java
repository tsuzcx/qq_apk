package com.tencent.open.business.base;

import android.os.Bundle;
import bhzm;
import biaa;
import biar;
import com.tencent.open.base.http.HttpBaseUtil;
import org.json.JSONObject;

public class OpenConfig$2
  implements Runnable
{
  public OpenConfig$2(biar parambiar, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = HttpBaseUtil.a(HttpBaseUtil.a("https://qappcenterv6.3g.qq.com/cgi-bin/mapp/mapp_policy_config", "GET", this.a).a);
      bhzm.c("OpenConfig", localJSONObject.toString());
      this.this$0.a(localJSONObject);
      this.this$0.a = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bhzm.e("OpenConfig", localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.2
 * JD-Core Version:    0.7.0.1
 */