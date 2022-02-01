package com.tencent.videocut.utils.lyric;

import .r8.java8methods.utility.Long.hashCode.IJ;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/lyric/Sentence;", "", "mText", "", "mStartTime", "", "mDuration", "mCharacters", "Ljava/util/ArrayList;", "Lcom/tencent/videocut/utils/lyric/LyricCharacter;", "(Ljava/lang/String;JJLjava/util/ArrayList;)V", "getMCharacters", "()Ljava/util/ArrayList;", "setMCharacters", "(Ljava/util/ArrayList;)V", "getMDuration", "()J", "setMDuration", "(J)V", "getMStartTime", "setMStartTime", "getMText", "()Ljava/lang/String;", "setMText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class Sentence
{
  @Nullable
  private String a;
  private long b;
  private long c;
  @Nullable
  private ArrayList<LyricCharacter> d;
  
  public Sentence()
  {
    this(null, 0L, 0L, null, 15, null);
  }
  
  public Sentence(@Nullable String paramString, long paramLong1, long paramLong2, @Nullable ArrayList<LyricCharacter> paramArrayList)
  {
    this.a = paramString;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramArrayList;
  }
  
  public final long a()
  {
    return this.b;
  }
  
  @Nullable
  public final String b()
  {
    return this.a;
  }
  
  public final long c()
  {
    return this.b;
  }
  
  public final long d()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Sentence))
      {
        paramObject = (Sentence)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    int k = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
    int m = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.c);
    localObject = this.d;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((i * 31 + k) * 31 + m) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sentence(mText=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mStartTime=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mDuration=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mCharacters=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.lyric.Sentence
 * JD-Core Version:    0.7.0.1
 */