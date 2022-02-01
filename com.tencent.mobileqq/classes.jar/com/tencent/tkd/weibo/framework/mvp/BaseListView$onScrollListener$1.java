package com.tencent.tkd.weibo.framework.mvp;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/weibo/framework/mvp/BaseListView$onScrollListener$1", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class BaseListView$onScrollListener$1
  implements AbsListView.OnScrollListener
{
  public void onScroll(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1)
    {
      Object localObject = this.a.a();
      if (localObject != null) {
        localObject = (Unit)((Function0)localObject).invoke();
      }
    }
    if ((paramAbsListView != null) && (paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!BaseListView.a(this.a))) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        BaseListView.a(this.a).b();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.BaseListView.onScrollListener.1
 * JD-Core Version:    0.7.0.1
 */