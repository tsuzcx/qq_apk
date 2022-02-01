package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.mini.sdk.MiniAppController;

class CapsuleButton$5$1
  implements ThreadExcutor.IThreadListener
{
  CapsuleButton$5$1(CapsuleButton.5 param5) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    MiniAppController.startApp(null, this.this$1.val$miniAppConfig, null);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.5.1
 * JD-Core Version:    0.7.0.1
 */