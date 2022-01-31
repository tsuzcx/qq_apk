package com.tencent.tavcut.session;

import com.tencent.tavcut.exporter.VideoExportConfig;
import com.tencent.tavcut.exporter.VideoExporter;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.builder.MediaBuilderListener;
import com.tencent.weseevideo.composition.builder.MediaBuilderOutput;

class TAVCutVideoSession$3
  implements MediaBuilderListener
{
  TAVCutVideoSession$3(TAVCutVideoSession paramTAVCutVideoSession, VideoExporter paramVideoExporter, VideoExportConfig paramVideoExportConfig) {}
  
  public void buildCompleted(int paramInt, VideoRenderChainManager paramVideoRenderChainManager, MediaBuilderOutput paramMediaBuilderOutput)
  {
    this.val$videoExporter.setTavComposition(paramVideoRenderChainManager.getComposition());
    this.val$videoExporter.setVideoExportConfig(this.val$videoExportConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.3
 * JD-Core Version:    0.7.0.1
 */