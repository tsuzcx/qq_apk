package com.tencent.xaction.api.base;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/api/base/DecorDrawable$baseAnim$1", "Lcom/tencent/xaction/api/base/BaseAnim;", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class DecorDrawable$baseAnim$1
  extends BaseAnim
{
  public void doFrameUpdate(float paramFloat)
  {
    this.a.doFrameUpdate(paramFloat);
  }
  
  public void end()
  {
    this.a.end();
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    this.a.preStart(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawable.baseAnim.1
 * JD-Core Version:    0.7.0.1
 */