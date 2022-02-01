package com.tencent.mobileqq.database.corrupt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class DBFixConfigActivity$1
  implements RadioGroup.OnCheckedChangeListener
{
  DBFixConfigActivity$1(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime, String paramString) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131366078) {
      DBFixConfigActivity.a = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(DBFixManager.b, 0).edit().putInt(this.jdField_a_of_type_JavaLangString + DBFixManager.c, DBFixConfigActivity.a).commit();
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      if (paramInt == 2131365595) {
        DBFixConfigActivity.a = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.1
 * JD-Core Version:    0.7.0.1
 */