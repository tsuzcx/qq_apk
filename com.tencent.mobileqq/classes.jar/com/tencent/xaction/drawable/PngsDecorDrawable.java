package com.tencent.xaction.drawable;

import android.os.Handler;
import android.view.View;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.impl.XATimeline;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/PngsDecorDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "set", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "PngsDecorDrawableState", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class PngsDecorDrawable
  extends DecorDrawable
{
  public PngsDecorDrawable()
  {
    setDrawable((IDrawable)new PngsDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.a((DecorDrawable)this);
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    Object localObject = getDrawable();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.PngsDrawable");
    }
    localObject = (PngsDrawable)localObject;
    if (((PngsDrawable)localObject).getCallback() == null)
    {
      localObject = getTl();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((XATimeline)localObject).c();
      return;
    }
    XAEngine.Companion.a().execute((Runnable)new PngsDecorDrawable.doFrameUpdate.1(this, (PngsDrawable)localObject));
  }
  
  public void end()
  {
    Object localObject = getTl();
    if (localObject != null)
    {
      long l = ((XATimeline)localObject).a();
      localObject = getEngine();
      if (localObject != null)
      {
        localObject = ((XAEngine)localObject).getUiHandler();
        if (localObject != null) {
          ((Handler)localObject).postDelayed((Runnable)new PngsDecorDrawable.end..inlined.let.lambda.1(this), l);
        }
      }
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject = getDrawable();
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.PngsDrawable");
    }
    localObject = (PngsDrawable)localObject;
    ((PngsDrawable)localObject).a(paramView.getResources());
    if ((((PngsDrawable)localObject).a() == null) && (getDecorState() != null)) {
      XAEngine.Companion.a().execute((Runnable)new PngsDecorDrawable.preStart.1(this, (PngsDrawable)localObject, paramView));
    }
  }
  
  public void set(@NotNull IDrawable paramIDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIDrawable, "drawable");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.drawable.PngsDecorDrawable
 * JD-Core Version:    0.7.0.1
 */