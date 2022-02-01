package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Message;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ItemManager$ScrollManager
  implements AbsListView.OnScrollListener
{
  private ItemManager$ScrollManager(ItemManager paramItemManager) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.a.a.c();
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = this.a.g;
    int j = 0;
    if ((i == 2) && (paramInt != 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject = this.a.c.obtainMessage(1, this.a);
      this.a.c.removeMessages(1);
      if (this.a.i) {
        i = j;
      } else {
        i = 550;
      }
      this.a.c.sendMessageDelayed((Message)localObject, i);
      this.a.h = true;
    }
    else if (paramInt == 2)
    {
      localObject = this.a;
      ((ItemManager)localObject).h = false;
      ((ItemManager)localObject).c.removeMessages(1);
    }
    Object localObject = this.a;
    ((ItemManager)localObject).g = paramInt;
    localObject = ((ItemManager)localObject).a.c();
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager.ScrollManager
 * JD-Core Version:    0.7.0.1
 */