package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import org.json.JSONException;

class AbstractReadInjoyWebShareHelper$3$1
  implements Runnable
{
  AbstractReadInjoyWebShareHelper$3$1(AbstractReadInjoyWebShareHelper.3 param3, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = this.c.this$0.b();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      try
      {
        this.c.this$0.a(this.c.d, this.c.e, this.c.f, this.a, this.b, this.c.g, 13);
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */