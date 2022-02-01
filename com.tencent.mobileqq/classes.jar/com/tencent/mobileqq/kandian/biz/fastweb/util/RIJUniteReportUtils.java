package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/util/RIJUniteReportUtils;", "", "()V", "APP_TYPE", "", "BUTTON_STATUE", "CHANNEL_ID", "CLICK_TYPE", "FAVOURITE_REPORT_CLICK_T", "FAVOURITE_REPORT_EXPOSURE_T", "LIKE_REPORT_CLICK_T", "LIKE_REPORT_EXPOSURE_T", "PAGE_TYPE", "PAGE_TYPE_ARTICLE", "", "ROWKEY", "SCENE_TYPE", "SCENE_TYPE_3POINT", "SCENE_TYPE_BOTTOM", "SCENE_TYPE_MIDDLE", "TO_UIN", "report", "", "bigT", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "sceneType", "status", "statusKey", "params", "", "reportLikeClick", "clickType", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUniteReportUtils
{
  public static final RIJUniteReportUtils a = new RIJUniteReportUtils();
  
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    a("0X800BB01", paramAbsBaseArticleInfo, paramInt1, "click_type", Integer.valueOf(paramInt2));
  }
  
  public final void a(@NotNull String paramString1, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, @NotNull String paramString2, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "bigT");
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramString2, "status");
    Intrinsics.checkParameterIsNotNull(paramObject, "statusKey");
    Map localMap = (Map)new HashMap();
    String str = paramAbsBaseArticleInfo.mSubscribeID;
    Intrinsics.checkExpressionValueIsNotNull(str, "articleInfo.mSubscribeID");
    localMap.put("touin", str);
    str = paramAbsBaseArticleInfo.innerUniqueID;
    Intrinsics.checkExpressionValueIsNotNull(str, "articleInfo.innerUniqueID");
    localMap.put("rowkey", str);
    localMap.put("channel_id", Long.valueOf(paramAbsBaseArticleInfo.mChannelID));
    localMap.put("page_type", Integer.valueOf(2));
    localMap.put("scene_type", Integer.valueOf(paramInt));
    localMap.put("app_type", Integer.valueOf(3));
    localMap.put(paramString2, paramObject);
    a(paramString1, localMap);
  }
  
  public final void a(@NotNull String paramString, @NotNull Map<String, Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bigT");
    Intrinsics.checkParameterIsNotNull(paramMap, "params");
    JSONObject localJSONObject = new JSONObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.RIJUniteReportUtils
 * JD-Core Version:    0.7.0.1
 */