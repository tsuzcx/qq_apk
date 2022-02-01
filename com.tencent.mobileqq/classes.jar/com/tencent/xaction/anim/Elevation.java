package com.tencent.xaction.anim;

import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Elevation;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "elev", "", "getElev", "()F", "setElev", "(F)V", "start", "getStart", "setStart", "doFrameUpdate", "", "animTime", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Elevation
  extends BaseAnim
{
  private float elev;
  private float start;
  
  public void doFrameUpdate(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      View localView = getView();
      if (localView != null)
      {
        float f = this.start;
        localView.setElevation(f + (this.elev - f) * paramFloat);
      }
    }
  }
  
  public final float getElev()
  {
    return this.elev;
  }
  
  public final float getStart()
  {
    return this.start;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    if (Build.VERSION.SDK_INT >= 21) {
      this.start = paramView.getElevation();
    }
  }
  
  public final void setElev(float paramFloat)
  {
    this.elev = paramFloat;
  }
  
  public final void setStart(float paramFloat)
  {
    this.start = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.Elevation
 * JD-Core Version:    0.7.0.1
 */