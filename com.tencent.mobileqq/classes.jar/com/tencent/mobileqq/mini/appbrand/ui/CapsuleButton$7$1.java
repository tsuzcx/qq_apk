package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.widget.QQToast;

class CapsuleButton$7$1
  implements Runnable
{
  CapsuleButton$7$1(CapsuleButton.7 param7) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo.topType == 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131718236, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2131718237, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.7.1
 * JD-Core Version:    0.7.0.1
 */