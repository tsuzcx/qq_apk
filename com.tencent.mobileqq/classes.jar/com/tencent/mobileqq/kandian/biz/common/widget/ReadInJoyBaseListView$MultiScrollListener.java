package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyBaseListView$MultiScrollListener
  implements AbsListView.OnScrollListener
{
  List<AbsListView.OnScrollListener> a = new ArrayList();
  
  void a()
  {
    this.a.clear();
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (!this.a.contains(paramOnScrollListener)) {
      this.a.add(paramOnScrollListener);
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.a.remove(paramOnScrollListener);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)localIterator.next();
      try
      {
        localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyBaseListView", 2, "onScroll exp", localThrowable);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)localIterator.next();
      try
      {
        localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseListView", 2, "onScrollStateChanged exp", localThrowable);
      }
    }
    if (paramInt == 0) {
      VideoReport.traverseExposure();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.MultiScrollListener
 * JD-Core Version:    0.7.0.1
 */