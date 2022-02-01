package com.tencent.weseevideo.model.template.auto;

import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IEffectNodeInterface;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.template.MediaTemplateModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class AutoTemplateMediaBuilder$1
  implements VideoRenderChainManager.IEffectNodeInterface
{
  AutoTemplateMediaBuilder$1(TAVAutomaticTemplate paramTAVAutomaticTemplate, AutomaticMediaTemplateModel paramAutomaticMediaTemplateModel, boolean paramBoolean, MediaModel paramMediaModel) {}
  
  public void insertEffectNode(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.val$automaticTemplate.getTransitionStickers();
    Iterator localIterator;
    TAVSticker localTAVSticker;
    if (!CollectionUtil.isEmptyList((List)localObject2))
    {
      localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localTAVSticker = (TAVSticker)localIterator.next();
        if (localTAVSticker != null) {
          localTAVSticker.setLayerIndex(-100);
        }
      }
      ((List)localObject1).addAll((Collection)localObject2);
    }
    localObject2 = this.val$automaticTemplate.getFilterStickers();
    if (!CollectionUtil.isEmptyList((List)localObject2))
    {
      if (("1".equals(paramMediaEffectModel.getParam("FRAME_PARAMS_KEY_IS_ON"))) && (this.val$templateModel.getAEFrameModel() != null))
      {
        int i = this.val$templateModel.getAEFrameModel().getPagFillMode();
        localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          localTAVSticker = (TAVSticker)localIterator.next();
          if (i == 1)
          {
            localTAVSticker.setScaleMode(1);
          }
          else
          {
            localTAVSticker.setScaleMode(0);
            this.val$automaticTemplate.setRenderSize(AutoTemplateMediaBuilder.access$000(localTAVSticker));
          }
        }
      }
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if (!CollectionUtil.isEmptyList((List)localObject1))
    {
      localObject2 = paramVideoRenderChainManager.getPagChainRenderContext();
      ((List)localObject1).addAll(((TAVStickerRenderContext)localObject2).getStickers());
      if ((localObject2 instanceof TAVAutomaticRenderContext)) {
        ((TAVAutomaticRenderContext)localObject2).setEffectStickers((List)localObject1);
      }
    }
    localObject1 = this.val$automaticTemplate.getOverlayStickers();
    if (!CollectionUtil.isEmptyList((List)localObject1))
    {
      localObject2 = paramVideoRenderChainManager.getStickerRenderContext();
      ((List)localObject1).addAll(((TAVStickerRenderContext)localObject2).getStickers());
      ((TAVStickerRenderContext)localObject2).reloadStickers((List)localObject1);
    }
    paramVideoRenderChainManager = paramVideoRenderChainManager.getComposition().getDuration();
    AutoTemplateMediaBuilder.access$100(paramMediaEffectModel, this.val$automaticTemplate, this.val$isSwitchToTemplateByUser, paramVideoRenderChainManager);
    this.val$model.getMediaTemplateModel().getAutomaticMediaTemplateModel().setSwitchToTemplateByUser(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AutoTemplateMediaBuilder.1
 * JD-Core Version:    0.7.0.1
 */