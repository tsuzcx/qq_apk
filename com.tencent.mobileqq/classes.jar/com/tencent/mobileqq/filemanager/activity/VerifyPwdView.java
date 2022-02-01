package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class VerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private VerifyPwdView.VerifyPswEvent jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$VerifyPswEvent = null;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new VerifyPwdView.1(this);
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private View b;
  
  public VerifyPwdView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.a;
  }
  
  private void c()
  {
    this.b.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void d()
  {
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$VerifyPswEvent;
    if (localObject != null) {
      ((VerifyPwdView.VerifyPswEvent)localObject).a();
    }
    localObject = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("input_method");
    if (((InputMethodManager)localObject).isActive()) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public View a(ViewGroup paramViewGroup, VerifyPwdView.VerifyPswEvent paramVerifyPswEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$VerifyPswEvent = paramVerifyPswEvent;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("layout_inflater")).inflate(2131560845, null).findViewById(2131380417);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$VerifyPswEvent = null;
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131377188);
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131380420);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376345));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373300));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380418));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381104));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844446);
    } else {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844445);
    }
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    localObject = (IQQFileEngine)((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IQQFileEngine.class);
    if (((IQQFileEngine)localObject).hasQueriedVerifyPassword() == true)
    {
      ((IQQFileEngine)localObject).queryNeedVerifyPwd();
      return;
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      c();
      ((IQQFileEngine)localObject).queryNeedVerifyPwd();
      return;
    }
    FMToastUtil.a(2131698210);
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if ((str != null) && (!str.equals(""))) {
      ((IQQFileEngine)((BaseQQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getRuntimeService(IQQFileEngine.class)).verifyPwd(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView
 * JD-Core Version:    0.7.0.1
 */