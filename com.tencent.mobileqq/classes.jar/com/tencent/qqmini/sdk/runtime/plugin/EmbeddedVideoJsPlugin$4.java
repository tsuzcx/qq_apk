package com.tencent.qqmini.sdk.runtime.plugin;

import android.app.Activity;
import bgls;
import bgmc;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;

class EmbeddedVideoJsPlugin$4
  implements bgmc<Void>
{
  EmbeddedVideoJsPlugin$4(EmbeddedVideoJsPlugin paramEmbeddedVideoJsPlugin, WeakReference paramWeakReference) {}
  
  public Void perform(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer)) {
      QMLog.d("Action", "Page is invalid");
    }
    int i;
    do
    {
      do
      {
        return null;
        i = ((AppBrandPageContainer)parambgls).a().a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.EmbeddedVideoJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */