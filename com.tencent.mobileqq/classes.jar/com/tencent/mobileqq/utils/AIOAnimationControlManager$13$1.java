package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;

class AIOAnimationControlManager$13$1
  implements Runnable
{
  AIOAnimationControlManager$13$1(AIOAnimationControlManager.13 param13) {}
  
  public void run()
  {
    try
    {
      if (this.a.b.f != null) {
        this.a.b.f.b();
      }
      label26:
      this.a.b.a = 1;
      this.a.b.a(this.a.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.13.1
 * JD-Core Version:    0.7.0.1
 */