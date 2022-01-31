package com.tencent.mobileqq.microapp.appbrand.page;

import bety;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$1$1
  implements Runnable
{
  AppBrandPageContainer$1$1(AppBrandPageContainer.1 param1, int paramInt) {}
  
  public void run()
  {
    AppBrandPageContainer localAppBrandPageContainer;
    if (this.val$resCode == 0)
    {
      localAppBrandPageContainer = (AppBrandPageContainer)this.this$1.val$pageWeakRef.get();
      if (localAppBrandPageContainer != null)
      {
        if (!"navigateTo".equals(this.this$1.val$fromFunc)) {
          break label62;
        }
        localAppBrandPageContainer.navigateTo(this.this$1.val$url);
      }
    }
    for (;;)
    {
      this.this$1.val$dialog.dismiss();
      return;
      label62:
      if ("redirectTo".equals(this.this$1.val$fromFunc))
      {
        localAppBrandPageContainer.redirectTo(this.this$1.val$url);
      }
      else if ("appLaunch".equals(this.this$1.val$fromFunc))
      {
        localAppBrandPageContainer.launch(this.this$1.val$url, "appLaunch");
      }
      else if ("reLaunch".equals(this.this$1.val$fromFunc))
      {
        localAppBrandPageContainer.launch(this.this$1.val$url, "reLaunch");
        continue;
        QQToast.a(this.this$1.val$dialog.getContext(), "页面不存在，请稍后重试", 1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */