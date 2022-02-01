package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final boolean a;
  protected int a;
  protected QQProgressNotifier a;
  public boolean b = false;
  public boolean c = false;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.d;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getTitleBarHeight();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.b = getIntent().getBooleanExtra("abp_flag", false);
    this.c = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.c) && (!this.b)) {
      setLeftViewName(2131690529);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QQProgressNotifier localQQProgressNotifier = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
    if (localQQProgressNotifier != null) {
      localQQProgressNotifier.b();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.b) {
      overridePendingTransition(2130772002, 2130772003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */