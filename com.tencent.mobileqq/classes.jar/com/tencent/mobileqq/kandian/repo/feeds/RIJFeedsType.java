package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AnswerDetailInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJFeedsType
{
  public static List<Integer> a = new ArrayList();
  public static List<Integer> b = new ArrayList();
  public static List<Integer> c = new ArrayList();
  private static String d;
  
  static
  {
    a.add(Integer.valueOf(0));
    Object localObject1 = a;
    Integer localInteger1 = Integer.valueOf(8);
    ((List)localObject1).add(localInteger1);
    Object localObject2 = a;
    localObject1 = Integer.valueOf(12);
    ((List)localObject2).add(localObject1);
    Object localObject3 = a;
    localObject2 = Integer.valueOf(16);
    ((List)localObject3).add(localObject2);
    a.add(Integer.valueOf(17));
    Object localObject4 = a;
    localObject3 = Integer.valueOf(10);
    ((List)localObject4).add(localObject3);
    a.add(Integer.valueOf(58));
    List localList = b;
    localObject4 = Integer.valueOf(1);
    localList.add(localObject4);
    b.add(Integer.valueOf(5));
    localList = b;
    Integer localInteger2 = Integer.valueOf(7);
    localList.add(localInteger2);
    b.add(Integer.valueOf(9));
    c.add(localObject4);
    c.add(Integer.valueOf(2));
    c.add(Integer.valueOf(3));
    c.add(localInteger2);
    c.add(localInteger1);
    c.add(localObject3);
    c.add(localObject1);
    c.add(localObject2);
    c.add(Integer.valueOf(18));
    c.add(Integer.valueOf(22));
    c.add(Integer.valueOf(25));
    c.add(Integer.valueOf(27));
    c.add(Integer.valueOf(31));
    c.add(Integer.valueOf(34));
    c.add(Integer.valueOf(35));
    c.add(Integer.valueOf(36));
    c.add(Integer.valueOf(37));
    c.add(Integer.valueOf(83));
    c.add(Integer.valueOf(85));
    c.add(Integer.valueOf(86));
    c.add(Integer.valueOf(107));
    c.add(Integer.valueOf(108));
  }
  
  public static boolean A(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)
        {
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.x == null) {
            return false;
          }
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mFeedType == 21) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean B(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (C(paramAbsBaseArticleInfo)) || (D(paramAbsBaseArticleInfo));
  }
  
  public static boolean C(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null)
          {
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c == null) {
              return false;
            }
            bool1 = bool2;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue() == 21) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean D(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null)
          {
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c == null) {
              return false;
            }
            bool1 = bool2;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue() == 22) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean E(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo.e >= 6);
  }
  
  public static boolean F(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (E(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mIsInPolymeric);
  }
  
  public static boolean G(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (E(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static boolean H(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if ((paramAbsBaseArticleInfo.G == 1) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.H)) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.I))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean I(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (E(paramAbsBaseArticleInfo)) && ((paramAbsBaseArticleInfo.mPolymericInfo.e == 9) || (paramAbsBaseArticleInfo.mPolymericInfo.e == 10) || (paramAbsBaseArticleInfo.mPolymericInfo.e == 11));
  }
  
  public static boolean J(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    NewPolymericInfo localNewPolymericInfo = paramAbsBaseArticleInfo.mNewPolymericInfo;
    boolean bool2 = true;
    int i;
    if (localNewPolymericInfo != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 9) {
        return bool1;
      }
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 10) {
        return bool1;
      }
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 11) {
        return true;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public static boolean K(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 15);
  }
  
  public static boolean L(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 12);
  }
  
  public static boolean M(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 13);
  }
  
  public static boolean N(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    KandianLiveInfo localKandianLiveInfo = paramAbsBaseArticleInfo.mKdLiveInfo;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localKandianLiveInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSubArticleList != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSubArticleList.size() > 0)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSubArticleList.get(0) != null)
          {
            bool1 = bool2;
            if (((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mSubArticleList.get(0)).mKdLiveInfo != null) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean O(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mFeedType == 24) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean P(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 29);
  }
  
  public static int Q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.p != null) && (!paramAbsBaseArticleInfo.mNewPolymericInfo.p.isEmpty()) && (paramAbsBaseArticleInfo.mNewPolymericInfo.a))
    {
      NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.p.get(0);
      if (S(paramAbsBaseArticleInfo)) {
        return 79;
      }
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 15) {
        return 131;
      }
      if (localPackArticleInfo.k == 10) {
        return 78;
      }
      if ((localPackArticleInfo.k != 4) && (localPackArticleInfo.k != 5))
      {
        if ((localPackArticleInfo.k != 6) && (localPackArticleInfo.k != 7) && (localPackArticleInfo.k != 8) && (localPackArticleInfo.k != 9))
        {
          if (localPackArticleInfo.k == 12) {
            return 77;
          }
          if (localPackArticleInfo.k == 0) {
            return 77;
          }
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("新聚合类卡片没有找到对应的FeedCell feedType = ");
          paramAbsBaseArticleInfo.append(localPackArticleInfo.k);
          QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, paramAbsBaseArticleInfo.toString());
        }
        return 77;
      }
      return 76;
    }
    QLog.e("RIJFeedsType", 1, "articleInfo = null");
    return 0;
  }
  
  public static boolean R(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 20) && (paramAbsBaseArticleInfo.mRecommendFollowInfos != null);
  }
  
  public static boolean S(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && ((paramAbsBaseArticleInfo.mNewPolymericInfo.d == 7) || (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 8) || (paramAbsBaseArticleInfo.mNewPolymericInfo.d == 9));
  }
  
  public static String T(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    if (((paramAbsBaseArticleInfo.mFeedType == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 5)) || (a(paramAbsBaseArticleInfo))) {
      return paramAbsBaseArticleInfo.innerUniqueID;
    }
    if ((RIJItemViewTypeUtils.o(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) && (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo.mSocialFeedInfo.s.a))) {
      return paramAbsBaseArticleInfo.innerUniqueID;
    }
    return String.valueOf(paramAbsBaseArticleInfo.mArticleID);
  }
  
  public static boolean U(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType != 29) {
      return a(paramAbsBaseArticleInfo);
    }
    if (paramAbsBaseArticleInfo.mProteusTemplateBean != null) {
      bool = a(ProteusReportUtil.b(paramAbsBaseArticleInfo.mProteusTemplateBean));
    }
    return bool;
  }
  
  public static boolean V(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 36) && (!paramAbsBaseArticleInfo.isPGCShortContent()) && (paramAbsBaseArticleInfo.mSocialFeedInfo.b != 4) && (paramAbsBaseArticleInfo.mSocialFeedInfo.b != 5) && (paramAbsBaseArticleInfo.mSocialFeedInfo.b != 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isImageArticle, style= ");
      localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.b);
      QLog.d("RIJFeedsType", 1, localStringBuilder.toString());
      bool = true;
    }
    else
    {
      bool = false;
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("isImageArticle, flag= ");
    paramAbsBaseArticleInfo.append(bool);
    QLog.d("RIJFeedsType", 1, paramAbsBaseArticleInfo.toString());
    return bool;
  }
  
  public static boolean W(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.isPGCShortContent()) {}
      while (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo))
      {
        bool = true;
        break;
      }
    }
    boolean bool = false;
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("isStructCard, flag= ");
    paramAbsBaseArticleInfo.append(bool);
    QLog.d("RIJFeedsType", 1, paramAbsBaseArticleInfo.toString());
    return bool;
  }
  
  public static boolean X(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      if (!Y(paramAbsBaseArticleInfo)) {
        return false;
      }
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mVideoJsonWidth < paramAbsBaseArticleInfo.mVideoJsonHeight) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean Y(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 36))
    {
      if (a(paramAbsBaseArticleInfo)) {}
      while ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && ((paramAbsBaseArticleInfo.mSocialFeedInfo.b == 4) || (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 5) || (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 6)))
      {
        bool = true;
        break;
      }
    }
    boolean bool = false;
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("isVideoCommentBiu, flag= ");
    paramAbsBaseArticleInfo.append(bool);
    QLog.d("RIJFeedsType", 1, paramAbsBaseArticleInfo.toString());
    return bool;
  }
  
  public static boolean Z(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool;
    if ((paramAbsBaseArticleInfo == null) || (paramAbsBaseArticleInfo.mFeedType != 36) || (paramAbsBaseArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramAbsBaseArticleInfo.getCardJumpUrl()))) {
      bool = false;
    } else {
      bool = true;
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("commentBiuCanJump, canJump= ");
    paramAbsBaseArticleInfo.append(bool);
    QLog.d("RIJFeedsType", 1, paramAbsBaseArticleInfo.toString());
    return bool;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null) && ((paramBoolean) || (paramAbsBaseArticleInfo.mFeedType == 21) || (paramAbsBaseArticleInfo.mFeedType == 22)) && ((!paramBoolean) || (B(paramAbsBaseArticleInfo))))
    {
      if ((paramBoolean) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.i == 3)) {
        return 75;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.s.i == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.i == 4)) {
        return 73;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.s.i == 4) {
        return 72;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error ugcFeedsSrc = ");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.s.i);
        QLog.e("RIJFeedsType", 1, localStringBuilder.toString());
      }
      return 7;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJFeedsType", 1, "something is null.");
    }
    return 7;
  }
  
  public static String a(articlesummary.ChannelInfo paramChannelInfo)
  {
    if (paramChannelInfo == null) {
      return null;
    }
    return paramChannelInfo.bytes_channel_name.get().toStringUtf8();
  }
  
  public static void a(String paramString)
  {
    String str = d;
    if (str != null) {
      TimeSliceHelper.a(str);
    }
    d = paramString;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 5)
    {
      bool1 = bool2;
      if (paramInt != 6)
      {
        int i;
        if (paramInt == 43) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramInt == 18) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((paramInt | i) != 0) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 == 0) {
      return false;
    }
    float f = FeedsSPUtils.b(RIJQQAppInterfaceUtil.e());
    if (f <= 0.0F) {
      f = 0.75F;
    }
    if (paramInt1 / paramInt2 <= f) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 41516L) || (paramLong == 41522L) || (paramLong == 41523L);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.mVideoCoverUrl != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mVideoVid)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    boolean bool3 = E(paramAbsBaseArticleInfo1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (E(paramAbsBaseArticleInfo2))
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo1.mPolymericInfo.h == paramAbsBaseArticleInfo2.mPolymericInfo.h) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(UGCFeedsInfo paramUGCFeedsInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramUGCFeedsInfo != null)
    {
      bool1 = bool2;
      if (paramUGCFeedsInfo.h != null)
      {
        bool1 = bool2;
        if (paramUGCFeedsInfo.h.a != null) {
          if (paramUGCFeedsInfo.h.a.size() <= 1)
          {
            bool1 = bool2;
            if (paramUGCFeedsInfo.h.a.size() == 1)
            {
              bool1 = bool2;
              if (TextUtils.isEmpty(((BiuCommentInfo)paramUGCFeedsInfo.h.a.get(0)).mBiuComment)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, long paramLong, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!FeedsSPUtils.a(RIJQQAppInterfaceUtil.e())) {
      return false;
    }
    if (RIJWebArticleUtil.a.b()) {
      return false;
    }
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if (paramLong == 1000000L) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLUtil.a(paramString);
      if ((paramString.containsKey("article_type")) && (!TextUtils.equals("1", (CharSequence)paramString.get("article_type")))) {
        return false;
      }
    }
    return o(paramAbsBaseArticleInfo);
  }
  
  public static boolean aa(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool;
    if ((paramAbsBaseArticleInfo == null) || (TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID)) || (TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl))) {
      bool = false;
    } else {
      bool = true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("canOpenNativeArticle,articleInfo=");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d("RIJFeedsType", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean ab(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if ((paramAbsBaseArticleInfo.mFeedType == 0) && (paramAbsBaseArticleInfo.mIsGallery > 0) && (paramAbsBaseArticleInfo.mGalleryFeedsInfo != null))
    {
      int i = paramAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
      if ((i == 3) || (i == 2) || (i == 1))
      {
        paramAbsBaseArticleInfo.mIsGalleryChannel = true;
        return true;
      }
    }
    paramAbsBaseArticleInfo.mIsGalleryChannel = false;
    return false;
  }
  
  public static int ac(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((ad(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue();
    }
    return 0;
  }
  
  public static boolean ad(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null);
  }
  
  private static String ae(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo = new ArrayList(((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
    if (paramAbsBaseArticleInfo.size() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramAbsBaseArticleInfo.size())
    {
      localStringBuilder.append(paramAbsBaseArticleInfo.get(i));
      localStringBuilder.append(",");
      i += 1;
    }
    paramAbsBaseArticleInfo = localStringBuilder.toString();
    return paramAbsBaseArticleInfo.substring(0, paramAbsBaseArticleInfo.length() - 1);
  }
  
  private static boolean af(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((!f(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo))) {
      j = 0;
    } else {
      j = 1;
    }
    return (i != 0) && (j != 0);
  }
  
  private static boolean ag(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (UtilsForComponent.c(paramAbsBaseArticleInfo) == 3) || (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.u(paramAbsBaseArticleInfo)) || (l(paramAbsBaseArticleInfo)) || (paramAbsBaseArticleInfo.isPGCShortContent()) || (paramAbsBaseArticleInfo.isAccountShown) || (paramAbsBaseArticleInfo.mKdLiveInfo != null);
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = l(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramAbsBaseArticleInfo = (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.p.get(0);
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.o != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.o.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo.mShowBigPicture)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mIsGallery == 1) {
        if ((paramAbsBaseArticleInfo.articleStyle != 3) && (paramAbsBaseArticleInfo.articleStyle != 4) && (paramAbsBaseArticleInfo.articleStyle != 5) && (paramAbsBaseArticleInfo.articleStyle != 6))
        {
          bool1 = bool2;
          if (!ab(paramAbsBaseArticleInfo)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return paramAbsBaseArticleInfo.mIsPolymericGallery;
  }
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.a.size() > 0);
  }
  
  public static boolean f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    return RIJItemViewTypeUtils.c(RIJBaseItemViewType.c(paramAbsBaseArticleInfo));
  }
  
  public static int g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int k = RIJBaseItemViewType.c(paramAbsBaseArticleInfo);
    RIJUtilsHelper localRIJUtilsHelper = new RIJUtilsHelper(paramAbsBaseArticleInfo);
    int j = localRIJUtilsHelper.a(k, 0);
    int i = j;
    if (UtilsForComponent.c(paramAbsBaseArticleInfo) == 3) {
      i = localRIJUtilsHelper.b(k, j);
    }
    i = localRIJUtilsHelper.a(paramAbsBaseArticleInfo, i);
    if (paramAbsBaseArticleInfo.isTwoItem) {
      i = 43;
    }
    if (BaseArticleInfoKt.e(paramAbsBaseArticleInfo)) {
      i = 69;
    }
    j = localRIJUtilsHelper.d(paramAbsBaseArticleInfo.mFeedType, i);
    i = j;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      i = j;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.L != null) {
        i = localRIJUtilsHelper.c(paramAbsBaseArticleInfo.mSocialFeedInfo.L.a, j);
      }
    }
    if (RIJItemViewTypeUtils.E(paramAbsBaseArticleInfo)) {
      i = 1065;
    }
    return i;
  }
  
  public static String h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c.b())) {
      return "1";
    }
    return "0";
  }
  
  public static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s.a == 6);
  }
  
  public static int j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0;
    }
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.x.a) {
        return 4;
      }
      return 2;
    }
    if (paramAbsBaseArticleInfo.isSuperTopic) {
      return 1;
    }
    return 3;
  }
  
  public static String k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = UtilsForComponent.c(paramAbsBaseArticleInfo);
    int j = 0;
    if (i == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (UtilsForComponent.c(paramAbsBaseArticleInfo) == 1) {
      j = 1;
    }
    if (af(paramAbsBaseArticleInfo)) {
      return String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.c.a);
    }
    if (i != 0) {
      return ae(paramAbsBaseArticleInfo);
    }
    if (j != 0) {
      return ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    if (ag(paramAbsBaseArticleInfo)) {
      return paramAbsBaseArticleInfo.mSubscribeID;
    }
    return "";
  }
  
  public static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return paramAbsBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  public static String m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.isSubscriptFeed()) {
      return "3";
    }
    articlesummary.PackInfo localPackInfo = paramAbsBaseArticleInfo.mPackInfoObj;
    String str2 = "";
    String str1 = str2;
    if (localPackInfo != null)
    {
      if (!paramAbsBaseArticleInfo.mPackInfoObj.pack_type.has()) {
        return "";
      }
      int i = paramAbsBaseArticleInfo.mPackInfoObj.pack_type.get();
      if ((i == 3) && (paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
        return "1";
      }
      str1 = str2;
      if (i == 2)
      {
        str1 = str2;
        if (paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has()) {
          str1 = "2";
        }
      }
    }
    return str1;
  }
  
  public static String n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    if (paramAbsBaseArticleInfo.isSubscriptFeed()) {
      return "1";
    }
    if ((paramAbsBaseArticleInfo.mPackInfoObj != null) && (paramAbsBaseArticleInfo.mPackInfoObj.has()) && (paramAbsBaseArticleInfo.mPackInfoObj.pack_type.get() == 3)) {
      return "2";
    }
    return "";
  }
  
  @VisibleForTesting
  public static boolean o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.isAccountShown) {
      return false;
    }
    if (a.contains(Integer.valueOf(paramAbsBaseArticleInfo.mFeedType))) {
      return true;
    }
    if (!b.contains(Integer.valueOf(paramAbsBaseArticleInfo.mFeedType))) {
      return false;
    }
    int i = RIJBaseItemViewType.c(paramAbsBaseArticleInfo);
    return c.contains(Integer.valueOf(i));
  }
  
  public static boolean p(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 17) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 16) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean r(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() == 23L);
  }
  
  public static boolean s(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 19) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean t(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 18) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean u(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n == null) {
          return false;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() != 17L)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() != 16L) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean v(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n == null) {
          return false;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() != 19L)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() != 18L) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean w(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 26) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean x(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localSocializeFeedsInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.x != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.x.v != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.x.s != null)
          {
            bool1 = bool2;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.x.s.size() > 0)
            {
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.x.v.e != 1) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean y(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool3;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool3;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)
        {
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.x == null) {
            return false;
          }
          if (paramAbsBaseArticleInfo.mFeedType == 21)
          {
            bool1 = bool2;
            if (a(paramAbsBaseArticleInfo, false) == 74) {
              bool1 = true;
            }
            return bool1;
          }
          bool1 = bool3;
          if (paramAbsBaseArticleInfo.mFeedType == 1)
          {
            bool1 = bool3;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null)
            {
              bool1 = bool3;
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c != null)
              {
                bool1 = bool3;
                if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue() == 21)
                {
                  bool1 = bool3;
                  if (a(paramAbsBaseArticleInfo, true) == 75) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean z(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = bool4;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool4;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool4;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)
        {
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.x == null) {
            return false;
          }
          if (paramAbsBaseArticleInfo.mFeedType == 22)
          {
            bool1 = bool2;
            if (a(paramAbsBaseArticleInfo, false) == 72) {
              bool1 = true;
            }
            return bool1;
          }
          if ((paramAbsBaseArticleInfo.mFeedType == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.intValue() == 22))
          {
            bool1 = bool3;
            if (a(paramAbsBaseArticleInfo, true) == 73) {
              bool1 = true;
            }
            return bool1;
          }
          bool1 = bool4;
          if (paramAbsBaseArticleInfo.mFeedType == 1)
          {
            bool1 = bool4;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.s.i == 4) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType
 * JD-Core Version:    0.7.0.1
 */