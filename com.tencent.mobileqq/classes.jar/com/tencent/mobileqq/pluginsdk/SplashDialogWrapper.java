package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public final class SplashDialogWrapper
{
  private Dialog mBase;
  private Context mContext;
  private Handler mHandler = new SplashDialogWrapper.InternalHandler(this);
  private boolean mOnlyCheckID;
  private String mPluginApk;
  private String mPluginName;
  private BroadcastReceiver mReceiver;
  private int mTimeOut;
  
  public SplashDialogWrapper(Context paramContext, Dialog paramDialog, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    this.mContext = paramContext;
    this.mBase = paramDialog;
    this.mPluginApk = paramString2;
    this.mPluginName = paramString1;
    this.mOnlyCheckID = paramBoolean;
    this.mTimeOut = paramInt;
  }
  
  public void dismiss()
  {
    if (this.mReceiver != null) {}
    try
    {
      this.mContext.unregisterReceiver(this.mReceiver);
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "SplashDialogWrapper.dismiss unregisterReceiver");
      }
      this.mReceiver = null;
      this.mHandler.removeMessages(0);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        try
        {
          this.mBase.dismiss();
          return;
        }
        catch (Exception localException) {}
        localIllegalArgumentException = localIllegalArgumentException;
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
  
  public void show()
  {
    this.mHandler.sendEmptyMessageDelayed(0, this.mTimeOut);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_launch_completed");
    this.mReceiver = new SplashDialogWrapper.LaunchCompletedObserver(this, this.mPluginName, this.mPluginApk);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "SplashDialogWrapper.show registerReceiver");
    }
    try
    {
      this.mContext.registerReceiver(this.mReceiver, localIntentFilter);
      this.mBase.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.SplashDialogWrapper
 * JD-Core Version:    0.7.0.1
 */