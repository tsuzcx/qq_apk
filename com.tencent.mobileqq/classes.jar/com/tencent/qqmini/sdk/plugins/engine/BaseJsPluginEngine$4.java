package com.tencent.qqmini.sdk.plugins.engine;

import android.os.Handler.Callback;
import android.os.Message;

class BaseJsPluginEngine$4
  implements Handler.Callback
{
  BaseJsPluginEngine$4(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2) {
        BaseJsPluginEngine.access$600(this.this$0, paramMessage.getData());
      }
    }
    else {
      BaseJsPluginEngine.access$700(this.this$0, paramMessage);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.4
 * JD-Core Version:    0.7.0.1
 */