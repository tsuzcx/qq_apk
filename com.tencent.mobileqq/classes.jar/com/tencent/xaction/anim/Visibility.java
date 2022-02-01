package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Visibility;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "vi", "", "getVi", "()Z", "setVi", "(Z)V", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Visibility
  extends BaseAnim
{
  private boolean vi = true;
  
  public void doFrameUpdate(float paramFloat)
  {
    View localView;
    if (paramFloat > 0.8D)
    {
      localView = getView();
      if (localView != null) {
        if (!this.vi) {
          break label33;
        }
      }
    }
    label33:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void end() {}
  
  public final boolean getVi()
  {
    return this.vi;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
  }
  
  public final void setVi(boolean paramBoolean)
  {
    this.vi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.anim.Visibility
 * JD-Core Version:    0.7.0.1
 */