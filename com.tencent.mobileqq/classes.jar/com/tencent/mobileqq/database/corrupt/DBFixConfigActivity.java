package com.tencent.mobileqq.database.corrupt;

import abvl;
import abvm;
import abvn;
import abvo;
import abvp;
import abvq;
import abvr;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixConfigActivity
  extends AppActivity
{
  public static int a;
  public static String a;
  public Button a;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  RadioButton jdField_a_of_type_AndroidWidgetRadioButton;
  RadioGroup jdField_a_of_type_AndroidWidgetRadioGroup;
  public Runnable a;
  Button jdField_b_of_type_AndroidWidgetButton;
  CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  RadioButton jdField_b_of_type_AndroidWidgetRadioButton;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DBFix";
    jdField_a_of_type_Int = 2;
  }
  
  public DBFixConfigActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new abvr(this);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969066);
    paramBundle = getAppRuntime();
    String str = paramBundle.getAccount();
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)super.findViewById(2131363939));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new abvl(this, paramBundle, str));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131364965));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131364966));
    jdField_a_of_type_Int = paramBundle.getApplication().getSharedPreferences(DBFixManager.b, 0).getInt(str + DBFixManager.c, 2);
    if (jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(false);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364967));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new abvm(this));
      ((Button)super.findViewById(2131364968)).setOnClickListener(new abvn(this, str));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)super.findViewById(2131364970));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(CacheConstants.a);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new abvo(this, paramBundle));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)super.findViewById(2131364971));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(CacheConstants.b);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new abvp(this, paramBundle));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364972));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new abvq(this, paramBundle));
      return true;
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(true);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity
 * JD-Core Version:    0.7.0.1
 */