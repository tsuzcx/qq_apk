package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class TeamWorkCreateActionSheetBuilder
  implements View.OnClickListener
{
  protected Context a;
  protected View a;
  protected TeamWorkCreateActionSheetBuilder.OnCreateItemClickListener a;
  protected final ActionSheet a;
  
  public TeamWorkCreateActionSheetBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(paramContext, null));
  }
  
  protected View a()
  {
    View localView1 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131560949, null);
    View localView2 = localView1.findViewById(2131365465);
    View localView3 = localView1.findViewById(2131365454);
    View localView4 = localView1.findViewById(2131365452);
    localView2.setOnClickListener(this);
    localView3.setOnClickListener(this);
    localView4.setOnClickListener(this);
    return localView1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = a();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_a_of_type_AndroidViewView, null);
    try
    {
      if (!a()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TeamWorkCreateActionSheetBuilder", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  public void a(TeamWorkCreateActionSheetBuilder.OnCreateItemClickListener paramOnCreateItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsTeamWorkCreateActionSheetBuilder$OnCreateItemClickListener = paramOnCreateItemClickListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing();
  }
  
  public void b()
  {
    if (a()) {}
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_AndroidViewView = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.w("TeamWorkCreateActionSheetBuilder", 2, "Exception while dismiss", localRuntimeException);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i = j;
    switch (paramView.getId())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsTeamWorkCreateActionSheetBuilder$OnCreateItemClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsTeamWorkCreateActionSheetBuilder$OnCreateItemClickListener.a(i);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TeamWorkCreateActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */