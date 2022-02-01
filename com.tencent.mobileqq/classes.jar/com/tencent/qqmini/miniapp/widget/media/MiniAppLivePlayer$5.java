package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;

class MiniAppLivePlayer$5
  implements Runnable
{
  MiniAppLivePlayer$5(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void run()
  {
    if (this.this$0.isBusyInChangeScreen) {
      return;
    }
    if (this.this$0.atyRef != null)
    {
      Activity localActivity = (Activity)this.this$0.atyRef.get();
      if ((localActivity != null) && (MiniAppLivePlayer.access$800(this.this$0) != null))
      {
        if (!(this.this$0.getParent() instanceof CoverLiveView)) {
          return;
        }
        if (!this.this$0.isFullScreen) {
          return;
        }
        Object localObject = this.this$0;
        ((MiniAppLivePlayer)localObject).isFullScreen = false;
        MiniAppLivePlayer.access$700((MiniAppLivePlayer)localObject);
        localObject = this.this$0.baseRuntime.getPage();
        if (!(localObject instanceof AppBrandPageContainer))
        {
          QMLog.d("MiniAppLivePlayer", "Page is invalid");
          return;
        }
        this.this$0.doSmallScreen(localActivity, (AppBrandPageContainer)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePlayer.5
 * JD-Core Version:    0.7.0.1
 */