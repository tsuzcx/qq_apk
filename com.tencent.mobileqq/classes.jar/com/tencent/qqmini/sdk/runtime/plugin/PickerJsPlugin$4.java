package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgho;
import bgkd;
import bhen;
import bhfu;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$4
  implements Runnable
{
  PickerJsPlugin$4(PickerJsPlugin paramPickerJsPlugin, Date paramDate, bgkd parambgkd, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bhfu localbhfu = new bhfu(PickerJsPlugin.access$500(this.this$0).a());
    localbhfu.a(bhen.a(this.val$date), bhen.b(this.val$date), new PickerJsPlugin.4.1(this));
    localbhfu.a(true);
    Object localObject = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bhen.a((String)localObject);
      localbhfu.b(bhen.a((Date)localObject));
      localbhfu.d(bhen.b((Date)localObject));
    }
    localObject = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bhen.a((String)localObject);
      localbhfu.a(bhen.a((Date)localObject));
      localbhfu.c(bhen.b((Date)localObject));
    }
    localbhfu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */