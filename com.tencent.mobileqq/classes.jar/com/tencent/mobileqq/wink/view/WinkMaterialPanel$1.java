package com.tencent.mobileqq.wink.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;

class WinkMaterialPanel$1
  extends RecyclerView.OnScrollListener
{
  WinkMaterialPanel$1(WinkMaterialPanel paramWinkMaterialPanel) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      WinkMaterialPanel.a(this.a, false);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (!WinkMaterialPanel.a(this.a))
    {
      paramInt1 = WinkMaterialPanel.b(this.a).findFirstVisibleItemPosition();
      paramInt1 = MetaMaterialKt.a(WinkMaterialPanel.c(this.a), WinkMaterialPanel.d(this.a), paramInt1);
      WinkMaterialPanel.e(this.a).a(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.WinkMaterialPanel.1
 * JD-Core Version:    0.7.0.1
 */