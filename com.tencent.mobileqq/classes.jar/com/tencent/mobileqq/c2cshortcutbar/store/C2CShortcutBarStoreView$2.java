package com.tencent.mobileqq.c2cshortcutbar.store;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class C2CShortcutBarStoreView$2
  extends RecyclerView.OnScrollListener
{
  C2CShortcutBarStoreView$2(C2CShortcutBarStoreView paramC2CShortcutBarStoreView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0) {
      C2CShortcutBarStoreView.a(this.a, paramRecyclerView);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (C2CShortcutBarStoreView.a(this.a))
    {
      C2CShortcutBarStoreView.a(this.a, false);
      C2CShortcutBarStoreView.a(this.a, paramRecyclerView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.store.C2CShortcutBarStoreView.2
 * JD-Core Version:    0.7.0.1
 */