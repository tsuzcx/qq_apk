package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnDismissListener;

class ShareJsPlugin$5
  implements ActionSheet.OnDismissListener
{
  ShareJsPlugin$5(ShareJsPlugin paramShareJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onDismiss()
  {
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */