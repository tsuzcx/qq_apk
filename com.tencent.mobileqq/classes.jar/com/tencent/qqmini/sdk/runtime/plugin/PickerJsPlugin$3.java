package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgho;
import bgkd;
import bhen;
import bheu;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, String paramString, bgkd parambgkd, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bheu localbheu = new bheu(PickerJsPlugin.access$400(this.this$0).a());
    int i = bhen.c(this.val$date);
    int j = bhen.d(this.val$date);
    int k = bhen.e(this.val$date);
    localbheu.a(i, j, k, new PickerJsPlugin.3.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localbheu.a(bhen.a(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localbheu.b(bhen.a(str));
    }
    localbheu.a(i, j, k);
    this.this$0.updateDataPickerFields(localbheu, this.val$fields);
    localbheu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */