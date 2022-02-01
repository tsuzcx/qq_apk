package com.tencent.weseevideo.model.template.auto;

import android.graphics.Color;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
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
  AutoTemplateMediaBuilder$1(TAVAutomaticTemplate paramTAVAutomaticTemplate, boolean paramBoolean, MediaModel paramMediaModel) {}
  
  public void insertEffectNode(VideoRenderChainManager paramVideoRenderChainManager, MediaEffectModel paramMediaEffectModel)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.val$automaticTemplate.getTransitionStickers();
    Object localObject3;
    Object localObject4;
    if (!CollectionUtil.isEmptyList((List)localObject2))
    {
      localObject3 = ((List)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TAVSticker)((Iterator)localObject3).next();
        if (localObject4 != null) {
          ((TAVSticker)localObject4).setLayerIndex(-100);
        }
      }
      ((List)localObject1).addAll((Collection)localObject2);
    }
    localObject2 = this.val$automaticTemplate.getFilterStickers();
    Object localObject5;
    if (!CollectionUtil.isEmptyList((List)localObject2))
    {
      localObject4 = paramMediaEffectModel.getParam("FRAME_PARAMS_KEY_IS_ON");
      localObject3 = paramMediaEffectModel.getParam("FRAME_PARAMS_KEY_COLOR");
      if ("1".equals(localObject4))
      {
        localObject4 = ((List)localObject2).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject4 = (TAVSticker)((Iterator)localObject4).next();
          localObject5 = ((TAVSticker)localObject4).getStickerSolidItems();
          if (!CollectionUtil.isEmptyList((List)localObject5)) {
            break label296;
          }
        }
      }
    }
    for (;;)
    {
      ((List)localObject1).addAll((Collection)localObject2);
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
      AutoTemplateMediaBuilder.access$000(paramMediaEffectModel, this.val$automaticTemplate, this.val$isSwitchToTemplateByUser, paramVideoRenderChainManager);
      this.val$model.getMediaTemplateModel().getAutomaticMediaTemplateModel().setSwitchToTemplateByUser(false);
      return;
      label296:
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((TAVStickerSolidItem)((Iterator)localObject5).next()).setColor(Color.parseColor((String)localObject3));
      }
      ((TAVSticker)localObject4).updateLayerColor();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.auto.AutoTemplateMediaBuilder.1
 * JD-Core Version:    0.7.0.1
 */