package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class OnSocialAvatarClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  private int c;
  
  public OnSocialAvatarClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramInt;
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
        if (((k != 0) || (bool3) || (bool4) || (m != 0) || (n != 0)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)) {
          a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.c.a);
        }
      }
      else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
      }
    }
    else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
      a(localSocialAvatarData, paramAbsBaseArticleInfo.mSubscribeID);
    }
    if (TextUtils.isEmpty(localSocialAvatarData.b)) {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSubscribeID);
      } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.s.e);
      } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)) {
        a(localSocialAvatarData, paramAbsBaseArticleInfo.mSocialFeedInfo.c.a);
      }
    }
    localSocialAvatarData.b = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, localSocialAvatarData.b, ReadinjoyReportUtils.e);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin = ");
    localStringBuilder.append(localSocialAvatarData.a);
    localStringBuilder.append(" url = ");
    localStringBuilder.append(localSocialAvatarData.b);
    localStringBuilder.append(" articleID = ");
    localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
    QLog.d("OnSocialAvatarClickListener", 1, localStringBuilder.toString());
    return localSocialAvatarData;
  }
  
  public static void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = a(paramAbsBaseArticleInfo, paramInt);
    if (!TextUtils.isEmpty(localSocialAvatarData.b))
    {
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramAbsBaseArticleInfo;
      ReadInJoyUtils.a(paramContext, localSocialAvatarData.b);
      a(paramAbsBaseArticleInfo, RIJFeedsType.k(paramAbsBaseArticleInfo), localSocialAvatarData.a);
    }
  }
  
  @VisibleForTesting
  static void a(@NotNull OnSocialAvatarClickListener.SocialAvatarData paramSocialAvatarData, long paramLong)
  {
    paramSocialAvatarData.a = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.h);
    localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramSocialAvatarData.a).getBytes(), 2));
    paramSocialAvatarData.b = localStringBuilder.toString();
  }
  
  @VisibleForTesting
  static void a(@NotNull OnSocialAvatarClickListener.SocialAvatarData paramSocialAvatarData, @NotNull String paramString)
  {
    try
    {
      paramSocialAvatarData.a = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new StringBuilder();
    paramString.append(ReadInJoyConstants.l);
    paramString.append(Base64Util.encodeToString(String.valueOf(paramSocialAvatarData.a).getBytes(), 2));
    paramSocialAvatarData.b = paramString.toString();
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
    if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
      localObject = "0X800935C";
    } else {
      localObject = "0X8007BA3";
    }
    long l1 = paramAbsBaseArticleInfo.mFeedId;
    long l2 = paramAbsBaseArticleInfo.mArticleID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
    PublicAccountReportUtils.a(null, String.valueOf(paramLong), (String)localObject, (String)localObject, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str, false);
    for (;;)
    {
      try
      {
        localObject = RIJTransMergeKanDianReport.d();
        ((JSONObject)localObject).put("feeds_source", paramString);
        ((JSONObject)localObject).put("kandian_mode", RIJAppSetting.b());
        paramString = RIJFeedsType.m(paramAbsBaseArticleInfo);
        if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID))
        {
          paramAbsBaseArticleInfo = "0X8009357";
          PublicAccountReportUtils.a(null, "CliOper", "", "", paramAbsBaseArticleInfo, paramAbsBaseArticleInfo, 0, 0, paramString, "", "", ((JSONObject)localObject).toString(), false);
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
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (RIJItemViewTypeUtils.E(paramAbsBaseArticleInfo))
    {
      OnSocialAvatarClickListener.SocialAvatarData localSocialAvatarData = a(paramAbsBaseArticleInfo, paramInt);
      a(paramAbsBaseArticleInfo, RIJFeedsType.k(paramAbsBaseArticleInfo), localSocialAvatarData.a);
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    a(this.b, this.a, this.c);
    paramViewBase = this.a;
    if ((paramViewBase != null) && (paramViewBase.mChannelID == 0L)) {
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(this.a.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_ENTER, 0, 0, 0), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialAvatarClickListener
 * JD-Core Version:    0.7.0.1
 */