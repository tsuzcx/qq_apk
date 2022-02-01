import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AccountVInfo;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
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
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RichTips;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class qlf
{
  private static void a(ArticleInfo paramArticleInfo)
  {
    PBRepeatMessageField localPBRepeatMessageField = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(localPBRepeatMessageField.computeSize(1));
    CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
    localPBRepeatMessageField.addAll(paramArticleInfo.srtUniversalID);
    try
    {
      localPBRepeatMessageField.writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      paramArticleInfo.srtUniversalIDBytesList = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (IOException paramArticleInfo)
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 1, "convertPBToBytes failed $e");
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null)
    {
      paramArticleInfo.mFeedType = 0;
      return;
    }
    paramArticleInfo.mFeedType = qlg.a(paramFeedsInfo.feeds_type);
    if ((paramFeedsInfo.uint32_business_id.has()) && ((paramArticleInfo.mPolymericInfo == null) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9))) {
      paramArticleInfo.businessId = qlg.a(paramFeedsInfo.uint32_business_id);
    }
    paramArticleInfo.mFeedCookie = qlg.a(paramFeedsInfo.bytes_feeds_cookie, "");
    paramArticleInfo.businessName = qlg.a(paramFeedsInfo.bytes_business_name, "");
    paramArticleInfo.businessUrl = qlg.a(paramFeedsInfo.bytes_business_url, "");
    paramArticleInfo.businessNamePrefix = qlg.a(paramFeedsInfo.bytes_business_name_prefix, "");
    b(paramArticleInfo, paramFeedsInfo);
    c(paramArticleInfo, paramFeedsInfo);
    d(paramArticleInfo, paramFeedsInfo);
  }
  
  private void b(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.SocializeFeedsInfo)qlg.a(paramFeedsInfo.msg_social_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a(paramFeedsInfo);
      paramArticleInfo.mSocialFeedInfoByte = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseSocializeFeedsInfo summary.msg_social_feeds_info is null");
  }
  
  private void c(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.TopicRecommendFeedsInfo)qlg.a(paramFeedsInfo.msg_topic_recommend_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramArticleInfo.mTopicRecommendFeedsInfo = rga.a(paramFeedsInfo);
      paramArticleInfo.mTopicRecommendFeedsInfoByte = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_Long;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseTopicRecommendFeedsInfo summary.msg_topic_recommend_feeds_info is null");
  }
  
  private void d(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    paramFeedsInfo = (articlesummary.ArkAppFeedsInfo)qlg.a(paramFeedsInfo.msg_ark_app_feeds_info);
    if (paramFeedsInfo != null)
    {
      paramArticleInfo.mArkAppFeedsInfo = rch.a(paramFeedsInfo);
      paramArticleInfo.mArkAppFeedsInfoBytes = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mArkAppFeedsInfo.jdField_a_of_type_Long;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseArkAppFeedsInfo summary.msg_ark_app_feeds_info is null");
  }
  
  private void l(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.FeedsInfo)qlg.a(paramArticleSummary.msg_feeds_info);
    if (paramArticleSummary != null) {
      a(paramArticleInfo, paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseFeedsInfo summary.msg_feeds_info is null");
  }
  
  private void m(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.RecommendFollowInfos)qlg.a(paramArticleSummary.recommend_info);
    if (paramArticleSummary != null) {
      paramArticleInfo.mRecommendFollowInfos = rdw.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseRecommendFollowInfo summary.recommend_info is null");
  }
  
  private void n(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.HotWordInfo)qlg.a(paramArticleSummary.hot_word_info);
    if (paramArticleSummary != null) {
      paramArticleInfo.hotWordInfo = rdb.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseHotWordInfo summary.hot_word_info is null");
  }
  
  private void o(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.PartnerAccountInfo)qlg.a(paramArticleSummary.msg_partner_account_info);
    if (paramArticleSummary != null) {
      if (qlg.a(paramArticleSummary.uint32_is_account_display) != 0)
      {
        bool = true;
        paramArticleInfo.isAccountShown = bool;
        paramArticleInfo.mPartnerAccountInfo = paramArticleSummary;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseProteusItemsData summary.msg_partner_account_info is null");
  }
  
  private void p(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.msg_srt_universal_id.has()) {
      paramArticleInfo.srtUniversalID = paramArticleSummary.msg_srt_universal_id.get();
    }
    if ((paramArticleInfo.srtUniversalID != null) && (!paramArticleInfo.srtUniversalID.isEmpty())) {
      a(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseUniversalID summary.msg_srt_universal_id is null");
  }
  
  private void q(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.AccountVInfo)qlg.a(paramArticleSummary.msg_account_v_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.vIconUrl = qlg.a(paramArticleSummary.bytes_v_icon_url);
      if (qlg.a(paramArticleSummary.uint32_is_unowned) == 1)
      {
        bool = true;
        paramArticleInfo.unowned = bool;
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseUniversalID summary.msg_account_v_info is null");
  }
  
  private void r(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.VideoColumnInfo)qlg.a(paramArticleSummary.video_multi_column_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.multiVideoColumnInfoBytes = paramArticleSummary.toByteArray();
      paramArticleInfo.multiVideoColumnInfo = rdl.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseMultiVideoColumnInfo summary.video_multi_column_info is null");
  }
  
  private void s(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.KdLiveInfo)qlg.a(paramArticleSummary.msg_kd_live_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mKdLiveInfoBytes = paramArticleSummary.toByteArray();
      paramArticleInfo.mKdLiveInfo = rde.a(paramArticleSummary);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseKdLiveInfo summary.msg_kd_live_info is null");
  }
  
  private void t(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.WeishiUGInfo)qlg.a(paramArticleSummary.msg_ug_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.weishiUGInfo = paramArticleSummary;
      paramArticleInfo.mWeishiUGInfo = paramArticleSummary.toByteArray();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseWeiShiUGInfo summary.msg_ug_info is null");
  }
  
  private void u(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.NewPackInfo)qlg.a(paramArticleSummary.msg_new_pack_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mNewPolymericInfo = rdm.a(paramArticleSummary);
      if ((paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        paramArticleInfo.businessId = ((rgc)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseNewPackInfo summary.msg_new_pack_info is null");
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    paramArticleInfo.mArticleID = qlg.a(paramArticleSummary.uint64_article_id);
    paramArticleInfo.mTitle = qlg.a(paramArticleSummary.bytes_article_title, "");
    paramArticleInfo.mSummary = qlg.a(paramArticleSummary.bytes_article_summary, "");
    paramArticleInfo.mFirstPagePicUrl = qlg.a(paramArticleSummary.bytes_first_page_pic_url, "");
    paramArticleInfo.mOriginalUrl = qlg.a(paramArticleSummary.bytes_original_url, "");
    paramArticleInfo.mArticleContentUrl = qlg.a(paramArticleSummary.bytes_article_content_url, "");
    paramArticleInfo.mTime = qlg.a(paramArticleSummary.uint64_time);
    paramArticleInfo.mCommentCount = qlg.a(paramArticleSummary.uint32_comment_count);
    paramArticleInfo.mSubscribeID = qlg.a(paramArticleSummary.bytes_subscribe_id, "");
    paramArticleInfo.mSubscribeName = qlg.a(paramArticleSummary.bytes_subscribe_name, "");
    paramArticleInfo.mRecommendTime = qlg.a(paramArticleSummary.uint64_recommend_time);
    paramArticleInfo.mRecommendSeq = qlg.a(paramArticleSummary.uint64_recommend_seq);
    if (qlg.a(paramArticleSummary.uint32_show_big_picture) == 1)
    {
      bool1 = true;
      paramArticleInfo.mShowBigPicture = bool1;
      paramArticleInfo.mAlgorithmID = qlg.a(paramArticleSummary.uint64_algorithm_id);
      paramArticleInfo.mJsonVideoList = qlg.a(paramArticleSummary.json_video_list);
      paramArticleInfo.mJsonPictureList = qlg.a(paramArticleSummary.json_picture_list);
      paramArticleInfo.mAbandonRepeatFlag = qlg.a(paramArticleSummary.uint32_abandon_repeat_flag);
      paramArticleInfo.mArticleSubscriptText = qlg.a(paramArticleSummary.bytes_test);
      paramArticleInfo.mArticleSubscriptColor = qlg.a(paramArticleSummary.bytes_colour);
      paramArticleInfo.mStrategyId = qlg.a(paramArticleSummary.uint32_strategy_id);
      paramArticleInfo.mMergeVideoId = qlg.a(paramArticleSummary.uint64_merged_video_id);
      paramArticleInfo.aioShareUrl = qlg.a(paramArticleSummary.bytes_aio_share_url);
      paramArticleInfo.qzoneShareUrl = qlg.a(paramArticleSummary.bytes_qzone_share_url);
      a(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mArticleFriendLikeText = qlg.a(paramArticleSummary.bytes_friend_like_wording);
      paramArticleInfo.mVideoType = qlg.a(paramArticleSummary.uint32_video_show_small_picture);
      paramArticleInfo.mCommentIconType = qlg.a(paramArticleSummary.uint32_comment_icon_type);
      paramArticleInfo.mServerContext = qlg.a(paramArticleSummary.bytes_server_context);
      b(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mIsDispTimestamp = qlg.a(paramArticleSummary.uint32_is_disp_timestamp);
      c(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mIsGallery = qlg.a(paramArticleSummary.uint32_is_gallery);
      if (paramArticleInfo.mIsGallery != 0) {
        paramArticleInfo.mGalleryPicNumber = qlg.a(paramArticleSummary.uint32_picture_number);
      }
      paramArticleInfo.innerUniqueID = qlg.a(paramArticleSummary.bytes_inner_uniq_id);
      e(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mCommentsObj = qlg.a(paramArticleSummary.rpt_comments);
      f(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mStrCircleId = qlg.a(paramArticleSummary.bytes_circle_id, "");
      if (qlg.a(paramArticleSummary.uint32_is_active) != 1) {
        break label1166;
      }
      bool1 = true;
      label482:
      paramArticleInfo.mPUinIsActive = bool1;
      paramArticleInfo.mSubscribeInfoObj = ((articlesummary.SubscribeInfo)qlg.a(paramArticleSummary.msg_subscribe_info));
      l(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mVideoPlayCount = qlg.a(paramArticleSummary.uint32_video_play_count);
      if (paramArticleSummary.rpt_label_list.has()) {
        paramArticleInfo.mLabelListObj = paramArticleSummary.rpt_label_list.get();
      }
      paramArticleInfo.mAccountLess = qlg.a(paramArticleSummary.is_accountless);
      paramArticleInfo.interfaceData = qlg.a(paramArticleSummary.bytes_interface_data);
      paramArticleInfo.galleryReprotExdData = qlg.a(paramArticleSummary.bytes_gallery_report_extdata);
      paramArticleInfo.articleStyle = qlg.a(paramArticleSummary.enum_article_style);
      b(paramArticleSummary, paramInt1, paramInt2, paramArticleInfo);
      d(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mVideoCommentCount = qlg.a(paramArticleSummary.uint32_video_comment_count);
      paramArticleInfo.mVideoArticleSubsText = qlg.a(paramArticleSummary.bytes_video_subscript_txt);
      paramArticleInfo.mVideoArticleSubsColor = qlg.a(paramArticleSummary.bytes_video_subscript_color);
      paramArticleInfo.mVideoAdsJumpUrl = qlg.a(paramArticleSummary.bytes_ads_jump_url);
      paramArticleInfo.mVideoAdsJumpType = qlg.a(paramArticleSummary.uint32_ads_jump_type);
      paramArticleInfo.mVideoAdsSource = qlg.a(paramArticleSummary.uint32_ads_source);
      paramArticleInfo.videoReportInfo = qlg.a(paramArticleSummary.bytes_video_report_info);
      g(paramArticleSummary, paramArticleInfo);
      u(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mVideoDownloadBarInfo = ((articlesummary.VideoDownloadBarInfo)qlg.a(paramArticleSummary.video_download_bar_info));
      m(paramArticleSummary, paramArticleInfo);
      n(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.gifCoverUrl = qlg.a(paramArticleSummary.bytes_first_page_gif_url);
      if (qlg.a(paramArticleSummary.uint32_is_first_page_use_gif) != 1) {
        break label1172;
      }
      bool1 = true;
      label762:
      paramArticleInfo.isUseGif = bool1;
      h(paramArticleSummary, paramArticleInfo);
      i(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.mGWCommonData = qlg.a(paramArticleSummary.bytes_gw_common_data);
      paramArticleInfo.mReportCommonData = qlg.a(paramArticleSummary.bytes_report_common_data);
      paramArticleInfo.mArticleType = qlg.a(paramArticleSummary.uint32_article_type);
      paramArticleInfo.isCloseDislike = qlg.a(paramArticleSummary.uint32_is_close_dislike);
      paramArticleInfo.isSuperTop = qlg.a(paramArticleSummary.uint32_is_super_top_article);
      paramArticleInfo.mVideoLogoUrl = qlg.a(paramArticleSummary.bytes_video_logo_url);
      o(paramArticleSummary, paramArticleInfo);
      j(paramArticleSummary, paramArticleInfo);
      articlesummary.VideoColumnInfo localVideoColumnInfo1 = (articlesummary.VideoColumnInfo)qlg.a(paramArticleSummary.video_column_info);
      articlesummary.VideoColumnInfo localVideoColumnInfo2 = (articlesummary.VideoColumnInfo)qlg.a(paramArticleSummary.video_simple_column_info);
      paramArticleInfo.mVideoColumnInfo = VideoColumnInfo.a(localVideoColumnInfo1);
      paramArticleInfo.mSimpleVideoColumnInfo = VideoColumnInfo.a(localVideoColumnInfo2);
      paramArticleInfo.commentJumpUrl = qlg.a(paramArticleSummary.bytes_comment_button_jump_url);
      paramArticleInfo.mIsShowSearchord = qlg.a(paramArticleSummary.uint32_is_show_search_word);
      paramArticleInfo.adReportCommonData = qlg.a(paramArticleSummary.bytes_ad_report_common_data);
      p(paramArticleSummary, paramArticleInfo);
      q(paramArticleSummary, paramArticleInfo);
      r(paramArticleSummary, paramArticleInfo);
      paramArticleInfo.columnStyle = qlg.a(paramArticleSummary.uint32_column_style);
      paramArticleInfo.isShowFollowButton = qlg.a(paramArticleSummary.uint32_is_show_follow_button);
      a(paramArticleSummary, paramInt2, paramArticleInfo);
      s(paramArticleSummary, paramArticleInfo);
      t(paramArticleSummary, paramArticleInfo);
      if (qlg.a(paramArticleSummary.uint32_expose_repeat_flag) != 1) {
        break label1178;
      }
      bool1 = true;
      label1030:
      paramArticleInfo.isNeeaRealExposureFilter = bool1;
      rbs.a(paramArticleInfo);
      if (qlg.a(paramArticleSummary.uint32_red_package_flag) != 1) {
        break label1184;
      }
      bool1 = true;
      label1056:
      paramArticleInfo.hasWalletIcon = bool1;
      paramArticleInfo.smallGameData = qlg.a(paramArticleSummary.bytes_small_game_rsp_pack);
      paramArticleInfo.mSmallMiniGameInfo = trt.a(paramArticleInfo.smallGameData);
      paramArticleInfo.columnEntrances = VideoColumnInfo.a(paramArticleSummary.card_column_entrances);
      if (paramArticleInfo.isWormhole()) {
        tpj.a(paramArticleInfo);
      }
      if (qlg.a(paramArticleSummary.uint32_forbid_reprint_flag) != 1) {
        break label1190;
      }
    }
    label1166:
    label1172:
    label1178:
    label1184:
    label1190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArticleInfo.isForbidReprint = bool1;
      paramArticleInfo.wechatShareUrl = qlg.a(paramArticleSummary.bytes_wechat_share_url);
      paramArticleInfo.dtReportContentType = qlg.a(paramArticleSummary.uint32_backend_content_type);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label482;
      bool1 = false;
      break label762;
      bool1 = false;
      break label1030;
      bool1 = false;
      break label1056;
    }
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, int paramInt, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.ScripCmsInfo)qlg.a(paramArticleSummary.msg_scrip_cms_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.scripCmsInfo = rea.a(paramArticleSummary);
      paramArticleInfo.scripCmsInfoByte = paramArticleSummary.toByteArray();
      if (paramInt != 7) {
        break label46;
      }
      paramArticleInfo.scripCmsInfo.jdField_b_of_type_Int = 1;
    }
    label46:
    while (paramInt != 6) {
      return;
    }
    paramArticleInfo.scripCmsInfo.jdField_b_of_type_Int = 2;
  }
  
  public void a(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    try
    {
      paramArticleInfo.mTopicPicInfo = qlg.a(paramArticleSummary.bytes_media_specs);
      if (paramArticleInfo.mTopicPicInfo == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyMSFHandlerUtils", 2, "test to print media specs true, media_specs:" + paramArticleInfo.mTopicPicInfo);
      }
      paramArticleSummary = new JSONObject(paramArticleInfo.mTopicPicInfo);
      int i = paramArticleSummary.optInt("topic_width");
      int j = paramArticleSummary.optInt("topic_height");
      if (j != 0) {
        paramArticleInfo.mTopicPicWHRatio = (i / 1.0D / j);
      }
      paramArticleInfo.videoJumpChannelID = paramArticleSummary.optInt("jump_channel_id");
      paramArticleInfo.videoJumpChannelType = paramArticleSummary.optInt("jump_channel_type");
      paramArticleInfo.videoJumpChannelName = paramArticleSummary.optString("jump_channel_name");
      return;
    }
    catch (Exception paramArticleSummary)
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve bytes_media_specs failed ", paramArticleSummary);
      paramArticleInfo.mTopicPicInfo = "";
      paramArticleInfo.mTopicPicWHRatio = 0.0D;
      paramArticleInfo.videoJumpChannelID = -1;
      paramArticleInfo.videoJumpChannelType = -1;
      paramArticleInfo.videoJumpChannelName = "";
    }
  }
  
  public void a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    paramChannelCoverInfo.mChannelCoverId = qlg.a(paramChannelInfo.uint32_channel_id);
    paramChannelCoverInfo.mChannelCoverName = qlg.a(paramChannelInfo.bytes_channel_name, "");
    paramChannelCoverInfo.mChannelCoverStyle = qlg.a(paramChannelInfo.enum_channel_cover_style);
    paramChannelCoverInfo.mFollowType = qlg.a(paramChannelInfo.uint32_is_followed);
    paramChannelCoverInfo.mColumnType = qlg.a(paramChannelInfo.enum_column_type);
    paramChannelCoverInfo.mFontColor = qlg.a(paramChannelInfo.uint32_fonts_color);
    paramChannelCoverInfo.mFrameColor = qlg.a(paramChannelInfo.uint32_frame_color);
    paramChannelCoverInfo.mChannelId = paramInt;
    paramChannelCoverInfo.mArticleId = qlg.a(paramChannelInfo.uint64_channel_cover_article_id);
    paramChannelCoverInfo.mChannelType = qlg.a(paramChannelInfo.uint32_channel_type);
    if (qlg.a(paramChannelInfo.uint32_is_topic) > 0)
    {
      bool = true;
      paramChannelCoverInfo.mIsTopic = bool;
      if (qlg.a(paramChannelInfo.uint32_is_external_expose) != 1) {
        break label382;
      }
      bool = true;
      label139:
      paramChannelCoverInfo.isExternalExposure = bool;
      paramChannelCoverInfo.externalExposureBackgroundUrl = qlg.a(paramChannelInfo.bytes_is_external_bg_url, "");
      if (qlg.a(paramChannelInfo.uint32_has_recommend) != 1) {
        break label388;
      }
    }
    label388:
    for (boolean bool = true;; bool = false)
    {
      paramChannelCoverInfo.isExternalExposurePersist = bool;
      try
      {
        paramChannelCoverInfo.mChannelCoverSummary = new String(qlg.a(paramChannelInfo.bytes_channel_cover_wording));
        paramChannelCoverInfo.mChannelCoverSpec = new String(qlg.a(paramChannelInfo.bytes_channel_cover_spec));
        Object localObject = new JSONObject(paramChannelCoverInfo.mChannelCoverSpec).getString("filterColor");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramChannelCoverInfo.hasFilterColor = true;
          paramChannelCoverInfo.filterColor = Color.parseColor((String)localObject);
        }
        paramChannelCoverInfo.mChannelJumpUrl = new String(qlg.a(paramChannelInfo.bytes_channel_jump_url));
        paramChannelCoverInfo.mColumnType = 1;
        paramChannelCoverInfo.mChannelCoverPicUrl = new String(qlg.a(paramChannelInfo.bytes_channel_cover_picurl));
        localObject = (oidb_cmd0x69f.RichTips)qlg.a(paramChannelInfo.msg_rich_tips);
        if (localObject != null)
        {
          paramChannelCoverInfo.mTipsType = qlg.a(((oidb_cmd0x69f.RichTips)localObject).uint32_tips_type);
          paramChannelCoverInfo.mUpdateTime = qlg.a(((oidb_cmd0x69f.RichTips)localObject).uint32_latest_sticky_time);
          paramChannelCoverInfo.mTipsText = new String(qlg.a(((oidb_cmd0x69f.RichTips)localObject).bytes_tips_text));
        }
        paramChannelCoverInfo.mIconUrl = new String(qlg.a(paramChannelInfo.bytes_icon_url));
        return;
      }
      catch (Exception paramChannelInfo)
      {
        QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve channel cover info failed $e");
        paramChannelCoverInfo.mColumnType = 0;
      }
      bool = false;
      break;
      label382:
      bool = false;
      break label139;
    }
  }
  
  public void b(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.msg_sub_article_summary.has())
    {
      paramArticleInfo.mSubSummaryListObj = paramArticleSummary.msg_sub_article_summary.get();
      if (paramArticleInfo.mSubSummaryListObj.size() > 0)
      {
        paramArticleSummary = new ArrayList(paramArticleInfo.mSubSummaryListObj.size());
        Iterator localIterator = paramArticleInfo.mSubSummaryListObj.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          Object localObject = qlh.a((articlesummary.ArticleSummary)localIterator.next(), paramInt1, paramInt2, null);
          if (localObject == null) {
            break label282;
          }
          paramArticleSummary.add(localObject);
          if (!QLog.isColorLevel()) {
            break label282;
          }
          localObject = new StringBuilder().append("convertArticleInfo(): 解析 sub articleSummary【");
          int j = i + 1;
          QLog.e("ReadInJoyMSFHandlerUtils", 2, i + "】 id : " + paramArticleInfo.mArticleID + " seq : " + paramArticleInfo.mRecommendSeq + " title : " + pay.d(paramArticleInfo.mTitle) + " , groupID : " + paramArticleInfo.mGroupId + " algorithmID : " + paramArticleInfo.mAlgorithmID + " strategyId : " + paramArticleInfo.mStrategyId + " businessID : " + paramArticleInfo.businessId + " businessName :" + paramArticleInfo.businessName);
          i = j;
        }
      }
    }
    label282:
    for (;;)
    {
      break;
      paramArticleInfo.mSubArtilceList = paramArticleSummary;
      return;
    }
  }
  
  public void b(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.ChannelInfo)qlg.a(paramArticleSummary.msg_channel_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mChannelInfoId = qlg.a(paramArticleSummary.uint32_channel_id);
      paramArticleInfo.mChannelInfoName = qlg.a(paramArticleSummary.bytes_channel_name);
      paramArticleInfo.mChannelInfoType = qlg.a(paramArticleSummary.uint32_channel_type);
      paramArticleInfo.mChannelInfoDisplayName = qlg.a(paramArticleSummary.bytes_channel_display_name);
    }
  }
  
  public void c(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.bytesBusiData = qlg.a(paramArticleSummary.bytes_gallery_busi_data);
    if ((paramArticleInfo.bytesBusiData != null) && (paramArticleInfo.bytesBusiData.length > 0)) {
      paramArticleInfo.mGalleryFeedsInfo = new galleryFeeds.GalleryFeedsInfo();
    }
    try
    {
      paramArticleInfo.mGalleryFeedsInfo.mergeFrom(paramArticleInfo.bytesBusiData);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArticleSummary)
    {
      QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.getMessage());
    }
  }
  
  public void d(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.mRecommentdReason = qlg.a(paramArticleSummary.bytes_recommend_reason);
    if ((TextUtils.isEmpty(paramArticleInfo.mRecommentdReason)) && (!TextUtils.isEmpty(paramArticleInfo.proteusItemsData))) {}
    try
    {
      paramArticleInfo.mRecommentdReason = new JSONObject(paramArticleInfo.proteusItemsData).optString("recommend_reason");
      return;
    }
    catch (JSONException paramArticleSummary)
    {
      QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleSummary.getMessage());
    }
  }
  
  public void e(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if (paramArticleSummary.rpt_dislike_list.has())
    {
      paramArticleSummary = paramArticleSummary.rpt_dislike_list.get();
      if ((paramArticleSummary != null) && (paramArticleSummary.size() > 0))
      {
        int j = paramArticleSummary.size();
        paramArticleInfo.mDislikeInfos = new ArrayList();
        int i = 0;
        while (i < j)
        {
          DislikeInfo localDislikeInfo = new DislikeInfo();
          localDislikeInfo.a((articlesummary.DisLikeInfo)paramArticleSummary.get(i));
          paramArticleInfo.mDislikeInfos.add(localDislikeInfo);
          i += 1;
        }
        paramArticleInfo.mDiskLikeInfoString = DislikeInfo.a(paramArticleInfo.mDislikeInfos);
      }
    }
  }
  
  public void f(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.PackInfo)qlg.a(paramArticleSummary.msg_pack_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mPackInfoObj = paramArticleSummary;
      paramArticleInfo.mGroupId = qlg.a(paramArticleSummary.uint64_pack_id);
      paramArticleInfo.mPolymericInfo = rdr.a(paramArticleInfo.mPackInfoObj);
    }
    if ((paramArticleInfo.mPolymericInfo != null) && (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9)) {
      paramArticleInfo.businessId = paramArticleInfo.mPolymericInfo.f;
    }
  }
  
  public void g(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    articlesummary.DiandianWording localDiandianWording = (articlesummary.DiandianWording)qlg.a(paramArticleSummary.diandian_wording);
    if (localDiandianWording != null)
    {
      paramArticleInfo.msgBoxBriefContent = qlg.a(localDiandianWording.bytes_msg_wording);
      paramArticleInfo.msgBoxBriefPreFix = qlg.a(localDiandianWording.bytes_uin_or_nick);
      paramArticleInfo.msgBoxBriefPreFixType = qlg.a(localDiandianWording.uint32_uin_type);
    }
    paramArticleSummary = (articlesummary.DiandianLabel)qlg.a(paramArticleSummary.diandian_label);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.mDianDianLabelIconUrl = qlg.a(paramArticleSummary.bytes_icon_url);
      paramArticleInfo.mDianDianLabelText = qlg.a(paramArticleSummary.bytes_icon_wording);
    }
  }
  
  public void h(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_aggregated_list.has()))
    {
      paramArticleSummary = (articlesummary.AggregatedList)paramArticleSummary.msg_feeds_info.msg_aggregated_list.get();
      paramArticleInfo.mExtraBiuBriefInfo = rcv.a(paramArticleSummary);
      if ((paramArticleSummary.uint32_aggregated_content_type.has()) && (paramArticleSummary.uint32_aggregated_content_type.get() == 2) && (paramArticleSummary.rpt_multi_biu_same_content.has()))
      {
        paramArticleInfo.multiBiuSameContentList = MultiBiuSameContent.a(paramArticleSummary.rpt_multi_biu_same_content.get());
        paramArticleInfo.mMultiBiuSameListObj = paramArticleSummary.rpt_multi_biu_same_content.get();
      }
    }
  }
  
  public void i(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleSummary = (articlesummary.FamilyCommentInfo)qlg.a(paramArticleSummary.msg_family_comment_info);
    if (paramArticleSummary != null)
    {
      paramArticleInfo.familyCommentInfoByte = paramArticleSummary.toByteArray();
      rcx localrcx = new rcx();
      localrcx.jdField_a_of_type_JavaLangString = qlg.a(paramArticleSummary.icon_url);
      localrcx.jdField_b_of_type_JavaLangString = qlg.a(paramArticleSummary.jump_url);
      localrcx.jdField_a_of_type_Int = qlg.a(paramArticleSummary.medal_urls_width);
      localrcx.jdField_b_of_type_Int = qlg.a(paramArticleSummary.medal_urls_height);
      paramArticleInfo.familyCommentInfo = localrcx;
    }
  }
  
  public void j(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.has()))
    {
      Object localObject = (articlesummary.SocializeFeedsInfo)qlg.a(paramArticleSummary.msg_feeds_info.msg_social_feeds_info);
      if (localObject != null)
      {
        localObject = (articlesummary.CardJumpInfo)qlg.a(((articlesummary.SocializeFeedsInfo)localObject).msg_card_jump_info);
        if (localObject != null)
        {
          paramArticleInfo.mCardJumpUrl = qlg.a(((articlesummary.CardJumpInfo)localObject).bytes_card_jump_url);
          paramArticleInfo.isCardJumpUrlAvailable = qlg.a(((articlesummary.CardJumpInfo)localObject).uint32_available);
          paramArticleInfo.commentBtnJumpUrl = qlg.a(((articlesummary.CardJumpInfo)localObject).bytes_comment_btn_url);
          paramArticleInfo.commentShareUrl = qlg.a(((articlesummary.CardJumpInfo)localObject).bytes_share_url);
        }
        paramArticleSummary = (articlesummary.FusionInfo)qlg.a(paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_fusion_info);
        if (paramArticleSummary != null)
        {
          paramArticleInfo.commentId = qlg.a(paramArticleSummary.str_comment_id);
          paramArticleInfo.commentSrc = qlg.a(paramArticleSummary.uint32_comment_src);
        }
      }
    }
  }
  
  public void k(articlesummary.ArticleSummary paramArticleSummary, ArticleInfo paramArticleInfo)
  {
    paramArticleInfo.proteusItemsData = qlg.a(paramArticleSummary.bytes_interface_data);
    if (paramArticleInfo.proteusItemsData != null) {
      pay.a(paramArticleInfo);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyMSFHandlerUtils", 2, "parseProteusItemsData summary.bytes_interface_data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlf
 * JD-Core Version:    0.7.0.1
 */