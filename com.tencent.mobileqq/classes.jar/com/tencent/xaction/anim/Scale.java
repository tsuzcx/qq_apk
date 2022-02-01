package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Scale;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "startX", "", "getStartX", "()F", "setStartX", "(F)V", "startY", "getStartY", "setStartY", "sx", "getSx", "setSx", "sy", "getSy", "setSy", "doFrameUpdate", "", "animTime", "end", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Scale
  extends BaseAnim
{
  private float startX;
  private float startY;
  private float sx;
  private float sy;
  
  public void doFrameUpdate(float paramFloat)
  {
    View localView = getView();
    if (localView != null) {
      localView.setScaleX(this.startX + (this.sx - this.startX) * paramFloat);
    }
    localView = getView();
    if (localView != null) {
      localView.setScaleY(this.startY + (this.sy - this.startY) * paramFloat);
    }
  }
  
  public void end() {}
  
  public final float getStartX()
  {
    return this.startX;
  }
  
  public final float getStartY()
  {
    return this.startY;
  }
  
  public final float getSx()
  {
    return this.sx;
  }
  
  public final float getSy()
  {
    return this.sy;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    this.startX = paramView.getScaleX();
    this.startY = paramView.getScaleY();
  }
  
  public final void setStartX(float paramFloat)
  {
    this.startX = paramFloat;
  }
  
  public final void setStartY(float paramFloat)
  {
    this.startY = paramFloat;
  }
  
  public final void setSx(float paramFloat)
  {
    this.sx = paramFloat;
  }
  
  public final void setSy(float paramFloat)
  {
    this.sy = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.anim.Scale
 * JD-Core Version:    0.7.0.1
 */