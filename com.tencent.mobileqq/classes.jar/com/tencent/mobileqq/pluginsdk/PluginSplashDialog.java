package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class PluginSplashDialog
  extends ReportDialog
{
  private Handler mHandler = new PluginSplashDialog.InternalHandler(this);
  private String mPluginApk;
  private String mPluginName;
  private BroadcastReceiver mReceiver = null;
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
    if (this.mReceiver != null)
    {
      try
      {
        getContext().unregisterReceiver(this.mReceiver);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      this.mReceiver = null;
    }
    this.mHandler.removeMessages(0);
    super.dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginSplashDialog
 * JD-Core Version:    0.7.0.1
 */