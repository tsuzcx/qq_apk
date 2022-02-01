package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.qqmini.minigame.ui.RaffleFailDialog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RaffleJsPlugin$6
  implements Runnable
{
  RaffleJsPlugin$6(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    RaffleJsPlugin.access$002(this.this$0, new RaffleFailDialog(this.val$context, RaffleJsPlugin.access$1000(this.this$0), RaffleJsPlugin.access$1500(this.this$0)));
    if (!RaffleJsPlugin.access$000(this.this$0).setDrawable(this.val$failDrawable, this.val$shareButtonDrawable, this.val$watchAdButtonDrawable))
    {
      RaffleJsPlugin.access$1400(this.this$0, this.val$context);
      RaffleJsPlugin.access$600(this.this$0, 6);
      return;
    }
    RaffleJsPlugin.access$000(this.this$0).setCanShare(this.val$canShare);
    RaffleJsPlugin.access$000(this.this$0).setCanWatchAd(this.val$canWatchAd);
    RaffleJsPlugin.access$000(this.this$0).show();
    QMLog.d(RaffleJsPlugin.access$200(), "showGameFailDialog show success");
    RaffleJsPlugin.access$1600(this.this$0, this.val$canShare, this.val$canWatchAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */