package com.tencent.mobileqq.wink.editor.music.vo;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/vo/MusicEntity;", "", "path", "", "start", "", "end", "(Ljava/lang/String;JJ)V", "getEnd", "()J", "getPath", "()Ljava/lang/String;", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicEntity
{
  @NotNull
  private final String a;
  private final long b;
  private final long c;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MusicEntity))
      {
        paramObject = (MusicEntity)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c)) {}
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
    return (i * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.c);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MusicEntity(path=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", start=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.vo.MusicEntity
 * JD-Core Version:    0.7.0.1
 */