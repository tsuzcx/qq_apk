package com.tencent.mobileqq.kandian.biz.ad;

import com.tencent.mobileqq.kandian.biz.fastweb.event.ListAdExposeManager;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.Set;

final class RIJCommentAdUtils$1
  implements AbsListView.OnScrollListener
{
  RIJCommentAdUtils$1(ReadInJoyCommentListView paramReadInJoyCommentListView, ListAdExposeManager paramListAdExposeManager) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    ListAdExposeManager localListAdExposeManager = this.b;
    if (localListAdExposeManager != null) {
      localListAdExposeManager.a(paramAbsListView);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (!RIJCommentAdUtils.i().isEmpty())
    {
      paramInt = RIJCommentAdUtils.a(this.a);
      RIJCommentAdUtils.a(paramAbsListView.getFirstVisiblePosition() - paramInt, paramAbsListView.getLastVisiblePosition() - paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils.1
 * JD-Core Version:    0.7.0.1
 */