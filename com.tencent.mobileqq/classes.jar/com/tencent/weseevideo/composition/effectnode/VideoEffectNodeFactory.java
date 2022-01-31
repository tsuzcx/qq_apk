package com.tencent.weseevideo.composition.effectnode;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.aekit.AEKitModel;
import com.tencent.tavcut.aifilter.AIFilterModel;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.LutModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.VideoPagModel;
import com.tencent.weseevideo.model.utils.ModelAdaptUtils;
import java.util.Iterator;
import java.util.List;

public class VideoEffectNodeFactory
{
  public static String TAG = VideoEffectNodeFactory.class.getSimpleName();
  
  @Nullable
  public static TAVStickerRenderContext addPagOverlayEffectNode(@NonNull VideoPagModel paramVideoPagModel, CGSize paramCGSize, TAVStickerRenderContext paramTAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface)
  {
    paramVideoPagModel = paramTAVStickerRenderContext;
    if (paramTAVStickerRenderContext == null) {
      if (paramIStickerContextInterface == null) {
        break label31;
      }
    }
    label31:
    for (paramVideoPagModel = paramIStickerContextInterface.createStickerContext();; paramVideoPagModel = new TAVStickerRenderContext())
    {
      if (0 != 0) {
        throw new NullPointerException();
      }
      return paramVideoPagModel;
    }
  }
  
  @Nullable
  public static TAVStickerRenderContext addStickerEffectNode(@NonNull List<StickerModel> paramList, @NonNull CGSize paramCGSize, @NonNull TAVStickerRenderContext paramTAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface)
  {
    Object localObject = paramTAVStickerRenderContext;
    if (paramTAVStickerRenderContext == null) {
      if (paramIStickerContextInterface == null) {
        break label76;
      }
    }
    label76:
    for (localObject = paramIStickerContextInterface.createStickerContext(); paramIStickerContextInterface == null; localObject = new TAVStickerRenderContext())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramTAVStickerRenderContext = (StickerModel)paramList.next();
        if (paramTAVStickerRenderContext != null)
        {
          paramIStickerContextInterface = ModelAdaptUtils.stickerModelToTAVSticker(paramTAVStickerRenderContext, paramCGSize);
          paramTAVStickerRenderContext.setStickerId(paramIStickerContextInterface.getStickerId());
          loadSticker((TAVStickerRenderContext)localObject, paramIStickerContextInterface);
        }
      }
    }
    return localObject;
  }
  
  @Nullable
  public static AEKitNode createAEKitNode(@NonNull AEKitModel paramAEKitModel)
  {
    AEKitNode localAEKitNode = new AEKitNode();
    localAEKitNode.setAEKitModel(paramAEKitModel);
    return localAEKitNode;
  }
  
  @Nullable
  public static AIFilterNode createAIFilterNode(@NonNull AIFilterModel paramAIFilterModel)
  {
    AIFilterNode localAIFilterNode = new AIFilterNode();
    localAIFilterNode.setAIFilterModel(paramAIFilterModel);
    return localAIFilterNode;
  }
  
  @Nullable
  public static CropEffectNode createCropEffectNode(@NonNull CropModel paramCropModel)
  {
    CropEffectNode localCropEffectNode = new CropEffectNode();
    localCropEffectNode.setCropModel(paramCropModel);
    return localCropEffectNode;
  }
  
  @Nullable
  public static WSLutEffectNode createLutEffectNode(@NonNull LutModel paramLutModel)
  {
    WSLutEffectNode localWSLutEffectNode = new WSLutEffectNode();
    localWSLutEffectNode.setLutMode(paramLutModel);
    return localWSLutEffectNode;
  }
  
  public static TAVVideoEffect createPagOverlayEffect(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface)
  {
    return new WSOverlayStickerMergedEffectNode(paramTAVStickerRenderContext, paramIStickerContextInterface);
  }
  
  public static void loadSticker(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, @NonNull TAVSticker paramTAVSticker)
  {
    if ((paramTAVStickerRenderContext instanceof TAVStickerContext))
    {
      HandlerUtils.getMainHandler().post(new VideoEffectNodeFactory.1(paramTAVStickerRenderContext, paramTAVSticker));
      return;
    }
    paramTAVStickerRenderContext.loadSticker(paramTAVSticker, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.VideoEffectNodeFactory
 * JD-Core Version:    0.7.0.1
 */