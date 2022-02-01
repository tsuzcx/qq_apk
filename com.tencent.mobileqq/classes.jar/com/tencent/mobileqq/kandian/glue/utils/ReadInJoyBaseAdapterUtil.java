package com.tencent.mobileqq.kandian.glue.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJFeedsFluencyOptimizeUtil;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/utils/ReadInJoyBaseAdapterUtil;", "", "()V", "getBaseItemViewType", "", "article", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelType", "useCache", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyBaseAdapterUtil
{
  public static final ReadInJoyBaseAdapterUtil a = new ReadInJoyBaseAdapterUtil();
  
  public final int a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0;
    }
    if (paramBoolean)
    {
      i = RIJFeedsFluencyOptimizeUtil.a.a(paramAbsBaseArticleInfo);
      if (i != -1) {
        return i;
      }
    }
    PTSLiteSwitchManager localPTSLiteSwitchManager = PTSLiteSwitchManager.a();
    Intrinsics.checkExpressionValueIsNotNull(localPTSLiteSwitchManager, "PTSLiteSwitchManager.getInstance()");
    if ((localPTSLiteSwitchManager.b()) && (PTSLiteItemViewBuilder.c(paramAbsBaseArticleInfo))) {
      return PTSLiteItemViewBuilder.a(paramAbsBaseArticleInfo);
    }
    if (DynamicItemViewHelper.a(paramAbsBaseArticleInfo)) {
      return ReadInJoyBaseAdapter.t.c(paramAbsBaseArticleInfo);
    }
    if (RIJItemViewTypeUtils.E(paramAbsBaseArticleInfo)) {
      return 147;
    }
    int j = paramAbsBaseArticleInfo.mFeedType;
    int i = 2;
    if (j == 20)
    {
      paramInt = 82;
      if (paramAbsBaseArticleInfo.mRecommendFollowInfos != null)
      {
        paramInt = paramAbsBaseArticleInfo.mRecommendFollowInfos.d;
        if (paramInt != 0)
        {
          if (paramInt == 1) {
            break label140;
          }
          if (paramInt == 2) {}
        }
        else
        {
          return 82;
        }
        return 88;
        label140:
        paramInt = 87;
      }
      return paramInt;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 36)
    {
      if (paramAbsBaseArticleInfo.isPGCShortContent()) {
        return 139;
      }
      if (RIJFeedsType.Y(paramAbsBaseArticleInfo)) {
        return 138;
      }
      return 137;
    }
    if ((paramAbsBaseArticleInfo.mFeedType != 21) && (paramAbsBaseArticleInfo.mFeedType != 22))
    {
      if (paramAbsBaseArticleInfo.mFeedType == 28) {
        return 93;
      }
      if (paramAbsBaseArticleInfo.mFeedType == 24) {
        return RIJFeedsType.Q(paramAbsBaseArticleInfo);
      }
      if (paramAbsBaseArticleInfo.mFeedType == 34) {
        return 123;
      }
      if ((paramAbsBaseArticleInfo.mGroupSubArticleList != null) && (paramAbsBaseArticleInfo.mFeedType != 29)) {
        return 53;
      }
      if (paramAbsBaseArticleInfo.mFeedType == 25) {
        return 89;
      }
      if (paramAbsBaseArticleInfo.mFeedType == 15) {
        return 38;
      }
      if ((paramAbsBaseArticleInfo.mFeedType != 3) && (paramAbsBaseArticleInfo.mFeedType != 13))
      {
        if (paramAbsBaseArticleInfo.mFeedType == 30) {
          return 107;
        }
        int k = paramAbsBaseArticleInfo.mFeedType;
        j = 6;
        if ((k == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mChannelID != 56))
        {
          i = RIJFeedsType.ac(paramAbsBaseArticleInfo);
          if ((i != 21) && (i != 22))
          {
            if (i == 11) {
              return 33;
            }
            paramBoolean = RIJFeedsType.u(paramAbsBaseArticleInfo);
            paramInt = 12;
            if (paramBoolean)
            {
              paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
              if (paramInt != 1) {
                if (paramInt != 2) {
                  if (paramInt == 9) {}
                }
              }
            }
            label478:
            label628:
            do
            {
              return 12;
              return 35;
              return 27;
              return 10;
              if (RIJFeedsType.v(paramAbsBaseArticleInfo))
              {
                paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.s.a;
                if (paramInt != 1)
                {
                  if ((paramInt == 2) || (paramInt == 3)) {
                    break label478;
                  }
                  if ((paramInt == 4) || (paramInt == 5)) {}
                }
                else
                {
                  return 24;
                }
                break label714;
                return 25;
              }
              else
              {
                if (RIJFeedsType.r(paramAbsBaseArticleInfo))
                {
                  if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0)) {
                    paramInt = ComponentContentGridImage.a(paramAbsBaseArticleInfo.mSocialFeedInfo.t.a.size(), paramAbsBaseArticleInfo.mSocialFeedInfo.b);
                  } else {
                    paramInt = 0;
                  }
                  if (paramInt != 0) {
                    if (paramInt != 1) {
                      if (paramInt != 3)
                      {
                        if (paramInt != 9) {
                          return 0;
                        }
                        return 63;
                      }
                    }
                  }
                  for (;;)
                  {
                    return 62;
                    for (;;)
                    {
                      return 49;
                      paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
                      if (paramInt == 3) {
                        break label628;
                      }
                      if (paramInt != 8)
                      {
                        if (paramInt != 9) {
                          break;
                        }
                        break label585;
                      }
                    }
                  }
                }
                if (i == 25) {
                  return 92;
                }
                if ((i == 27) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.E != null))
                {
                  if (!TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mSocialFeedInfo.E.c)) {
                    return 94;
                  }
                  return 95;
                }
                if ((i != 32) || (paramAbsBaseArticleInfo.mSocialFeedInfo == null) || (paramAbsBaseArticleInfo.mSocialFeedInfo.u == null)) {
                  break label717;
                }
              }
              return 26;
              if (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) {
                break label858;
              }
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.b != 0) {
                break;
              }
            } while (!paramAbsBaseArticleInfo.isPGCShortContent());
            label585:
            label714:
            label717:
            return 112;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 1)
            {
              paramInt = 10;
              if (!paramAbsBaseArticleInfo.isPGCShortContent()) {}
            }
            else
            {
              for (;;)
              {
                return 113;
                if (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 5) {
                  return 11;
                }
                if (paramAbsBaseArticleInfo.mSocialFeedInfo.b != 2) {
                  break;
                }
                paramInt = 27;
                if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                  return paramInt;
                }
              }
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 6) {
                return 28;
              }
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 9)
              {
                paramInt = 35;
                if (paramAbsBaseArticleInfo.isPGCShortContent()) {
                  return 114;
                }
              }
              else
              {
                if (paramAbsBaseArticleInfo.isPGCShortContent()) {
                  paramInt = 112;
                }
                return paramInt;
                label858:
                if (paramAbsBaseArticleInfo.mSocialFeedInfo.s.a == 1)
                {
                  if (paramAbsBaseArticleInfo.mSocialFeedInfo.s.d.size() > 0) {
                    paramInt = 108;
                  } else {
                    paramInt = 24;
                  }
                }
                else if ((paramAbsBaseArticleInfo.mSocialFeedInfo.s.a != 3) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.a != 2)) {
                  paramInt = 26;
                } else if ((paramAbsBaseArticleInfo.mSocialFeedInfo.b == 9) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size() > 1)) {
                  paramInt = 37;
                } else if (paramAbsBaseArticleInfo.mSocialFeedInfo.z != null) {
                  paramInt = 81;
                } else {
                  paramInt = 25;
                }
                return paramInt;
              }
            }
          }
          else
          {
            return RIJFeedsType.a(paramAbsBaseArticleInfo, true);
          }
        }
        else
        {
          if (((paramAbsBaseArticleInfo.mFeedType == 11) || (paramAbsBaseArticleInfo.mFeedType == 14)) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.size() > 0))
          {
            if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.size() > 1) {
              return 30;
            }
            return 29;
          }
          if (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) {
            if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
            {
              paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
              if (paramInt != 0)
              {
                if (paramInt != 1)
                {
                  if (paramInt != 2)
                  {
                    if (paramInt != 3)
                    {
                      if (paramInt != 5)
                      {
                        if (paramInt != 6)
                        {
                          if (paramInt == 8) {
                            break label1228;
                          }
                          if (paramInt != 9)
                          {
                            if ((paramInt != 19191924) || (!paramAbsBaseArticleInfo.isPGCShortContent())) {
                              break label1228;
                            }
                            return 134;
                          }
                          paramInt = 34;
                          if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                            return paramInt;
                          }
                        }
                        else
                        {
                          paramInt = 19;
                          if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                            return paramInt;
                          }
                          return 133;
                        }
                      }
                      else {
                        return 17;
                      }
                    }
                    else {
                      if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                        break label1228;
                      }
                    }
                    return 111;
                  }
                  else
                  {
                    paramInt = 18;
                    if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                      return paramInt;
                    }
                    label1201:
                    return 110;
                  }
                }
                else if (paramAbsBaseArticleInfo.isPGCShortContent()) {
                  return 132;
                }
              }
              else
              {
                paramInt = 20;
                if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                  return paramInt;
                }
                label1225:
                return 109;
              }
            }
          }
          label1228:
          do
          {
            do
            {
              return 16;
              if ((paramAbsBaseArticleInfo.mFeedType == 32) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null)) {
                return 120;
              }
              if ((RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null)) {
                return RIJItemViewTypeUtils.A(paramAbsBaseArticleInfo);
              }
              if ((RIJFeedsType.p(paramAbsBaseArticleInfo)) || (RIJFeedsType.q(paramAbsBaseArticleInfo))) {
                break label2605;
              }
              if ((RIJFeedsType.s(paramAbsBaseArticleInfo)) || (RIJFeedsType.t(paramAbsBaseArticleInfo))) {
                break label2600;
              }
              if (RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo))
              {
                paramInt = 31;
                if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
                  return paramInt;
                }
                paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
                if (paramInt != 0)
                {
                  if (paramInt != 1)
                  {
                    if (paramInt != 2)
                    {
                      if (paramInt != 5)
                      {
                        if (paramInt != 6)
                        {
                          if (paramInt != 9)
                          {
                            paramInt = 86;
                            if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                              return paramInt;
                            }
                            break label1225;
                          }
                          paramInt = 85;
                          if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                            return paramInt;
                          }
                          break;
                        }
                        return 32;
                      }
                      return 84;
                    }
                    paramInt = 31;
                    if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                      return paramInt;
                    }
                    break label1201;
                  }
                  paramInt = 83;
                  if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                    return paramInt;
                  }
                  break;
                }
                paramInt = 86;
                if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
                  return paramInt;
                }
                break label1225;
              }
              if (paramAbsBaseArticleInfo.mFeedType != 23) {
                break label1483;
              }
            } while (paramAbsBaseArticleInfo.mSocialFeedInfo == null);
            paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
            if (paramInt == 3) {
              break label1480;
            }
            if (paramInt == 8) {
              break label1477;
            }
          } while (paramInt != 9);
          return 65;
          label1477:
          return 48;
          label1480:
          return 64;
          label1483:
          if ((paramAbsBaseArticleInfo.mChannelID == 0L) && (paramAbsBaseArticleInfo.mSimpleVideoColumnInfo != null) && (RIJFeedsType.a(paramAbsBaseArticleInfo))) {
            return 128;
          }
          if ((paramAbsBaseArticleInfo.mChannelID == 0L) && (paramAbsBaseArticleInfo.mVideoColumnInfo != null) && (RIJFeedsType.a(paramAbsBaseArticleInfo))) {
            return 118;
          }
          if (paramAbsBaseArticleInfo.multiVideoColumnInfo != null)
          {
            if (paramAbsBaseArticleInfo.columnStyle == 1) {
              return 142;
            }
            if (paramAbsBaseArticleInfo.multiVideoColumnInfo.j) {
              return 125;
            }
            return 124;
          }
          if (paramAbsBaseArticleInfo.mKdLiveInfo != null)
          {
            if (paramAbsBaseArticleInfo.mKdLiveInfo.a == 4) {
              return 130;
            }
            return 129;
          }
          if (BaseArticleInfoKt.c(paramAbsBaseArticleInfo)) {
            return 70;
          }
          if (BaseArticleInfoKt.b(paramAbsBaseArticleInfo))
          {
            if ((paramAbsBaseArticleInfo.mFeedType == 33) && (paramAbsBaseArticleInfo.mChannelID != 56) && (paramAbsBaseArticleInfo.mChannelID != 70)) {
              return 121;
            }
            return 46;
          }
          if ((RIJFeedsType.a(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length >= 3) && (paramAbsBaseArticleInfo.mChannelID == 0L)) {
            return 14;
          }
          if (RIJFeedsType.a(paramAbsBaseArticleInfo))
          {
            if (paramAbsBaseArticleInfo.mVideoType == 0)
            {
              if (RIJQQAppInterfaceUtil.g())
              {
                if ((paramAbsBaseArticleInfo.mChannelID == 56) || (paramInt == 3)) {
                  break label1950;
                }
                if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
                {
                  if (!((AdvertisementInfo)paramAbsBaseArticleInfo).isIMaxAndNewStyle)
                  {
                    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSmallVideo(paramAbsBaseArticleInfo))
                    {
                      paramInt = 151;
                      break label1937;
                    }
                    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSurpriseVideoCard(paramAbsBaseArticleInfo)) {
                      break label1887;
                    }
                    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdShakeVideoCard(paramAbsBaseArticleInfo)) {
                      break label1919;
                    }
                    break label1912;
                  }
                }
                else
                {
                  paramInt = j;
                  if (VideoFeedsHelper.k() != 0) {
                    break label1937;
                  }
                  break label1934;
                }
              }
              else
              {
                if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
                  break label1925;
                }
                if (!((AdvertisementInfo)paramAbsBaseArticleInfo).isIMaxAndNewStyle) {
                  break label1869;
                }
              }
              paramInt = 115;
              break label1937;
              label1869:
              if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdSurpriseVideoCard(paramAbsBaseArticleInfo))
              {
                label1887:
                paramInt = 152;
              }
              else if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdShakeVideoCard(paramAbsBaseArticleInfo))
              {
                label1912:
                paramInt = 153;
              }
              else
              {
                label1919:
                paramInt = 66;
                break label1937;
                paramInt = j;
                if (VideoFeedsHelper.k() == 0) {
                  paramInt = 126;
                }
              }
              label1925:
              label1934:
              label1937:
              return paramInt;
            }
            else
            {
              if (paramAbsBaseArticleInfo.mChannelID != 56) {
                break label1952;
              }
            }
            label1950:
            return 4;
            label1952:
            return 5;
          }
          if (RIJFeedsType.ab(paramAbsBaseArticleInfo))
          {
            if (paramAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 3) {
              return 103;
            }
            if (paramAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 2) {
              return 102;
            }
            return 101;
          }
          if (paramAbsBaseArticleInfo.mShowBigPicture)
          {
            if (paramAbsBaseArticleInfo.mIsGallery == 0)
            {
              if (paramAbsBaseArticleInfo.mTopicPicWHRatio != 0.0D) {
                return 9;
              }
              paramInt = i;
              if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
                paramInt = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBigPicAdapterType((AdvertisementInfo)paramAbsBaseArticleInfo);
              }
              return paramInt;
            }
            if (paramAbsBaseArticleInfo.articleStyle == 3) {
              return 47;
            }
            if (paramAbsBaseArticleInfo.articleStyle == 4) {
              return 60;
            }
            if (paramAbsBaseArticleInfo.articleStyle == 5) {
              return 61;
            }
            if (paramAbsBaseArticleInfo.articleStyle == 6) {
              return 96;
            }
            return 8;
          }
          if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkAdType((AdvertisementInfo)paramAbsBaseArticleInfo))) {
            return 116;
          }
          if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType((AdvertisementInfo)paramAbsBaseArticleInfo))) {
            return 39;
          }
          if (RIJFeedsType.w(paramAbsBaseArticleInfo))
          {
            if (RIJFeedsType.x(paramAbsBaseArticleInfo)) {
              return 91;
            }
            return 90;
          }
          if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isBrandOptimizationAdType((AdvertisementInfo)paramAbsBaseArticleInfo))) {
            return 127;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameAdCardType(paramAbsBaseArticleInfo)) {
            return 140;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGame285(paramAbsBaseArticleInfo)) {
            return 144;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameNewStyle(paramAbsBaseArticleInfo)) {
            return 145;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGameAdCardHorzi(paramAbsBaseArticleInfo)) {
            return 146;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGame65(paramAbsBaseArticleInfo)) {
            return 143;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isMiniGame185(paramAbsBaseArticleInfo)) {
            return 141;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(paramAbsBaseArticleInfo)) {
            return 148;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLivePicCard(paramAbsBaseArticleInfo)) {
            return 149;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandPicCard(paramAbsBaseArticleInfo)) {
            return 150;
          }
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isNoXtabExpandAd(paramAbsBaseArticleInfo)) {
            return 39;
          }
          if ((paramAbsBaseArticleInfo.mPictures != null) && (paramAbsBaseArticleInfo.mPictures.length >= 3))
          {
            if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo)) {
              return 105;
            }
            return 3;
          }
          if (TextUtils.isEmpty((CharSequence)paramAbsBaseArticleInfo.mFirstPagePicUrl)) {
            return 0;
          }
          if (paramAbsBaseArticleInfo.mFeedType == 37) {
            return 135;
          }
          if (paramAbsBaseArticleInfo.mIsGallery == 0)
          {
            if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramAbsBaseArticleInfo))
            {
              if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).hasAddLocationInfo(paramAbsBaseArticleInfo)) {
                return 106;
              }
              return 104;
            }
            return 1;
          }
          return 7;
          label2600:
          return RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo);
          label2605:
          paramInt = 40;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
          {
            paramInt = paramAbsBaseArticleInfo.mSocialFeedInfo.b;
            if (paramInt != 1)
            {
              if ((paramInt == 2) || (paramInt != 9)) {
                return 40;
              }
              return 42;
            }
            return 41;
          }
        }
      }
      else
      {
        return 15;
      }
    }
    else
    {
      paramInt = RIJFeedsType.a(paramAbsBaseArticleInfo, false);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.utils.ReadInJoyBaseAdapterUtil
 * JD-Core Version:    0.7.0.1
 */