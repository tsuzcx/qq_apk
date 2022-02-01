package com.tencent.xaction.drawable.pngs;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.impl.XATimeline;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PngsDecorDrawable$preStart$1
  implements Runnable
{
  PngsDecorDrawable$preStart$1(PngsDecorDrawable paramPngsDecorDrawable, PngsDrawable paramPngsDrawable, View paramView) {}
  
  public final void run()
  {
    Object localObject1 = this.this$0.getTl();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((XATimeline)localObject1).a();
    Object localObject2 = FileUtil.a;
    Object localObject3 = this.this$0.getDecorState();
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject4;
    Object localObject5;
    if (((FileUtil.Companion)localObject2).b(((DecorDrawableState)localObject3).getPath()))
    {
      localObject2 = this.a;
      localObject3 = FileUtil.a;
      localObject4 = this.this$0.getDecorState();
      if (localObject4 == null) {
        Intrinsics.throwNpe();
      }
      localObject4 = ((DecorDrawableState)localObject4).getPath();
      localObject5 = this.b.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "view.resources");
      ((PngsDrawable)localObject2).a(((FileUtil.Companion)localObject3).a((String)localObject4, (Resources)localObject5));
    }
    else
    {
      localObject2 = FilePathUtil.a;
      localObject3 = this.this$0.getDecorState();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((FilePathUtil.Companion)localObject2).a(((DecorDrawableState)localObject3).getPath(), "$PARENT_ROOT", this.this$0.getEngine());
      localObject3 = this.a;
      localObject4 = FileUtil.a;
      localObject5 = this.this$0.getDecorState();
      if (localObject5 == null) {
        Intrinsics.throwNpe();
      }
      ((PngsDrawable)localObject3).a(((FileUtil.Companion)localObject4).a((String)localObject2, ((DecorDrawableState)localObject5).getFp()));
    }
    if ((((TimeProp)localObject1).getDuration() <= 0) && (this.a.a() != null) && (((TimeProp)localObject1).getRc() > 0))
    {
      localObject2 = this.a.a();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((TimeProp)localObject1).setDuration((int)(localObject2.length * (1000.0F / ((TimeProp)localObject1).getFps())));
      this.this$0.setDuration(((TimeProp)localObject1).getDuration());
    }
    this.a.b();
    XAEngine.Companion.c().post((Runnable)new PngsDecorDrawable.preStart.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.pngs.PngsDecorDrawable.preStart.1
 * JD-Core Version:    0.7.0.1
 */