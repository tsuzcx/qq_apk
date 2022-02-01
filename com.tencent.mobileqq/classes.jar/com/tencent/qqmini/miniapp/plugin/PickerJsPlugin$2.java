package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.MutiPickerView;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class PickerJsPlugin$2
  implements Runnable
{
  PickerJsPlugin$2(PickerJsPlugin paramPickerJsPlugin, String[][] paramArrayOfString, int[] paramArrayOfInt, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    if (PickerJsPlugin.access$100(this.this$0) == null) {
      PickerJsPlugin.access$102(this.this$0, new MutiPickerView(PickerJsPlugin.access$200(this.this$0).getAttachedActivity()));
    }
    PickerJsPlugin.access$100(this.this$0).setDisplayedValues(this.val$mutiArray);
    PickerJsPlugin.access$100(this.this$0).setCurrentIndex(this.val$curValue);
    PickerJsPlugin.access$100(this.this$0).setOnConfirmListener(new PickerJsPlugin.2.1(this));
    PickerJsPlugin.access$100(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.PickerJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */