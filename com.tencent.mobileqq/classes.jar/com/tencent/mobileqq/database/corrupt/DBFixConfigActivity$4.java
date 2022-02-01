package com.tencent.mobileqq.database.corrupt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.CacheConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class DBFixConfigActivity$4
  implements CompoundButton.OnCheckedChangeListener
{
  DBFixConfigActivity$4(DBFixConfigActivity paramDBFixConfigActivity, AppRuntime paramAppRuntime) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(CacheConstants.a, 0).edit().putBoolean(CacheConstants.b, paramBoolean).commit();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixConfigActivity.getApplicationContext(), HardCodeUtil.a(2131702902), 1).a();
    if ((this.jdField_a_of_type_MqqAppAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).exit(false);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.4
 * JD-Core Version:    0.7.0.1
 */