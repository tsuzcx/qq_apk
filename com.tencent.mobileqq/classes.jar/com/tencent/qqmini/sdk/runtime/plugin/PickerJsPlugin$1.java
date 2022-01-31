package com.tencent.qqmini.sdk.runtime.plugin;

import begz;
import beka;
import beks;
import bfeh;
import org.json.JSONArray;

class PickerJsPlugin$1
  implements Runnable
{
  PickerJsPlugin$1(PickerJsPlugin paramPickerJsPlugin, JSONArray paramJSONArray, int paramInt, beka parambeka) {}
  
  public void run()
  {
    bfeh localbfeh = new bfeh(PickerJsPlugin.access$000(this.this$0).a());
    String[] arrayOfString = beks.a(this.val$array);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localbfeh.a(arrayOfString);
      localbfeh.b(0);
      localbfeh.a(arrayOfString.length - 1);
      localbfeh.c(this.val$currentIndex);
      localbfeh.a(this.val$currentIndex, new PickerJsPlugin.1.1(this));
    }
    localbfeh.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */