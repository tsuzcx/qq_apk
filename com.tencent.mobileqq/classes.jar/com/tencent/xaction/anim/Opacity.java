package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Opacity;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "op", "", "getOp", "()F", "setOp", "(F)V", "startAlpha", "getStartAlpha", "setStartAlpha", "doFrameUpdate", "", "animTime", "end", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Opacity
  extends BaseAnim
{
  private float op;
  private float startAlpha;
  
  public void doFrameUpdate(float paramFloat)
  {
    View localView = getView();
    if (localView != null) {
      localView.setAlpha(this.startAlpha + (this.op - this.startAlpha) * paramFloat);
    }
  }
  
  public void end() {}
  
  public final float getOp()
  {
    return this.op;
  }
  
  public final float getStartAlpha()
  {
    return this.startAlpha;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    this.startAlpha = paramView.getAlpha();
  }
  
  public final void setOp(float paramFloat)
  {
    this.op = paramFloat;
  }
  
  public final void setStartAlpha(float paramFloat)
  {
    this.startAlpha = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.anim.Opacity
 * JD-Core Version:    0.7.0.1
 */