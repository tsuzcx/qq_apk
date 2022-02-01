package com.tencent.mobileqq.wink.editor.filter;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/filter/EffectType;", "", "(Ljava/lang/String;I)V", "AI", "CLIENT", "NETWORK", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum EffectType
{
  static
  {
    EffectType localEffectType1 = new EffectType("AI", 0);
    AI = localEffectType1;
    EffectType localEffectType2 = new EffectType("CLIENT", 1);
    CLIENT = localEffectType2;
    EffectType localEffectType3 = new EffectType("NETWORK", 2);
    NETWORK = localEffectType3;
    $VALUES = new EffectType[] { localEffectType1, localEffectType2, localEffectType3 };
  }
  
  private EffectType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.filter.EffectType
 * JD-Core Version:    0.7.0.1
 */