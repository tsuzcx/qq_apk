import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SimpleChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import localpb.readinjoy.Readinjoy.ArticleSummary;
import localpb.readinjoy.Readinjoy.ChannelInfo;
import localpb.readinjoy.Readinjoy.VideoData;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ArticleSummary;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ChannelInfo;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.VideoData;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/struct/WeiShiVideoArticleInfo$Companion;", "", "()V", "TABLE_NAME", "", "mergeArticleList", "", "summary", "Ltencent/im/oidb/cmd0xbed/oidb_cmd0xbed$ArticleSummary;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/WeiShiVideoArticleInfo;", "mergeChannelInfo", "Llocalpb/readinjoy/Readinjoy$ArticleSummary;", "mergeFromArticleSummaryPb", "mergeFromCmd0xbedPb", "mergeLabelList", "mergeVideoData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class rss
{
  private final void a(Readinjoy.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.msg_video_data.has())
    {
      Readinjoy.VideoData localVideoData = paramArticleSummary.msg_video_data;
      paramArticleSummary = new rsp();
      paramWeiShiVideoArticleInfo.videoData = paramArticleSummary;
      paramArticleSummary.jdField_a_of_type_Int = localVideoData.uint32_busi_type.get();
      paramArticleSummary.jdField_b_of_type_Int = localVideoData.uint32_duration.get();
      paramArticleSummary.c = localVideoData.uint32_width.get();
      paramArticleSummary.d = localVideoData.uint32_height.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_vid;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_vid");
      paramArticleSummary.jdField_a_of_type_JavaLangString = qdv.a(paramWeiShiVideoArticleInfo);
      paramArticleSummary.e = localVideoData.uint32_file_size.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_video_url;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_video_url");
      paramArticleSummary.jdField_b_of_type_JavaLangString = qdv.a(paramWeiShiVideoArticleInfo);
    }
  }
  
  private final void a(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.rpt_article_list.has())
    {
      paramWeiShiVideoArticleInfo.articleList = ((List)new ArrayList());
      Object localObject = paramArticleSummary.rpt_article_list.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.rpt_article_list.get()");
      int m = ((Collection)localObject).size();
      int i = 0;
      if (i < m)
      {
        localObject = (oidb_cmd0xbed.ArticleSummary)((oidb_cmd0xbed.ArticleSummary)paramArticleSummary.rpt_article_list.get(i)).get();
        SimpleChannelInfo localSimpleChannelInfo = spy.a(paramArticleSummary.msg_channel_info);
        int j;
        if (localSimpleChannelInfo != null)
        {
          j = (int)localSimpleChannelInfo.b;
          label101:
          if (localSimpleChannelInfo == null) {
            break label158;
          }
        }
        label158:
        for (int k = (int)localSimpleChannelInfo.a;; k = 0)
        {
          localObject = (BaseVideoArticleInfo)spy.a((oidb_cmd0xbed.ArticleSummary)localObject, j, k);
          if (localObject != null) {
            paramWeiShiVideoArticleInfo.articleList.add(localObject);
          }
          i += 1;
          break;
          j = 0;
          break label101;
        }
      }
    }
  }
  
  private final void b(Readinjoy.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if ((paramArticleSummary.msg_channel_info.has()) && (paramArticleSummary.msg_channel_info.get() != null))
    {
      paramWeiShiVideoArticleInfo.channelID = paramArticleSummary.msg_channel_info.uint32_channel_id.get();
      paramWeiShiVideoArticleInfo.channelType = paramArticleSummary.msg_channel_info.uint32_channel_type.get();
    }
  }
  
  private final void b(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.rpt_label_list.has())
    {
      paramWeiShiVideoArticleInfo.labelList = ((List)new ArrayList());
      paramArticleSummary = paramArticleSummary.rpt_label_list.get().iterator();
      while (paramArticleSummary.hasNext())
      {
        SimpleChannelInfo localSimpleChannelInfo = spy.a((oidb_cmd0xbed.ChannelInfo)paramArticleSummary.next());
        if (localSimpleChannelInfo != null) {
          paramWeiShiVideoArticleInfo.labelList.add(localSimpleChannelInfo);
        }
      }
    }
  }
  
  private final void c(Readinjoy.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.rpt_label_list.has())
    {
      paramWeiShiVideoArticleInfo.labelList = ((List)new ArrayList());
      paramArticleSummary = paramArticleSummary.rpt_label_list.get().iterator();
      while (paramArticleSummary.hasNext())
      {
        Readinjoy.ChannelInfo localChannelInfo = (Readinjoy.ChannelInfo)paramArticleSummary.next();
        paramWeiShiVideoArticleInfo.labelList.add(spy.a(localChannelInfo));
      }
    }
  }
  
  private final void c(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if ((paramArticleSummary.msg_channel_info.has()) && (paramArticleSummary.msg_channel_info.get() != null))
    {
      paramWeiShiVideoArticleInfo.channelID = paramArticleSummary.msg_channel_info.uint32_channel_id.get();
      paramWeiShiVideoArticleInfo.channelType = paramArticleSummary.msg_channel_info.uint32_channel_type.get();
    }
  }
  
  private final void d(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.msg_video_data.has())
    {
      oidb_cmd0xbed.VideoData localVideoData = paramArticleSummary.msg_video_data;
      paramArticleSummary = new rsp();
      paramWeiShiVideoArticleInfo.videoData = paramArticleSummary;
      paramArticleSummary.jdField_a_of_type_Int = localVideoData.uint32_busi_type.get();
      paramArticleSummary.jdField_b_of_type_Int = localVideoData.uint32_duration.get();
      paramArticleSummary.c = localVideoData.uint32_width.get();
      paramArticleSummary.d = localVideoData.uint32_height.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_vid;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_vid");
      paramArticleSummary.jdField_a_of_type_JavaLangString = qdv.a(paramWeiShiVideoArticleInfo);
      paramArticleSummary.e = localVideoData.uint32_file_size.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_video_url;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_video_url");
      paramArticleSummary.jdField_b_of_type_JavaLangString = qdv.a(paramWeiShiVideoArticleInfo);
    }
  }
  
  @JvmStatic
  @Nullable
  public final WeiShiVideoArticleInfo a(@Nullable Readinjoy.ArticleSummary paramArticleSummary)
  {
    boolean bool = true;
    if (paramArticleSummary == null) {
      return null;
    }
    try
    {
      WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = new WeiShiVideoArticleInfo();
      localWeiShiVideoArticleInfo.articleID = paramArticleSummary.uint64_article_id.get();
      PBBytesField localPBBytesField = paramArticleSummary.bytes_rowkey;
      Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_rowkey");
      localWeiShiVideoArticleInfo.rowkey = qdv.a(localPBBytesField);
      if (paramArticleSummary.uint32_is_ugc.get() == 1) {}
      for (;;)
      {
        localWeiShiVideoArticleInfo.isUgc = bool;
        localWeiShiVideoArticleInfo.uptime = paramArticleSummary.uint32_uptime.get();
        localWeiShiVideoArticleInfo.feedsType = paramArticleSummary.uint32_feeds_type.get();
        localWeiShiVideoArticleInfo.videoCount = paramArticleSummary.uint32_video_count.get();
        localWeiShiVideoArticleInfo.strategyID = paramArticleSummary.uint32_strategy_id.get();
        localPBBytesField = paramArticleSummary.bytes_article_title;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_title");
        localWeiShiVideoArticleInfo.title = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_article_summary;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_summary");
        localWeiShiVideoArticleInfo.summary = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_first_page_pic_url;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_first_page_pic_url");
        localWeiShiVideoArticleInfo.pagePicUrl = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_article_content_url;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_content_url");
        localWeiShiVideoArticleInfo.articleContentUrl = qdv.a(localPBBytesField);
        localWeiShiVideoArticleInfo.time = paramArticleSummary.uint64_time.get();
        localWeiShiVideoArticleInfo.commentCount = paramArticleSummary.uint32_comment_count.get();
        localPBBytesField = paramArticleSummary.bytes_name;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_name");
        localWeiShiVideoArticleInfo.subscribeName = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_icon;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_icon");
        localWeiShiVideoArticleInfo.subscribeIcon = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_uin;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_uin");
        localWeiShiVideoArticleInfo.subscribeID = qdv.a(localPBBytesField);
        localWeiShiVideoArticleInfo.recommendTime = paramArticleSummary.uint64_recommend_time.get();
        localWeiShiVideoArticleInfo.recommendSeq = paramArticleSummary.uint64_recommend_seq.get();
        localWeiShiVideoArticleInfo.algorithmID = paramArticleSummary.uint64_algorithm_id.get();
        localPBBytesField = paramArticleSummary.bytes_recommend_reason;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_recommend_reason");
        localWeiShiVideoArticleInfo.recommendReason = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_push_context;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_push_context");
        localWeiShiVideoArticleInfo.pushContext = qdv.a(localPBBytesField);
        localWeiShiVideoArticleInfo.videoPlayCount = paramArticleSummary.uint32_play_count.get();
        localWeiShiVideoArticleInfo.adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
        localPBBytesField = paramArticleSummary.bytes_ads_jump_url;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_ads_jump_url");
        localWeiShiVideoArticleInfo.adsJumpUrl = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_video_report_info;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_report_info");
        localWeiShiVideoArticleInfo.videoReportInfo = qdv.a(localPBBytesField);
        localWeiShiVideoArticleInfo.articleStyle = paramArticleSummary.uint32_article_style.get();
        localPBBytesField = paramArticleSummary.bytes_business_info;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_business_info");
        localWeiShiVideoArticleInfo.businessInfo = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_video_subscript_txt;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_subscript_txt");
        localWeiShiVideoArticleInfo.videoSubscriptTxt = qdv.a(localPBBytesField);
        localPBBytesField = paramArticleSummary.bytes_video_subscript_color;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_subscript_color");
        localWeiShiVideoArticleInfo.videoSubscriptColor = qdv.a(localPBBytesField);
        ((rss)this).c(paramArticleSummary, localWeiShiVideoArticleInfo);
        ((rss)this).b(paramArticleSummary, localWeiShiVideoArticleInfo);
        ((rss)this).a(paramArticleSummary, localWeiShiVideoArticleInfo);
        return localWeiShiVideoArticleInfo;
        bool = false;
      }
      return null;
    }
    catch (Throwable paramArticleSummary)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoProtoHelper", 0, "cmd0xbedToWeiShiVideoArticleInfo error:" + paramArticleSummary);
      }
    }
  }
  
  @JvmStatic
  @Nullable
  public final WeiShiVideoArticleInfo a(@Nullable oidb_cmd0xbed.ArticleSummary paramArticleSummary)
  {
    boolean bool = true;
    if (paramArticleSummary != null)
    {
      WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = new WeiShiVideoArticleInfo();
      for (;;)
      {
        try
        {
          localWeiShiVideoArticleInfo.articleID = paramArticleSummary.uint64_article_id.get();
          PBBytesField localPBBytesField = paramArticleSummary.bytes_rowkey;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_rowkey");
          localWeiShiVideoArticleInfo.rowkey = qdv.a(localPBBytesField);
          if (paramArticleSummary.uint32_is_ugc.get() != 1) {
            continue;
          }
          localWeiShiVideoArticleInfo.isUgc = bool;
          localWeiShiVideoArticleInfo.uptime = paramArticleSummary.uint32_uptime.get();
          localWeiShiVideoArticleInfo.feedsType = paramArticleSummary.uint32_feeds_type.get();
          localWeiShiVideoArticleInfo.videoCount = paramArticleSummary.uint32_video_count.get();
          localWeiShiVideoArticleInfo.strategyID = paramArticleSummary.uint32_strategy_id.get();
          localPBBytesField = paramArticleSummary.bytes_article_title;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_title");
          localWeiShiVideoArticleInfo.title = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_article_summary;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_summary");
          localWeiShiVideoArticleInfo.summary = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_first_page_pic_url;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_first_page_pic_url");
          localWeiShiVideoArticleInfo.pagePicUrl = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_article_content_url;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_content_url");
          localWeiShiVideoArticleInfo.articleContentUrl = qdv.a(localPBBytesField);
          localWeiShiVideoArticleInfo.time = paramArticleSummary.uint64_time.get();
          localWeiShiVideoArticleInfo.commentCount = paramArticleSummary.uint32_comment_count.get();
          localPBBytesField = paramArticleSummary.bytes_name;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_name");
          localWeiShiVideoArticleInfo.subscribeName = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_icon;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_icon");
          localWeiShiVideoArticleInfo.subscribeIcon = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_uin;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_uin");
          localWeiShiVideoArticleInfo.subscribeID = qdv.a(localPBBytesField);
          localWeiShiVideoArticleInfo.recommendTime = paramArticleSummary.uint64_recommend_time.get();
          localWeiShiVideoArticleInfo.recommendSeq = paramArticleSummary.uint64_recommend_seq.get();
          localWeiShiVideoArticleInfo.algorithmID = paramArticleSummary.uint64_algorithm_id.get();
          localPBBytesField = paramArticleSummary.bytes_recommend_reason;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_recommend_reason");
          localWeiShiVideoArticleInfo.recommendReason = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_push_context;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_push_context");
          localWeiShiVideoArticleInfo.pushContext = qdv.a(localPBBytesField);
          localWeiShiVideoArticleInfo.videoPlayCount = paramArticleSummary.uint32_play_count.get();
          localWeiShiVideoArticleInfo.adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
          localPBBytesField = paramArticleSummary.bytes_ads_jump_url;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_ads_jump_url");
          localWeiShiVideoArticleInfo.adsJumpUrl = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_video_report_info;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_report_info");
          localWeiShiVideoArticleInfo.videoReportInfo = qdv.a(localPBBytesField);
          localWeiShiVideoArticleInfo.articleStyle = paramArticleSummary.uint32_article_style.get();
          localPBBytesField = paramArticleSummary.bytes_business_info;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_business_info");
          localWeiShiVideoArticleInfo.businessInfo = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_video_subscript_txt;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_subscript_txt");
          localWeiShiVideoArticleInfo.videoSubscriptTxt = qdv.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_video_subscript_color;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_subscript_color");
          localWeiShiVideoArticleInfo.videoSubscriptColor = qdv.a(localPBBytesField);
          ((rss)this).d(paramArticleSummary, localWeiShiVideoArticleInfo);
          ((rss)this).c(paramArticleSummary, localWeiShiVideoArticleInfo);
          ((rss)this).b(paramArticleSummary, localWeiShiVideoArticleInfo);
          ((rss)this).a(paramArticleSummary, localWeiShiVideoArticleInfo);
        }
        catch (Throwable paramArticleSummary)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VideoProtoHelper", 0, "cmd0xbedToWeiShiVideoArticleInfo error:" + pqu.a(paramArticleSummary));
          continue;
        }
        return localWeiShiVideoArticleInfo;
        bool = false;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rss
 * JD-Core Version:    0.7.0.1
 */