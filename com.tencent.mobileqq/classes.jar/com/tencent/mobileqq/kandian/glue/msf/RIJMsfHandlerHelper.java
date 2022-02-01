package com.tencent.mobileqq.kandian.glue.msf;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.MultiBiuSameContentUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArkAppFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.KandianLiveInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.RichTitleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ScripCmsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ShortWithLongContentUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AccountVInfo;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.CardExInfo;
import tencent.im.oidb.articlesummary.articlesummary.CardJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.DiandianLabel;
import tencent.im.oidb.articlesummary.articlesummary.DiandianWording;
import tencent.im.oidb.articlesummary.articlesummary.DisLikeInfo;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.FusionInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UserIdentityIcon;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeChatVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RichTips;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJMsfHandlerHelper
{
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    PBRepeatMessageField localPBRepeatMessageField = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(localPBRepeatMessageField.computeSize(1));
    CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
    localPBRepeatMessageField.addAll(paramAbsBaseArticleInfo.srtUniversalID);
    try
    {
      localPBRepeatMessageField.writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      paramAbsBaseArticleInfo.srtUniversalIDBytesList = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (IOException paramAbsBaseArticleInfo)
    {
      label51:
      break label51;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 1, "convertPBToBytes failed $e");
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null)
    {
      paramAbsBaseArticleInfo.mFeedType = 0;
      return;
    }
    paramAbsBaseArticleInfo.mFeedType = RIJPBFieldUtils.a(paramFeedsInfo.feeds_type);
    if ((paramFeedsInfo.uint32_business_id.has()) && ((paramAbsBaseArticleInfo.mPolymericInfo == null) || (paramAbsBaseArticleInfo.mPolymericInfo.e != 9))) {
      paramAbsBaseArticleInfo.businessId = RIJPBFieldUtils.a(paramFeedsInfo.uint32_business_id);
    }
    paramAbsBaseArticleInfo.mFeedCookie = RIJPBFieldUtils.a(paramFeedsInfo.bytes_feeds_cookie, "");
    paramAbsBaseArticleInfo.businessName = RIJPBFieldUtils.a(paramFeedsInfo.bytes_business_name, "");
    paramAbsBaseArticleInfo.businessUrl = RIJPBFieldUtils.a(paramFeedsInfo.bytes_business_url, "");
    paramAbsBaseArticleInfo.businessNamePrefix = RIJPBFieldUtils.a(paramFeedsInfo.bytes_business_name_prefix, "");
    b(paramAbsBaseArticleInfo, paramFeedsInfo);
    c(paramAbsBaseArticleInfo, paramFeedsInfo);
    d(paramAbsBaseArticleInfo, paramFeedsInfo);
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.SocializeFeedsInfo)RIJPBFieldUtils.a(paramFeedsInfo.msg_social_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramAbsBaseArticleInfo.mSocialFeedInfo = SocializeFeedsInfoUtils.a(paramFeedsInfo);
      paramAbsBaseArticleInfo.mSocialFeedInfoByte = paramFeedsInfo.toByteArray();
      paramAbsBaseArticleInfo.mFeedId = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseSocializeFeedsInfo summary.msg_social_feeds_info is null");
    }
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.TopicRecommendFeedsInfo)RIJPBFieldUtils.a(paramFeedsInfo.msg_topic_recommend_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo = TopicRecommendFeedsInfo.a(paramFeedsInfo);
      paramAbsBaseArticleInfo.mTopicRecommendFeedsInfoByte = paramFeedsInfo.toByteArray();
      paramAbsBaseArticleInfo.mFeedId = paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseTopicRecommendFeedsInfo summary.msg_topic_recommend_feeds_info is null");
    }
  }
  
  private void d(AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.ArkAppFeedsInfo)RIJPBFieldUtils.a(paramFeedsInfo.msg_ark_app_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramAbsBaseArticleInfo.mArkAppFeedsInfo = ArkAppFeedsInfo.a(paramFeedsInfo);
      paramAbsBaseArticleInfo.mArkAppFeedsInfoBytes = paramFeedsInfo.toByteArray();
      paramAbsBaseArticleInfo.mFeedId = paramAbsBaseArticleInfo.mArkAppFeedsInfo.a;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseArkAppFeedsInfo summary.msg_ark_app_feeds_info is null");
    }
  }
  
  private void m(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.FeedsInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_feeds_info);
    if (paramArticleSummary != null)
    {
      a(paramAbsBaseArticleInfo, paramArticleSummary);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseFeedsInfo summary.msg_feeds_info is null");
    }
  }
  
  private void n(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.RecommendFollowInfos)RIJPBFieldUtils.a(paramArticleSummary.recommend_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.mRecommendFollowInfos = RecommendFollowInfos.a(paramArticleSummary);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseRecommendFollowInfo summary.recommend_info is null");
    }
  }
  
  private void o(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.HotWordInfo)RIJPBFieldUtils.a(paramArticleSummary.hot_word_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.hotWordInfo = HotWordInfo.a(paramArticleSummary);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseHotWordInfo summary.hot_word_info is null");
    }
  }
  
  private void p(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.PartnerAccountInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_partner_account_info);
    if (paramArticleSummary != null)
    {
      PBUInt32Field localPBUInt32Field = paramArticleSummary.uint32_is_wechat_video;
      boolean bool = false;
      localPBUInt32Field.set(0);
      paramArticleSummary.uint32_watch_see_later.set(0);
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_account_display) != 0) {
        bool = true;
      }
      paramAbsBaseArticleInfo.isAccountShown = bool;
      paramAbsBaseArticleInfo.mPartnerAccountInfo = paramArticleSummary;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseProteusItemsData summary.msg_partner_account_info is null");
    }
  }
  
  private void q(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramArticleSummary.msg_srt_universal_id.has()) {
      paramAbsBaseArticleInfo.srtUniversalID = paramArticleSummary.msg_srt_universal_id.get();
    }
    if ((paramAbsBaseArticleInfo.srtUniversalID != null) && (!paramAbsBaseArticleInfo.srtUniversalID.isEmpty()))
    {
      a(paramAbsBaseArticleInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseUniversalID summary.msg_srt_universal_id is null");
    }
  }
  
  private void r(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.AccountVInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_account_v_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.vIconUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_v_icon_url);
      boolean bool;
      if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_unowned) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramAbsBaseArticleInfo.unowned = bool;
      paramArticleSummary = (articlesummary.UserIdentityIcon)RIJPBFieldUtils.a(paramArticleSummary.user_identity_icon);
      if (paramArticleSummary != null)
      {
        paramAbsBaseArticleInfo.upIconUrl = RIJPBFieldUtils.a(paramArticleSummary.icon_url, "");
        return;
      }
      QLog.e("ReadInJoyMSFHandlerUtils", 1, "parseAccountVInfo summary.user_identity_icon is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseUniversalID summary.msg_account_v_info is null");
    }
  }
  
  private void s(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(paramArticleSummary.video_multi_column_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.multiVideoColumnInfoBytes = paramArticleSummary.toByteArray();
      paramAbsBaseArticleInfo.multiVideoColumnInfo = MultiVideoColumnInfo.a(paramArticleSummary);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseMultiVideoColumnInfo summary.video_multi_column_info is null");
    }
  }
  
  private void t(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.KdLiveInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_kd_live_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.mKdLiveInfoBytes = paramArticleSummary.toByteArray();
      paramAbsBaseArticleInfo.mKdLiveInfo = KandianLiveInfo.a(paramArticleSummary);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseKdLiveInfo summary.msg_kd_live_info is null");
    }
  }
  
  private void u(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.WeishiUGInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_ug_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.weishiUGInfo = paramArticleSummary;
      paramAbsBaseArticleInfo.mWeishiUGInfo = paramArticleSummary.toByteArray();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseWeiShiUGInfo summary.msg_ug_info is null");
    }
  }
  
  private void v(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.NewPackInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_new_pack_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.mNewPolymericInfo = NewPolymericInfo.a(paramArticleSummary);
      if ((paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.size() > 0)) {
        paramAbsBaseArticleInfo.businessId = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0)).a;
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseNewPackInfo summary.msg_new_pack_info is null");
    }
  }
  
  private static void w(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo.titleWithTopicJson = RIJPBFieldUtils.a(paramArticleSummary.bytes_title_with_topic);
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.titleWithTopicJson)) {
      return;
    }
    paramAbsBaseArticleInfo.richTitleInfoList = new ArrayList();
    try
    {
      paramArticleSummary = new JSONObject(paramAbsBaseArticleInfo.titleWithTopicJson).getJSONArray("rpt_biu_mutli_level");
      int i = paramArticleSummary.length() - 1;
      while (i >= 0)
      {
        RichTitleInfo localRichTitleInfo = new RichTitleInfo((JSONObject)paramArticleSummary.get(i));
        paramAbsBaseArticleInfo.richTitleInfoList.add(localRichTitleInfo);
        i -= 1;
      }
    }
    catch (Exception paramArticleSummary)
    {
      label94:
      break label94;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 1, "parseRichTitleInfo failed $e");
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo.mArticleID = RIJPBFieldUtils.a(paramArticleSummary.uint64_article_id);
    paramAbsBaseArticleInfo.mTitle = RIJPBFieldUtils.a(paramArticleSummary.bytes_article_title, "");
    paramAbsBaseArticleInfo.mSummary = RIJPBFieldUtils.a(paramArticleSummary.bytes_article_summary, "");
    paramAbsBaseArticleInfo.mFirstPagePicUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_first_page_pic_url, "");
    paramAbsBaseArticleInfo.mOriginalUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_original_url, "");
    paramAbsBaseArticleInfo.mArticleContentUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_article_content_url, "");
    paramAbsBaseArticleInfo.mTime = RIJPBFieldUtils.a(paramArticleSummary.uint64_time);
    paramAbsBaseArticleInfo.mCommentCount = RIJPBFieldUtils.a(paramArticleSummary.uint32_comment_count);
    paramAbsBaseArticleInfo.mSubscribeID = RIJPBFieldUtils.a(paramArticleSummary.bytes_subscribe_id, "");
    paramAbsBaseArticleInfo.mSubscribeName = RIJPBFieldUtils.a(paramArticleSummary.bytes_subscribe_name, "");
    paramAbsBaseArticleInfo.mRecommendTime = RIJPBFieldUtils.a(paramArticleSummary.uint64_recommend_time);
    paramAbsBaseArticleInfo.mRecommendSeq = RIJPBFieldUtils.a(paramArticleSummary.uint64_recommend_seq);
    int i = RIJPBFieldUtils.a(paramArticleSummary.uint32_show_big_picture);
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramAbsBaseArticleInfo.mShowBigPicture = bool1;
    paramAbsBaseArticleInfo.mAlgorithmID = RIJPBFieldUtils.a(paramArticleSummary.uint64_algorithm_id);
    paramAbsBaseArticleInfo.mJsonVideoList = RIJPBFieldUtils.a(paramArticleSummary.json_video_list);
    paramAbsBaseArticleInfo.mJsonPictureList = RIJPBFieldUtils.a(paramArticleSummary.json_picture_list);
    paramAbsBaseArticleInfo.mAbandonRepeatFlag = RIJPBFieldUtils.a(paramArticleSummary.uint32_abandon_repeat_flag);
    paramAbsBaseArticleInfo.mArticleSubscriptText = RIJPBFieldUtils.a(paramArticleSummary.bytes_test);
    paramAbsBaseArticleInfo.mArticleSubscriptColor = RIJPBFieldUtils.a(paramArticleSummary.bytes_colour);
    paramAbsBaseArticleInfo.mStrategyId = RIJPBFieldUtils.a(paramArticleSummary.uint32_strategy_id);
    paramAbsBaseArticleInfo.mMergeVideoId = RIJPBFieldUtils.a(paramArticleSummary.uint64_merged_video_id);
    paramAbsBaseArticleInfo.aioShareUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_aio_share_url);
    paramAbsBaseArticleInfo.qzoneShareUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_qzone_share_url);
    b(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mArticleFriendLikeText = RIJPBFieldUtils.a(paramArticleSummary.bytes_friend_like_wording);
    paramAbsBaseArticleInfo.mVideoType = RIJPBFieldUtils.a(paramArticleSummary.uint32_video_show_small_picture);
    paramAbsBaseArticleInfo.mCommentIconType = RIJPBFieldUtils.a(paramArticleSummary.uint32_comment_icon_type);
    paramAbsBaseArticleInfo.mServerContext = RIJPBFieldUtils.b(paramArticleSummary.bytes_server_context);
    c(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mIsDispTimestamp = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_disp_timestamp);
    d(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mIsGallery = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_gallery);
    if (paramAbsBaseArticleInfo.mIsGallery != 0) {
      paramAbsBaseArticleInfo.mGalleryPicNumber = RIJPBFieldUtils.a(paramArticleSummary.uint32_picture_number);
    }
    paramAbsBaseArticleInfo.innerUniqueID = RIJPBFieldUtils.a(paramArticleSummary.bytes_inner_uniq_id);
    f(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mCommentsObj = RIJPBFieldUtils.a(paramArticleSummary.rpt_comments);
    g(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mStrCircleId = RIJPBFieldUtils.a(paramArticleSummary.bytes_circle_id, "");
    if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_active) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramAbsBaseArticleInfo.mPUinIsActive = bool1;
    paramAbsBaseArticleInfo.mSubscribeInfoObj = ((articlesummary.SubscribeInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_subscribe_info));
    m(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mVideoPlayCount = RIJPBFieldUtils.a(paramArticleSummary.uint32_video_play_count);
    if (paramArticleSummary.rpt_label_list.has()) {
      paramAbsBaseArticleInfo.mLabelListObj = paramArticleSummary.rpt_label_list.get();
    }
    paramAbsBaseArticleInfo.mAccountLess = RIJPBFieldUtils.a(paramArticleSummary.is_accountless);
    paramAbsBaseArticleInfo.interfaceData = RIJPBFieldUtils.a(paramArticleSummary.bytes_interface_data);
    paramAbsBaseArticleInfo.galleryReprotExdData = RIJPBFieldUtils.a(paramArticleSummary.bytes_gallery_report_extdata);
    paramAbsBaseArticleInfo.articleStyle = RIJPBFieldUtils.a(paramArticleSummary.enum_article_style);
    b(paramArticleSummary, paramInt1, paramInt2, paramAbsBaseArticleInfo);
    e(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mVideoCommentCount = RIJPBFieldUtils.a(paramArticleSummary.uint32_video_comment_count);
    paramAbsBaseArticleInfo.mVideoArticleSubsText = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_subscript_txt);
    paramAbsBaseArticleInfo.mVideoArticleSubsColor = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_subscript_color);
    paramAbsBaseArticleInfo.mVideoAdsJumpUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_ads_jump_url);
    paramAbsBaseArticleInfo.mVideoAdsJumpType = RIJPBFieldUtils.a(paramArticleSummary.uint32_ads_jump_type);
    paramAbsBaseArticleInfo.mVideoAdsSource = RIJPBFieldUtils.a(paramArticleSummary.uint32_ads_source);
    paramAbsBaseArticleInfo.videoReportInfo = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_report_info);
    h(paramArticleSummary, paramAbsBaseArticleInfo);
    v(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mVideoDownloadBarInfo = ((articlesummary.VideoDownloadBarInfo)RIJPBFieldUtils.a(paramArticleSummary.video_download_bar_info));
    n(paramArticleSummary, paramAbsBaseArticleInfo);
    o(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.gifCoverUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_first_page_gif_url);
    if (RIJPBFieldUtils.a(paramArticleSummary.uint32_is_first_page_use_gif) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramAbsBaseArticleInfo.isUseGif = bool1;
    i(paramArticleSummary, paramAbsBaseArticleInfo);
    j(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.mGWCommonData = RIJPBFieldUtils.a(paramArticleSummary.bytes_gw_common_data);
    paramAbsBaseArticleInfo.mReportCommonData = RIJPBFieldUtils.a(paramArticleSummary.bytes_report_common_data);
    paramAbsBaseArticleInfo.mArticleType = RIJPBFieldUtils.a(paramArticleSummary.uint32_article_type);
    paramAbsBaseArticleInfo.isCloseDislike = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_close_dislike);
    paramAbsBaseArticleInfo.isSuperTop = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_super_top_article);
    paramAbsBaseArticleInfo.mVideoLogoUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_video_logo_url);
    p(paramArticleSummary, paramAbsBaseArticleInfo);
    k(paramArticleSummary, paramAbsBaseArticleInfo);
    articlesummary.VideoColumnInfo localVideoColumnInfo1 = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(paramArticleSummary.video_column_info);
    articlesummary.VideoColumnInfo localVideoColumnInfo2 = (articlesummary.VideoColumnInfo)RIJPBFieldUtils.a(paramArticleSummary.video_simple_column_info);
    paramAbsBaseArticleInfo.mVideoColumnInfo = VideoColumnInfo.a(localVideoColumnInfo1);
    paramAbsBaseArticleInfo.mSimpleVideoColumnInfo = VideoColumnInfo.a(localVideoColumnInfo2);
    paramAbsBaseArticleInfo.commentJumpUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_comment_button_jump_url);
    paramAbsBaseArticleInfo.mIsShowSearchord = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_show_search_word);
    paramAbsBaseArticleInfo.adReportCommonData = RIJPBFieldUtils.a(paramArticleSummary.bytes_ad_report_common_data);
    q(paramArticleSummary, paramAbsBaseArticleInfo);
    r(paramArticleSummary, paramAbsBaseArticleInfo);
    s(paramArticleSummary, paramAbsBaseArticleInfo);
    paramAbsBaseArticleInfo.columnStyle = RIJPBFieldUtils.a(paramArticleSummary.uint32_column_style);
    paramAbsBaseArticleInfo.isShowFollowButton = RIJPBFieldUtils.a(paramArticleSummary.uint32_is_show_follow_button);
    a(paramArticleSummary, paramInt2, paramAbsBaseArticleInfo);
    t(paramArticleSummary, paramAbsBaseArticleInfo);
    u(paramArticleSummary, paramAbsBaseArticleInfo);
    if (RIJPBFieldUtils.a(paramArticleSummary.uint32_expose_repeat_flag) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramAbsBaseArticleInfo.isNeeaRealExposureFilter = bool1;
    ShortWithLongContentUtil.a(paramAbsBaseArticleInfo);
    if (RIJPBFieldUtils.a(paramArticleSummary.uint32_red_package_flag) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramAbsBaseArticleInfo.hasWalletIcon = bool1;
    paramAbsBaseArticleInfo.smallGameData = RIJPBFieldUtils.a(paramArticleSummary.bytes_small_game_rsp_pack);
    paramAbsBaseArticleInfo.mSmallMiniGameInfo = SmallMiniGameInfo.a(paramAbsBaseArticleInfo.smallGameData);
    paramAbsBaseArticleInfo.columnEntrances = VideoColumnInfo.a(paramArticleSummary.card_column_entrances);
    boolean bool1 = bool2;
    if (RIJPBFieldUtils.a(paramArticleSummary.uint32_forbid_reprint_flag) == 1) {
      bool1 = true;
    }
    paramAbsBaseArticleInfo.isForbidReprint = bool1;
    paramAbsBaseArticleInfo.wechatShareUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_wechat_share_url);
    paramAbsBaseArticleInfo.dtReportContentType = RIJPBFieldUtils.a(paramArticleSummary.uint32_backend_content_type);
    if ((paramArticleSummary.msg_card_ex_info.has()) && (paramArticleSummary.msg_card_ex_info.bytes_owner_datacard_info.has())) {
      paramArticleSummary.bytes_interface_data.set(paramArticleSummary.msg_card_ex_info.bytes_owner_datacard_info.get());
    }
    if (paramArticleSummary.msg_card_ex_info.has()) {
      paramAbsBaseArticleInfo.mShareCount = RIJPBFieldUtils.a(paramArticleSummary.msg_card_ex_info.uint32_share_count);
    }
    a(paramArticleSummary, paramAbsBaseArticleInfo);
    w(paramArticleSummary, paramAbsBaseArticleInfo);
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.ScripCmsInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_scrip_cms_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.scripCmsInfo = ScripCmsInfo.a(paramArticleSummary);
      paramAbsBaseArticleInfo.scripCmsInfoByte = paramArticleSummary.toByteArray();
      if (paramInt == 7)
      {
        paramAbsBaseArticleInfo.scripCmsInfo.m = 1;
        return;
      }
      if (paramInt == 6) {
        paramAbsBaseArticleInfo.scripCmsInfo.m = 2;
      }
    }
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramArticleSummary.msg_wechat_video_info.has())
    {
      paramAbsBaseArticleInfo.mPartnerAccountInfo = new articlesummary.PartnerAccountInfo();
      paramAbsBaseArticleInfo.mPartnerAccountInfo.uint64_uin.set(paramArticleSummary.msg_wechat_video_info.uint64_uin.get());
      paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_account_type.set(paramArticleSummary.msg_wechat_video_info.uint32_account_type.get());
      paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_recommend_reason.set(paramArticleSummary.msg_wechat_video_info.bytes_recommend_reason.get());
      paramAbsBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url.set(paramArticleSummary.msg_wechat_video_info.bytes_v_icon_url.get());
      paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_is_wechat_video.set(1);
      paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_watch_see_later.set(0);
      paramAbsBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.set(1);
      paramAbsBaseArticleInfo.isAccountShown = true;
    }
  }
  
  public void a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    paramChannelCoverInfo.mChannelCoverId = RIJPBFieldUtils.a(paramChannelInfo.uint32_channel_id, -1);
    Object localObject = paramChannelInfo.bytes_channel_name;
    String str = "";
    paramChannelCoverInfo.mChannelCoverName = RIJPBFieldUtils.a((PBBytesField)localObject, "");
    paramChannelCoverInfo.mChannelCoverStyle = RIJPBFieldUtils.a(paramChannelInfo.enum_channel_cover_style);
    paramChannelCoverInfo.mFollowType = RIJPBFieldUtils.a(paramChannelInfo.uint32_is_followed, -1);
    paramChannelCoverInfo.mColumnType = RIJPBFieldUtils.b(paramChannelInfo.enum_column_type, -1);
    paramChannelCoverInfo.mFontColor = RIJPBFieldUtils.a(paramChannelInfo.uint32_fonts_color, -1291845632);
    paramChannelCoverInfo.mFrameColor = RIJPBFieldUtils.a(paramChannelInfo.uint32_frame_color, -3355444);
    paramChannelCoverInfo.mChannelId = paramInt;
    paramChannelCoverInfo.mArticleId = RIJPBFieldUtils.a(paramChannelInfo.uint64_channel_cover_article_id, -1L);
    paramChannelCoverInfo.mChannelType = RIJPBFieldUtils.a(paramChannelInfo.uint32_channel_type, -1);
    boolean bool;
    if (RIJPBFieldUtils.a(paramChannelInfo.uint32_is_topic) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramChannelCoverInfo.mIsTopic = bool;
    if (RIJPBFieldUtils.a(paramChannelInfo.uint32_is_external_expose) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramChannelCoverInfo.isExternalExposure = bool;
    paramChannelCoverInfo.externalExposureBackgroundUrl = RIJPBFieldUtils.a(paramChannelInfo.bytes_is_external_bg_url, "");
    if (RIJPBFieldUtils.a(paramChannelInfo.uint32_has_recommend) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramChannelCoverInfo.isExternalExposurePersist = bool;
    try
    {
      localObject = RIJPBFieldUtils.b(paramChannelInfo.bytes_channel_cover_wording);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = new String((byte[])localObject);
      }
      paramChannelCoverInfo.mChannelCoverSummary = ((String)localObject);
      localObject = RIJPBFieldUtils.b(paramChannelInfo.bytes_channel_cover_spec);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = new String((byte[])localObject);
      }
      paramChannelCoverInfo.mChannelCoverSpec = ((String)localObject);
      localObject = new JSONObject(paramChannelCoverInfo.mChannelCoverSpec).getString("filterColor");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramChannelCoverInfo.hasFilterColor = true;
        paramChannelCoverInfo.filterColor = Color.parseColor((String)localObject);
      }
      localObject = RIJPBFieldUtils.b(paramChannelInfo.bytes_channel_jump_url);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = new String((byte[])localObject);
      }
      paramChannelCoverInfo.mChannelJumpUrl = ((String)localObject);
      paramChannelCoverInfo.mColumnType = 1;
      localObject = RIJPBFieldUtils.b(paramChannelInfo.bytes_channel_cover_picurl);
      if (localObject == null) {
        localObject = "";
      } else {
        localObject = new String((byte[])localObject);
      }
      paramChannelCoverInfo.mChannelCoverPicUrl = ((String)localObject);
      localObject = (oidb_cmd0x69f.RichTips)RIJPBFieldUtils.a(paramChannelInfo.msg_rich_tips);
      if (localObject != null)
      {
        paramChannelCoverInfo.mTipsType = RIJPBFieldUtils.a(((oidb_cmd0x69f.RichTips)localObject).uint32_tips_type, -1);
        paramChannelCoverInfo.mUpdateTime = RIJPBFieldUtils.a(((oidb_cmd0x69f.RichTips)localObject).uint32_latest_sticky_time);
        localObject = RIJPBFieldUtils.b(((oidb_cmd0x69f.RichTips)localObject).bytes_tips_text);
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = new String((byte[])localObject);
        }
        paramChannelCoverInfo.mTipsText = ((String)localObject);
      }
      paramChannelInfo = RIJPBFieldUtils.b(paramChannelInfo.bytes_icon_url);
      if (paramChannelInfo == null) {
        paramChannelInfo = str;
      } else {
        paramChannelInfo = new String(paramChannelInfo);
      }
      paramChannelCoverInfo.mIconUrl = paramChannelInfo;
      return;
    }
    catch (Exception paramChannelInfo)
    {
      label530:
      break label530;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve channel cover info failed $e");
    paramChannelCoverInfo.mColumnType = 0;
  }
  
  public void b(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramArticleSummary.msg_sub_article_summary.has())
    {
      paramAbsBaseArticleInfo.mSubSummaryListObj = paramArticleSummary.msg_sub_article_summary.get();
      if (paramAbsBaseArticleInfo.mSubSummaryListObj.size() > 0)
      {
        paramArticleSummary = new ArrayList(paramAbsBaseArticleInfo.mSubSummaryListObj.size());
        int i = 0;
        Iterator localIterator = paramAbsBaseArticleInfo.mSubSummaryListObj.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = ReadInJoyMSFHandlerUtils.a((articlesummary.ArticleSummary)localIterator.next(), paramInt1, paramInt2, null);
          if (localObject != null)
          {
            paramArticleSummary.add(localObject);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("convertArticleInfo(): 解析 sub articleSummary【");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append("】 id : ");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
              ((StringBuilder)localObject).append(" seq : ");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mRecommendSeq);
              ((StringBuilder)localObject).append(" title : ");
              ((StringBuilder)localObject).append(RIJAppSetting.b(paramAbsBaseArticleInfo.mTitle));
              ((StringBuilder)localObject).append(" , groupID : ");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mGroupId);
              ((StringBuilder)localObject).append(" algorithmID : ");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mAlgorithmID);
              ((StringBuilder)localObject).append(" strategyId : ");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
              ((StringBuilder)localObject).append(" businessID : ");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.businessId);
              ((StringBuilder)localObject).append(" businessName :");
              ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.businessName);
              QLog.e("ReadInJoyMSFHandlerUtils", 2, ((StringBuilder)localObject).toString());
              i += 1;
            }
          }
        }
        paramAbsBaseArticleInfo.mSubArticleList = paramArticleSummary;
      }
    }
  }
  
  public void b(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo.mTopicPicInfo = RIJPBFieldUtils.a(paramArticleSummary.bytes_media_specs);
      if (paramAbsBaseArticleInfo.mTopicPicInfo == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramArticleSummary = new StringBuilder();
        paramArticleSummary.append("test to print media specs true, media_specs:");
        paramArticleSummary.append(paramAbsBaseArticleInfo.mTopicPicInfo);
        QLog.d("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.toString());
      }
      paramArticleSummary = new JSONObject(paramAbsBaseArticleInfo.mTopicPicInfo);
      int i = paramArticleSummary.optInt("topic_width");
      int j = paramArticleSummary.optInt("topic_height");
      if (j != 0)
      {
        double d1 = i;
        Double.isNaN(d1);
        d1 /= 1.0D;
        double d2 = j;
        Double.isNaN(d2);
        d1 /= d2;
        paramAbsBaseArticleInfo.mTopicPicWHRatio = d1;
      }
      paramAbsBaseArticleInfo.videoJumpChannelID = paramArticleSummary.optInt("jump_channel_id");
      paramAbsBaseArticleInfo.videoJumpChannelType = paramArticleSummary.optInt("jump_channel_type");
      paramAbsBaseArticleInfo.videoJumpChannelName = paramArticleSummary.optString("jump_channel_name");
      return;
    }
    catch (Exception paramArticleSummary)
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve bytes_media_specs failed ", paramArticleSummary);
      paramAbsBaseArticleInfo.mTopicPicInfo = "";
      paramAbsBaseArticleInfo.mTopicPicWHRatio = 0.0D;
      paramAbsBaseArticleInfo.videoJumpChannelID = -1;
      paramAbsBaseArticleInfo.videoJumpChannelType = -1;
      paramAbsBaseArticleInfo.videoJumpChannelName = "";
    }
  }
  
  public void c(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.ChannelInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_channel_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.mChannelInfoId = RIJPBFieldUtils.a(paramArticleSummary.uint32_channel_id);
      paramAbsBaseArticleInfo.mChannelInfoName = RIJPBFieldUtils.a(paramArticleSummary.bytes_channel_name);
      paramAbsBaseArticleInfo.mChannelInfoType = RIJPBFieldUtils.a(paramArticleSummary.uint32_channel_type);
      paramAbsBaseArticleInfo.mChannelInfoDisplayName = RIJPBFieldUtils.a(paramArticleSummary.bytes_channel_display_name);
    }
  }
  
  public void d(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo.bytesBusiData = RIJPBFieldUtils.b(paramArticleSummary.bytes_gallery_busi_data);
    if ((paramAbsBaseArticleInfo.bytesBusiData != null) && (paramAbsBaseArticleInfo.bytesBusiData.length > 0))
    {
      paramAbsBaseArticleInfo.mGalleryFeedsInfo = new galleryFeeds.GalleryFeedsInfo();
      try
      {
        paramAbsBaseArticleInfo.mGalleryFeedsInfo.mergeFrom(paramAbsBaseArticleInfo.bytesBusiData);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArticleSummary)
      {
        QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.getMessage());
      }
    }
  }
  
  public void e(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo.mRecommentdReason = RIJPBFieldUtils.a(paramArticleSummary.bytes_recommend_reason);
    if ((TextUtils.isEmpty(paramAbsBaseArticleInfo.mRecommentdReason)) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData))) {
      try
      {
        paramAbsBaseArticleInfo.mRecommentdReason = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optString("recommend_reason");
        return;
      }
      catch (JSONException paramArticleSummary)
      {
        QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.getMessage());
      }
    }
  }
  
  public void f(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramArticleSummary.rpt_dislike_list.has())
    {
      paramArticleSummary = paramArticleSummary.rpt_dislike_list.get();
      if ((paramArticleSummary != null) && (paramArticleSummary.size() > 0))
      {
        int j = paramArticleSummary.size();
        paramAbsBaseArticleInfo.mDislikeInfos = new ArrayList();
        int i = 0;
        while (i < j)
        {
          DislikeInfo localDislikeInfo = new DislikeInfo();
          localDislikeInfo.a((articlesummary.DisLikeInfo)paramArticleSummary.get(i));
          paramAbsBaseArticleInfo.mDislikeInfos.add(localDislikeInfo);
          i += 1;
        }
        paramAbsBaseArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramAbsBaseArticleInfo.mDislikeInfos);
      }
    }
  }
  
  public void g(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.PackInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_pack_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.mPackInfoObj = paramArticleSummary;
      paramAbsBaseArticleInfo.mGroupId = RIJPBFieldUtils.a(paramArticleSummary.uint64_pack_id);
      paramAbsBaseArticleInfo.mPolymericInfo = PolymericInfo.a(paramAbsBaseArticleInfo.mPackInfoObj);
    }
    if ((paramAbsBaseArticleInfo.mPolymericInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo.e == 9)) {
      paramAbsBaseArticleInfo.businessId = paramAbsBaseArticleInfo.mPolymericInfo.m;
    }
  }
  
  public void h(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    articlesummary.DiandianWording localDiandianWording = (articlesummary.DiandianWording)RIJPBFieldUtils.a(paramArticleSummary.diandian_wording);
    if (localDiandianWording != null)
    {
      paramAbsBaseArticleInfo.msgBoxBriefContent = RIJPBFieldUtils.a(localDiandianWording.bytes_msg_wording);
      paramAbsBaseArticleInfo.msgBoxBriefPreFix = RIJPBFieldUtils.a(localDiandianWording.bytes_uin_or_nick);
      paramAbsBaseArticleInfo.msgBoxBriefPreFixType = RIJPBFieldUtils.a(localDiandianWording.uint32_uin_type);
    }
    paramArticleSummary = (articlesummary.DiandianLabel)RIJPBFieldUtils.a(paramArticleSummary.diandian_label);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.mDianDianLabelIconUrl = RIJPBFieldUtils.a(paramArticleSummary.bytes_icon_url);
      paramAbsBaseArticleInfo.mDianDianLabelText = RIJPBFieldUtils.a(paramArticleSummary.bytes_icon_wording);
    }
  }
  
  public void i(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_aggregated_list.has()))
    {
      paramArticleSummary = (articlesummary.AggregatedList)paramArticleSummary.msg_feeds_info.msg_aggregated_list.get();
      paramAbsBaseArticleInfo.mExtraBiuBriefInfo = ExtraBiuBriefInfo.a(paramArticleSummary);
      if ((paramArticleSummary.uint32_aggregated_content_type.has()) && (paramArticleSummary.uint32_aggregated_content_type.get() == 2) && (paramArticleSummary.rpt_multi_biu_same_content.has()))
      {
        paramAbsBaseArticleInfo.multiBiuSameContentList = MultiBiuSameContentUtils.a(paramArticleSummary.rpt_multi_biu_same_content.get());
        paramAbsBaseArticleInfo.mMultiBiuSameListObj = paramArticleSummary.rpt_multi_biu_same_content.get();
      }
    }
  }
  
  public void j(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramArticleSummary = (articlesummary.FamilyCommentInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_family_comment_info);
    if (paramArticleSummary != null)
    {
      paramAbsBaseArticleInfo.familyCommentInfoByte = paramArticleSummary.toByteArray();
      FamilyCommentInfo localFamilyCommentInfo = new FamilyCommentInfo();
      localFamilyCommentInfo.a = RIJPBFieldUtils.a(paramArticleSummary.icon_url);
      localFamilyCommentInfo.b = RIJPBFieldUtils.a(paramArticleSummary.jump_url);
      localFamilyCommentInfo.c = RIJPBFieldUtils.a(paramArticleSummary.medal_urls_width);
      localFamilyCommentInfo.d = RIJPBFieldUtils.a(paramArticleSummary.medal_urls_height);
      paramAbsBaseArticleInfo.familyCommentInfo = localFamilyCommentInfo;
    }
  }
  
  public void k(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.has()))
    {
      Object localObject = (articlesummary.SocializeFeedsInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_feeds_info.msg_social_feeds_info);
      if (localObject != null)
      {
        localObject = (articlesummary.CardJumpInfo)RIJPBFieldUtils.a(((articlesummary.SocializeFeedsInfo)localObject).msg_card_jump_info);
        if (localObject != null)
        {
          paramAbsBaseArticleInfo.mCardJumpUrl = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).bytes_card_jump_url);
          paramAbsBaseArticleInfo.isCardJumpUrlAvailable = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).uint32_available);
          paramAbsBaseArticleInfo.commentBtnJumpUrl = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).bytes_comment_btn_url);
          paramAbsBaseArticleInfo.commentShareUrl = RIJPBFieldUtils.a(((articlesummary.CardJumpInfo)localObject).bytes_share_url);
        }
        paramArticleSummary = (articlesummary.FusionInfo)RIJPBFieldUtils.a(paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_fusion_info);
        if (paramArticleSummary != null)
        {
          paramAbsBaseArticleInfo.commentId = RIJPBFieldUtils.a(paramArticleSummary.str_comment_id);
          paramAbsBaseArticleInfo.commentSrc = RIJPBFieldUtils.a(paramArticleSummary.uint32_comment_src);
        }
      }
    }
  }
  
  public void l(articlesummary.ArticleSummary paramArticleSummary, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo.proteusItemsData = RIJPBFieldUtils.a(paramArticleSummary.bytes_interface_data);
    if (paramAbsBaseArticleInfo.proteusItemsData != null)
    {
      RIJPreParseData.c(paramAbsBaseArticleInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseProteusItemsData summary.bytes_interface_data is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.RIJMsfHandlerHelper
 * JD-Core Version:    0.7.0.1
 */