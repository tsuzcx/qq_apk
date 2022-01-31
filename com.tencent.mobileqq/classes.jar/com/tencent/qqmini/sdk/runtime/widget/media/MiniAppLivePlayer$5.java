package com.tencent.qqmini.sdk.runtime.widget.media;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import bgls;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppLivePlayer$5
  implements Runnable
{
  MiniAppLivePlayer$5(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
  public void run()
  {
    if (this.this$0.g) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while (this.this$0.jdField_a_of_type_JavaLangRefWeakReference == null);
      localActivity = (Activity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localActivity == null) || (MiniAppLivePlayer.a(this.this$0) == null) || (!(this.this$0.getParent() instanceof CoverLiveView)) || (!this.this$0.jdField_a_of_type_Boolean));
    this.this$0.jdField_a_of_type_Boolean = false;
    MiniAppLivePlayer.a(this.this$0);
    Object localObject = this.this$0.jdField_a_of_type_Bgls.a();
    if (!(localObject instanceof AppBrandPageContainer))
    {
      QMLog.d("MiniAppLivePlayer", "Page is invalid");
      return;
    }
    localObject = ((AppBrandPageContainer)localObject).a();
    if (localObject != null)
    {
      if (((AppBrandPage)localObject).a() != null) {
        ((AppBrandPage)localObject).a().setVisibility(MiniAppLivePlayer.a(this.this$0));
      }
      if (((AppBrandPage)localObject).a() != null) {
        ((AppBrandPage)localObject).a().setVisibility(MiniAppLivePlayer.b(this.this$0));
      }
    }
    localActivity.getWindow().clearFlags(1024);
    localActivity.setRequestedOrientation(1);
    if (Build.VERSION.SDK_INT >= 16) {
      localActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        i = ((AppBrandPage)localObject).a().a();
        if (i != -1) {
          continue;
        }
        ImmersiveUtils.setStatusTextColor(false, localActivity.getWindow());
      }
      catch (Exception localException)
      {
        int i;
        QMLog.e("MiniAppLivePlayer", "smallScreen: ", localException);
        continue;
      }
      this.this$0.b = System.currentTimeMillis();
      this.this$0.g = true;
      MiniAppLivePlayer.a(this.this$0).postDelayed(new MiniAppLivePlayer.5.1(this), 200L);
      return;
      if (i == -16777216) {
        ImmersiveUtils.setStatusTextColor(true, localActivity.getWindow());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer.5
 * JD-Core Version:    0.7.0.1
 */