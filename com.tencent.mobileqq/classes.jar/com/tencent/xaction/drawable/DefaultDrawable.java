package com.tencent.xaction.drawable;

import android.view.View;
import com.tencent.xaction.api.base.DecorDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/DefaultDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "DefaultDrawableState", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class DefaultDrawable
  extends DecorDrawable
{
  public void doFrameUpdate(float paramFloat) {}
  
  public void end() {}
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.DefaultDrawable
 * JD-Core Version:    0.7.0.1
 */