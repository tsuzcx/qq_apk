package com.tencent.qqmini.sdk.plugins;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class DataJsPlugin$15
  implements Handler.Callback
{
  DataJsPlugin$15(DataJsPlugin paramDataJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.val$req.fail();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.DataJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */