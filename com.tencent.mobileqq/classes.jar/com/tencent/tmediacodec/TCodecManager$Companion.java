package com.tencent.tmediacodec;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/TCodecManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/tmediacodec/TCodecManager;", "getInstance", "()Lcom/tencent/tmediacodec/TCodecManager;", "instance$delegate", "Lkotlin/Lazy;", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class TCodecManager$Companion
{
  @NotNull
  public final TCodecManager getInstance()
  {
    Lazy localLazy = TCodecManager.access$getInstance$cp();
    Object localObject = TCodecManager.Companion;
    localObject = $$delegatedProperties[0];
    return (TCodecManager)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.TCodecManager.Companion
 * JD-Core Version:    0.7.0.1
 */