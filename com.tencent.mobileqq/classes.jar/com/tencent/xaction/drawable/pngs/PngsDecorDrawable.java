package com.tencent.xaction.drawable.pngs;

import android.os.Handler;
import android.view.View;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/pngs/PngsDecorDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "doFrameUpdate", "", "animTime", "", "end", "init", "view", "Landroid/view/View;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "preStart", "set", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "stop", "PngsDecorDrawableState", "XActionCore_release"}, k=1, mv={1, 1, 16})
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
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    Object localObject = getDrawable();
    if (localObject != null)
    {
      localObject = (PngsDrawable)localObject;
      if (((PngsDrawable)localObject).getCallback() == null)
      {
        localObject = getTl();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((XATimeline)localObject).e();
        return;
      }
      XAEngine.Companion.a().execute((Runnable)new PngsDecorDrawable.doFrameUpdate.1(this, (PngsDrawable)localObject));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.pngs.PngsDrawable");
  }
  
  public void end()
  {
    Object localObject = getTl();
    if (localObject != null)
    {
      long l = ((XATimeline)localObject).b();
      localObject = XAEngine.Companion.c();
      if (localObject != null) {
        localObject = Boolean.valueOf(((Handler)localObject).postDelayed((Runnable)new PngsDecorDrawable.end..inlined.let.lambda.1(this), l));
      } else {
        localObject = null;
      }
      ((Boolean)localObject).booleanValue();
    }
  }
  
  public void init(@NotNull View paramView, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    super.init(paramView, paramIXAEngine);
    if ((getDecorState() instanceof PngsDecorDrawable.PngsDecorDrawableState))
    {
      paramView = getDecorState();
      if (paramView != null)
      {
        setMirror(((PngsDecorDrawable.PngsDecorDrawableState)paramView).a());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.pngs.PngsDecorDrawable.PngsDecorDrawableState");
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    Object localObject = getDrawable();
    if (localObject != null)
    {
      localObject = (PngsDrawable)localObject;
      ((PngsDrawable)localObject).a(paramView.getResources());
      if (((PngsDrawable)localObject).a() == null)
      {
        if (getDecorState() == null) {
          return;
        }
        XAEngine.Companion.a().execute((Runnable)new PngsDecorDrawable.preStart.1(this, (PngsDrawable)localObject, paramView));
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.pngs.PngsDrawable");
  }
  
  public void set(@NotNull IDrawable paramIDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIDrawable, "drawable");
  }
  
  public void stop()
  {
    end();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.pngs.PngsDecorDrawable
 * JD-Core Version:    0.7.0.1
 */