package com.tencent.mobileqq.troop.recommend;

import android.widget.TextView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RecommendTroopListWrapper$1
  implements AbsListView.OnScrollListener
{
  RecommendTroopListWrapper$1(RecommendTroopListWrapper paramRecommendTroopListWrapper) {}
  
  private boolean a(AbsListView paramAbsListView)
  {
    return (paramAbsListView.getChildAt(paramAbsListView.getChildCount() - 1) == this.a.l) && (this.a.l.getBottom() == this.a.l.getBottom());
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (a(paramAbsListView))) {
      this.a.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.RecommendTroopListWrapper.1
 * JD-Core Version:    0.7.0.1
 */