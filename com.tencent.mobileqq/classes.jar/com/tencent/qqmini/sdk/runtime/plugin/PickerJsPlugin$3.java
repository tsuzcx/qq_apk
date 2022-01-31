package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import begz;
import beka;
import bfdy;
import bfeb;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, String paramString, beka parambeka, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bfeb localbfeb = new bfeb(PickerJsPlugin.access$400(this.this$0).a());
    int i = bfdy.c(this.val$date);
    int j = bfdy.d(this.val$date);
    int k = bfdy.e(this.val$date);
    localbfeb.a(i, j, k, new PickerJsPlugin.3.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localbfeb.a(bfdy.a(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localbfeb.b(bfdy.a(str));
    }
    localbfeb.a(i, j, k);
    this.this$0.updateDataPickerFields(localbfeb, this.val$fields);
    localbfeb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */