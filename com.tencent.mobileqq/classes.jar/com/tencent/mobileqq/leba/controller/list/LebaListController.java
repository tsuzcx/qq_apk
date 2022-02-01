package com.tencent.mobileqq.leba.controller.list;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.controller.ILebaController;
import com.tencent.mobileqq.leba.entity.InitViewParam;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaListController
  implements ILebaController
{
  private View jdField_a_of_type_AndroidViewView;
  private LebaListViewAdapter jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter;
  private LebaItemListener jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener;
  private LebaRedTouchBase jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase = new LebaListController.LebaListRedTouch(null);
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131369913);
    localView.setBackgroundResource(2130850682);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)localView.findViewById(2131376845);
    localRoundRelativeLayout.a = ViewUtils.b(16.0F);
    localRoundRelativeLayout.setVisibility(8);
    localView.findViewById(2131366333).setBackgroundResource(2130850694);
    paramView.findViewById(2131378254).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131366904)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131375397);
    ViewUtils.a(paramView, null);
    paramView.setBackgroundResource(2130839393);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = ViewUtils.a(56.0F);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RoundRelativeLayout)paramView.findViewById(2131376843);
    ((RoundRelativeLayout)localObject).a = ViewUtils.b(16.0F);
    ((RoundRelativeLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369990);
    ((ImageView)localObject).setImageResource(2130845487);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ViewUtils.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376650);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = ViewUtils.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362976)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (ViewUtils.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131369991)).getLayoutParams()).leftMargin = ViewUtils.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131375609)).getLayoutParams()).leftMargin = ViewUtils.a(14.0F);
  }
  
  private void c(View paramView)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131374379);
    ViewUtils.a(paramView, null);
    paramView.setBackgroundResource(2130839393);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject).height = ViewUtils.a(56.0F);
    localObject = (RoundRelativeLayout)paramView.findViewById(2131376843);
    ((RoundRelativeLayout)localObject).a = ViewUtils.b(16.0F);
    ((RoundRelativeLayout)localObject).setVisibility(8);
    localObject = (ImageView)paramView.findViewById(2131369990);
    ((ImageView)localObject).setImageResource(2130845491);
    localObject = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).height = ViewUtils.b(24.0F);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.a(20.0F);
    localObject = (RelativeLayout)paramView.findViewById(2131376650);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams()).width = ViewUtils.a(28.0F);
    localObject = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject).findViewById(2131362976)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ViewUtils.a(7.0F);
    ((RelativeLayout.LayoutParams)localObject).height = (ViewUtils.a(23.0F) / 2);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374384)).getLayoutParams()).leftMargin = ViewUtils.a(16.0F);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131374386)).getLayoutParams()).leftMargin = ViewUtils.a(14.0F);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    LebaListViewAdapter localLebaListViewAdapter = this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter;
    if (localLebaListViewAdapter != null) {
      localLebaListViewAdapter.b();
    }
  }
  
  public void a(InitViewParam paramInitViewParam)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    AppRuntime localAppRuntime = paramInitViewParam.jdField_a_of_type_MqqAppAppRuntime;
    List localList = paramInitViewParam.jdField_a_of_type_JavaUtilList;
    Context localContext = paramInitViewParam.jdField_a_of_type_AndroidContentContext;
    FPSXListView localFPSXListView = paramInitViewParam.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
    View localView = paramInitViewParam.jdField_a_of_type_AndroidViewView;
    LebaItemListener localLebaItemListener = paramInitViewParam.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener;
    this.jdField_a_of_type_AndroidViewView = paramInitViewParam.jdField_a_of_type_AndroidViewView;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localLebaItemListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaItemListener = localLebaItemListener;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130850581));
      }
    }
    catch (Exception paramInitViewParam)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramInitViewParam);
    }
    if (localView != null) {
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        a(localView);
        b(localView);
        c(localView);
      }
      catch (Exception paramInitViewParam)
      {
        QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramInitViewParam);
      }
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter = new LebaListViewAdapter(localContext, localList, 2131559061, 2131559062, localAppRuntime, localFPSXListView, new LebaListController.1(this));
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter.a();
        localFPSXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter);
      }
    }
    catch (Exception paramInitViewParam)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramInitViewParam);
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter.a(localAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter.a(localList);
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter;
    if (localObject != null) {
      ((LebaListViewAdapter)localObject).a(paramInt1, paramBoolean, paramInt2);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaRedtouchLebaRedTouchBase;
    if (localObject != null) {
      ((LebaRedTouchBase)localObject).a(paramAppRuntime);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      a((View)localObject);
      b(this.jdField_a_of_type_AndroidViewView);
      c(this.jdField_a_of_type_AndroidViewView);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter;
    if (localObject != null) {
      ((LebaListViewAdapter)localObject).c();
    }
  }
  
  public void c()
  {
    LebaListViewAdapter localLebaListViewAdapter = this.jdField_a_of_type_ComTencentMobileqqLebaControllerListLebaListViewAdapter;
    if (localLebaListViewAdapter != null) {
      localLebaListViewAdapter.notifyDataSetChanged();
    }
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListController
 * JD-Core Version:    0.7.0.1
 */