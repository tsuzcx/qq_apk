package com.tencent.tavcut.rendermodel;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "", "voiceKind", "", "environment", "(Ljava/lang/String;III)V", "getEnvironment", "()I", "getVoiceKind", "NAUGHTY_KID", "STRONG_CURRENT", "HEAVY_MACHINE", "SLOWLY", "STUTTER", "ONLINE_CELEBRITY", "CAGED_ANIMAL", "FLU", "FOREIGNER", "HEAVY_METAL", "FAT_MAN", "LOLI", "UNCLE", "ETHEREAL", "FREAKY", "FUNNY", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum VoiceEnum
{
  private final int environment;
  private final int voiceKind;
  
  static
  {
    VoiceEnum localVoiceEnum1 = new VoiceEnum("NAUGHTY_KID", 0, 1, 1);
    NAUGHTY_KID = localVoiceEnum1;
    VoiceEnum localVoiceEnum2 = new VoiceEnum("STRONG_CURRENT", 1, 10, 4);
    STRONG_CURRENT = localVoiceEnum2;
    VoiceEnum localVoiceEnum3 = new VoiceEnum("HEAVY_MACHINE", 2, 10, 20);
    HEAVY_MACHINE = localVoiceEnum3;
    VoiceEnum localVoiceEnum4 = new VoiceEnum("SLOWLY", 3, 11, -1);
    SLOWLY = localVoiceEnum4;
    VoiceEnum localVoiceEnum5 = new VoiceEnum("STUTTER", 4, 12, -1);
    STUTTER = localVoiceEnum5;
    VoiceEnum localVoiceEnum6 = new VoiceEnum("ONLINE_CELEBRITY", 5, 9, 51);
    ONLINE_CELEBRITY = localVoiceEnum6;
    VoiceEnum localVoiceEnum7 = new VoiceEnum("CAGED_ANIMAL", 6, 13, 1);
    CAGED_ANIMAL = localVoiceEnum7;
    VoiceEnum localVoiceEnum8 = new VoiceEnum("FLU", 7, 536936433, 50);
    FLU = localVoiceEnum8;
    VoiceEnum localVoiceEnum9 = new VoiceEnum("FOREIGNER", 8, -1, 5);
    FOREIGNER = localVoiceEnum9;
    VoiceEnum localVoiceEnum10 = new VoiceEnum("HEAVY_METAL", 9, -1, 9);
    HEAVY_METAL = localVoiceEnum10;
    VoiceEnum localVoiceEnum11 = new VoiceEnum("FAT_MAN", 10, 13, -1);
    FAT_MAN = localVoiceEnum11;
    VoiceEnum localVoiceEnum12 = new VoiceEnum("LOLI", 11, 4, -1);
    LOLI = localVoiceEnum12;
    VoiceEnum localVoiceEnum13 = new VoiceEnum("UNCLE", 12, 5, -1);
    UNCLE = localVoiceEnum13;
    VoiceEnum localVoiceEnum14 = new VoiceEnum("ETHEREAL", 13, -1, 2);
    ETHEREAL = localVoiceEnum14;
    VoiceEnum localVoiceEnum15 = new VoiceEnum("FREAKY", 14, 8, 3);
    FREAKY = localVoiceEnum15;
    VoiceEnum localVoiceEnum16 = new VoiceEnum("FUNNY", 15, 7, -1);
    FUNNY = localVoiceEnum16;
    $VALUES = new VoiceEnum[] { localVoiceEnum1, localVoiceEnum2, localVoiceEnum3, localVoiceEnum4, localVoiceEnum5, localVoiceEnum6, localVoiceEnum7, localVoiceEnum8, localVoiceEnum9, localVoiceEnum10, localVoiceEnum11, localVoiceEnum12, localVoiceEnum13, localVoiceEnum14, localVoiceEnum15, localVoiceEnum16 };
  }
  
  private VoiceEnum(int paramInt1, int paramInt2)
  {
    this.voiceKind = paramInt1;
    this.environment = paramInt2;
  }
  
  public final int getEnvironment()
  {
    return this.environment;
  }
  
  public final int getVoiceKind()
  {
    return this.voiceKind;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.VoiceEnum
 * JD-Core Version:    0.7.0.1
 */