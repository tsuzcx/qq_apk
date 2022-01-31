package com.tencent.mobileqq.mini.appbrand.ui;

import ajya;
import amtb;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;

class CapsuleButton$6$1
  implements Runnable
{
  CapsuleButton$6$1(CapsuleButton.6 param6) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null) {
      this.this$1.val$miniAppInfo.topType = 0;
    }
    if (amtb.g())
    {
      bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131701351) + amtb.c() + ajya.a(2131701350), 0).a();
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.6.1
 * JD-Core Version:    0.7.0.1
 */