package com.tencent.mobileqq.kandian.biz.daily;

import android.view.View;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import java.util.Iterator;
import java.util.List;

class ReadInJoyDailyXListView$3
  implements ReadInJoyOverScrollViewListener
{
  ReadInJoyDailyXListView$3(ReadInJoyDailyXListView paramReadInJoyDailyXListView) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).onNotCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    this.a.onNotCompleteVisable(paramInt1, paramView, paramListView, paramInt2);
  }
  
  public void onScrollView(View paramView, ListView paramListView, int paramInt)
  {
    this.a.onScrollView(paramView, paramListView, paramInt);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).onViewCompleteVisable(paramInt, paramView, paramListView);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    boolean bool = false;
    while (localIterator.hasNext()) {
      if (((OverScrollViewListener)localIterator.next()).onViewCompleteVisableAndReleased(paramInt, paramView, paramListView)) {
        bool = true;
      }
    }
    return bool;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((OverScrollViewListener)localIterator.next()).onViewNotCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyXListView.3
 * JD-Core Version:    0.7.0.1
 */