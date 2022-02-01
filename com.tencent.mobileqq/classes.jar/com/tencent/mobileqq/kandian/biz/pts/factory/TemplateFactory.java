package com.tencent.mobileqq.kandian.biz.pts.factory;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateWithHotReloadFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig;
import com.tencent.mobileqq.kandian.biz.pts.realtime.RealTimeTemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils.ConfigData;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.Config;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper.TemplateFactoryWrapper;
import com.tencent.mobileqq.kandian.repo.pts.ITemplateFactoryConst;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@IgnoreDenyDependencyToSelf
public class TemplateFactory
  extends TemplateWithHotReloadFactory
  implements ITemplateFactoryConst
{
  private static TemplateFactoryCache jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactoryCache = new TemplateFactoryCache();
  private DynamicChannelConfig jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsBasicDynamicChannelConfig;
  private StyleConfigHelper jdField_a_of_type_ComTencentMobileqqKandianGluePtsStyleConfigHelper = new StyleConfigHelper();
  private String jdField_a_of_type_JavaLangString = "-1";
  private String b;
  
  public static TemplateFactory a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RealTimeTemplateFactory.a(paramString, true);
      return jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactoryCache.getAutoCreate(BaseApplicationImpl.getContext(), paramString);
    }
    paramString = jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactoryCache.get(paramString);
    if (paramString != null) {
      return paramString.a;
    }
    return null;
  }
  
  public static void a()
  {
    QLog.d("TemplateFactory", 1, "reset: ");
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactoryCache.reset();
  }
  
  private void b()
  {
    Iterator localIterator = this.nameTemplateMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TemplateBean localTemplateBean = (TemplateBean)((Map.Entry)localIterator.next()).getValue();
      localTemplateBean.setId(this.templateId.get());
      localTemplateBean.setStyleSource(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public static void c(String paramString)
  {
    StyleConfigHelper.TemplateFactoryWrapper localTemplateFactoryWrapper = StyleConfigHelper.a().a(BaseApplicationImpl.getContext(), paramString);
    localTemplateFactoryWrapper.a.b(paramString);
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsFactoryTemplateFactoryCache.put(paramString, localTemplateFactoryWrapper);
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsBasicDynamicChannelConfig;
    if (localObject != null)
    {
      localObject = ((DynamicChannelConfig)localObject).a("column_count");
      if (localObject != null) {
        try
        {
          i = Integer.valueOf((String)localObject).intValue();
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("TemplateFactory", 2, new Object[] { "getColumnCount e = ", localNumberFormatException, ", s = ", localObject });
        }
      }
    }
    int i = 1;
    QLog.d("TemplateFactory", 2, new Object[] { "getColumnCount = ", Integer.valueOf(i) });
    if (i > 0) {
      return i;
    }
    return 1;
  }
  
  public DynamicChannelConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsBasicDynamicChannelConfig;
  }
  
  public TemplateFactory a()
  {
    TemplateFactory localTemplateFactory = new TemplateFactory();
    localTemplateFactory.templateId = new AtomicInteger(getTemplateId());
    localTemplateFactory.a(this.jdField_a_of_type_JavaLangString);
    localTemplateFactory.b(this.b);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.nameTemplateMap);
    localTemplateFactory.nameTemplateMap = localHashMap;
    return localTemplateFactory;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.templateId.set(paramInt);
    b();
  }
  
  public void a(OfflineUtils.ConfigData paramConfigData)
  {
    if (paramConfigData == null)
    {
      QLog.d("TemplateFactory", 2, "updateProteusConfig, configData is null.");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsBasicDynamicChannelConfig = paramConfigData.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsBasicDynamicChannelConfig;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    b();
  }
  
  public boolean a(TemplateBean paramTemplateBean)
  {
    boolean bool = true;
    if (paramTemplateBean == null) {
      return true;
    }
    RealTimeTemplateFactory localRealTimeTemplateFactory = RealTimeTemplateFactory.a(this.b, false);
    if ((localRealTimeTemplateFactory != null) && (localRealTimeTemplateFactory.getTemplate(paramTemplateBean.getStyleName()) != null)) {
      return localRealTimeTemplateFactory.a(paramTemplateBean);
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
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public Map<String, TemplateBean> getNameTemplateMap()
  {
    Map localMap = super.getNameTemplateMap();
    RealTimeTemplateFactory localRealTimeTemplateFactory = RealTimeTemplateFactory.a(this.b, false);
    if (localRealTimeTemplateFactory != null) {
      localMap.putAll(localRealTimeTemplateFactory.getNameTemplateMap());
    }
    return localMap;
  }
  
  public TemplateBean getTemplate(String paramString)
  {
    Object localObject1 = RealTimeTemplateFactory.a(this.b, false);
    if (localObject1 != null)
    {
      localObject1 = ((RealTimeTemplateFactory)localObject1).getTemplate(paramString);
      if (localObject1 != null) {
        return localObject1;
      }
    }
    TemplateBean localTemplateBean = super.getTemplate(paramString);
    localObject1 = localTemplateBean;
    if (localTemplateBean == null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGluePtsStyleConfigHelper.a(this.b);
      localObject1 = localTemplateBean;
      if (((StyleConfigHelper.Config)localObject2).d != null)
      {
        localObject2 = a(((StyleConfigHelper.Config)localObject2).d, true);
        localObject1 = localTemplateBean;
        if (localObject2 != null) {
          localObject1 = ((TemplateFactory)localObject2).getTemplate(paramString);
        }
      }
    }
    if (localObject1 == null) {
      ProteusReportUtil.a(this.jdField_a_of_type_JavaLangString, this.b, paramString);
    }
    return localObject1;
  }
  
  public boolean isUsable()
  {
    return getTemplateId() > 0;
  }
  
  protected void onAddTemplate(String paramString, TemplateBean paramTemplateBean)
  {
    paramTemplateBean.setStyleSource(this.jdField_a_of_type_JavaLangString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("serviceId: ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" bid: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = getNameTemplateMap().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append((String)localEntry.getKey());
      localStringBuilder2.append(" : ");
      localStringBuilder2.append(localEntry.getValue());
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory
 * JD-Core Version:    0.7.0.1
 */