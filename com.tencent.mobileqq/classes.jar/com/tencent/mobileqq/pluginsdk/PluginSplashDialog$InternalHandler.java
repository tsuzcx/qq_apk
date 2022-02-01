package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;

class PluginSplashDialog$InternalHandler
  extends Handler
{
  public static final int MSG_DISMISS = 0;
  private Dialog mDlg = null;
  
  public PluginSplashDialog$InternalHandler(Dialog paramDialog)
  {
    this.mDlg = paramDialog;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    try
    {
      this.mDlg.dismiss();
      return;
    }
    catch (Exception paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginSplashDialog.InternalHandler
 * JD-Core Version:    0.7.0.1
 */