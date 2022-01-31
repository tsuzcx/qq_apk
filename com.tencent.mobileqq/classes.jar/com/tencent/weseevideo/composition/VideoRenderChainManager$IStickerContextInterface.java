package com.tencent.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.tavsticker.core.TAVStickerContext;

public abstract interface VideoRenderChainManager$IStickerContextInterface
{
  public abstract void alignStickers(long paramLong);
  
  @NonNull
  public abstract TAVStickerContext createStickerContext();
  
  public abstract void releaseStickerContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface
 * JD-Core Version:    0.7.0.1
 */