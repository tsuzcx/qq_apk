package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

public class TroopBarPublishUtils$UserInvokeAction
{
  SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private String jdField_a_of_type_JavaLangString;
  
  public TroopBarPublishUtils$UserInvokeAction(Activity paramActivity, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("uin");
    if (this.jdField_a_of_type_JavaLangString != null) {}
    for (paramBundle = this.jdField_a_of_type_JavaLangString;; paramBundle = "0")
    {
      this.jdField_a_of_type_JavaLangString = paramBundle;
      this.jdField_a_of_type_AndroidContentSharedPreferences = paramActivity.getSharedPreferences("tribeInvokeFrom", 0);
      return;
    }
  }
  
  public Boolean a()
  {
    return Boolean.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_JavaLangString, false));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(this.jdField_a_of_type_JavaLangString, true);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.UserInvokeAction
 * JD-Core Version:    0.7.0.1
 */