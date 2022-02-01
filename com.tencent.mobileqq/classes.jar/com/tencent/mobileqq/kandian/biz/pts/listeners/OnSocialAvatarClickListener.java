package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class OnSocialAvatarClickListener
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public OnSocialAvatarClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public static OnSocialAvatarClickListener.SocialAvatarData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = new OnSocialAvatarClickListener.SocialAvatarData();
    if (paramAbsBaseArticleInfo == null) {
      return localSocialAvatarData;
    }
    boolean bool1 = RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo);
    int n = 0;
    int i;
    if ((paramInt != 77) && (paramInt != 78)) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool2 = RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo);
    int j;
    if ((paramInt != 72) && (paramInt != 74)) {
      j = 0;
    } else {
      j = 1;
    }
    int k;
    if (paramInt == 76) {
      k = 1;
    } else {
      k = 0;
    }
    boolean bool3 = RIJItemViewTypeUtils.h(paramAbsBaseArticleInfo);
    boolean bool4 = RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo);
    int m;
    if ((paramInt != 73) && (paramInt != 75)) {
      m = 0;
    } else {
      m = 1;
    }
    if (paramInt == 147) {
      n = 1;
    }
    if ((!bool1) && (i == 0))
    {
      if ((!bool2) && (j == 0))
      {
        if (((k != 0) || (bool3) || (bool4) || (m != 0) || (n != 0)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null)) {
          a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
        }
      }
      else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
      }
    }
    else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
      a(localSocialAvatarData, paramAbsBaseArticleInfo.mSubscribeID);
    }
    if (TextUtils.isEmpty(localSocialAvatarData.jdField_a_of_type_JavaLangString)) {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSubscribeID);
      } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long);
      } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
      }
    }
    localSocialAvatarData.jdField_a_of_type_JavaLangString = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, localSocialAvatarData.jdField_a_of_type_JavaLangString, ReadinjoyReportUtils.e);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin = ");
    localStringBuilder.append(localSocialAvatarData.jdField_a_of_type_Long);
    localStringBuilder.append(" url = ");
    localStringBuilder.append(localSocialAvatarData.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" articleID = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
    QLog.d("OnSocialAvatarClickListener", 1, localStringBuilder.toString());
    return localSocialAvatarData;
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = a(paramAbsBaseArticleInfo, paramInt);
    if (!TextUtils.isEmpty(localSocialAvatarData.jdField_a_of_type_JavaLangString))
    {
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      ReadInJoyUtils.a(paramContext, localSocialAvatarData.jdField_a_of_type_JavaLangString);
      a(paramAbsBaseArticleInfo, RIJFeedsType.c(paramAbsBaseArticleInfo), localSocialAvatarData.jdField_a_of_type_Long);
    }
  }
  
  @VisibleForTesting
  static void a(@NotNull OnSocialAvatarClickListener.SocialAvatarData paramSocialAvatarData, long paramLong)
  {
    paramSocialAvatarData.jdField_a_of_type_Long = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.g);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramSocialAvatarData.jdField_a_of_type_Long).getBytes(), 2));
    paramSocialAvatarData.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  @VisibleForTesting
  static void a(@NotNull OnSocialAvatarClickListener.SocialAvatarData paramSocialAvatarData, @NotNull String paramString)
  {
    try
    {
      paramSocialAvatarData.jdField_a_of_type_Long = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new StringBuilder();
    paramString.append(ReadInJoyConstants.k);
    paramString.append(Base64Util.encodeToString(String.valueOf(paramSocialAvatarData.jdField_a_of_type_Long).getBytes(), 2));
    paramSocialAvatarData.jdField_a_of_type_JavaLangString = paramString.toString();
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo))
    {
      OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = a(paramAbsBaseArticleInfo, paramInt);
      a(paramAbsBaseArticleInfo, RIJFeedsType.c(paramAbsBaseArticleInfo), localSocialAvatarData.jdField_a_of_type_Long);
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, long paramLong)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    Object localObject;
    if (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) {
      localObject = "3";
    } else if (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) {
      localObject = "4";
    } else {
      localObject = "1";
    }
    String str = RIJTransMergeKanDianReport.a((String)localObject, paramAbsBaseArticleInfo, paramLong);
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
      localObject = "0X800935C";
    } else {
      localObject = "0X8007BA3";
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    long l1 = paramAbsBaseArticleInfo.mFeedId;
    long l2 = paramAbsBaseArticleInfo.mArticleID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(paramLong), (String)localObject, (String)localObject, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str, false);
    for (;;)
    {
      try
      {
        localObject = RIJTransMergeKanDianReport.a();
        ((JSONObject)localObject).put("feeds_source", paramString);
        ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.a());
        paramString = RIJFeedsType.d(paramAbsBaseArticleInfo);
        if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID))
        {
          paramAbsBaseArticleInfo = "0X8009357";
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", paramAbsBaseArticleInfo, paramAbsBaseArticleInfo, 0, 0, paramString, "", "", ((JSONObject)localObject).toString(), false);
          return;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        return;
      }
      paramAbsBaseArticleInfo = "0X800744D";
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_Int);
    paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramViewBase != null) && (paramViewBase.mChannelID == 0L)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ENTER, 0, 0, 0), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialAvatarClickListener
 * JD-Core Version:    0.7.0.1
 */