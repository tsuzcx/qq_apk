package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public class PluginSplashDialog
  extends Dialog
{
  private Handler mHandler = new PluginSplashDialog.InternalHandler(this);
  private String mPluginApk;
  private String mPluginName;
  private BroadcastReceiver mReceiver;
  private int mTimeOut;
  
  public PluginSplashDialog(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.mTimeOut = paramInt2;
    this.mPluginName = paramString1;
    this.mPluginApk = paramString2;
  }
  
  public void dismiss()
  {
    if (this.mReceiver != null) {}
    try
    {
      getContext().unregisterReceiver(this.mReceiver);
      this.mReceiver = null;
      this.mHandler.removeMessages(0);
      super.dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void show()
  {
    this.mHandler.sendEmptyMessageDelayed(0, this.mTimeOut);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_launch_completed");
    this.mReceiver = new PluginSplashDialog.LaunchCompletedObserver(this, this.mPluginName, this.mPluginApk);
    try
    {
      getContext().registerReceiver(this.mReceiver, localIntentFilter);
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "PluginSplashDialog RegisterReceiver");
      }
      label74:
      super.show();
      return;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginSplashDialog
 * JD-Core Version:    0.7.0.1
 */