package com.tencent.weseevideo.composition.builder;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.template.auto.AutoTemplateMediaBuilder;
import com.tencent.weseevideo.model.template.movie.MovieTemplateMediaBuilder;

public class MediaBuilderFactory
{
  public static final int RHYTHM_SINGLE_IMAGE = 10000;
  public static final float TIME_FLOAT_MS = 1000.0F;
  public static final float TIME_FLOAT_US = 1000000.0F;
  public static final int TIME_INT_MS = 1000;
  public static final int TIME_MAX_MS = 60000;
  public static final int TIME_MIN_MS = 2000;
  
  public static void mediaBuilderAsync(@NonNull MediaModel paramMediaModel, Context paramContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    switch (paramVideoRenderChainConfigure.getSceneType())
    {
    default: 
      MediaBuilder.build(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure);
      return;
    case 1: 
      MovieTemplateMediaBuilder.buildAsync(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure);
      return;
    }
    AutoTemplateMediaBuilder.build(paramMediaModel, paramContext, paramIStickerContextInterface, paramVideoRenderChainConfigure, paramMediaBuilderListener);
  }
  
  public static void mediaBuilderAsync(@NonNull MediaModel paramMediaModel, Context paramContext, @NonNull VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    mediaBuilderAsync(paramMediaModel, paramContext, paramIStickerContextInterface, new VideoRenderChainConfigure(true), paramMediaBuilderListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.builder.MediaBuilderFactory
 * JD-Core Version:    0.7.0.1
 */