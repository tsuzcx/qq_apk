package com.tencent.tavcut.exporter;

import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.util.CompositionUtils;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1$1
  implements MediaBuilderListener
{
  ImageExporter$1$1(ImageExporter.1 param1, StickerController paramStickerController, MediaModel paramMediaModel, CGSize paramCGSize, LinkedBlockingDeque paramLinkedBlockingDeque, String paramString1, String paramString2, AtomicInteger paramAtomicInteger, long paramLong) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.val$stickerController.restoreSticker(this.val$exportMediaModel.getMediaEffectModel().getStickerModelList());
    paramVideoRenderChainManager.getComposition().setRenderSize(this.val$size);
    paramVideoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    CompositionUtils.removeTAVAspectEffect(paramVideoRenderChainManager.getComposition());
    paramMediaBuilderOutput = new WSImageRender();
    DurationUtil.start("imageRender.init");
    paramMediaBuilderOutput.init(paramVideoRenderChainManager.getComposition(), paramVideoRenderChainManager.getComposition().getRenderSize());
    DurationUtil.end("imageRender.init");
    DurationUtil.start("imageRender.render");
    paramMediaBuilderOutput.render(new ImageExporter.1.1.1(this, paramVideoRenderChainManager, paramMediaBuilderOutput));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter.1.1
 * JD-Core Version:    0.7.0.1
 */