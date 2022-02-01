package com.tencent.mobileqq.kandian.biz.video.api;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeController$EventListener;", "", "onHeadsetStateChanged", "", "on", "", "onPhoneCome", "onSystemVolumeChanged", "volume", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoVolumeController$EventListener
{
  public abstract void onHeadsetStateChanged(boolean paramBoolean);
  
  public abstract void onPhoneCome();
  
  public abstract void onSystemVolumeChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener
 * JD-Core Version:    0.7.0.1
 */