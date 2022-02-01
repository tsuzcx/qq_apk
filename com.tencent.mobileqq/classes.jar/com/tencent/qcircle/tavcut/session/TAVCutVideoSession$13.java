package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.tavcut.exporter.VideoExportConfig;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.qcircle.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;

class TAVCutVideoSession$13
  implements MediaBuilderListener
{
  TAVCutVideoSession$13(TAVCutVideoSession paramTAVCutVideoSession, VideoExporter paramVideoExporter, VideoExportConfig paramVideoExportConfig) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    TAVCutVideoSession.access$002(this.this$0, paramMediaBuilderOutput);
    if ((ModelExtKt.isAutoTemplate(this.this$0.getMediaModel())) || (ModelExtKt.isLightTemplate(this.this$0.getMediaModel())))
    {
      TAVCutVideoSession.access$500(this.this$0, paramVideoRenderChainManager.getComposition());
      paramMediaBuilderOutput = TAVCutVideoSession.access$400(this.this$0, paramVideoRenderChainManager);
      TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager, paramMediaBuilderOutput);
    }
    this.val$videoExporter.setTavComposition(paramVideoRenderChainManager.getComposition());
    this.val$videoExporter.setVideoExportConfig(this.val$videoExportConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.13
 * JD-Core Version:    0.7.0.1
 */