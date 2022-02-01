package com.tencent.qapmsdk.common.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Ljava/io/File;", "invoke"}, k=3, mv={1, 1, 15})
final class FileUtil$Companion$zipFiles$allFiles$3
  extends Lambda
  implements Function1<File, String>
{
  public static final 3 INSTANCE = new 3();
  
  FileUtil$Companion$zipFiles$allFiles$3()
  {
    super(1);
  }
  
  public final String invoke(File paramFile)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "it");
    return paramFile.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.Companion.zipFiles.allFiles.3
 * JD-Core Version:    0.7.0.1
 */