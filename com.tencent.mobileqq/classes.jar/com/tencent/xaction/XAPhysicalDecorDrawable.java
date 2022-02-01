package com.tencent.xaction;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.xaction.anim.PhysicalWorld2;
import com.tencent.xaction.anim.XARect;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.drawable.partical.IParticalDecor;
import com.tencent.xaction.drawable.partical.ParticalDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XAPhysicalDecorDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "Lcom/tencent/xaction/drawable/partical/IParticalDecor;", "()V", "idCount", "", "paint", "Landroid/graphics/Paint;", "random", "Ljava/util/Random;", "world", "Lcom/tencent/xaction/anim/PhysicalWorld2;", "createPartical", "", "count", "doFrameUpdate", "animTime", "", "drawPartical", "canvas", "Landroid/graphics/Canvas;", "end", "getState", "Lcom/tencent/xaction/XAPhysicalDecorDrawable$XAPhysicalDecorDrawableState;", "initWorld", "preStart", "view", "Landroid/view/View;", "stop", "XAPhysicalDecorDrawableState", "XAPhysical_release"}, k=1, mv={1, 1, 16})
public final class XAPhysicalDecorDrawable
  extends DecorDrawable
  implements IParticalDecor
{
  private transient PhysicalWorld2 a;
  private final transient Paint b = new Paint();
  private final Random c = new Random();
  private int d;
  
  public XAPhysicalDecorDrawable()
  {
    setDrawable((IDrawable)new ParticalDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  private final void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    Object localObject1 = getDecorState();
    if (localObject1 != null)
    {
      localObject1 = (XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1;
      if (1 <= paramInt)
      {
        int i = 1;
        for (;;)
        {
          double d1 = Math.toRadians(this.c.nextInt(90));
          double d2 = Math.cos(d1);
          double d3 = ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getRange();
          Double.isNaN(d3);
          float f2 = (float)(d2 * d3);
          float f1 = f2;
          if (!((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).isDirectLeft()) {
            f1 = -f2;
          }
          d1 = Math.sin(d1);
          d2 = ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getRange();
          Double.isNaN(d2);
          f2 = -(float)(d1 * d2);
          PhysicalWorld2 localPhysicalWorld2 = this.a;
          if (localPhysicalWorld2 != null)
          {
            this.d += 1;
            int j = this.d;
            Object localObject2 = getView();
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            localObject2 = ((View)localObject2).getResources();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "view!!.resources");
            localPhysicalWorld2.a(new XARect(j, ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getRandomTexture((Resources)localObject2), ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getStartXPx(), ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getStartYPx(), ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getW(), ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject1).getH(), 0.0F, 0.0F, 192, null), f1, f2);
          }
          if (i == paramInt) {
            break;
          }
          i += 1;
        }
      }
      return;
    }
    localObject1 = new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState");
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private final void b(Canvas paramCanvas)
  {
    this.a = new PhysicalWorld2();
    PhysicalWorld2 localPhysicalWorld2 = this.a;
    if (localPhysicalWorld2 == null) {
      Intrinsics.throwNpe();
    }
    localPhysicalWorld2.a(paramCanvas.getWidth(), paramCanvas.getHeight());
  }
  
  public void a(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.a == null) {
      b(paramCanvas);
    }
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((Map)((PhysicalWorld2)localObject).d()).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      XARect localXARect = (XARect)((Map.Entry)((Iterator)localObject).next()).getKey();
      Rect localRect = new Rect((int)localXARect.d(), (int)localXARect.e(), (int)(localXARect.d() + localXARect.f()), (int)(localXARect.e() + localXARect.g()));
      int i = paramCanvas.save();
      Bitmap localBitmap = localXARect.c();
      if (localBitmap != null)
      {
        paramCanvas.rotate(localXARect.h(), localXARect.a(), localXARect.b());
        paramCanvas.drawBitmap(localBitmap, null, localRect, this.b);
      }
      paramCanvas.restoreToCount(i);
    }
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    if (this.a == null) {
      return;
    }
    Object localObject = getDecorState();
    if (localObject != null)
    {
      int i = ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)localObject).getCount();
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (i > ((PhysicalWorld2)localObject).d().size()) {
        a(1);
      }
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((PhysicalWorld2)localObject).a(paramFloat);
      localObject = getDrawable();
      if (localObject != null)
      {
        ((Drawable)localObject).invalidateSelf();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState");
  }
  
  public void end()
  {
    PhysicalWorld2 localPhysicalWorld2 = this.a;
    if (localPhysicalWorld2 != null) {
      localPhysicalWorld2.b();
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    setView(paramView);
    paramView = getDecorState();
    if (paramView != null)
    {
      ((XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState)paramView).init();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState");
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XAPhysicalDecorDrawable
 * JD-Core Version:    0.7.0.1
 */