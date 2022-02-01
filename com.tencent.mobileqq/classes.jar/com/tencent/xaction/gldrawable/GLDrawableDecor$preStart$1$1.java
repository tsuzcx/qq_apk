package com.tencent.xaction.gldrawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawable.Companion;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GLDrawableDecor$preStart$1$1
  implements Runnable
{
  GLDrawableDecor$preStart$1$1(GLDrawableDecor.preStart.1 param1) {}
  
  public final void run()
  {
    int i;
    if ((this.this$0.a instanceof IView))
    {
      ViewData localViewData = ((IView)this.this$0.a).getDecor().getStyle();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      i = localViewData.getSt().getHierarchy();
    }
    else
    {
      i = 0;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      DecorDrawable.Companion.a(DecorDrawable.Companion, i, this.this$0.a, (Drawable)this.this$0.this$0.a(), false, 8, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.gldrawable.GLDrawableDecor.preStart.1.1
 * JD-Core Version:    0.7.0.1
 */