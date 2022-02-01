package com.tencent.mobileqq.onlinestatus.auto.location;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.util.List;

public class PoiCache
{
  private LRULinkedHashMap<PoiCache.PoiKey, PoiCache.PoiItem> a;
  private int b;
  private final String c;
  
  private void a(String paramString, PoiCache.PoiItem paramPoiItem)
  {
    if (QLog.isColorLevel())
    {
      if ((paramPoiItem != null) && (paramPoiItem.b != null) && (paramPoiItem.b.size() != 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][poiCache][");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("] from: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result: ");
        ((StringBuilder)localObject).append(paramPoiItem.b);
        ((StringBuilder)localObject).append(" size: ");
        ((StringBuilder)localObject).append(paramPoiItem.b.size());
        QLog.d("PoiCache", 2, ((StringBuilder)localObject).toString());
        localObject = (Poi)paramPoiItem.b.get(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[status][poiCache][");
        localStringBuilder.append(this.c);
        localStringBuilder.append("] from: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" first poi: ");
        localStringBuilder.append(((Poi)localObject).title);
        localStringBuilder.append("-");
        localStringBuilder.append(((Poi)localObject).category);
        localStringBuilder.append("-");
        localStringBuilder.append(((Poi)localObject)._distance);
        QLog.d("PoiCache", 2, localStringBuilder.toString());
        if (paramPoiItem.b.size() >= 2)
        {
          localObject = (Poi)paramPoiItem.b.get(1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[status][poiCache][");
          localStringBuilder.append(this.c);
          localStringBuilder.append("] from: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" second poi: ");
          localStringBuilder.append(((Poi)localObject).title);
          localStringBuilder.append("-");
          localStringBuilder.append(((Poi)localObject).category);
          localStringBuilder.append("-");
          localStringBuilder.append(((Poi)localObject)._distance);
          QLog.d("PoiCache", 2, localStringBuilder.toString());
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[status][poiCache][");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("] from: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" result: ");
        ((StringBuilder)localObject).append(paramPoiItem.b);
        ((StringBuilder)localObject).append(" adInfoCity: ");
        ((StringBuilder)localObject).append(paramPoiItem.c.city);
        ((StringBuilder)localObject).append(" adInfoDistrict: ");
        ((StringBuilder)localObject).append(paramPoiItem.c.district);
        QLog.d("PoiCache", 2, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[status][poiCache][");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] from: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result: ");
      if ((paramPoiItem != null) && (paramPoiItem.b != null)) {
        paramString = "0";
      } else {
        paramString = "null";
      }
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PoiCache", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(PoiCache.PoiItem paramPoiItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiCache][");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] put poiItem: ");
      localStringBuilder.append(paramPoiItem);
      QLog.d("PoiCache", 2, localStringBuilder.toString());
    }
    a("putPoiList", paramPoiItem);
    this.a.put(new PoiCache.PoiKey(this, paramPoiItem.a), paramPoiItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.PoiCache
 * JD-Core Version:    0.7.0.1
 */