package com.tencent.mobileqq.mini.appbrand.ui;

import anzj;
import arfd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class CapsuleButton$6$1
  implements Runnable
{
  CapsuleButton$6$1(CapsuleButton.6 param6) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo != null) {
      this.this$1.val$miniAppInfo.topType = 0;
    }
    if (arfd.c())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131700263) + arfd.a() + anzj.a(2131700262), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), "最多仅支持置顶10个小程序", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.6.1
 * JD-Core Version:    0.7.0.1
 */