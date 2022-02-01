package com.tencent.qapmsdk.common.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/io/File;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 15})
final class FileUtil$Companion$zipFiles$allFiles$2
  extends Lambda
  implements Function1<File, Boolean>
{
  public static final 2 INSTANCE = new 2();
  
  FileUtil$Companion$zipFiles$allFiles$2()
  {
    super(1);
  }
  
  public final boolean invoke(File paramFile)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "it");
    return paramFile.isFile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.Companion.zipFiles.allFiles.2
 * JD-Core Version:    0.7.0.1
 */