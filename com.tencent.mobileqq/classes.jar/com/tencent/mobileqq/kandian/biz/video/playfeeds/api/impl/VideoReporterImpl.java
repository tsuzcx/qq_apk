package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/VideoReporterImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoReporter;", "()V", "addJump2ChannelAndVieoSessionID2R5", "", "jump2ChannelValue", "", "videoSessionId", "r5JsonStr", "addKanDianTagForWeishiReport", "Lorg/json/JSONObject;", "r5", "companyId", "getKandianModel4Report", "getReportVideoType", "busiType", "sourceName", "getUinMemberNum", "app", "Lcom/tencent/common/app/AppInterface;", "uin", "uinType", "getVideoSessionId", "key", "", "reportClickEvent", "", "cmd", "videoAioUinType", "videoBizSource", "vid", "r4", "reportVideoStructMsgRecv", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportVideoStructMsgSendSuc", "msgType", "peerUin", "uniseq", "", "reportVideoUserOperationByOidbOfFeed", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelID", "operation", "timeLength", "videoExtraRepoerData", "Lcom/tencent/mobileqq/kandian/repo/report/ReportInfo$VideoExtraRepoerData;", "reportVideoUserOperationByOidbOfVideoFeeds", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "firstVideoRowkey", "videoReportBaseR5", "md5", "puin", "aid", "extR5", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoReporterImpl
  implements IVideoReporter
{
  @Nullable
  public String addJump2ChannelAndVieoSessionID2R5(int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    return VideoReporter.a(paramInt, paramString1, paramString2);
  }
  
  @Nullable
  public JSONObject addKanDianTagForWeishiReport(@Nullable JSONObject paramJSONObject, int paramInt)
  {
    return VideoReporter.a(paramJSONObject, paramInt);
  }
  
  public int getKandianModel4Report()
  {
    return VideoReporter.c();
  }
  
  public int getReportVideoType(int paramInt, @Nullable String paramString)
  {
    return VideoReporter.a(paramInt, paramString);
  }
  
  public int getUinMemberNum(@Nullable AppInterface paramAppInterface, @Nullable String paramString, int paramInt)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return VideoReporter.a((QQAppInterface)paramAppInterface, paramString, paramInt);
    }
    return 0;
  }
  
  @Nullable
  public String getVideoSessionId(@NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "key");
    HashMap localHashMap = VideoReporter.c;
    Intrinsics.checkExpressionValueIsNotNull(localHashMap, "VideoReporter.sVideoSessionMap");
    return (String)((Map)localHashMap).get(paramObject);
  }
  
  public void reportClickEvent(@Nullable String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2, @Nullable String paramString3)
  {
    VideoReporter.a(paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public void reportVideoStructMsgRecv(@Nullable MessageRecord paramMessageRecord)
  {
    VideoReporter.a(paramMessageRecord);
  }
  
  public void reportVideoStructMsgSendSuc(@Nullable AppInterface paramAppInterface, int paramInt1, @Nullable String paramString, int paramInt2, long paramLong)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      VideoReporter.a((QQAppInterface)paramAppInterface, paramInt1, paramString, paramInt2, paramLong);
    }
  }
  
  public void reportVideoUserOperationByOidbOfFeed(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, long paramLong, @Nullable ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData)
  {
    VideoReporter.a(paramAbsBaseArticleInfo, paramInt1, paramInt2, paramLong, paramVideoExtraRepoerData);
  }
  
  public void reportVideoUserOperationByOidbOfVideoFeeds(@Nullable VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, @Nullable ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, @Nullable String paramString)
  {
    VideoReporter.b(paramVideoInfo, paramInt1, paramInt2, paramInt3, paramVideoExtraRepoerData, paramString);
  }
  
  @Nullable
  public String videoReportBaseR5(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable JSONObject paramJSONObject)
  {
    return VideoReporter.a(paramString1, paramString2, paramString3, paramString4, paramJSONObject);
  }
  
  @Nullable
  public String videoReportBaseR5(@Nullable JSONObject paramJSONObject)
  {
    return VideoReporter.b(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl.VideoReporterImpl
 * JD-Core Version:    0.7.0.1
 */