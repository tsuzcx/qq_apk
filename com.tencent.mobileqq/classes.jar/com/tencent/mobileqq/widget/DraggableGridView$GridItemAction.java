package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DraggableGridView$GridItemAction
  implements View.OnClickListener, View.OnLongClickListener
{
  private int b;
  private int c;
  
  public DraggableGridView$GridItemAction(DraggableGridView paramDraggableGridView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void onClick(View paramView)
  {
    if (DraggableGridView.k(this.a) != null) {
      DraggableGridView.k(this.a).a(paramView, this.b, this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (DraggableGridView.g(this.a) != null) {
      DraggableGridView.g(this.a).a(this.b, this.c);
    }
    if ((DraggableGridView.h(this.a)) && (!DraggableGridView.d(this.a)))
    {
      this.a.a((View)paramView.getParent(), paramView);
      paramView.setVisibility(4);
      paramView.setPressed(false);
      DraggableGridView.a(this.a, this.b);
      DraggableGridView.b(this.a, this.c);
      DraggableGridView.e(this.a).x = DraggableGridView.i(this.a);
      DraggableGridView.e(this.a).y = DraggableGridView.j(this.a);
      DraggableGridView.a(this.a, true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.GridItemAction
 * JD-Core Version:    0.7.0.1
 */