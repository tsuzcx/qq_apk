package com.tencent.mobileqq.kandian.biz.video.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"tool"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addObserver", "", "observer", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsIPCClient$Observer;", "callServer", "Landroid/os/Bundle;", "action", "", "params", "removeObserver", "Observer", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoFeedsIPCClient
  extends QRouteApi
{
  public abstract void addObserver(@NotNull IVideoFeedsIPCClient.Observer paramObserver);
  
  @Nullable
  public abstract Bundle callServer(@Nullable String paramString, @Nullable Bundle paramBundle);
  
  public abstract void removeObserver(@NotNull IVideoFeedsIPCClient.Observer paramObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient
 * JD-Core Version:    0.7.0.1
 */