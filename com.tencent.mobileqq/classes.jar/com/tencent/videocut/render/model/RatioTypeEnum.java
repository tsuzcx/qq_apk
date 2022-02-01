package com.tencent.videocut.render.model;

import com.tencent.videocut.model.RatioType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/model/RatioTypeEnum;", "", "type", "Lcom/tencent/videocut/model/RatioType;", "ratioValue", "", "(Ljava/lang/String;ILcom/tencent/videocut/model/RatioType;F)V", "getRatioValue", "()F", "getType", "()Lcom/tencent/videocut/model/RatioType;", "ORIGINAL", "R16_9", "R9_16", "R1_1", "R3_4", "R4_3", "R1_2", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum RatioTypeEnum
{
  public static final RatioTypeEnum.Companion Companion = new RatioTypeEnum.Companion(null);
  private final float ratioValue;
  @NotNull
  private final RatioType type;
  
  static
  {
    RatioTypeEnum localRatioTypeEnum1 = new RatioTypeEnum("ORIGINAL", 0, RatioType.ORIGINAL, 0.0F);
    ORIGINAL = localRatioTypeEnum1;
    RatioTypeEnum localRatioTypeEnum2 = new RatioTypeEnum("R16_9", 1, RatioType.R16_9, 1.777778F);
    R16_9 = localRatioTypeEnum2;
    RatioTypeEnum localRatioTypeEnum3 = new RatioTypeEnum("R9_16", 2, RatioType.R9_16, 0.5625F);
    R9_16 = localRatioTypeEnum3;
    RatioTypeEnum localRatioTypeEnum4 = new RatioTypeEnum("R1_1", 3, RatioType.R1_1, 1.0F);
    R1_1 = localRatioTypeEnum4;
    RatioTypeEnum localRatioTypeEnum5 = new RatioTypeEnum("R3_4", 4, RatioType.R3_4, 0.75F);
    R3_4 = localRatioTypeEnum5;
    RatioTypeEnum localRatioTypeEnum6 = new RatioTypeEnum("R4_3", 5, RatioType.R4_3, 1.333333F);
    R4_3 = localRatioTypeEnum6;
    RatioTypeEnum localRatioTypeEnum7 = new RatioTypeEnum("R1_2", 6, RatioType.R1_2, 0.5F);
    R1_2 = localRatioTypeEnum7;
    $VALUES = new RatioTypeEnum[] { localRatioTypeEnum1, localRatioTypeEnum2, localRatioTypeEnum3, localRatioTypeEnum4, localRatioTypeEnum5, localRatioTypeEnum6, localRatioTypeEnum7 };
  }
  
  private RatioTypeEnum(RatioType paramRatioType, float paramFloat)
  {
    this.type = paramRatioType;
    this.ratioValue = paramFloat;
  }
  
  public final float getRatioValue()
  {
    return this.ratioValue;
  }
  
  @NotNull
  public final RatioType getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.model.RatioTypeEnum
 * JD-Core Version:    0.7.0.1
 */