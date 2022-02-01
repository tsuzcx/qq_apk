package com.tencent.mobileqq.kandian.biz.pts.realtime;

import android.content.Context;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.glue.pts.RealTimeController;

public class RealTimeTemplateFactoryCache
  extends QQHashMap<String, RealTimeTemplateFactory>
{
  public RealTimeTemplateFactoryCache()
  {
    super(2018, 10, 230000);
  }
  
  public void clear()
  {
    try
    {
      super.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void clearMemory()
  {
    if (!ReadInJoyHelper.r()) {
      clear();
    }
  }
  
  public RealTimeTemplateFactory get(String paramString)
  {
    try
    {
      paramString = (RealTimeTemplateFactory)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public RealTimeTemplateFactory getAutoCreate(Context paramContext, String paramString)
  {
    paramContext = get(paramString);
    if (paramContext != null) {
      return paramContext;
    }
    paramContext = RealTimeController.a(paramString);
    if (paramContext != null)
    {
      paramContext.b(paramString);
      put(paramString, paramContext);
      return paramContext;
    }
    return null;
  }
  
  public RealTimeTemplateFactory put(String paramString, RealTimeTemplateFactory paramRealTimeTemplateFactory)
  {
    try
    {
      paramString = (RealTimeTemplateFactory)super.put(paramString, paramRealTimeTemplateFactory);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public RealTimeTemplateFactory remove(String paramString)
  {
    try
    {
      paramString = (RealTimeTemplateFactory)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */