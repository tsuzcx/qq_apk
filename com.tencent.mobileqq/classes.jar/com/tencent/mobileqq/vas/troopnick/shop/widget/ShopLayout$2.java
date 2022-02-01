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
    if (ShopLayout.a(this.a) != null) {
      ShopLayout.a(this.a).a();
    }
    if (paramInt == 0)
    {
      paramRecyclerView = ShopLayout.a(this.a).getLayoutManager();
      int i = 0;
      if ((paramRecyclerView instanceof GridLayoutManager)) {
        i = ((GridLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
      if ((paramRecyclerView.getChildCount() > 0) && (i >= paramRecyclerView.getItemCount() - 1))
      {
        this.a.a(true);
        QLog.d("ShopLayout", 2, " load more shop data newState:" + paramInt + " lastVisiblePosition:" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.2
 * JD-Core Version:    0.7.0.1
 */