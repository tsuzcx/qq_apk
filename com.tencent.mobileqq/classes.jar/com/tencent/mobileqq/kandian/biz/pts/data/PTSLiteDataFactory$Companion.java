package com.tencent.mobileqq.kandian.biz.pts.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/data/PTSLiteDataFactory$Companion;", "", "()V", "TAG", "", "dataBuilderMap", "", "", "Lcom/tencent/mobileqq/kandian/biz/pts/data/PTSLiteDataFactory$IPTSLiteDataJson;", "addR5ReportJson", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "r5", "Lorg/json/JSONObject;", "bindCommonInfo", "json", "convertToPtsLiteCard", "updateReportData", "article", "exposeTime", "", "position", "dataManager", "Lcom/tencent/mobileqq/kandian/biz/accesslayer/data/RIJDataManager;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSLiteDataFactory$Companion
{
  private final void a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Util.c(paramAbsBaseArticleInfo, paramJSONObject);
    Util.b(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Object localObject3 = new JSONObject();
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.proteusItemsData)) {
        localObject1 = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      }
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[convertToPtsLiteCard] e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("PTSLiteDataFactory", 1, localStringBuilder.toString());
      localObject2 = localObject3;
    }
    localObject3 = (PTSLiteDataFactory.IPTSLiteDataJson)PTSLiteDataFactory.a().get(Integer.valueOf(paramAbsBaseArticleInfo.mFeedType));
    if (localObject3 != null)
    {
      ((PTSLiteDataFactory.IPTSLiteDataJson)localObject3).a(paramAbsBaseArticleInfo, (JSONObject)localObject2);
      PTSLiteDataFactory.a.a((JSONObject)localObject2, paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo.proteusItemsData = ((JSONObject)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[convertToPtsLiteCard], articleInfo = ");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
      QLog.i("PTSLiteDataFactory", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong, int paramInt, @NotNull RIJDataManager paramRIJDataManager)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "article");
    Intrinsics.checkParameterIsNotNull(paramRIJDataManager, "dataManager");
    if ((paramAbsBaseArticleInfo.mFeedType == 58) && (paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.next();
        Object localObject1 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "dataManager.builder");
        localObject1 = ((RIJDataManager.Builder)localObject1).A();
        Object localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        int i = ((RIJDataManager.Builder)localObject2).B();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        int j = ((RIJDataManager.Builder)localObject2).r();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        boolean bool = ((RIJDataManager.Builder)localObject2).n();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        localObject2 = ((RIJDataManager.Builder)localObject2).v();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder.readInJoyBaseAdapter");
        int k = ((ReadInJoyBaseAdapter)localObject2).getCount();
        localObject2 = paramRIJDataManager.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "dataManager.builder");
        RIJReportDataCollectionManager.a(localAbsBaseArticleInfo, (IReadInJoyModel)new ReadInJoyModelImpl((Context)localObject1, localAbsBaseArticleInfo, 46, i, j, paramInt, bool, k, null, (IReadInJoyBaseAdapter)((RIJDataManager.Builder)localObject2).v()), paramLong, paramInt, paramRIJDataManager);
      }
    }
  }
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "r5");
    Object localObject = (PTSLiteDataFactory.IPTSLiteDataJson)PTSLiteDataFactory.a().get(Integer.valueOf(paramAbsBaseArticleInfo.mFeedType));
    if (localObject != null)
    {
      ((PTSLiteDataFactory.IPTSLiteDataJson)localObject).b(paramAbsBaseArticleInfo, paramJSONObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[addR5ReportJson], mFeedType = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mFeedType);
      ((StringBuilder)localObject).append(", r5 = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("PTSLiteDataFactory", 1, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      if (paramAbsBaseArticleInfo.optJSONObject("card_report_params") != null)
      {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.getJSONObject("card_report_params");
        localObject = paramAbsBaseArticleInfo.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          String str2 = paramAbsBaseArticleInfo.optString(str1);
          if ((!TextUtils.isEmpty((CharSequence)str1)) && (!TextUtils.isEmpty((CharSequence)str2))) {
            paramJSONObject.put(str1, str2);
          }
        }
      }
      return;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("[getR5Json], e = ");
      paramJSONObject.append(paramAbsBaseArticleInfo);
      QLog.e("PTSLiteDataFactory", 1, paramJSONObject.toString());
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("[getR5Json], e = ");
      paramJSONObject.append(paramAbsBaseArticleInfo);
      QLog.e("PTSLiteDataFactory", 1, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory.Companion
 * JD-Core Version:    0.7.0.1
 */