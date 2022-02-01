package com.tencent.mobileqq.vas.troopnick.shop.widget;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;

class ShopLayout$2
  extends RecyclerView.OnScrollListener
{
  ShopLayout$2(ShopLayout paramShopLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (ShopLayout.b(this.a) != null) {
      ShopLayout.b(this.a).a();
    }
    if (paramInt == 0)
    {
      paramRecyclerView = ShopLayout.c(this.a).getLayoutManager();
      int i = 0;
      if ((paramRecyclerView instanceof GridLayoutManager)) {
        i = ((GridLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
      if ((paramRecyclerView.getChildCount() > 0) && (i >= paramRecyclerView.getItemCount() - 1))
      {
        this.a.a(true);
        paramRecyclerView = new StringBuilder();
        paramRecyclerView.append(" load more shop data newState:");
        paramRecyclerView.append(paramInt);
        paramRecyclerView.append(" lastVisiblePosition:");
        paramRecyclerView.append(i);
        QLog.d("ShopLayout", 2, paramRecyclerView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.2
 * JD-Core Version:    0.7.0.1
 */