package com.tencent.mobileqq.kandian.repo.db.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.view.widget.text.PositionalSpanStruct;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.text.JumpSpan;
import com.tencent.mobileqq.kandian.glue.text.UserSpan;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BuluoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.IconWordingInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LocationInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PrivacyShowInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyMedalInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.handler.UGCVoiceInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.GameLiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfoUser;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;

public class SocializeFeedsInfoUtils
{
  public static SpannableStringBuilder a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, List<BiuCommentInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramList.size();
    Object localObject2 = ((BiuCommentInfo)paramList.get(i - 1)).mBiuComment;
    Object localObject1;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
    {
      localObject1 = ((String)localObject2).substring(1);
    }
    else
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    localStringBuilder.append((String)localObject1);
    int j = localStringBuilder.length();
    ArrayList localArrayList = new ArrayList();
    i -= 2;
    while (i >= 0)
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramList.get(i);
      int k = localBiuCommentInfo.mOpType;
      if ((k != 2) && (k != 3))
      {
        long l = localBiuCommentInfo.mUin.longValue();
        localObject1 = ReadInJoyUserInfoModule.a(l, paramRefreshUserInfoCallBack);
        if (localObject1 != null) {
          localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
        } else {
          localObject1 = ReadInJoyUserInfoModule.a();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (localBiuCommentInfo.mOpType == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(" ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if (localBiuCommentInfo.mBiuComment == null) {
          localObject2 = "";
        } else {
          localObject2 = localBiuCommentInfo.mBiuComment;
        }
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localArrayList.add(new PositionalSpanStruct(j, j + ((String)localObject1).length(), new UserSpan(l, paramString, paramAbsBaseArticleInfo, paramInt)));
      }
      else if (localBiuCommentInfo.jumpInfo != null)
      {
        localObject2 = localBiuCommentInfo.jumpInfo.getWording();
        String str = localBiuCommentInfo.jumpInfo.getJumpUrl();
        if (localBiuCommentInfo.mBiuComment == null) {
          localObject1 = "";
        } else {
          localObject1 = localBiuCommentInfo.mBiuComment;
        }
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject1);
        localArrayList.add(new PositionalSpanStruct(j, ((String)localObject2).length() + j, new JumpSpan(str, 13421772)));
      }
      j = localStringBuilder.length();
      i -= 1;
    }
    paramAbsBaseArticleInfo = new SpannableStringBuilder(new QQText(localStringBuilder, 3, 16));
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      paramRefreshUserInfoCallBack = (PositionalSpanStruct)paramString.next();
      paramAbsBaseArticleInfo.setSpan(paramRefreshUserInfoCallBack.a(), paramRefreshUserInfoCallBack.a(), paramRefreshUserInfoCallBack.b(), 17);
    }
    return paramAbsBaseArticleInfo;
  }
  
  public static SpannableStringBuilder a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, List<BiuCommentInfo> paramList)
  {
    return a(-15504151, paramAbsBaseArticleInfo, paramString, paramRefreshUserInfoCallBack, paramList);
  }
  
  public static SocializeFeedsInfo a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null)
    {
      QLog.d("SocializeFeedsInfoUtils", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_Long = PBFieldUtils.a(paramSocializeFeedsInfo.uint64_feeds_id);
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a(paramSocializeFeedsInfo);
    localSocializeFeedsInfo.jdField_a_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_feeds_style);
    localSocializeFeedsInfo.jdField_b_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_like_count);
    localSocializeFeedsInfo.jdField_d_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_comments_count);
    localSocializeFeedsInfo.jdField_e_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_biu_time);
    localSocializeFeedsInfo.jdField_c_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_myself_like_status);
    localSocializeFeedsInfo.i = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_follow_counts);
    localSocializeFeedsInfo.h = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_follow_status);
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo = ShareWebPageInfo.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("create SocialFeedsInfo, feedsID : ");
    ((StringBuilder)localObject).append(localSocializeFeedsInfo.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(", followCnt : ");
    ((StringBuilder)localObject).append(localSocializeFeedsInfo.i);
    ((StringBuilder)localObject).append(", followStatus : ");
    ((StringBuilder)localObject).append(localSocializeFeedsInfo.h);
    ((StringBuilder)localObject).append(", masterUin : ");
    ((StringBuilder)localObject).append(localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(", followStatusHas : ");
    ((StringBuilder)localObject).append(paramSocializeFeedsInfo.uint32_follow_status.has());
    QLog.d("SocializeFeedsInfoUtils", 1, ((StringBuilder)localObject).toString());
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject).next();
        FeedsInfoUser localFeedsInfoUser = new FeedsInfoUser();
        long l;
        if ((localSocializeFeedsInfoUser.has()) && (localSocializeFeedsInfoUser.get() != null)) {
          l = PBFieldUtils.a(localSocializeFeedsInfoUser.uint64_uin);
        } else {
          l = 0L;
        }
        localFeedsInfoUser.jdField_a_of_type_Long = l;
        int i;
        if ((localSocializeFeedsInfoUser.has()) && (localSocializeFeedsInfoUser.get() != null)) {
          i = PBFieldUtils.a(localSocializeFeedsInfoUser.enum_uin_type);
        } else {
          i = 0;
        }
        localFeedsInfoUser.jdField_a_of_type_Int = i;
        localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localFeedsInfoUser);
      }
    }
    if ((paramSocializeFeedsInfo.bytes_comments.has()) && (paramSocializeFeedsInfo.bytes_comments.get() != null)) {
      try
      {
        localObject = new String(paramSocializeFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
        localSocializeFeedsInfo.jdField_b_of_type_JavaLangString = ((String)localObject);
        localSocializeFeedsInfo.jdField_a_of_type_JavaLangString = EmotionCodecUtils.b((String)localObject);
      }
      catch (Exception localException1)
      {
        QLog.d("SocializeFeedsInfoUtils", 1, "parse bytes_comments failed ", localException1);
      }
    }
    if ((paramSocializeFeedsInfo.bytes_recommend_reason.has()) && (paramSocializeFeedsInfo.bytes_recommend_reason.get() != null)) {
      try
      {
        localSocializeFeedsInfo.jdField_c_of_type_JavaLangString = new String(paramSocializeFeedsInfo.bytes_recommend_reason.get().toByteArray(), "utf-8");
      }
      catch (Exception localException2)
      {
        QLog.d("SocializeFeedsInfoUtils", 1, "parse bytes_comments reason failed ", localException2);
      }
    }
    if ((paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.has()) && (paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get() != null)) {
      localSocializeFeedsInfo.jdField_a_of_type_ArrayOfByte = ((articlesummary.SocializeFeedsExtInfo)paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get()).toByteArray();
    }
    localSocializeFeedsInfo.jdField_f_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_biu_count);
    localSocializeFeedsInfo.jdField_g_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = ((BiuInfo)PBFieldUtils.a(paramSocializeFeedsInfo.msg_biu_mutli_level, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo, new SocializeFeedsInfoUtils.1(localSocializeFeedsInfo)));
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo = ((GameLiveInfo)PBFieldUtils.a(paramSocializeFeedsInfo.game_live_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityGameLiveInfo, new SocializeFeedsInfoUtils.2()));
    localSocializeFeedsInfo.jdField_b_of_type_Long = PBFieldUtils.a(paramSocializeFeedsInfo.uint64_article_id, localSocializeFeedsInfo.jdField_b_of_type_Long);
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo = ((UGCFeedsInfo)PBFieldUtils.a(paramSocializeFeedsInfo.msg_ugc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo, new SocializeFeedsInfoUtils.3(localSocializeFeedsInfo)));
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo = ((PGCFeedsInfo)PBFieldUtils.a(paramSocializeFeedsInfo.msg_pgc_topic_feeds_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo, new SocializeFeedsInfoUtils.4()));
    if (paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has())
    {
      localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
      QLog.d("SocializeFeedsInfoUtils", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo });
    }
    if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
    {
      localSocializeFeedsInfo.jdField_d_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
      QLog.d("SocializeFeedsInfoUtils", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.jdField_d_of_type_JavaLangString });
    }
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo = ((WendaInfo)PBFieldUtils.a(paramSocializeFeedsInfo.wenda_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityWendaInfo, new SocializeFeedsInfoUtils.5()));
    localSocializeFeedsInfo.j = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo = ((IconWordingInfo)PBFieldUtils.a(paramSocializeFeedsInfo.icon_wording_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityIconWordingInfo, new SocializeFeedsInfoUtils.6()));
    localSocializeFeedsInfo.k = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_feed_status, localSocializeFeedsInfo.k);
    localSocializeFeedsInfo.jdField_e_of_type_JavaLangString = PBFieldUtils.a(paramSocializeFeedsInfo.bytes_private_status_title, localSocializeFeedsInfo.jdField_e_of_type_JavaLangString);
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo = ((LocationInfo)PBFieldUtils.a(paramSocializeFeedsInfo.location_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLocationInfo, new SocializeFeedsInfoUtils.7()));
    if (paramSocializeFeedsInfo.uint32_is_jump_recommend_page.has())
    {
      localSocializeFeedsInfo.l = PBFieldUtils.a(paramSocializeFeedsInfo.uint32_is_jump_recommend_page);
      localSocializeFeedsInfo.jdField_f_of_type_JavaLangString = PBFieldUtils.a(paramSocializeFeedsInfo.bytes_jump_recommend_url, localSocializeFeedsInfo.jdField_f_of_type_JavaLangString);
      if (paramSocializeFeedsInfo.bytes_jump_recommend_prompt.has()) {
        localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = paramSocializeFeedsInfo.bytes_jump_recommend_prompt.get().toStringUtf8();
      }
      localSocializeFeedsInfo.jdField_g_of_type_JavaLangString = PBFieldUtils.a(paramSocializeFeedsInfo.bytes_jump_recommend_prompt, localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse jumpchannel ");
      localStringBuilder.append(localSocializeFeedsInfo.l);
      localStringBuilder.append("  ");
      localStringBuilder.append(localSocializeFeedsInfo.jdField_f_of_type_JavaLangString);
      localStringBuilder.append("  ");
      localStringBuilder.append(localSocializeFeedsInfo.jdField_g_of_type_JavaLangString);
      QLog.d("SocializeFeedsInfoUtils", 1, localStringBuilder.toString());
    }
    if (paramSocializeFeedsInfo.visible_info.has()) {
      localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo = ((PrivacyShowInfo)PBFieldUtils.a(paramSocializeFeedsInfo.visible_info.visible_show_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPrivacyShowInfo, new SocializeFeedsInfoUtils.8()));
    }
    if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
      a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
    }
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo = ((BuluoInfo)PBFieldUtils.a(paramSocializeFeedsInfo.buluo_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo, new SocializeFeedsInfoUtils.9()));
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo = ((LongContentInfo)PBFieldUtils.a(paramSocializeFeedsInfo.long_content_info, localSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo, new SocializeFeedsInfoUtils.10()));
    localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo = ((articlesummary.ColumnTopicInfo)PBFieldUtils.a(paramSocializeFeedsInfo.msg_column_topic_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo));
    localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo = ((articlesummary.TopicEntranceInfo)PBFieldUtils.a(paramSocializeFeedsInfo.msg_topic_entrance_info, localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo));
    return localSocializeFeedsInfo;
  }
  
  public static UGCFeedsInfo a(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.UGCFeedsInfo paramUGCFeedsInfo)
  {
    UGCFeedsInfo localUGCFeedsInfo = new UGCFeedsInfo();
    localUGCFeedsInfo.jdField_a_of_type_Int = RIJPBFieldUtils.a(paramUGCFeedsInfo.enum_ugc_feeds_card_type, 0);
    localUGCFeedsInfo.jdField_a_of_type_Long = RIJPBFieldUtils.a(paramUGCFeedsInfo.uint64_cuin, 0L);
    localUGCFeedsInfo.jdField_b_of_type_Int = RIJPBFieldUtils.a(paramUGCFeedsInfo.enum_ugc_feeds_src, 0);
    localUGCFeedsInfo.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramUGCFeedsInfo.bytes_ugc_comments);
    if ((paramUGCFeedsInfo.msg_at_multi_level.has()) && (paramUGCFeedsInfo.msg_at_multi_level.get() != null)) {
      localUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo = b(paramSocializeFeedsInfo, paramUGCFeedsInfo.msg_at_multi_level);
    }
    if (paramUGCFeedsInfo.account_profile.has()) {
      localUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo = AccountProfileInfo.a((feeds_info.AccountProfile)paramUGCFeedsInfo.account_profile.get());
    }
    Object localObject1;
    Object localObject2;
    if (paramUGCFeedsInfo.msg_ugc_pic_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_pic_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCPicInfo)paramSocializeFeedsInfo.next();
        localObject2 = new UGCPicInfo();
        ((UGCPicInfo)localObject2).jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_md5);
        ((UGCPicInfo)localObject2).jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).bytes_pic_url);
        ((UGCPicInfo)localObject2).jdField_b_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_height);
        ((UGCPicInfo)localObject2).jdField_a_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).uint32_pic_width);
        ((UGCPicInfo)localObject2).jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).bytes_thumbnail_url);
        ((UGCPicInfo)localObject2).jdField_c_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCPicInfo)localObject1).is_animation);
        localUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_video_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_video_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVideoInfo)paramSocializeFeedsInfo.next();
        localObject2 = new UGCVideoInfo();
        ((UGCVideoInfo)localObject2).jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_md5);
        ((UGCVideoInfo)localObject2).jdField_d_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_pic_url);
        ((UGCVideoInfo)localObject2).jdField_e_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_title);
        ((UGCVideoInfo)localObject2).jdField_f_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uuid);
        ((UGCVideoInfo)localObject2).jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_md5);
        ((UGCVideoInfo)localObject2).jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_video_url);
        ((UGCVideoInfo)localObject2).h = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_share_url);
        ((UGCVideoInfo)localObject2).i = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_vid);
        ((UGCVideoInfo)localObject2).jdField_g_of_type_JavaLangString = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).bytes_uniq_id);
        ((UGCVideoInfo)localObject2).jdField_f_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_busi_type);
        ((UGCVideoInfo)localObject2).jdField_e_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_create_time);
        ((UGCVideoInfo)localObject2).jdField_a_of_type_Long = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint64_duration);
        ((UGCVideoInfo)localObject2).jdField_a_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_width);
        ((UGCVideoInfo)localObject2).jdField_b_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_video_height);
        ((UGCVideoInfo)localObject2).jdField_c_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_width);
        ((UGCVideoInfo)localObject2).jdField_d_of_type_Int = RIJPBFieldUtils.a(((articlesummary.UGCVideoInfo)localObject1).uint32_pic_height);
        localUGCFeedsInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    if (paramUGCFeedsInfo.msg_ugc_voice_info_list.has())
    {
      paramSocializeFeedsInfo = paramUGCFeedsInfo.msg_ugc_voice_info_list.get().iterator();
      while (paramSocializeFeedsInfo.hasNext())
      {
        localObject1 = (articlesummary.UGCVoiceInfo)paramSocializeFeedsInfo.next();
        localObject2 = new UGCVoiceInfo();
        ((UGCVoiceInfo)localObject2).voiceUrl = ((articlesummary.UGCVoiceInfo)localObject1).bytes_voice_url.get().toStringUtf8();
        ((UGCVoiceInfo)localObject2).duration = ((articlesummary.UGCVoiceInfo)localObject1).uint32_duration.get();
        ((UGCVoiceInfo)localObject2).fileSize = ((articlesummary.UGCVoiceInfo)localObject1).uint32_file_size.get();
        localUGCFeedsInfo.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
      }
    }
    localUGCFeedsInfo.jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(paramUGCFeedsInfo.bytes_jump_url);
    return localUGCFeedsInfo;
  }
  
  public static BiuCommentInfo a(articlesummary.BiuOneLevelItem paramBiuOneLevelItem)
  {
    BiuCommentInfo localBiuCommentInfo = new BiuCommentInfo();
    localBiuCommentInfo.mUin = Long.valueOf(PBFieldUtils.a(paramBiuOneLevelItem.uint64_uin));
    localBiuCommentInfo.mFeedId = Long.valueOf(PBFieldUtils.a(paramBiuOneLevelItem.uint64_feeds_id));
    localBiuCommentInfo.mBiuTime = PBFieldUtils.a(paramBiuOneLevelItem.uint32_biu_time);
    localBiuCommentInfo.mFeedsType = PBFieldUtils.a(paramBiuOneLevelItem.feeds_type);
    localBiuCommentInfo.mOpType = PBFieldUtils.a(paramBiuOneLevelItem.op_type);
    if ((paramBiuOneLevelItem.bytes_biu_comments.has()) && (paramBiuOneLevelItem.bytes_biu_comments.get() != null)) {
      try
      {
        String str = new String(paramBiuOneLevelItem.bytes_biu_comments.get().toByteArray(), "utf-8");
        localBiuCommentInfo.mOrigBiuComment = str;
        localBiuCommentInfo.mBiuComment = EmotionCodecUtils.b(str);
      }
      catch (Exception localException)
      {
        QLog.d("SocializeFeedsInfoUtils", 1, "parse bytes_biu_comment failed ", localException);
      }
    }
    if ((paramBiuOneLevelItem.msg_jump_info.has()) && (paramBiuOneLevelItem.msg_jump_info.get() != null))
    {
      paramBiuOneLevelItem = (articlesummary.JumpInfo)paramBiuOneLevelItem.msg_jump_info.get();
      localBiuCommentInfo.jumpInfo = new JumpInfo(PBFieldUtils.a(paramBiuOneLevelItem.uint64_id), paramBiuOneLevelItem.bytes_wording.get().toStringUtf8(), paramBiuOneLevelItem.bytes_jump_url.get().toStringUtf8());
    }
    return localBiuCommentInfo;
  }
  
  private static void a(SocializeFeedsInfo paramSocializeFeedsInfo, List<oidb_cmd0xb57.MedalInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = (oidb_cmd0xb57.MedalInfo)paramList.get(0);
      paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo = new ReadInJoyMedalInfo();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_c_of_type_JavaLangString = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_b_of_type_Int = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_a_of_type_Int = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_a_of_type_Long = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_a_of_type_JavaLangString = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_b_of_type_JavaLangString = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_c_of_type_Int = paramList.uint32_pic_width.get();
      }
      if (paramList.uint32_pic_height.has()) {
        paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyMedalInfo.jdField_d_of_type_Int = paramList.uint32_pic_height.get();
      }
    }
  }
  
  public static void a(SocializeFeedsInfo paramSocializeFeedsInfo, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo1)
  {
    if (paramSocializeFeedsInfo1 == null) {
      return;
    }
    paramSocializeFeedsInfo.jdField_b_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_like_count);
    paramSocializeFeedsInfo.jdField_d_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_comments_count);
    paramSocializeFeedsInfo.jdField_c_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_myself_like_status);
    paramSocializeFeedsInfo.jdField_f_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_biu_count);
    paramSocializeFeedsInfo.jdField_g_of_type_Int = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo1.uint32_follow_count.has()) {
      paramSocializeFeedsInfo.i = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo1.uint32_follow_status.has()) {
      paramSocializeFeedsInfo.h = PBFieldUtils.a(paramSocializeFeedsInfo1.uint32_follow_status);
    }
    paramSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1;
    Object localObject2;
    if ((paramSocializeFeedsInfo1.rpt_recommend_list.has()) && (paramSocializeFeedsInfo1.rpt_recommend_list.get() != null))
    {
      localObject1 = paramSocializeFeedsInfo1.rpt_recommend_list.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0x8c8.SocializeFeedsInfoUser)((Iterator)localObject1).next();
        FeedsInfoUser localFeedsInfoUser = new FeedsInfoUser();
        long l;
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {
          l = PBFieldUtils.a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);
        } else {
          l = 0L;
        }
        localFeedsInfoUser.jdField_a_of_type_Long = l;
        paramSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.add(localFeedsInfoUser);
      }
    }
    if ((paramSocializeFeedsInfo1.msg_topic_recommend_feeds_info.has()) && (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo != null) && (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramSocializeFeedsInfo1 = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo1.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo1.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo1 = paramSocializeFeedsInfo1.msg_topic_recommend_info.get();
        int i = 0;
        while ((i < paramSocializeFeedsInfo1.size()) && (i < paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo1.get(i);
          localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_b_of_type_Int = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
          }
          i += 1;
        }
      }
    }
    paramSocializeFeedsInfo1 = new StringBuilder();
    paramSocializeFeedsInfo1.append("8c8 update followStatus : ");
    paramSocializeFeedsInfo1.append(paramSocializeFeedsInfo.h);
    paramSocializeFeedsInfo1.append(", followCnt : ");
    paramSocializeFeedsInfo1.append(paramSocializeFeedsInfo.h);
    paramSocializeFeedsInfo1.append(", feedsID : ");
    paramSocializeFeedsInfo1.append(paramSocializeFeedsInfo.jdField_a_of_type_Long);
    QLog.d("SocializeFeedsInfoUtils", 2, paramSocializeFeedsInfo1.toString());
  }
  
  private static BiuInfo b(SocializeFeedsInfo paramSocializeFeedsInfo, articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    BiuInfo localBiuInfo = new BiuInfo();
    localBiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(PBFieldUtils.a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localBiuInfo.b = Long.valueOf(PBFieldUtils.a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localBiuInfo.jdField_a_of_type_JavaUtilList.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfoUtils", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long), ", mOriFeedType = ", localBiuInfo.b });
    return localBiuInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils
 * JD-Core Version:    0.7.0.1
 */