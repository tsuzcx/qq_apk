import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusPreloadManager.preloadContainer.1;
import com.tencent.biz.pubaccount.readinjoy.config.beans.ProteusPreloadRule;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/ProteusPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ctxMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/proteus/wrap/ReadInjoyContext;", "preloadConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "preloadContainerMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/common/ProteusPreloadManager$PreloadContainerWrapper;", "clear", "", "getContainer", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "service", "styleName", "getProteusPreloadConfig", "", "Lcom/tencent/biz/pubaccount/readinjoy/config/beans/ProteusPreloadRule;", "initServiceValCtx", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "innerPreload", "key", "bean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "count", "", "ctx", "preloadCards", "rules", "preloadContainer", "PreloadContainerWrapper", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pis
{
  private static final AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ProteusPreloadManager";
  private static final Map<String, List<pit>> jdField_a_of_type_JavaUtilMap;
  public static final pis a;
  private static final Map<String, qxj> b = (Map)new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Pis = new pis();
    jdField_a_of_type_JavaLangString = "ProteusPreloadManager";
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
    AladdinConfig localAladdinConfig = Aladdin.getConfig(334);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…FIG_PROTEUS_CARD_PRELOAD)");
    jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = localAladdinConfig;
  }
  
  private final VafContext a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    if (localBaseApplication != null)
    {
      localObject = localBaseApplication.getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
      if (((Resources)localObject).getConfiguration().orientation != 2) {}
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "orientation is landscape ! ctx can't init");
      return null;
    }
    Object localObject = new qxj();
    b.put(paramString, localObject);
    ((qxj)localObject).setContext((Context)localBaseApplication);
    piv.a((VafContext)localObject, paramString);
    return (VafContext)localObject;
  }
  
  private final void a(String paramString, TemplateBean paramTemplateBean, int paramInt, VafContext paramVafContext)
  {
    int k = 0;
    int j = 0;
    int i;
    if (j < paramInt)
    {
      try
      {
        Object localObject = paramVafContext.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ctx.context");
        localObject = ((Context)localObject).getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "ctx.context.resources");
        if ((((Resources)localObject).getConfiguration().orientation == 2) || (UIUtils.getScreenWidth(paramVafContext.getContext()) > UIUtils.getScreenHeight(paramVafContext.getContext())))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "orientation is landscape ! give up preload container[" + paramString + ']');
          i = k;
        }
        else
        {
          localObject = paramVafContext.getViewFactory().inflate(paramVafContext, paramTemplateBean);
          i = k;
          if (localObject != null)
          {
            i = k + 1;
            if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
            {
              List localList = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
              if (localList == null) {
                break label298;
              }
              localList.add(new pit((Container)localObject));
            }
            else
            {
              jdField_a_of_type_JavaUtilMap.put(paramString, CollectionsKt.mutableListOf(new pit[] { new pit((Container)localObject) }));
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "preload happen error : " + paramString);
        return;
      }
    }
    else
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "innerPreload " + paramString + " success , cnt : " + k);
      return;
    }
    label298:
    for (;;)
    {
      j += 1;
      k = i;
      break;
    }
  }
  
  @ExperimentalStdlibApi
  @Nullable
  public final Container a(@Nullable String paramString1, @Nullable String paramString2)
  {
    boolean bool = false;
    if ((paramString1 == null) || (paramString2 == null)) {}
    label161:
    label166:
    do
    {
      return null;
      String str = paramString1 + '#' + paramString2;
      paramString1 = (List)jdField_a_of_type_JavaUtilMap.get(str);
      int i;
      if (paramString1 != null)
      {
        i = paramString1.size();
        paramString1 = jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("getContainer : ").append(paramString2).append(" ret : ");
        if (i > 0) {
          bool = true;
        }
        QLog.d(paramString1, 1, bool);
        if (i <= 0) {
          break label231;
        }
        paramString1 = (List)jdField_a_of_type_JavaUtilMap.get(str);
        if (paramString1 == null) {
          break label161;
        }
      }
      for (paramString1 = (pit)CollectionsKt.removeLast(paramString1);; paramString1 = null)
      {
        if (paramString1 == null) {
          break label224;
        }
        if (!paramString1.a()) {
          break label166;
        }
        return paramString1.a();
        i = 0;
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "container size is not suitable, size : " + paramString1.a());
      paramString2 = (List)jdField_a_of_type_JavaUtilMap.get(str);
    } while (paramString2 == null);
    paramString2.add(paramString1);
    return null;
    label224:
    label231:
    for (paramString1 = (Container)null;; paramString1 = null) {
      return paramString1;
    }
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
    if (!uro.a.b()) {}
    TemplateBean localTemplateBean;
    do
    {
      do
      {
        return;
        localObject = tmh.a(paramString1, true);
      } while (localObject == null);
      localTemplateBean = ((tmh)localObject).getTemplate(paramString2);
    } while (localTemplateBean == null);
    Object localObject = (qxj)b.get(paramString1);
    if (localObject != null) {}
    for (localObject = (VafContext)localObject; localObject == null; localObject = a(paramString1))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "ctx is null, can't preload");
      return;
    }
    ThreadManager.executeOnSubThread((Runnable)new ProteusPreloadManager.preloadContainer.1(paramString1, paramString2, localTemplateBean, paramInt, (VafContext)localObject));
  }
  
  public final void a(@NotNull List<ProteusPreloadRule> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "rules");
    QLog.d(jdField_a_of_type_JavaLangString, 1, "preload list : " + paramList);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProteusPreloadRule localProteusPreloadRule = (ProteusPreloadRule)paramList.next();
      a(localProteusPreloadRule.getBizID(), localProteusPreloadRule.getStyleName(), localProteusPreloadRule.getPreloadCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pis
 * JD-Core Version:    0.7.0.1
 */