package com.tencent.mobileqq.troop.enterEffect;

import android.os.Handler;
import bbpq;
import bbqh;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopEnterEffectManager$1
  implements Runnable
{
  public TroopEnterEffectManager$1(bbqh parambbqh, String paramString) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bbpq = this.this$0.a();
    if (this.this$0.jdField_a_of_type_Bbpq.a.get()) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new TroopEnterEffectManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager.1
 * JD-Core Version:    0.7.0.1
 */