package com.tencent.qqmini.minigame.plugins;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R.layout;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;

class RaffleJsPlugin$14
  implements Runnable
{
  RaffleJsPlugin$14(RaffleJsPlugin paramRaffleJsPlugin) {}
  
  public void run()
  {
    Object localObject = RaffleJsPlugin.access$3400(this.this$0).getAttachedActivity();
    RaffleJsPlugin.access$3502(this.this$0, new ReportDialog((Context)localObject));
    RaffleJsPlugin.access$3500(this.this$0).setCancelable(false);
    if (RaffleJsPlugin.access$3500(this.this$0).getWindow() != null)
    {
      RaffleJsPlugin.access$3500(this.this$0).getWindow().requestFeature(1);
      RaffleJsPlugin.access$3500(this.this$0).getWindow().setBackgroundDrawableResource(17170445);
    }
    localObject = LayoutInflater.from((Context)localObject).inflate(R.layout.mini_sdk_full_screen_loading_bar, null);
    RaffleJsPlugin.access$3500(this.this$0).setContentView((View)localObject, new ViewGroup.LayoutParams(-1, -1));
    RaffleJsPlugin.access$3500(this.this$0).show();
    ThreadManager.getUIHandler().postDelayed(new RaffleJsPlugin.14.1(this), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */