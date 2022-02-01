package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.MutiPickerView;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONArray;

class PickerJsPlugin$5
  implements Runnable
{
  PickerJsPlugin$5(PickerJsPlugin paramPickerJsPlugin, int paramInt1, int paramInt2, JSONArray paramJSONArray, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (PickerJsPlugin.access$100(this.this$0) != null)
    {
      PickerJsPlugin.access$100(this.this$0).setDisplayedValues(this.val$column, this.val$current, JSONUtil.jsonArrayToStringArray(this.val$jsonArray));
      this.val$req.ok();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */