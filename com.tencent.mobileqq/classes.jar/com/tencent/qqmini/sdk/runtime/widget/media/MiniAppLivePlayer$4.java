package com.tencent.qqmini.sdk.runtime.widget.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import bghl;
import com.tencent.qqmini.sdk.core.widget.NavigationBar;
import com.tencent.qqmini.sdk.core.widget.TabBar;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPage;
import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;

class MiniAppLivePlayer$4
  implements Runnable
{
  MiniAppLivePlayer$4(MiniAppLivePlayer paramMiniAppLivePlayer) {}
  
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
    } while ((localActivity == null) || (!(this.this$0.getParent() instanceof CoverLiveView)));
    this.this$0.jdField_a_of_type_Boolean = true;
    Object localObject = this.this$0.jdField_a_of_type_Bghl.a();
    if (!(localObject instanceof AppBrandPageContainer))
    {
      QMLog.d("MiniAppLivePlayer", "Page is invalid");
      return;
    }
    localObject = ((AppBrandPageContainer)localObject).a();
    if (localObject != null)
    {
      MiniAppLivePlayer.a(this.this$0, ((AppBrandPage)localObject).a().getVisibility());
      ((AppBrandPage)localObject).a().setVisibility(8);
      MiniAppLivePlayer.b(this.this$0, ((AppBrandPage)localObject).a().getVisibility());
      ((AppBrandPage)localObject).a().setVisibility(8);
    }
    MiniAppLivePlayer.a(this.this$0, ((CoverLiveView)this.this$0.getParent()).getLayoutParams());
    if (this.this$0.getParent().getParent() != null)
    {
      MiniAppLivePlayer.c(this.this$0, ((ViewGroup)this.this$0.getParent().getParent()).getScrollY());
      ((ViewGroup)this.this$0.getParent().getParent()).scrollTo(0, 0);
    }
    if (localObject == null)
    {
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.getRealHeight(this.this$0.getContext()), ImmersiveUtils.getScreenWidth());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      ((CoverLiveView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
      localActivity.getWindow().getDecorView().setSystemUiVisibility(2);
      if ((this.this$0.b != -90) && (this.this$0.b != 270)) {
        break label383;
      }
      localActivity.setRequestedOrientation(8);
    }
    for (;;)
    {
      MiniAppLivePlayer.a(this.this$0, localActivity);
      MiniAppLivePlayer.a(this.this$0);
      return;
      localObject = new FrameLayout.LayoutParams(DisplayUtil.getRealHeight(this.this$0.getContext()), ImmersiveUtils.getScreenWidth());
      ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      ((CoverLiveView)this.this$0.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      label383:
      if (this.this$0.b == 0) {
        localActivity.setRequestedOrientation(1);
      } else if ((this.this$0.b == 180) || (this.this$0.b == -180)) {
        localActivity.setRequestedOrientation(9);
      } else {
        localActivity.setRequestedOrientation(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer.4
 * JD-Core Version:    0.7.0.1
 */