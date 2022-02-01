package com.tencent.qqlive.module.videoreport.page;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class ScrollReader
{
  private static final IScrollReader DEFAULT_READER = new ScrollReader.CommonViewScrollReader(null);
  private static final Set<View> INJECTED_VIEWS = Collections.newSetFromMap(new WeakHashMap());
  private static final Map<Class<?>, IScrollReader> SCROLL_READERS = new HashMap();
  
  static
  {
    SCROLL_READERS.put(RecyclerView.class, new ScrollReader.RecyclerViewScrollReader(null));
    SCROLL_READERS.put(AbsListView.class, new ScrollReader.AbsListViewScrollReader(null));
  }
  
  @NonNull
  static IScrollReader getScrollReader(View paramView)
  {
    Iterator localIterator = SCROLL_READERS.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Class)localEntry.getKey()).isInstance(paramView)) {
        return (IScrollReader)localEntry.getValue();
      }
    }
    return DEFAULT_READER;
  }
  
  private static void injectCommonViewScroll(View paramView, ScrollReader.OnScrollChangeListener paramOnScrollChangeListener)
  {
    paramView.getViewTreeObserver().addOnScrollChangedListener(new ScrollReader.2(paramOnScrollChangeListener));
  }
  
  private static void injectRecyclerViewScroll(RecyclerView paramRecyclerView, @NonNull ScrollReader.OnScrollChangeListener paramOnScrollChangeListener)
  {
    paramRecyclerView.addOnScrollListener(new ScrollReader.1(paramOnScrollChangeListener));
  }
  
  static void injectScrollListener(View paramView, ScrollReader.OnScrollChangeListener paramOnScrollChangeListener)
  {
    if ((paramView != null) && (paramOnScrollChangeListener != null))
    {
      if (INJECTED_VIEWS.contains(paramView)) {
        return;
      }
      INJECTED_VIEWS.add(paramView);
      if ((paramView instanceof RecyclerView))
      {
        injectRecyclerViewScroll((RecyclerView)paramView, paramOnScrollChangeListener);
        return;
      }
      injectCommonViewScroll(paramView, paramOnScrollChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.ScrollReader
 * JD-Core Version:    0.7.0.1
 */