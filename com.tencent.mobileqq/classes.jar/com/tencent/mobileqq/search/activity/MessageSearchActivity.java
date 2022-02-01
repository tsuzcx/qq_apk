package com.tencent.mobileqq.search.activity;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import anzj;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.MessageSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MessageSearchActivity
  extends BaseSearchActivity
{
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MessageSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return new MessageSearchFragment();
  }
  
  protected String a()
  {
    return anzj.a(2131705552);
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
 * Qualified Name:     com.tencent.mobileqq.search.activity.MessageSearchActivity
 * JD-Core Version:    0.7.0.1
 */