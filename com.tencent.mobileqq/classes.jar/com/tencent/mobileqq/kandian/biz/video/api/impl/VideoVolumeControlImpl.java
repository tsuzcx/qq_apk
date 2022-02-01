package com.tencent.mobileqq.kandian.biz.video.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoVolumeControlImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeControl;", "()V", "isInPhoneCall", "", "context", "Landroid/content/Context;", "saveConfig", "", "shouldMute", "setMute", "mute", "reason", "", "what", "", "shouldMuteInReadInJoy", "startAudioPlay", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoVolumeControlImpl
  implements IVideoVolumeControl
{
  public VideoVolumeControlImpl()
  {
    VideoVolumeControl localVideoVolumeControl = VideoVolumeControl.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localVideoVolumeControl, "VideoVolumeControl.getInstance()");
    this.$$delegate_0 = localVideoVolumeControl;
  }
  
  public boolean isInPhoneCall(@Nullable Context paramContext)
  {
    return this.$$delegate_0.isInPhoneCall(paramContext);
  }
  
  public void saveConfig(boolean paramBoolean)
  {
    this.$$delegate_0.saveConfig(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean, @Nullable String paramString, int paramInt)
  {
    this.$$delegate_0.setMute(paramBoolean, paramString, paramInt);
  }
  
  public boolean shouldMuteInReadInJoy()
  {
    return this.$$delegate_0.shouldMuteInReadInJoy();
  }
  
  public void startAudioPlay()
  {
    this.$$delegate_0.startAudioPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.impl.VideoVolumeControlImpl
 * JD-Core Version:    0.7.0.1
 */