package com.tencent.xaction.drawable.partical;

import android.graphics.Canvas;
import android.view.View;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/ParticalDecorDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "Lcom/tencent/xaction/drawable/partical/IParticalDecor;", "()V", "stormPartical", "Lcom/tencent/xaction/drawable/partical/StormPartical;", "getStormPartical", "()Lcom/tencent/xaction/drawable/partical/StormPartical;", "setStormPartical", "(Lcom/tencent/xaction/drawable/partical/StormPartical;)V", "doFrameUpdate", "", "animTime", "", "drawPartical", "canvas", "Landroid/graphics/Canvas;", "end", "preStart", "view", "Landroid/view/View;", "stop", "ParticalDecorDrawableState", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ParticalDecorDrawable
  extends DecorDrawable
  implements IParticalDecor
{
  @Nullable
  private StormPartical a;
  
  public ParticalDecorDrawable()
  {
    setDrawable((IDrawable)new ParticalDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  public void a(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Object localObject = (ParticalDecorDrawable.ParticalDecorDrawableState)null;
    if (!(getDecorState() instanceof ParticalDecorDrawable.ParticalDecorDrawableState)) {
      return;
    }
    localObject = getDecorState();
    if (localObject != null)
    {
      localObject = (ParticalDecorDrawable.ParticalDecorDrawableState)localObject;
      if (((ParticalDecorDrawable.ParticalDecorDrawableState)localObject).getTexture() != null)
      {
        StormPartical localStormPartical = this.a;
        if (localStormPartical == null) {
          Intrinsics.throwNpe();
        }
        localStormPartical.a(paramCanvas, ((ParticalDecorDrawable.ParticalDecorDrawableState)localObject).getTexture());
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState");
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    View localView = getView();
    if (localView != null) {
      localView.invalidate();
    }
  }
  
  public void end() {}
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    setView(paramView);
    paramView = getDecorState();
    if (paramView != null)
    {
      paramView = (ParticalDecorDrawable.ParticalDecorDrawableState)paramView;
      this.a = new StormPartical(getDuration());
      Object localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((StormPartical)localObject).a();
      ScreenUnit.Companion localCompanion = ScreenUnit.a;
      float f = paramView.getScale();
      StormPartical localStormPartical = this.a;
      if (localStormPartical == null) {
        Intrinsics.throwNpe();
      }
      ((StormPartical.ParticalData)localObject).a(localCompanion.b(f, localStormPartical.a().g()));
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((StormPartical)localObject).a();
      localCompanion = ScreenUnit.a;
      f = paramView.getSpeed();
      localStormPartical = this.a;
      if (localStormPartical == null) {
        Intrinsics.throwNpe();
      }
      ((StormPartical.ParticalData)localObject).c(localCompanion.b(f, localStormPartical.a().o()));
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((StormPartical)localObject).a();
      localCompanion = ScreenUnit.a;
      f = paramView.getCamZ();
      localStormPartical = this.a;
      if (localStormPartical == null) {
        Intrinsics.throwNpe();
      }
      ((StormPartical.ParticalData)localObject).c(localCompanion.b(f, (float)localStormPartical.a().c()));
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((StormPartical)localObject).a();
      localCompanion = ScreenUnit.a;
      f = paramView.getCamY();
      localStormPartical = this.a;
      if (localStormPartical == null) {
        Intrinsics.throwNpe();
      }
      ((StormPartical.ParticalData)localObject).b(localCompanion.b(f, (float)localStormPartical.a().b()));
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((StormPartical)localObject).a();
      localCompanion = ScreenUnit.a;
      int i = paramView.getCount();
      localStormPartical = this.a;
      if (localStormPartical == null) {
        Intrinsics.throwNpe();
      }
      ((StormPartical.ParticalData)localObject).c(localCompanion.b(i, localStormPartical.a().i()));
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((StormPartical)localObject).a();
      localCompanion = ScreenUnit.a;
      f = paramView.getRadius();
      paramView = this.a;
      if (paramView == null) {
        Intrinsics.throwNpe();
      }
      ((StormPartical.ParticalData)localObject).b(localCompanion.b(f, paramView.a().k()));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState");
  }
  
  public void stop()
  {
    StormPartical localStormPartical = this.a;
    if (localStormPartical != null) {
      localStormPartical.b();
    }
    this.a = ((StormPartical)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.ParticalDecorDrawable
 * JD-Core Version:    0.7.0.1
 */