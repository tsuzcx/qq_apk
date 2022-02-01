package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.qqmini.minigame.ui.RaffleSuccessDialog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class RaffleJsPlugin$4
  implements Runnable
{
  RaffleJsPlugin$4(RaffleJsPlugin paramRaffleJsPlugin, Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5) {}
  
  public void run()
  {
    RaffleJsPlugin localRaffleJsPlugin = this.this$0;
    RaffleJsPlugin.access$902(localRaffleJsPlugin, new RaffleSuccessDialog(this.val$context, RaffleJsPlugin.access$1000(localRaffleJsPlugin), RaffleJsPlugin.access$1100(this.this$0)));
    if (!RaffleJsPlugin.access$900(this.this$0).setDrawable(this.val$logoDrawable, this.val$wishingImgDrawable, this.val$prizeDrawable, this.val$setAfterReceiveDrawable, this.val$goBackMainButtonDrawable))
    {
      RaffleJsPlugin.access$800(this.this$0, this.val$context);
      RaffleJsPlugin.access$600(this.this$0, 4);
      return;
    }
    RaffleJsPlugin.access$900(this.this$0).show();
    QMLog.d(RaffleJsPlugin.access$200(), "showGameSuccessDialog show success");
    RaffleJsPlugin.access$1200(this.this$0, "xiaoyouxi_choujiang", "exp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */