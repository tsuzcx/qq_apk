package com.tencent.viola.ui.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.viola.ui.view.list.VRecyclerView;
import java.util.List;

class VSmartView$RvScrollListener
  extends RecyclerView.OnScrollListener
{
  private VSmartView$RvScrollListener(VSmartView paramVSmartView) {}
  
  private void scrollOtherRV(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < VSmartView.access$300(this.this$0).size())
    {
      VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = (VSmartView.RecyclerViewWrapper)VSmartView.access$300(this.this$0).get(i);
      if (localRecyclerViewWrapper.recyclerView != paramRecyclerView) {
        localRecyclerViewWrapper.recyclerView.scrollBy(paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (VSmartView.access$500(this.this$0) == null) {
      return;
    }
    Object localObject = paramRecyclerView.getTag();
    if (!(localObject instanceof VSmartView.RecyclerViewWrapper)) {
      return;
    }
    if (((VSmartView.RecyclerViewWrapper)localObject).ignoreScrollEvent) {
      return;
    }
    float f1;
    float f2;
    if (paramInt2 > 0)
    {
      f1 = VSmartView.access$600(this.this$0);
      f2 = VSmartView.access$500(this.this$0).getTranslationY();
      f1 = -f1;
      if (f2 > f1)
      {
        f2 = VSmartView.access$500(this.this$0).getTranslationY() + -paramInt2;
        if (f2 >= f1) {
          f1 = f2;
        }
        VSmartView.access$500(this.this$0).setTranslationY(f1);
        scrollOtherRV(paramRecyclerView, paramInt1, paramInt2);
      }
    }
    else
    {
      localObject = paramRecyclerView.findViewHolderForAdapterPosition(1);
      if (localObject == null) {
        return;
      }
      localObject = ((RecyclerView.ViewHolder)localObject).itemView;
      if ((localObject != null) && (((View)localObject).getTop() > VSmartView.access$500(this.this$0).getHeight() + VSmartView.access$500(this.this$0).getTranslationY()))
      {
        f2 = -paramInt2 + VSmartView.access$500(this.this$0).getTranslationY();
        f1 = f2;
        if (f2 > 0.0F) {
          f1 = 0.0F;
        }
        VSmartView.access$500(this.this$0).setTranslationY(f1);
        scrollOtherRV(paramRecyclerView, paramInt1, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView.RvScrollListener
 * JD-Core Version:    0.7.0.1
 */