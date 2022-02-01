package com.tencent.mobileqq.search.ftsentity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FTSEntitySearchActivity
  extends BaseSearchActivity
{
  static String a;
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    a = paramString;
    Intent localIntent = new Intent(paramContext, FTSEntitySearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("extra_key_fts_type", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment c()
  {
    return FTSEntitySearchFragment.b(a);
  }
  
  protected String d()
  {
    return FTSEntitySearchUtils.b(this, this.j);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent.q = true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */