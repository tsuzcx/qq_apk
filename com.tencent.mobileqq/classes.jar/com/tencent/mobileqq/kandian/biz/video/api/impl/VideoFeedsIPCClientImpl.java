package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoFeedsIPCClientImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;", "()V", "addObserver", "", "observer", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient$Observer;", "callServer", "Landroid/os/Bundle;", "action", "", "params", "removeObserver", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsIPCClientImpl
  implements IVideoFeedsIPCClient
{
  public VideoFeedsIPCClientImpl()
  {
    VideoFeedsIPCClient localVideoFeedsIPCClient = VideoFeedsIPCClient.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localVideoFeedsIPCClient, "VideoFeedsIPCClient.getInstance()");
    this.$$delegate_0 = localVideoFeedsIPCClient;
  }
  
  public void addObserver(@NotNull IVideoFeedsIPCClient.Observer paramObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramObserver, "observer");
    this.$$delegate_0.addObserver(paramObserver);
  }
  
  @Nullable
  public Bundle callServer(@Nullable String paramString, @Nullable Bundle paramBundle)
  {
    return this.$$delegate_0.callServer(paramString, paramBundle);
  }
  
  public void removeObserver(@NotNull IVideoFeedsIPCClient.Observer paramObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramObserver, "observer");
    this.$$delegate_0.removeObserver(paramObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoFeedsIPCClientImpl
 * JD-Core Version:    0.7.0.1
 */