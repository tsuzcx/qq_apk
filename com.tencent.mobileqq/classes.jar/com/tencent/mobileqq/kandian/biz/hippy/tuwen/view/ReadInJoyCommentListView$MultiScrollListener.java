package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyCommentListView$MultiScrollListener
  implements AbsListView.OnScrollListener
{
  private List<AbsListView.OnScrollListener> mListeners = new ArrayList();
  
  public void addScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    List localList = this.mListeners;
    if ((localList != null) && (!localList.contains(paramOnScrollListener))) {
      this.mListeners.add(paramOnScrollListener);
    }
  }
  
  public void clear()
  {
    List localList = this.mListeners;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.mListeners;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = this.mListeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)((Iterator)localObject).next();
        if (localOnScrollListener != null) {
          localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject = this.mListeners;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return;
      }
      localObject = this.mListeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsListView.OnScrollListener localOnScrollListener = (AbsListView.OnScrollListener)((Iterator)localObject).next();
        if (localOnScrollListener != null) {
          localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
        }
      }
    }
  }
  
  public void removeScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    List localList = this.mListeners;
    if (localList != null) {
      localList.remove(paramOnScrollListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView.MultiScrollListener
 * JD-Core Version:    0.7.0.1
 */