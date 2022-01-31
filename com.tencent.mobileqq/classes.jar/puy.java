import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.CodedOutputStreamMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AccountVInfo;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArkAppFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.AwesomeCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.CardJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.ChannelInfo;
import tencent.im.oidb.articlesummary.articlesummary.DiandianLabel;
import tencent.im.oidb.articlesummary.articlesummary.DiandianWording;
import tencent.im.oidb.articlesummary.articlesummary.DisLikeInfo;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.HotWordInfo;
import tencent.im.oidb.articlesummary.articlesummary.KdLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.NewPackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.PosAdInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID;
import tencent.im.oidb.articlesummary.articlesummary.ScripCmsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SubscribeInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoColumnInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.RedPoint;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeResult;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.InterestLabelInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.TagInfo;
import tencent.im.oidb.cmd0xbde.oidb_cmd0xbde.TopicInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class puy
{
  private static Boolean[] jdField_a_of_type_ArrayOfJavaLangBoolean = { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) };
  private static Integer[] jdField_a_of_type_ArrayOfJavaLangInteger;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { alpo.a(2131713193), alpo.a(2131713507), alpo.a(2131713179), alpo.a(2131713226), alpo.a(2131713186), alpo.a(2131713514), alpo.a(2131713368), alpo.a(2131713443), alpo.a(2131713313), alpo.a(2131713136) };
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[] { Integer.valueOf(4779), Integer.valueOf(1166), Integer.valueOf(5293), Integer.valueOf(501), Integer.valueOf(73), Integer.valueOf(5729), Integer.valueOf(1314), Integer.valueOf(3817), Integer.valueOf(3689), Integer.valueOf(3076) };
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if ((paramInt1 % 5 == 0) || (paramInt1 % 5 == 1)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return 0;
  }
  
  public static ArticleInfo a(articlesummary.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    if (paramArticleSummary == null)
    {
      paramArticleSummary = null;
      return paramArticleSummary;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo: channelID:" + paramInt1);
    }
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (paramArticleInfo == null) {
      localArticleInfo = new ArticleInfo();
    }
    localArticleInfo.mChannelID = paramInt1;
    if (paramArticleSummary.uint64_article_id.has()) {
      localArticleInfo.mArticleID = paramArticleSummary.uint64_article_id.get();
    }
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localArticleInfo.mTitle = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
      localArticleInfo.mSummary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_first_page_pic_url.has()) && (paramArticleSummary.bytes_first_page_pic_url.get() != null)) {
      localArticleInfo.mFirstPagePicUrl = paramArticleSummary.bytes_first_page_pic_url.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_original_url.has()) && (paramArticleSummary.bytes_original_url.get() != null)) {
      localArticleInfo.mOriginalUrl = paramArticleSummary.bytes_original_url.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_article_content_url.has()) && (paramArticleSummary.bytes_article_content_url.get() != null)) {
      localArticleInfo.mArticleContentUrl = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
    }
    if (paramArticleSummary.uint64_time.has()) {
      localArticleInfo.mTime = paramArticleSummary.uint64_time.get();
    }
    if (paramArticleSummary.uint32_comment_count.has()) {
      localArticleInfo.mCommentCount = paramArticleSummary.uint32_comment_count.get();
    }
    if ((paramArticleSummary.bytes_subscribe_id.has()) && (paramArticleSummary.bytes_subscribe_id.get() != null)) {
      localArticleInfo.mSubscribeID = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
    }
    if ((paramArticleSummary.bytes_subscribe_name.has()) && (paramArticleSummary.bytes_subscribe_name.get() != null)) {
      localArticleInfo.mSubscribeName = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
    }
    if (paramArticleSummary.uint64_recommend_time.has()) {
      localArticleInfo.mRecommendTime = paramArticleSummary.uint64_recommend_time.get();
    }
    if (paramArticleSummary.uint64_recommend_seq.has()) {
      localArticleInfo.mRecommendSeq = paramArticleSummary.uint64_recommend_seq.get();
    }
    boolean bool1;
    if (paramArticleSummary.uint32_show_big_picture.has())
    {
      if (paramArticleSummary.uint32_show_big_picture.get() != 1) {
        break label1349;
      }
      bool1 = true;
    }
    int i;
    int j;
    Object localObject1;
    for (;;)
    {
      localArticleInfo.mShowBigPicture = bool1;
      if (paramArticleSummary.uint64_algorithm_id.has()) {
        localArticleInfo.mAlgorithmID = paramArticleSummary.uint64_algorithm_id.get();
      }
      if ((paramArticleSummary.json_video_list.has()) && (paramArticleSummary.json_video_list.get() != null)) {
        localArticleInfo.mJsonVideoList = paramArticleSummary.json_video_list.get().toStringUtf8();
      }
      if ((paramArticleSummary.json_picture_list.has()) && (paramArticleSummary.json_picture_list.get() != null)) {
        localArticleInfo.mJsonPictureList = paramArticleSummary.json_picture_list.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_abandon_repeat_flag.has()) {
        localArticleInfo.mAbandonRepeatFlag = paramArticleSummary.uint32_abandon_repeat_flag.get();
      }
      if ((paramArticleSummary.bytes_test.has()) && (paramArticleSummary.bytes_test.get() != null)) {
        localArticleInfo.mArticleSubscriptText = paramArticleSummary.bytes_test.get().toStringUtf8();
      }
      if ((paramArticleSummary.bytes_colour.has()) && (paramArticleSummary.bytes_colour.get() != null)) {
        localArticleInfo.mArticleSubscriptColor = paramArticleSummary.bytes_colour.get().toStringUtf8();
      }
      if (paramArticleSummary.uint32_strategy_id.has()) {
        localArticleInfo.mStrategyId = paramArticleSummary.uint32_strategy_id.get();
      }
      if (paramArticleSummary.uint64_merged_video_id.has()) {
        localArticleInfo.mMergeVideoId = paramArticleSummary.uint64_merged_video_id.get();
      }
      if ((paramArticleSummary.bytes_media_specs.has()) && (paramArticleSummary.bytes_media_specs.get() != null)) {}
      try
      {
        localArticleInfo.mTopicPicInfo = paramArticleSummary.bytes_media_specs.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyMSFHandlerUtils", 2, "test to print media specs true, media_specs:" + localArticleInfo.mTopicPicInfo);
        }
        paramArticleInfo = new JSONObject(localArticleInfo.mTopicPicInfo);
        i = paramArticleInfo.optInt("topic_width");
        j = paramArticleInfo.optInt("topic_height");
        if (j != 0) {
          localArticleInfo.mTopicPicWHRatio = (i / 1.0D / j);
        }
        localArticleInfo.videoJumpChannelID = paramArticleInfo.optInt("jump_channel_id");
        localArticleInfo.videoJumpChannelType = paramArticleInfo.optInt("jump_channel_type");
        localArticleInfo.videoJumpChannelName = paramArticleInfo.optString("jump_channel_name");
        if ((paramArticleSummary.bytes_friend_like_wording.has()) && (paramArticleSummary.bytes_friend_like_wording.get() != null)) {
          localArticleInfo.mArticleFriendLikeText = paramArticleSummary.bytes_friend_like_wording.get().toStringUtf8();
        }
        if (paramArticleSummary.uint32_video_show_small_picture.has()) {
          localArticleInfo.mVideoType = paramArticleSummary.uint32_video_show_small_picture.get();
        }
        if (paramArticleSummary.uint32_comment_icon_type.has()) {
          localArticleInfo.mCommentIconType = paramArticleSummary.uint32_comment_icon_type.get();
        }
        if ((paramArticleSummary.bytes_server_context.has()) && (paramArticleSummary.bytes_server_context.get() != null)) {
          localArticleInfo.mServerContext = paramArticleSummary.bytes_server_context.get().toByteArray();
        }
        if (paramArticleSummary.msg_channel_info.has())
        {
          paramArticleInfo = (articlesummary.ChannelInfo)paramArticleSummary.msg_channel_info.get();
          if (paramArticleInfo.uint32_channel_id.has()) {
            localArticleInfo.mChannelInfoId = paramArticleInfo.uint32_channel_id.get();
          }
          if (paramArticleInfo.bytes_channel_name.has()) {
            localArticleInfo.mChannelInfoName = paramArticleInfo.bytes_channel_name.get().toStringUtf8();
          }
          if (paramArticleInfo.uint32_channel_type.has()) {
            localArticleInfo.mChannelInfoType = paramArticleInfo.uint32_channel_type.get();
          }
          if (paramArticleInfo.bytes_channel_display_name.has()) {
            localArticleInfo.mChannelInfoDisplayName = paramArticleInfo.bytes_channel_display_name.get().toStringUtf8();
          }
        }
        if (paramArticleSummary.uint32_is_disp_timestamp.has()) {
          localArticleInfo.mIsDispTimestamp = paramArticleSummary.uint32_is_disp_timestamp.get();
        }
        if (paramArticleSummary.bytes_gallery_busi_data.has())
        {
          localArticleInfo.bytesBusiData = paramArticleSummary.bytes_gallery_busi_data.get().toByteArray();
          if ((localArticleInfo.bytesBusiData != null) && (localArticleInfo.bytesBusiData.length > 0)) {
            localArticleInfo.mGalleryFeedsInfo = new galleryFeeds.GalleryFeedsInfo();
          }
        }
      }
      catch (Exception paramArticleInfo)
      {
        try
        {
          localArticleInfo.mGalleryFeedsInfo.mergeFrom(localArticleInfo.bytesBusiData);
          if (paramArticleSummary.uint32_is_gallery.has())
          {
            localArticleInfo.mIsGallery = paramArticleSummary.uint32_is_gallery.get();
            if ((localArticleInfo.mIsGallery != 0) && (paramArticleSummary.uint32_picture_number.has())) {
              localArticleInfo.mGalleryPicNumber = paramArticleSummary.uint32_picture_number.get();
            }
          }
          if ((paramArticleSummary.bytes_inner_uniq_id.has()) && (paramArticleSummary.bytes_inner_uniq_id.get() != null)) {
            localArticleInfo.innerUniqueID = paramArticleSummary.bytes_inner_uniq_id.get().toStringUtf8();
          }
          if (paramArticleSummary.rpt_dislike_list.has())
          {
            paramArticleInfo = paramArticleSummary.rpt_dislike_list.get();
            if ((paramArticleInfo != null) && (paramArticleInfo.size() > 0))
            {
              j = paramArticleInfo.size();
              localArticleInfo.mDislikeInfos = new ArrayList();
              i = 0;
              for (;;)
              {
                if (i < j)
                {
                  localObject1 = new DislikeInfo();
                  ((DislikeInfo)localObject1).a((articlesummary.DisLikeInfo)paramArticleInfo.get(i));
                  localArticleInfo.mDislikeInfos.add(localObject1);
                  i += 1;
                  continue;
                  label1349:
                  bool1 = false;
                  break;
                  paramArticleInfo = paramArticleInfo;
                  QLog.d("ReadInJoyMSFHandlerUtils", 1, "resolve bytes_media_specs failed ", paramArticleInfo);
                  localArticleInfo.mTopicPicInfo = "";
                  localArticleInfo.mTopicPicWHRatio = 0.0D;
                  localArticleInfo.videoJumpChannelID = -1;
                  localArticleInfo.videoJumpChannelType = -1;
                  localArticleInfo.videoJumpChannelName = "";
                }
              }
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramArticleInfo)
        {
          for (;;)
          {
            paramArticleInfo.printStackTrace();
          }
          localArticleInfo.mDiskLikeInfoString = DislikeInfo.a(localArticleInfo.mDislikeInfos);
          if (paramArticleSummary.rpt_comments.has()) {
            localArticleInfo.mCommentsObj = paramArticleSummary.rpt_comments.get();
          }
          if (paramArticleSummary.msg_pack_info.has())
          {
            localArticleInfo.mPackInfoObj = ((articlesummary.PackInfo)paramArticleSummary.msg_pack_info.get());
            localArticleInfo.mGroupId = localArticleInfo.mPackInfoObj.uint64_pack_id.get();
            localArticleInfo.mPolymericInfo = qlo.a(localArticleInfo.mPackInfoObj);
            if (localArticleInfo.mPolymericInfo.jdField_a_of_type_Int == 9) {
              localArticleInfo.businessId = localArticleInfo.mPolymericInfo.f;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PolymericSmallVideo_ReadInJoyMSFHandlerUtils", 2, "groupId:" + localArticleInfo.mGroupId + " articleID:" + localArticleInfo.mArticleID + " type:" + ((articlesummary.PackInfo)localArticleInfo.mPackInfoObj.get()).pack_type.get() + " recommendId:" + localArticleInfo.mRecommendSeq + " mPolymericInfo = " + localArticleInfo.mPolymericInfo);
            }
          }
          if (!paramArticleSummary.bytes_circle_id.has()) {
            break label2366;
          }
        }
      }
    }
    localArticleInfo.mStrCircleId = paramArticleSummary.bytes_circle_id.get().toStringUtf8();
    label1656:
    if (paramArticleSummary.uint32_is_active.has()) {
      if (paramArticleSummary.uint32_is_active.get() == 1)
      {
        bool1 = true;
        localArticleInfo.mPUinIsActive = bool1;
        if (paramArticleSummary.msg_subscribe_info.has()) {
          localArticleInfo.mSubscribeInfoObj = ((articlesummary.SubscribeInfo)paramArticleSummary.msg_subscribe_info.get());
        }
        if (paramArticleSummary.msg_feeds_info.has()) {
          a(localArticleInfo, (articlesummary.FeedsInfo)paramArticleSummary.msg_feeds_info.get());
        }
        if (paramArticleSummary.uint32_video_play_count.has())
        {
          localArticleInfo.mVideoPlayCount = paramArticleSummary.uint32_video_play_count.get();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.mVideoPlayCount =" + localArticleInfo.mVideoPlayCount);
          }
        }
        if (paramArticleSummary.rpt_label_list.has())
        {
          localArticleInfo.mLabelListObj = paramArticleSummary.rpt_label_list.get();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): summary.rpt_label_list.has() = true");
          }
        }
        if (paramArticleSummary.is_accountless.has())
        {
          localArticleInfo.mAccountLess = paramArticleSummary.is_accountless.get();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.mAccountLess =" + localArticleInfo.mAccountLess);
          }
        }
        if (paramArticleSummary.bytes_interface_data.has())
        {
          localArticleInfo.interfaceData = paramArticleSummary.bytes_interface_data.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.interfaceData = " + localArticleInfo.interfaceData);
          }
        }
        if (paramArticleSummary.bytes_gallery_report_extdata.has())
        {
          localArticleInfo.galleryReprotExdData = paramArticleSummary.bytes_gallery_report_extdata.get().toStringUtf8();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.galleryReprotExdData = " + localArticleInfo.galleryReprotExdData);
          }
        }
        if (paramArticleSummary.enum_article_style.has())
        {
          localArticleInfo.articleStyle = paramArticleSummary.enum_article_style.get();
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): articleInfo.articleStyle = " + localArticleInfo.articleStyle);
          }
        }
        if (!paramArticleSummary.msg_sub_article_summary.has()) {
          break label2439;
        }
        localArticleInfo.mSubSummaryListObj = paramArticleSummary.msg_sub_article_summary.get();
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): summary.msg_sub_article_summary.has() = true");
        }
        if ((localArticleInfo.mSubSummaryListObj == null) || (localArticleInfo.mSubSummaryListObj.size() <= 0)) {
          break label2439;
        }
        paramArticleInfo = new ArrayList(localArticleInfo.mSubSummaryListObj.size());
        localObject1 = localArticleInfo.mSubSummaryListObj.iterator();
        i = 0;
        if (!((Iterator)localObject1).hasNext()) {
          break label2392;
        }
        Object localObject2 = a((articlesummary.ArticleSummary)((Iterator)localObject1).next(), paramInt1, paramInt2, null);
        paramArticleInfo.add(localObject2);
        if ((!QLog.isColorLevel()) || (localObject2 == null)) {
          break label5067;
        }
        localObject2 = new StringBuilder().append("convertArticleInfo(): 解析 sub articleSummary【");
        j = i + 1;
        QLog.e("ReadInJoyMSFHandlerUtils", 2, i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + ors.c(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " algorithmID : " + localArticleInfo.mAlgorithmID + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName);
        i = j;
      }
    }
    label1680:
    label1687:
    label2366:
    label5061:
    label5067:
    for (;;)
    {
      for (;;)
      {
        label2161:
        break label2161;
        localArticleInfo.mStrCircleId = "";
        break label1656;
        bool1 = false;
        break label1680;
        localArticleInfo.mPUinIsActive = true;
        break label1687;
        label2392:
        localArticleInfo.mSubArtilceList = paramArticleInfo;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): summary.msg_sub_article_summary.size = " + localArticleInfo.mSubSummaryListObj.size());
        }
        if (paramArticleSummary.bytes_interface_data.has())
        {
          localArticleInfo.proteusItemsData = paramArticleSummary.bytes_interface_data.get().toStringUtf8();
          ors.a(localArticleInfo);
        }
        if ((paramArticleSummary.bytes_recommend_reason.has()) && (paramArticleSummary.bytes_recommend_reason.get() != null)) {
          localArticleInfo.mRecommentdReason = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
        }
        if ((TextUtils.isEmpty(localArticleInfo.mRecommentdReason)) && (!TextUtils.isEmpty(localArticleInfo.proteusItemsData))) {}
        try
        {
          localArticleInfo.mRecommentdReason = new JSONObject(localArticleInfo.proteusItemsData).optString("recommend_reason");
          if (paramArticleSummary.uint32_video_comment_count.has()) {
            localArticleInfo.mVideoCommentCount = paramArticleSummary.uint32_video_comment_count.get();
          }
          if ((paramArticleSummary.bytes_video_subscript_txt.has()) && (paramArticleSummary.bytes_video_subscript_txt.get() != null)) {
            localArticleInfo.mVideoArticleSubsText = paramArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
          }
          if ((paramArticleSummary.bytes_video_subscript_color.has()) && (paramArticleSummary.bytes_video_subscript_color.get() != null)) {
            localArticleInfo.mVideoArticleSubsColor = paramArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
          }
          if ((paramArticleSummary.bytes_ads_jump_url.has()) && (paramArticleSummary.bytes_ads_jump_url.get() != null)) {
            localArticleInfo.mVideoAdsJumpUrl = paramArticleSummary.bytes_ads_jump_url.get().toStringUtf8();
          }
          if (paramArticleSummary.uint32_ads_jump_type.has()) {
            localArticleInfo.mVideoAdsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
          }
          if (paramArticleSummary.uint32_ads_source.has()) {
            localArticleInfo.mVideoAdsSource = paramArticleSummary.uint32_ads_source.get();
          }
          if ((paramArticleSummary.bytes_video_report_info.has()) && (paramArticleSummary.bytes_video_report_info.get() != null))
          {
            localArticleInfo.videoReportInfo = paramArticleSummary.bytes_video_report_info.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyMSFHandlerUtils", 2, "articleInfo.mArticleID = " + localArticleInfo.mArticleID + "videoReportInfo = " + localArticleInfo.videoReportInfo);
            }
          }
          if (paramArticleSummary.diandian_wording.has())
          {
            paramArticleInfo = (articlesummary.DiandianWording)paramArticleSummary.diandian_wording.get();
            if (paramArticleInfo.bytes_msg_wording.has())
            {
              localArticleInfo.msgBoxBriefContent = paramArticleInfo.bytes_msg_wording.get().toStringUtf8();
              if (paramArticleInfo.bytes_uin_or_nick.has())
              {
                localArticleInfo.msgBoxBriefPreFix = paramArticleInfo.bytes_uin_or_nick.get().toStringUtf8();
                localArticleInfo.msgBoxBriefPreFixType = paramArticleInfo.uint32_uin_type.get();
              }
            }
          }
          if (paramArticleSummary.diandian_label.has())
          {
            paramArticleInfo = (articlesummary.DiandianLabel)paramArticleSummary.diandian_label.get();
            if (paramArticleInfo.bytes_icon_url.has())
            {
              localArticleInfo.mDianDianLabelIconUrl = paramArticleInfo.bytes_icon_url.get().toStringUtf8();
              QLog.d("ReadInJoyMSFHandlerUtils", 2, "articleInfo.diandianLabelIconUrl = " + localArticleInfo.mDianDianLabelIconUrl);
            }
            if (paramArticleInfo.bytes_icon_wording.has())
            {
              localArticleInfo.mDianDianLabelText = paramArticleInfo.bytes_icon_wording.get().toStringUtf8();
              QLog.d("ReadInJoyMSFHandlerUtils", 2, "articleInfo.diandianLabelText = " + localArticleInfo.mDianDianLabelText);
            }
          }
          if (paramArticleSummary.msg_new_pack_info.has())
          {
            localArticleInfo.mNewPolymericInfo = qlj.a((articlesummary.NewPackInfo)paramArticleSummary.msg_new_pack_info.get());
            if ((localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              localArticleInfo.businessId = ((qno)localArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int;
            }
          }
          if (paramArticleSummary.video_download_bar_info.has())
          {
            localArticleInfo.mVideoDownloadBarInfo = ((articlesummary.VideoDownloadBarInfo)paramArticleSummary.video_download_bar_info.get());
            if (localArticleInfo.mVideoDownloadBarInfo != null) {
              QLog.d("ReadInJoyMSFHandlerUtils", 2, "articleInfo.mVideoDownloadBarInfo = " + localArticleInfo.mVideoDownloadBarInfo.uint32_appear_style.get());
            }
          }
          if (paramArticleSummary.recommend_info.has()) {
            localArticleInfo.mRecommendFollowInfos = qlt.a((articlesummary.RecommendFollowInfos)paramArticleSummary.recommend_info.get());
          }
          if (paramArticleSummary.hot_word_info.has()) {
            localArticleInfo.hotWordInfo = qky.a((articlesummary.HotWordInfo)paramArticleSummary.hot_word_info.get());
          }
          if ((paramArticleSummary.bytes_first_page_gif_url.has()) && (paramArticleSummary.bytes_first_page_gif_url.get() != null)) {
            localArticleInfo.gifCoverUrl = paramArticleSummary.bytes_first_page_gif_url.get().toStringUtf8();
          }
          if (paramArticleSummary.uint32_is_first_page_use_gif.has())
          {
            if (paramArticleSummary.uint32_is_first_page_use_gif.get() == 1)
            {
              bool1 = true;
              localArticleInfo.isUseGif = bool1;
            }
          }
          else
          {
            ors.a(localArticleInfo);
            if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_aggregated_list.has()))
            {
              paramArticleInfo = (articlesummary.AggregatedList)paramArticleSummary.msg_feeds_info.msg_aggregated_list.get();
              localArticleInfo.mExtraBiuBriefInfo = qks.a(paramArticleInfo);
              if ((paramArticleInfo.uint32_aggregated_content_type.has()) && (paramArticleInfo.uint32_aggregated_content_type.get() == 2) && (paramArticleInfo.rpt_multi_biu_same_content != null) && (paramArticleInfo.rpt_multi_biu_same_content.has()))
              {
                localArticleInfo.multiBiuSameContentList = MultiBiuSameContent.a(paramArticleInfo.rpt_multi_biu_same_content.get());
                localArticleInfo.mMultiBiuSameListObj = paramArticleInfo.rpt_multi_biu_same_content.get();
              }
            }
            if (paramArticleSummary.awesome_comment_icon.has())
            {
              localArticleInfo.hasAwesome = true;
              qki.a(localArticleInfo, (articlesummary.AwesomeCommentInfo)paramArticleSummary.awesome_comment_icon.get());
            }
            if (paramArticleSummary.msg_family_comment_info.has())
            {
              localArticleInfo.familyCommentInfoByte = ((articlesummary.FamilyCommentInfo)paramArticleSummary.msg_family_comment_info.get()).toByteArray();
              paramArticleInfo = (articlesummary.FamilyCommentInfo)paramArticleSummary.msg_family_comment_info.get();
              localObject1 = new qku();
              if (paramArticleInfo.icon_url.has()) {
                ((qku)localObject1).jdField_a_of_type_JavaLangString = paramArticleInfo.icon_url.get().toStringUtf8();
              }
              if (paramArticleInfo.jump_url.has()) {
                ((qku)localObject1).jdField_b_of_type_JavaLangString = paramArticleInfo.jump_url.get().toStringUtf8();
              }
              if (paramArticleInfo.medal_urls_width.has()) {
                ((qku)localObject1).jdField_a_of_type_Int = paramArticleInfo.medal_urls_width.get();
              }
              if (paramArticleInfo.medal_urls_height.has()) {
                ((qku)localObject1).jdField_b_of_type_Int = paramArticleInfo.medal_urls_height.get();
              }
              localArticleInfo.familyCommentInfo = ((qku)localObject1);
              QLog.d("ReadInJoyMSFHandlerUtils", 1, "FamilyCommentInfo : " + localArticleInfo.familyCommentInfo);
            }
            if ((paramArticleSummary.bytes_gw_common_data.has()) && (paramArticleSummary.bytes_gw_common_data.get() != null))
            {
              localArticleInfo.mGWCommonData = paramArticleSummary.bytes_gw_common_data.get().toStringUtf8();
              QLog.d("ReadInJoyMSFHandlerUtils", 1, new Object[] { "gwCommonData = ", localArticleInfo.mGWCommonData });
            }
            if ((paramArticleSummary.bytes_report_common_data.has()) && (paramArticleSummary.bytes_report_common_data.get() != null))
            {
              localArticleInfo.mReportCommonData = paramArticleSummary.bytes_report_common_data.get().toStringUtf8();
              QLog.d("ReadInJoyMSFHandlerUtils", 1, new Object[] { "mReportCommonData = ", localArticleInfo.mReportCommonData });
            }
            if (paramArticleSummary.uint32_article_type.has()) {
              localArticleInfo.mArticleType = paramArticleSummary.uint32_article_type.get();
            }
            if (paramArticleSummary.uint32_is_close_dislike.has()) {
              localArticleInfo.isCloseDislike = paramArticleSummary.uint32_is_close_dislike.get();
            }
            if (paramArticleSummary.uint32_is_super_top_article.has()) {
              localArticleInfo.isSuperTop = paramArticleSummary.uint32_is_super_top_article.get();
            }
            if ((paramArticleSummary.bytes_video_logo_url.has()) && (paramArticleSummary.bytes_video_logo_url.get() != null)) {
              localArticleInfo.mVideoLogoUrl = paramArticleSummary.bytes_video_logo_url.get().toStringUtf8();
            }
            if (paramArticleSummary.msg_partner_account_info.has())
            {
              paramArticleInfo = (articlesummary.PartnerAccountInfo)paramArticleSummary.msg_partner_account_info.get();
              if ((paramArticleInfo != null) && (paramArticleInfo.uint32_is_account_display.has()))
              {
                if (paramArticleInfo.uint32_is_account_display.get() == 0) {
                  break label5012;
                }
                bool1 = true;
                localArticleInfo.isAccountShown = bool1;
                localArticleInfo.mPartnerAccountInfo = paramArticleInfo;
              }
            }
            if ((paramArticleSummary.msg_feeds_info.has()) && (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.has()))
            {
              if (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_card_jump_info.has()) {
                localArticleInfo.mCardJumpUrl = paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8();
              }
              if (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_card_jump_info.uint32_available.has()) {
                localArticleInfo.isCardJumpUrlAvailable = paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_card_jump_info.uint32_available.get();
              }
              if (paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_card_jump_info.bytes_comment_btn_url.has()) {
                localArticleInfo.commentBtnJumpUrl = paramArticleSummary.msg_feeds_info.msg_social_feeds_info.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8();
              }
            }
            if ((paramArticleSummary.video_column_info.has()) && (paramArticleSummary.video_column_info.get() != null))
            {
              localArticleInfo.mVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)paramArticleSummary.video_column_info.get());
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): mVideoColumnInfo" + localArticleInfo.mVideoColumnInfo);
              }
            }
            if ((paramArticleSummary.video_simple_column_info.has()) && (paramArticleSummary.video_simple_column_info.get() != null))
            {
              localArticleInfo.mSimpleVideoColumnInfo = VideoColumnInfo.a((articlesummary.VideoColumnInfo)paramArticleSummary.video_simple_column_info.get());
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo(): mSimpleVideoColumnInfo" + localArticleInfo.mSimpleVideoColumnInfo);
              }
            }
            if ((paramArticleSummary.bytes_comment_button_jump_url.has()) && (paramArticleSummary.bytes_comment_button_jump_url.get() != null)) {
              localArticleInfo.comment_jump_url = paramArticleSummary.bytes_comment_button_jump_url.get().toStringUtf8();
            }
            if (paramArticleSummary.uint32_is_show_search_word.has()) {
              localArticleInfo.mIsShowSearchord = paramArticleSummary.uint32_is_show_search_word.get();
            }
            if ((paramArticleSummary.bytes_ad_report_common_data.has()) && (paramArticleSummary.bytes_ad_report_common_data.get() != null)) {
              localArticleInfo.adReportCommonData = paramArticleSummary.bytes_ad_report_common_data.get().toStringUtf8();
            }
            if (paramArticleSummary.msg_srt_universal_id.has())
            {
              localArticleInfo.srtUniversalID = paramArticleSummary.msg_srt_universal_id.get();
              a(localArticleInfo.srtUniversalID, localArticleInfo);
            }
            if ((!paramArticleSummary.msg_account_v_info.has()) || (paramArticleSummary.msg_account_v_info.get() == null)) {
              break label5025;
            }
            paramArticleInfo = (articlesummary.AccountVInfo)paramArticleSummary.msg_account_v_info.get();
            if (!paramArticleInfo.bytes_v_icon_url.has()) {
              break label5018;
            }
            paramArticleInfo = paramArticleInfo.bytes_v_icon_url.get().toStringUtf8();
            localArticleInfo.vIconUrl = paramArticleInfo;
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyMSFHandlerUtils", 2, "[convertArticleInfo], vIconUrl = " + localArticleInfo.vIconUrl);
            }
            if ((paramArticleSummary.video_multi_column_info.has()) && (paramArticleSummary.video_multi_column_info.get() != null))
            {
              localArticleInfo.multiVideoColumnInfoBytes = ((articlesummary.VideoColumnInfo)paramArticleSummary.video_multi_column_info.get()).toByteArray();
              localArticleInfo.multiVideoColumnInfo = qli.a((articlesummary.VideoColumnInfo)paramArticleSummary.video_multi_column_info.get());
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo: multiVideoColumnInfo=" + localArticleInfo.multiVideoColumnInfo.toString());
              }
            }
            if (paramArticleSummary.msg_scrip_cms_info.has())
            {
              localArticleInfo.scripCmsInfo = qlx.a((articlesummary.ScripCmsInfo)paramArticleSummary.msg_scrip_cms_info.get());
              localArticleInfo.scripCmsInfoByte = ((articlesummary.ScripCmsInfo)paramArticleSummary.msg_scrip_cms_info.get()).toByteArray();
              if (paramInt2 != 7) {
                break label5043;
              }
              localArticleInfo.scripCmsInfo.jdField_b_of_type_Int = 1;
              paramArticleInfo = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              pid.a(BaseApplicationImpl.getApplication(), paramArticleInfo, pid.a(BaseApplicationImpl.getApplication(), paramArticleInfo) + 1);
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertArticleInfo: Scrip Cms Info = " + localArticleInfo.scripCmsInfo.toString());
              }
            }
            if ((paramArticleSummary.msg_kd_live_info.has()) && (paramArticleSummary.msg_kd_live_info.get() != null))
            {
              localArticleInfo.mKdLiveInfoBytes = ((articlesummary.KdLiveInfo)paramArticleSummary.msg_kd_live_info.get()).toByteArray();
              localArticleInfo.mKdLiveInfo = qlb.a((articlesummary.KdLiveInfo)paramArticleSummary.msg_kd_live_info.get());
              if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyMSFHandlerUtils", 2, "convertKandianLiveInfo: kdLiveInfo=" + localArticleInfo.mKdLiveInfo.toString());
              }
            }
            if ((paramArticleSummary.msg_ug_info.has()) && (paramArticleSummary.msg_ug_info.get() != null))
            {
              localArticleInfo.weishiUGInfo = ((articlesummary.WeishiUGInfo)paramArticleSummary.msg_ug_info.get());
              localArticleInfo.mWeishiUGInfo = localArticleInfo.weishiUGInfo.toByteArray();
              QLog.d("ReadInJoyMSFHandlerUtils", 1, "UGRuleManager getArticleInfo weishiugInfo has title is : " + localArticleInfo.mTitle);
            }
            if (paramArticleSummary.uint32_expose_repeat_flag.has())
            {
              if (paramArticleSummary.uint32_expose_repeat_flag.get() != 1) {
                break label5061;
              }
              bool1 = true;
              localArticleInfo.isNeeaRealExposureFilter = bool1;
            }
            qjy.a(localArticleInfo);
            bool1 = bool2;
            if (paramArticleSummary.uint32_red_package_flag.has())
            {
              bool1 = bool2;
              if (paramArticleSummary.uint32_red_package_flag.get() == 1) {
                bool1 = true;
              }
            }
            localArticleInfo.hasWalletIcon = bool1;
            if ((localArticleInfo.hasWalletIcon) && (QLog.isColorLevel())) {
              QLog.i("ReadInJoyMSFHandlerUtils", 1, "article info rowkey: " + localArticleInfo.innerUniqueID + "has wallet: " + localArticleInfo.hasWalletIcon);
            }
            if ((paramArticleSummary.card_column_entrances.has()) && (paramArticleSummary.card_column_entrances.get() != null)) {
              localArticleInfo.columnEntrances = VideoColumnInfo.a(paramArticleSummary.card_column_entrances);
            }
            paramArticleSummary = localArticleInfo;
            if (!localArticleInfo.isWormhole()) {
              break;
            }
            sro.a(localArticleInfo);
            return localArticleInfo;
          }
        }
        catch (JSONException paramArticleInfo)
        {
          for (;;)
          {
            QLog.e("ReadInJoyMSFHandlerUtils", 2, paramArticleInfo.getMessage());
            continue;
            bool1 = false;
            continue;
            bool1 = false;
            continue;
            paramArticleInfo = "";
            continue;
            if (QLog.isColorLevel())
            {
              QLog.d("ReadInJoyMSFHandlerUtils", 2, "[convertArticleInfo], vIconUrl is null.");
              continue;
              if (paramInt2 == 6)
              {
                localArticleInfo.scripCmsInfo.jdField_b_of_type_Int = 2;
                continue;
                bool1 = false;
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public static ChannelCoverInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 1280	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo
    //   5: dup
    //   6: invokespecial 1281	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:<init>	()V
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 1284	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_channel_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   18: ifeq +15 -> 33
    //   21: aload 4
    //   23: aload_0
    //   24: getfield 1284	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_channel_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   27: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   30: putfield 1287	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverId	I
    //   33: aload_0
    //   34: getfield 1288	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   37: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   40: ifeq +28 -> 68
    //   43: aload_0
    //   44: getfield 1288	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   50: ifnull +18 -> 68
    //   53: aload 4
    //   55: aload_0
    //   56: getfield 1288	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   59: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   62: invokevirtual 123	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   65: putfield 1291	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverName	Ljava/lang/String;
    //   68: aload_0
    //   69: getfield 1294	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:enum_channel_cover_style	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   72: invokevirtual 598	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   75: ifeq +15 -> 90
    //   78: aload 4
    //   80: aload_0
    //   81: getfield 1294	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:enum_channel_cover_style	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   84: invokevirtual 510	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   87: putfield 1297	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverStyle	I
    //   90: aload_0
    //   91: getfield 1300	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   94: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   97: ifeq +38 -> 135
    //   100: aload_0
    //   101: getfield 1300	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: ifnull +28 -> 135
    //   110: aload 4
    //   112: new 12	java/lang/String
    //   115: dup
    //   116: aload_0
    //   117: getfield 1300	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   120: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 319	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   126: ldc_w 1302
    //   129: invokespecial 1305	java/lang/String:<init>	([BLjava/lang/String;)V
    //   132: putfield 1308	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverSummary	Ljava/lang/String;
    //   135: aload_0
    //   136: getfield 1311	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_spec	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   139: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   142: ifeq +82 -> 224
    //   145: aload_0
    //   146: getfield 1311	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_spec	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   149: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   152: ifnull +72 -> 224
    //   155: aload 4
    //   157: new 12	java/lang/String
    //   160: dup
    //   161: aload_0
    //   162: getfield 1311	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_spec	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 319	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   171: ldc_w 1302
    //   174: invokespecial 1305	java/lang/String:<init>	([BLjava/lang/String;)V
    //   177: putfield 1314	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverSpec	Ljava/lang/String;
    //   180: new 260	org/json/JSONObject
    //   183: dup
    //   184: aload 4
    //   186: getfield 1314	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverSpec	Ljava/lang/String;
    //   189: invokespecial 263	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   192: ldc_w 1316
    //   195: invokevirtual 1319	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: astore 5
    //   200: aload 5
    //   202: invokestatic 681	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifne +19 -> 224
    //   208: aload 4
    //   210: iconst_1
    //   211: putfield 1322	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:hasFilterColor	Z
    //   214: aload 4
    //   216: aload 5
    //   218: invokestatic 1327	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   221: putfield 1329	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:filterColor	I
    //   224: aload_0
    //   225: getfield 1332	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   228: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   231: ifeq +448 -> 679
    //   234: aload_0
    //   235: getfield 1332	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   238: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   241: ifnull +438 -> 679
    //   244: aload 4
    //   246: new 12	java/lang/String
    //   249: dup
    //   250: aload_0
    //   251: getfield 1332	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 319	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: ldc_w 1302
    //   263: invokespecial 1305	java/lang/String:<init>	([BLjava/lang/String;)V
    //   266: putfield 1335	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelJumpUrl	Ljava/lang/String;
    //   269: aload 4
    //   271: iconst_1
    //   272: putfield 1338	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mColumnType	I
    //   275: aload_0
    //   276: getfield 1341	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_picurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   279: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   282: ifeq +38 -> 320
    //   285: aload_0
    //   286: getfield 1341	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_picurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   289: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   292: ifnull +28 -> 320
    //   295: aload 4
    //   297: new 12	java/lang/String
    //   300: dup
    //   301: aload_0
    //   302: getfield 1341	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_channel_cover_picurl	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   305: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   308: invokevirtual 319	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   311: ldc_w 1302
    //   314: invokespecial 1305	java/lang/String:<init>	([BLjava/lang/String;)V
    //   317: putfield 1344	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverPicUrl	Ljava/lang/String;
    //   320: aload_0
    //   321: getfield 1347	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_is_followed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   324: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   327: ifeq +15 -> 342
    //   330: aload 4
    //   332: aload_0
    //   333: getfield 1347	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_is_followed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: putfield 1350	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mFollowType	I
    //   342: aload_0
    //   343: getfield 1353	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:enum_column_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   346: invokevirtual 598	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   349: ifeq +15 -> 364
    //   352: aload 4
    //   354: aload_0
    //   355: getfield 1353	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:enum_column_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   358: invokevirtual 510	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   361: putfield 1338	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mColumnType	I
    //   364: aload_0
    //   365: getfield 1357	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:msg_rich_tips	Ltencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips;
    //   368: invokevirtual 1360	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:has	()Z
    //   371: ifeq +389 -> 760
    //   374: aload_0
    //   375: getfield 1357	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:msg_rich_tips	Ltencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips;
    //   378: invokevirtual 1361	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   381: ifnull +379 -> 760
    //   384: aload_0
    //   385: getfield 1357	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:msg_rich_tips	Ltencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips;
    //   388: invokevirtual 1361	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   391: checkcast 1359	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips
    //   394: astore 5
    //   396: aload 5
    //   398: getfield 1364	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:uint32_tips_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   401: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   404: ifeq +16 -> 420
    //   407: aload 4
    //   409: aload 5
    //   411: getfield 1364	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:uint32_tips_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   414: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   417: putfield 1367	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mTipsType	I
    //   420: aload 5
    //   422: getfield 1370	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:bytes_tips_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   425: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   428: ifeq +40 -> 468
    //   431: aload 5
    //   433: getfield 1370	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:bytes_tips_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   436: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   439: ifnull +29 -> 468
    //   442: aload 4
    //   444: new 12	java/lang/String
    //   447: dup
    //   448: aload 5
    //   450: getfield 1370	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:bytes_tips_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   453: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   456: invokevirtual 319	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   459: ldc_w 1302
    //   462: invokespecial 1305	java/lang/String:<init>	([BLjava/lang/String;)V
    //   465: putfield 1373	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mTipsText	Ljava/lang/String;
    //   468: aload 5
    //   470: getfield 1376	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:uint32_latest_sticky_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   473: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   476: ifeq +17 -> 493
    //   479: aload 4
    //   481: aload 5
    //   483: getfield 1376	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$RichTips:uint32_latest_sticky_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   486: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   489: i2l
    //   490: putfield 1379	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mUpdateTime	J
    //   493: invokestatic 1384	owy:a	()Lowy;
    //   496: iload_1
    //   497: invokevirtual 1387	owy:a	(I)Ljava/util/List;
    //   500: checkcast 415	java/util/ArrayList
    //   503: astore 5
    //   505: aload 5
    //   507: ifnull +253 -> 760
    //   510: aload 5
    //   512: invokevirtual 1388	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   515: astore 5
    //   517: aload 5
    //   519: invokeinterface 626 1 0
    //   524: ifeq +236 -> 760
    //   527: aload 5
    //   529: invokeinterface 630 1 0
    //   534: checkcast 1280	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo
    //   537: astore 6
    //   539: aload 6
    //   541: getfield 1287	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverId	I
    //   544: aload 4
    //   546: getfield 1287	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelCoverId	I
    //   549: if_icmpne -32 -> 517
    //   552: aload 4
    //   554: aload 6
    //   556: getfield 1391	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mPreUpdateTime	J
    //   559: putfield 1391	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mPreUpdateTime	J
    //   562: goto -45 -> 517
    //   565: astore 5
    //   567: ldc_w 1393
    //   570: iconst_1
    //   571: new 63	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   578: ldc_w 1395
    //   581: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 5
    //   586: invokevirtual 1396	java/lang/Exception:toString	()Ljava/lang/String;
    //   589: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: goto -463 -> 135
    //   601: astore 5
    //   603: ldc_w 1393
    //   606: iconst_1
    //   607: new 63	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 1398
    //   617: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload 5
    //   622: invokevirtual 1396	java/lang/Exception:toString	()Ljava/lang/String;
    //   625: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: goto -410 -> 224
    //   637: astore 5
    //   639: ldc_w 1393
    //   642: iconst_1
    //   643: new 63	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 1400
    //   653: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload 5
    //   658: invokevirtual 1396	java/lang/Exception:toString	()Ljava/lang/String;
    //   661: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: aload 4
    //   672: iconst_0
    //   673: putfield 1338	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mColumnType	I
    //   676: goto -401 -> 275
    //   679: aload 4
    //   681: iconst_0
    //   682: putfield 1338	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mColumnType	I
    //   685: goto -410 -> 275
    //   688: astore 5
    //   690: ldc_w 1393
    //   693: iconst_1
    //   694: new 63	java/lang/StringBuilder
    //   697: dup
    //   698: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   701: ldc_w 1402
    //   704: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload 5
    //   709: invokevirtual 1396	java/lang/Exception:toString	()Ljava/lang/String;
    //   712: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: goto -401 -> 320
    //   724: astore 6
    //   726: ldc_w 1393
    //   729: iconst_1
    //   730: new 63	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 1404
    //   740: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 6
    //   745: invokevirtual 1396	java/lang/Exception:toString	()Ljava/lang/String;
    //   748: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: goto -289 -> 468
    //   760: aload_0
    //   761: getfield 1405	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   764: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   767: ifeq +38 -> 805
    //   770: aload_0
    //   771: getfield 1405	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   774: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   777: ifnull +28 -> 805
    //   780: aload 4
    //   782: new 12	java/lang/String
    //   785: dup
    //   786: aload_0
    //   787: getfield 1405	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   790: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   793: invokevirtual 319	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   796: ldc_w 1302
    //   799: invokespecial 1305	java/lang/String:<init>	([BLjava/lang/String;)V
    //   802: putfield 1408	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mIconUrl	Ljava/lang/String;
    //   805: aload_0
    //   806: getfield 1411	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_fonts_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   809: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   812: ifeq +25 -> 837
    //   815: aload_0
    //   816: getfield 1411	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_fonts_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   819: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   822: ifeq +15 -> 837
    //   825: aload 4
    //   827: aload_0
    //   828: getfield 1411	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_fonts_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   831: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   834: putfield 1414	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mFontColor	I
    //   837: aload_0
    //   838: getfield 1417	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_frame_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   841: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   844: ifeq +25 -> 869
    //   847: aload_0
    //   848: getfield 1417	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_frame_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   851: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   854: ifeq +15 -> 869
    //   857: aload 4
    //   859: aload_0
    //   860: getfield 1417	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_frame_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   863: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   866: putfield 1420	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mFrameColor	I
    //   869: aload 4
    //   871: iload_1
    //   872: putfield 1423	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelId	I
    //   875: aload_0
    //   876: getfield 1426	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint64_channel_cover_article_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   879: invokevirtual 101	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   882: ifeq +15 -> 897
    //   885: aload 4
    //   887: aload_0
    //   888: getfield 1426	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint64_channel_cover_article_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   891: invokevirtual 105	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   894: putfield 1429	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mArticleId	J
    //   897: aload_0
    //   898: getfield 1430	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   901: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   904: ifeq +15 -> 919
    //   907: aload 4
    //   909: aload_0
    //   910: getfield 1430	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   913: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   916: putfield 1433	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mChannelType	I
    //   919: aload_0
    //   920: getfield 1436	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_is_topic	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   923: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   926: ifeq +21 -> 947
    //   929: aload_0
    //   930: getfield 1436	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_is_topic	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   933: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   936: ifle +133 -> 1069
    //   939: iconst_1
    //   940: istore_2
    //   941: aload 4
    //   943: iload_2
    //   944: putfield 1439	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:mIsTopic	Z
    //   947: aload_0
    //   948: getfield 1442	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_is_external_expose	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   951: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   954: ifeq +22 -> 976
    //   957: aload_0
    //   958: getfield 1442	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_is_external_expose	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   961: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   964: iconst_1
    //   965: if_icmpne +109 -> 1074
    //   968: iconst_1
    //   969: istore_2
    //   970: aload 4
    //   972: iload_2
    //   973: putfield 1445	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:isExternalExposure	Z
    //   976: aload_0
    //   977: getfield 1448	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_is_external_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   980: invokevirtual 115	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   983: ifeq +18 -> 1001
    //   986: aload 4
    //   988: aload_0
    //   989: getfield 1448	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:bytes_is_external_bg_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   992: invokevirtual 118	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   995: invokevirtual 123	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   998: putfield 1451	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:externalExposureBackgroundUrl	Ljava/lang/String;
    //   1001: aload_0
    //   1002: getfield 1454	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_has_recommend	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1005: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1008: ifeq +22 -> 1030
    //   1011: aload_0
    //   1012: getfield 1454	tencent/im/oidb/cmd0x69f/oidb_cmd0x69f$ChannelInfo:uint32_has_recommend	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1015: invokevirtual 167	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1018: iconst_1
    //   1019: if_icmpne +60 -> 1079
    //   1022: iload_3
    //   1023: istore_2
    //   1024: aload 4
    //   1026: iload_2
    //   1027: putfield 1457	com/tencent/biz/pubaccount/readinjoy/struct/ChannelCoverInfo:isExternalExposurePersist	Z
    //   1030: aload 4
    //   1032: areturn
    //   1033: astore 5
    //   1035: ldc_w 1393
    //   1038: iconst_1
    //   1039: new 63	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 1459
    //   1049: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload 5
    //   1054: invokevirtual 1396	java/lang/Exception:toString	()Ljava/lang/String;
    //   1057: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: goto -261 -> 805
    //   1069: iconst_0
    //   1070: istore_2
    //   1071: goto -130 -> 941
    //   1074: iconst_0
    //   1075: istore_2
    //   1076: goto -106 -> 970
    //   1079: iconst_0
    //   1080: istore_2
    //   1081: goto -57 -> 1024
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1084	0	paramChannelInfo	oidb_cmd0x69f.ChannelInfo
    //   0	1084	1	paramInt	int
    //   940	141	2	bool1	boolean
    //   1	1022	3	bool2	boolean
    //   9	1022	4	localChannelCoverInfo1	ChannelCoverInfo
    //   198	330	5	localObject	Object
    //   565	20	5	localException1	Exception
    //   601	20	5	localException2	Exception
    //   637	20	5	localException3	Exception
    //   688	20	5	localException4	Exception
    //   1033	20	5	localException5	Exception
    //   537	18	6	localChannelCoverInfo2	ChannelCoverInfo
    //   724	20	6	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   110	135	565	java/lang/Exception
    //   155	224	601	java/lang/Exception
    //   244	275	637	java/lang/Exception
    //   295	320	688	java/lang/Exception
    //   442	468	724	java/lang/Exception
    //   780	805	1033	java/lang/Exception
  }
  
  public static ChannelCoverInfo a(oidb_cmd0xbe6.MsgChannelInfo paramMsgChannelInfo, int paramInt)
  {
    ChannelCoverInfo localChannelCoverInfo = new ChannelCoverInfo();
    if (paramMsgChannelInfo.string_name.has()) {
      localChannelCoverInfo.mChannelCoverName = paramMsgChannelInfo.string_name.get();
    }
    if (paramMsgChannelInfo.uint32_channel_id.has()) {
      localChannelCoverInfo.mChannelCoverId = paramMsgChannelInfo.uint32_channel_id.get();
    }
    if (paramMsgChannelInfo.uint32_channel_type.has()) {
      localChannelCoverInfo.mChannelType = paramMsgChannelInfo.uint32_channel_type.get();
    }
    localChannelCoverInfo.mChannelId = paramInt;
    return localChannelCoverInfo;
  }
  
  public static ChannelInfo a(oidb_cmd0x69f.ChannelInfo paramChannelInfo)
  {
    ChannelInfo localChannelInfo = new ChannelInfo();
    if (paramChannelInfo.uint32_channel_id.has()) {
      localChannelInfo.mChannelID = paramChannelInfo.uint32_channel_id.get();
    }
    if ((paramChannelInfo.bytes_channel_name.has()) && (paramChannelInfo.bytes_channel_name.get() != null)) {
      localChannelInfo.mChannelName = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
    }
    if (paramChannelInfo.uint32_channel_type.has()) {
      localChannelInfo.mChannelType = paramChannelInfo.uint32_channel_type.get();
    }
    if ((paramChannelInfo.uint32_is_first_req.has()) && (localChannelInfo.mChannelType == 1)) {
      if (paramChannelInfo.uint32_is_first_req.get() == 0) {
        break label227;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localChannelInfo.mIsFirstReq = bool;
      if ((paramChannelInfo.uint32_frame_color.has()) && (paramChannelInfo.uint32_frame_color.get() != 0)) {
        localChannelInfo.mFrameColor = paramChannelInfo.uint32_frame_color.get();
      }
      if ((paramChannelInfo.uint32_fonts_color.has()) && (paramChannelInfo.uint32_fonts_color.get() != 0)) {
        localChannelInfo.mFontColor = paramChannelInfo.uint32_fonts_color.get();
      }
      if ((paramChannelInfo.bytes_channel_jump_url.has()) && (paramChannelInfo.bytes_channel_jump_url.get() != null)) {}
      try
      {
        localChannelInfo.mJumpUrl = new String(paramChannelInfo.bytes_channel_jump_url.get().toByteArray(), "utf-8");
        return localChannelInfo;
      }
      catch (Exception paramChannelInfo)
      {
        label227:
        QLog.d("ChannelInfoModule", 1, "resolve search channel jump url failed " + paramChannelInfo.toString());
      }
    }
    return localChannelInfo;
  }
  
  public static TabChannelCoverInfo a(channel_button.Channel paramChannel)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo();
    if (paramChannel.uint64_channel_id.has()) {
      localTabChannelCoverInfo.mChannelCoverId = ((int)paramChannel.uint64_channel_id.get());
    }
    if (paramChannel.str_channel_name.has()) {
      localTabChannelCoverInfo.mChannelCoverName = paramChannel.str_channel_name.get();
    }
    if ((paramChannel.msg_red_point.has()) && (paramChannel.msg_red_point.uint64_start_time.has()) && (paramChannel.msg_red_point.uint64_end_time.has()))
    {
      localTabChannelCoverInfo.redPoint = new qnc();
      if (paramChannel.msg_red_point.bool_red_point.has()) {
        localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = paramChannel.msg_red_point.bool_red_point.get();
      }
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Long = paramChannel.msg_red_point.uint64_start_time.get();
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Long = paramChannel.msg_red_point.uint64_end_time.get();
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Int = paramChannel.msg_red_point.uint32_type.get();
      if (paramChannel.msg_red_point.str_title_text.has()) {
        localTabChannelCoverInfo.redPoint.jdField_a_of_type_JavaLangString = paramChannel.msg_red_point.str_title_text.get();
      }
      localTabChannelCoverInfo.redPoint.jdField_b_of_type_Int = paramChannel.msg_red_point.uint32_title_color.get();
      localTabChannelCoverInfo.redPoint.c = paramChannel.msg_red_point.uint32_bg_color.get();
    }
    if (paramChannel.str_cover_url.has()) {
      localTabChannelCoverInfo.mChannelCoverPicUrl = paramChannel.str_cover_url.get();
    }
    if (paramChannel.str_icon_url.has()) {
      localTabChannelCoverInfo.mIconUrl = paramChannel.str_icon_url.get();
    }
    if ((paramChannel.str_web_url.has()) && (!TextUtils.isEmpty(paramChannel.str_web_url.get()))) {
      localTabChannelCoverInfo.mChannelJumpUrl = paramChannel.str_web_url.get();
    }
    for (localTabChannelCoverInfo.mColumnType = 1;; localTabChannelCoverInfo.mColumnType = 0)
    {
      if (paramChannel.uint64_start_time.has()) {
        localTabChannelCoverInfo.startTimestamp = paramChannel.uint64_start_time.get();
      }
      if (paramChannel.uint64_end_time.has()) {
        localTabChannelCoverInfo.endTimestamp = paramChannel.uint64_end_time.get();
      }
      if (paramChannel.uint32_bold_font.has()) {
        localTabChannelCoverInfo.bold_font = paramChannel.uint32_bold_font.get();
      }
      if (paramChannel.uint32_fonts_color.has()) {
        localTabChannelCoverInfo.fonts_color = paramChannel.uint32_fonts_color.get();
      }
      if (paramChannel.uint32_frame_color.has()) {
        localTabChannelCoverInfo.frame_color = paramChannel.uint32_frame_color.get();
      }
      if (paramChannel.uint32_show_cover.has()) {
        localTabChannelCoverInfo.show_cover = paramChannel.uint32_show_cover.get();
      }
      if (paramChannel.str_proxy.has()) {
        localTabChannelCoverInfo.proxy = paramChannel.str_proxy.get();
      }
      if (paramChannel.uint32_show_icon.has()) {
        localTabChannelCoverInfo.show_icon = paramChannel.uint32_show_icon.get();
      }
      if (paramChannel.enum_reason.has()) {
        localTabChannelCoverInfo.reason = paramChannel.enum_reason.get();
      }
      if (paramChannel.uint32_only_cover.has()) {
        localTabChannelCoverInfo.only_cover = paramChannel.uint32_only_cover.get();
      }
      if (paramChannel.uint32_channel_type.has()) {
        localTabChannelCoverInfo.mChannelType = paramChannel.uint32_channel_type.get();
      }
      if (paramChannel.uint64_section_id.has()) {
        localTabChannelCoverInfo.sectionId = paramChannel.uint64_section_id.get();
      }
      if (paramChannel.uint64_bid.has())
      {
        localTabChannelCoverInfo.bid = paramChannel.uint64_bid.get();
        a(localTabChannelCoverInfo);
      }
      if (paramChannel.uint32_dynamic_sort.has()) {
        localTabChannelCoverInfo.dynamicSort = paramChannel.uint32_dynamic_sort.get();
      }
      if (paramChannel.str_square_icon_url.has()) {
        localTabChannelCoverInfo.mChannelCoverIcon = paramChannel.str_square_icon_url.get();
      }
      if (paramChannel.str_channel_version.has()) {
        localTabChannelCoverInfo.mChannelVersion = paramChannel.str_channel_version.get();
      }
      return localTabChannelCoverInfo;
    }
  }
  
  public static ArrayList<ArticleInfo> a(List<oidb_cmd0x68b.RspGetFollowTabFeeds> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x68b.RspGetFollowTabFeeds localRspGetFollowTabFeeds = (oidb_cmd0x68b.RspGetFollowTabFeeds)paramList.next();
      if ((localRspGetFollowTabFeeds.msg_article_summary.has()) && (localRspGetFollowTabFeeds.uint32_feeds_type.has()))
      {
        ArticleInfo localArticleInfo = a((articlesummary.ArticleSummary)localRspGetFollowTabFeeds.msg_article_summary.get(), 70, 0, null);
        if ((localArticleInfo != null) && (localArticleInfo.mArticleID != -1L) && (localArticleInfo.mRecommendSeq != -1L))
        {
          if (localRspGetFollowTabFeeds.uint64_follow_recommend_id.has()) {
            localArticleInfo.mRecommendFollowId = localRspGetFollowTabFeeds.uint64_follow_recommend_id.get();
          }
          localArticleInfo.mFeedType = localRspGetFollowTabFeeds.uint32_feeds_type.get();
          localArrayList.add(localArticleInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<ChannelInfo> a(List<oidb_cmd0x69f.ChannelInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((oidb_cmd0x69f.ChannelInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List<ArticleInfo> a(List<articlesummary.ArticleSummary> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = a((articlesummary.ArticleSummary)paramList.next(), paramInt1, paramInt2, null);
      if (localArticleInfo != null) {
        localArticleInfo.recommentFlag = paramInt3;
      }
      localArrayList.add(localArticleInfo);
    }
    return localArrayList;
  }
  
  public static List<InterestLabelInfo> a(List<oidb_cmd0x6e5.InterestLabelInfo> paramList, List<Integer> paramList1)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = j;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        i = j;
      }
    }
    else
    {
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        paramList = new InterestLabelInfo();
        paramList.mInterestLabelNme = jdField_a_of_type_ArrayOfJavaLangString[i];
        paramList.mInterestLabelID = jdField_a_of_type_ArrayOfJavaLangInteger[i].intValue();
        paramList.mIsDefault = jdField_a_of_type_ArrayOfJavaLangBoolean[i].booleanValue();
        localArrayList.add(paramList);
        i += 1;
      }
      return localArrayList;
    }
    j = paramList.size();
    paramList = paramList.iterator();
    i = 0;
    if (paramList.hasNext())
    {
      oidb_cmd0x6e5.InterestLabelInfo localInterestLabelInfo = (oidb_cmd0x6e5.InterestLabelInfo)paramList.next();
      InterestLabelInfo localInterestLabelInfo1 = new InterestLabelInfo();
      if (localInterestLabelInfo.uint32_interest_label_id.has()) {
        localInterestLabelInfo1.mInterestLabelID = localInterestLabelInfo.uint32_interest_label_id.get();
      }
      if ((localInterestLabelInfo.bytes_interest_label_name.has()) && (localInterestLabelInfo.bytes_interest_label_name.get() != null)) {
        localInterestLabelInfo1.mInterestLabelNme = localInterestLabelInfo.bytes_interest_label_name.get().toStringUtf8();
      }
      if ((paramList1 != null) && (!paramList1.isEmpty())) {
        localInterestLabelInfo1.mIsDefault = paramList1.contains(Integer.valueOf(localInterestLabelInfo1.mInterestLabelID));
      }
      if ((localInterestLabelInfo1.mInterestLabelNme != null) && (localInterestLabelInfo1.mInterestLabelNme.length() > 3))
      {
        i = a(i, j);
        localArrayList.add(i, localInterestLabelInfo1);
      }
      for (;;)
      {
        break;
        localArrayList.add(localInterestLabelInfo1);
      }
    }
    return localArrayList;
  }
  
  public static void a(ArticleInfo paramArticleInfo, articlesummary.FeedsInfo paramFeedsInfo)
  {
    if (paramFeedsInfo == null)
    {
      paramArticleInfo.mFeedType = 0;
      return;
    }
    if (paramFeedsInfo.feeds_type.has()) {
      paramArticleInfo.mFeedType = paramFeedsInfo.feeds_type.get();
    }
    if ((paramFeedsInfo.uint32_business_id.has()) && ((paramArticleInfo.mPolymericInfo == null) || (paramArticleInfo.mPolymericInfo.jdField_a_of_type_Int != 9))) {
      paramArticleInfo.businessId = paramFeedsInfo.uint32_business_id.get();
    }
    if (paramFeedsInfo.bytes_feeds_cookie.has()) {
      paramArticleInfo.mFeedCookie = paramFeedsInfo.bytes_feeds_cookie.get().toStringUtf8();
    }
    if (paramFeedsInfo.bytes_business_name.has()) {
      paramArticleInfo.businessName = paramFeedsInfo.bytes_business_name.get().toStringUtf8();
    }
    if (paramFeedsInfo.bytes_business_url.has()) {
      paramArticleInfo.businessUrl = paramFeedsInfo.bytes_business_url.get().toStringUtf8();
    }
    if (paramFeedsInfo.bytes_business_name_prefix.has()) {
      paramArticleInfo.businessNamePrefix = paramFeedsInfo.bytes_business_name_prefix.get().toStringUtf8();
    }
    Object localObject;
    if ((paramFeedsInfo.msg_social_feeds_info.has()) && (paramFeedsInfo.msg_social_feeds_info.get() != null))
    {
      localObject = (articlesummary.SocializeFeedsInfo)paramFeedsInfo.msg_social_feeds_info.get();
      paramArticleInfo.mSocialFeedInfo = SocializeFeedsInfo.a((articlesummary.SocializeFeedsInfo)localObject);
      paramArticleInfo.mSocialFeedInfoByte = ((articlesummary.SocializeFeedsInfo)localObject).toByteArray();
      if (paramArticleInfo.mSocialFeedInfo != null) {
        paramArticleInfo.mFeedId = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      }
    }
    if (((!paramFeedsInfo.msg_pos_ad_info.has()) || (paramFeedsInfo.msg_pos_ad_info.get() == null)) || ((paramFeedsInfo.msg_topic_recommend_feeds_info.has()) && (paramFeedsInfo.msg_topic_recommend_feeds_info.get() != null)))
    {
      localObject = (articlesummary.TopicRecommendFeedsInfo)paramFeedsInfo.msg_topic_recommend_feeds_info.get();
      paramArticleInfo.mTopicRecommendFeedsInfo = qnm.a((articlesummary.TopicRecommendFeedsInfo)localObject);
      paramArticleInfo.mTopicRecommendFeedsInfoByte = ((articlesummary.TopicRecommendFeedsInfo)localObject).toByteArray();
      if (paramArticleInfo.mTopicRecommendFeedsInfo == null) {
        break label385;
      }
    }
    label385:
    for (long l = paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_Long;; l = 0L)
    {
      paramArticleInfo.mFeedId = l;
      if ((!paramFeedsInfo.msg_ark_app_feeds_info.has()) || (paramFeedsInfo.msg_ark_app_feeds_info.get() == null)) {
        break;
      }
      paramFeedsInfo = (articlesummary.ArkAppFeedsInfo)paramFeedsInfo.msg_ark_app_feeds_info.get();
      paramArticleInfo.mArkAppFeedsInfo = qkf.a(paramFeedsInfo);
      paramArticleInfo.mArkAppFeedsInfoBytes = paramFeedsInfo.toByteArray();
      paramArticleInfo.mFeedId = paramArticleInfo.mArkAppFeedsInfo.jdField_a_of_type_Long;
      return;
    }
  }
  
  private static void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if ((paramTabChannelCoverInfo == null) || (paramTabChannelCoverInfo.bid <= 0L)) {}
    do
    {
      return;
      QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "preDownloadDynamicChannel, channelCoverInfo = ", paramTabChannelCoverInfo });
    } while (paramTabChannelCoverInfo.bid <= 0L);
    String str = ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId);
    sft.a(str, String.valueOf(paramTabChannelCoverInfo.bid));
    sft.b(str);
    try
    {
      ReadInJoyDynamicChannelBaseFragment.a(str);
      return;
    }
    catch (Exception paramTabChannelCoverInfo)
    {
      QLog.d("ReadInJoyMSFHandlerUtils", 2, "preDownloadDynamicChannel, e = ", paramTabChannelCoverInfo);
    }
  }
  
  public static void a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ors.a((ArticleInfo)paramList.next());
      }
    }
  }
  
  private static void a(List<articlesummary.SRTUniversalID> paramList, ArticleInfo paramArticleInfo)
  {
    paramList = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramList.computeSize(1));
    CodedOutputStreamMicro localCodedOutputStreamMicro = CodedOutputStreamMicro.newInstance(localByteArrayOutputStream);
    paramList.addAll(paramArticleInfo.srtUniversalID);
    try
    {
      paramList.writeTo(localCodedOutputStreamMicro, 1);
      localCodedOutputStreamMicro.flush();
      paramArticleInfo.srtUniversalIDBytesList = localByteArrayOutputStream.toByteArray();
      return;
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  private static boolean a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo.bid <= 0L) {}
    for (;;)
    {
      return true;
      if (paramTabChannelCoverInfo.bid > 0L)
      {
        if (!ovk.a()) {
          return false;
        }
        try
        {
          paramTabChannelCoverInfo = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramTabChannelCoverInfo.mChannelCoverId));
          if (paramTabChannelCoverInfo != null)
          {
            paramTabChannelCoverInfo = paramTabChannelCoverInfo.a();
            if (paramTabChannelCoverInfo != null)
            {
              paramTabChannelCoverInfo = paramTabChannelCoverInfo.b("cgi");
              QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "isDynamicChannelAvailable, cgi = ", paramTabChannelCoverInfo });
              if (TextUtils.isEmpty(paramTabChannelCoverInfo)) {
                continue;
              }
              boolean bool = ProteusJsHelper.preLoadSo();
              return bool;
            }
          }
        }
        catch (Exception paramTabChannelCoverInfo)
        {
          QLog.d("ReadInJoyMSFHandlerUtils", 2, "isDynamicChannelAvailable, e = ", paramTabChannelCoverInfo);
        }
      }
    }
    return false;
  }
  
  public static List<TabChannelCoverInfo> b(List<channel_button.Channel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = a((channel_button.Channel)paramList.next());
        boolean bool = a(localTabChannelCoverInfo);
        QLog.d("ReadInJoyMSFHandlerUtils", 2, new Object[] { "channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), ", name = ", localTabChannelCoverInfo.mChannelCoverName, ", bid = ", Long.valueOf(localTabChannelCoverInfo.bid), ", isAvailable = ", Boolean.valueOf(bool) });
        if ((bool) && (localTabChannelCoverInfo.mChannelCoverId != 41449)) {
          localArrayList.add(localTabChannelCoverInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<qkr> c(List<oidb_cmd0x46f.DislikeResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeResult localDislikeResult = (oidb_cmd0x46f.DislikeResult)paramList.next();
      qkr localqkr = new qkr();
      if (localDislikeResult.uint64_articleid.has()) {
        localqkr.jdField_a_of_type_Long = localDislikeResult.uint64_articleid.get();
      }
      if (localDislikeResult.uint32_result.has()) {
        localqkr.jdField_a_of_type_Int = localDislikeResult.uint32_result.get();
      }
      if (localDislikeResult.str_message.has()) {
        localqkr.jdField_a_of_type_JavaLangString = localDislikeResult.str_message.get();
      }
      localArrayList.add(localqkr);
    }
    return localArrayList;
  }
  
  public static List<TagInfo> d(List<oidb_cmd0xb83.TagInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0xb83.TagInfo localTagInfo = (oidb_cmd0xb83.TagInfo)paramList.next();
        localArrayList.add(new TagInfo(localTagInfo.uint64_tag_id.get(), localTagInfo.bytes_tag_name.get().toStringUtf8(), localTagInfo.double_tag_score.get(), localTagInfo.uint64_channel.get()));
      }
    }
    return localArrayList;
  }
  
  public static List<TopicInfo> e(List<oidb_cmd0xbde.TopicInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0xbde.TopicInfo localTopicInfo = (oidb_cmd0xbde.TopicInfo)paramList.next();
        localArrayList.add(TopicInfo.a().a(localTopicInfo.uint64_topic_id.get()).a(localTopicInfo.bytes_topic_name.get().toStringUtf8()).b(localTopicInfo.bytes_topic_summary.get().toStringUtf8()).c(localTopicInfo.bytes_topic_cover_url.get().toStringUtf8()).d(localTopicInfo.bytes_topic_url.get().toStringUtf8()).a());
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     puy
 * JD-Core Version:    0.7.0.1
 */