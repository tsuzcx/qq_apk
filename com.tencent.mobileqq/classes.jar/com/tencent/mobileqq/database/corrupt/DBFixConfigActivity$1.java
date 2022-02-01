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
    if (paramInt == 2131432266) {
      DBFixConfigActivity.f = 1;
    } else if (paramInt == 2131431642) {
      DBFixConfigActivity.f = 2;
    }
    SharedPreferences.Editor localEditor = this.a.getApplication().getSharedPreferences(DBFixManager.d, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(DBFixManager.e);
    localEditor.putInt(localStringBuilder.toString(), DBFixConfigActivity.f).commit();
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.1
 * JD-Core Version:    0.7.0.1
 */