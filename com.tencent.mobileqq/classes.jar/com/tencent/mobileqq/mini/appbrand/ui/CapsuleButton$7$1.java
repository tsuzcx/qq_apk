package com.tencent.mobileqq.mini.appbrand.ui;

import alud;
import aoom;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class CapsuleButton$7$1
  implements Runnable
{
  CapsuleButton$7$1(CapsuleButton.7 param7) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null) {
      this.this$1.val$miniAppInfo.topType = 0;
    }
    if (aoom.g())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131701736) + aoom.c() + alud.a(2131701735), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.7.1
 * JD-Core Version:    0.7.0.1
 */