package com.tencent.qcircle.weseevideo.composition;

import android.support.annotation.NonNull;
import com.tencent.tavsticker.core.TAVStickerContext;

public abstract interface VideoRenderChainManager$IStickerContextInterface
{
  public abstract void alignStickers(long paramLong);
  
  @NonNull
  public abstract TAVStickerContext createStickerContext(boolean paramBoolean);
  
  public abstract void releaseStickerContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface
 * JD-Core Version:    0.7.0.1
 */