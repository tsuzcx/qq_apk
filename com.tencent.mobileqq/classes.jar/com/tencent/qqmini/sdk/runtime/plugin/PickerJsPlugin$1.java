package com.tencent.qqmini.sdk.runtime.plugin;

import bgho;
import bgkd;
import bgkz;
import bhfr;
import org.json.JSONArray;

class PickerJsPlugin$1
  implements Runnable
{
  PickerJsPlugin$1(PickerJsPlugin paramPickerJsPlugin, JSONArray paramJSONArray, int paramInt, bgkd parambgkd) {}
  
  public void run()
  {
    bhfr localbhfr = new bhfr(PickerJsPlugin.access$000(this.this$0).a());
    String[] arrayOfString = bgkz.a(this.val$array);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localbhfr.a(arrayOfString);
      localbhfr.b(0);
      localbhfr.a(arrayOfString.length - 1);
      localbhfr.c(this.val$currentIndex);
      localbhfr.a(this.val$currentIndex, new PickerJsPlugin.1.1(this));
    }
    localbhfr.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */