package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.PickerView;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONArray;

class PickerJsPlugin$1
  implements Runnable
{
  PickerJsPlugin$1(PickerJsPlugin paramPickerJsPlugin, JSONArray paramJSONArray, int paramInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    PickerView localPickerView = new PickerView(PickerJsPlugin.access$000(this.this$0).getAttachedActivity());
    String[] arrayOfString = JSONUtil.jsonArrayToStringArray(this.val$array);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localPickerView.setDisplayedValues(arrayOfString);
      localPickerView.setMinValue(0);
      localPickerView.setMaxValues(arrayOfString.length - 1);
      localPickerView.setValue(this.val$currentIndex);
      localPickerView.init(this.val$currentIndex, new PickerJsPlugin.1.1(this));
    }
    localPickerView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */