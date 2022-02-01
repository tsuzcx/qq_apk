package com.tencent.mobileqq.kandian.biz.video.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addEventListener", "", "listener", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController$EventListener;", "getStreamMaxVolume", "", "streamType", "inKandianModule", "context", "Landroid/content/Context;", "outKandianModule", "removeEventListener", "requestOrAbandonAudioFocus", "isFocus", "", "what", "", "EventListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoVolumeController
  extends QRouteApi
{
  public abstract void addEventListener(@Nullable IVideoVolumeController.EventListener paramEventListener);
  
  public abstract int getStreamMaxVolume(int paramInt);
  
  public abstract void inKandianModule(@Nullable Context paramContext);
  
  public abstract void outKandianModule(@Nullable Context paramContext);
  
  public abstract void removeEventListener(@Nullable IVideoVolumeController.EventListener paramEventListener);
  
  public abstract void requestOrAbandonAudioFocus(boolean paramBoolean, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController
 * JD-Core Version:    0.7.0.1
 */