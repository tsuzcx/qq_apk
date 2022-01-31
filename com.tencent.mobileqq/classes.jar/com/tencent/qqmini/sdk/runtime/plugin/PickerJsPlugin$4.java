package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bglv;
import bgok;
import bhiu;
import bhkb;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$4
  implements Runnable
{
  PickerJsPlugin$4(PickerJsPlugin paramPickerJsPlugin, Date paramDate, bgok parambgok, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bhkb localbhkb = new bhkb(PickerJsPlugin.access$500(this.this$0).a());
    localbhkb.a(bhiu.a(this.val$date), bhiu.b(this.val$date), new PickerJsPlugin.4.1(this));
    localbhkb.a(true);
    Object localObject = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bhiu.a((String)localObject);
      localbhkb.b(bhiu.a((Date)localObject));
      localbhkb.d(bhiu.b((Date)localObject));
    }
    localObject = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bhiu.a((String)localObject);
      localbhkb.a(bhiu.a((Date)localObject));
      localbhkb.c(bhiu.b((Date)localObject));
    }
    localbhkb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */