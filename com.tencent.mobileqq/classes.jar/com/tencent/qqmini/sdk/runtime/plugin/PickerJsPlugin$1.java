package com.tencent.qqmini.sdk.runtime.plugin;

import behq;
import bekr;
import belj;
import bfey;
import org.json.JSONArray;

class PickerJsPlugin$1
  implements Runnable
{
  PickerJsPlugin$1(PickerJsPlugin paramPickerJsPlugin, JSONArray paramJSONArray, int paramInt, bekr parambekr) {}
  
  public void run()
  {
    bfey localbfey = new bfey(PickerJsPlugin.access$000(this.this$0).a());
    String[] arrayOfString = belj.a(this.val$array);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localbfey.a(arrayOfString);
      localbfey.b(0);
      localbfey.a(arrayOfString.length - 1);
      localbfey.c(this.val$currentIndex);
      localbfey.a(this.val$currentIndex, new PickerJsPlugin.1.1(this));
    }
    localbfey.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */