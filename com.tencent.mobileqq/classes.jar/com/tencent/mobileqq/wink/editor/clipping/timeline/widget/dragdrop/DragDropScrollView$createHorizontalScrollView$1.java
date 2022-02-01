package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.content.Context;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$createHorizontalScrollView$1", "Landroid/widget/HorizontalScrollView;", "listener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "fling", "", "velocityX", "", "onScrollChanged", "l", "t", "oldl", "oldt", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DragDropScrollView$createHorizontalScrollView$1
  extends HorizontalScrollView
{
  private final DynamicAnimation.OnAnimationUpdateListener b = (DynamicAnimation.OnAnimationUpdateListener)new DragDropScrollView.createHorizontalScrollView.1.listener.1(this);
  
  DragDropScrollView$createHorizontalScrollView$1(Context paramContext)
  {
    super(localContext);
  }
  
  public void fling(int paramInt)
  {
    Object localObject = DragDropScrollView.a(this.a);
    if (localObject != null)
    {
      localObject = ((DragDropScrollViewController)localObject).f();
      if (localObject != null)
      {
        float f1 = paramInt;
        float f2 = getScrollX();
        BottomLineRelativeLayout localBottomLineRelativeLayout = this.a.getContentView();
        if (localBottomLineRelativeLayout == null) {
          Intrinsics.throwNpe();
        }
        ((FlingHelper)localObject).a(f1, f2, localBottomLineRelativeLayout.getMeasuredWidth(), this.b);
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.a.getContentView();
    if (localObject != null)
    {
      int i = 0;
      int j = ((BottomLineRelativeLayout)localObject).getChildCount();
      while (i < j)
      {
        View localView = ((BottomLineRelativeLayout)localObject).getChildAt(i);
        if ((localView != null) && ((localView instanceof IDragDropScrollListener))) {
          ((IDragDropScrollListener)localView).a((View)this, paramInt1, paramInt2, paramInt3, paramInt4);
        }
        i += 1;
      }
    }
    localObject = DragDropScrollView.a(this.a);
    if (localObject != null) {
      ((DragDropScrollViewController)localObject).b(paramInt1);
    }
    DragDropScrollView.b(this.a).a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView.createHorizontalScrollView.1
 * JD-Core Version:    0.7.0.1
 */