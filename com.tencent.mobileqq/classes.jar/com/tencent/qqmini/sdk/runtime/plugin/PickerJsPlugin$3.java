package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import behq;
import bekr;
import bfep;
import bfes;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, String paramString, bekr parambekr, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bfes localbfes = new bfes(PickerJsPlugin.access$400(this.this$0).a());
    int i = bfep.c(this.val$date);
    int j = bfep.d(this.val$date);
    int k = bfep.e(this.val$date);
    localbfes.a(i, j, k, new PickerJsPlugin.3.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localbfes.a(bfep.a(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localbfes.b(bfep.a(str));
    }
    localbfes.a(i, j, k);
    this.this$0.updateDataPickerFields(localbfes, this.val$fields);
    localbfes.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */