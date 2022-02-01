package com.tencent.tavcut.session.config;

import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import java.util.List;

public class SessionConfig
{
  private boolean autoPlayVideo = true;
  private TAVVideoConfiguration.TAVVideoConfigurationContentMode contentMode;
  private List<CropConfig> imageInitCropConfigs;
  private int maxImageDecodeSize = -1;
  private int maxIntermediateRenderSize = -1;
  private int minIntermediateRenderSize = -1;
  private VideoComposition.RenderLayoutMode renderLayoutMode;
  private StickerEditViewIconConfig stickerEditViewIconConfig;
  private CropConfig videoInitCropConfig;
  
  public TAVVideoConfiguration.TAVVideoConfigurationContentMode getContentMode()
  {
    return this.contentMode;
  }
  
  public List<CropConfig> getImageInitCropConfigs()
  {
    return this.imageInitCropConfigs;
  }
  
  public int getMaxImageDecodeSize()
  {
    return this.maxImageDecodeSize;
  }
  
  public int getMaxIntermediateRenderSize()
  {
    return this.maxIntermediateRenderSize;
  }
  
  public int getMinIntermediateRenderSize()
  {
    return this.minIntermediateRenderSize;
  }
  
  public VideoComposition.RenderLayoutMode getRenderLayoutMode()
  {
    return this.renderLayoutMode;
  }
  
  public StickerEditViewIconConfig getStickerEditViewIconConfig()
  {
    return this.stickerEditViewIconConfig;
  }
  
  public CropConfig getVideoInitCropConfig()
  {
    return this.videoInitCropConfig;
  }
  
  public boolean isAutoPlayVideo()
  {
    return this.autoPlayVideo;
  }
  
  public void setAutoPlayVideo(boolean paramBoolean)
  {
    this.autoPlayVideo = paramBoolean;
  }
  
  public void setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    this.contentMode = paramTAVVideoConfigurationContentMode;
  }
  
  public void setImageInitCropConfigs(List<CropConfig> paramList)
  {
    this.imageInitCropConfigs = paramList;
  }
  
  public void setMaxImageDecodeSize(int paramInt)
  {
    this.maxImageDecodeSize = paramInt;
  }
  
  public void setMaxIntermediateRenderSize(int paramInt)
  {
    this.maxIntermediateRenderSize = paramInt;
  }
  
  public void setMinIntermediateRenderSize(int paramInt)
  {
    this.minIntermediateRenderSize = paramInt;
  }
  
  public void setRenderLayoutMode(VideoComposition.RenderLayoutMode paramRenderLayoutMode)
  {
    this.renderLayoutMode = paramRenderLayoutMode;
  }
  
  public void setStickerEditViewIconConfig(StickerEditViewIconConfig paramStickerEditViewIconConfig)
  {
    this.stickerEditViewIconConfig = paramStickerEditViewIconConfig;
  }
  
  public void setVideoInitCropConfig(CropConfig paramCropConfig)
  {
    this.videoInitCropConfig = paramCropConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.config.SessionConfig
 * JD-Core Version:    0.7.0.1
 */