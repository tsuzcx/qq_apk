package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoVolumeControllerImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController;", "()V", "addEventListener", "", "listener", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController$EventListener;", "getStreamMaxVolume", "", "streamType", "inKandianModule", "context", "Landroid/content/Context;", "outKandianModule", "removeEventListener", "requestOrAbandonAudioFocus", "isFocus", "", "what", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoVolumeControllerImpl
  implements IVideoVolumeController
{
  public VideoVolumeControllerImpl()
  {
    VideoVolumeController localVideoVolumeController = VideoVolumeController.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localVideoVolumeController, "VideoVolumeController.getInstance()");
    this.$$delegate_0 = localVideoVolumeController;
  }
  
  public void addEventListener(@Nullable IVideoVolumeController.EventListener paramEventListener)
  {
    this.$$delegate_0.addEventListener(paramEventListener);
  }
  
  public int getStreamMaxVolume(int paramInt)
  {
    return this.$$delegate_0.getStreamMaxVolume(paramInt);
  }
  
  public void inKandianModule(@Nullable Context paramContext)
  {
    this.$$delegate_0.inKandianModule(paramContext);
  }
  
  public void outKandianModule(@Nullable Context paramContext)
  {
    this.$$delegate_0.outKandianModule(paramContext);
  }
  
  public void removeEventListener(@Nullable IVideoVolumeController.EventListener paramEventListener)
  {
    this.$$delegate_0.removeEventListener(paramEventListener);
  }
  
  public void requestOrAbandonAudioFocus(boolean paramBoolean, @Nullable String paramString)
  {
    this.$$delegate_0.requestOrAbandonAudioFocus(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoVolumeControllerImpl
 * JD-Core Version:    0.7.0.1
 */