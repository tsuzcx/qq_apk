package com.tencent.mobileqq.triton.internal.render.monitor;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ScreenShootMonitor$createScreenShot$1
  implements Runnable
{
  ScreenShootMonitor$createScreenShot$1(ScreenShootMonitor paramScreenShootMonitor, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public final void run()
  {
    int i = this.$w;
    int k = this.$h;
    Object localObject = new int[i * k];
    i = 0;
    while (i < k)
    {
      int m = this.$w;
      int n = this.$h;
      int j = 0;
      while (j < m)
      {
        int i1 = this.$bitmapBuffer[(i * m + j)];
        localObject[((n - i - 1) * m + j)] = (i1 & 0xFF00FF00 | i1 << 16 & 0xFF0000 | i1 >> 16 & 0xFF);
        j += 1;
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap((int[])localObject, this.$w, this.$h, Bitmap.Config.ARGB_8888);
    ScreenShootMonitor localScreenShootMonitor = this.this$0;
    Result.Companion localCompanion = Result.Companion;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "bitmap");
    ScreenShootMonitor.access$onGetScreenShot(localScreenShootMonitor, Result.constructor-impl(localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.render.monitor.ScreenShootMonitor.createScreenShot.1
 * JD-Core Version:    0.7.0.1
 */