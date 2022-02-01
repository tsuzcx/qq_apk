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

class EmbeddedVideoJsPlugin$3
  implements Action<Void>
{
  EmbeddedVideoJsPlugin$3(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin, WeakReference paramWeakReference) {}
  
  public Void perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (!(paramBaseRuntime instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    int i;
    do
    {
      do
      {
        return null;
        i = ((AppBrandPageContainer)paramBaseRuntime).getShowingPage().getNavBar().getStatusNavigationBarTextStyle();
        if (i != -1) {
          break;
        }
      } while (this.val$activityRef.get() == null);
      ImmersiveUtils.setStatusTextColor(false, ((Activity)this.val$activityRef.get()).getWindow());
      return null;
    } while ((i != -16777216) || (this.val$activityRef.get() == null));
    ImmersiveUtils.setStatusTextColor(true, ((Activity)this.val$activityRef.get()).getWindow());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */