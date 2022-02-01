package com.tencent.mobileqq.kandian.repo.video.entity;

import com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SimpleChannelInfo;
import com.tencent.mobileqq.kandian.repo.video.VideoProtoHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ArticleSummary;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ChannelInfo;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.VideoData;
import tencent.im.oidb.readinjoy.Readinjoy.ArticleSummary;
import tencent.im.oidb.readinjoy.Readinjoy.ChannelInfo;
import tencent.im.oidb.readinjoy.Readinjoy.VideoData;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/video/entity/WeiShiVideoArticleInfo$Companion;", "", "()V", "TABLE_NAME", "", "mergeArticleList", "", "summary", "Ltencent/im/oidb/cmd0xbed/oidb_cmd0xbed$ArticleSummary;", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/video/entity/WeiShiVideoArticleInfo;", "mergeChannelInfo", "Ltencent/im/oidb/readinjoy/Readinjoy$ArticleSummary;", "mergeFromArticleSummaryPb", "mergeFromCmd0xbedPb", "mergeLabelList", "mergeVideoData", "toSimpleChannelInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/SimpleChannelInfo;", "serverChannelInfo", "Ltencent/im/oidb/readinjoy/Readinjoy$ChannelInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class WeiShiVideoArticleInfo$Companion
{
  private final void a(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.rpt_article_list.has())
    {
      paramWeiShiVideoArticleInfo.articleList = ((List)new ArrayList());
      Object localObject = paramArticleSummary.rpt_article_list.get();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.rpt_article_list.get()");
      int m = ((Collection)localObject).size();
      int i = 0;
      while (i < m)
      {
        localObject = (oidb_cmd0xbed.ArticleSummary)((oidb_cmd0xbed.ArticleSummary)paramArticleSummary.rpt_article_list.get(i)).get();
        SimpleChannelInfo localSimpleChannelInfo = VideoProtoHelper.a(paramArticleSummary.msg_channel_info);
        int j;
        if (localSimpleChannelInfo != null) {
          j = (int)localSimpleChannelInfo.c;
        } else {
          j = 0;
        }
        int k;
        if (localSimpleChannelInfo != null) {
          k = (int)localSimpleChannelInfo.b;
        } else {
          k = 0;
        }
        localObject = (BaseVideoArticleInfo)VideoProtoHelper.a((oidb_cmd0xbed.ArticleSummary)localObject, j, k);
        if (localObject != null) {
          paramWeiShiVideoArticleInfo.articleList.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  private final void a(Readinjoy.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.msg_video_data.has())
    {
      Readinjoy.VideoData localVideoData = paramArticleSummary.msg_video_data;
      paramArticleSummary = new VideoData();
      paramWeiShiVideoArticleInfo.videoData = paramArticleSummary;
      paramArticleSummary.a = localVideoData.uint32_busi_type.get();
      paramArticleSummary.b = localVideoData.uint32_duration.get();
      paramArticleSummary.c = localVideoData.uint32_width.get();
      paramArticleSummary.d = localVideoData.uint32_height.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_vid;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_vid");
      paramArticleSummary.e = PBFieldUtils.a(paramWeiShiVideoArticleInfo);
      paramArticleSummary.f = localVideoData.uint32_file_size.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_video_url;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_video_url");
      paramArticleSummary.g = PBFieldUtils.a(paramWeiShiVideoArticleInfo);
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
        SimpleChannelInfo localSimpleChannelInfo = VideoProtoHelper.a((oidb_cmd0xbed.ChannelInfo)paramArticleSummary.next());
        if (localSimpleChannelInfo != null) {
          paramWeiShiVideoArticleInfo.labelList.add(localSimpleChannelInfo);
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
  
  private final void c(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if ((paramArticleSummary.msg_channel_info.has()) && (paramArticleSummary.msg_channel_info.get() != null))
    {
      paramWeiShiVideoArticleInfo.channelID = paramArticleSummary.msg_channel_info.uint32_channel_id.get();
      paramWeiShiVideoArticleInfo.channelType = paramArticleSummary.msg_channel_info.uint32_channel_type.get();
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
        paramWeiShiVideoArticleInfo.labelList.add(((Companion)this).a(localChannelInfo));
      }
    }
  }
  
  private final void d(oidb_cmd0xbed.ArticleSummary paramArticleSummary, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    if (paramArticleSummary.msg_video_data.has())
    {
      oidb_cmd0xbed.VideoData localVideoData = paramArticleSummary.msg_video_data;
      paramArticleSummary = new VideoData();
      paramWeiShiVideoArticleInfo.videoData = paramArticleSummary;
      paramArticleSummary.a = localVideoData.uint32_busi_type.get();
      paramArticleSummary.b = localVideoData.uint32_duration.get();
      paramArticleSummary.c = localVideoData.uint32_width.get();
      paramArticleSummary.d = localVideoData.uint32_height.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_vid;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_vid");
      paramArticleSummary.e = PBFieldUtils.a(paramWeiShiVideoArticleInfo);
      paramArticleSummary.f = localVideoData.uint32_file_size.get();
      paramWeiShiVideoArticleInfo = localVideoData.bytes_video_url;
      Intrinsics.checkExpressionValueIsNotNull(paramWeiShiVideoArticleInfo, "serverVideoData.bytes_video_url");
      paramArticleSummary.g = PBFieldUtils.a(paramWeiShiVideoArticleInfo);
    }
  }
  
  @Nullable
  public final SimpleChannelInfo a(@Nullable Readinjoy.ChannelInfo paramChannelInfo)
  {
    SimpleChannelInfo localSimpleChannelInfo = new SimpleChannelInfo();
    if ((paramChannelInfo != null) && (paramChannelInfo.has()))
    {
      if (paramChannelInfo.bytes_channel_name.has()) {
        localSimpleChannelInfo.a = paramChannelInfo.bytes_channel_name.get().toStringUtf8();
      }
      if (paramChannelInfo.uint32_channel_type.has()) {
        localSimpleChannelInfo.b = paramChannelInfo.uint32_channel_type.get();
      }
      if (paramChannelInfo.uint32_channel_id.has()) {
        localSimpleChannelInfo.c = paramChannelInfo.uint32_channel_id.get();
      }
    }
    return localSimpleChannelInfo;
  }
  
  @JvmStatic
  @Nullable
  public final WeiShiVideoArticleInfo a(@Nullable oidb_cmd0xbed.ArticleSummary paramArticleSummary)
  {
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    if (paramArticleSummary != null) {
      localWeiShiVideoArticleInfo = new WeiShiVideoArticleInfo();
    }
    for (;;)
    {
      try
      {
        localWeiShiVideoArticleInfo.articleID = paramArticleSummary.uint64_article_id.get();
        localObject = paramArticleSummary.bytes_rowkey;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_rowkey");
        localWeiShiVideoArticleInfo.rowkey = PBFieldUtils.a((PBBytesField)localObject);
        int i = paramArticleSummary.uint32_is_ugc.get();
        bool = true;
        if (i != 1) {
          break label648;
        }
        localWeiShiVideoArticleInfo.isUgc = bool;
        localWeiShiVideoArticleInfo.uptime = paramArticleSummary.uint32_uptime.get();
        localWeiShiVideoArticleInfo.feedsType = paramArticleSummary.uint32_feeds_type.get();
        localWeiShiVideoArticleInfo.videoCount = paramArticleSummary.uint32_video_count.get();
        localWeiShiVideoArticleInfo.strategyID = paramArticleSummary.uint32_strategy_id.get();
        localObject = paramArticleSummary.bytes_article_title;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_article_title");
        localWeiShiVideoArticleInfo.title = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_article_summary;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_article_summary");
        localWeiShiVideoArticleInfo.summary = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_first_page_pic_url;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_first_page_pic_url");
        localWeiShiVideoArticleInfo.pagePicUrl = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_article_content_url;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_article_content_url");
        localWeiShiVideoArticleInfo.articleContentUrl = PBFieldUtils.a((PBBytesField)localObject);
        localWeiShiVideoArticleInfo.time = paramArticleSummary.uint64_time.get();
        localWeiShiVideoArticleInfo.commentCount = paramArticleSummary.uint32_comment_count.get();
        localObject = paramArticleSummary.bytes_name;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_name");
        localWeiShiVideoArticleInfo.subscribeName = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_icon;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_icon");
        localWeiShiVideoArticleInfo.subscribeIcon = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_uin;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_uin");
        localWeiShiVideoArticleInfo.subscribeID = PBFieldUtils.a((PBBytesField)localObject);
        localWeiShiVideoArticleInfo.recommendTime = paramArticleSummary.uint64_recommend_time.get();
        localWeiShiVideoArticleInfo.recommendSeq = paramArticleSummary.uint64_recommend_seq.get();
        localWeiShiVideoArticleInfo.algorithmID = paramArticleSummary.uint64_algorithm_id.get();
        localObject = paramArticleSummary.bytes_recommend_reason;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_recommend_reason");
        localWeiShiVideoArticleInfo.recommendReason = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_push_context;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_push_context");
        localWeiShiVideoArticleInfo.pushContext = PBFieldUtils.a((PBBytesField)localObject);
        localWeiShiVideoArticleInfo.videoPlayCount = paramArticleSummary.uint32_play_count.get();
        localWeiShiVideoArticleInfo.adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
        localObject = paramArticleSummary.bytes_ads_jump_url;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_ads_jump_url");
        localWeiShiVideoArticleInfo.adsJumpUrl = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_video_report_info;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_video_report_info");
        localWeiShiVideoArticleInfo.videoReportInfo = PBFieldUtils.a((PBBytesField)localObject);
        localWeiShiVideoArticleInfo.articleStyle = paramArticleSummary.uint32_article_style.get();
        localObject = paramArticleSummary.bytes_business_info;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_business_info");
        localWeiShiVideoArticleInfo.businessInfo = PBFieldUtils.b((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_video_subscript_txt;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_video_subscript_txt");
        localWeiShiVideoArticleInfo.videoSubscriptTxt = PBFieldUtils.a((PBBytesField)localObject);
        localObject = paramArticleSummary.bytes_video_subscript_color;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "summary.bytes_video_subscript_color");
        localWeiShiVideoArticleInfo.videoSubscriptColor = PBFieldUtils.a((PBBytesField)localObject);
        ((Companion)this).d(paramArticleSummary, localWeiShiVideoArticleInfo);
        ((Companion)this).c(paramArticleSummary, localWeiShiVideoArticleInfo);
        ((Companion)this).b(paramArticleSummary, localWeiShiVideoArticleInfo);
        ((Companion)this).a(paramArticleSummary, localWeiShiVideoArticleInfo);
        return localWeiShiVideoArticleInfo;
      }
      catch (Throwable paramArticleSummary)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd0xbedToWeiShiVideoArticleInfo error:");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramArticleSummary));
          QLog.e("VideoProtoHelper", 2, ((StringBuilder)localObject).toString());
        }
        return localWeiShiVideoArticleInfo;
      }
      return null;
      label648:
      boolean bool = false;
    }
  }
  
  @JvmStatic
  @Nullable
  public final WeiShiVideoArticleInfo a(@Nullable Readinjoy.ArticleSummary paramArticleSummary)
  {
    if (paramArticleSummary == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new WeiShiVideoArticleInfo();
        ((WeiShiVideoArticleInfo)localObject).articleID = paramArticleSummary.uint64_article_id.get();
        PBBytesField localPBBytesField = paramArticleSummary.bytes_rowkey;
        Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_rowkey");
        ((WeiShiVideoArticleInfo)localObject).rowkey = PBFieldUtils.a(localPBBytesField);
        int i = paramArticleSummary.uint32_is_ugc.get();
        bool = true;
        if (i == 1)
        {
          ((WeiShiVideoArticleInfo)localObject).isUgc = bool;
          ((WeiShiVideoArticleInfo)localObject).uptime = paramArticleSummary.uint32_uptime.get();
          ((WeiShiVideoArticleInfo)localObject).feedsType = paramArticleSummary.uint32_feeds_type.get();
          ((WeiShiVideoArticleInfo)localObject).videoCount = paramArticleSummary.uint32_video_count.get();
          ((WeiShiVideoArticleInfo)localObject).strategyID = paramArticleSummary.uint32_strategy_id.get();
          localPBBytesField = paramArticleSummary.bytes_article_title;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_title");
          ((WeiShiVideoArticleInfo)localObject).title = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_article_summary;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_summary");
          ((WeiShiVideoArticleInfo)localObject).summary = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_first_page_pic_url;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_first_page_pic_url");
          ((WeiShiVideoArticleInfo)localObject).pagePicUrl = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_article_content_url;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_article_content_url");
          ((WeiShiVideoArticleInfo)localObject).articleContentUrl = PBFieldUtils.a(localPBBytesField);
          ((WeiShiVideoArticleInfo)localObject).time = paramArticleSummary.uint64_time.get();
          ((WeiShiVideoArticleInfo)localObject).commentCount = paramArticleSummary.uint32_comment_count.get();
          localPBBytesField = paramArticleSummary.bytes_name;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_name");
          ((WeiShiVideoArticleInfo)localObject).subscribeName = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_icon;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_icon");
          ((WeiShiVideoArticleInfo)localObject).subscribeIcon = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_uin;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_uin");
          ((WeiShiVideoArticleInfo)localObject).subscribeID = PBFieldUtils.a(localPBBytesField);
          ((WeiShiVideoArticleInfo)localObject).recommendTime = paramArticleSummary.uint64_recommend_time.get();
          ((WeiShiVideoArticleInfo)localObject).recommendSeq = paramArticleSummary.uint64_recommend_seq.get();
          ((WeiShiVideoArticleInfo)localObject).algorithmID = paramArticleSummary.uint64_algorithm_id.get();
          localPBBytesField = paramArticleSummary.bytes_recommend_reason;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_recommend_reason");
          ((WeiShiVideoArticleInfo)localObject).recommendReason = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_push_context;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_push_context");
          ((WeiShiVideoArticleInfo)localObject).pushContext = PBFieldUtils.a(localPBBytesField);
          ((WeiShiVideoArticleInfo)localObject).videoPlayCount = paramArticleSummary.uint32_play_count.get();
          ((WeiShiVideoArticleInfo)localObject).adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
          localPBBytesField = paramArticleSummary.bytes_ads_jump_url;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_ads_jump_url");
          ((WeiShiVideoArticleInfo)localObject).adsJumpUrl = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_video_report_info;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_report_info");
          ((WeiShiVideoArticleInfo)localObject).videoReportInfo = PBFieldUtils.a(localPBBytesField);
          ((WeiShiVideoArticleInfo)localObject).articleStyle = paramArticleSummary.uint32_article_style.get();
          localPBBytesField = paramArticleSummary.bytes_business_info;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_business_info");
          ((WeiShiVideoArticleInfo)localObject).businessInfo = PBFieldUtils.b(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_video_subscript_txt;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_subscript_txt");
          ((WeiShiVideoArticleInfo)localObject).videoSubscriptTxt = PBFieldUtils.a(localPBBytesField);
          localPBBytesField = paramArticleSummary.bytes_video_subscript_color;
          Intrinsics.checkExpressionValueIsNotNull(localPBBytesField, "summary.bytes_video_subscript_color");
          ((WeiShiVideoArticleInfo)localObject).videoSubscriptColor = PBFieldUtils.a(localPBBytesField);
          ((Companion)this).c(paramArticleSummary, (WeiShiVideoArticleInfo)localObject);
          ((Companion)this).b(paramArticleSummary, (WeiShiVideoArticleInfo)localObject);
          ((Companion)this).a(paramArticleSummary, (WeiShiVideoArticleInfo)localObject);
          return localObject;
        }
      }
      catch (Throwable paramArticleSummary)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd0xbedToWeiShiVideoArticleInfo error:");
          ((StringBuilder)localObject).append(paramArticleSummary);
          QLog.e("VideoProtoHelper", 2, ((StringBuilder)localObject).toString());
        }
        return null;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo.Companion
 * JD-Core Version:    0.7.0.1
 */