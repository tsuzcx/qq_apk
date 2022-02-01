package com.tencent.tkd.comment.adapt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class PanelRootFrameLayout
  extends FrameLayout
{
  private final int[] a = new int[2];
  private PanelFrameLayout b;
  
  public PanelRootFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PanelRootFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PanelRootFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.b != null) {
      return;
    }
    if ((paramViewGroup instanceof PanelFrameLayout))
    {
      this.b = ((PanelFrameLayout)paramViewGroup);
      return;
    }
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        a((ViewGroup)localView);
      }
      i -= 1;
    }
  }
  
  private boolean a()
  {
    getLocationOnScreen(this.a);
    return KeyboardObserver.judgeKeyboardShowingByBottom(this.a[1] + getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    PanelFrameLayout localPanelFrameLayout = this.b;
    if (localPanelFrameLayout != null) {
      localPanelFrameLayout.setKeyboardShowing(false);
    }
    super.onMeasure(paramInt1, paramInt2);
    a(this);
    if ((this.b != null) && (a()) && (this.b.getMeasuredHeight() > 0))
    {
      this.b.setKeyboardShowing(true);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.adapt.PanelRootFrameLayout
 * JD-Core Version:    0.7.0.1
 */