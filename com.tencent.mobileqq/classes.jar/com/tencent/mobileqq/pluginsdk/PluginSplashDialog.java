package com.tencent.mobileqq.pluginsdk;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;

public class PluginSplashDialog
  extends Dialog
{
  private Handler a = new a(this);
  private BroadcastReceiver b;
  private int c;
  private String d;
  private String e;
  
  public PluginSplashDialog(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    super(paramContext, paramInt1);
    this.c = paramInt2;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public void dismiss()
  {
    if (this.b != null) {}
    try
    {
      getContext().unregisterReceiver(this.b);
      this.b = null;
      this.a.removeMessages(0);
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
    this.a.sendEmptyMessageDelayed(0, this.c);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_launch_completed");
    this.b = new b(this.d, this.e);
    try
    {
      getContext().registerReceiver(this.b, localIntentFilter);
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
  
  public static class LaunchCompletedIntent
    extends Intent
  {
    public static final String ACTION_LAUNCH_COMPLETED = "action_launch_completed";
    public static final String PARAM_PLUGIN_APK = "plugin_apk";
    public static final String PARAM_PLUGIN_NAME = "plugin_name";
  }
  
  private static class a
    extends Handler
  {
    public static final int a = 0;
    private Dialog b;
    
    public a(Dialog paramDialog)
    {
      this.b = paramDialog;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      try
      {
        this.b.dismiss();
        return;
      }
      catch (Exception paramMessage) {}
    }
  }
  
  private class b
    extends BroadcastReceiver
  {
    private String b;
    private String c;
    
    public b(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getStringExtra("plugin_apk");
      paramIntent = paramIntent.getStringExtra("plugin_name");
      if ((this.c.equalsIgnoreCase(paramContext)) && (this.b.equalsIgnoreCase(paramIntent))) {}
      try
      {
        PluginSplashDialog.this.dismiss();
        return;
      }
      catch (Exception paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginSplashDialog
 * JD-Core Version:    0.7.0.1
 */