package com.tencent.qqmini.sdk.plugins;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class ShareJsPlugin$6
  implements DialogInterface.OnCancelListener
{
  ShareJsPlugin$6(ShareJsPlugin paramShareJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.val$req.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ShareJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */