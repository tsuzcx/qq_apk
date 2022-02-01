package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTTVKDataProvider;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity.Builder;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity.Builder;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.AdType;
import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import java.util.HashMap;
import java.util.Map;

public class TVKDataBinder
  implements ITVKDataBinder
{
  public static final String KEY_REPORT_TYPE = "report_type";
  private static final String TAG = "VideoDataBinder";
  public static final String VALUE_REPORT_TYPE_AD = "11";
  public static final String VALUE_REPORT_TYPE_VIDEO = "12";
  private VideoEntity mAdEntity;
  private boolean mAdNeedReportType;
  private final Object mAdPlayer = new Object();
  private final Map<String, Object> mBizParams = new HashMap();
  private final String mFlowId;
  private TVKNetVideoInfo mNetVideoInfo;
  private final Map<String, Object> mOpenParams = new HashMap();
  private final IDTTVKDataProvider mProvider;
  private TVKProperties mReportProperties;
  private long mVideoDuration;
  private VideoEntity mVideoEntity;
  private TVKPlayerVideoInfo mVideoInfo;
  private boolean mVideoNeedReportType;
  private final Object mVideoPlayer = new Object();
  
  public TVKDataBinder(String paramString, IDTTVKDataProvider paramIDTTVKDataProvider)
  {
    this.mFlowId = paramString;
    this.mProvider = paramIDTTVKDataProvider;
  }
  
  private String calculateReportType(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mAdNeedReportType))
    {
      this.mAdNeedReportType = false;
      return "11";
    }
    if ((!paramBoolean) && (this.mVideoNeedReportType))
    {
      this.mVideoNeedReportType = false;
      return "12";
    }
    return "";
  }
  
  private Map<String, Object> getInnerParams(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("report_type", calculateReportType(paramBoolean));
    return localHashMap;
  }
  
  private String getVid()
  {
    Object localObject = this.mVideoInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TVKPlayerVideoInfo)localObject).getVid()))) {
      return this.mVideoInfo.getVid();
    }
    localObject = this.mNetVideoInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((TVKNetVideoInfo)localObject).getVid()))) {
      return this.mNetVideoInfo.getVid();
    }
    return null;
  }
  
  public void onAdPrepared(ITVKPlayerEventListener.AdType paramAdType, long paramLong)
  {
    paramAdType = new StringBuilder();
    paramAdType.append("[VideoPlayReport] onAdPrepare vid=");
    paramAdType.append(getVid());
    paramAdType.append(", flowId=");
    paramAdType.append(this.mFlowId);
    paramAdType.append(", isBizReady=");
    paramAdType.append(this.mProvider.isBizReady(this.mReportProperties));
    paramAdType.append(", adDuration=");
    paramAdType.append(paramLong);
    Log.d("VideoDataBinder", paramAdType.toString());
    if (!this.mProvider.active(this.mVideoInfo)) {
      return;
    }
    paramAdType = this.mProvider.formatStartParams(this.mNetVideoInfo, false);
    this.mAdEntity = new VideoEntity.Builder().bizReady(true).setContentId(this.mProvider.getContentId(this.mVideoInfo)).setContentType(this.mProvider.getContentType(this.mVideoInfo, 1)).setIdentifier(getVid()).setVideoDuration((int)paramLong).addCustomParams(this.mOpenParams).addCustomParams(this.mBizParams).addCustomParams(paramAdType).addCustomParams(getInnerParams(true)).build();
    VideoReport.bindVideoPlayerInfo(this.mAdPlayer, this.mAdEntity);
  }
  
  public void onAdStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] onAdStop vid=");
    localStringBuilder.append(getVid());
    localStringBuilder.append(", flowId=");
    localStringBuilder.append(this.mFlowId);
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(this.mProvider.isBizReady(this.mReportProperties));
    Log.d("VideoDataBinder", localStringBuilder.toString());
    if (!this.mProvider.active(this.mVideoInfo)) {
      return;
    }
    VideoReport.unbindVideoPlayerInfo(this.mAdPlayer);
  }
  
  public void onNetVideoInfo(@NonNull TVKNetVideoInfo paramTVKNetVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] onNetVideoInfo vid=");
    localStringBuilder.append(paramTVKNetVideoInfo.getVid());
    localStringBuilder.append(", flowId=");
    localStringBuilder.append(this.mFlowId);
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(this.mProvider.isBizReady(this.mReportProperties));
    Log.d("VideoDataBinder", localStringBuilder.toString());
    this.mNetVideoInfo = paramTVKNetVideoInfo;
  }
  
  public void onOpenMedia(@NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] onOpenMedia vid=");
    localStringBuilder.append(paramTVKPlayerVideoInfo.getVid());
    localStringBuilder.append(", flowId=");
    localStringBuilder.append(this.mFlowId);
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(this.mProvider.isBizReady(paramTVKPlayerVideoInfo.getReportInfoProperties()));
    Log.d("VideoDataBinder", localStringBuilder.toString());
    this.mVideoInfo = paramTVKPlayerVideoInfo;
    this.mReportProperties = paramTVKPlayerVideoInfo.getReportInfoProperties();
    this.mOpenParams.clear();
    this.mBizParams.clear();
    this.mOpenParams.putAll(this.mProvider.formatOpenParams(paramTVKPlayerVideoInfo, paramString));
    this.mBizParams.putAll(this.mProvider.formatBizParams(this.mReportProperties));
  }
  
  public void onUpdateReportParam(@NonNull TVKProperties paramTVKProperties)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[VideoPlayReport] onUpdateReportParam vid=");
    ((StringBuilder)localObject).append(getVid());
    ((StringBuilder)localObject).append(", flowId=");
    ((StringBuilder)localObject).append(this.mFlowId);
    ((StringBuilder)localObject).append(", isBizReady=");
    ((StringBuilder)localObject).append(this.mProvider.isBizReady(paramTVKProperties));
    Log.d("VideoDataBinder", ((StringBuilder)localObject).toString());
    this.mReportProperties = paramTVKProperties;
    this.mBizParams.putAll(this.mProvider.formatBizParams(paramTVKProperties));
    localObject = this.mVideoEntity;
    if (localObject != null)
    {
      paramTVKProperties = new VideoBaseEntity.Builder((VideoBaseEntity)localObject).bizReady(this.mProvider.isBizReady(paramTVKProperties)).addCustomParams(this.mBizParams).build();
      VideoReport.updateVideoPlayerInfo(this.mVideoPlayer, paramTVKProperties);
    }
    paramTVKProperties = this.mAdEntity;
    if (paramTVKProperties != null)
    {
      paramTVKProperties = new VideoBaseEntity.Builder(paramTVKProperties).bizReady(true).addCustomParams(this.mBizParams).build();
      VideoReport.updateVideoPlayerInfo(this.mAdPlayer, paramTVKProperties);
    }
  }
  
  public void onVideoPlay()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[VideoPlayReport] onVideoPlay vid=");
    ((StringBuilder)localObject).append(getVid());
    ((StringBuilder)localObject).append(", flowId=");
    ((StringBuilder)localObject).append(this.mFlowId);
    ((StringBuilder)localObject).append(", isBizReady=");
    ((StringBuilder)localObject).append(this.mProvider.isBizReady(this.mReportProperties));
    Log.d("VideoDataBinder", ((StringBuilder)localObject).toString());
    if (!this.mProvider.active(this.mVideoInfo)) {
      return;
    }
    localObject = this.mProvider.formatStartParams(this.mNetVideoInfo, false);
    this.mVideoEntity = new VideoEntity.Builder().bizReady(this.mProvider.isBizReady(this.mReportProperties)).setContentId(this.mProvider.getContentId(this.mVideoInfo)).setContentType(this.mProvider.getContentType(this.mVideoInfo, 2)).setIdentifier(getVid()).setVideoDuration((int)this.mVideoDuration).addCustomParams(this.mOpenParams).addCustomParams(this.mBizParams).addCustomParams((Map)localObject).addCustomParams(getInnerParams(false)).build();
    VideoReport.bindVideoPlayerInfo(this.mVideoPlayer, this.mVideoEntity);
  }
  
  public void onVideoPrepared(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] onVideoPrepare vid=");
    localStringBuilder.append(getVid());
    localStringBuilder.append(", flowId=");
    localStringBuilder.append(this.mFlowId);
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(this.mProvider.isBizReady(this.mReportProperties));
    localStringBuilder.append(", videoDuration=");
    localStringBuilder.append(paramLong);
    Log.d("VideoDataBinder", localStringBuilder.toString());
    this.mVideoDuration = paramLong;
  }
  
  public void onVideoStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlayReport] onVideoStop vid=");
    localStringBuilder.append(getVid());
    localStringBuilder.append(", flowId=");
    localStringBuilder.append(this.mFlowId);
    localStringBuilder.append(", isBizReady=");
    localStringBuilder.append(this.mProvider.isBizReady(this.mReportProperties));
    Log.d("VideoDataBinder", localStringBuilder.toString());
    if (!this.mProvider.active(this.mVideoInfo)) {
      return;
    }
    VideoReport.unbindVideoPlayerInfo(this.mVideoPlayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder
 * JD-Core Version:    0.7.0.1
 */