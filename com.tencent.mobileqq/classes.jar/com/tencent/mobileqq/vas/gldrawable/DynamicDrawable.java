package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable;", "Lcom/tencent/mobileqq/vas/gldrawable/AbsBaseDrawable;", "()V", "callbackProxy", "com/tencent/mobileqq/vas/gldrawable/DynamicDrawable$callbackProxy$1", "Lcom/tencent/mobileqq/vas/gldrawable/DynamicDrawable$callbackProxy$1;", "value", "Landroid/graphics/drawable/Drawable;", "currentDrawable", "getCurrentDrawable", "()Landroid/graphics/drawable/Drawable;", "setCurrentDrawable", "(Landroid/graphics/drawable/Drawable;)V", "doFailedDrawableBuild", "Lkotlin/Function0;", "doTargetDrawableBuild", "failedDrawableBuild", "getFailedDrawableBuild", "()Lkotlin/jvm/functions/Function0;", "setFailedDrawableBuild", "(Lkotlin/jvm/functions/Function0;)V", "isRecycle", "", "targetDrawableBuild", "getTargetDrawableBuild", "setTargetDrawableBuild", "tmpalpha", "", "applyToBaseDrawable", "", "child", "applyToDrawable", "build", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getPadding", "padding", "Landroid/graphics/Rect;", "getResID", "", "isRecyclyed", "loadAndRefresh", "loader", "Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableProxy$GLDrawableLoader;", "onBoundsChange", "bounds", "onDraw", "canvas", "Landroid/graphics/Canvas;", "left", "top", "right", "bottom", "onTouch", "x", "", "y", "recycle", "setAlpha", "alpha", "setBounds", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setVisible", "visible", "restart", "updateDrawableState", "MyLoaderCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DynamicDrawable
  extends AbsBaseDrawable
{
  private int jdField_a_of_type_Int = 255;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final DynamicDrawable.callbackProxy.1 jdField_a_of_type_ComTencentMobileqqVasGldrawableDynamicDrawable$callbackProxy$1 = new DynamicDrawable.callbackProxy.1(this);
  @Nullable
  private Function0<? extends Drawable> jdField_a_of_type_KotlinJvmFunctionsFunction0;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private Function0<? extends Drawable> b = (Function0)DynamicDrawable.targetDrawableBuild.1.INSTANCE;
  private final Function0<Drawable> c = (Function0)new DynamicDrawable.doFailedDrawableBuild.1(this);
  private final Function0<Drawable> d = (Function0)new DynamicDrawable.doTargetDrawableBuild.1(this);
  
  private final void a(Drawable paramDrawable)
  {
    if ((Intrinsics.areEqual(paramDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) ^ true))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      c();
    }
  }
  
  private final void a(GLDrawableProxy.GLDrawableLoader paramGLDrawableLoader)
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new DynamicDrawable.loadAndRefresh.1(this, paramGLDrawableLoader));
  }
  
  private final void b(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Boolean) {
      GLDrawableProxy.a().a(paramDrawable);
    }
    if ((paramDrawable instanceof Animatable)) {
      ((Animatable)paramDrawable).start();
    }
  }
  
  private final void c()
  {
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new DynamicDrawable.updateDrawableState.1(this));
  }
  
  private final void c(Drawable paramDrawable)
  {
    paramDrawable.setCallback((Drawable.Callback)this.jdField_a_of_type_ComTencentMobileqqVasGldrawableDynamicDrawable$callbackProxy$1);
    paramDrawable.setAlpha(this.jdField_a_of_type_Int);
    paramDrawable.setBounds(getBounds());
    paramDrawable.setVisible(isVisible(), false);
  }
  
  @Nullable
  public final Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  @Nullable
  public final Function0<Drawable> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction0;
  }
  
  public final void a()
  {
    GLDrawableProxy.GLDrawableLoader localGLDrawableLoader = GLDrawableWraper.a();
    Intrinsics.checkExpressionValueIsNotNull(localGLDrawableLoader, "loader");
    if (!localGLDrawableLoader.a())
    {
      Drawable localDrawable = (Drawable)this.c.invoke();
      if (localDrawable != null) {
        a(localDrawable);
      }
    }
    a(localGLDrawableLoader);
  }
  
  public void a(@NotNull Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null)
    {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      localDrawable.draw(paramCanvas);
    }
  }
  
  public final void a(@Nullable Function0<? extends Drawable> paramFunction0)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction0 = paramFunction0;
  }
  
  @NotNull
  public final Function0<Drawable> b()
  {
    return this.b;
  }
  
  public void b()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (GLDrawableProxy.a(localDrawable))) {
      GLDrawableProxy.a().a(localDrawable);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void b(@NotNull Function0<? extends Drawable> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.b = paramFunction0;
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return localDrawable.getConstantState();
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return super.getIntrinsicWidth();
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  public boolean getPadding(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "padding");
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      return localDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  protected void onBoundsChange(@Nullable Rect paramRect)
  {
    if (paramRect != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null) {
        localDrawable.setBounds(paramRect);
      }
    }
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setColorFilter(paramColorFilter);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.DynamicDrawable
 * JD-Core Version:    0.7.0.1
 */