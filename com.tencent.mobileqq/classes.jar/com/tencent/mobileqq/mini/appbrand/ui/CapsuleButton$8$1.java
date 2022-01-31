package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.widget.QQToast;

class CapsuleButton$8$1
  implements Runnable
{
  CapsuleButton$8$1(CapsuleButton.8 param8) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo.topType == 1)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2131719918, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2131719919, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.8.1
 * JD-Core Version:    0.7.0.1
 */