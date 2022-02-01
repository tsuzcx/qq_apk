package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class ComponentAdapter$2
  implements VRefreshLayout.onRefreshStateChangeListener
{
  ComponentAdapter$2(ComponentAdapter paramComponentAdapter, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.b.getHeaderHeight();
    if ((paramInt <= i) && (!ComponentAdapter.a(this.c)))
    {
      this.a.a();
      RefreshAnimView localRefreshAnimView = this.a;
      double d1 = paramInt;
      double d2 = i;
      Double.isNaN(d1);
      Double.isNaN(d2);
      localRefreshAnimView.a(d1 / d2);
    }
  }
  
  public void onStateEnd()
  {
    ComponentAdapter.a(this.c, false);
    this.a.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    ComponentAdapter.a(this.c, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    ComponentAdapter.a(this.c, true);
    this.a.a();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter.2
 * JD-Core Version:    0.7.0.1
 */