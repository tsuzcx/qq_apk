package com.tencent.mobileqq.vip.diy.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

@Deprecated
@PluginInterface
public class DIYLottieLoader
  extends LottieLoader
{
  private static final String TAG = "DIYLottieLoader";
  private MQLruCache<String, Object> mMemoryCache;
  
  public DIYLottieLoader(Context paramContext)
  {
    super(paramContext);
  }
  
  public void destroy()
  {
    super.destroy();
    Object localObject1 = this.mMemoryCache;
    if (localObject1 != null)
    {
      localObject1 = ((MQLruCache)localObject1).getLargeCache().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        Object localObject2 = this.mMemoryCache.get(str);
        if ((localObject2 != null) && ((localObject2 instanceof Bitmap)))
        {
          ((Bitmap)localObject2).recycle();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recycle bitmap key = ");
          ((StringBuilder)localObject2).append(str);
          QLog.i("DIYLottieLoader", 4, ((StringBuilder)localObject2).toString());
        }
      }
      this.mMemoryCache.releaseLargeCache();
    }
  }
  
  protected MQLruCache<String, Object> getMemoryCache()
  {
    return this.mMemoryCache;
  }
  
  public void setMemoryCacheSize(int paramInt)
  {
    this.mMemoryCache = new DIYLottieLoader.1(this, paramInt);
    this.mMemoryCache.setLargeSize(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.common.DIYLottieLoader
 * JD-Core Version:    0.7.0.1
 */