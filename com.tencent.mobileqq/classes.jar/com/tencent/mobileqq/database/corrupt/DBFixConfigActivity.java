package com.tencent.mobileqq.database.corrupt;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixConfigActivity
  extends AppActivity
{
  public static int a = 2;
  public static String a = "DBFix";
  Button jdField_a_of_type_AndroidWidgetButton;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  Runnable jdField_a_of_type_JavaLangRunnable = new DBFixConfigActivity.7(this);
  Button jdField_b_of_type_AndroidWidgetButton;
  CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559328);
    paramBundle = getAppRuntime();
    String str = paramBundle.getAccount();
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)super.findViewById(2131364613));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new DBFixConfigActivity.1(this, paramBundle, str));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131365995));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131365438));
    SharedPreferences localSharedPreferences = paramBundle.getApplication().getSharedPreferences(DBFixManager.b, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(DBFixManager.c);
    jdField_a_of_type_Int = localSharedPreferences.getInt(localStringBuilder.toString(), 2);
    if (jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(false);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(true);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(false);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131381202));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new DBFixConfigActivity.2(this));
    ((Button)super.findViewById(2131365251)).setOnClickListener(new DBFixConfigActivity.3(this, str));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)super.findViewById(2131370500));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new DBFixConfigActivity.4(this, paramBundle));
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)super.findViewById(2131364230));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(true);
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new DBFixConfigActivity.5(this, paramBundle));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131373053));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new DBFixConfigActivity.6(this));
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity
 * JD-Core Version:    0.7.0.1
 */