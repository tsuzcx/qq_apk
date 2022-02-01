package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/StressState;", "", "(Ljava/lang/String;I)V", "Stretched", "Shrink", "kandian-api_release"}, k=1, mv={1, 1, 16})
public enum StressState
{
  static
  {
    StressState localStressState1 = new StressState("Stretched", 0);
    Stretched = localStressState1;
    StressState localStressState2 = new StressState("Shrink", 1);
    Shrink = localStressState2;
    $VALUES = new StressState[] { localStressState1, localStressState2 };
  }
  
  private StressState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.StressState
 * JD-Core Version:    0.7.0.1
 */