package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
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
  private static String a;
  public static List<Integer> a;
  public static List<Integer> b;
  public static List<Integer> c;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    b = new ArrayList();
    c = new ArrayList();
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
    Object localObject1 = jdField_a_of_type_JavaUtilList;
    Integer localInteger1 = Integer.valueOf(8);
    ((List)localObject1).add(localInteger1);
    Object localObject2 = jdField_a_of_type_JavaUtilList;
    localObject1 = Integer.valueOf(12);
    ((List)localObject2).add(localObject1);
    Object localObject3 = jdField_a_of_type_JavaUtilList;
    localObject2 = Integer.valueOf(16);
    ((List)localObject3).add(localObject2);
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(17));
    Object localObject4 = jdField_a_of_type_JavaUtilList;
    localObject3 = Integer.valueOf(10);
    ((List)localObject4).add(localObject3);
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(58));
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
    return (y(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static boolean B(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
      if ((paramAbsBaseArticleInfo.l == 1) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.f)) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.g))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean C(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (y(paramAbsBaseArticleInfo)) && ((paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) || (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10) || (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11));
  }
  
  public static boolean D(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 9) {
        return bool1;
      }
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 10) {
        return bool1;
      }
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 11) {
        return true;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public static boolean E(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15);
  }
  
  public static boolean F(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12);
  }
  
  public static boolean G(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 13);
  }
  
  public static boolean H(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean I(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mFeedType == 24) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean J(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 29);
  }
  
  public static boolean K(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 20) && (paramAbsBaseArticleInfo.mRecommendFollowInfos != null);
  }
  
  public static boolean L(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && ((paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 7) || (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 8) || (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 9));
  }
  
  public static boolean M(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType != 29) {
      return a(paramAbsBaseArticleInfo);
    }
    if (paramAbsBaseArticleInfo.mProteusTemplateBean != null) {
      bool = a(ProteusReportUtil.a(paramAbsBaseArticleInfo.mProteusTemplateBean));
    }
    return bool;
  }
  
  public static boolean N(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool;
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 36) && (!paramAbsBaseArticleInfo.isPGCShortContent()) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 4) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 6))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isImageArticle, style= ");
      localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
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
  
  public static boolean O(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean P(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      if (!Q(paramAbsBaseArticleInfo)) {
        return false;
      }
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mVideoJsonWidth < paramAbsBaseArticleInfo.mVideoJsonHeight) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean Q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mFeedType == 36))
    {
      if (a(paramAbsBaseArticleInfo)) {}
      while ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && ((paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 4) || (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) || (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6)))
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
  
  public static boolean R(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean S(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean T(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean U(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null);
  }
  
  private static boolean V(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null)) {
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
  
  private static boolean W(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (UtilsForComponent.a(paramAbsBaseArticleInfo) == 3) || (RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.t(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.u(paramAbsBaseArticleInfo)) || (h(paramAbsBaseArticleInfo)) || (paramAbsBaseArticleInfo.isPGCShortContent()) || (paramAbsBaseArticleInfo.isAccountShown) || (paramAbsBaseArticleInfo.mKdLiveInfo != null);
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int k = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
    RIJUtilsHelper localRIJUtilsHelper = new RIJUtilsHelper(paramAbsBaseArticleInfo);
    int j = localRIJUtilsHelper.a(k, 0);
    int i = j;
    if (UtilsForComponent.a(paramAbsBaseArticleInfo) == 3) {
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
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo != null) {
        i = localRIJUtilsHelper.c(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.jdField_a_of_type_Int, j);
      }
    }
    if (RIJItemViewTypeUtils.B(paramAbsBaseArticleInfo)) {
      i = 1065;
    }
    return i;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null) && ((paramBoolean) || (paramAbsBaseArticleInfo.mFeedType == 21) || (paramAbsBaseArticleInfo.mFeedType == 22)) && ((!paramBoolean) || (v(paramAbsBaseArticleInfo))))
    {
      if ((paramBoolean) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 3)) {
        return 75;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 4)) {
        return 73;
      }
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 4) {
        return 72;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error ugcFeedsSrc = ");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b);
        QLog.e("RIJFeedsType", 1, localStringBuilder.toString());
      }
      return 7;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJFeedsType", 1, "something is null.");
    }
    return 7;
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!c(paramAbsBaseArticleInfo)) {
      return null;
    }
    if ((paramAbsBaseArticleInfo.mGalleryFeedsInfo != null) && (paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
      String str = ViolaAccessHelper.c(paramAbsBaseArticleInfo);
      if ((ViolaAccessHelper.c(paramAbsBaseArticleInfo)) && (!TextUtils.isEmpty(str))) {
        return str;
      }
    }
    return null;
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
    String str = jdField_a_of_type_JavaLangString;
    if (str != null) {
      TimeSliceHelper.a(str);
    }
    jdField_a_of_type_JavaLangString = paramString;
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
    float f = FeedsSPUtils.a(RIJQQAppInterfaceUtil.a());
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
    boolean bool3 = y(paramAbsBaseArticleInfo1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (y(paramAbsBaseArticleInfo2))
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo1.mPolymericInfo.c == paramAbsBaseArticleInfo2.mPolymericInfo.c) {
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
      if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)
      {
        bool1 = bool2;
        if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null) {
          if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() <= 1)
          {
            bool1 = bool2;
            if (paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() == 1)
            {
              bool1 = bool2;
              if (TextUtils.isEmpty(((BiuCommentInfo)paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment)) {}
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
    if (!FeedsSPUtils.a(RIJQQAppInterfaceUtil.a())) {
      return false;
    }
    if (RIJWebArticleUtil.a.a()) {
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
    return i(paramAbsBaseArticleInfo);
  }
  
  public static int b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0;
    }
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null))
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_Boolean) {
        return 4;
      }
      return 2;
    }
    if (paramAbsBaseArticleInfo.isSuperTopic) {
      return 1;
    }
    return 3;
  }
  
  public static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a())) {
      return "1";
    }
    return "0";
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = h(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramAbsBaseArticleInfo = (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.a != null)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.a.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static int c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null) && (!paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      if (L(paramAbsBaseArticleInfo)) {
        return 79;
      }
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15) {
        return 131;
      }
      if (localPackArticleInfo.b == 10) {
        return 78;
      }
      if ((localPackArticleInfo.b != 4) && (localPackArticleInfo.b != 5))
      {
        if ((localPackArticleInfo.b != 6) && (localPackArticleInfo.b != 7) && (localPackArticleInfo.b != 8) && (localPackArticleInfo.b != 9))
        {
          if (localPackArticleInfo.b == 12) {
            return 77;
          }
          if (localPackArticleInfo.b == 0) {
            return 77;
          }
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("新聚合类卡片没有找到对应的FeedCell feedType = ");
          paramAbsBaseArticleInfo.append(localPackArticleInfo.b);
          QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, paramAbsBaseArticleInfo.toString());
        }
        return 77;
      }
      return 76;
    }
    QLog.e("RIJFeedsType", 1, "articleInfo = null");
    return 0;
  }
  
  public static String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = UtilsForComponent.a(paramAbsBaseArticleInfo);
    int j = 0;
    if (i == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (UtilsForComponent.a(paramAbsBaseArticleInfo) == 1) {
      j = 1;
    }
    if (V(paramAbsBaseArticleInfo)) {
      return String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a);
    }
    if (i != 0) {
      return g(paramAbsBaseArticleInfo);
    }
    if (j != 0) {
      return ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    if (W(paramAbsBaseArticleInfo)) {
      return paramAbsBaseArticleInfo.mSubscribeID;
    }
    return "";
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
          if (!T(paramAbsBaseArticleInfo)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static int d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((U(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b != null)) {
      return paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue();
    }
    return 0;
  }
  
  public static String d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return paramAbsBaseArticleInfo.mIsPolymericGallery;
  }
  
  public static String e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public static String f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    if (((paramAbsBaseArticleInfo.mFeedType == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (a(paramAbsBaseArticleInfo))) {
      return paramAbsBaseArticleInfo.innerUniqueID;
    }
    if ((RIJItemViewTypeUtils.o(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) && (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int))) {
      return paramAbsBaseArticleInfo.innerUniqueID;
    }
    return String.valueOf(paramAbsBaseArticleInfo.mArticleID);
  }
  
  public static boolean f(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    return RIJItemViewTypeUtils.c(RIJBaseItemViewType.a(paramAbsBaseArticleInfo));
  }
  
  private static String g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean g(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int == 6);
  }
  
  public static boolean h(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return paramAbsBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  @VisibleForTesting
  public static boolean i(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.isAccountShown) {
      return false;
    }
    if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramAbsBaseArticleInfo.mFeedType))) {
      return true;
    }
    if (!b.contains(Integer.valueOf(paramAbsBaseArticleInfo.mFeedType))) {
      return false;
    }
    int i = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
    return c.contains(Integer.valueOf(i));
  }
  
  public static boolean j(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean k(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean l(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() == 23L);
  }
  
  public static boolean m(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean n(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean o(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
          return false;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() != 17L)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() != 16L) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean p(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
          return false;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() != 19L)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() != 18L) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean q(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public static boolean r(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localSocializeFeedsInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.c != null)
          {
            bool1 = bool2;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.c.size() > 0)
            {
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAnswerDetailInfo.b != 1) {
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
  
  public static boolean s(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)
        {
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo == null) {
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
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)
            {
              bool1 = bool3;
              if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b != null)
              {
                bool1 = bool3;
                if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() == 21)
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
  
  public static boolean t(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)
        {
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo == null) {
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
          if ((paramAbsBaseArticleInfo.mFeedType == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() == 22))
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
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b == 4) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
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
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)
        {
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo == null) {
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
  
  public static boolean v(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (w(paramAbsBaseArticleInfo)) || (x(paramAbsBaseArticleInfo));
  }
  
  public static boolean w(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)
          {
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b == null) {
              return false;
            }
            bool1 = bool2;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() == 21) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean x(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null)
        {
          bool1 = bool2;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)
          {
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b == null) {
              return false;
            }
            bool1 = bool2;
            if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.intValue() == 22) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean y(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int >= 6);
  }
  
  public static boolean z(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (y(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mIsInPolymeric);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType
 * JD-Core Version:    0.7.0.1
 */