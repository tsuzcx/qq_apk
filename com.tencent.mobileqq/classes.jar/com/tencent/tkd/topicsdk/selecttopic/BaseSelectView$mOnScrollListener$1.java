package com.tencent.tkd.topicsdk.selecttopic;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.tkd.topicsdk.mvp.ListPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/selecttopic/BaseSelectView$mOnScrollListener$1", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class BaseSelectView$mOnScrollListener$1
  implements AbsListView.OnScrollListener
{
  public void onScroll(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView != null) && (paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!BaseSelectView.a(this.a))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        BaseSelectView.a(this.a).b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selecttopic.BaseSelectView.mOnScrollListener.1
 * JD-Core Version:    0.7.0.1
 */