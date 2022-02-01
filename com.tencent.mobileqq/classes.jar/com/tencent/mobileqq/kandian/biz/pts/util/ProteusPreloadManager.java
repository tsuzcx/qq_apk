package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.aladdin.beans.ProteusPreloadRule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/util/ProteusPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ctxMap", "", "Lcom/tencent/mobileqq/kandian/biz/pts/ReadInjoyContext;", "preloadConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "preloadContainerMap", "", "Lcom/tencent/mobileqq/kandian/biz/pts/util/ProteusPreloadManager$PreloadContainerWrapper;", "clear", "", "getContainer", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "service", "styleName", "getProteusPreloadConfig", "", "Lcom/tencent/mobileqq/kandian/repo/aladdin/beans/ProteusPreloadRule;", "initServiceValCtx", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "innerPreload", "key", "bean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "count", "", "ctx", "preloadCards", "rules", "preloadContainer", "PreloadContainerWrapper", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ProteusPreloadManager
{
  private static final AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
  public static final ProteusPreloadManager a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ProteusPreloadManager";
  private static final Map<String, List<ProteusPreloadManager.PreloadContainerWrapper>> jdField_a_of_type_JavaUtilMap;
  private static final Map<String, ReadInjoyContext> b = (Map)new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilProteusPreloadManager = new ProteusPreloadManager();
    jdField_a_of_type_JavaLangString = "ProteusPreloadManager";
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(334);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…FIG_PROTEUS_CARD_PRELOAD)");
    jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = localAladdinConfig;
  }
  
  private final VafContext a(String paramString)
  {
    Object localObject1 = BaseApplicationImpl.context;
    if (localObject1 != null)
    {
      Object localObject2 = ((BaseApplication)localObject1).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.resources");
      if (((Resources)localObject2).getConfiguration().orientation != 2)
      {
        localObject2 = new ReadInjoyContext();
        b.put(paramString, localObject2);
        ((ReadInjoyContext)localObject2).setContext((Context)localObject1);
        localObject1 = (VafContext)localObject2;
        ProteusSupportUtil.a((VafContext)localObject1, paramString);
        return localObject1;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "orientation is landscape ! ctx can't init");
    return null;
  }
  
  private final void a(String paramString, TemplateBean paramTemplateBean, int paramInt, VafContext paramVafContext)
  {
    int j = 0;
    int k = 0;
    while (j < paramInt) {
      try
      {
        Object localObject1 = paramVafContext.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "ctx.context");
        localObject1 = ((Context)localObject1).getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "ctx.context.resources");
        int i;
        Object localObject2;
        if ((((Resources)localObject1).getConfiguration().orientation != 2) && (UIUtils.b(paramVafContext.getContext()) <= UIUtils.c(paramVafContext.getContext())))
        {
          localObject1 = paramVafContext.getViewFactory().inflate(paramVafContext, paramTemplateBean);
          i = k;
          if (localObject1 != null)
          {
            k += 1;
            if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
            {
              localObject2 = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
              i = k;
              if (localObject2 != null)
              {
                ((List)localObject2).add(new ProteusPreloadManager.PreloadContainerWrapper((Container)localObject1));
                i = k;
              }
            }
            else
            {
              jdField_a_of_type_JavaUtilMap.put(paramString, CollectionsKt.mutableListOf(new ProteusPreloadManager.PreloadContainerWrapper[] { new ProteusPreloadManager.PreloadContainerWrapper((Container)localObject1) }));
              i = k;
            }
          }
        }
        else
        {
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("orientation is landscape ! give up preload container[");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(']');
          QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          i = k;
        }
        j += 1;
        k = i;
      }
      catch (Throwable paramString)
      {
        paramTemplateBean = jdField_a_of_type_JavaLangString;
        paramVafContext = new StringBuilder();
        paramVafContext.append("preload happen error : ");
        paramVafContext.append(paramString);
        QLog.d(paramTemplateBean, 1, paramVafContext.toString());
        return;
      }
    }
    paramTemplateBean = jdField_a_of_type_JavaLangString;
    paramVafContext = new StringBuilder();
    paramVafContext.append("innerPreload ");
    paramVafContext.append(paramString);
    paramVafContext.append(" success , cnt : ");
    paramVafContext.append(k);
    QLog.d(paramTemplateBean, 1, paramVafContext.toString());
  }
  
  @ExperimentalStdlibApi
  @Nullable
  public final Container a(@Nullable String paramString1, @Nullable String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append('#');
      ((StringBuilder)localObject1).append(paramString2);
      String str = ((StringBuilder)localObject1).toString();
      paramString1 = (List)jdField_a_of_type_JavaUtilMap.get(str);
      boolean bool = false;
      int i;
      if (paramString1 != null) {
        i = paramString1.size();
      } else {
        i = 0;
      }
      paramString1 = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getContainer : ");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" ret : ");
      if (i > 0) {
        bool = true;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d(paramString1, 1, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (i > 0)
      {
        paramString1 = (List)jdField_a_of_type_JavaUtilMap.get(str);
        if (paramString1 != null) {
          paramString1 = (ProteusPreloadManager.PreloadContainerWrapper)CollectionsKt.removeLast(paramString1);
        } else {
          paramString1 = null;
        }
        if (paramString1 != null)
        {
          if (paramString1.a()) {
            return paramString1.a();
          }
          paramString2 = jdField_a_of_type_JavaLangString;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("container size is not suitable, size : ");
          ((StringBuilder)localObject1).append(paramString1.a());
          QLog.d(paramString2, 1, ((StringBuilder)localObject1).toString());
          paramString2 = (List)jdField_a_of_type_JavaUtilMap.get(str);
          if (paramString2 != null) {
            paramString2.add(paramString1);
          }
          return null;
        }
        localObject1 = (Container)null;
      }
    }
    return localObject1;
  }
  
  @NotNull
  public final List<ProteusPreloadRule> a()
  {
    List localList = jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getList("preload_list");
    Intrinsics.checkExpressionValueIsNotNull(localList, "preloadConfig.getList<Pr…loadRule>(\"preload_list\")");
    return localList;
  }
  
  public final void a()
  {
    b.clear();
    jdField_a_of_type_JavaUtilMap.clear();
    QLog.d(jdField_a_of_type_JavaLangString, 1, "clear");
  }
  
  @JvmOverloads
  public final void a(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "service");
    Intrinsics.checkParameterIsNotNull(paramString2, "styleName");
    if (!FluencyOptUtils.a.b()) {
      return;
    }
    Object localObject = TemplateFactory.a(paramString1, true);
    if (localObject != null)
    {
      TemplateBean localTemplateBean = ((TemplateFactory)localObject).getTemplate(paramString2);
      if (localTemplateBean != null)
      {
        localObject = (ReadInjoyContext)b.get(paramString1);
        if (localObject != null) {
          localObject = (VafContext)localObject;
        } else {
          localObject = a(paramString1);
        }
        if (localObject == null)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "ctx is null, can't preload");
          return;
        }
        ThreadManager.executeOnSubThread((Runnable)new ProteusPreloadManager.preloadContainer.1(paramString1, paramString2, localTemplateBean, paramInt, (VafContext)localObject));
      }
    }
  }
  
  public final void a(@NotNull List<ProteusPreloadRule> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rules");
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preload list : ");
    localStringBuilder.append(paramList);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (ProteusPreloadRule)paramList.next();
      a(((ProteusPreloadRule)localObject).getBizID(), ((ProteusPreloadRule)localObject).getStyleName(), ((ProteusPreloadRule)localObject).getPreloadCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusPreloadManager
 * JD-Core Version:    0.7.0.1
 */