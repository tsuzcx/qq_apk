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
import atjj;
import atjk;
import atpa;
import atqx;
import atur;
import auna;
import bhnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atjk jdField_a_of_type_Atjk;
  private atpa jdField_a_of_type_Atpa = new atjj(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private View b;
  
  public VerifyPwdView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app;
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
    if (this.jdField_a_of_type_Atjk != null) {
      this.jdField_a_of_type_Atjk.a();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public View a(ViewGroup paramViewGroup, atjk paramatjk)
  {
    this.jdField_a_of_type_Atjk = paramatjk;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("layout_inflater")).inflate(2131560939, null).findViewById(2131380651);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Atpa != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Atpa);
      this.jdField_a_of_type_Atjk = null;
    }
  }
  
  public void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377315);
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131380654);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376445));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373240));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380652));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381354));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844398);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != true) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844397);
    }
    if (bhnv.d(BaseApplicationImpl.getContext()))
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      return;
    }
    auna.a(BaseApplicationImpl.getContext().getString(2131693963));
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if ((str == null) || (str.equals(""))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView
 * JD-Core Version:    0.7.0.1
 */