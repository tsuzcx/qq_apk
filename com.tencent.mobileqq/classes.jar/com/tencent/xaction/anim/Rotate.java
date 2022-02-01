package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Rotate;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "rx", "", "getRx", "()F", "setRx", "(F)V", "ry", "getRy", "setRy", "rz", "getRz", "setRz", "startX", "getStartX", "setStartX", "startY", "getStartY", "setStartY", "startZ", "getStartZ", "setStartZ", "doFrameUpdate", "", "animTime", "end", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Rotate
  extends BaseAnim
{
  private float rx;
  private float ry;
  private float rz;
  private float startX;
  private float startY;
  private float startZ;
  
  public void doFrameUpdate(float paramFloat)
  {
    View localView = getView();
    if (localView != null) {
      localView.setRotationX(this.startX + (this.rx - this.startX) * paramFloat);
    }
    localView = getView();
    if (localView != null) {
      localView.setRotationY(this.startY + (this.ry - this.startY) * paramFloat);
    }
    localView = getView();
    if (localView != null) {
      localView.setRotation(this.startZ + (this.rz - this.startZ) * paramFloat);
    }
  }
  
  public void end() {}
  
  public final float getRx()
  {
    return this.rx;
  }
  
  public final float getRy()
  {
    return this.ry;
  }
  
  public final float getRz()
  {
    return this.rz;
  }
  
  public final float getStartX()
  {
    return this.startX;
  }
  
  public final float getStartY()
  {
    return this.startY;
  }
  
  public final float getStartZ()
  {
    return this.startZ;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    this.startX = paramView.getRotationX();
    this.startY = paramView.getRotationY();
    this.startZ = paramView.getRotation();
  }
  
  public final void setRx(float paramFloat)
  {
    this.rx = paramFloat;
  }
  
  public final void setRy(float paramFloat)
  {
    this.ry = paramFloat;
  }
  
  public final void setRz(float paramFloat)
  {
    this.rz = paramFloat;
  }
  
  public final void setStartX(float paramFloat)
  {
    this.startX = paramFloat;
  }
  
  public final void setStartY(float paramFloat)
  {
    this.startY = paramFloat;
  }
  
  public final void setStartZ(float paramFloat)
  {
    this.startZ = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.anim.Rotate
 * JD-Core Version:    0.7.0.1
 */