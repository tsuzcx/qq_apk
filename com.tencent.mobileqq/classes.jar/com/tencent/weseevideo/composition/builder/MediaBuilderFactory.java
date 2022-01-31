package com.tencent.weseevideo.composition.builder;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.model.MediaModel;

public class MediaBuilderFactory
{
  public static final int RHYTHM_SINGLE_IMAGE = 10000;
  public static final float TIME_FLOAT_MS = 1000.0F;
  public static final float TIME_FLOAT_US = 1000000.0F;
  public static final int TIME_INT_MS = 1000;
  public static final int TIME_MAX_MS = 60000;
  public static final int TIME_MIN_MS = 2000;
  
  public static void mediaBuilderAsync(@NonNull MediaModel paramMediaModel, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    paramVideoRenderChainConfigure.setSceneType(0);
    MediaBuilder.build(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure);
  }
  
  public static void mediaBuilderAsync(@NonNull MediaModel paramMediaModel, @NonNull VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    mediaBuilderAsync(paramMediaModel, paramIStickerContextInterface, new VideoRenderChainConfigure(true), paramMediaBuilderListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.builder.MediaBuilderFactory
 * JD-Core Version:    0.7.0.1
 */