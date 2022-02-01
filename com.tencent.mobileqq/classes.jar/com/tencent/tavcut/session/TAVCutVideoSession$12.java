package com.tencent.tavcut.session;

import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;
import com.tencent.weseevideo.model.ModelExtKt;

class TAVCutVideoSession$12
  implements MediaBuilderListener
{
  TAVCutVideoSession$12(TAVCutVideoSession paramTAVCutVideoSession, VideoExporter paramVideoExporter, VideoExportConfig paramVideoExportConfig) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    TAVCutVideoSession.access$002(this.this$0, paramMediaBuilderOutput);
    if ((ModelExtKt.isAutoTemplate(this.this$0.getMediaModel())) || (ModelExtKt.isLightTemplate(this.this$0.getMediaModel())))
    {
      TAVCutVideoSession.access$400(this.this$0, paramVideoRenderChainManager.getComposition());
      paramMediaBuilderOutput = TAVCutVideoSession.access$300(this.this$0, paramVideoRenderChainManager);
      TAVCutVideoSession.access$100(this.this$0, paramVideoRenderChainManager, paramMediaBuilderOutput);
    }
    this.val$videoExporter.setTavComposition(paramVideoRenderChainManager.getComposition());
    this.val$videoExporter.setVideoExportConfig(this.val$videoExportConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.12
 * JD-Core Version:    0.7.0.1
 */