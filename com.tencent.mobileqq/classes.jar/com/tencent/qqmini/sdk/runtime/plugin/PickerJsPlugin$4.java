package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import begz;
import beka;
import bfdy;
import bfek;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$4
  implements Runnable
{
  PickerJsPlugin$4(PickerJsPlugin paramPickerJsPlugin, Date paramDate, beka parambeka, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bfek localbfek = new bfek(PickerJsPlugin.access$500(this.this$0).a());
    localbfek.a(bfdy.a(this.val$date), bfdy.b(this.val$date), new PickerJsPlugin.4.1(this));
    localbfek.a(true);
    Object localObject = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bfdy.a((String)localObject);
      localbfek.b(bfdy.a((Date)localObject));
      localbfek.d(bfdy.b((Date)localObject));
    }
    localObject = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bfdy.a((String)localObject);
      localbfek.a(bfdy.a((Date)localObject));
      localbfek.c(bfdy.b((Date)localObject));
    }
    localbfek.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */