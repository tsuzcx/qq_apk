package com.tencent.mobileqq.vip.diy.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.LottieLoader;
import java.util.ArrayList;
import java.util.Iterator;

public class DIYLottieLoader
  extends LottieLoader
{
  private static final String TAG = "DIYProfileTemplate.DIYLottieLoader";
  private MQLruCache<String, Object> mMemoryCache;
  
  public DIYLottieLoader(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public void destroy()
  {
    super.destroy();
    if (this.mMemoryCache != null)
    {
      Iterator localIterator = this.mMemoryCache.getLargeCache().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.mMemoryCache.get(str);
        if ((localObject != null) && ((localObject instanceof Bitmap)))
        {
          ((Bitmap)localObject).recycle();
          QZLog.i("DIYProfileTemplate.DIYLottieLoader", 4, "recycle bitmap key = " + str);
        }
      }
      this.mMemoryCache.releaseLargeCache();
    }
  }
  
  public MQLruCache<String, Object> getMemoryCache()
  {
    return this.mMemoryCache;
  }
  
  public void setMemoryCacheSize(int paramInt)
  {
    this.mMemoryCache = new DIYLottieLoader.1(this, paramInt);
    this.mMemoryCache.setLargeSize(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYLottieLoader
 * JD-Core Version:    0.7.0.1
 */