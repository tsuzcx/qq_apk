package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/ClipModel;", "", "uuid", "", "type", "", "path", "timeData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;", "drawData", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "(Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;)V", "getDrawData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/DrawData;", "getPath", "()Ljava/lang/String;", "getTimeData", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TimeData;", "getType", "()I", "getUuid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "toVariableClipModel", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/VariableClipModel;", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ClipModel
{
  @NotNull
  private final String a;
  private final int b;
  @NotNull
  private final String c;
  @NotNull
  private final TimeData d;
  @NotNull
  private final DrawData e;
  
  public ClipModel(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull TimeData paramTimeData, @NotNull DrawData paramDrawData)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramTimeData;
    this.e = paramDrawData;
  }
  
  @NotNull
  public final VariableClipModel a()
  {
    return new VariableClipModel(this.a, this.b, this.c, this.d, 0L, 0L, this.e);
  }
  
  @NotNull
  public final String b()
  {
    return this.a;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final TimeData d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof ClipModel))
      {
        paramObject = (ClipModel)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int n = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
    localObject = this.c;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.e;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return (((i * 31 + n) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClipModel(uuid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", path=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", timeData=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", drawData=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.ClipModel
 * JD-Core Version:    0.7.0.1
 */