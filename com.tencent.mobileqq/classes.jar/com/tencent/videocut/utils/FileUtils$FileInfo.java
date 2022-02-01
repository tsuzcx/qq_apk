package com.tencent.videocut.utils;

import .r8.java8methods.utility.Long.hashCode.IJ;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/FileUtils$FileInfo;", "", "filePath", "", "offset", "", "(Ljava/lang/String;J)V", "getFilePath", "()Ljava/lang/String;", "getOffset", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class FileUtils$FileInfo
{
  @NotNull
  private final String a;
  private final long b;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FileInfo))
      {
        paramObject = (FileInfo)paramObject;
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
    return i * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileInfo(filePath=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.FileUtils.FileInfo
 * JD-Core Version:    0.7.0.1
 */