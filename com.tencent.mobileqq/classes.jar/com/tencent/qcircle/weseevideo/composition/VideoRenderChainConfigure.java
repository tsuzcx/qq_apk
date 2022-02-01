package com.tencent.qcircle.weseevideo.composition;

import com.tencent.tav.coremedia.CGSize;

public class VideoRenderChainConfigure
{
  private boolean imageMode;
  private boolean isOpenAspectFillEffect;
  private boolean isOpenBeautyEffect;
  private boolean isOpenFreeVideoEndEffect;
  private boolean isOpenLutEffect;
  private boolean isOpenMovieTemplateEffect;
  private boolean isOpenRedPacketStickerEffect;
  private boolean isOpenStickerEffect;
  private boolean isOpenSubtitleEffect;
  private boolean isOpenVideoBeginEffect;
  private boolean isOpenVideoEndEffect;
  private boolean isOpenVideoFenWeiEffect;
  private boolean isOpenVideoSpecialEffect;
  private boolean isOpenWXShareVideoEndEffect;
  private boolean isOpenWaterMarkEffect;
  public int mApplyType = -1;
  private CGSize mRenderSize;
  private int mSceneType = 0;
  private boolean modifyClip;
  private CGSize screenSize;
  
  public VideoRenderChainConfigure()
  {
    this(true);
  }
  
  public VideoRenderChainConfigure(boolean paramBoolean)
  {
    this.isOpenAspectFillEffect = paramBoolean;
    this.isOpenBeautyEffect = paramBoolean;
    this.isOpenLutEffect = paramBoolean;
    this.isOpenVideoSpecialEffect = paramBoolean;
    this.isOpenVideoBeginEffect = paramBoolean;
    this.isOpenVideoFenWeiEffect = paramBoolean;
    this.isOpenVideoEndEffect = paramBoolean;
    this.isOpenStickerEffect = paramBoolean;
    this.isOpenSubtitleEffect = paramBoolean;
    this.isOpenFreeVideoEndEffect = paramBoolean;
    this.isOpenWaterMarkEffect = paramBoolean;
    this.isOpenWXShareVideoEndEffect = paramBoolean;
    this.isOpenRedPacketStickerEffect = paramBoolean;
    this.isOpenMovieTemplateEffect = paramBoolean;
  }
  
  public int getApplyType()
  {
    return this.mApplyType;
  }
  
  public CGSize getRenderSize()
  {
    return this.mRenderSize;
  }
  
  public int getSceneType()
  {
    return this.mSceneType;
  }
  
  public CGSize getScreenSize()
  {
    return this.screenSize;
  }
  
  public boolean isImageMode()
  {
    return this.imageMode;
  }
  
  public boolean isModifyClip()
  {
    return this.modifyClip;
  }
  
  public boolean isOpenAspectFillEffect()
  {
    return this.isOpenAspectFillEffect;
  }
  
  public boolean isOpenBeautyEffect()
  {
    return this.isOpenBeautyEffect;
  }
  
  public boolean isOpenFreeVideoEndEffect()
  {
    return this.isOpenFreeVideoEndEffect;
  }
  
  public boolean isOpenLutEffect()
  {
    return this.isOpenLutEffect;
  }
  
  public boolean isOpenMovieTemplateEffect()
  {
    return this.isOpenMovieTemplateEffect;
  }
  
  public boolean isOpenRedPacketStickerEffect()
  {
    return this.isOpenRedPacketStickerEffect;
  }
  
  public boolean isOpenStickerEffect()
  {
    return this.isOpenStickerEffect;
  }
  
  public boolean isOpenSubtitleEffect()
  {
    return this.isOpenSubtitleEffect;
  }
  
  public boolean isOpenVideoBeginEffect()
  {
    return this.isOpenVideoBeginEffect;
  }
  
  public boolean isOpenVideoEndEffect()
  {
    return this.isOpenVideoEndEffect;
  }
  
  public boolean isOpenVideoFenWeiEffect()
  {
    return this.isOpenVideoFenWeiEffect;
  }
  
  public boolean isOpenVideoSpecialEffect()
  {
    return this.isOpenVideoSpecialEffect;
  }
  
  public boolean isOpenWXShareVideoEndEffect()
  {
    return this.isOpenWXShareVideoEndEffect;
  }
  
  public boolean isOpenWaterMarkEffect()
  {
    return this.isOpenWaterMarkEffect;
  }
  
  public void setApplyType(int paramInt)
  {
    this.mApplyType = paramInt;
  }
  
  public void setImageMode(boolean paramBoolean)
  {
    this.imageMode = paramBoolean;
  }
  
  public void setModifyClip(boolean paramBoolean)
  {
    this.modifyClip = paramBoolean;
  }
  
  public void setOpenAspectFillEffect(boolean paramBoolean)
  {
    this.isOpenAspectFillEffect = paramBoolean;
  }
  
  public void setOpenBeautyEffect(boolean paramBoolean)
  {
    this.isOpenBeautyEffect = paramBoolean;
  }
  
  public void setOpenFreeVideoEndEffect(boolean paramBoolean)
  {
    this.isOpenFreeVideoEndEffect = paramBoolean;
  }
  
  public void setOpenLutEffect(boolean paramBoolean)
  {
    this.isOpenLutEffect = paramBoolean;
  }
  
  public void setOpenMovieTemplateEffect(boolean paramBoolean)
  {
    this.isOpenMovieTemplateEffect = paramBoolean;
  }
  
  public void setOpenRedPacketStickerEffect(boolean paramBoolean)
  {
    this.isOpenRedPacketStickerEffect = paramBoolean;
  }
  
  public void setOpenStickerEffect(boolean paramBoolean)
  {
    this.isOpenStickerEffect = paramBoolean;
  }
  
  public void setOpenSubtitleEffect(boolean paramBoolean)
  {
    this.isOpenSubtitleEffect = paramBoolean;
  }
  
  public void setOpenVideoBeginEffect(boolean paramBoolean)
  {
    this.isOpenVideoBeginEffect = paramBoolean;
  }
  
  public void setOpenVideoEndEffect(boolean paramBoolean)
  {
    this.isOpenVideoEndEffect = paramBoolean;
  }
  
  public void setOpenVideoFenWeiEffect(boolean paramBoolean)
  {
    this.isOpenVideoFenWeiEffect = paramBoolean;
  }
  
  public void setOpenVideoSpecialEffect(boolean paramBoolean)
  {
    this.isOpenVideoSpecialEffect = paramBoolean;
  }
  
  public void setOpenWXShareVideoEndEffect(boolean paramBoolean)
  {
    this.isOpenWXShareVideoEndEffect = paramBoolean;
  }
  
  public void setOpenWaterMarkEffect(boolean paramBoolean)
  {
    this.isOpenWaterMarkEffect = paramBoolean;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.mRenderSize = paramCGSize;
  }
  
  public void setSceneType(int paramInt)
  {
    this.mSceneType = paramInt;
  }
  
  public void setScreenSize(CGSize paramCGSize)
  {
    this.screenSize = paramCGSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure
 * JD-Core Version:    0.7.0.1
 */