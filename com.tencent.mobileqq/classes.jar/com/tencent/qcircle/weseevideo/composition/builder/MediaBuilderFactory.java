package com.tencent.qcircle.weseevideo.composition.builder;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainConfigure;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AutoTemplateMediaBuilder;
import com.tencent.qcircle.weseevideo.model.template.light.LightTemplateMediaBuilder;
import com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplateMediaBuilder;

public class MediaBuilderFactory
{
  public static final int RHYTHM_SINGLE_IMAGE = 10000;
  public static final float TIME_FLOAT_MS = 1000.0F;
  public static final float TIME_FLOAT_US = 1000000.0F;
  public static final int TIME_INT_MS = 1000;
  public static final int TIME_MAX_MS = 60000;
  public static final int TIME_MIN_MS = 2000;
  
  public static void mediaBuilderSync(@NonNull MediaModel paramMediaModel, Context paramContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener)
  {
    mediaBuilderSync(paramMediaModel, paramContext, paramIStickerContextInterface, paramVideoRenderChainConfigure, paramMediaBuilderListener, false);
  }
  
  public static void mediaBuilderSync(@NonNull MediaModel paramMediaModel, Context paramContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface, @NonNull VideoRenderChainConfigure paramVideoRenderChainConfigure, @NonNull MediaBuilderListener paramMediaBuilderListener, boolean paramBoolean)
  {
    int i = paramVideoRenderChainConfigure.getSceneType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          MediaBuilder.build(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure);
          return;
        }
        LightTemplateMediaBuilder.build(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure, paramBoolean);
        return;
      }
      AutoTemplateMediaBuilder.build(paramMediaModel, paramContext, paramIStickerContextInterface, paramVideoRenderChainConfigure, paramMediaBuilderListener);
      return;
    }
    MovieTemplateMediaBuilder.build(paramMediaModel, paramIStickerContextInterface, paramMediaBuilderListener, paramVideoRenderChainConfigure);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderFactory
 * JD-Core Version:    0.7.0.1
 */