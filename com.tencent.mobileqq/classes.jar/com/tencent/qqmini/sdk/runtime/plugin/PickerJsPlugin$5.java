package com.tencent.qqmini.sdk.runtime.plugin;

import bgkd;
import bgkz;
import bhfo;
import org.json.JSONArray;

class PickerJsPlugin$5
  implements Runnable
{
  PickerJsPlugin$5(PickerJsPlugin paramPickerJsPlugin, int paramInt1, int paramInt2, JSONArray paramJSONArray, bgkd parambgkd) {}
  
  public void run()
  {
    if (PickerJsPlugin.access$100(this.this$0) != null)
    {
      PickerJsPlugin.access$100(this.this$0).a(this.val$column, this.val$current, bgkz.a(this.val$jsonArray));
      this.val$req.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */