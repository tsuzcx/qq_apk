package com.tencent.mobileqq.wink.pick.util;

import android.util.LruCache;
import android.view.View;

public final class WinkFastClickThrottle
{
  private static final LruCache<String, Long> a = new LruCache(10);
  
  public static boolean a(View paramView)
  {
    Object localObject = paramView.getTag(2131427883);
    long l = System.currentTimeMillis();
    paramView.setTag(2131427883, Long.valueOf(l));
    return ((localObject instanceof Long)) && (Math.abs(l - ((Long)localObject).longValue()) <= 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.util.WinkFastClickThrottle
 * JD-Core Version:    0.7.0.1
 */