package com.tencent.qapmsdk.base.breadcrumbreflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/breadcrumbreflect/AthenaInfo;", "", "label", "", "intValue", "", "longValue", "", "stringValue", "(Ljava/lang/String;IJLjava/lang/String;)V", "getIntValue", "()I", "setIntValue", "(I)V", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getLongValue", "()J", "setLongValue", "(J)V", "getStringValue", "setStringValue", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AthenaInfo
{
  private int intValue;
  @NotNull
  private String label;
  private long longValue;
  @NotNull
  private String stringValue;
  
  public AthenaInfo()
  {
    this(null, 0, 0L, null, 15, null);
  }
  
  public AthenaInfo(@NotNull String paramString1, int paramInt, long paramLong, @NotNull String paramString2)
  {
    this.label = paramString1;
    this.intValue = paramInt;
    this.longValue = paramLong;
    this.stringValue = paramString2;
  }
  
  public final int getIntValue()
  {
    return this.intValue;
  }
  
  @NotNull
  public final String getLabel()
  {
    return this.label;
  }
  
  public final long getLongValue()
  {
    return this.longValue;
  }
  
  @NotNull
  public final String getStringValue()
  {
    return this.stringValue;
  }
  
  public final void setIntValue(int paramInt)
  {
    this.intValue = paramInt;
  }
  
  public final void setLabel(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.label = paramString;
  }
  
  public final void setLongValue(long paramLong)
  {
    this.longValue = paramLong;
  }
  
  public final void setStringValue(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.stringValue = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.breadcrumbreflect.AthenaInfo
 * JD-Core Version:    0.7.0.1
 */