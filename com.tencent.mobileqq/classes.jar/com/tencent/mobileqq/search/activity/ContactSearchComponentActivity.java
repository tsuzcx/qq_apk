package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ContactSearchComponentActivity
  extends ContactSearchActivity
{
  private static long a;
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramString, paramInt1, paramInt2, paramInt3, -1L);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - a < 1500L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
      }
      return;
    }
    a = l;
    Intent localIntent = new Intent(paramActivity, ContactSearchComponentActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    if (paramLong > 0L) {
      localIntent.putExtra("contactSearchResultFilterType", paramLong);
    }
    paramActivity.startActivityForResult(localIntent, paramInt3);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (l - a < 1500L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
      }
      return;
    }
    a = l;
    Intent localIntent = new Intent(paramActivity, ContactSearchComponentActivity.class);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("specifiedTroopUin", paramString2);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, paramInt3);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  protected BaseSearchFragment c()
  {
    int i = getIntent().getIntExtra("fromType", -1);
    int j = getIntent().getIntExtra("contactSearchSource", 33751869);
    String str = getIntent().getStringExtra("specifiedTroopUin");
    ArrayList localArrayList = new ArrayList();
    if ((i != 7) && (i != 6) && (i != 23)) {
      return super.c();
    }
    localArrayList.add(AppConstants.BABY_Q_UIN);
    return ContactSearchFragment.a(i, j, str, localArrayList, null, false, 0, getIntent().getLongExtra("contactSearchResultFilterType", -1L));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.g.setVisibility(8);
    findViewById(2131445417).setOnTouchListener(new ContactSearchComponentActivity.1(this));
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchComponentActivity
 * JD-Core Version:    0.7.0.1
 */