package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bglv;
import bgok;
import bhiu;
import bhjb;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, String paramString, bgok parambgok, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bhjb localbhjb = new bhjb(PickerJsPlugin.access$400(this.this$0).a());
    int i = bhiu.c(this.val$date);
    int j = bhiu.d(this.val$date);
    int k = bhiu.e(this.val$date);
    localbhjb.a(i, j, k, new PickerJsPlugin.3.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localbhjb.a(bhiu.a(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localbhjb.b(bhiu.a(str));
    }
    localbhjb.a(i, j, k);
    this.this$0.updateDataPickerFields(localbhjb, this.val$fields);
    localbhjb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */