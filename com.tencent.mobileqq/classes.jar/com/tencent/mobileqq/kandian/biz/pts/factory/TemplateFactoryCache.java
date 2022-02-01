package com.tencent.mobileqq.kandian.biz.pts.factory;

import android.content.Context;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.Config;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.TemplateFactoryWrapper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TemplateFactoryCache
  extends QQHashMap<String, StyleConfigHelper.TemplateFactoryWrapper>
{
  private volatile StyleConfigHelper mStyleConfigHelper = new StyleConfigHelper();
  
  public TemplateFactoryCache()
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
  
  public StyleConfigHelper.TemplateFactoryWrapper get(String paramString)
  {
    try
    {
      paramString = (StyleConfigHelper.TemplateFactoryWrapper)super.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public TemplateFactory getAutoCreate(Context paramContext, String paramString)
  {
    try
    {
      StyleConfigHelper.TemplateFactoryWrapper localTemplateFactoryWrapper = get(paramString);
      if ((localTemplateFactoryWrapper != null) && (localTemplateFactoryWrapper.a != null))
      {
        paramContext = OfflineUtils.a(this.mStyleConfigHelper.a(paramContext, paramString).a());
        if ((paramContext != null) && (localTemplateFactoryWrapper.a.a().equals(paramContext.a())))
        {
          int i = localTemplateFactoryWrapper.a.getTemplateId();
          int j = paramContext.getTemplateId();
          if (i != j) {
            return paramContext;
          }
        }
        paramContext = localTemplateFactoryWrapper.a;
        return paramContext;
      }
      paramContext = this.mStyleConfigHelper.a(paramContext, paramString);
      if ((paramContext != null) && (paramContext.a != null))
      {
        paramContext.a.b(paramString);
        put(paramString, paramContext);
        paramContext = paramContext.a;
        return paramContext;
      }
      return null;
    }
    finally {}
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper put(String paramString, StyleConfigHelper.TemplateFactoryWrapper paramTemplateFactoryWrapper)
  {
    try
    {
      paramString = (StyleConfigHelper.TemplateFactoryWrapper)super.put(paramString, paramTemplateFactoryWrapper);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper remove(String paramString)
  {
    try
    {
      paramString = (StyleConfigHelper.TemplateFactoryWrapper)super.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void reset()
  {
    Object localObject1 = this.mStyleConfigHelper;
    StyleConfigHelper localStyleConfigHelper = new StyleConfigHelper();
    Object localObject2 = ((StyleConfigHelper)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (!((StyleConfigHelper.Config)localEntry.getValue()).equals(localStyleConfigHelper.a((String)localEntry.getKey()))) {
        ((List)localObject1).add(localEntry.getKey());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      remove((String)((Iterator)localObject1).next());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reset: ");
    ((StringBuilder)localObject1).append(localStyleConfigHelper);
    QLog.d("TemplateFactory", 2, ((StringBuilder)localObject1).toString());
    this.mStyleConfigHelper = localStyleConfigHelper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactoryCache
 * JD-Core Version:    0.7.0.1
 */