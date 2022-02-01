package com.tencent.mobileqq.search.activity;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import anzj;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tyi;

public class PublicAcntSearchActivity
  extends BaseSearchActivity
{
  static int d = -1;
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    d = paramInt;
    Intent localIntent = new Intent(paramContext, PublicAcntSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return PublicAcntSearchFragment.a(d);
  }
  
  protected String a()
  {
    if (d == 12) {
      return anzj.a(2131707620) + tyi.a(this.app, getApplicationContext());
    }
    return anzj.a(2131707678);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.PublicAcntSearchActivity
 * JD-Core Version:    0.7.0.1
 */