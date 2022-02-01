package com.tencent.tavcut.utils;

import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/tavcut/utils/ZipIO;", "invoke"}, k=3, mv={1, 1, 16})
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
    Intrinsics.checkParameterIsNotNull(paramZipIO, "it");
    return paramZipIO.a().isDirectory() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.FileExtKt.unzip.1.3
 * JD-Core Version:    0.7.0.1
 */