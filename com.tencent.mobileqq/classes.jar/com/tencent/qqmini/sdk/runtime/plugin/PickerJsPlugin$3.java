package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bdcz;
import bdfz;
import bdxh;
import bdxj;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, String paramString, bdfz parambdfz, JSONObject paramJSONObject) {}
  
  public void run()
  {
    bdxj localbdxj = new bdxj(PickerJsPlugin.access$400(this.this$0).a());
    int i = bdxh.c(this.val$date);
    int j = bdxh.d(this.val$date);
    int k = bdxh.e(this.val$date);
    localbdxj.a(i, j, k, new PickerJsPlugin.3.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localbdxj.a(bdxh.a(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localbdxj.b(bdxh.a(str));
    }
    localbdxj.a(i, j, k);
    this.this$0.updateDataPickerFields(localbdxj, this.val$fields);
    localbdxj.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */