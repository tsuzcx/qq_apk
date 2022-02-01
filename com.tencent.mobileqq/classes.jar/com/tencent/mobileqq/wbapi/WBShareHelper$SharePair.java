package com.tencent.mobileqq.wbapi;

import android.app.Activity;
import com.sina.weibo.sdk.openapi.IWBAPI;
import mqq.util.WeakReference;

class WBShareHelper$SharePair
{
  WeakReference<Activity> a;
  WeakReference<IWBAPI> b;
  
  WBShareHelper$SharePair(Activity paramActivity, IWBAPI paramIWBAPI)
  {
    this.a = new WeakReference(paramActivity);
    this.b = new WeakReference(paramIWBAPI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBShareHelper.SharePair
 * JD-Core Version:    0.7.0.1
 */