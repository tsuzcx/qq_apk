package com.tencent.mobileqq.mini.appbrand.ui;

import ajyc;
import amtc;
import bcpw;
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
    if (amtc.g())
    {
      bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131701340) + amtc.c() + ajyc.a(2131701339), 0).a();
      return;
    }
    bcpw.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.6.1
 * JD-Core Version:    0.7.0.1
 */