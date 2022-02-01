package com.tencent.qqlive.module.videoreport.dtreport.video.playback;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.api.DTConfig;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;

public class ReportThumbPlayer
{
  private static final String TAG = "ReportThumbPlayer";
  
  private ReportThumbPlayer()
  {
    Log.i("ReportThumbPlayer", "create VideoEventReporter");
  }
  
  public static ReportThumbPlayer getInstance()
  {
    return ReportThumbPlayer.InstanceHolder.access$100();
  }
  
  public void getReportManager(Object paramObject1, Object paramObject2)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer getReportManager");
      VideoReportManager.getInstance().getReportManager(paramObject1, paramObject2);
    }
  }
  
  public void onCompletion(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer onCompletion");
      VideoReportManager.getInstance().onCompletion(paramObject);
    }
  }
  
  public void onError(Object paramObject, int paramInt1, int paramInt2)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer onError");
      VideoReportManager.getInstance().onError(paramObject, paramInt1, paramInt2);
    }
  }
  
  public void onInfo(Object paramObject, int paramInt, long paramLong1, long paramLong2)
  {
    if (DTConfigConstants.config.videoReportSupport()) {
      VideoReportManager.getInstance().onInfo(paramObject, paramInt, paramLong1, paramLong2);
    }
  }
  
  public void onPrepared(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer onPrepared");
      VideoReportManager.getInstance().onPrepared(paramObject);
    }
  }
  
  public void pause(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer pause");
      VideoReportManager.getInstance().pause(paramObject);
    }
  }
  
  public void release(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer release");
      VideoReportManager.getInstance().release(paramObject);
    }
  }
  
  public void reset(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer reset");
      VideoReportManager.getInstance().reset(paramObject);
    }
  }
  
  public void seekTo(Object paramObject, int paramInt)
  {
    if ((DTConfigConstants.config.videoReportSupport()) && (DTConfigConstants.config.seekReportSupport()))
    {
      Log.i("ReportThumbPlayer", "thumbplayer seekTo");
      VideoReportManager.getInstance().seekTo(paramObject, paramInt);
    }
  }
  
  public void setLoopback(Object paramObject, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer setLoopback");
      VideoReportManager.getInstance().setLoopback(paramObject, paramBoolean, paramLong1, paramLong2);
    }
  }
  
  public void setPlaySpeedRatio(Object paramObject, float paramFloat)
  {
    if ((DTConfigConstants.config.videoReportSupport()) && (DTConfigConstants.config.speedRatioReportSupport()))
    {
      Log.i("ReportThumbPlayer", "thumbplayer setPlaySpeedRatio");
      VideoReportManager.getInstance().setPlaySpeedRatio(paramObject, paramFloat);
    }
  }
  
  public void setPlayerOptionalParam(Object paramObject1, Object paramObject2)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer setPlayerOptionalParam");
      VideoReportManager.getInstance().setStartPosition(paramObject1, paramObject2);
    }
  }
  
  public void setReportInfo(Object paramObject1, Object paramObject2)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer setReportInfo");
      VideoReportManager.getInstance().setReportInfo(paramObject1, paramObject2);
    }
  }
  
  public void start(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer start");
      ThreadUtils.runOnUiThread(new ReportThumbPlayer.1(this, paramObject));
    }
  }
  
  public void stop(Object paramObject)
  {
    if (DTConfigConstants.config.videoReportSupport())
    {
      Log.i("ReportThumbPlayer", "thumbplayer stop");
      VideoReportManager.getInstance().stop(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer
 * JD-Core Version:    0.7.0.1
 */