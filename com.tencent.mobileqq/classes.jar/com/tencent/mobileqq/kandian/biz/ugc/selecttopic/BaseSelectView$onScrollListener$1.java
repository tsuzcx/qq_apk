package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mobileqq.kandian.base.mvp.ListPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectView$onScrollListener$1", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseSelectView$onScrollListener$1
  implements AbsListView.OnScrollListener
{
  public void onScroll(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt)
  {
    int i = 1;
    if ((paramAbsListView != null) && (paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!BaseSelectView.a(this.a))) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      BaseSelectView.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.BaseSelectView.onScrollListener.1
 * JD-Core Version:    0.7.0.1
 */