package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.qcircle.tavcut.util.CompositionUtils;
import com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import java.util.Iterator;
import java.util.List;

class TAVCutImageSession$21
  implements MediaBuilderListener
{
  TAVCutImageSession$21(TAVCutImageSession paramTAVCutImageSession, int paramInt, CGSize paramCGSize) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    paramVideoRenderChainManager.setFilterManager(TAVCutImageSession.access$700(this.this$0));
    paramVideoRenderChainManager.setShouldRenderStickerAdapter(new TAVCutImageSession.21.1(this));
    paramVideoRenderChainManager.setCachePicDelegate(TAVCutImageSession.access$800(this.this$0));
    this.this$0.renderChainManagers.put(this.val$index, paramVideoRenderChainManager);
    this.this$0.tavCompositions.put(this.val$index, paramVideoRenderChainManager.getComposition());
    this.this$0.mediaBuilderOutputs.put(this.val$index, paramMediaBuilderOutput);
    if ((paramMediaBuilderOutput != null) && (paramMediaBuilderOutput.getAutomaticTemplate() != null) && (paramMediaBuilderOutput.getAutomaticTemplate().getRenderSize() != null)) {
      paramVideoRenderChainManager.getComposition().setRenderSize(paramMediaBuilderOutput.getAutomaticTemplate().getRenderSize());
    } else {
      paramVideoRenderChainManager.getComposition().setRenderSize(this.val$size);
    }
    paramVideoRenderChainManager.getComposition().setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFill);
    paramMediaBuilderOutput = new WSImageRender();
    CompositionUtils.removeTAVAspectEffect(paramVideoRenderChainManager.getComposition());
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
    paramVideoRenderChainManager = paramVideoRenderChainManager.getPagChainRenderContext();
    if ((paramVideoRenderChainManager instanceof TAVAutomaticTransRenderContext)) {
      paramMediaBuilderOutput.setTansRenderContext((TAVAutomaticTransRenderContext)paramVideoRenderChainManager);
    }
    TAVCutImageSession.access$900(this.this$0).put(this.val$index, paramMediaBuilderOutput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.21
 * JD-Core Version:    0.7.0.1
 */