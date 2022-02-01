package com.tencent.qqlive.module.videoreport.report.scroll;

import android.view.View;
import com.tencent.qqlive.module.videoreport.page.PageSwitchObserver;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

class ScrollableViewObserver$PendingTask
  implements Runnable
{
  private Set<View> mNotifyViewList = Collections.newSetFromMap(new WeakHashMap());
  
  private void setNotifyView(View paramView)
  {
    this.mNotifyViewList.add(paramView);
  }
  
  public void run()
  {
    if (this.mNotifyViewList.isEmpty()) {
      return;
    }
    Iterator localIterator = this.mNotifyViewList.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      PageSwitchObserver.getInstance().onPageViewVisible(localView);
    }
    this.mNotifyViewList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.scroll.ScrollableViewObserver.PendingTask
 * JD-Core Version:    0.7.0.1
 */