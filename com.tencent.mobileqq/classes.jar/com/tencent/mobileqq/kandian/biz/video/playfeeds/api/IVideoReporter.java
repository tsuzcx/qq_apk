package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo.VideoExtraRepoerData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addJump2ChannelAndVieoSessionID2R5", "", "jump2ChannelValue", "", "videoSessionId", "r5JsonStr", "addKanDianTagForWeishiReport", "Lorg/json/JSONObject;", "r5", "companyId", "getKandianModel4Report", "getReportVideoType", "busiType", "sourceName", "getUinMemberNum", "app", "Lcom/tencent/common/app/AppInterface;", "uin", "uinType", "getVideoSessionId", "key", "", "reportClickEvent", "", "cmd", "videoAioUinType", "videoBizSource", "vid", "r4", "reportVideoStructMsgRecv", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportVideoStructMsgSendSuc", "msgType", "peerUin", "uniseq", "", "reportVideoUserOperationByOidbOfFeed", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "channelID", "operation", "timeLength", "videoExtraRepoerData", "Lcom/tencent/mobileqq/kandian/repo/report/ReportInfo$VideoExtraRepoerData;", "reportVideoUserOperationByOidbOfVideoFeeds", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "firstVideoRowkey", "videoReportBaseR5", "md5", "puin", "aid", "extR5", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoReporter
  extends QRouteApi
{
  @Nullable
  public abstract String addJump2ChannelAndVieoSessionID2R5(int paramInt, @Nullable String paramString1, @Nullable String paramString2);
  
  @Nullable
  public abstract JSONObject addKanDianTagForWeishiReport(@Nullable JSONObject paramJSONObject, int paramInt);
  
  public abstract int getKandianModel4Report();
  
  public abstract int getReportVideoType(int paramInt, @Nullable String paramString);
  
  public abstract int getUinMemberNum(@Nullable AppInterface paramAppInterface, @Nullable String paramString, int paramInt);
  
  @Nullable
  public abstract String getVideoSessionId(@NotNull Object paramObject);
  
  public abstract void reportClickEvent(@Nullable String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract void reportVideoStructMsgRecv(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void reportVideoStructMsgSendSuc(@Nullable AppInterface paramAppInterface, int paramInt1, @Nullable String paramString, int paramInt2, long paramLong);
  
  public abstract void reportVideoUserOperationByOidbOfFeed(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, long paramLong, @Nullable ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData);
  
  public abstract void reportVideoUserOperationByOidbOfVideoFeeds(@Nullable VideoInfo paramVideoInfo, int paramInt1, int paramInt2, int paramInt3, @Nullable ReportInfo.VideoExtraRepoerData paramVideoExtraRepoerData, @Nullable String paramString);
  
  @Nullable
  public abstract String videoReportBaseR5(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable JSONObject paramJSONObject);
  
  @Nullable
  public abstract String videoReportBaseR5(@Nullable JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter
 * JD-Core Version:    0.7.0.1
 */