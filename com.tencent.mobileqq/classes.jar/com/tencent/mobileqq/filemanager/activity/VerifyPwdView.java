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
import anza;
import anzb;
import aodp;
import aodw;
import aoii;
import apcb;
import badq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class VerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anzb jdField_a_of_type_Anzb;
  private aodp jdField_a_of_type_Aodp = new anza(this);
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
    if (this.jdField_a_of_type_Anzb != null) {
      this.jdField_a_of_type_Anzb.a();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public View a(ViewGroup paramViewGroup, anzb paramanzb)
  {
    this.jdField_a_of_type_Anzb = paramanzb;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("layout_inflater")).inflate(2131494937, null).findViewById(2131313021);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aodp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aodp);
      this.jdField_a_of_type_Anzb = null;
    }
  }
  
  public void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131310067);
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131313024);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131309309));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131306473));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131313022));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313589));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843473);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() != true) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843472);
    }
    if (badq.d(BaseApplicationImpl.getContext()))
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      return;
    }
    apcb.a(BaseApplicationImpl.getContext().getString(2131628946));
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if ((paramView == null) || (paramView.equals(""))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView
 * JD-Core Version:    0.7.0.1
 */