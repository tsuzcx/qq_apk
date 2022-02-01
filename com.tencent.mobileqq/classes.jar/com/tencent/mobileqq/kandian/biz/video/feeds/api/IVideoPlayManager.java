package com.tencent.mobileqq.kandian.biz.video.feeds.api;

import android.app.Activity;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/feeds/api/IVideoPlayManager;", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/api/IVideoPlay;", "addStateListener", "", "listener", "Lcom/tencent/mobileqq/kandian/biz/video/api/OnPlayStateListener;", "getActivity", "Landroid/app/Activity;", "getCurrenPlayPostion", "", "getCurrentPlayVideoParam", "Lcom/tencent/mobileqq/kandian/biz/video/feeds/entity/VideoPlayParam;", "getVideoDuration", "getVideoUIManager", "Lcom/tencent/mobileqq/kandian/biz/feeds/api/IVideoUIManager;", "isPlaying", "", "pause", "removeStateListener", "seekTo", "pos", "", "setVideoPauseType", "videoPauseType", "Ljava/lang/Object;", "stop", "what", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPlayManager
  extends IVideoPlay
{
  @Nullable
  public abstract VideoPlayParam a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(@Nullable OnPlayStateListener paramOnPlayStateListener);
  
  public abstract void a(@Nullable Object paramObject);
  
  @Nullable
  public abstract Activity b();
  
  public abstract void b(int paramInt);
  
  public abstract void b(@Nullable OnPlayStateListener paramOnPlayStateListener);
  
  public abstract void c();
  
  @Nullable
  public abstract IVideoUIManager d();
  
  public abstract long e();
  
  public abstract long f();
  
  public abstract boolean g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager
 * JD-Core Version:    0.7.0.1
 */