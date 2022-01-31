package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;

class ProgressWebView$1$5
  implements MiniAppController.ActivityResultListener
{
  ProgressWebView$1$5(ProgressWebView.1 param1) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2019)
    {
      this.this$1.this$0.onActivityResult(paramInt1, paramInt2, paramIntent);
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.ProgressWebView.1.5
 * JD-Core Version:    0.7.0.1
 */