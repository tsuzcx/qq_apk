package com.tencent.qqmini.sdk.runtime.plugin;

import bglv;
import bgok;
import bgpg;
import bhjy;
import org.json.JSONArray;

class PickerJsPlugin$1
  implements Runnable
{
  PickerJsPlugin$1(PickerJsPlugin paramPickerJsPlugin, JSONArray paramJSONArray, int paramInt, bgok parambgok) {}
  
  public void run()
  {
    bhjy localbhjy = new bhjy(PickerJsPlugin.access$000(this.this$0).a());
    String[] arrayOfString = bgpg.a(this.val$array);
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      localbhjy.a(arrayOfString);
      localbhjy.b(0);
      localbhjy.a(arrayOfString.length - 1);
      localbhjy.c(this.val$currentIndex);
      localbhjy.a(this.val$currentIndex, new PickerJsPlugin.1.1(this));
    }
    localbhjy.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */