package com.tencent.mobileqq.kandian.biz.video.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload;", "", "addPreDownloadVideo", "", "vid", "", "busiType", "", "videoDuration", "", "cacheDuration", "videoURL", "webCallback", "destory", "setCallbackListener", "listener", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoWebPreDownload$CallbackListener;", "stopPreDownloadVideo", "CallbackListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoWebPreDownload
{
  public abstract void a();
  
  public abstract void a(@Nullable IVideoWebPreDownload.CallbackListener paramCallbackListener);
  
  public abstract void a(@Nullable String paramString1, int paramInt1, long paramLong, int paramInt2, @Nullable String paramString2, @Nullable String paramString3);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload
 * JD-Core Version:    0.7.0.1
 */