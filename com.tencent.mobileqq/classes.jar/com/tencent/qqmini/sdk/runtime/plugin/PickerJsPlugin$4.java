package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bdcz;
import bdfz;
import bdxh;
import bdxs;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$4
  implements Runnable
{
  PickerJsPlugin$4(PickerJsPlugin paramPickerJsPlugin, Date paramDate, bdfz parambdfz, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bdxs localbdxs = new bdxs(PickerJsPlugin.access$500(this.this$0).a());
    localbdxs.a(bdxh.a(this.val$date), bdxh.b(this.val$date), new PickerJsPlugin.4.1(this));
    localbdxs.a(true);
    Object localObject = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bdxh.a((String)localObject);
      localbdxs.b(bdxh.a((Date)localObject));
      localbdxs.d(bdxh.b((Date)localObject));
    }
    localObject = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bdxh.a((String)localObject);
      localbdxs.a(bdxh.a((Date)localObject));
      localbdxs.c(bdxh.b((Date)localObject));
    }
    localbdxs.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */