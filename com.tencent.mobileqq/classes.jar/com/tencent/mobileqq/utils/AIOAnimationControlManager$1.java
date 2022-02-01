package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;

class AIOAnimationControlManager$1
  implements Runnable
{
  AIOAnimationControlManager$1(AIOAnimationControlManager paramAIOAnimationControlManager) {}
  
  public void run()
  {
    AIOAnimationControlManager.a(this.this$0);
    try
    {
      this.this$0.c();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AIOAnimationControlManager", 1, "checkPicEffectPackageIdState failed!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.1
 * JD-Core Version:    0.7.0.1
 */