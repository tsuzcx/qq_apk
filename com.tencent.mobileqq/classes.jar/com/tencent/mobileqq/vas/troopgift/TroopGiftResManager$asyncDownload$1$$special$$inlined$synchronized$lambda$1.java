package com.tencent.mobileqq.vas.troopgift;

import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/io/File;", "invoke", "com/tencent/mobileqq/vas/troopgift/TroopGiftResManager$asyncDownload$1$1$1$1", "com/tencent/mobileqq/vas/troopgift/TroopGiftResManager$asyncDownload$1$$special$$inlined$forEach$lambda$1"}, k=3, mv={1, 1, 16})
final class TroopGiftResManager$asyncDownload$1$$special$$inlined$synchronized$lambda$1
  extends Lambda
  implements Function1<File, Unit>
{
  TroopGiftResManager$asyncDownload$1$$special$$inlined$synchronized$lambda$1(ArrayList paramArrayList, TroopGiftResManager.asyncDownload.1 param1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "it");
    this.$files$inlined.add(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftResManager.asyncDownload.1..special..inlined.synchronized.lambda.1
 * JD-Core Version:    0.7.0.1
 */