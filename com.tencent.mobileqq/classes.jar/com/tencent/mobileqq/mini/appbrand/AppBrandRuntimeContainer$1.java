package com.tencent.mobileqq.mini.appbrand;

import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.appbrand.ui.DebugLayout;

class AppBrandRuntimeContainer$1
  implements Runnable
{
  AppBrandRuntimeContainer$1(AppBrandRuntimeContainer paramAppBrandRuntimeContainer) {}
  
  public void run()
  {
    AppBrandRuntimeContainer.access$002(this.this$0, new DebugLayout(BaseApplicationImpl.getContext()));
    AppBrandRuntimeContainer.access$000(this.this$0).setBackgroundColor(-822083584);
    AppBrandRuntimeContainer.access$102(this.this$0, new TextView(BaseApplicationImpl.getContext()));
    AppBrandRuntimeContainer.access$100(this.this$0).setTextColor(-1);
    AppBrandRuntimeContainer.access$100(this.this$0).setTextSize(30.0F);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    AppBrandRuntimeContainer.access$000(this.this$0).addView(AppBrandRuntimeContainer.access$100(this.this$0), localLayoutParams);
    AppBrandRuntimeContainer.access$000(this.this$0).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer.1
 * JD-Core Version:    0.7.0.1
 */