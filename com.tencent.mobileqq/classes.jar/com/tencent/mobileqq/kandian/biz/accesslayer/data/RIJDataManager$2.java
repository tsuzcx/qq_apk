package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RIJDataManager$2
  implements AbsListView.OnScrollListener
{
  RIJDataManager$2(RIJDataManager paramRIJDataManager) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {}
    }
    else
    {
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.a.a().v();
      this.a.a().h().a(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
      this.a.a().h().b(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
      this.a.a().h().c(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
      this.a.a().h().d(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localReadInJoyBaseAdapter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.2
 * JD-Core Version:    0.7.0.1
 */