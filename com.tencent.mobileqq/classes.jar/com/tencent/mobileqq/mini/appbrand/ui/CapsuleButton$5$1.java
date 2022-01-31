package com.tencent.mobileqq.mini.appbrand.ui;

import ajjy;
import amda;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;

class CapsuleButton$5$1
  implements Runnable
{
  CapsuleButton$5$1(CapsuleButton.5 param5) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null) {
      this.this$1.val$miniAppInfo.topType = 0;
    }
    if (amda.g())
    {
      bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131635556) + amda.c() + ajjy.a(2131635555), 0).a();
      return;
    }
    bbmy.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.5.1
 * JD-Core Version:    0.7.0.1
 */