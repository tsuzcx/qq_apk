package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.view.TextureView;
import com.tencent.qzonehub.api.panorama.IPanoramaView;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.util.PanoramaConfig.Builder;
import cooperation.qzone.panorama.widget.PanoramaView;

public class PanoramaViewImpl
  implements IPanoramaView
{
  public void changeRenderMode(TextureView paramTextureView, int paramInt)
  {
    ((PanoramaView)paramTextureView).changeRenderMode(paramInt);
  }
  
  public void changeRotate(TextureView paramTextureView, float paramFloat1, float paramFloat2)
  {
    ((PanoramaView)paramTextureView).changeRotate(paramFloat1, paramFloat2);
  }
  
  public TextureView getPanoramaView(Context paramContext)
  {
    return new PanoramaView(paramContext);
  }
  
  public void onRecycled(TextureView paramTextureView)
  {
    ((PanoramaView)paramTextureView).onRecycled();
  }
  
  public void setOnPanoramaClickListener(TextureView paramTextureView, OnPanoramaClickListener paramOnPanoramaClickListener)
  {
    ((PanoramaView)paramTextureView).setOnPanoramaClickListener(paramOnPanoramaClickListener);
  }
  
  public void startShowPanorama(TextureView paramTextureView, PanoramaConfig.Builder paramBuilder, OnPanoramaLoadingListener paramOnPanoramaLoadingListener)
  {
    ((PanoramaView)paramTextureView).startShowPanorama(paramBuilder, paramOnPanoramaLoadingListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.panorama.impl.PanoramaViewImpl
 * JD-Core Version:    0.7.0.1
 */