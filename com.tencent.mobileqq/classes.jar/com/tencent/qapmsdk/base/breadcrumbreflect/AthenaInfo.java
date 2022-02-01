package com.tencent.qapmsdk.base.breadcrumbreflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/breadcrumbreflect/AthenaInfo;", "", "label", "", "value", "", "(Ljava/lang/String;I)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getValue", "()I", "setValue", "(I)V", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaInfo
{
  @NotNull
  private String label;
  private int value;
  
  public AthenaInfo()
  {
    this(null, 0, 3, null);
  }
  
  public AthenaInfo(@NotNull String paramString, int paramInt)
  {
    this.label = paramString;
    this.value = paramInt;
  }
  
  @NotNull
  public final String getLabel()
  {
    return this.label;
  }
  
  public final int getValue()
  {
    return this.value;
  }
  
  public final void setLabel(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.label = paramString;
  }
  
  public final void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.breadcrumbreflect.AthenaInfo
 * JD-Core Version:    0.7.0.1
 */