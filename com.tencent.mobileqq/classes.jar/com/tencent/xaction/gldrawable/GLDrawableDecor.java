package com.tencent.xaction.gldrawable;

import android.view.View;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/gldrawable/GLDrawableDecor;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "glDrawable", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "getGlDrawable", "()Lcom/tencent/android/gldrawable/api/IGLDrawable;", "setGlDrawable", "(Lcom/tencent/android/gldrawable/api/IGLDrawable;)V", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "stop", "GLDrawableDecorState", "XAGLDrawable_release"}, k=1, mv={1, 1, 16})
public final class GLDrawableDecor
  extends DecorDrawable
{
  @Nullable
  private IGLDrawable a;
  
  public GLDrawableDecor()
  {
    setDrawable((IDrawable)new XAGLDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  @Nullable
  public final IGLDrawable a()
  {
    return this.a;
  }
  
  public final void a(@Nullable IGLDrawable paramIGLDrawable)
  {
    this.a = paramIGLDrawable;
  }
  
  public void doFrameUpdate(float paramFloat) {}
  
  public void end()
  {
    IGLDrawable localIGLDrawable = this.a;
    if (localIGLDrawable != null) {
      localIGLDrawable.recycle();
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    XAEngine.Companion.a().execute((Runnable)new GLDrawableDecor.preStart.1(this, paramView));
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.gldrawable.GLDrawableDecor
 * JD-Core Version:    0.7.0.1
 */