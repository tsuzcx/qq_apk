package com.tencent.xaction.drawable;

import android.os.Handler;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.impl.XAEngine;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PngsDecorDrawable$doFrameUpdate$1
  implements Runnable
{
  PngsDecorDrawable$doFrameUpdate$1(PngsDecorDrawable paramPngsDecorDrawable, PngsDrawable paramPngsDrawable) {}
  
  public final void run()
  {
    if (this.this$0.getBaseAnim().isFirst().get())
    {
      localObject = this.this$0.getDrawable();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.PngsDrawable");
      }
      ((PngsDrawable)localObject).a(0);
    }
    this.a.a();
    Object localObject = this.this$0.getEngine();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((XAEngine)localObject).getUiHandler();
    if (localObject != null) {
      ((Handler)localObject).post((Runnable)new PngsDecorDrawable.doFrameUpdate.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.drawable.PngsDecorDrawable.doFrameUpdate.1
 * JD-Core Version:    0.7.0.1
 */