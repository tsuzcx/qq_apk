package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import com.tencent.qphone.base.util.QLog;

class IVOfflinePluginImpl$2
  extends Handler
{
  IVOfflinePluginImpl$2(IVOfflinePluginImpl paramIVOfflinePluginImpl) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (IVOfflinePluginImpl.access$200(this.this$0)) {}
    do
    {
      return;
      if (paramMessage.arg1 == 1)
      {
        IVOfflinePluginImpl.access$302(this.this$0, paramMessage.arg2);
        paramMessage = (String)paramMessage.obj;
        IVOfflinePluginImpl.access$400(this.this$0).loadUrl(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.i(IVOfflinePluginImpl.access$000(this.this$0), 2, "mCheckupHandler loadUrl start");
        }
        IVOfflinePluginImpl.access$500(this.this$0, paramMessage);
        return;
      }
    } while (paramMessage.arg1 != 2);
    if (QLog.isDevelopLevel()) {
      QLog.i(IVOfflinePluginImpl.access$000(this.this$0), 4, "checkOfflineUpBack refresh current url");
    }
    IVOfflinePluginImpl.access$600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVOfflinePluginImpl.2
 * JD-Core Version:    0.7.0.1
 */