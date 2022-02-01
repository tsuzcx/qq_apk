package com.tencent.mobileqq.troop.entereffect.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig;
import java.util.concurrent.atomic.AtomicBoolean;

class TroopEnterEffectServiceImpl$1
  implements Runnable
{
  TroopEnterEffectServiceImpl$1(TroopEnterEffectServiceImpl paramTroopEnterEffectServiceImpl, String paramString) {}
  
  public void run()
  {
    TroopEnterEffectServiceImpl localTroopEnterEffectServiceImpl = this.this$0;
    localTroopEnterEffectServiceImpl.mEffectConfig = localTroopEnterEffectServiceImpl.getTroopEnterEffectConfig();
    if (this.this$0.mEffectConfig.a.get()) {
      this.this$0.mHandler.post(new TroopEnterEffectServiceImpl.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.api.impl.TroopEnterEffectServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */