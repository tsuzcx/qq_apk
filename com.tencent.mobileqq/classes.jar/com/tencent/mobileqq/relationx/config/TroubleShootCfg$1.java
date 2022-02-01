package com.tencent.mobileqq.relationx.config;

import com.tencent.mobileqq.dpc.DPCObserver;

class TroubleShootCfg$1
  implements DPCObserver
{
  TroubleShootCfg$1(TroubleShootCfg paramTroubleShootCfg) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.config.TroubleShootCfg.1
 * JD-Core Version:    0.7.0.1
 */