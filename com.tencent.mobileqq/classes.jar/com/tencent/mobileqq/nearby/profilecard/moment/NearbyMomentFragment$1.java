package com.tencent.mobileqq.nearby.profilecard.moment;

import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

class NearbyMomentFragment$1
  implements AbsListView.OnScrollListener
{
  NearbyMomentFragment$1(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      int j = NearbyMomentFragment.a(this.a).getLastVisiblePosition();
      int k = NearbyMomentFragment.a(this.a).getCount();
      int i = 0;
      paramInt = i;
      if (j == k - 1)
      {
        paramAbsListView = NearbyMomentFragment.a(this.a).getChildAt(NearbyMomentFragment.a(this.a).getLastVisiblePosition() - NearbyMomentFragment.a(this.a).getFirstVisiblePosition());
        paramInt = i;
        if (NearbyMomentFragment.a(this.a).getHeight() >= paramAbsListView.getBottom()) {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        NearbyMomentFragment.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.1
 * JD-Core Version:    0.7.0.1
 */