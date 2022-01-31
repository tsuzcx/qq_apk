package com.tencent.viola.ui.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.List;

class VSmartView$RvScrollListener
  extends RecyclerView.OnScrollListener
{
  private VSmartView$RvScrollListener(VSmartView paramVSmartView) {}
  
  private void scrollOtherRV(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < VSmartView.access$200(this.this$0).size())
    {
      VSmartView.RecyclerViewWrapper localRecyclerViewWrapper = (VSmartView.RecyclerViewWrapper)VSmartView.access$200(this.this$0).get(i);
      if (localRecyclerViewWrapper.recyclerView == paramRecyclerView) {}
      for (;;)
      {
        i += 1;
        break;
        localRecyclerViewWrapper.recyclerView.scrollBy(paramInt1, paramInt2);
      }
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (VSmartView.access$300(this.this$0) == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          float f3;
          do
          {
            do
            {
              return;
              localObject = paramRecyclerView.getTag();
            } while ((!(localObject instanceof VSmartView.RecyclerViewWrapper)) || (((VSmartView.RecyclerViewWrapper)localObject).ignoreScrollEvent));
            if (paramInt2 <= 0) {
              break;
            }
            f3 = VSmartView.access$400(this.this$0);
          } while (VSmartView.access$300(this.this$0).getTranslationY() <= -f3);
          f2 = VSmartView.access$300(this.this$0).getTranslationY() + -paramInt2;
          f1 = f2;
          if (f2 < -f3) {
            f1 = -f3;
          }
          VSmartView.access$300(this.this$0).setTranslationY(f1);
          scrollOtherRV(paramRecyclerView, paramInt1, paramInt2);
          return;
        } while (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager));
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(1);
      } while (localObject == null);
      localObject = ((RecyclerView.ViewHolder)localObject).itemView;
    } while ((localObject == null) || (((View)localObject).getTop() <= VSmartView.access$300(this.this$0).getHeight() + VSmartView.access$300(this.this$0).getTranslationY()));
    float f2 = -paramInt2 + VSmartView.access$300(this.this$0).getTranslationY();
    float f1 = f2;
    if (f2 > 0.0F) {
      f1 = 0.0F;
    }
    VSmartView.access$300(this.this$0).setTranslationY(f1);
    scrollOtherRV(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSmartView.RvScrollListener
 * JD-Core Version:    0.7.0.1
 */