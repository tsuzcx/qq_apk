package com.tencent.xaction.drawable.pngs;

import android.os.Handler;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PngsDecorDrawable$doFrameUpdate$1
  implements Runnable
{
  PngsDecorDrawable$doFrameUpdate$1(PngsDecorDrawable paramPngsDecorDrawable, PngsDrawable paramPngsDrawable) {}
  
  public final void run()
  {
    if (this.this$0.isFirst().get())
    {
      IDrawable localIDrawable = this.this$0.getDrawable();
      if (localIDrawable != null) {
        ((PngsDrawable)localIDrawable).a(0);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.pngs.PngsDrawable");
      }
    }
    this.a.b();
    XAEngine.Companion.c().post((Runnable)new PngsDecorDrawable.doFrameUpdate.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.pngs.PngsDecorDrawable.doFrameUpdate.1
 * JD-Core Version:    0.7.0.1
 */