package com.tencent.qcircle.weseevideo.model.template.movie;

import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavmovie.sticker.TAVMovieSticker;
import com.tencent.tavsticker.model.TAVSticker;

final class MovieTemplateMediaBuilder$1
  implements VideoRenderChainManager.IEffectNodeInterface
{
  MovieTemplateMediaBuilder$1(MovieTemplate paramMovieTemplate) {}
  
  public void insertEffectNode(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    paramMediaEffectModel = this.val$movieTemplate;
    if (paramMediaEffectModel != null)
    {
      paramMediaEffectModel = paramMediaEffectModel.getTemplateSticker();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.template.movie.MovieTemplateMediaBuilder.1
 * JD-Core Version:    0.7.0.1
 */