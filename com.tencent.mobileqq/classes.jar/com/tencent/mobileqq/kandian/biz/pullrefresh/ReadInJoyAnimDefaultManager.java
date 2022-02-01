package com.tencent.mobileqq.kandian.biz.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimDefaultManager
  extends ReadInJoyAnimBaseManager
{
  private RefreshAnimView a;
  
  public ReadInJoyAnimDefaultManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public void endOfRefresh()
  {
    super.endOfRefresh();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a(1000L);
  }
  
  public int getPullRefreshAreaHeight()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298852);
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562705, paramViewGroup, false);
      paramViewGroup.findViewById(2131376344).getLayoutParams().width = -2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = ((IPullRefreshHeader)paramViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader).findViewById(2131376336));
    }
    return (View)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.b();
  }
  
  public void onPullRefreshing(int paramInt, boolean paramBoolean)
  {
    super.onPullRefreshing(paramInt, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.f();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.c(0L);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a();
    RefreshAnimView localRefreshAnimView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView;
    double d = paramInt;
    Double.isNaN(d);
    localRefreshAnimView.a(d / 100.0D);
  }
  
  public void showPullRefresh()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.f();
  }
  
  public void showRefreshResult(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimDefaultManager
 * JD-Core Version:    0.7.0.1
 */