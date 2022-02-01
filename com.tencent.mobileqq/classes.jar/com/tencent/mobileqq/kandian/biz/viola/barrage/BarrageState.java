package com.tencent.mobileqq.kandian.biz.viola.barrage;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageState;", "", "(Ljava/lang/String;I)V", "IDLE", "PLAYING", "PAUSE", "STOPED", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public enum BarrageState
{
  static
  {
    BarrageState localBarrageState1 = new BarrageState("IDLE", 0);
    IDLE = localBarrageState1;
    BarrageState localBarrageState2 = new BarrageState("PLAYING", 1);
    PLAYING = localBarrageState2;
    BarrageState localBarrageState3 = new BarrageState("PAUSE", 2);
    PAUSE = localBarrageState3;
    BarrageState localBarrageState4 = new BarrageState("STOPED", 3);
    STOPED = localBarrageState4;
    $VALUES = new BarrageState[] { localBarrageState1, localBarrageState2, localBarrageState3, localBarrageState4 };
  }
  
  private BarrageState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageState
 * JD-Core Version:    0.7.0.1
 */