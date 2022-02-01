package com.tencent.mobileqq.vas.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/AbsAsyncDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/mobileqq/vas/ui/IAsyncDrawableConfig;", "()V", "callbackProxy", "com/tencent/mobileqq/vas/ui/AbsAsyncDrawable$callbackProxy$1", "Lcom/tencent/mobileqq/vas/ui/AbsAsyncDrawable$callbackProxy$1;", "value", "currentDrawable", "getCurrentDrawable", "()Landroid/graphics/drawable/Drawable;", "setCurrentDrawable", "(Landroid/graphics/drawable/Drawable;)V", "doFailedDrawableBuild", "Lkotlin/Function0;", "doTargetDrawableBuild", "failedDrawableBuild", "getFailedDrawableBuild", "()Lkotlin/jvm/functions/Function0;", "setFailedDrawableBuild", "(Lkotlin/jvm/functions/Function0;)V", "requestLodingHeight", "", "getRequestLodingHeight", "()I", "setRequestLodingHeight", "(I)V", "requestLodingWidth", "getRequestLodingWidth", "setRequestLodingWidth", "targetDrawableBuild", "getTargetDrawableBuild", "setTargetDrawableBuild", "tmpalpha", "applyToDrawable", "", "child", "doLoadTask", "callback", "Lcom/tencent/mobileqq/vas/ui/ILoaderSucessCallback;", "draw", "canvas", "Landroid/graphics/Canvas;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getPadding", "", "padding", "Landroid/graphics/Rect;", "isLoadSucess", "load", "loadAndRefresh", "onBoundsChange", "bounds", "postSubTask", "block", "postUITask", "setAlpha", "alpha", "setBounds", "left", "top", "right", "bottom", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setVisible", "visible", "restart", "updateDrawableState", "Companion", "MyAsyncLoaderCallback", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract class AbsAsyncDrawable
  extends Drawable
  implements IAsyncDrawableConfig
{
  public static final AbsAsyncDrawable.Companion b = new AbsAsyncDrawable.Companion(null);
  @Nullable
  private Function0<? extends Drawable> a;
  @NotNull
  private Function0<? extends Drawable> d = (Function0)AbsAsyncDrawable.targetDrawableBuild.1.INSTANCE;
  @Nullable
  private Drawable e;
  private final Function0<Drawable> f = (Function0)new AbsAsyncDrawable.doFailedDrawableBuild.1(this);
  private final Function0<Drawable> g = (Function0)new AbsAsyncDrawable.doTargetDrawableBuild.1(this);
  private final AbsAsyncDrawable.callbackProxy.1 h = new AbsAsyncDrawable.callbackProxy.1(this);
  private int i = 255;
  
  private final void a(Drawable paramDrawable)
  {
    if ((Intrinsics.areEqual(paramDrawable, this.e) ^ true))
    {
      this.e = paramDrawable;
      b();
    }
  }
  
  private final void b()
  {
    a((Function0)new AbsAsyncDrawable.updateDrawableState.1(this));
  }
  
  private final void b(Drawable paramDrawable)
  {
    paramDrawable.setCallback((Drawable.Callback)this.h);
    paramDrawable.setAlpha(this.i);
    paramDrawable.setBounds(getBounds());
    paramDrawable.setVisible(isVisible(), false);
  }
  
  private final void i()
  {
    AbsAsyncDrawable.MyAsyncLoaderCallback localMyAsyncLoaderCallback = new AbsAsyncDrawable.MyAsyncLoaderCallback(new WeakReference(this));
    if (a())
    {
      localMyAsyncLoaderCallback.a();
      return;
    }
    a((ILoaderSucessCallback)localMyAsyncLoaderCallback);
  }
  
  public void a(int paramInt)
  {
    this.j.b(paramInt);
  }
  
  public abstract void a(@NotNull ILoaderSucessCallback paramILoaderSucessCallback);
  
  public abstract void a(@NotNull Function0<Unit> paramFunction0);
  
  public abstract boolean a();
  
  public void b(int paramInt)
  {
    this.j.a(paramInt);
  }
  
  public abstract void b(@NotNull Function0<Unit> paramFunction0);
  
  @Nullable
  public final Function0<Drawable> c()
  {
    return this.a;
  }
  
  public final void c(@Nullable Function0<? extends Drawable> paramFunction0)
  {
    this.a = paramFunction0;
  }
  
  @NotNull
  public final Function0<Drawable> d()
  {
    return this.d;
  }
  
  public final void d(@NotNull Function0<? extends Drawable> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.d = paramFunction0;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Drawable localDrawable = this.e;
    if (localDrawable != null)
    {
      localDrawable.setBounds(getBounds());
      localDrawable.draw(paramCanvas);
    }
  }
  
  @Nullable
  public final Drawable e()
  {
    return this.e;
  }
  
  public final void f()
  {
    if (!a())
    {
      Drawable localDrawable = (Drawable)this.f.invoke();
      if (localDrawable != null) {
        a(localDrawable);
      }
    }
    i();
  }
  
  public int g()
  {
    return this.j.b();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      return localDrawable.getConstantState();
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    if (g() != -1) {
      return g();
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    if (h() != -1) {
      return h();
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  public boolean getPadding(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "padding");
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      return localDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int h()
  {
    return this.j.a();
  }
  
  protected void onBoundsChange(@Nullable Rect paramRect)
  {
    if (paramRect != null)
    {
      Drawable localDrawable = this.e;
      if (localDrawable != null) {
        localDrawable.setBounds(paramRect);
      }
    }
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
    this.i = paramInt;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.AbsAsyncDrawable
 * JD-Core Version:    0.7.0.1
 */