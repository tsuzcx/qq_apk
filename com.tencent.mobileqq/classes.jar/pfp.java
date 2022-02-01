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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/common/ProteusPreloadManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ctxMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/proteus/wrap/ReadInjoyContext;", "preloadConfig", "Lcom/tencent/aladdin/config/AladdinConfig;", "preloadContainerMap", "", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;", "clear", "", "getContainer", "service", "styleName", "getProteusPreloadConfig", "", "Lcom/tencent/biz/pubaccount/readinjoy/config/beans/ProteusPreloadRule;", "initServiceValCtx", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "innerPreload", "key", "bean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "count", "", "ctx", "preloadCards", "rules", "preloadContainer", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pfp
{
  private static final AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ProteusPreloadManager";
  private static final Map<String, List<Container>> jdField_a_of_type_JavaUtilMap;
  public static final pfp a;
  private static final Map<String, qmv> b = (Map)new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Pfp = new pfp();
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
    Object localObject = new qmv();
    b.put(paramString, localObject);
    ((qmv)localObject).setContext((Context)localBaseApplication);
    pfr.a((VafContext)localObject, paramString);
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
        if ((((Resources)localObject).getConfiguration().orientation == 2) || (zlx.b(paramVafContext.getContext()) > zlx.c(paramVafContext.getContext())))
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
                break label284;
              }
              localList.add(localObject);
            }
            else
            {
              jdField_a_of_type_JavaUtilMap.put(paramString, CollectionsKt.mutableListOf(new Container[] { localObject }));
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
    label284:
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
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    paramString1 = paramString1 + '#' + paramString2;
    Object localObject = (List)jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localObject != null) {}
    for (int i = ((List)localObject).size();; i = 0)
    {
      localObject = jdField_a_of_type_JavaLangString;
      paramString2 = new StringBuilder().append("getContainer : ").append(paramString2).append(" ret : ");
      if (i > 0) {
        bool = true;
      }
      QLog.d((String)localObject, 1, bool);
      if (i <= 0) {
        break label149;
      }
      paramString1 = (List)jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (paramString1 == null) {
        break;
      }
      return (Container)CollectionsKt.removeFirst(paramString1);
    }
    return null;
    label149:
    return null;
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
  }
  
  @JvmOverloads
  public final void a(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "service");
    Intrinsics.checkParameterIsNotNull(paramString2, "styleName");
    if (!twz.a.b()) {}
    TemplateBean localTemplateBean;
    do
    {
      do
      {
        return;
        localObject = teh.a(paramString1, true);
      } while (localObject == null);
      localTemplateBean = ((teh)localObject).getTemplate(paramString2);
    } while (localTemplateBean == null);
    Object localObject = (qmv)b.get(paramString1);
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
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ProteusPreloadRule localProteusPreloadRule = (ProteusPreloadRule)paramList.next();
      a(localProteusPreloadRule.getBizID(), localProteusPreloadRule.getStyleName(), localProteusPreloadRule.getPreloadCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfp
 * JD-Core Version:    0.7.0.1
 */