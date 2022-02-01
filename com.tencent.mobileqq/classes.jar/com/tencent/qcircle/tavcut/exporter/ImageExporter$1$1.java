package com.tencent.qcircle.tavcut.exporter;

import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.qcircle.tavcut.util.CompositionUtils;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ImageExporter$1$1
  implements MediaBuilderListener
{
  ImageExporter$1$1(ImageExporter.1 param1, StickerController paramStickerController, MediaModel paramMediaModel, CGSize paramCGSize, LinkedBlockingDeque paramLinkedBlockingDeque, String paramString1, String paramString2, AtomicInteger paramAtomicInteger, long paramLong) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.val$stickerController.restoreSticker(this.val$exportMediaModel.getMediaEffectModel().getStickerModelList());
    if ((paramMediaBuilderOutput != null) && (paramMediaBuilderOutput.getAutomaticTemplate() != null) && (paramMediaBuilderOutput.getAutomaticTemplate().getRenderSize() != null)) {
      paramVideoRenderChainManager.getComposition().setRenderSize(paramMediaBuilderOutput.getAutomaticTemplate().getRenderSize());
    } else {
      paramVideoRenderChainManager.getComposition().setRenderSize(this.val$size);
    }
    paramVideoRenderChainManager.setFilterManager(this.this$1.val$aeFilterManager);
    paramVideoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    CompositionUtils.removeTAVAspectEffect(paramVideoRenderChainManager.getComposition());
    paramMediaBuilderOutput = new WSImageRender();
    DurationUtil.start("imageRender.init");
    Iterator localIterator1 = paramVideoRenderChainManager.getComposition().getVideoChannels().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
      {
        Object localObject = (TAVTransitionableVideo)localIterator2.next();
        if ((localObject instanceof TAVClip))
        {
          localObject = (TAVClip)localObject;
          if ((((TAVClip)localObject).getResource() instanceof TAVImageTrackResource)) {
            ((TAVImageTrackResource)((TAVClip)localObject).getResource()).setImageDecodeSize(this.val$size);
          }
        }
      }
    }
    paramMediaBuilderOutput.init(paramVideoRenderChainManager.getComposition(), paramVideoRenderChainManager.getComposition().getRenderSize());
    DurationUtil.end("imageRender.init");
    DurationUtil.start("imageRender.render");
    paramMediaBuilderOutput.render(new ImageExporter.1.1.1(this, paramVideoRenderChainManager, paramMediaBuilderOutput), this.this$1.val$eglContext, this.this$1.val$imageProcessThread, this.this$1.val$renderContext);
    DurationUtil.end("imageRender.render");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.exporter.ImageExporter.1.1
 * JD-Core Version:    0.7.0.1
 */