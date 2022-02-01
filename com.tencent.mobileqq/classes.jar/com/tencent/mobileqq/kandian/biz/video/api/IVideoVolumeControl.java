package com.tencent.mobileqq.kandian.biz.video.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeControl;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isInPhoneCall", "", "context", "Landroid/content/Context;", "saveConfig", "", "shouldMute", "setMute", "mute", "reason", "", "what", "", "shouldMuteInReadInJoy", "startAudioPlay", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoVolumeControl
  extends QRouteApi
{
  public static final IVideoVolumeControl.Companion Companion = IVideoVolumeControl.Companion.a;
  public static final int GLOBAL = 0;
  public static final int IN_READINJOY = 1;
  public static final int IN_VIDEO_FEED = 2;
  
  public abstract boolean isInPhoneCall(@Nullable Context paramContext);
  
  public abstract void saveConfig(boolean paramBoolean);
  
  public abstract void setMute(boolean paramBoolean, @Nullable String paramString, int paramInt);
  
  public abstract boolean shouldMuteInReadInJoy();
  
  public abstract void startAudioPlay();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl
 * JD-Core Version:    0.7.0.1
 */