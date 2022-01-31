package com.tencent.mobileqq.database.corrupt;

import akry;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import ankh;
import anki;
import ankj;
import ankk;
import ankl;
import ankm;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixConfigActivity
  extends AppActivity
{
  public static int a;
  public static String a;
  Button jdField_a_of_type_AndroidWidgetButton;
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
    this.jdField_a_of_type_JavaLangRunnable = new DBFixConfigActivity.7(this);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559207);
    paramBundle = getAppRuntime();
    String str = paramBundle.getAccount();
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)super.findViewById(2131364192));
    this.jdField_a_of_type_AndroidWidgetRadioGroup.setOnCheckedChangeListener(new ankh(this, paramBundle, str));
    this.jdField_a_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131365419));
    this.jdField_b_of_type_AndroidWidgetRadioButton = ((RadioButton)super.findViewById(2131364935));
    jdField_a_of_type_Int = paramBundle.getApplication().getSharedPreferences(DBFixManager.b, 0).getInt(str + DBFixManager.c, 2);
    if (jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(false);
      this.jdField_b_of_type_AndroidWidgetRadioButton.setChecked(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131379514));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new anki(this));
      ((Button)super.findViewById(2131364773)).setOnClickListener(new ankj(this, str));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)super.findViewById(2131369604));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(akry.a);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new ankk(this, paramBundle));
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)super.findViewById(2131363811));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(akry.b);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(new ankl(this, paramBundle));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131371929));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ankm(this, paramBundle));
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