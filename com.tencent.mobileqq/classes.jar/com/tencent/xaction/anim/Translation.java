package com.tencent.xaction.anim;

import android.view.View;
import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Translation;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "startX", "", "startY", "tx", "getTx", "()F", "setTx", "(F)V", "txPX", "", "getTxPX", "()I", "setTxPX", "(I)V", "ty", "getTy", "setTy", "tyPX", "getTyPX", "setTyPX", "doFrameUpdate", "", "animTime", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Translation
  extends BaseAnim
{
  private float startX;
  private float startY;
  private float tx;
  private transient int txPX = ScreenUnit.a.a();
  private float ty;
  private transient int tyPX = ScreenUnit.a.a();
  
  public void doFrameUpdate(float paramFloat)
  {
    View localView = getView();
    float f;
    if (localView != null)
    {
      f = this.startX;
      localView.setTranslationX(f + (this.txPX - f) * paramFloat);
    }
    localView = getView();
    if (localView != null)
    {
      f = this.startY;
      localView.setTranslationY(f + (this.tyPX - f) * paramFloat);
    }
  }
  
  public final float getTx()
  {
    return this.tx;
  }
  
  public final int getTxPX()
  {
    return this.txPX;
  }
  
  public final float getTy()
  {
    return this.ty;
  }
  
  public final int getTyPX()
  {
    return this.tyPX;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    this.startX = paramView.getTranslationX();
    this.startY = paramView.getTranslationY();
    this.txPX = ScreenUnit.a.d(this.tx);
    this.tyPX = ScreenUnit.a.d(this.ty);
  }
  
  public final void setTx(float paramFloat)
  {
    this.tx = paramFloat;
  }
  
  public final void setTxPX(int paramInt)
  {
    this.txPX = paramInt;
  }
  
  public final void setTy(float paramFloat)
  {
    this.ty = paramFloat;
  }
  
  public final void setTyPX(int paramInt)
  {
    this.tyPX = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.Translation
 * JD-Core Version:    0.7.0.1
 */