package com.tencent.qqmini.sdk.runtime.plugin;

import bdcz;
import bdfz;
import bdgq;
import bdxp;
import org.json.JSONArray;

class PickerJsPlugin$1
  implements Runnable
{
  PickerJsPlugin$1(PickerJsPlugin paramPickerJsPlugin, JSONArray paramJSONArray, int paramInt, bdfz parambdfz) {}
  
  public void run()
  {
    bdxp localbdxp = new bdxp(PickerJsPlugin.access$000(this.this$0).a());
    String[] arrayOfString = bdgq.a(this.val$array);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localbdxp.a(arrayOfString);
      localbdxp.b(0);
      localbdxp.a(arrayOfString.length - 1);
      localbdxp.c(this.val$currentIndex);
      localbdxp.a(this.val$currentIndex, new PickerJsPlugin.1.1(this));
    }
    localbdxp.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */