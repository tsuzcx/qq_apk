package com.tencent.mobileqq.mini.widget;

import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.DisplayUtil;

class MiniAppTextArea1$4
  implements Runnable
{
  MiniAppTextArea1$4(MiniAppTextArea1 paramMiniAppTextArea1) {}
  
  public void run()
  {
    int i;
    if ((this.this$0.isFocused()) && (MiniAppTextArea1.access$1400(this.this$0)) && (MiniAppTextArea1.access$600(this.this$0) != null))
    {
      if ((MiniAppTextArea1.access$600(this.this$0).appBrandRuntime == null) || (MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage() == null) || (MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().getNavBar() == null) || (MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().getNavBar().getNavbarStyle() == null)) {
        break label392;
      }
      if (MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().getNavBar().getNavbarStyle().equals("custom")) {
        i = 0;
      }
    }
    for (;;)
    {
      i = DisplayUtil.getRealHeight(this.this$0.getContext()) - (i + (this.this$0.getTop() - MiniAppTextArea1.access$600(this.this$0).getNativeScrollY()) + MiniAppTextArea1.access$1500(this.this$0));
      if ((MiniAppTextArea1.access$400(this.this$0) > i) && (MiniAppTextArea1.access$1600(this.this$0)) && (MiniAppTextArea1.access$1400(this.this$0)))
      {
        localObjectAnimator = ObjectAnimator.ofFloat(MiniAppTextArea1.access$600(this.this$0), "translationY", new float[] { MiniAppTextArea1.access$1700(this.this$0), -(MiniAppTextArea1.access$400(this.this$0) - i) });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        localObjectAnimator.start();
        MiniAppTextArea1.access$1702(this.this$0, -(MiniAppTextArea1.access$400(this.this$0) - i));
      }
      do
      {
        return;
        i = MiniAppTextArea1.access$600(this.this$0).appBrandRuntime.getCurPage().getNavBar().getHeight();
        break;
      } while ((MiniAppTextArea1.access$1400(this.this$0)) || (MiniAppTextArea1.access$600(this.this$0) == null));
      MiniAppTextArea1.access$1702(this.this$0, 0);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(MiniAppTextArea1.access$600(this.this$0), "translationY", new float[] { MiniAppTextArea1.access$600(this.this$0).getTranslationY(), 0.0F });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
      localObjectAnimator.start();
      return;
      label392:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniAppTextArea1.4
 * JD-Core Version:    0.7.0.1
 */