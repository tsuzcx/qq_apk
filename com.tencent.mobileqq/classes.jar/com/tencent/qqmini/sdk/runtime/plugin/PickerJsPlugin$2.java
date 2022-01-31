package com.tencent.qqmini.sdk.runtime.plugin;

import bgho;
import bgkd;
import bhfo;

class PickerJsPlugin$2
  implements Runnable
{
  PickerJsPlugin$2(PickerJsPlugin paramPickerJsPlugin, String[][] paramArrayOfString, int[] paramArrayOfInt, bgkd parambgkd) {}
  
  public void run()
  {
    if (PickerJsPlugin.access$100(this.this$0) == null) {
      PickerJsPlugin.access$102(this.this$0, new bhfo(PickerJsPlugin.access$200(this.this$0).a()));
    }
    PickerJsPlugin.access$100(this.this$0).a(this.val$mutiArray);
    PickerJsPlugin.access$100(this.this$0).a(this.val$curValue);
    PickerJsPlugin.access$100(this.this$0).a(new PickerJsPlugin.2.1(this));
    PickerJsPlugin.access$100(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */