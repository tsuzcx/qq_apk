package com.tencent.tavcut.rendermodel;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/RenderScene;", "", "(Ljava/lang/String;I)V", "PLAY", "COVER", "EXPORTER", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum RenderScene
{
  static
  {
    RenderScene localRenderScene1 = new RenderScene("PLAY", 0);
    PLAY = localRenderScene1;
    RenderScene localRenderScene2 = new RenderScene("COVER", 1);
    COVER = localRenderScene2;
    RenderScene localRenderScene3 = new RenderScene("EXPORTER", 2);
    EXPORTER = localRenderScene3;
    $VALUES = new RenderScene[] { localRenderScene1, localRenderScene2, localRenderScene3 };
  }
  
  private RenderScene() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.RenderScene
 * JD-Core Version:    0.7.0.1
 */