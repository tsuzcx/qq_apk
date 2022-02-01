package com.tencent.xaction;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/XAPagView$decor$1$bindData$1$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "XAPag_release"}, k=1, mv={1, 1, 16})
public final class XAPagView$decor$1$bindData$1$1
  implements PAGView.PAGViewListener
{
  public void onAnimationCancel(@Nullable PAGView paramPAGView)
  {
    this.a.this$0.a("cancel", (View)this.a.this$0.a);
  }
  
  public void onAnimationEnd(@Nullable PAGView paramPAGView)
  {
    this.a.this$0.a("end", (View)this.a.this$0.a);
  }
  
  public void onAnimationRepeat(@Nullable PAGView paramPAGView)
  {
    this.a.this$0.a("repeat", (View)this.a.this$0.a);
  }
  
  public void onAnimationStart(@Nullable PAGView paramPAGView)
  {
    this.a.this$0.a("play", (View)this.a.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XAPagView.decor.1.bindData.1.1
 * JD-Core Version:    0.7.0.1
 */