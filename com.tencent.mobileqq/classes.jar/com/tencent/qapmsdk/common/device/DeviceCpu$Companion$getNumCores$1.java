package com.tencent.qapmsdk.common.device;

import java.io.File;
import java.io.FilenameFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k=3, mv={1, 1, 15})
final class DeviceCpu$Companion$getNumCores$1
  implements FilenameFilter
{
  public static final 1 INSTANCE = new 1();
  
  public final boolean accept(File paramFile, String paramString)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramString, "name");
    paramFile = (CharSequence)paramString;
    return new Regex("cpu\\d+").matches(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceCpu.Companion.getNumCores.1
 * JD-Core Version:    0.7.0.1
 */