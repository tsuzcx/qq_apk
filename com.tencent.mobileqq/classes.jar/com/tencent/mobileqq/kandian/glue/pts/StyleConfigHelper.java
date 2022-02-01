package com.tencent.mobileqq.kandian.glue.pts;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.loaders.StyleLoaderHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotification;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StyleConfigHelper
{
  private static StyleConfigHelper jdField_a_of_type_ComTencentMobileqqKandianGluePtsStyleConfigHelper = new StyleConfigHelper();
  private final Map<String, StyleConfigHelper.Config> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public StyleConfigHelper()
  {
    c();
  }
  
  public static StyleConfigHelper a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianGluePtsStyleConfigHelper;
  }
  
  public static String a(String paramString)
  {
    return (String)RIJSPUtils.a(b(paramString), "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    RIJSPUtils.a(b(paramString1), paramString2);
  }
  
  private static StyleConfigHelper.Config b(String paramString)
  {
    StyleConfigHelper.Config localConfig = new StyleConfigHelper.Config(paramString);
    localConfig.a("default_feeds");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("proteus/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    localConfig.c = localStringBuilder.toString();
    paramString = a(paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.endsWith(""))
      {
        localConfig.c = paramString;
        return localConfig;
      }
      localConfig.b = paramString;
    }
    return localConfig;
  }
  
  private static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandian_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void b(String paramString)
  {
    StyleConfigHelper.Config localConfig = b(paramString);
    QLog.d("StyleConfigHelper", 2, new Object[] { "checkStyleUpdate, serviceId = ", paramString, ", config.bid = ", localConfig.b, ", config.localPath = ", localConfig.c });
    new StyleLoaderHelper(localConfig.b, localConfig.c).a();
  }
  
  private void c()
  {
    Object localObject = new StyleConfigHelper.Config("default_feeds");
    ((StyleConfigHelper.Config)localObject).b = RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("proteus/");
    localStringBuilder.append(((StyleConfigHelper.Config)localObject).a);
    localStringBuilder.append("");
    ((StyleConfigHelper.Config)localObject).c = localStringBuilder.toString();
    a((StyleConfigHelper.Config)localObject);
    localObject = new StyleConfigHelper.Config("comment_feeds");
    ((StyleConfigHelper.Config)localObject).b = RIJProteusOfflineBidSp.a("comment_proteus_offline_bid");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("proteus/");
    localStringBuilder.append(((StyleConfigHelper.Config)localObject).a);
    ((StyleConfigHelper.Config)localObject).c = localStringBuilder.toString();
    a((StyleConfigHelper.Config)localObject);
    localObject = new StyleConfigHelper.Config("native_article");
    ((StyleConfigHelper.Config)localObject).a("default_feeds");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("proteus/");
    localStringBuilder.append(((StyleConfigHelper.Config)localObject).a);
    localStringBuilder.append("");
    ((StyleConfigHelper.Config)localObject).c = localStringBuilder.toString();
    ((StyleConfigHelper.Config)localObject).b = RIJProteusOfflineBidSp.a("native_proteus_offline_bid");
    a((StyleConfigHelper.Config)localObject);
    d();
    localObject = new StyleConfigHelper.Config("daily_dynamic_header");
    ((StyleConfigHelper.Config)localObject).b = RIJProteusOfflineBidSp.a("daily_header_proteus_bid");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("proteus/");
    localStringBuilder.append(((StyleConfigHelper.Config)localObject).a);
    localStringBuilder.append("");
    ((StyleConfigHelper.Config)localObject).c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[init]: dailyDynamicHeader.bid=");
    localStringBuilder.append(((StyleConfigHelper.Config)localObject).b);
    QLog.i("StyleConfigHelper", 1, localStringBuilder.toString());
    a((StyleConfigHelper.Config)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init: ");
    ((StringBuilder)localObject).append(this);
    QLog.d("TemplateFactory", 2, ((StringBuilder)localObject).toString());
  }
  
  private void d() {}
  
  public StyleConfigHelper.Config a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (StyleConfigHelper.Config)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    StyleConfigHelper.Config localConfig = b(paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, localConfig);
    return localConfig;
  }
  
  public StyleConfigHelper.TemplateFactoryWrapper a(Context paramContext, String paramString)
  {
    StyleConfigHelper.Config localConfig = a(paramString);
    StyleLoaderHelper localStyleLoaderHelper = new StyleLoaderHelper(localConfig.b, localConfig.c);
    StyleLoaderHelper.a(paramString);
    paramString = localStyleLoaderHelper.a(paramContext);
    if (paramString == null)
    {
      paramContext = localStyleLoaderHelper.b(paramContext);
      return new StyleConfigHelper.TemplateFactoryWrapper(localConfig.c, paramContext, true);
    }
    return new StyleConfigHelper.TemplateFactoryWrapper(localConfig.b, paramString, false);
  }
  
  public Map<String, StyleConfigHelper.Config> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      StyleConfigHelper.Config localConfig = (StyleConfigHelper.Config)((Map.Entry)localIterator.next()).getValue();
      new StyleLoaderHelper(localConfig.b, localConfig.c).a();
    }
  }
  
  public void a(StyleConfigHelper.Config paramConfig)
  {
    if (paramConfig.a != null)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramConfig.a, paramConfig);
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void a(String paramString)
  {
    paramString = (StyleConfigHelper.Config)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      new StyleLoaderHelper(paramString.b, paramString.c).a();
    }
  }
  
  public void b()
  {
    if ((!RIJPushNotification.c()) && (Aladdin.getConfig(335).getIntegerFromString("pts_style_immediate_effect", 0) == 1) && (((Boolean)RIJSPUtils.a("kandian_pts_style_update", Boolean.valueOf(false))).booleanValue()))
    {
      QLog.d("StyleConfigHelper", 1, "invalidAllArticles");
      TemplateFactory.c("default_feeds");
      RIJSPUtils.a("kandian_pts_style_update", Boolean.valueOf(false));
      ProteusPreloadManager.a.a();
      List localList = ProteusPreloadManager.a.a();
      ProteusPreloadManager.a.a(localList);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload pts card, rules : ");
      localStringBuilder.append(localList);
      QLog.d("StyleConfigHelper", 1, localStringBuilder.toString());
      ReadInJoyLogicEngineEventDispatcher.a().n();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((StyleConfigHelper.Config)((Map.Entry)localIterator.next()).getValue()).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper
 * JD-Core Version:    0.7.0.1
 */