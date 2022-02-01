package com.tencent.videocut.utils;

import java.io.File;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/videocut/utils/ZipIO;", "it", "Ljava/util/zip/ZipEntry;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/videocut/utils/FileExtKt$unzip$1$1"}, k=3, mv={1, 4, 2})
final class FileExtKt$unzip$$inlined$use$lambda$1
  extends Lambda
  implements Function1<ZipEntry, ZipIO>
{
  FileExtKt$unzip$$inlined$use$lambda$1(File paramFile)
  {
    super(1);
  }
  
  @NotNull
  public final ZipIO invoke(ZipEntry paramZipEntry)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.$rootFolder$inlined.getAbsolutePath());
    localStringBuilder.append(File.separator);
    Intrinsics.checkNotNullExpressionValue(paramZipEntry, "it");
    localStringBuilder.append(paramZipEntry.getName());
    return new ZipIO(paramZipEntry, new File(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.FileExtKt.unzip..inlined.use.lambda.1
 * JD-Core Version:    0.7.0.1
 */