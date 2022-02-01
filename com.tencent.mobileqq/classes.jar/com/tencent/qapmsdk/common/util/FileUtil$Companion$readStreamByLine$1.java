package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 15})
final class FileUtil$Companion$readStreamByLine$1
  extends Lambda
  implements Function1<String, Unit>
{
  FileUtil$Companion$readStreamByLine$1(IStreamListener paramIStreamListener)
  {
    super(1);
  }
  
  public final void invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    this.$listener.readLine(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.Companion.readStreamByLine.1
 * JD-Core Version:    0.7.0.1
 */