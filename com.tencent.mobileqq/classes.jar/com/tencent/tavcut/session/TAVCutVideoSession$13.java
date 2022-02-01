package com.tencent.tavcut.session;

import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;

class TAVCutVideoSession$13
  implements MediaBuilderListener
{
  TAVCutVideoSession$13(TAVCutVideoSession paramTAVCutVideoSession, VideoExporter paramVideoExporter, VideoExportConfig paramVideoExportConfig) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    if (TAVCutVideoSession.access$300(this.this$0))
    {
      TAVCutVideoSession.access$200(this.this$0, paramVideoRenderChainManager.getComposition());
      paramMediaBuilderOutput = TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager);
      paramVideoRenderChainManager.getComposition().setRenderSize(paramMediaBuilderOutput);
    }
    this.val$videoExporter.setTavComposition(paramVideoRenderChainManager.getComposition());
    this.val$videoExporter.setVideoExportConfig(this.val$videoExportConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.13
 * JD-Core Version:    0.7.0.1
 */