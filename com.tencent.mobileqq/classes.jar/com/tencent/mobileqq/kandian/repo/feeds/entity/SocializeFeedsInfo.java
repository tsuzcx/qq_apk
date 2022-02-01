package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;
import tencent.im.oidb.articlesummary.feeds_info.IconWordingInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;

public class SocializeFeedsInfo
  implements Cloneable
{
  public int a;
  public long a;
  public BuluoInfo a;
  public FeedsInfoUser a;
  public IconWordingInfo a;
  public LocationInfo a;
  public LongContentInfo a;
  public PGCFeedsInfo a;
  public PrivacyShowInfo a;
  public ReadInJoyMedalInfo a;
  public ShareWebPageInfo a;
  public TopicRecommendFeedsInfo a;
  public UGCFeedsInfo a;
  public WendaInfo a;
  public BiuInfo a;
  public GameLiveInfo a;
  public NowLiveInfo a;
  public String a;
  public List<FeedsInfoUser> a;
  public articlesummary.ColumnTopicInfo a;
  public articlesummary.TopicEntranceInfo a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public int i;
  public int j;
  public int k = 0;
  public int l;
  
  public SocializeFeedsInfo()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser = new FeedsInfoUser();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  private void a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_d_of_type_JavaLangString != null) {
      paramSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
    }
    if (this.jdField_c_of_type_JavaLangString != null) {
      paramSocializeFeedsInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      paramSocializeFeedsInfo.uint32_is_jump_recommend_page.set(this.l);
      paramSocializeFeedsInfo.bytes_jump_recommend_url.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
    }
    if (this.jdField_g_of_type_JavaLangString != null) {
      paramSocializeFeedsInfo.bytes_jump_recommend_prompt.set(ByteStringMicro.copyFromUtf8(this.jdField_g_of_type_JavaLangString));
    }
  }
  
  private void b(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null) {
      paramSocializeFeedsInfo.msg_column_topic_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo);
    }
    if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) {
      paramSocializeFeedsInfo.msg_topic_entrance_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo != null) {
      paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.a());
    }
  }
  
  private void c(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null) {
      paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(UGCFeedsInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) {
      paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(PGCFeedsInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo));
    }
  }
  
  private void d(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo != null)
    {
      feeds_info.LocationInfo localLocationInfo = new feeds_info.LocationInfo();
      PBBytesField localPBBytesField = localLocationInfo.bytes_name;
      boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo.jdField_a_of_type_JavaLangString);
      String str2 = "";
      String str1;
      if (bool) {
        str1 = "";
      } else {
        str1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo.jdField_a_of_type_JavaLangString;
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
      localLocationInfo.uint32_longitude.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo.jdField_a_of_type_Int);
      localLocationInfo.uint32_latitude.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo.jdField_b_of_type_Int);
      localPBBytesField = localLocationInfo.bytes_icon_url;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo.jdField_b_of_type_JavaLangString)) {
        str1 = str2;
      } else {
        str1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo.jdField_b_of_type_JavaLangString;
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8(str1));
      paramSocializeFeedsInfo.location_info.set(localLocationInfo);
    }
  }
  
  private void e(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo != null)
    {
      feeds_info.VisibleInfo localVisibleInfo = new feeds_info.VisibleInfo();
      feeds_info.VisibleShowInfo localVisibleShowInfo = new feeds_info.VisibleShowInfo();
      localVisibleShowInfo.uint32_visible_type.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo.jdField_a_of_type_Int);
      localVisibleShowInfo.uint64_feed_id.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo.jdField_b_of_type_Long);
      localVisibleShowInfo.uint64_who.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo.jdField_a_of_type_Long);
      localVisibleInfo.visible_show_info.set(localVisibleShowInfo);
      paramSocializeFeedsInfo.visible_info.set(localVisibleInfo);
    }
  }
  
  private void f(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo != null)
    {
      articlesummary.BuluoInfo localBuluoInfo = new articlesummary.BuluoInfo();
      localBuluoInfo.bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo.jdField_a_of_type_JavaLangString));
      localBuluoInfo.bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo.jdField_d_of_type_JavaLangString));
      localBuluoInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo.jdField_b_of_type_JavaLangString));
      localBuluoInfo.bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo.jdField_c_of_type_JavaLangString));
      localBuluoInfo.uint64_buluo_id.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo.jdField_a_of_type_Long);
      paramSocializeFeedsInfo.buluo_info.set(localBuluoInfo);
    }
  }
  
  private void g(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo != null)
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0xb57.MedalInfo localMedalInfo = new oidb_cmd0xb57.MedalInfo();
      localMedalInfo.uint32_pic_width.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_c_of_type_Int);
      localMedalInfo.uint32_pic_height.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_d_of_type_Int);
      localMedalInfo.bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_b_of_type_JavaLangString));
      localMedalInfo.uint64_medal_id.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_a_of_type_Long);
      localMedalInfo.bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_a_of_type_JavaLangString));
      localMedalInfo.uint32_is_jump.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_b_of_type_Int);
      localMedalInfo.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_c_of_type_JavaLangString));
      localMedalInfo.uint32_medal_type.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_a_of_type_Int);
      localArrayList.add(localMedalInfo);
      paramSocializeFeedsInfo.msg_master_uin.rpt_msg_medal_info.set(localArrayList);
    }
  }
  
  private void h(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    paramSocializeFeedsInfo.uint64_feeds_id.set(this.jdField_a_of_type_Long);
    paramSocializeFeedsInfo.uint32_comments_count.set(this.jdField_d_of_type_Int);
    paramSocializeFeedsInfo.uint32_biu_time.set(this.jdField_e_of_type_Int);
    paramSocializeFeedsInfo.uint32_feeds_style.set(this.jdField_a_of_type_Int);
    paramSocializeFeedsInfo.uint32_like_count.set(this.jdField_b_of_type_Int);
    paramSocializeFeedsInfo.uint32_myself_like_status.set(this.jdField_c_of_type_Int);
    Object localObject = new articlesummary.SocializeFeedsInfoUser();
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint64_uin.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
    ((articlesummary.SocializeFeedsInfoUser)localObject).enum_uin_type.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int);
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint32_star_style.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_b_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_JavaLangString)) {
      ((articlesummary.SocializeFeedsInfoUser)localObject).bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_JavaLangString));
    }
    ((articlesummary.SocializeFeedsInfoUser)localObject).uint32_is_real_user.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_c_of_type_Int);
    paramSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject);
    paramSocializeFeedsInfo.uint32_follow_counts.set(this.i);
    paramSocializeFeedsInfo.uint32_follow_status.set(this.h);
    localObject = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)localIterator.next();
      articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
      localSocializeFeedsInfoUser.uint64_uin.set(localFeedsInfoUser.jdField_a_of_type_Long);
      localSocializeFeedsInfoUser.enum_uin_type.set(localFeedsInfoUser.jdField_a_of_type_Int);
      ((List)localObject).add(localSocializeFeedsInfoUser);
    }
    paramSocializeFeedsInfo.rpt_recommend_list.set((List)localObject);
    paramSocializeFeedsInfo.uint32_myself_biu_status.set(this.jdField_g_of_type_Int);
    paramSocializeFeedsInfo.uint32_biu_count.set(this.jdField_f_of_type_Int);
    paramSocializeFeedsInfo.uint64_article_id.set(this.jdField_b_of_type_Long);
    paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.j);
    paramSocializeFeedsInfo.uint32_feed_status.set(this.k);
  }
  
  public SocializeFeedsInfo a()
  {
    SocializeFeedsInfo localSocializeFeedsInfo1;
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a();
        localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList = new ArrayList();
        Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject).next();
          localSocializeFeedsInfo1.jdField_a_of_type_JavaUtilList.add(localFeedsInfoUser.a());
        }
        localObject = localSocializeFeedsInfo1;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
          return ???;
        }
        localSocializeFeedsInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a();
        return localSocializeFeedsInfo1;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
      QLog.d("SocializeFeedsInfo", 1, "clone SocializeFeedsInfo failed ", localCloneNotSupportedException2);
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      localSocializeFeedsInfo1 = null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo2 = localSocializeFeedsInfo1;
    return localSocializeFeedsInfo2;
  }
  
  public boolean a()
  {
    return this.k == 1;
  }
  
  public byte[] a()
  {
    articlesummary.SocializeFeedsInfo localSocializeFeedsInfo = new articlesummary.SocializeFeedsInfo();
    h(localSocializeFeedsInfo);
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      localSocializeFeedsInfo.bytes_private_status_title.set(ByteStringMicro.copyFromUtf8(this.jdField_e_of_type_JavaLangString));
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo;
    if (localObject != null)
    {
      localObject = ((LongContentInfo)localObject).a();
      localSocializeFeedsInfo.long_content_info.set((MessageMicro)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.a());
    }
    if (this.jdField_b_of_type_JavaLangString != null) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo != null) {
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo != null) {
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo.a());
    }
    try
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        localSocializeFeedsInfo.msg_socialize_feeds_ext_info.mergeFrom(this.jdField_a_of_type_ArrayOfByte);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a());
      }
    }
    catch (Exception localException)
    {
      QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo != null) {
      localSocializeFeedsInfo.game_live_info.set(GameLiveInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo));
    }
    b(localSocializeFeedsInfo);
    c(localSocializeFeedsInfo);
    a(localSocializeFeedsInfo);
    d(localSocializeFeedsInfo);
    e(localSocializeFeedsInfo);
    g(localSocializeFeedsInfo);
    f(localSocializeFeedsInfo);
    return localSocializeFeedsInfo.toByteArray();
  }
  
  public boolean b()
  {
    PrivacyShowInfo localPrivacyShowInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo;
    return (localPrivacyShowInfo != null) && (localPrivacyShowInfo.jdField_a_of_type_Int != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SocializeFeedsInfo{mFeedStyle=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mRecommUinList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", mLikeCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mLikeStatus=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", mCommentCount=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", mBiuTime=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", mCommentWording='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommReason='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRecommendAccountReason='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMasterUser.uin='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMasterUser.type='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMasterUser.starType='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_b_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBiuCount='");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBiuStatus='");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBiuInfo='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFollowStatus='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFollowCnt='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIsOriginFeedsDeleted='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedStatus='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPrivateStatusTitle='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mIs_jump_recommend_page='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJump_recommend__url='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJump_recommend__prompt='");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPGCFeedsInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo);
    localStringBuilder.append(", mUGCFeedsInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */