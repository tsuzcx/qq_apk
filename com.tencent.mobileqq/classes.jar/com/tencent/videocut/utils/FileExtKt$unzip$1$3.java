package com.tencent.videocut.utils;

import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/videocut/utils/ZipIO;", "invoke"}, k=3, mv={1, 4, 2})
final class FileExtKt$unzip$1$3
  extends Lambda
  implements Function1<ZipIO, Boolean>
{
  public static final 3 INSTANCE = new 3();
  
  FileExtKt$unzip$1$3()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull ZipIO paramZipIO)
  {
    Intrinsics.checkNotNullParameter(paramZipIO, "it");
    return paramZipIO.a().isDirectory() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.FileExtKt.unzip.1.3
 * JD-Core Version:    0.7.0.1
 */