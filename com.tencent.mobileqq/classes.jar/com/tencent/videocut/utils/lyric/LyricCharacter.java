package com.tencent.videocut.utils.lyric;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/lyric/LyricCharacter;", "", "mStartTime", "", "mDuration", "mStart", "", "mEnd", "(JJII)V", "getMDuration", "()J", "getMEnd", "()I", "getMStart", "getMStartTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class LyricCharacter
{
  private final long a;
  private final long b;
  private final int c;
  private final int d;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LyricCharacter))
      {
        paramObject = (LyricCharacter)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d)) {}
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
    return ((.r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.a) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b)) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.c)) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.d);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LyricCharacter(mStartTime=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mDuration=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mStart=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mEnd=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.lyric.LyricCharacter
 * JD-Core Version:    0.7.0.1
 */