package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.cache.MiniCacheFreeManager;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;

class CapsuleButton$5
  implements CapsuleButton.onActivityFinishListener
{
  CapsuleButton$5(CapsuleButton paramCapsuleButton, MiniAppConfig paramMiniAppConfig) {}
  
  public void onActivityFinish()
  {
    MiniCacheFreeManager.freeCache(MainPageFragment.getUin(), CapsuleButton.access$700(this.this$0), true, new CapsuleButton.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton.5
 * JD-Core Version:    0.7.0.1
 */