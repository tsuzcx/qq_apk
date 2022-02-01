package com.tencent.mobileqq.utils;

import android.os.Handler;
import com.tencent.mobileqq.qwallet.hb.aio.specify.ISpecifyRedPacketAnimMsg.OnAnimEndListener;

class AIOAnimationControlManager$13
  implements ISpecifyRedPacketAnimMsg.OnAnimEndListener
{
  AIOAnimationControlManager$13(AIOAnimationControlManager paramAIOAnimationControlManager, boolean paramBoolean) {}
  
  public void a()
  {
    if (this.b.j != null) {
      this.b.j.post(new AIOAnimationControlManager.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AIOAnimationControlManager.13
 * JD-Core Version:    0.7.0.1
 */