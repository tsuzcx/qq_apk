package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/CloseableLeakMeta;", "Lcom/tencent/rmonitor/base/meta/MonitorMeta;", "stack", "", "(Ljava/lang/String;)V", "getStack", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class CloseableLeakMeta
  extends MonitorMeta
{
  @NotNull
  private final String stack;
  
  public CloseableLeakMeta(@NotNull String paramString)
  {
    this.stack = paramString;
  }
  
  @NotNull
  public final String component1()
  {
    return this.stack;
  }
  
  @NotNull
  public final CloseableLeakMeta copy(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "stack");
    return new CloseableLeakMeta(paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CloseableLeakMeta))
      {
        paramObject = (CloseableLeakMeta)paramObject;
        if (Intrinsics.areEqual(this.stack, paramObject.stack)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getStack()
  {
    return this.stack;
  }
  
  public int hashCode()
  {
    String str = this.stack;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloseableLeakMeta(stack=");
    localStringBuilder.append(this.stack);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.CloseableLeakMeta
 * JD-Core Version:    0.7.0.1
 */