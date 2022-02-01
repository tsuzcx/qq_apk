package com.tencent.mobileqq.comment;

import android.graphics.Paint;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class DanmuDataHolder
{
  private static DanmuDataHolder e;
  public Paint a = null;
  public int b = ViewUtils.dip2px(150.0F);
  private LruCache<String, DanmuDataHolder.CacheHolder> c;
  private DanmuDataServlet d = null;
  
  private DanmuDataHolder()
  {
    if (this.c == null) {
      this.c = new LruCache(10485760);
    }
    if (MobileQQ.sProcessId == 1)
    {
      if (this.d == null) {
        this.d = new DanmuDataServlet();
      }
      c();
    }
  }
  
  public static DanmuDataHolder a()
  {
    if (e == null) {
      e = new DanmuDataHolder();
    }
    return e;
  }
  
  public DanmuDataHolder.CacheHolder a(String paramString)
  {
    return (DanmuDataHolder.CacheHolder)this.c.get(paramString);
  }
  
  public String a(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramLong1));
    localStringBuilder.append(paramLong2);
    return localStringBuilder.toString();
  }
  
  public void a(DanmuDataContext paramDanmuDataContext, DanmuDataIPCClient.DanmuPullCallback paramDanmuPullCallback)
  {
    if ((paramDanmuDataContext.a != 0L) && (paramDanmuDataContext.b != 0L))
    {
      Object localObject = a().a(paramDanmuDataContext.b, paramDanmuDataContext.a);
      DanmuDataHolder.CacheHolder localCacheHolder = a().a((String)localObject);
      localObject = localCacheHolder;
      if (localCacheHolder == null)
      {
        localObject = new DanmuDataHolder.CacheHolder(this).a(paramDanmuDataContext).d(0).e(0).a(paramDanmuPullCallback).b();
        QLog.d("DanmuDataHolder", 2, "request start, reqHolder is null, create it");
      }
      this.d.a((DanmuDataHolder.CacheHolder)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DanmuDataHolder", 2, String.format("request, bad parameter, topicUin:%s, groupUin:%s", new Object[] { Long.valueOf(paramDanmuDataContext.a), Long.valueOf(paramDanmuDataContext.b) }));
    }
  }
  
  public void a(String paramString, DanmuDataHolder.CacheHolder paramCacheHolder)
  {
    this.c.put(paramString, paramCacheHolder);
  }
  
  public DanmuDataHolder.CacheHolder b(String paramString)
  {
    DanmuDataHolder.CacheHolder localCacheHolder = new DanmuDataHolder.CacheHolder(this);
    a(paramString, localCacheHolder);
    return localCacheHolder;
  }
  
  public void b()
  {
    this.c.evictAll();
  }
  
  public void c()
  {
    if (this.a == null) {
      this.a = ((TextView)LayoutInflater.from(MobileQQ.getContext()).inflate(2131629204, null).findViewById(2131431033)).getPaint();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.DanmuDataHolder
 * JD-Core Version:    0.7.0.1
 */