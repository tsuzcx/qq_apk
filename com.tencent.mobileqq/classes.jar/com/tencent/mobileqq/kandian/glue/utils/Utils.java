package com.tencent.mobileqq.kandian.glue.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ShortContentWithLinkSpan;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.text.UserSpan;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.OutsideLinkInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Utils
{
  public static IReadInJoyModel a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return new ReadInJoyModelImpl(null, paramAbsBaseArticleInfo, RIJBaseItemViewType.c(paramAbsBaseArticleInfo), (int)paramAbsBaseArticleInfo.mChannelID, 0, 0, false, 0, null, null);
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ReadInJoyUserInfoModule.a(paramLong, paramRefreshUserInfoCallBack, ReadInJoyUserInfoModule.d()));
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.articleViewModel.c)) {
      paramRefreshUserInfoCallBack = " ";
    } else {
      paramRefreshUserInfoCallBack = "：";
    }
    ((StringBuilder)localObject).append(paramRefreshUserInfoCallBack);
    localObject = ((StringBuilder)localObject).toString();
    paramRefreshUserInfoCallBack = new SpannableStringBuilder((CharSequence)localObject);
    paramRefreshUserInfoCallBack.append(paramCharSequence);
    paramRefreshUserInfoCallBack.setSpan(new UserSpan(paramLong, "2", paramAbsBaseArticleInfo, paramInt), 0, ((String)localObject).length(), 18);
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("addPreAuthor: ");
    paramCharSequence.append(paramRefreshUserInfoCallBack);
    paramCharSequence.append(", linkTextColor: ");
    paramCharSequence.append(paramInt);
    QLog.d("Utils", 1, paramCharSequence.toString());
    return paramRefreshUserInfoCallBack;
  }
  
  public static CharSequence a(int paramInt, CharSequence paramCharSequence, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramAbsBaseArticleInfo != null)
    {
      localCharSequence = paramCharSequence;
      if (paramAbsBaseArticleInfo.articleViewModel != null)
      {
        localCharSequence = paramCharSequence;
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.articleViewModel.c)) {
          localCharSequence = a(paramCharSequence, paramAbsBaseArticleInfo.articleViewModel.c);
        }
        if (paramAbsBaseArticleInfo.articleViewModel.b != 0L) {
          paramCharSequence = a(paramInt, localCharSequence, paramAbsBaseArticleInfo.articleViewModel.b, paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
        } else {
          paramCharSequence = localCharSequence;
        }
        localCharSequence = paramCharSequence;
        if (paramAbsBaseArticleInfo.articleViewModel.a != 0) {
          localCharSequence = a(paramCharSequence, paramAbsBaseArticleInfo.articleViewModel.a);
        }
      }
    }
    return new QQText(localCharSequence, 3, 16);
  }
  
  public static CharSequence a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    Object localObject1 = "";
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    int i = RIJBaseItemViewType.c(paramAbsBaseArticleInfo);
    int m = 1;
    if ((i != 18) && (i != 19) && (i != 31) && (i != 32)) {
      if (i != 34) {
        if ((i == 48) || (i == 64) || (i == 65)) {}
      }
    }
    switch (i)
    {
    default: 
      for (i = 0;; i = 1)
      {
        j = 0;
        k = 0;
        break;
      }
    case 85: 
      i = 1;
      break;
    case 83: 
    case 84: 
    case 86: 
      i = 0;
    }
    int n = 0;
    int k = 1;
    int j = i;
    i = n;
    Object localObject2;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      if (paramAbsBaseArticleInfo.isPGCShortContent())
      {
        i = 9;
        localObject1 = a(paramAbsBaseArticleInfo, "");
        break label437;
      }
      if (i != 0)
      {
        localObject1 = paramAbsBaseArticleInfo.mTitle;
        i = m;
        break label437;
      }
      if ((!RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo)))
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.s == null) {
          break label435;
        }
        localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo.s;
        if (RIJFeedsType.a((UGCFeedsInfo)localObject2))
        {
          localObject1 = SocializeFeedsInfoUtils.a(paramAbsBaseArticleInfo, "3", paramRefreshUserInfoCallBack, ((UGCFeedsInfo)localObject2).h.a);
          i = 6;
          break label437;
        }
        if ((CmpCtxt.c(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)))
        {
          localObject2 = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.get(0)).e;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label435;
          }
          localObject1 = a((String)localObject2);
          i = 7;
          break label437;
        }
        if (TextUtils.isEmpty(((UGCFeedsInfo)localObject2).f)) {
          break label435;
        }
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = EmotionCodecUtils.c(((UGCFeedsInfo)localObject2).f);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label336:
      break label336;
    }
    localObject1 = new QQText((CharSequence)localObject1, 3, 16);
    i = 8;
    break label437;
    if (j != 0)
    {
      localObject1 = c(paramAbsBaseArticleInfo);
      i = 2;
    }
    else if (k != 0)
    {
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) {
        localObject1 = paramAbsBaseArticleInfo.mTitle;
      } else {
        localObject1 = paramAbsBaseArticleInfo.mSummary;
      }
      i = 3;
    }
    else if (RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo))
    {
      localObject1 = b(paramAbsBaseArticleInfo);
      i = 4;
    }
    else
    {
      localObject1 = paramAbsBaseArticleInfo.mSummary;
      i = 5;
      break label437;
      label435:
      i = 0;
    }
    label437:
    paramRefreshUserInfoCallBack = a((CharSequence)localObject1, paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("makeNonBiuComment: ");
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo.rawkey);
    ((StringBuilder)localObject1).append(" ssb: ");
    ((StringBuilder)localObject1).append(paramRefreshUserInfoCallBack);
    ((StringBuilder)localObject1).append(" condition flag: ");
    ((StringBuilder)localObject1).append(i);
    QLog.d("Utils", 2, ((StringBuilder)localObject1).toString());
    return paramRefreshUserInfoCallBack;
  }
  
  private static CharSequence a(AbsBaseArticleInfo paramAbsBaseArticleInfo, CharSequence paramCharSequence)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c)))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 19191924) {
        try
        {
          paramAbsBaseArticleInfo = ShortContentWithLinkSpan.a(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c, paramAbsBaseArticleInfo.mSocialFeedInfo.L.d.b, paramAbsBaseArticleInfo.mSocialFeedInfo.L.d.a, paramAbsBaseArticleInfo.mSocialFeedInfo.L.d.c, paramAbsBaseArticleInfo);
          return paramAbsBaseArticleInfo;
        }
        catch (NullPointerException paramAbsBaseArticleInfo)
        {
          QLog.e("Utils", 2, paramAbsBaseArticleInfo.toString());
          return paramCharSequence;
        }
      }
      return paramAbsBaseArticleInfo.mSocialFeedInfo.t.c;
    }
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle))) {
      return paramAbsBaseArticleInfo.mTitle;
    }
    return "";
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localSpannableStringBuilder.append(" ");
      i += 1;
    }
    localSpannableStringBuilder.append(paramCharSequence);
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("addPreBlank: ");
    paramCharSequence.append(localSpannableStringBuilder);
    QLog.d("Utils", 1, paramCharSequence.toString());
    return localSpannableStringBuilder;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return a(-15504151, paramCharSequence, paramAbsBaseArticleInfo, paramRefreshUserInfoCallBack);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.append(paramCharSequence);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-6908266), 0, paramString.length(), 18);
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("addPreCommentText: ");
    paramCharSequence.append(localSpannableStringBuilder);
    QLog.d("Utils", 1, paramCharSequence.toString());
    return localSpannableStringBuilder;
  }
  
  @NotNull
  private static CharSequence a(String paramString)
  {
    String str2 = ReadInJoyDisplayUtils.a(paramString);
    String str1 = str2;
    if (TextUtils.equals(str2, paramString)) {
      str1 = EmotionCodecUtils.c(paramString);
    }
    return new QQText(str1, 3, 16);
  }
  
  @NotNull
  private static CharSequence b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131913242));
    if (!RIJItemViewTypeUtils.z(paramAbsBaseArticleInfo))
    {
      TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.v.g.get(0);
      localStringBuilder.append("“");
      boolean bool = TextUtils.isEmpty(localTopicRecommendInfo.d);
      String str = "";
      if (bool) {
        paramAbsBaseArticleInfo = "";
      } else {
        paramAbsBaseArticleInfo = localTopicRecommendInfo.d;
      }
      localStringBuilder.append(paramAbsBaseArticleInfo);
      if (TextUtils.isEmpty(localTopicRecommendInfo.b)) {
        paramAbsBaseArticleInfo = str;
      } else {
        paramAbsBaseArticleInfo = localTopicRecommendInfo.b;
      }
      localStringBuilder.append(paramAbsBaseArticleInfo);
      localStringBuilder.append("”");
    }
    return localStringBuilder;
  }
  
  @NotNull
  private static CharSequence c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.c != null))
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Comment String: ");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
        return localSpannableStringBuilder;
      }
    }
    else if (paramAbsBaseArticleInfo.mTitle != null)
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    }
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.utils.Utils
 * JD-Core Version:    0.7.0.1
 */