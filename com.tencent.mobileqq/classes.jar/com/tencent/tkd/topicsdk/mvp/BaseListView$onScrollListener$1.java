package com.tencent.tkd.topicsdk.mvp;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mvp/BaseListView$onScrollListener$1", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class BaseListView$onScrollListener$1
  implements AbsListView.OnScrollListener
{
  BaseListView$onScrollListener$1(Context paramContext) {}
  
  public void onScroll(@Nullable AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(@Nullable AbsListView paramAbsListView, int paramInt)
  {
    int j = 0;
    if ((paramInt == 1) && (BaseListView.c(this.a)))
    {
      Object localObject = this.b.getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      }
    }
    int i = j;
    if (paramAbsListView != null)
    {
      i = j;
      if (paramInt == 0)
      {
        i = j;
        if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
        {
          i = j;
          if (!BaseListView.d(this.a)) {
            i = 1;
          }
        }
      }
    }
    if (i != 0) {
      BaseListView.b(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.BaseListView.onScrollListener.1
 * JD-Core Version:    0.7.0.1
 */