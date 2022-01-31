package com.tencent.mobileqq.mini.appbrand;

import bcqf;

class BaseAppBrandRuntime$1
  implements Runnable
{
  BaseAppBrandRuntime$1(BaseAppBrandRuntime paramBaseAppBrandRuntime) {}
  
  public void run()
  {
    if (this.this$0.activity != null)
    {
      BaseAppBrandRuntime.access$002(this.this$0, new bcqf(this.this$0.activity));
      BaseAppBrandRuntime.access$000(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.1
 * JD-Core Version:    0.7.0.1
 */