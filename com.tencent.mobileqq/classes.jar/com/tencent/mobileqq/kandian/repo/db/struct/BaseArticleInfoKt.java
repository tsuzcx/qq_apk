package com.tencent.mobileqq.kandian.repo.db.struct;

import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeParam;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.search.RequestSearchWord.Rcmd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shouldReportExtraBiuUI", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "shouldShowExtraBiuUI", "getSocialCardJumpInfo", "", "getSocialInfo", "getWormholeData", "getWormholeId", "hasOnlyTwoVideoFeeds", "isTwoItemVideoFeed", "isWeishiGridTwoItemFeed", "makeDislikeParam", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeParam;", "dislikeInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/dislike/DislikeInfo;", "rowkey", "setSearchWordInfo", "", "title", "rcmds", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Ltencent/im/oidb/search/RequestSearchWord$Rcmd;", "sessionId", "Lcom/tencent/mobileqq/pb/PBStringField;", "kandian_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class BaseArticleInfoKt
{
  @Nullable
  public static final DislikeParam a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ArrayList<DislikeInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$makeDislikeParam");
    return a(paramAbsBaseArticleInfo, paramArrayList, paramAbsBaseArticleInfo.innerUniqueID);
  }
  
  @Nullable
  public static final DislikeParam a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable ArrayList<DislikeInfo> paramArrayList, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$makeDislikeParam");
    DislikeParam localDislikeParam = new DislikeParam();
    if (paramString != null)
    {
      int i;
      if (((CharSequence)paramString).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localDislikeParam.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    localDislikeParam.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mArticleID;
    localDislikeParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      localDislikeParam.b = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      localDislikeParam.c = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
    }
    if (RIJFeedsType.C(paramAbsBaseArticleInfo))
    {
      localDislikeParam.c = paramAbsBaseArticleInfo.mPolymericInfo.b;
      localDislikeParam.d = paramAbsBaseArticleInfo.mPolymericInfo.f;
      localDislikeParam.jdField_a_of_type_Long = 0L;
    }
    return localDislikeParam;
  }
  
  @Nullable
  public static final String a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$getWormholeData");
    if (paramAbsBaseArticleInfo.wormholeData != null) {
      return paramAbsBaseArticleInfo.wormholeData;
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("feeds_type", paramAbsBaseArticleInfo.mFeedType).put("feeds_id", paramAbsBaseArticleInfo.mFeedId).put("rowkey", paramAbsBaseArticleInfo.innerUniqueID).put("article_id", String.valueOf(paramAbsBaseArticleInfo.mArticleID)).put("article_title", paramAbsBaseArticleInfo.mTitle).put("video_json", paramAbsBaseArticleInfo.mJsonVideoList).put("article_content_url", paramAbsBaseArticleInfo.mArticleContentUrl).put("comment_count", paramAbsBaseArticleInfo.mCommentCount).put("share_count", paramAbsBaseArticleInfo.mShareCount).put("video_comment_count", paramAbsBaseArticleInfo.mVideoCommentCount).put("firstpage_pic_url", paramAbsBaseArticleInfo.mFirstPagePicUrl).put("video_logo_url", paramAbsBaseArticleInfo.mVideoLogoUrl).put("socialize_info", c(paramAbsBaseArticleInfo)).put("bind_json", paramAbsBaseArticleInfo.proteusItemsData).put("video_play_count", paramAbsBaseArticleInfo.mVideoPlayCount).put("ads_jump_url", paramAbsBaseArticleInfo.mVideoAdsJumpUrl).put("ads_jump_type", paramAbsBaseArticleInfo.mVideoAdsJumpType).put("ads_source", paramAbsBaseArticleInfo.mVideoAdsSource).put("channel_id", paramAbsBaseArticleInfo.mChannelID).put("algorithm_id", paramAbsBaseArticleInfo.mAlgorithmID).put("strategy_id", paramAbsBaseArticleInfo.mStrategyId).put("article_type", paramAbsBaseArticleInfo.mArticleType).put("recommend_time", paramAbsBaseArticleInfo.mRecommendTime).put("recommend_seq", paramAbsBaseArticleInfo.mRecommendSeq).put("article_time", paramAbsBaseArticleInfo.mTime).put("article_style", b(paramAbsBaseArticleInfo));
      localJSONObject2 = new JSONObject().put("id", b(paramAbsBaseArticleInfo)).put("param", localJSONObject2);
      Intrinsics.checkExpressionValueIsNotNull(localJSONObject2, "JSONObject()\n           …     .put(\"param\", param)");
      localJSONObject1.put("loadInstance", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createDataError: ");
      localStringBuilder.append(localJSONException.getMessage());
      ViolaLogUtils.e("Q.readinjoy.AbsBaseArticleInfo", localStringBuilder.toString());
    }
    paramAbsBaseArticleInfo.wormholeData = localJSONObject1.toString();
    return paramAbsBaseArticleInfo.wormholeData;
  }
  
  public static final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable String paramString, @Nullable PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, @Nullable PBStringField paramPBStringField)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$setSearchWordInfo");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramAbsBaseArticleInfo.mSearchWordTitle = ((String)null);
      paramAbsBaseArticleInfo.mSearchWords.clear();
      return;
    }
    Object localObject1 = Aladdin.getConfig(201);
    if (localObject1 != null) {
      paramAbsBaseArticleInfo.mSearchWordTitle = ((AladdinConfig)localObject1).getString("feeds_searchterm_text", paramString);
    }
    paramAbsBaseArticleInfo.mSearchWords.clear();
    localObject1 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (localObject1 != null)
    {
      localObject1 = (QQAppInterface)localObject1;
      Paint localPaint = new Paint();
      Object localObject2 = ((QQAppInterface)localObject1).getApp();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.app");
      localPaint.setTextSize(AIOUtils.b(14.0F, ((BaseApplication)localObject2).getResources()));
      int j = (int)DeviceInfoUtil.k();
      localObject2 = ((QQAppInterface)localObject1).getApp();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.app");
      int k = AIOUtils.b(14.0F, ((BaseApplication)localObject2).getResources());
      int m = (int)localPaint.measureText(paramString);
      if ((paramPBStringField != null) && (paramPBStringField.has() == true))
      {
        paramString = paramPBStringField.get();
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(((QQAppInterface)localObject1).getCurrentAccountUin());
        paramString.append(System.currentTimeMillis());
        paramString = paramString.toString();
      }
      paramAbsBaseArticleInfo.mSearchWordSessionId = paramString;
      int i = 0;
      j = j - k - m;
      paramString = "";
      while (i <= 3)
      {
        paramPBStringField = paramString;
        k = j;
        if (paramPBRepeatMessageField != null)
        {
          localObject2 = paramPBRepeatMessageField.get();
          paramPBStringField = paramString;
          k = j;
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            paramPBStringField = paramString;
            k = j;
            if (localObject2 != null) {
              for (;;)
              {
                paramPBStringField = paramString;
                k = j;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                RequestSearchWord.Rcmd localRcmd = (RequestSearchWord.Rcmd)((Iterator)localObject2).next();
                k = (int)localPaint.measureText(localRcmd.word.get().toStringUtf8());
                paramPBStringField = ((QQAppInterface)localObject1).getApp();
                Intrinsics.checkExpressionValueIsNotNull(paramPBStringField, "app.app");
                k += AIOUtils.b(38.0F, paramPBStringField.getResources());
                if (j - k > 0)
                {
                  paramPBStringField = new StringBuilder();
                  paramPBStringField.append(paramString);
                  if (TextUtils.isEmpty((CharSequence)paramString))
                  {
                    paramString = localRcmd.word.get().toStringUtf8();
                  }
                  else
                  {
                    paramString = new StringBuilder();
                    paramString.append("::");
                    paramString.append(localRcmd.word.get().toStringUtf8());
                    paramString = paramString.toString();
                  }
                  paramPBStringField.append(paramString);
                  paramPBStringField = paramPBStringField.toString();
                  paramString = ((QQAppInterface)localObject1).getApp();
                  Intrinsics.checkExpressionValueIsNotNull(paramString, "app.app");
                  k = j - (k - AIOUtils.b(14.0F, paramString.getResources()));
                  paramAbsBaseArticleInfo.mSearchWords.add(localRcmd);
                  ((Iterator)localObject2).remove();
                  break;
                }
              }
            }
          }
        }
        i += 1;
        paramString = paramPBStringField;
        j = k;
      }
      if (paramAbsBaseArticleInfo.innerUniqueID != null) {
        paramPBRepeatMessageField = ByteStringMicro.copyFromUtf8(paramAbsBaseArticleInfo.innerUniqueID).toStringUtf8();
      } else {
        paramPBRepeatMessageField = " ";
      }
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("exp_Kdfeedsback_list").obj1("2049").ver2("Kdfeedsback").ver3(paramAbsBaseArticleInfo.mArticleContentUrl).ver4(paramString).ver5(paramAbsBaseArticleInfo.mTitle).ver6(paramPBRepeatMessageField).session_id(paramAbsBaseArticleInfo.mSearchWordSessionId));
      paramPBStringField = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(paramPBStringField, "BaseApplicationImpl.getApplication()");
      paramPBStringField = paramPBStringField.getRuntime();
      if (paramPBStringField != null)
      {
        paramPBStringField = ((QQAppInterface)paramPBStringField).getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
        if (paramPBStringField != null)
        {
          paramPBStringField = (UniteSearchHandler)paramPBStringField;
          localObject1 = BaseApplicationImpl.getApplication();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
          localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
          if (localObject1 != null)
          {
            paramPBStringField.a((QQAppInterface)localObject1, "exp_Kdfeedsback_list", paramAbsBaseArticleInfo.mSearchWordSessionId, paramAbsBaseArticleInfo.mArticleContentUrl, paramString, paramAbsBaseArticleInfo.mTitle, paramPBRepeatMessageField);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.UniteSearchHandler");
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramAbsBaseArticleInfo = new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    for (;;)
    {
      throw paramAbsBaseArticleInfo;
    }
  }
  
  public static final boolean a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$hasOnlyTwoVideoFeeds");
    boolean bool1 = RIJFeedsType.a(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    if ((!bool1) && (!RIJFeedsType.g(paramAbsBaseArticleInfo))) {
      return false;
    }
    bool1 = bool2;
    if (paramAbsBaseArticleInfo.mSubArticleList != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSubArticleList.size() == 1)
      {
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.get(0);
        Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "mSubArticleList[0]");
        paramAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo;
        if (!RIJFeedsType.a(paramAbsBaseArticleInfo))
        {
          bool1 = bool2;
          if (!RIJFeedsType.g(paramAbsBaseArticleInfo)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public static final String b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$getWormholeId");
    if (paramAbsBaseArticleInfo.wormholeId == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramAbsBaseArticleInfo.mChannelID));
      localStringBuilder.append("_");
      localStringBuilder.append(paramAbsBaseArticleInfo.articleStyle);
      localStringBuilder.append("_");
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      paramAbsBaseArticleInfo.wormholeId = localStringBuilder.toString();
    }
    return paramAbsBaseArticleInfo.wormholeId;
  }
  
  public static final boolean b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$isTwoItemVideoFeed");
    if (paramAbsBaseArticleInfo.mChannelID == 40677) {
      return false;
    }
    return a(paramAbsBaseArticleInfo);
  }
  
  private static final String c(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("like_count", paramAbsBaseArticleInfo.mSocialFeedInfo.b).put("myself_like_status", paramAbsBaseArticleInfo.mSocialFeedInfo.c).put("comments_count", paramAbsBaseArticleInfo.mSocialFeedInfo.d).put("biu_count", paramAbsBaseArticleInfo.mSocialFeedInfo.f).put("follow_status", paramAbsBaseArticleInfo.mSocialFeedInfo.h).put("follow_count", paramAbsBaseArticleInfo.mSocialFeedInfo.i).put("card_jump_info", d(paramAbsBaseArticleInfo));
    return localJSONObject.toString();
  }
  
  public static final boolean c(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "$this$isWeishiGridTwoItemFeed");
    if (paramAbsBaseArticleInfo.mChannelID == 40677) {
      return a(paramAbsBaseArticleInfo);
    }
    return false;
  }
  
  private static final String d(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("card_jump_url", paramAbsBaseArticleInfo.mCardJumpUrl);
    return localJSONObject.toString();
  }
  
  public static final boolean d(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    if ((paramAbsBaseArticleInfo.mExtraBiuBriefInfo != null) && (!paramAbsBaseArticleInfo.isExtraBiuExpanded) && (paramAbsBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList;
      Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "articleInfo.mExtraBiuBriefInfo.biuBriefInfoItems");
      if ((((Collection)paramAbsBaseArticleInfo).isEmpty() ^ true)) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean e(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    if ((paramAbsBaseArticleInfo.mExtraBiuBriefInfo != null) && (paramAbsBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList;
      Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "articleInfo.mExtraBiuBriefInfo.biuBriefInfoItems");
      if ((((Collection)paramAbsBaseArticleInfo).isEmpty() ^ true)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt
 * JD-Core Version:    0.7.0.1
 */