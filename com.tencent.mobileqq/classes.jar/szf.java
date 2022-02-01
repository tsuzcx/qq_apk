import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapterUtil;", "", "()V", "getBaseItemViewType", "", "article", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "channelType", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class szf
{
  public static final szf a = new szf();
  
  public final int a(@Nullable ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {
      paramInt = 0;
    }
    do
    {
      return paramInt;
      rad localrad = rad.a();
      Intrinsics.checkExpressionValueIsNotNull(localrad, "PTSLiteSwitchManager.getInstance()");
      if ((localrad.a()) && (qym.a((BaseArticleInfo)paramArticleInfo))) {
        return qym.a(paramArticleInfo);
      }
      if (qsf.a(paramArticleInfo)) {
        return szd.a.a(paramArticleInfo);
      }
      if (paramArticleInfo.mFeedType != 20) {
        break;
      }
      paramInt = 82;
    } while (paramArticleInfo.mRecommendFollowInfos == null);
    switch (paramArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int)
    {
    default: 
      return 82;
    case 0: 
      return 82;
    case 1: 
      return 87;
    }
    return 88;
    if (paramArticleInfo.mFeedType == 36)
    {
      if (paramArticleInfo.isPGCShortContent()) {
        return 139;
      }
      if (pqw.z((BaseArticleInfo)paramArticleInfo)) {
        return 138;
      }
      return 137;
    }
    if ((paramArticleInfo.mFeedType == 21) || (paramArticleInfo.mFeedType == 22)) {
      return pqw.a(paramArticleInfo, false);
    }
    if (paramArticleInfo.mFeedType == 28) {
      return 93;
    }
    if (paramArticleInfo.mFeedType == 24) {
      return pqw.b((BaseArticleInfo)paramArticleInfo);
    }
    if (paramArticleInfo.mFeedType == 34) {
      return 123;
    }
    if ((paramArticleInfo.mGroupSubArticleList != null) && (paramArticleInfo.mFeedType != 29)) {
      return 53;
    }
    if (paramArticleInfo.mFeedType == 25) {
      return 89;
    }
    if (paramArticleInfo.mFeedType == 15) {
      return 38;
    }
    if ((paramArticleInfo.mFeedType == 3) || (paramArticleInfo.mFeedType == 13)) {
      return 15;
    }
    if (paramArticleInfo.mFeedType == 30) {
      return 107;
    }
    if ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mChannelID != 56))
    {
      paramInt = pki.a((BaseArticleInfo)paramArticleInfo);
      if ((paramInt == 21) || (paramInt == 22)) {
        return pqw.a(paramArticleInfo, true);
      }
      if (paramInt == 11) {
        return 33;
      }
      if (pqw.h(paramArticleInfo))
      {
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          return 12;
        case 1: 
          return 10;
        case 2: 
          return 27;
        }
        return 35;
      }
      if (pqw.i(paramArticleInfo))
      {
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int)
        {
        default: 
          return 24;
        case 1: 
          return 24;
        case 2: 
        case 3: 
          return 25;
        }
        return 26;
      }
      if (pqw.e(paramArticleInfo)) {
        if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label2397;
        }
      }
    }
    label2394:
    label2397:
    for (paramInt = ComponentContentGridImage.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.jdField_a_of_type_JavaUtilArrayList.size(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);; paramInt = 0)
    {
      if (paramInt != 0)
      {
        switch (paramInt)
        {
        default: 
          return 0;
        case 1: 
          return 49;
        case 3: 
          return 62;
        }
        return 63;
      }
      switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
      {
      default: 
        return 12;
      case 9: 
        return 63;
      case 3: 
        return 62;
      }
      return 49;
      if (paramInt == 25) {
        return 92;
      }
      if ((paramInt == 27) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp != null))
      {
        if (!TextUtils.isEmpty((CharSequence)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp.c)) {
          return 94;
        }
        return 95;
      }
      if ((paramInt == 32) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rra != null)) {
        return 26;
      }
      if (!ppe.i(paramArticleInfo))
      {
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 0)
        {
          paramInt = 12;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 112;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 1)
        {
          paramInt = 10;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 113;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5) {
          return 11;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 2)
        {
          paramInt = 27;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 113;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 6) {
          return 28;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9)
        {
          paramInt = 35;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 114;
        }
        paramInt = 12;
        if (!paramArticleInfo.isPGCShortContent()) {
          break;
        }
        return 112;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int == 1)
      {
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.c.size() > 0) {
          return 108;
        }
        return 24;
      }
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int == 3) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int == 2))
      {
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 9) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
          return 37;
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrb != null) {
          return 81;
        }
        return 25;
      }
      return 26;
      if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
          return 30;
        }
        return 29;
      }
      if (ppe.a(paramArticleInfo))
      {
        if (paramArticleInfo.mSocialFeedInfo == null) {
          break label2394;
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          return 16;
        case 0: 
          paramInt = 20;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 109;
        case 5: 
          return 17;
        case 2: 
          paramInt = 18;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 110;
        case 6: 
          paramInt = 19;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 133;
        case 9: 
          paramInt = 34;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 111;
        case 3: 
          if (!paramArticleInfo.isPGCShortContent()) {
            break label2394;
          }
          return 111;
        case 8: 
          return 16;
        case 1: 
          if (!paramArticleInfo.isPGCShortContent()) {
            break label2394;
          }
          return 132;
        case 19191924: 
          if (!paramArticleInfo.isPGCShortContent()) {
            break label2394;
          }
          return 134;
        }
      }
      if ((paramArticleInfo.mFeedType == 32) && (paramArticleInfo.mSocialFeedInfo != null)) {
        return 120;
      }
      if ((ppe.g((BaseArticleInfo)paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null)) {
        return ppe.b(paramArticleInfo);
      }
      if ((pqw.c(paramArticleInfo)) || (pqw.d(paramArticleInfo)))
      {
        paramInt = 40;
        if (paramArticleInfo.mSocialFeedInfo == null) {
          break;
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        default: 
          return 40;
        case 2: 
          return 40;
        case 1: 
          return 41;
        }
        return 42;
      }
      if ((pqw.f(paramArticleInfo)) || (pqw.g(paramArticleInfo))) {
        return ppe.c(paramArticleInfo);
      }
      if (ppe.h(paramArticleInfo))
      {
        paramInt = 31;
        if (paramArticleInfo.mSocialFeedInfo == null) {
          break;
        }
        switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
        {
        case 3: 
        case 4: 
        case 7: 
        case 8: 
        default: 
          paramInt = 86;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 109;
        case 2: 
          paramInt = 31;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 110;
        case 6: 
          return 32;
        case 1: 
          paramInt = 83;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 111;
        case 5: 
          return 84;
        case 9: 
          paramInt = 85;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 111;
        case 0: 
          paramInt = 86;
          if (!paramArticleInfo.isPGCShortContent()) {
            break;
          }
          return 109;
        }
      }
      if (paramArticleInfo.mFeedType == 23)
      {
        if (paramArticleInfo.mSocialFeedInfo != null)
        {
          switch (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int)
          {
          default: 
            return 16;
          case 9: 
            return 65;
          case 3: 
            return 64;
          }
          return 48;
        }
      }
      else
      {
        if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mSimpleVideoColumnInfo != null) && (pqw.a((BaseArticleInfo)paramArticleInfo))) {
          return 128;
        }
        if ((paramArticleInfo.mChannelID == 0L) && (paramArticleInfo.mVideoColumnInfo != null) && (pqw.a((BaseArticleInfo)paramArticleInfo))) {
          return 118;
        }
        if (paramArticleInfo.multiVideoColumnInfo != null)
        {
          if (paramArticleInfo.columnStyle == 1) {
            return 142;
          }
          if (paramArticleInfo.multiVideoColumnInfo.a) {
            return 125;
          }
          return 124;
        }
        if (paramArticleInfo.mKdLiveInfo != null)
        {
          if (paramArticleInfo.mKdLiveInfo.jdField_a_of_type_Int == 4) {
            return 130;
          }
          return 129;
        }
        if (paramArticleInfo.isWeishiGridTwoItemFeed()) {
          return 70;
        }
        if (paramArticleInfo.isTwoItemVideoFeed())
        {
          if ((paramArticleInfo.mFeedType == 33) && (paramArticleInfo.mChannelID != 56) && (paramArticleInfo.mChannelID != 70)) {
            return 121;
          }
          return 46;
        }
        if (paramArticleInfo.isWormhole()) {
          return 136;
        }
        if ((pqw.a((BaseArticleInfo)paramArticleInfo)) && (paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3) && (paramArticleInfo.mChannelID == 0L)) {
          return 14;
        }
        if (pqw.a((BaseArticleInfo)paramArticleInfo))
        {
          if (paramArticleInfo.mVideoType == 0)
          {
            if (pnn.a())
            {
              if ((paramArticleInfo.mChannelID == 56) || (paramInt == 3)) {
                return 4;
              }
              if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo))
              {
                if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle) {
                  return 115;
                }
                return 66;
              }
              if (six.f() == 0) {
                return 126;
              }
              return 6;
            }
            if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo))
            {
              if (((AdvertisementInfo)paramArticleInfo).isIMaxAndNewStyle) {
                return 115;
              }
              return 66;
            }
            if (six.f() == 0) {
              return 126;
            }
            return 6;
          }
          if (paramArticleInfo.mChannelID == 56) {
            return 4;
          }
          return 5;
        }
        if (pqa.a((BaseArticleInfo)paramArticleInfo))
        {
          if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 3) {
            return 103;
          }
          if (paramArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 2) {
            return 102;
          }
          return 101;
        }
        if (paramArticleInfo.mShowBigPicture)
        {
          if (paramArticleInfo.mIsGallery == 0)
          {
            if (paramArticleInfo.mTopicPicWHRatio != 0.0D) {
              return 9;
            }
            if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) {
              return uks.b((AdvertisementInfo)paramArticleInfo);
            }
            return 2;
          }
          if (paramArticleInfo.articleStyle == 3) {
            return 47;
          }
          if (paramArticleInfo.articleStyle == 4) {
            return 60;
          }
          if (paramArticleInfo.articleStyle == 5) {
            return 61;
          }
          if (paramArticleInfo.articleStyle == 6) {
            return 96;
          }
          return 8;
        }
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) && (uks.g((AdvertisementInfo)paramArticleInfo))) {
          return 116;
        }
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) && (uks.h((AdvertisementInfo)paramArticleInfo))) {
          return 39;
        }
        if (pqw.j(paramArticleInfo))
        {
          if (pqw.k(paramArticleInfo)) {
            return 91;
          }
          return 90;
        }
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) && (uks.i((AdvertisementInfo)paramArticleInfo))) {
          return 127;
        }
        if (uks.c((BaseArticleInfo)paramArticleInfo)) {
          return 140;
        }
        if (uks.e((BaseArticleInfo)paramArticleInfo)) {
          return 144;
        }
        if (uks.g((BaseArticleInfo)paramArticleInfo)) {
          return 145;
        }
        if (uks.d((BaseArticleInfo)paramArticleInfo)) {
          return 146;
        }
        if (uks.h((BaseArticleInfo)paramArticleInfo)) {
          return 143;
        }
        if (uks.f((BaseArticleInfo)paramArticleInfo)) {
          return 141;
        }
        if ((paramArticleInfo.mPictures != null) && (paramArticleInfo.mPictures.length >= 3))
        {
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo)) {
            return 105;
          }
          return 3;
        }
        if (TextUtils.isEmpty((CharSequence)paramArticleInfo.mFirstPagePicUrl)) {
          return 0;
        }
        if (paramArticleInfo.mFeedType == 37) {
          return 135;
        }
        if (paramArticleInfo.mIsGallery == 0)
        {
          if (AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)paramArticleInfo))
          {
            if (ois.a((BaseArticleInfo)paramArticleInfo)) {
              return 106;
            }
            return 104;
          }
          return 1;
        }
        return 7;
      }
      return 16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szf
 * JD-Core Version:    0.7.0.1
 */