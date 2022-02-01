package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;

class TelephonyJsPlugin$2
  implements Runnable
{
  TelephonyJsPlugin$2(TelephonyJsPlugin paramTelephonyJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void run()
  {
    ActionSheet localActionSheet = ActionSheet.create(TelephonyJsPlugin.access$100(this.this$0).getAttachedActivity());
    localActionSheet.addButton("创建新联系人", 7);
    localActionSheet.addButton("添加到现有联系人", 7);
    localActionSheet.setOnButtonClickListener(new TelephonyJsPlugin.2.1(this, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.TelephonyJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */