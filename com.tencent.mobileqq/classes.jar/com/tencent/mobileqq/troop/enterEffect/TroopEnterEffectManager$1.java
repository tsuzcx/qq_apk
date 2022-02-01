package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import bftr;
import bfui;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopEnterEffectManager$1
  implements Runnable
{
  public TroopEnterEffectManager$1(bfui parambfui, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bftr = this.this$0.a();
    if (this.this$0.jdField_a_of_type_Bftr.a.get()) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopEnterEffectManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.1
 * JD-Core Version:    0.7.0.1
 */