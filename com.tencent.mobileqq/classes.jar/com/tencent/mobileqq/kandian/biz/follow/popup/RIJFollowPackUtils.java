package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowPackUtils;", "", "()V", "FOLLOW_AVATOR_CLICK_TYPE", "", "FOLLOW_BUTTON_CLICK_TYPE", "FOLLOW_CONTAINER_CLICK_TYPE", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportInfo", "", "", "", "getReportInfo", "()Ljava/util/Map;", "setReportInfo", "(Ljava/util/Map;)V", "addButtonType", "", "recommendFollowInfo", "Lcom/tencent/mobileqq/kandian/repo/follow/RecommendFollowInfo;", "map", "isClick", "", "addExtraReport", "r5Builder", "Lcom/tencent/mobileqq/kandian/glue/report/RIJTransMergeKanDianReport$ReportR5Builder;", "extras", "", "addProteusFollowCards", "context", "Landroid/content/Context;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "parentLayout", "Landroid/view/ViewGroup;", "dialog", "Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJBottomDialog;", "addUin", "clickFollowBtn", "followPackData", "Lcom/tencent/mobileqq/kandian/biz/follow/popup/RIJFollowPackUtils$RIJFollowPackData;", "createProteusContext", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "destroy", "doProteusClick", "position", "type", "getFollowReportParams", "source", "(Lcom/tencent/mobileqq/kandian/repo/follow/RecommendFollowInfo;ZLjava/lang/Integer;)Ljava/util/Map;", "getRecommendFollowInfo", "index", "hasReported", "bigT", "uin", "isPGC", "jump", "jump2SelfPage", "refreshProteus", "report", "reportT", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/kandian/repo/follow/RecommendFollowInfo;Ljava/util/Map;)V", "requestFollow", "setAttachData", "container", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "templateBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;", "updateFollowStatus", "recommendFollowInfoList", "", "RIJFollowPackData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFollowPackUtils
{
  public static final RIJFollowPackUtils a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "RIJFollowPackUtils";
  @NotNull
  private static Map<String, List<Long>> jdField_a_of_type_JavaUtilMap = (Map)new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFollowPopupRIJFollowPackUtils = new RIJFollowPackUtils();
  }
  
  private final VafContext a(Context paramContext)
  {
    ReadInjoyContext localReadInjoyContext = new ReadInjoyContext();
    localReadInjoyContext.setContext(paramContext);
    paramContext = (VafContext)localReadInjoyContext;
    ProteusSupportUtil.a(paramContext, "native_article");
    return paramContext;
  }
  
  private final RecommendFollowInfo a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)null;
    RecommendFollowInfos localRecommendFollowInfos = paramAbsBaseArticleInfo.mRecommendFollowInfos;
    paramAbsBaseArticleInfo = localRecommendFollowInfo;
    if (localRecommendFollowInfos != null)
    {
      paramAbsBaseArticleInfo = localRecommendFollowInfo;
      if (paramInt >= 0)
      {
        paramAbsBaseArticleInfo = localRecommendFollowInfo;
        if (paramInt < localRecommendFollowInfos.a.size()) {
          paramAbsBaseArticleInfo = (RecommendFollowInfo)localRecommendFollowInfos.a.get(paramInt);
        }
      }
    }
    return paramAbsBaseArticleInfo;
  }
  
  private final void a(int paramInt, RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (paramRecommendFollowInfo != null) {
      RIJJumpUtils.a(String.valueOf(paramRecommendFollowInfo.uin), null);
    }
  }
  
  private final void a(ViewBase paramViewBase, TemplateBean paramTemplateBean, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJBottomDialog paramRIJBottomDialog)
  {
    ViewBase localViewBase = paramViewBase.findViewBaseByName("id_proteus_collection_view");
    Intrinsics.checkExpressionValueIsNotNull(localViewBase, "container.findViewBaseBy…proteus_collection_view\")");
    if ((localViewBase instanceof RvPolymericContainer))
    {
      paramViewBase = new RIJFollowPackUtils.RIJFollowPackData(paramTemplateBean, paramViewBase, paramAbsBaseArticleInfo);
      ((RvPolymericContainer)localViewBase).a(paramViewBase);
      paramRIJBottomDialog.a(paramViewBase);
    }
  }
  
  private final void a(RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData, RecommendFollowInfo paramRecommendFollowInfo)
  {
    if (paramRecommendFollowInfo != null)
    {
      if (paramRecommendFollowInfo.isFollowed)
      {
        RIJJumpUtils.a(String.valueOf(paramRecommendFollowInfo.uin), null);
        return;
      }
      jdField_a_of_type_ComTencentMobileqqKandianBizFollowPopupRIJFollowPackUtils.b(paramRIJFollowPackData, paramRecommendFollowInfo);
    }
  }
  
  private final void a(RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder, Map<String, ? extends Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramReportR5Builder.addValueSafe((String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }
  
  private final void a(RecommendFollowInfo paramRecommendFollowInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    if (a(paramRecommendFollowInfo))
    {
      paramReportR5Builder.addStringNotThrow("puin", paramRecommendFollowInfo.uin);
      return;
    }
    paramReportR5Builder.addStringNotThrow("ugcuin", paramRecommendFollowInfo.uin);
  }
  
  private final void a(RecommendFollowInfo paramRecommendFollowInfo, Map<String, Object> paramMap, boolean paramBoolean)
  {
    int i = 2;
    if (paramBoolean)
    {
      if (!paramRecommendFollowInfo.isFollowed) {
        i = 1;
      }
      paramMap.put("click_type", Integer.valueOf(i));
      return;
    }
    if (!paramRecommendFollowInfo.isFollowed) {
      i = 1;
    }
    paramMap.put("button_type", Integer.valueOf(i));
  }
  
  private final boolean a(RecommendFollowInfo paramRecommendFollowInfo)
  {
    return paramRecommendFollowInfo.type == 1;
  }
  
  private final boolean a(String paramString, long paramLong)
  {
    List localList = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localList == null)
    {
      localList = (List)new ArrayList();
      localList.add(Long.valueOf(paramLong));
      jdField_a_of_type_JavaUtilMap.put(paramString, localList);
    }
    else
    {
      if ("0X800B96B".equals(paramString)) {
        return true;
      }
      if (localList.contains(Long.valueOf(paramLong))) {
        return true;
      }
      localList.add(Long.valueOf(paramLong));
    }
    return false;
  }
  
  private final void b(RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData, RecommendFollowInfo paramRecommendFollowInfo)
  {
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    if (localUserOperationModule != null)
    {
      String str1 = RIJQQAppInterfaceUtil.a();
      long l = paramRecommendFollowInfo.uin;
      String str2 = paramRecommendFollowInfo.headUrl;
      paramRIJFollowPackData = (Ox978RespCallBack)new RIJFollowPackUtils.requestFollow.1(paramRecommendFollowInfo, paramRIJFollowPackData);
      int i;
      if (a(paramRecommendFollowInfo)) {
        i = 1;
      } else {
        i = 2;
      }
      localUserOperationModule.request0x978(str1, l, true, str2, paramRIJFollowPackData, i);
    }
  }
  
  @NotNull
  public final String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final Map<String, Object> a(@Nullable RecommendFollowInfo paramRecommendFollowInfo, boolean paramBoolean, @Nullable Integer paramInteger)
  {
    Map localMap = (Map)new HashMap();
    int i;
    if ((paramInteger != null) && (paramInteger.intValue() == 2)) {
      i = 17;
    } else {
      i = 18;
    }
    localMap.put("scene_type", Integer.valueOf(i));
    if (paramRecommendFollowInfo != null) {
      jdField_a_of_type_ComTencentMobileqqKandianBizFollowPopupRIJFollowPackUtils.a(paramRecommendFollowInfo, localMap, paramBoolean);
    }
    return localMap;
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFollowPackData, "followPackData");
    RecommendFollowInfo localRecommendFollowInfo = a(paramRIJFollowPackData.a(), paramInt1);
    if (localRecommendFollowInfo != null) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqKandianBizFollowPopupRIJFollowPackUtils.a(paramInt1, paramInt2, paramRIJFollowPackData, localRecommendFollowInfo);
      }
      catch (Exception paramRIJFollowPackData)
      {
        jdField_a_of_type_ComTencentMobileqqKandianBizFollowPopupRIJFollowPackUtils.a(paramInt1, localRecommendFollowInfo);
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doProteusClick! error msg=");
        localStringBuilder.append(paramRIJFollowPackData);
        QLog.d((String)localObject, 1, localStringBuilder.toString());
      }
    }
    paramRIJFollowPackData = jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doProteusClick! position=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", type=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", recommendFollowInfo=");
    ((StringBuilder)localObject).append(localRecommendFollowInfo);
    QLog.d(paramRIJFollowPackData, 1, ((StringBuilder)localObject).toString());
  }
  
  public final void a(int paramInt1, int paramInt2, @NotNull RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData, @NotNull RecommendFollowInfo paramRecommendFollowInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFollowPackData, "followPackData");
    Intrinsics.checkParameterIsNotNull(paramRecommendFollowInfo, "recommendFollowInfo");
    Object localObject = paramRIJFollowPackData.a().mRecommendFollowInfos;
    if (localObject != null) {
      localObject = Integer.valueOf(((RecommendFollowInfos)localObject).b);
    } else {
      localObject = null;
    }
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 != 3)
        {
          a(paramInt1, paramRecommendFollowInfo);
        }
        else
        {
          a("0X800B96D", (Integer)localObject, paramRecommendFollowInfo, null);
          a(paramInt1, paramRecommendFollowInfo);
        }
      }
      else
      {
        a("0X800B1A7", (Integer)localObject, paramRecommendFollowInfo, a(paramRecommendFollowInfo, true, (Integer)localObject));
        a(paramRIJFollowPackData, paramRecommendFollowInfo);
      }
    }
    else {
      a(paramInt1, paramRecommendFollowInfo);
    }
    a("0X800B96B", (Integer)localObject, paramRecommendFollowInfo, null);
  }
  
  public final void a(@NotNull Context paramContext, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull ViewGroup paramViewGroup, @NotNull RIJBottomDialog paramRIJBottomDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parentLayout");
    Intrinsics.checkParameterIsNotNull(paramRIJBottomDialog, "dialog");
    try
    {
      Object localObject = a(paramContext);
      paramContext = FastWebPTSDataConverter.a(paramAbsBaseArticleInfo);
      localObject = ((VafContext)localObject).getViewFactory().inflate((VafContext)localObject, paramContext);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "followCardsView");
      ViewBase localViewBase = ((Container)localObject).getVirtualView();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "templateBean");
      ProteusSupportUtil.a(localViewBase, paramContext.getViewBean());
      paramViewGroup.addView((View)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localViewBase, "container");
      a(localViewBase, paramContext, paramAbsBaseArticleInfo, paramRIJBottomDialog);
      return;
    }
    catch (Exception paramContext)
    {
      paramAbsBaseArticleInfo = jdField_a_of_type_JavaLangString;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("addProteusFollowCards error! msg=");
      paramViewGroup.append(paramContext);
      QLog.d(paramAbsBaseArticleInfo, 1, paramViewGroup.toString());
    }
  }
  
  public final void a(@NotNull RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData)
  {
    Intrinsics.checkParameterIsNotNull(paramRIJFollowPackData, "followPackData");
    JSONObject localJSONObject = FastWebPTSDataConverter.a(paramRIJFollowPackData.a().mRecommendFollowInfos);
    paramRIJFollowPackData.a().bindData(localJSONObject);
    ProteusSupportUtil.a(paramRIJFollowPackData.a(), paramRIJFollowPackData.a().getViewBean());
  }
  
  public final void a(@NotNull String paramString, @Nullable Integer paramInteger, @NotNull RecommendFollowInfo paramRecommendFollowInfo, @Nullable Map<String, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reportT");
    Intrinsics.checkParameterIsNotNull(paramRecommendFollowInfo, "recommendFollowInfo");
    if (a(paramString, paramRecommendFollowInfo.uin)) {
      return;
    }
    paramInteger = RIJFollowRecommendReport.a.a(paramInteger);
    a(paramInteger, paramMap);
    a(paramRecommendFollowInfo, paramInteger);
    paramRecommendFollowInfo = RIJFollowRecommendReport.a;
    paramInteger = paramInteger.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramInteger, "r5Builder.toString()");
    paramRecommendFollowInfo.a(paramString, paramInteger);
  }
  
  public final void a(@NotNull List<? extends RecommendFollowInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "recommendFollowInfoList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)paramList.next();
      localRecommendFollowInfo.isFollowed = FollowListInfoModule.a(localRecommendFollowInfo.uin, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils
 * JD-Core Version:    0.7.0.1
 */