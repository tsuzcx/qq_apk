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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateConfig=");
      localStringBuilder.append(localJSONObject.toString());
      LogUtility.c("TAMST_WAKE", localStringBuilder.toString());
      this.this$0.a(localJSONObject);
    }
    catch (Throwable localThrowable)
    {
      LogUtility.e("OpenConfig", localThrowable.getMessage());
    }
    this.this$0.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.OpenConfig.2
 * JD-Core Version:    0.7.0.1
 */