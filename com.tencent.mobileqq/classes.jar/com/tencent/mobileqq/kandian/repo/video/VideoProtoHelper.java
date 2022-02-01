package com.tencent.mobileqq.kandian.repo.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SimpleChannelInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.BaseVideoArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoData;
import com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ArticleSummary;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ChannelInfo;
import tencent.im.oidb.readinjoy.Readinjoy.ArticleSummary;
import tencent.im.oidb.readinjoy.Readinjoy.ChannelInfo;
import tencent.im.oidb.readinjoy.Readinjoy.VideoData;

public class VideoProtoHelper
{
  public static SimpleChannelInfo a(oidb_cmd0xbed.ChannelInfo paramChannelInfo)
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
  
  public static BaseVideoArticleInfo a(Readinjoy.ArticleSummary paramArticleSummary)
  {
    return WeiShiVideoArticleInfo.mergeFromArticleSummaryPb(paramArticleSummary);
  }
  
  public static VideoData a(Readinjoy.VideoData paramVideoData)
  {
    Object localObject = null;
    if (paramVideoData == null) {
      return null;
    }
    if (paramVideoData.has())
    {
      VideoData localVideoData = new VideoData();
      if (paramVideoData.uint32_busi_type.has()) {
        localVideoData.a = paramVideoData.uint32_busi_type.get();
      }
      if (paramVideoData.uint32_duration.has()) {
        localVideoData.b = paramVideoData.uint32_duration.get();
      }
      if (paramVideoData.uint32_width.has()) {
        localVideoData.c = paramVideoData.uint32_width.get();
      }
      if (paramVideoData.uint32_height.has()) {
        localVideoData.d = paramVideoData.uint32_height.get();
      }
      if (paramVideoData.bytes_vid.has()) {
        localVideoData.e = paramVideoData.bytes_vid.get().toStringUtf8();
      }
      if (paramVideoData.uint32_file_size.has()) {
        localVideoData.f = paramVideoData.uint32_file_size.get();
      }
      localObject = localVideoData;
      if (paramVideoData.bytes_video_url.has())
      {
        localVideoData.g = paramVideoData.bytes_video_url.get().toStringUtf8();
        localObject = localVideoData;
      }
    }
    return localObject;
  }
  
  public static WeiShiVideoArticleInfo a(oidb_cmd0xbed.ArticleSummary paramArticleSummary, int paramInt1, int paramInt2)
  {
    paramArticleSummary = WeiShiVideoArticleInfo.mergeFromCmd0xbedPb(paramArticleSummary);
    if (paramArticleSummary != null)
    {
      if (paramArticleSummary.channelID == 0) {
        paramArticleSummary.channelID = paramInt1;
      }
      if (paramArticleSummary.channelType == 0) {
        paramArticleSummary.channelType = paramInt2;
      }
    }
    return paramArticleSummary;
  }
  
  public static List<WeiShiVideoArticleInfo> a(List<oidb_cmd0xbed.ArticleSummary> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((oidb_cmd0xbed.ArticleSummary)paramList.next(), paramInt1, paramInt2));
      }
      return localArrayList;
    }
    return null;
  }
  
  public static Readinjoy.ArticleSummary a(BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    Readinjoy.ArticleSummary localArticleSummary = new Readinjoy.ArticleSummary();
    for (;;)
    {
      try
      {
        localArticleSummary.uint64_article_id.set(paramBaseVideoArticleInfo.articleID);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.rowkey)) {
          localArticleSummary.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.rowkey));
        }
        localObject = localArticleSummary.uint32_is_ugc;
        if (!paramBaseVideoArticleInfo.isUgc) {
          break label631;
        }
        i = 1;
        ((PBUInt32Field)localObject).set(i);
        localArticleSummary.uint32_uptime.set(paramBaseVideoArticleInfo.uptime);
        localArticleSummary.uint32_feeds_type.set(paramBaseVideoArticleInfo.feedsType);
        localArticleSummary.uint32_video_count.set(paramBaseVideoArticleInfo.videoCount);
        localArticleSummary.uint32_strategy_id.set(paramBaseVideoArticleInfo.strategyID);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.title)) {
          localArticleSummary.bytes_article_title.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.title));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.summary)) {
          localArticleSummary.bytes_article_summary.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.summary));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.articleContentUrl)) {
          localArticleSummary.bytes_article_content_url.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.articleContentUrl));
        }
        localArticleSummary.uint64_time.set(paramBaseVideoArticleInfo.time);
        localArticleSummary.uint32_comment_count.set(paramBaseVideoArticleInfo.commentCount);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.subscribeName)) {
          localArticleSummary.bytes_name.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.subscribeName));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.subscribeIcon)) {
          localArticleSummary.bytes_icon.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.subscribeIcon));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.subscribeID)) {
          localArticleSummary.bytes_uin.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.subscribeID));
        }
        localArticleSummary.uint64_recommend_time.set(paramBaseVideoArticleInfo.recommendTime);
        localArticleSummary.uint64_recommend_seq.set(paramBaseVideoArticleInfo.recommendSeq);
        localArticleSummary.uint64_algorithm_id.set(paramBaseVideoArticleInfo.algorithmID);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.recommendReason)) {
          localArticleSummary.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.recommendReason));
        }
        if (paramBaseVideoArticleInfo.videoData != null) {
          localArticleSummary.msg_video_data.set(a(paramBaseVideoArticleInfo.videoData));
        }
        localObject = new Readinjoy.ChannelInfo();
        ((Readinjoy.ChannelInfo)localObject).uint32_channel_id.set(paramBaseVideoArticleInfo.channelID);
        ((Readinjoy.ChannelInfo)localObject).uint32_channel_type.set(paramBaseVideoArticleInfo.channelType);
        localArticleSummary.msg_channel_info.set((MessageMicro)localObject);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.pushContext)) {
          localArticleSummary.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.pushContext));
        }
        localArticleSummary.uint32_play_count.set(paramBaseVideoArticleInfo.videoPlayCount);
        localArticleSummary.uint32_ads_jump_type.set(paramBaseVideoArticleInfo.adsJumpType);
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.adsJumpUrl)) {
          localArticleSummary.bytes_ads_jump_url.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.adsJumpUrl));
        }
        if (!TextUtils.isEmpty(paramBaseVideoArticleInfo.videoReportInfo)) {
          localArticleSummary.bytes_video_report_info.set(ByteStringMicro.copyFromUtf8(paramBaseVideoArticleInfo.videoReportInfo));
        }
        localArticleSummary.uint32_article_style.set(paramBaseVideoArticleInfo.articleStyle);
        if (paramBaseVideoArticleInfo.businessInfo != null) {
          localArticleSummary.bytes_business_info.set(ByteStringMicro.copyFrom(paramBaseVideoArticleInfo.businessInfo));
        }
        if ((paramBaseVideoArticleInfo instanceof WeiShiVideoArticleInfo))
        {
          if (!TextUtils.isEmpty(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptTxt)) {
            localArticleSummary.bytes_video_subscript_txt.set(ByteStringMicro.copyFromUtf8(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptTxt));
          }
          if (!TextUtils.isEmpty(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptColor))
          {
            localArticleSummary.bytes_video_subscript_color.set(ByteStringMicro.copyFromUtf8(((WeiShiVideoArticleInfo)paramBaseVideoArticleInfo).videoSubscriptColor));
            return localArticleSummary;
          }
        }
      }
      catch (Throwable paramBaseVideoArticleInfo)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("videoArticleinfoCovert2LocalPB error:");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramBaseVideoArticleInfo));
          QLog.e("VideoProtoHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      return localArticleSummary;
      label631:
      int i = 0;
    }
  }
  
  public static Readinjoy.VideoData a(VideoData paramVideoData)
  {
    if (paramVideoData == null) {
      return null;
    }
    Readinjoy.VideoData localVideoData = new Readinjoy.VideoData();
    localVideoData.uint32_busi_type.set(paramVideoData.a);
    localVideoData.uint32_duration.set(paramVideoData.b);
    localVideoData.uint32_width.set(paramVideoData.c);
    localVideoData.uint32_height.set(paramVideoData.d);
    if (!TextUtils.isEmpty(paramVideoData.e)) {
      localVideoData.bytes_vid.set(ByteStringMicro.copyFromUtf8(paramVideoData.e));
    }
    localVideoData.uint32_file_size.set(paramVideoData.f);
    if (!TextUtils.isEmpty(paramVideoData.g)) {
      localVideoData.bytes_video_url.set(ByteStringMicro.copyFromUtf8(paramVideoData.g));
    }
    return localVideoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoProtoHelper
 * JD-Core Version:    0.7.0.1
 */