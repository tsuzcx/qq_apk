package com.tencent.mobileqq.mini.appbrand.ui;

import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

class CapsuleButton$7$1
  implements Runnable
{
  CapsuleButton$7$1(CapsuleButton.7 param7) {}
  
  public void run()
  {
    if (this.this$1.val$miniAppInfo.topType == 1)
    {
      bcql.a(BaseApplicationImpl.getApplication(), 2131719418, 0).a();
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), 2131719419, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.7.1
 * JD-Core Version:    0.7.0.1
 */