package com.tencent.tkd.topicsdk.common;

import java.io.File;
import java.io.FileFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/common/DeviceUtil$CPU_FILTER$1", "Ljava/io/FileFilter;", "accept", "", "pathname", "Ljava/io/File;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DeviceUtil$CPU_FILTER$1
  implements FileFilter
{
  public boolean accept(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "pathname");
    paramFile = paramFile.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    int i;
    int j;
    if (StringsKt.startsWith$default(paramFile, "cpu", false, 2, null))
    {
      i = 3;
      j = paramFile.length();
    }
    while (i < j)
    {
      if (!Character.isDigit(paramFile.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.DeviceUtil.CPU_FILTER.1
 * JD-Core Version:    0.7.0.1
 */