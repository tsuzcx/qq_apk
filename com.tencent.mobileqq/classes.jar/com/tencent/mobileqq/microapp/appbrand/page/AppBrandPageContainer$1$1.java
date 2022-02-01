package com.tencent.mobileqq.microapp.appbrand.page;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class AppBrandPageContainer$1$1
  implements Runnable
{
  AppBrandPageContainer$1$1(AppBrandPageContainer.1 param1, int paramInt) {}
  
  public void run()
  {
    if (this.val$resCode == 0)
    {
      AppBrandPageContainer localAppBrandPageContainer = (AppBrandPageContainer)this.this$1.val$pageWeakRef.get();
      if (localAppBrandPageContainer != null) {
        if ("navigateTo".equals(this.this$1.val$fromFunc)) {
          localAppBrandPageContainer.navigateTo(this.this$1.val$url);
        } else if ("redirectTo".equals(this.this$1.val$fromFunc)) {
          localAppBrandPageContainer.redirectTo(this.this$1.val$url);
        } else if ("appLaunch".equals(this.this$1.val$fromFunc)) {
          localAppBrandPageContainer.launch(this.this$1.val$url, "appLaunch");
        } else if ("reLaunch".equals(this.this$1.val$fromFunc)) {
          localAppBrandPageContainer.launch(this.this$1.val$url, "reLaunch");
        }
      }
    }
    else
    {
      QQToast.makeText(this.this$1.val$dialog.getContext(), "页面不存在，请稍后重试", 1).show();
    }
    this.this$1.val$dialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer.1.1
 * JD-Core Version:    0.7.0.1
 */