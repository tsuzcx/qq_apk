package com.tencent.mobileqq.triton.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/model/Version;", "", "version", "", "timeStamp", "", "(Ljava/lang/String;J)V", "getTimeStamp", "()J", "getVersion", "()Ljava/lang/String;", "compareTo", "", "other", "compareVersion", "lhs", "rhs", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class Version
  implements Comparable<Version>
{
  private final long timeStamp;
  @NotNull
  private final String version;
  
  public Version(@NotNull String paramString, long paramLong)
  {
    this.version = paramString;
    this.timeStamp = paramLong;
  }
  
  private final int compareVersion(String paramString1, String paramString2)
  {
    paramString1 = StringsKt.split$default((CharSequence)paramString1, new char[] { '.' }, false, 0, 6, null);
    paramString2 = StringsKt.split$default((CharSequence)paramString2, new char[] { '.' }, false, 0, 6, null);
    Ref.IntRef localIntRef = new Ref.IntRef();
    int j = Math.min(paramString1.size(), paramString2.size());
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        localIntRef.element = (Integer.parseInt((String)paramString1.get(i)) - Integer.parseInt((String)paramString2.get(i)));
        if (localIntRef.element != 0)
        {
          i = localIntRef.element;
          return i;
        }
        i += 1;
      }
      catch (Exception paramString1) {}
    }
    return paramString1.size() - paramString2.size();
    return 0;
  }
  
  public int compareTo(@NotNull Version paramVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramVersion, "other");
    int i = compareVersion(this.version, paramVersion.version);
    if (i == 0) {
      return this.timeStamp < paramVersion.timeStamp;
    }
    return i;
  }
  
  @NotNull
  public final String component1()
  {
    return this.version;
  }
  
  public final long component2()
  {
    return this.timeStamp;
  }
  
  @NotNull
  public final Version copy(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "version");
    return new Version(paramString, paramLong);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Version))
      {
        paramObject = (Version)paramObject;
        if ((Intrinsics.areEqual(this.version, paramObject.version)) && (this.timeStamp == paramObject.timeStamp)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long getTimeStamp()
  {
    return this.timeStamp;
  }
  
  @NotNull
  public final String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    String str = this.version;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    long l = this.timeStamp;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Version(version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", timeStamp=");
    localStringBuilder.append(this.timeStamp);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.model.Version
 * JD-Core Version:    0.7.0.1
 */