package com.tencent.mobileqq.kandian.biz.video.playfeeds.api;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsPlayManager;", "", "getCurrentPlayPosition", "", "getPlayingVideoParam", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoPlayParam;", "getVideoDuration", "isPlaying", "", "isVideoPlaying", "pause", "", "seekTo", "pos", "", "changeSeekBar", "setVideoEndType", "videoEndType", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsPlayManager
{
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(@Nullable Object paramObject);
  
  public abstract long b();
  
  public abstract void g();
  
  public abstract boolean k();
  
  public abstract boolean p();
  
  public abstract long t();
  
  @Nullable
  public abstract VideoPlayParam v();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */