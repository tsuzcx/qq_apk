package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/ResAnim;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "iAnim", "Lcom/tencent/xaction/api/IAnim;", "isAnimating", "", "isPlay", "()Z", "setPlay", "(Z)V", "doFrameUpdate", "", "animTime", "", "end", "play", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ResAnim
  extends BaseAnim
{
  private IAnim iAnim;
  private transient boolean isAnimating;
  private boolean isPlay = true;
  
  public void doFrameUpdate(float paramFloat)
  {
    if (!this.isPlay) {
      return;
    }
    if (!this.isAnimating)
    {
      localIAnim = this.iAnim;
      if (localIAnim != null) {
        localIAnim.play();
      }
      this.isAnimating = true;
    }
    IAnim localIAnim = this.iAnim;
    if (localIAnim != null) {
      localIAnim.doFrame((paramFloat * getDuration()));
    }
  }
  
  public void end()
  {
    IAnim localIAnim = this.iAnim;
    if (localIAnim != null) {
      localIAnim.end();
    }
    this.isAnimating = false;
  }
  
  public final boolean isPlay()
  {
    return this.isPlay;
  }
  
  public void play()
  {
    if (this.isPlay)
    {
      IAnim localIAnim = this.iAnim;
      if (localIAnim != null) {
        localIAnim.play();
      }
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    if ((paramView instanceof IAnim))
    {
      this.iAnim = ((IAnim)paramView);
      IAnim localIAnim = this.iAnim;
      if (localIAnim != null) {
        localIAnim.preStart(paramView);
      }
    }
  }
  
  public final void setPlay(boolean paramBoolean)
  {
    this.isPlay = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.anim.ResAnim
 * JD-Core Version:    0.7.0.1
 */