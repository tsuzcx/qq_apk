package com.tencent.tkd.topicsdk.widget;

import android.database.DataSetObserver;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/widget/HorizontalListView$mDataObserver$1", "Landroid/database/DataSetObserver;", "onChanged", "", "onInvalidated", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class HorizontalListView$mDataObserver$1
  extends DataSetObserver
{
  public void onChanged()
  {
    synchronized (this.a)
    {
      HorizontalListView.a(this.a, true);
      Unit localUnit = Unit.INSTANCE;
      this.a.invalidate();
      this.a.requestLayout();
      return;
    }
  }
  
  public void onInvalidated()
  {
    HorizontalListView.h(this.a);
    this.a.invalidate();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.HorizontalListView.mDataObserver.1
 * JD-Core Version:    0.7.0.1
 */