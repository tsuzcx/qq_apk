package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.widget.QQProgressNotifier;

public class DatingBaseActivity
  extends NearbyTitleBarActivity
{
  public static final boolean a = AppSetting.e;
  protected QQProgressNotifier b;
  protected int c;
  public boolean d = false;
  public boolean e = false;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.c = getTitleBarHeight();
    this.b = new QQProgressNotifier(this);
    this.d = getIntent().getBooleanExtra("abp_flag", false);
    this.e = getIntent().getBooleanExtra("is_from_web", false);
    if ((this.e) && (!this.d)) {
      setLeftViewName(2131887440);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QQProgressNotifier localQQProgressNotifier = this.b;
    if (localQQProgressNotifier != null) {
      localQQProgressNotifier.b();
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.d) {
      overridePendingTransition(2130772005, 2130772006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingBaseActivity
 * JD-Core Version:    0.7.0.1
 */