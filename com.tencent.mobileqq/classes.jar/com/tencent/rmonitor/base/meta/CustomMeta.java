package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/CustomMeta;", "", "firstCustomField", "", "secondCustomField", "(Ljava/lang/String;Ljava/lang/String;)V", "getFirstCustomField", "()Ljava/lang/String;", "getSecondCustomField", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class CustomMeta
{
  @NotNull
  private final String firstCustomField;
  @NotNull
  private final String secondCustomField;
  
  public CustomMeta(@NotNull String paramString1, @NotNull String paramString2)
  {
    this.firstCustomField = paramString1;
    this.secondCustomField = paramString2;
  }
  
  @NotNull
  public final String getFirstCustomField()
  {
    return this.firstCustomField;
  }
  
  @NotNull
  public final String getSecondCustomField()
  {
    return this.secondCustomField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.CustomMeta
 * JD-Core Version:    0.7.0.1
 */