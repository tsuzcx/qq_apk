package com.tencent.qqmini.miniapp.plugin;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.util.DateUtils;
import com.tencent.qqmini.miniapp.widget.TimePickerView;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.util.Date;
import org.json.JSONObject;

class PickerJsPlugin$3
  implements Runnable
{
  PickerJsPlugin$3(PickerJsPlugin paramPickerJsPlugin, Date paramDate, RequestEvent paramRequestEvent, JSONObject paramJSONObject) {}
  
  public void run()
  {
    TimePickerView localTimePickerView = new TimePickerView(PickerJsPlugin.access$400(this.this$0).getAttachedActivity());
    localTimePickerView.init(DateUtils.getHour(this.val$date), DateUtils.getMinute(this.val$date), new PickerJsPlugin.3.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */