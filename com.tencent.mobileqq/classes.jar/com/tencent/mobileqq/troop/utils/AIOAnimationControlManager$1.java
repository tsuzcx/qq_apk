package com.tencent.mobileqq.troop.utils;

import bagr;
import com.tencent.qphone.base.util.QLog;

public class AIOAnimationControlManager$1
  implements Runnable
{
  public AIOAnimationControlManager$1(bagr parambagr) {}
  
  public void run()
  {
    bagr.a(this.this$0);
    try
    {
      this.this$0.a();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AIOAnimationControlManager", 1, "checkPicEffectPackageIdState failed!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.1
 * JD-Core Version:    0.7.0.1
 */