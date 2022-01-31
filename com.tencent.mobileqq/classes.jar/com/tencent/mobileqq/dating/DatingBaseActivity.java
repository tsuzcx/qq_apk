package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.os.Bundle;
import beps;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final boolean a;
  protected int a;
  protected beps a;
  public boolean b;
  public boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.c;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getTitleBarHeight();
    this.jdField_a_of_type_Beps = new beps(this);
    this.b = getIntent().getBooleanExtra("abp_flag", false);
    this.c = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.c) && (!this.b)) {
      setLeftViewName(2131690382);
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Beps != null) {
      this.jdField_a_of_type_Beps.b();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.b) {
      overridePendingTransition(2130771988, 2130771989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */