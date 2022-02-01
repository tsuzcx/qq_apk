package com.tencent.mobileqq.kandian.biz.video.column;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/column/VideoColumnDataManager;", "", "fromType", "", "(I)V", "dataMap", "", "", "Lorg/json/JSONObject;", "getFromType", "()I", "requestingList", "", "addData", "", "topicId", "json", "convertColumnJson", "columnInfo", "Lcom/tencent/mobileqq/kandian/repo/video/entity/VideoColumnInfo;", "disablePreload", "", "videoFromType", "fetchVideoColumnList", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "rowKey", "getColumnDataInfo", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "getUrlJumpInfo", "urlJumpInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/UrlJumpInfo;", "makeReqBody", "Lcom/tencent/mobileqq/WebSsoBody$WebSsoRequestBody;", "onCenterViewChange", "viewHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "removeRequest", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoColumnDataManager
{
  public static final VideoColumnDataManager.Companion a;
  private final int jdField_a_of_type_Int;
  private final List<String> jdField_a_of_type_JavaUtilList;
  private final Map<String, JSONObject> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager$Companion = new VideoColumnDataManager.Companion(null);
  }
  
  public VideoColumnDataManager(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
  }
  
  private final WebSsoBody.WebSsoRequestBody a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject2 = new JSONObject().put("uint32_topic_basic", 1).put("uint32_topic_ext", 1).put("uint32_topic_isfans", 1).put("uint32_article_basic", 2).put("uint32_article_play", 1).put("uint32_article_like", 1).put("uint32_article_comment", 1).put("uint32_article_islike", 1).put("uint32_topic_guide", 1);
    JSONObject localJSONObject1 = new JSONObject();
    paramString2 = new JSONArray((Collection)CollectionsKt.arrayListOf(new String[] { paramString2 }));
    localJSONObject1.put("str_topicid", paramString1).put("uint32_size", 6).put("msg_option", localJSONObject2).put("rpt_top_rowkey", paramString2).put("is_public", 0);
    paramString1 = new JSONObject();
    paramString1.put("body", localJSONObject1);
    paramString2 = new WebSsoBody.WebSsoRequestBody();
    paramString2.type.set(0);
    paramString2.data.set(paramString1.toString());
    return paramString2;
  }
  
  private final String a(UrlJumpInfo paramUrlJumpInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramUrlJumpInfo != null) {
      localJSONObject.put("uint32_jump_type", paramUrlJumpInfo.jdField_a_of_type_Int).put("bytes_jump_schema", paramUrlJumpInfo.jdField_c_of_type_JavaLangString).put("bytes_jump_bundle", paramUrlJumpInfo.jdField_b_of_type_JavaLangString).put("bytes_jump_url", paramUrlJumpInfo.jdField_a_of_type_JavaLangString).put("bytes_clipboard_info", paramUrlJumpInfo.jdField_d_of_type_JavaLangString).put("bytes_common_data", paramUrlJumpInfo.jdField_e_of_type_JavaLangString);
    }
    paramUrlJumpInfo = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramUrlJumpInfo, "json.toString()");
    return paramUrlJumpInfo;
  }
  
  private final String a(String paramString)
  {
    paramString = (JSONObject)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.toString();
    }
    return null;
  }
  
  private final void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString1)))
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString1)) {
        return;
      }
      QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
      if (localQQAppInterface != null)
      {
        this.jdField_a_of_type_JavaUtilList.add(paramString1);
        ThreadManagerV2.executeOnSubThread((Runnable)new VideoColumnDataManager.fetchVideoColumnList.2(this, paramString1, paramString2, localQQAppInterface));
      }
    }
  }
  
  private final boolean a(int paramInt)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(350);
    boolean bool = false;
    if ((localAladdinConfig.getIntegerFromString("disable_preload", 0) == 1) || (!ReadInJoyHelper.c(paramInt)) || (!PlayerHelper.a.a())) {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  public final String a(@NotNull VideoColumnInfo paramVideoColumnInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoColumnInfo, "columnInfo");
    return new JSONObject().put("uint32_column_id", paramVideoColumnInfo.jdField_a_of_type_Int).put("bytes_column_name", paramVideoColumnInfo.jdField_b_of_type_JavaLangString).put("bytes_column_icon_url", paramVideoColumnInfo.jdField_c_of_type_JavaLangString).put("uint32_subscribe_count", paramVideoColumnInfo.jdField_c_of_type_Int).put("uint32_is_subscribed", paramVideoColumnInfo.jdField_a_of_type_Boolean).put("bytes_app_name", paramVideoColumnInfo.g).put("bytes_app_icon_url", paramVideoColumnInfo.h).put("subscribe_jump_info", a(paramVideoColumnInfo.jdField_c_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo)).put("app_jump_info", a(paramVideoColumnInfo.jdField_d_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo)).put("default_jump_info", a(paramVideoColumnInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo)).put("uint32_style", paramVideoColumnInfo.jdField_e_of_type_Int).put("bytes_from_txt", paramVideoColumnInfo.i).put("uint64_last_update_time", paramVideoColumnInfo.jdField_a_of_type_Long).put("uint32_video_count", paramVideoColumnInfo.jdField_b_of_type_Int).put("bytes_column_card_bg_url", paramVideoColumnInfo.jdField_d_of_type_JavaLangString).put("bytes_column_card_bg_color", paramVideoColumnInfo.jdField_e_of_type_JavaLangString).put("bytes_column_card_icon_url", paramVideoColumnInfo.jdField_f_of_type_JavaLangString).put("bytes_column_name_color", paramVideoColumnInfo.j).put("uin32_column_card_bg_style", paramVideoColumnInfo.jdField_d_of_type_Int).put("uint32_update_count", paramVideoColumnInfo.jdField_f_of_type_Int).toString();
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (a(this.jdField_a_of_type_Int)) {
      return;
    }
    VideoColumnInfo localVideoColumnInfo = paramVideoInfo.a;
    if (localVideoColumnInfo != null) {
      a(String.valueOf(localVideoColumnInfo.jdField_a_of_type_Int), paramVideoInfo.g);
    }
  }
  
  public final void a(@Nullable VideoItemHolder paramVideoItemHolder)
  {
    if (a(this.jdField_a_of_type_Int)) {
      return;
    }
    if (paramVideoItemHolder != null)
    {
      paramVideoItemHolder = paramVideoItemHolder.a;
      if (paramVideoItemHolder != null)
      {
        paramVideoItemHolder = paramVideoItemHolder.a;
        if ((paramVideoItemHolder != null) && ((paramVideoItemHolder instanceof VideoInfo)))
        {
          VideoColumnInfo localVideoColumnInfo = paramVideoItemHolder.a;
          if (localVideoColumnInfo != null) {
            a(String.valueOf(localVideoColumnInfo.jdField_a_of_type_Int), paramVideoItemHolder.g);
          }
        }
      }
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
  }
  
  public final void a(@NotNull String paramString, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    String str2 = a(paramString);
    String str1;
    if (str2 != null) {
      str1 = str2;
    } else {
      str1 = "";
    }
    paramFunction1.invoke(str1);
    if (str2 == null)
    {
      paramFunction1 = new StringBuilder();
      paramFunction1.append("getColumnInfo error, waitingData: ");
      paramFunction1.append(this.jdField_a_of_type_JavaUtilList.contains(paramString));
      QLog.e("VideoColumnDataManager", 1, paramFunction1.toString());
    }
  }
  
  public final void a(@NotNull String paramString, @NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "json");
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramJSONObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topicId: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", data: ");
      localStringBuilder.append(paramJSONObject);
      QLog.d("VideoColumnDataManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager
 * JD-Core Version:    0.7.0.1
 */