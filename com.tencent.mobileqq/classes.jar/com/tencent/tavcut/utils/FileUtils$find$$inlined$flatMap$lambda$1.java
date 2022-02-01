package com.tencent.tavcut.utils;

import java.io.File;
import java.io.FilenameFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept", "com/tencent/tavcut/utils/FileUtils$find$1$1"}, k=3, mv={1, 1, 16})
final class FileUtils$find$$inlined$flatMap$lambda$1
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    return Intrinsics.areEqual(paramString, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.FileUtils.find..inlined.flatMap.lambda.1
 * JD-Core Version:    0.7.0.1
 */