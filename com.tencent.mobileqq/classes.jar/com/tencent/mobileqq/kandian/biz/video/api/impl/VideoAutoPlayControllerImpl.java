package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoAutoPlayControllerImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoAutoPlayController;", "()V", "canAutoPlayVideo", "", "initVideoPlaySetting", "", "p0", "", "kotlin.jvm.PlatformType", "isNeedNetWorkAlert", "isNeedNetWorkAlertForIPC", "isRefreshingList", "isWifi", "setChannelFrom", "", "setChannelId", "", "setIsRefreshingList", "updateNetworkChange", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoAutoPlayControllerImpl
  implements IVideoAutoPlayController
{
  public VideoAutoPlayControllerImpl()
  {
    VideoAutoPlayController localVideoAutoPlayController = VideoAutoPlayController.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localVideoAutoPlayController, "VideoAutoPlayController.getInstance()");
    this.$$delegate_0 = localVideoAutoPlayController;
  }
  
  public boolean canAutoPlayVideo()
  {
    return this.$$delegate_0.canAutoPlayVideo();
  }
  
  public void initVideoPlaySetting(String paramString)
  {
    this.$$delegate_0.initVideoPlaySetting(paramString);
  }
  
  public boolean isNeedNetWorkAlert()
  {
    return this.$$delegate_0.isNeedNetWorkAlert();
  }
  
  public boolean isNeedNetWorkAlertForIPC()
  {
    return this.$$delegate_0.isNeedNetWorkAlertForIPC();
  }
  
  public boolean isRefreshingList()
  {
    return this.$$delegate_0.isRefreshingList();
  }
  
  public boolean isWifi()
  {
    return this.$$delegate_0.isWifi();
  }
  
  public void setChannelFrom(long paramLong)
  {
    this.$$delegate_0.setChannelFrom(paramLong);
  }
  
  public void setChannelId(int paramInt)
  {
    this.$$delegate_0.setChannelId(paramInt);
  }
  
  public void setIsRefreshingList(boolean paramBoolean)
  {
    this.$$delegate_0.setIsRefreshingList(paramBoolean);
  }
  
  public void updateNetworkChange(boolean paramBoolean)
  {
    this.$$delegate_0.updateNetworkChange(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoAutoPlayControllerImpl
 * JD-Core Version:    0.7.0.1
 */