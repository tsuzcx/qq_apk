package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.base.BaseAnim;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/ResAnim;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "iAnim", "Lcom/tencent/xaction/api/IAnim;", "isAnimating", "", "playCtrl", "", "getPlayCtrl", "()I", "setPlayCtrl", "(I)V", "doFrameUpdate", "", "animTime", "", "end", "play", "preStart", "view", "Landroid/view/View;", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class ResAnim
  extends BaseAnim
{
  public static final ResAnim.Companion Companion = new ResAnim.Companion(null);
  public static final int DEFAULT = 0;
  public static final int PLAY = 1;
  public static final int STOP = 2;
  private transient IAnim iAnim;
  private transient boolean isAnimating;
  private int playCtrl;
  
  public void doFrameUpdate(float paramFloat)
  {
    IAnim localIAnim = this.iAnim;
    if (localIAnim != null) {
      localIAnim.doFrame((paramFloat * getDuration()));
    }
  }
  
  public void end()
  {
    if (this.playCtrl == 0)
    {
      IAnim localIAnim = this.iAnim;
      if (localIAnim != null) {
        localIAnim.end();
      }
      this.isAnimating = false;
    }
  }
  
  public final int getPlayCtrl()
  {
    return this.playCtrl;
  }
  
  public void play()
  {
    int i = this.playCtrl;
    IAnim localIAnim;
    if ((i != 1) && (i != 0))
    {
      if (i == 2)
      {
        localIAnim = this.iAnim;
        if (localIAnim != null) {
          localIAnim.end();
        }
      }
    }
    else
    {
      localIAnim = this.iAnim;
      if (localIAnim != null) {
        localIAnim.play();
      }
      this.isAnimating = true;
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
  
  public final void setPlayCtrl(int paramInt)
  {
    this.playCtrl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.ResAnim
 * JD-Core Version:    0.7.0.1
 */