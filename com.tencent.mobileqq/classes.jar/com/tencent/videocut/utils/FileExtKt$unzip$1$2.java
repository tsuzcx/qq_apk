package com.tencent.videocut.utils;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/videocut/utils/ZipIO;", "it", "invoke"}, k=3, mv={1, 4, 2})
final class FileExtKt$unzip$1$2
  extends Lambda
  implements Function1<ZipIO, ZipIO>
{
  public static final 2 INSTANCE = new 2();
  
  FileExtKt$unzip$1$2()
  {
    super(1);
  }
  
  @NotNull
  public final ZipIO invoke(@NotNull ZipIO paramZipIO)
  {
    Intrinsics.checkNotNullParameter(paramZipIO, "it");
    File localFile = paramZipIO.b().getParentFile();
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    return paramZipIO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.FileExtKt.unzip.1.2
 * JD-Core Version:    0.7.0.1
 */