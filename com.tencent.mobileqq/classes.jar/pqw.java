import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class pqw
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
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(12));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(16));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(17));
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10));
    b.add(Integer.valueOf(1));
    b.add(Integer.valueOf(5));
    b.add(Integer.valueOf(7));
    b.add(Integer.valueOf(9));
    c.add(Integer.valueOf(1));
    c.add(Integer.valueOf(2));
    c.add(Integer.valueOf(3));
    c.add(Integer.valueOf(7));
    c.add(Integer.valueOf(8));
    c.add(Integer.valueOf(10));
    c.add(Integer.valueOf(12));
    c.add(Integer.valueOf(16));
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
  
  private static boolean A(BaseArticleInfo paramBaseArticleInfo)
  {
    int i;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null))
    {
      i = 1;
      if ((!a((ArticleInfo)paramBaseArticleInfo)) && (!ppe.g(paramBaseArticleInfo)) && (!ppe.i((ArticleInfo)paramBaseArticleInfo)) && (!ppe.j((ArticleInfo)paramBaseArticleInfo)) && (!ppe.k((ArticleInfo)paramBaseArticleInfo))) {
        break label83;
      }
    }
    label83:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label88;
      }
      return true;
      i = 0;
      break;
    }
    label88:
    return false;
  }
  
  private static boolean B(BaseArticleInfo paramBaseArticleInfo)
  {
    return (rjl.a((ArticleInfo)paramBaseArticleInfo) == 3) || (ppe.a((ArticleInfo)paramBaseArticleInfo)) || (ppe.i(paramBaseArticleInfo)) || (ppe.n((ArticleInfo)paramBaseArticleInfo)) || (g(paramBaseArticleInfo)) || (paramBaseArticleInfo.isPGCShortContent()) || (paramBaseArticleInfo.isAccountShown) || (paramBaseArticleInfo.mKdLiveInfo != null);
  }
  
  public static int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0;
    }
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru != null))
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.jdField_a_of_type_Boolean) {
        return 4;
      }
      return 2;
    }
    if (paramArticleInfo.isSuperTopic) {
      return 1;
    }
    return 3;
  }
  
  public static int a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null) || ((!paramBoolean) && (paramArticleInfo.mFeedType != 21) && (paramArticleInfo.mFeedType != 22)) || ((paramBoolean) && (!o(paramArticleInfo)))) {
      if (QLog.isColorLevel()) {
        QLog.e("RIJFeedsType", 1, "something is null.");
      }
    }
    do
    {
      return 7;
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b == 3)) {
        return 75;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b == 3) {
        return 74;
      }
      if ((paramBoolean) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b == 4)) {
        return 73;
      }
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b == 4) {
        return 72;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RIJFeedsType", 1, "error ugcFeedsSrc = " + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b);
    return 7;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = ppe.a((ArticleInfo)paramBaseArticleInfo);
    pjf localpjf = new pjf(paramBaseArticleInfo);
    int i = localpjf.a(j, 0);
    if (rjl.a((ArticleInfo)paramBaseArticleInfo) == 3) {
      i = localpjf.b(j, i);
    }
    for (;;)
    {
      i = localpjf.a(paramBaseArticleInfo, i);
      if (paramBaseArticleInfo.isTwoItem) {
        i = 43;
      }
      if (rpb.b(paramBaseArticleInfo)) {
        i = 69;
      }
      j = localpjf.d(paramBaseArticleInfo.mFeedType, i);
      i = j;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        i = j;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rre != null) {
          i = localpjf.c(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rre.jdField_a_of_type_Int, j);
        }
      }
      return i;
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a())) {
      return "1";
    }
    return "0";
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!c(paramBaseArticleInfo)) {}
    String str;
    do
    {
      do
      {
        return null;
      } while ((paramBaseArticleInfo.mGalleryFeedsInfo == null) || (!paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) || (TextUtils.isEmpty(paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())));
      paramBaseArticleInfo = paramBaseArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
      str = tto.b(paramBaseArticleInfo);
    } while ((!tto.b(paramBaseArticleInfo)) || (TextUtils.isEmpty(str)));
    return str;
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
    if (jdField_a_of_type_JavaLangString != null) {
      pkn.a(jdField_a_of_type_JavaLangString);
    }
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = false;
    int i;
    if ((paramInt != 5) && (paramInt != 6))
    {
      if (paramInt != 43) {
        break label39;
      }
      i = 1;
      if (paramInt != 18) {
        break label44;
      }
    }
    label39:
    label44:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt | i) != 0) {
        bool = true;
      }
      return bool;
      i = 0;
      break;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return false;
      float f = bmhv.b(pnn.a());
      if (f > 0.0F) {}
      while (paramInt1 / paramInt2 <= f)
      {
        return true;
        f = 0.75F;
      }
    }
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong == 41516L) || (paramLong == 41522L) || (paramLong == 41523L);
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    return rjl.b(ppe.a(paramArticleInfo));
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mVideoCoverUrl == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mVideoVid))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (h(paramBaseArticleInfo1))
    {
      bool1 = bool2;
      if (h(paramBaseArticleInfo2))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo1.mPolymericInfo.c == paramBaseArticleInfo2.mPolymericInfo.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, long paramLong, ArticleInfo paramArticleInfo)
  {
    if (!bmhv.C(pnn.a())) {
      return false;
    }
    if (udj.a.a()) {
      return false;
    }
    if ((paramArticleInfo instanceof AdvertisementInfo)) {
      return false;
    }
    if (paramLong == 1000000L) {
      return false;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bkyp.a(paramString);
      if ((paramString.containsKey("article_type")) && (!TextUtils.equals("1", (CharSequence)paramString.get("article_type")))) {
        return false;
      }
    }
    return b(paramArticleInfo);
  }
  
  public static boolean a(rrq paramrrq)
  {
    return (paramrrq != null) && (paramrrq.jdField_a_of_type_Rqw != null) && (paramrrq.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList != null) && ((paramrrq.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.size() > 1) || ((paramrrq.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.size() == 1) && (!TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramrrq.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.get(0)).mBiuComment))));
  }
  
  public static int b(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.isEmpty()) || (!paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean))
    {
      QLog.e("RIJFeedsType", 1, "articleInfo = null");
      return 0;
    }
    rpt localrpt = (rpt)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    if (u(paramBaseArticleInfo)) {
      return 79;
    }
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15) {
      return 131;
    }
    if (localrpt.b == 10) {
      return 78;
    }
    if ((localrpt.b == 4) || (localrpt.b == 5)) {
      return 76;
    }
    if ((localrpt.b == 6) || (localrpt.b == 7) || (localrpt.b == 8) || (localrpt.b == 9) || (localrpt.b == 12)) {
      return 77;
    }
    if (localrpt.b == 0) {
      return 77;
    }
    QLog.e("FeedItemCellTypeNewPolymericBaseHeader", 1, "新聚合类卡片没有找到对应的FeedCell feedType = " + localrpt.b);
    return 77;
  }
  
  public static String b(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 1;
    int i;
    if (rjl.a((ArticleInfo)paramBaseArticleInfo) == 2)
    {
      i = 1;
      if (rjl.a((ArticleInfo)paramBaseArticleInfo) != 1) {
        break label52;
      }
    }
    for (;;)
    {
      if (!A(paramBaseArticleInfo)) {
        break label57;
      }
      return String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.a);
      i = 0;
      break;
      label52:
      j = 0;
    }
    label57:
    if (i != 0) {
      return e(paramBaseArticleInfo);
    }
    if (j != 0) {
      return ((articlesummary.SpecialTopicInfo)paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    if (B(paramBaseArticleInfo)) {
      return paramBaseArticleInfo.mSubscribeID;
    }
    return "";
  }
  
  @VisibleForTesting
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        return false;
      } while (paramArticleInfo.isAccountShown);
      if (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramArticleInfo.mFeedType))) {
        return true;
      }
    } while (!b.contains(Integer.valueOf(paramArticleInfo.mFeedType)));
    int i = ppe.a(paramArticleInfo);
    return c.contains(Integer.valueOf(i));
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    if (g(paramBaseArticleInfo))
    {
      paramBaseArticleInfo = (rpt)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
      return (paramBaseArticleInfo.a != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.a.jdField_a_of_type_JavaLangString));
    }
    return false;
  }
  
  public static String c(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "3";
    }
    if ((paramBaseArticleInfo.mPackInfoObj == null) || (!paramBaseArticleInfo.mPackInfoObj.pack_type.has())) {
      return "";
    }
    int i = paramBaseArticleInfo.mPackInfoObj.pack_type.get();
    if ((i == 3) && (paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.has())) {
      return "1";
    }
    if ((i == 2) && (paramBaseArticleInfo.mPackInfoObj.msg_special_topic_info.has())) {
      return "2";
    }
    return "";
  }
  
  public static boolean c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 17) {
      return false;
    }
    return true;
  }
  
  public static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = true;
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mShowBigPicture) && (paramBaseArticleInfo.mIsGallery == 1))
    {
      bool1 = bool2;
      if (paramBaseArticleInfo.articleStyle != 3)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.articleStyle != 4)
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.articleStyle != 5)
          {
            bool1 = bool2;
            if (paramBaseArticleInfo.articleStyle != 6) {
              if (!pqa.a(paramBaseArticleInfo)) {
                break label75;
              }
            }
          }
        }
      }
    }
    label75:
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static String d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "";
    }
    if (paramBaseArticleInfo.isSubscriptFeed()) {
      return "1";
    }
    if ((paramBaseArticleInfo.mPackInfoObj != null) && (paramBaseArticleInfo.mPackInfoObj.has()) && (paramBaseArticleInfo.mPackInfoObj.pack_type.get() == 3)) {
      return "2";
    }
    return "";
  }
  
  public static boolean d(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 16) {
      return false;
    }
    return true;
  }
  
  public static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mIsPolymericGallery;
  }
  
  private static String e(BaseArticleInfo paramBaseArticleInfo)
  {
    paramBaseArticleInfo = new ArrayList(((articlesummary.FriendRecommendInfo)paramBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
    if (paramBaseArticleInfo.size() == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramBaseArticleInfo.size())
    {
      localStringBuilder.append(paramBaseArticleInfo.get(i));
      localStringBuilder.append(",");
      i += 1;
    }
    paramBaseArticleInfo = localStringBuilder.toString();
    return paramBaseArticleInfo.substring(0, paramBaseArticleInfo.length() - 1);
  }
  
  public static boolean e(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() == 23L);
  }
  
  public static boolean e(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 19) {
      return false;
    }
    return true;
  }
  
  public static boolean f(BaseArticleInfo paramBaseArticleInfo)
  {
    return ((paramBaseArticleInfo instanceof ArticleInfo)) && (!ppe.q((ArticleInfo)paramBaseArticleInfo)) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int == 6);
  }
  
  public static boolean g(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 18) {
      return false;
    }
    return true;
  }
  
  public static boolean g(BaseArticleInfo paramBaseArticleInfo)
  {
    return paramBaseArticleInfo.mNewPolymericInfo != null;
  }
  
  public static boolean h(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() != 17L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() != 16L)) {
      return false;
    }
    return true;
  }
  
  public static boolean h(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mPolymericInfo != null) && (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int >= 6);
  }
  
  public static boolean i(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null)) {}
    while ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() != 19L) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.longValue() != 18L)) {
      return false;
    }
    return true;
  }
  
  public static boolean i(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && (paramBaseArticleInfo.mIsInPolymeric);
  }
  
  public static boolean j(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 26) {
      return false;
    }
    return true;
  }
  
  public static boolean j(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && (paramBaseArticleInfo.mGroupSubArticleList != null);
  }
  
  public static boolean k(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.jdField_a_of_type_Rom == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.c == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.c.size() <= 0) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru.jdField_a_of_type_Rom.b != 1);
  }
  
  public static boolean k(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if ((paramBaseArticleInfo.l == 1) && (!TextUtils.isEmpty(paramBaseArticleInfo.f)) && (!TextUtils.isEmpty(paramBaseArticleInfo.g))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean l(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (paramArticleInfo.mFeedType != 21) {
          break;
        }
      } while (a(paramArticleInfo, false) == 74);
      return false;
      if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.intValue() != 21)) {
        break;
      }
    } while (a(paramArticleInfo, true) == 75);
    return false;
    return false;
  }
  
  public static boolean l(BaseArticleInfo paramBaseArticleInfo)
  {
    return (h(paramBaseArticleInfo)) && ((paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 11));
  }
  
  public static boolean m(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null)) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (paramArticleInfo.mFeedType != 22) {
            break;
          }
        } while (a(paramArticleInfo, false) == 72);
        return false;
        if ((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.intValue() != 22)) {
          break;
        }
      } while (a(paramArticleInfo, true) == 73);
      return false;
    } while ((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.b == 4));
    return false;
  }
  
  public static boolean m(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {}
    for (int i = 1; (i != 0) && ((paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 9) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 10) || (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 11)); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean n(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null)) {}
    while (paramArticleInfo.mFeedType != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean n(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 15);
  }
  
  public static boolean o(ArticleInfo paramArticleInfo)
  {
    return (p(paramArticleInfo)) || (q(paramArticleInfo));
  }
  
  public static boolean o(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12);
  }
  
  public static boolean p(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.intValue() != 21) {
      return false;
    }
    return true;
  }
  
  public static boolean p(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 13);
  }
  
  public static boolean q(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b == null)) {}
    while (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b.intValue() != 22) {
      return false;
    }
    return true;
  }
  
  public static boolean q(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mKdLiveInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0) && (paramBaseArticleInfo.mSubArtilceList.get(0) != null) && (((ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0)).mKdLiveInfo != null);
  }
  
  public static boolean r(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("RIJFeedsType", 1, "commentBiuCanJump, canJump= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramArticleInfo.mFeedType == 36)
      {
        bool1 = bool2;
        if (paramArticleInfo.isCardJumpUrlAvailable == 1)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean r(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mFeedType == 24) && (paramBaseArticleInfo.mNewPolymericInfo != null);
  }
  
  public static boolean s(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("RIJFeedsType", 1, "canOpenNativeArticle,articleInfo=" + paramArticleInfo);
      return bool1;
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramArticleInfo.mArticleContentUrl)) {
          bool1 = true;
        }
      }
    }
  }
  
  public static boolean s(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mFeedType == 29);
  }
  
  public static boolean t(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo != null) && (paramBaseArticleInfo.mFeedType == 20) && (paramBaseArticleInfo.mRecommendFollowInfos != null);
  }
  
  public static boolean u(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBaseArticleInfo.mNewPolymericInfo != null) {
      if ((paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 7) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 8))
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int != 9) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean v(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = false;
    switch (paramBaseArticleInfo.mFeedType)
    {
    default: 
      bool = a(paramBaseArticleInfo);
    }
    do
    {
      return bool;
    } while (paramBaseArticleInfo.mProteusTemplateBean == null);
    return a(qsf.a(paramBaseArticleInfo.mProteusTemplateBean));
  }
  
  public static boolean w(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("RIJFeedsType", 1, "isImageArticle, flag= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramBaseArticleInfo.mFeedType == 36)
        {
          bool1 = bool2;
          if (!paramBaseArticleInfo.isPGCShortContent())
          {
            bool1 = bool2;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 4)
            {
              bool1 = bool2;
              if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)
              {
                bool1 = bool2;
                if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 6)
                {
                  QLog.d("RIJFeedsType", 1, "isImageArticle, style= " + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean x(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("RIJFeedsType", 1, "isStructCard, flag= " + bool1);
      return bool1;
      if (paramBaseArticleInfo.isPGCShortContent())
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if ((paramBaseArticleInfo instanceof ArticleInfo))
        {
          bool1 = bool2;
          if (ppe.i((ArticleInfo)paramBaseArticleInfo)) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static boolean y(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!z(paramBaseArticleInfo))) {}
    while (paramBaseArticleInfo.mVideoJsonWidth >= paramBaseArticleInfo.mVideoJsonHeight) {
      return false;
    }
    return true;
  }
  
  public static boolean z(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBaseArticleInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      QLog.d("RIJFeedsType", 1, "isVideoCommentBiu, flag= " + bool1);
      return bool1;
      bool1 = bool2;
      if (paramBaseArticleInfo.mFeedType == 36) {
        if (a(paramBaseArticleInfo))
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramBaseArticleInfo.mSocialFeedInfo != null) {
            if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 4) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5))
            {
              bool1 = bool2;
              if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 6) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqw
 * JD-Core Version:    0.7.0.1
 */