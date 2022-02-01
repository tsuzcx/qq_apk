package com.tencent.xaction.gldrawable;

import android.view.View;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/gldrawable/GLDrawableDecor;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "GLDrawableDecorState", "XAGLDrawable_release"}, k=1, mv={1, 1, 16})
public final class GLDrawableDecor
  extends DecorDrawable
{
  public GLDrawableDecor()
  {
    setDrawable((IDrawable)new XAGLDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  public void doFrameUpdate(float paramFloat) {}
  
  public void end() {}
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    XAEngine.Companion.a().execute((Runnable)new GLDrawableDecor.preStart.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.gldrawable.GLDrawableDecor
 * JD-Core Version:    0.7.0.1
 */