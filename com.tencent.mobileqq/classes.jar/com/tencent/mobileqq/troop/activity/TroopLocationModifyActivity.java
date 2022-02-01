package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class TroopLocationModifyActivity
  extends TroopCreateMapViewSupportActivity
{
  long g = 0L;
  Dialog h;
  Boolean i = Boolean.valueOf(true);
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString.split("\\|");
    if (localObject.length >= 4) {
      localObject = localObject[3];
    } else {
      localObject = "";
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("location", (String)localObject);
    localIntent.putExtra("locationOriginal", paramString);
    setResult(-1, localIntent);
    finish();
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
        break label231;
      }
      int j = paramIntent.getIntExtra("errCode", -1);
      boolean bool = paramIntent.getBooleanExtra("isClear", false);
      String str = paramIntent.getStringExtra("location");
      int k = paramIntent.getIntExtra("lat", 0);
      int m = paramIntent.getIntExtra("lon", 0);
      if (j == 0)
      {
        if (bool) {
          QQToast.makeText(this, 2131917677, 0).show(getTitleBarHeight());
        } else {
          QQToast.makeText(this, 2131917682, 0).show(getTitleBarHeight());
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("location", str);
        localIntent.putExtra("lat", k);
        localIntent.putExtra("lon", m);
        setResult(-1, localIntent);
        finish();
      }
      else
      {
        if (j == 1002) {
          str = getString(2131917689);
        } else if (bool) {
          str = getString(2131917676);
        } else {
          str = getString(2131917681);
        }
        QQToast.makeText(this, str, 0).show(getTitleBarHeight());
        a();
      }
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    return;
    label231:
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    String str = paramBundle.getString("troopUin");
    this.i = Boolean.valueOf(paramBundle.getBoolean("saveDirect", true));
    this.g = Long.parseLong(str);
    paramBundle = findViewById(2131444897);
    if ((paramBundle instanceof NavBarCommon))
    {
      paramBundle = (NavBarCommon)paramBundle;
      paramBundle.setRightButton(getString(2131917410));
      paramBundle.setOnItemSelectListener(new TroopLocationModifyActivity.1(this));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void e()
  {
    f();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.setMainTitle(2131917678);
    localActionSheet.addButton(2131917679, 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnDismissListener(new TroopLocationModifyActivity.2(this));
    localActionSheet.setOnButtonClickListener(new TroopLocationModifyActivity.3(this));
    this.h = localActionSheet;
    this.h.show();
  }
  
  protected void f()
  {
    Dialog localDialog = this.h;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.h.dismiss();
      }
      this.h = null;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity
 * JD-Core Version:    0.7.0.1
 */