package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopLocationModifyActivity
  extends TroopCreateMapViewSupportActivity
{
  long jdField_a_of_type_Long = 0L;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  Dialog b;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("saveDirect", false);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  protected void b(String paramString)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return;
    }
    a(getString(2131720064));
    Intent localIntent = new Intent(this, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 5);
    localIntent.putExtra("troop_location", paramString);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_Long);
    startActivityForResult(localIntent, 41);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 41)
    {
      if ((paramIntent == null) || (paramInt2 != -1)) {
        break label227;
      }
      int i = paramIntent.getIntExtra("errCode", -1);
      boolean bool = paramIntent.getBooleanExtra("isClear", false);
      String str = paramIntent.getStringExtra("location");
      int j = paramIntent.getIntExtra("lat", 0);
      int k = paramIntent.getIntExtra("lon", 0);
      if (i == 0)
      {
        if (bool) {
          QQToast.a(this, 2131720056, 0).b(getTitleBarHeight());
        } else {
          QQToast.a(this, 2131720061, 0).b(getTitleBarHeight());
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("location", str);
        localIntent.putExtra("lat", j);
        localIntent.putExtra("lon", k);
        setResult(-1, localIntent);
        finish();
      }
      else
      {
        if (i == 1002) {
          str = getString(2131720068);
        } else if (bool) {
          str = getString(2131720055);
        } else {
          str = getString(2131720060);
        }
        QQToast.a(this, str, 0).b(getTitleBarHeight());
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    return;
    label227:
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    String str = paramBundle.getString("troopUin");
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBundle.getBoolean("saveDirect", true));
    this.jdField_a_of_type_Long = Long.parseLong(str);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  protected void e()
  {
    Dialog localDialog = this.b;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.b.dismiss();
      }
      this.b = null;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity
 * JD-Core Version:    0.7.0.1
 */