package com.tencent.tavcut.exporter;

import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1$1
  implements MediaBuilderListener
{
  ImageExporter$1$1(ImageExporter.1 param1, StickerController paramStickerController, MediaModel paramMediaModel, String paramString1, LinkedBlockingDeque paramLinkedBlockingDeque, String paramString2, AtomicInteger paramAtomicInteger) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.val$stickerController.restoreSticker(this.val$exportMediaModel.getMediaEffectModel().getStickerModelList());
    int j = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getWidth();
    int k = ((MediaClipModel)paramVideoRenderChainManager.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getHeight();
    int m = BitmapUtil.getImageRotation(this.val$sourcePath);
    int i;
    if (m != 90)
    {
      paramInt = k;
      i = j;
      if (m != 270) {}
    }
    else
    {
      i = k;
      paramInt = j;
    }
    paramVideoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    paramMediaBuilderOutput = this.val$exportMediaModel.getMediaEffectModel().getCropModel();
    k = paramInt;
    j = i;
    if (paramMediaBuilderOutput != null)
    {
      k = paramInt;
      j = i;
      if (paramMediaBuilderOutput.getCropConfig() != null)
      {
        j = (int)(i * paramMediaBuilderOutput.getCropConfig().getWidth());
        k = (int)(paramInt * paramMediaBuilderOutput.getCropConfig().getHeight());
      }
    }
    paramVideoRenderChainManager.getComposition().setRenderSize(new CGSize(j, k));
    this.this$1.this$0.constrainRenderSize(j, k, paramVideoRenderChainManager);
    paramMediaBuilderOutput = new WSImageRender();
    DurationUtil.start("imageRender.init");
    paramMediaBuilderOutput.init(paramVideoRenderChainManager.getComposition(), paramVideoRenderChainManager.getComposition().getRenderSize());
    DurationUtil.end("imageRender.init");
    DurationUtil.start("imageRender.render");
    paramMediaBuilderOutput.render(new ImageExporter.1.1.1(this, paramVideoRenderChainManager, paramMediaBuilderOutput));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.exporter.ImageExporter.1.1
 * JD-Core Version:    0.7.0.1
 */