package com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer;

import android.util.Log;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener.AdType;
import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;

public class DefaultTVKDataBinder
  implements ITVKDataBinder
{
  private static final String TAG = "DefaultVideoDataBinder";
  
  public void onAdPrepared(ITVKPlayerEventListener.AdType paramAdType, long paramLong)
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onAdPrepare");
  }
  
  public void onAdStop()
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onAdStop");
  }
  
  public void onNetVideoInfo(TVKNetVideoInfo paramTVKNetVideoInfo)
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onNetVideoInfo");
  }
  
  public void onOpenMedia(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString)
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onOpenMedia");
  }
  
  public void onUpdateReportParam(TVKProperties paramTVKProperties)
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onUpdateReportParam");
  }
  
  public void onVideoPlay()
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onVideoPlay");
  }
  
  public void onVideoPrepared(long paramLong)
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onVideoPrepare");
  }
  
  public void onVideoStop()
  {
    Log.d("DefaultVideoDataBinder", "[VideoPlayReport] onVideoStop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.DefaultTVKDataBinder
 * JD-Core Version:    0.7.0.1
 */