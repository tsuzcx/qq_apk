package com.tencent.mobileqq.kandian.biz.pts.realtime;

import android.support.v4.util.ArrayMap;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RealTimeTemplateFactory
  extends TemplateFactory
{
  private static RealTimeTemplateFactoryCache b = new RealTimeTemplateFactoryCache();
  private Map<String, RealTimeTemplateFactory.Item> a = new ConcurrentHashMap();
  
  public RealTimeTemplateFactory()
  {
    this.nameTemplateMap = new ConcurrentHashMap();
  }
  
  public static RealTimeTemplateFactory b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return b.getAutoCreate(BaseApplicationImpl.getContext(), paramString);
    }
    return b.get(paramString);
  }
  
  public static void h()
  {
    QLog.d("RealTimeTemplateFactory", 2, "reset: ");
    b.clear();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return;
      }
      paramString2 = new RealTimeTemplateFactory.Item(paramString1, paramString2, paramString3);
      this.a.put(paramString1, paramString2);
    }
  }
  
  public boolean a(TemplateBean paramTemplateBean)
  {
    boolean bool = true;
    if (paramTemplateBean == null) {
      return true;
    }
    if (paramTemplateBean.getId() == getTemplateId())
    {
      if (!a().equals(paramTemplateBean.getStyleSource())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void d(String paramString)
  {
    paramString = (RealTimeTemplateFactory.Item)this.a.remove(paramString);
    if (paramString != null)
    {
      paramString = (TemplateBean)this.nameTemplateMap.remove(paramString.c);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteStyle: ");
      localStringBuilder.append(paramString);
      QLog.d("RealTimeTemplateFactory", 1, localStringBuilder.toString());
    }
  }
  
  public Map<String, String> g()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeTemplateFactory.Item localItem = (RealTimeTemplateFactory.Item)localIterator.next();
      localHashMap.put(localItem.a, localItem.b);
    }
    return localHashMap;
  }
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(this.nameTemplateMap);
    return localArrayMap;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = (TemplateBean)this.nameTemplateMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactory
 * JD-Core Version:    0.7.0.1
 */