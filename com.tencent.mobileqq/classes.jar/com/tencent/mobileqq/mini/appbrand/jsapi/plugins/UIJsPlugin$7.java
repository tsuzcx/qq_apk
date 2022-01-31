package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.DateUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.DatePickerView;
import java.util.Date;
import org.json.JSONObject;

class UIJsPlugin$7
  implements Runnable
{
  UIJsPlugin$7(UIJsPlugin paramUIJsPlugin, Date paramDate, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    DatePickerView localDatePickerView = new DatePickerView(this.this$0.jsPluginEngine.getActivityContext());
    int i = DateUtils.getYearByDateStr(this.val$date);
    int j = DateUtils.getMonthByDateStr(this.val$date);
    int k = DateUtils.getDayByDateStr(this.val$date);
    localDatePickerView.init(i, j, k, new UIJsPlugin.7.1(this));
    String str = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty(str)) {
      localDatePickerView.setMinDate(DateUtils.dateToLong(str));
    }
    str = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty(str)) {
      localDatePickerView.setMaxDate(DateUtils.dateToLong(str));
    }
    localDatePickerView.updateDate(i, j, k);
    this.this$0.updateDataPickerFields(localDatePickerView, this.val$fields);
    localDatePickerView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */