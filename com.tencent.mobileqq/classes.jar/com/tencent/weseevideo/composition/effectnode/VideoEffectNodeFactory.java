package com.tencent.weseevideo.composition.effectnode;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.VideoRenderChainManager.IStickerContextInterface;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.weseevideo.editor.utils.HandlerUtils;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.LutModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import com.tencent.weseevideo.model.effect.VideoBeginModel;
import com.tencent.weseevideo.model.effect.VideoEffectModel;
import com.tencent.weseevideo.model.effect.VideoEndModel;
import com.tencent.weseevideo.model.effect.VideoFenWeiModel;
import com.tencent.weseevideo.model.effect.VideoPagModel;
import com.tencent.weseevideo.model.utils.ModelAdaptUtils;
import java.util.Iterator;
import java.util.List;

public class VideoEffectNodeFactory
{
  public static String TAG = VideoEffectNodeFactory.class.getSimpleName();
  
  @Nullable
  public static TAVAutomaticRenderContext addPagChainEffectNode(@NonNull VideoPagModel paramVideoPagModel, TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    TAVAutomaticRenderContext localTAVAutomaticRenderContext = paramTAVAutomaticRenderContext;
    if (paramTAVAutomaticRenderContext == null) {
      localTAVAutomaticRenderContext = new TAVAutomaticRenderContext();
    }
    Object localObject = null;
    if ((VideoEffectType.TYPE_VIDEO_BEGIN.value == paramVideoPagModel.getEffectType()) && ((paramVideoPagModel instanceof VideoBeginModel)))
    {
      paramTAVAutomaticRenderContext = ModelAdaptUtils.videoBeginModelToTAVSticker((VideoBeginModel)paramVideoPagModel);
      TAVStickerExKt.setExtraStickerType(paramTAVAutomaticRenderContext, "sticker_video_begin");
    }
    for (;;)
    {
      if (paramTAVAutomaticRenderContext != null)
      {
        paramVideoPagModel.setUniqueId(paramTAVAutomaticRenderContext.getStickerId());
        localTAVAutomaticRenderContext.loadSticker(paramTAVAutomaticRenderContext, false);
      }
      return localTAVAutomaticRenderContext;
      if ((VideoEffectType.TYPE_VIDEO_END.value == paramVideoPagModel.getEffectType()) && ((paramVideoPagModel instanceof VideoEndModel)))
      {
        paramTAVAutomaticRenderContext = ModelAdaptUtils.videoEndModelToTAVSticker((VideoEndModel)paramVideoPagModel);
        TAVStickerExKt.setExtraStickerType(paramTAVAutomaticRenderContext, "sticker_video_end");
      }
      else
      {
        paramTAVAutomaticRenderContext = localObject;
        if (VideoEffectType.TYPE_FEN_WEI.value == paramVideoPagModel.getEffectType())
        {
          paramTAVAutomaticRenderContext = localObject;
          if ((paramVideoPagModel instanceof VideoFenWeiModel))
          {
            paramTAVAutomaticRenderContext = ModelAdaptUtils.videoFenWeiModelToTAVSticker((VideoFenWeiModel)paramVideoPagModel);
            TAVStickerExKt.setExtraStickerType(paramTAVAutomaticRenderContext, "sticker_fen_wei");
          }
        }
      }
    }
  }
  
  @Nullable
  public static TAVStickerRenderContext addPagOverlayEffectNode(@NonNull VideoPagModel paramVideoPagModel, CGSize paramCGSize, TAVStickerRenderContext paramTAVStickerRenderContext, VideoRenderChainManager.IStickerContextInterface paramIStickerContextInterface)
  {
    Object localObject1 = paramTAVStickerRenderContext;
    if (paramTAVStickerRenderContext == null) {
      if (paramIStickerContextInterface == null) {
        break label91;
      }
    }
    label91:
    for (localObject1 = paramIStickerContextInterface.createStickerContext();; localObject1 = new TAVStickerRenderContext())
    {
      Object localObject2 = null;
      paramTAVStickerRenderContext = localObject2;
      if (paramIStickerContextInterface == null)
      {
        paramTAVStickerRenderContext = localObject2;
        if (VideoEffectType.TYPE_SUBTITLE.value == paramVideoPagModel.getEffectType())
        {
          paramTAVStickerRenderContext = localObject2;
          if ((paramVideoPagModel instanceof SubtitleModel))
          {
            paramTAVStickerRenderContext = ModelAdaptUtils.subtitleModelToTAVSticker((SubtitleModel)paramVideoPagModel, paramCGSize);
            TAVStickerExKt.setExtraStickerType(paramTAVStickerRenderContext, "sticker_lyric");
          }
        }
      }
      if (paramTAVStickerRenderContext != null)
      {
        paramVideoPagModel.setUniqueId(paramTAVStickerRenderContext.getStickerId());
        loadSticker((TAVStickerRenderContext)localObject1, paramTAVStickerRenderContext);
      }
      return localObject1;
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
          paramTAVStickerRenderContext.setUniqueId(paramIStickerContextInterface.getStickerId());
          loadSticker((TAVStickerRenderContext)localObject, paramIStickerContextInterface);
        }
      }
    }
    return localObject;
  }
  
  @Nullable
  public static TAVAutomaticRenderContext addVideoSpecialEffectNode(@NonNull List<VideoEffectModel> paramList, @NonNull TAVAutomaticRenderContext paramTAVAutomaticRenderContext)
  {
    TAVAutomaticRenderContext localTAVAutomaticRenderContext = paramTAVAutomaticRenderContext;
    if (paramTAVAutomaticRenderContext == null) {
      localTAVAutomaticRenderContext = new TAVAutomaticRenderContext();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramTAVAutomaticRenderContext = (VideoEffectModel)paramList.next();
      if (paramTAVAutomaticRenderContext != null)
      {
        TAVSticker localTAVSticker = ModelAdaptUtils.videoEffectModelToTAVSticker(paramTAVAutomaticRenderContext);
        paramTAVAutomaticRenderContext.setUniqueId(localTAVSticker.getStickerId());
        localTAVSticker.setLayerIndex(-99);
        loadSticker(localTAVAutomaticRenderContext, localTAVSticker);
      }
    }
    return localTAVAutomaticRenderContext;
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
  
  @Nullable
  public static TAVVideoMixEffect createPagChainEffect(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    if ((paramTAVStickerRenderContext instanceof TAVAutomaticRenderContext))
    {
      ((TAVAutomaticRenderContext)paramTAVStickerRenderContext).readAllVideoTracks();
      return new WSPagChainStickerMergedEffectNode((TAVAutomaticRenderContext)paramTAVStickerRenderContext);
    }
    return new TAVBigStickerOverlayEffect(paramTAVStickerRenderContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.VideoEffectNodeFactory
 * JD-Core Version:    0.7.0.1
 */