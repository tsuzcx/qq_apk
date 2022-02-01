package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import java.lang.ref.WeakReference;

class EmbeddedLivePusherJsPlugin$4
  implements Action<Void>
{
  EmbeddedLivePusherJsPlugin$4(EmbeddedLivePusherJsPlugin paramEmbeddedLivePusherJsPlugin, WeakReference paramWeakReference) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer))
    {
      QMLog.d("Action", "Page is invalid");
      return null;
    }
    int i = ((AppBrandPageContainer)paramBaseRuntime).getShowingPage().getNavBar().getStatusNavigationBarTextStyle();
    if (i == -1)
    {
      if (this.val$activityRef.get() != null)
      {
        ImmersiveUtils.setStatusTextColor(false, ((Activity)this.val$activityRef.get()).getWindow());
        return null;
      }
    }
    else if ((i == -16777216) && (this.val$activityRef.get() != null)) {
      ImmersiveUtils.setStatusTextColor(true, ((Activity)this.val$activityRef.get()).getWindow());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */