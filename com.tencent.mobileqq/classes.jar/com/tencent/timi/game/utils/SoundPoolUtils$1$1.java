package com.tencent.timi.game.utils;

import android.app.Activity;

class SoundPoolUtils$1$1
  implements Runnable
{
  SoundPoolUtils$1$1(SoundPoolUtils.1 param1) {}
  
  public void run()
  {
    if (((this.this$0.a instanceof Activity)) && (((Activity)this.this$0.a).isFinishing())) {
      return;
    }
    SoundPoolUtils.a(false);
    SoundPoolUtils.a(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils.1.1
 * JD-Core Version:    0.7.0.1
 */