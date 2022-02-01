package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Rotate;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "rx", "", "getRx", "()F", "setRx", "(F)V", "ry", "getRy", "setRy", "rz", "getRz", "setRz", "startX", "getStartX", "setStartX", "startY", "getStartY", "setStartY", "startZ", "getStartZ", "setStartZ", "doFrameUpdate", "", "animTime", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
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
    float f;
    if (localView != null)
    {
      f = this.startX;
      localView.setRotationX(f + (this.rx - f) * paramFloat);
    }
    localView = getView();
    if (localView != null)
    {
      f = this.startY;
      localView.setRotationY(f + (this.ry - f) * paramFloat);
    }
    localView = getView();
    if (localView != null)
    {
      f = this.startZ;
      localView.setRotation(f + (this.rz - f) * paramFloat);
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.Rotate
 * JD-Core Version:    0.7.0.1
 */