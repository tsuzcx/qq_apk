package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import bedc;
import bedt;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopEnterEffectManager$1
  implements Runnable
{
  public TroopEnterEffectManager$1(bedt parambedt, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bedc = this.this$0.a();
    if (this.this$0.jdField_a_of_type_Bedc.a.get()) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopEnterEffectManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.1
 * JD-Core Version:    0.7.0.1
 */