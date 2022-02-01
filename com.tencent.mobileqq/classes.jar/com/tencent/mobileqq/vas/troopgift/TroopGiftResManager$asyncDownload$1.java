package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TroopGiftResManager$asyncDownload$1
  implements Runnable
{
  TroopGiftResManager$asyncDownload$1(String[] paramArrayOfString, Context paramContext, Function1 paramFunction1) {}
  
  public final void run()
  {
    try
    {
      Object localObject1 = new ArrayList();
      Object localObject3 = this.a;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject3[i];
        TroopGiftResManager.a(TroopGiftResManager.a, this.b, str, (Function1)new TroopGiftResManager.asyncDownload.1..special..inlined.synchronized.lambda.1((ArrayList)localObject1, this));
        i += 1;
      }
      localObject3 = this.c;
      localObject1 = ((ArrayList)localObject1).toArray(new File[0]);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "files.toArray(emptyArray())");
      ((Function1)localObject3).invoke(localObject1);
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftResManager.asyncDownload.1
 * JD-Core Version:    0.7.0.1
 */