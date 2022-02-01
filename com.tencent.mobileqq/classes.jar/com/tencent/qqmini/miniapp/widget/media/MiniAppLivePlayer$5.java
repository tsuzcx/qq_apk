package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

class MiniAppLivePlayer$5
  implements Runnable
{
  MiniAppLivePlayer$5(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void run()
  {
    if (this.this$0.isBusyInChangeScreen) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.atyRef == null);
      localActivity = (Activity)this.this$0.atyRef.get();
    } while ((localActivity == null) || (MiniAppLivePlayer.access$800(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverLiveView)) || (!this.this$0.isFullScreen));
    this.this$0.isFullScreen = false;
    MiniAppLivePlayer.access$700(this.this$0);
    IPage localIPage = this.this$0.baseRuntime.getPage();
    if (!(localIPage instanceof AppBrandPageContainer))
    {
      QMLog.d("MiniAppLivePlayer", "Page is invalid");
      return;
    }
    this.this$0.doSmallScreen(localActivity, (AppBrandPageContainer)localIPage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.5
 * JD-Core Version:    0.7.0.1
 */