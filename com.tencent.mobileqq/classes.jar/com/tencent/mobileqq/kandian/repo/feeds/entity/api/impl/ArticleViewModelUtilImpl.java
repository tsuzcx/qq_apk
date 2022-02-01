package com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.utils.Utils;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IArticleViewModelUtil;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/impl/ArticleViewModelUtilImpl;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IArticleViewModelUtil;", "()V", "JUST_MINS", "", "kotlin.jvm.PlatformType", "getJUST_MINS", "()Ljava/lang/String;", "convertBiuTime", "", "info", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "isRecommendUnFollowedCard", "", "makeBiuComment", "article", "callBack", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "linkTextColor", "", "makeNonBiuComment", "articleInfo", "makeSummaryText", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ArticleViewModelUtilImpl
  implements IArticleViewModelUtil
{
  @Deprecated
  public static final ArticleViewModelUtilImpl.Companion Companion = new ArticleViewModelUtilImpl.Companion(null);
  public static final int MAX_LENGTH = 36;
  private static final String TAG = "ArticleViewModelUtilImpl";
  private final String JUST_MINS = HardCodeUtil.a(2131712679);
  
  @Nullable
  public CharSequence convertBiuTime(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str2 = "";
    if (paramAbsBaseArticleInfo != null)
    {
      long l2 = paramAbsBaseArticleInfo.mTime;
      long l1 = l2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        l1 = l2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.e > 0) {
          l1 = paramAbsBaseArticleInfo.mSocialFeedInfo.e;
        }
      }
      String str1;
      if (l1 > 0L) {
        str1 = ((IReadInJoyTimeUtils)QRoute.api(IReadInJoyTimeUtils.class)).getRelativeDisplayForTime(l1, true);
      } else {
        str1 = this.JUST_MINS;
      }
      Object localObject;
      if ((isRecommendUnFollowedCard(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
      {
        localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      }
      else
      {
        localObject = str2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          localObject = str2;
          if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mSocialFeedInfo.d))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append(" · ");
            ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo.d);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAbsBaseArticleInfo = str1;
      }
      return (CharSequence)RIJStringUtils.a(paramAbsBaseArticleInfo, 36);
    }
    return (CharSequence)"";
  }
  
  public final String getJUST_MINS()
  {
    return this.JUST_MINS;
  }
  
  public final boolean isRecommendUnFollowedCard(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.h == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  public CharSequence makeBiuComment(int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if (paramAbsBaseArticleInfo == null) {
      return (CharSequence)"";
    }
    Object localObject1 = (CharSequence)"";
    Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo;
    int i = 1;
    if (localObject2 != null)
    {
      localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a != null) && (((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.size() > 0) && ((((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.size() != 1) || ((!TextUtils.isEmpty((CharSequence)((BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.get(0)).mBiuComment)) && (!TextUtils.equals((CharSequence)((BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.get(0)).mBiuComment, (CharSequence)":")) && (!TextUtils.equals((CharSequence)((BiuCommentInfo)((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a.get(0)).mBiuComment, (CharSequence)"：")))))
      {
        localObject1 = new SpannableStringBuilder();
        localObject2 = (CharSequence)SocializeFeedsInfoUtils.a(paramInt, paramAbsBaseArticleInfo, "5", paramRefreshUserInfoCallBack, ((SocializeFeedsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
        }
        localObject1 = (CharSequence)localObject1;
        break label381;
      }
      if (!TextUtils.isEmpty((CharSequence)((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString))
      {
        if (((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString.length() >= 100)
        {
          localObject1 = new StringBuilder();
          String str = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString;
          Intrinsics.checkExpressionValueIsNotNull(str, "socializeFeedsInfo.mCommentWording");
          if (str != null)
          {
            str = str.substring(0, 99);
            Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            ((StringBuilder)localObject1).append(str);
            ((StringBuilder)localObject1).append('…');
            ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
        localObject1 = ((SocializeFeedsInfo)localObject2).jdField_a_of_type_JavaLangString;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "socializeFeedsInfo.mCommentWording");
        localObject1 = (CharSequence)localObject1;
        break label381;
      }
    }
    i = 0;
    label381:
    paramRefreshUserInfoCallBack = Utils.a(paramInt, (CharSequence)localObject1, paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
    Intrinsics.checkExpressionValueIsNotNull(paramRefreshUserInfoCallBack, "Utils.addPreText(linkTex…esult, article, callBack)");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("makeBiuComment: ");
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.rawkey);
    ((StringBuilder)localObject1).append(" ssb: ");
    ((StringBuilder)localObject1).append(paramRefreshUserInfoCallBack);
    ((StringBuilder)localObject1).append(" condition flag: ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(", linkTextColor ");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("ArticleViewModelUtilImpl", 2, ((StringBuilder)localObject1).toString());
    return paramRefreshUserInfoCallBack;
  }
  
  @Nullable
  public CharSequence makeBiuComment(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return makeBiuComment(-15504151, paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
  
  @Nullable
  public CharSequence makeNonBiuComment(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return Utils.a(paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
  
  @Nullable
  public CharSequence makeSummaryText(int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("makeSummaryText: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("ArticleViewModelUtilImpl", 1, ((StringBuilder)localObject).toString());
    localObject = new SpannableStringBuilder();
    paramAbsBaseArticleInfo = Utils.a(paramAbsBaseArticleInfo);
    NativeSummaryView.a(paramInt, paramAbsBaseArticleInfo, (SpannableStringBuilder)localObject, paramRefreshUserInfoCallBack);
    NativeSummaryView.a(paramAbsBaseArticleInfo, (SpannableStringBuilder)localObject, paramRefreshUserInfoCallBack);
    return (CharSequence)localObject;
  }
  
  @Nullable
  public CharSequence makeSummaryText(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return makeSummaryText(-15504151, paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl.ArticleViewModelUtilImpl
 * JD-Core Version:    0.7.0.1
 */