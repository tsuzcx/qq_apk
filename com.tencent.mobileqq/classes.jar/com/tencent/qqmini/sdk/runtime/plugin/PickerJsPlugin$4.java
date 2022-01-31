package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import behq;
import bekr;
import bfep;
import bffb;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$4
  implements Runnable
{
  PickerJsPlugin$4(PickerJsPlugin paramPickerJsPlugin, Date paramDate, bekr parambekr, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bffb localbffb = new bffb(PickerJsPlugin.access$500(this.this$0).a());
    localbffb.a(bfep.a(this.val$date), bfep.b(this.val$date), new PickerJsPlugin.4.1(this));
    localbffb.a(true);
    Object localObject = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bfep.a((String)localObject);
      localbffb.b(bfep.a((Date)localObject));
      localbffb.d(bfep.b((Date)localObject));
    }
    localObject = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bfep.a((String)localObject);
      localbffb.a(bfep.a((Date)localObject));
      localbffb.c(bfep.b((Date)localObject));
    }
    localbffb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */