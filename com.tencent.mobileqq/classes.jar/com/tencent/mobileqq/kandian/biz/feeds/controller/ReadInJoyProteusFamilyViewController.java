package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.List;

public class ReadInJoyProteusFamilyViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  
  public ReadInJoyProteusFamilyViewController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      this.b = ((ViewGroup)localObject).findViewById(2131373730);
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    d();
  }
  
  public void a(boolean paramBoolean, List<AbsBaseArticleInfo> paramList)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      aw_();
      this.jdField_a_of_type_Boolean = true;
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup != null)
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localObject = new ViewGroup.LayoutParams(-1, -1);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup);
        }
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup, (ViewGroup.LayoutParams)localObject);
      }
      ((ReadInJoyProteusFamilyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a(true, paramList);
    }
  }
  
  public void aw_()
  {
    super.aw_();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup = new ReadInJoyProteusFamilyListViewGroup(this, 0, 0, 0, null, 2131560288);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = ((ReadInJoyProteusFamilyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void e()
  {
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.b();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyProteusFamilyViewController
 * JD-Core Version:    0.7.0.1
 */