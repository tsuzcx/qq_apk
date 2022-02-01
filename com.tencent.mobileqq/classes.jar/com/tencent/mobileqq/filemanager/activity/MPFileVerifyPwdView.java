package com.tencent.mobileqq.filemanager.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import anvu;
import atiq;
import atir;
import atis;
import atit;
import auna;
import bhnv;
import bmkd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Timer;

public class MPFileVerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atit jdField_a_of_type_Atit;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Timer jdField_a_of_type_JavaUtilTimer = new Timer();
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public MPFileVerifyPwdView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, atit paramatit)
  {
    this.jdField_a_of_type_Atit = paramatit;
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560941, null).findViewById(2131380651);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Atit = null;
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  @TargetApi(11)
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380654);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373240));
    this.jdField_a_of_type_AndroidWidgetTextView.setLongClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.addTextChangedListener(new atiq(this));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextIsSelectable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCustomSelectionActionModeCallback(new atir(this));
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131380652));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371323));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131693806);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new atis(this));
    if (!bhnv.d(BaseApplicationImpl.getContext())) {
      auna.a(BaseApplicationImpl.getContext().getString(2131693963));
    }
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new MPFileVerifyPwdView.4(this));
  }
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    if ((str == null) || (str.equals(""))) {
      auna.a(BaseApplicationImpl.getContext().getString(2131693825));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
      if (str.length() < 6)
      {
        auna.a(BaseApplicationImpl.getContext().getString(2131693826));
      }
      else if (!bhnv.d(BaseApplicationImpl.getContext()))
      {
        auna.a(BaseApplicationImpl.getContext().getString(2131693963));
      }
      else
      {
        anvu localanvu = (anvu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
        localanvu.a().a(str);
        this.jdField_a_of_type_Long = localanvu.a().a(2);
        if (this.jdField_a_of_type_Atit != null) {
          this.jdField_a_of_type_Atit.a(this.jdField_a_of_type_Long);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView
 * JD-Core Version:    0.7.0.1
 */