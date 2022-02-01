package com.tencent.weseevideo.model.template.movie;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface;
import com.tencent.weseevideo.model.effect.MediaEffectModel;

final class MovieTemplateMediaBuilder$1
  implements VideoRenderChainManager.IEffectNodeInterface
{
  MovieTemplateMediaBuilder$1(MovieTemplate paramMovieTemplate) {}
  
  public void insertEffectNode(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    if (this.val$movieTemplate != null)
    {
      paramMediaEffectModel = this.val$movieTemplate.getTemplateSticker();
      if ((paramMediaEffectModel != null) && (paramMediaEffectModel.getSticker() != null))
      {
        paramMediaEffectModel = paramMediaEffectModel.getSticker();
        paramMediaEffectModel.setTimeRange(new CMTimeRange(CMTime.CMTimeZero, paramVideoRenderChainManager.getComposition().getDuration()));
        paramMediaEffectModel.setLayerIndex(-98);
        paramVideoRenderChainManager.updateMovieTemplateEffect(paramMediaEffectModel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.movie.MovieTemplateMediaBuilder.1
 * JD-Core Version:    0.7.0.1
 */