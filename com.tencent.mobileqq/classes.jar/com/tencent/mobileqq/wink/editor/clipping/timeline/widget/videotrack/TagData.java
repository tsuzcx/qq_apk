package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack;

import .r8.java8methods.utility.Integer.hashCode.II;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/TagData;", "", "text", "", "res", "", "(Ljava/lang/String;I)V", "getRes", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TagData
{
  @NotNull
  private final String a;
  private final int b;
  
  public TagData(@NotNull String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TagData))
      {
        paramObject = (TagData)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b)) {}
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
    String str = this.a;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TagData(text=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", res=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.TagData
 * JD-Core Version:    0.7.0.1
 */