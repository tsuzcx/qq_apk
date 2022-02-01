package com.tencent.mobileqq.kandian.biz.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimOldManager
  extends ReadInJoyAnimBaseManager
{
  public ReadInJoyAnimOldManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public int getPullRefreshAreaHeight()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298921);
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559642, paramViewGroup, false));
    }
    return (View)this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader;
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0L);
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
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIPullRefreshHeader.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimOldManager
 * JD-Core Version:    0.7.0.1
 */