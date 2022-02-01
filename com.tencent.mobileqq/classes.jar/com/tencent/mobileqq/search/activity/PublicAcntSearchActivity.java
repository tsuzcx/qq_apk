package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublicAcntSearchActivity
  extends BaseSearchActivity
{
  static int a = -1;
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    a = paramInt;
    Intent localIntent = new Intent(paramContext, PublicAcntSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment c()
  {
    return PublicAcntSearchFragment.a(a);
  }
  
  protected String d()
  {
    if (a == 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131906513));
      localStringBuilder.append(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((AppInterface)getAppRuntime(), getApplicationContext()));
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131906566);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.PublicAcntSearchActivity
 * JD-Core Version:    0.7.0.1
 */