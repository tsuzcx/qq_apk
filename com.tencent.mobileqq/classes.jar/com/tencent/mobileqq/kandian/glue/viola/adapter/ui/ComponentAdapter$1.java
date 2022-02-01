package com.tencent.mobileqq.kandian.glue.viola.adapter.ui;

import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class ComponentAdapter$1
  implements VRefreshLayout.onRefreshStateChangeListener
{
  ComponentAdapter$1(ComponentAdapter paramComponentAdapter, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!ComponentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterUiComponentAdapter)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a();
      RefreshAnimView localRefreshAnimView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView;
      double d1 = paramInt;
      double d2 = i;
      Double.isNaN(d1);
      Double.isNaN(d2);
      localRefreshAnimView.a(d1 / d2);
    }
  }
  
  public void onStateEnd()
  {
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterUiComponentAdapter, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterUiComponentAdapter, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    ComponentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterUiComponentAdapter, true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter.1
 * JD-Core Version:    0.7.0.1
 */