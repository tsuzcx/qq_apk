package com.tencent.timi.game.utils;

import android.app.Activity;

class SoundPoolUtils$2$1
  implements Runnable
{
  SoundPoolUtils$2$1(SoundPoolUtils.2 param2) {}
  
  public void run()
  {
    if (((this.this$0.b instanceof Activity)) && (((Activity)this.this$0.b).isFinishing())) {
      return;
    }
    SoundPoolUtils.b(false);
    SoundPoolUtils.a(this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils.2.1
 * JD-Core Version:    0.7.0.1
 */