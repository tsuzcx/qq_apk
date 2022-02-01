package com.tencent.mobileqq.conditionsearch;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class SearchResultActivity$2
  implements OverScrollViewListener
{
  SearchResultActivity$2(SearchResultActivity paramSearchResultActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).c(SearchResultActivity.a(this.a));
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).b(SearchResultActivity.a(this.a));
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).a(SearchResultActivity.a(this.a));
    if (NetworkUtil.d(this.a)) {
      SearchResultActivity.c(this.a);
    }
    for (;;)
    {
      SearchResultActivity.a(this.a, System.currentTimeMillis());
      return true;
      SearchResultActivity.a(this.a).a(1);
      paramView = Message.obtain();
      paramView.what = 3;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity.2
 * JD-Core Version:    0.7.0.1
 */