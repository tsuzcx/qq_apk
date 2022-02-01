package com.tencent.widget;

import android.view.View;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;

class AbsListView$RecycleBin
{
  private View[] mActiveViews = new View[0];
  private ArrayList<View> mCurrentScrap;
  private int mFirstActivePosition;
  private AbsListView.RecyclerListener mRecyclerListener;
  private ArrayList<View>[] mScrapViews;
  private int mViewTypeCount;
  
  AbsListView$RecycleBin(AbsListView paramAbsListView) {}
  
  private void pruneScrapViews()
  {
    int m = this.mActiveViews.length;
    int n = this.mViewTypeCount;
    ArrayList[] arrayOfArrayList = this.mScrapViews;
    int i = 0;
    while (i < n)
    {
      ArrayList localArrayList = arrayOfArrayList[i];
      int i1 = localArrayList.size();
      int j = i1 - 1;
      int k = 0;
      while (k < i1 - m)
      {
        AbsListView.access$3600(this.this$0, (View)localArrayList.remove(j), false);
        k += 1;
        j -= 1;
      }
      i += 1;
    }
  }
  
  void addScrapView(View paramView, int paramInt)
  {
    Object localObject = (AbsListView.LayoutParams)paramView.getLayoutParams();
    if (localObject == null) {
      return;
    }
    int i = ((AbsListView.LayoutParams)localObject).viewType;
    if (!shouldRecycleViewType(i))
    {
      if (i != -2) {
        AbsListView.access$3300(this.this$0, paramView, false);
      }
      return;
    }
    ((AbsListView.LayoutParams)localObject).scrappedFromPosition = paramInt;
    if (this.mViewTypeCount == 1)
    {
      AbsListView.access$3400(this.this$0, paramView);
      this.mCurrentScrap.add(paramView);
    }
    else
    {
      AbsListView.access$3400(this.this$0, paramView);
      localObject = this.mScrapViews;
      if (i < localObject.length) {
        localObject[i].add(paramView);
      }
    }
    localObject = this.mRecyclerListener;
    if (localObject != null) {
      ((AbsListView.RecyclerListener)localObject).onMovedToScrapHeap(paramView);
    }
  }
  
  void clear()
  {
    int k = this.mViewTypeCount;
    ArrayList localArrayList;
    int j;
    if (k == 1)
    {
      localArrayList = this.mCurrentScrap;
      j = localArrayList.size();
      i = 0;
      while (i < j)
      {
        AbsListView.access$3100(this.this$0, (View)localArrayList.remove(j - 1 - i), false);
        i += 1;
      }
    }
    int i = 0;
    while (i < k)
    {
      localArrayList = this.mScrapViews[i];
      int m = localArrayList.size();
      j = 0;
      while (j < m)
      {
        AbsListView.access$3200(this.this$0, (View)localArrayList.remove(m - 1 - j), false);
        j += 1;
      }
      i += 1;
    }
  }
  
  void fillActiveViews(int paramInt1, int paramInt2)
  {
    if (this.mActiveViews.length < paramInt1) {
      this.mActiveViews = new View[paramInt1];
    }
    this.mFirstActivePosition = paramInt2;
    View[] arrayOfView = this.mActiveViews;
    paramInt2 = 0;
    while (paramInt2 < paramInt1)
    {
      View localView = this.this$0.getChildAt(paramInt2);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (localLayoutParams.viewType != -2)) {
        arrayOfView[paramInt2] = localView;
      }
      paramInt2 += 1;
    }
  }
  
  View getActiveView(int paramInt)
  {
    paramInt -= this.mFirstActivePosition;
    View[] arrayOfView = this.mActiveViews;
    if ((paramInt >= 0) && (paramInt < arrayOfView.length))
    {
      View localView = arrayOfView[paramInt];
      arrayOfView[paramInt] = null;
      return localView;
    }
    return null;
  }
  
  View getScrapView(int paramInt)
  {
    if (this.mViewTypeCount == 1) {
      return AbsListView.retrieveFromScrap(this.mCurrentScrap, paramInt);
    }
    int i = this.this$0.mAdapter.getItemViewType(paramInt);
    if (i >= 0)
    {
      ArrayList[] arrayOfArrayList = this.mScrapViews;
      if ((arrayOfArrayList != null) && (i < arrayOfArrayList.length)) {
        return AbsListView.retrieveFromScrap(arrayOfArrayList[i], paramInt);
      }
    }
    return null;
  }
  
  public void markChildrenDirty()
  {
    int k = this.mViewTypeCount;
    int i = 0;
    ArrayList localArrayList;
    int j;
    if (k == 1)
    {
      localArrayList = this.mCurrentScrap;
      j = localArrayList.size();
      while (i < j)
      {
        ((View)localArrayList.get(i)).forceLayout();
        i += 1;
      }
    }
    i = 0;
    while (i < k)
    {
      localArrayList = this.mScrapViews[i];
      int m = localArrayList.size();
      j = 0;
      while (j < m)
      {
        ((View)localArrayList.get(j)).forceLayout();
        j += 1;
      }
      i += 1;
    }
  }
  
  void reclaimScrapViews(List<View> paramList)
  {
    int j = this.mViewTypeCount;
    if (j == 1)
    {
      paramList.addAll(this.mCurrentScrap);
      return;
    }
    ArrayList[] arrayOfArrayList = this.mScrapViews;
    int i = 0;
    while (i < j)
    {
      paramList.addAll(arrayOfArrayList[i]);
      i += 1;
    }
  }
  
  void scrapActiveViews()
  {
    View[] arrayOfView = this.mActiveViews;
    int i;
    if (this.mRecyclerListener != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.mViewTypeCount > 1) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject1 = this.mCurrentScrap;
    int k = arrayOfView.length - 1;
    while (k >= 0)
    {
      View localView = arrayOfView[k];
      Object localObject2 = localObject1;
      if (localView != null)
      {
        localObject2 = (AbsListView.LayoutParams)localView.getLayoutParams();
        int m = ((AbsListView.LayoutParams)localObject2).viewType;
        arrayOfView[k] = null;
        if (!shouldRecycleViewType(m))
        {
          localObject2 = localObject1;
          if (m != -2)
          {
            AbsListView.access$3500(this.this$0, localView, false);
            localObject2 = localObject1;
          }
        }
        else
        {
          if (j != 0) {
            localObject1 = this.mScrapViews[m];
          }
          AbsListView.access$3400(this.this$0, localView);
          ((AbsListView.LayoutParams)localObject2).scrappedFromPosition = (this.mFirstActivePosition + k);
          ((ArrayList)localObject1).add(localView);
          localObject2 = localObject1;
          if (i != 0)
          {
            this.mRecyclerListener.onMovedToScrapHeap(localView);
            localObject2 = localObject1;
          }
        }
      }
      k -= 1;
      localObject1 = localObject2;
    }
    pruneScrapViews();
  }
  
  void setCacheColorHint(int paramInt)
  {
    int m = this.mViewTypeCount;
    int k = 0;
    if (m == 1)
    {
      localObject1 = this.mCurrentScrap;
      j = ((ArrayList)localObject1).size();
      i = 0;
      while (i < j)
      {
        ((View)((ArrayList)localObject1).get(i)).setDrawingCacheBackgroundColor(paramInt);
        i += 1;
      }
    }
    int i = 0;
    while (i < m)
    {
      localObject1 = this.mScrapViews[i];
      int n = ((ArrayList)localObject1).size();
      j = 0;
      while (j < n)
      {
        ((View)((ArrayList)localObject1).get(j)).setDrawingCacheBackgroundColor(paramInt);
        j += 1;
      }
      i += 1;
    }
    Object localObject1 = this.mActiveViews;
    int j = localObject1.length;
    i = k;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setDrawingCacheBackgroundColor(paramInt);
      }
      i += 1;
    }
  }
  
  public void setViewTypeCount(int paramInt)
  {
    if (paramInt >= 1)
    {
      localObject = new ArrayList[paramInt];
      int i = 0;
      while (i < paramInt)
      {
        localObject[i] = new ArrayList();
        i += 1;
      }
      this.mViewTypeCount = paramInt;
      this.mCurrentScrap = localObject[0];
      this.mScrapViews = ((ArrayList[])localObject);
      return;
    }
    Object localObject = new IllegalArgumentException("Can't have a viewTypeCount < 1");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public boolean shouldRecycleViewType(int paramInt)
  {
    return paramInt >= 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.RecycleBin
 * JD-Core Version:    0.7.0.1
 */