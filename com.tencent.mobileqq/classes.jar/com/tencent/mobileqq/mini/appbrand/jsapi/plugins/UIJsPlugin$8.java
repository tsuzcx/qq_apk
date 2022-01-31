package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.DateUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.TimePickerView;
import java.util.Date;
import org.json.JSONObject;

class UIJsPlugin$8
  implements Runnable
{
  UIJsPlugin$8(UIJsPlugin paramUIJsPlugin, Date paramDate, JsRuntime paramJsRuntime, String paramString, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    TimePickerView localTimePickerView = new TimePickerView(this.this$0.jsPluginEngine.getActivityContext());
    localTimePickerView.init(DateUtils.getHour(this.val$date), DateUtils.getMinute(this.val$date), new UIJsPlugin.8.1(this));
    localTimePickerView.setIs24HourView(true);
    Object localObject = this.val$rangeJsonObj.optString("start");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = DateUtils.getTimeByStrTime((String)localObject);
      localTimePickerView.setHourMinValue(DateUtils.getHour((Date)localObject));
      localTimePickerView.setMinuteMinValue(DateUtils.getMinute((Date)localObject));
    }
    localObject = this.val$rangeJsonObj.optString("end");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = DateUtils.getTimeByStrTime((String)localObject);
      localTimePickerView.setHourMaxValue(DateUtils.getHour((Date)localObject));
      localTimePickerView.setMinuteMaxValue(DateUtils.getMinute((Date)localObject));
    }
    localTimePickerView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UIJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */