package com.tencent.mobileqq.mini.appbrand;

import amtj;

class JsErrorGuard$6
  implements Runnable
{
  JsErrorGuard$6(JsErrorGuard paramJsErrorGuard, int paramInt) {}
  
  public void run()
  {
    if ((JsErrorGuard.access$1300(this.this$0) != null) && (JsErrorGuard.access$1300(this.this$0).isShowing())) {
      JsErrorGuard.access$1300(this.this$0).setTitle(amtj.a(2131705015) + this.val$progress + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.JsErrorGuard.6
 * JD-Core Version:    0.7.0.1
 */