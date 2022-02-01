package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.view.TextureView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.util.PanoramaConfig.Builder;

@QAPI(process={"all"})
public abstract interface IPanoramaView
  extends QRouteApi
{
  public abstract void changeRenderMode(TextureView paramTextureView, int paramInt);
  
  public abstract void changeRotate(TextureView paramTextureView, float paramFloat1, float paramFloat2);
  
  public abstract TextureView getPanoramaView(Context paramContext);
  
  public abstract void onRecycled(TextureView paramTextureView);
  
  public abstract void setOnPanoramaClickListener(TextureView paramTextureView, OnPanoramaClickListener paramOnPanoramaClickListener);
  
  public abstract void startShowPanorama(TextureView paramTextureView, PanoramaConfig.Builder paramBuilder, OnPanoramaLoadingListener paramOnPanoramaLoadingListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.IPanoramaView
 * JD-Core Version:    0.7.0.1
 */