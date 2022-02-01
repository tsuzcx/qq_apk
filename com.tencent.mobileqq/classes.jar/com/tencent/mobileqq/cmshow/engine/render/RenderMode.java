package com.tencent.mobileqq.cmshow.engine.render;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/render/RenderMode;", "", "(Ljava/lang/String;I)V", "isOffscreen", "", "ON_SCREEN", "OFF_SCREEN", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public enum RenderMode
{
  static
  {
    RenderMode localRenderMode1 = new RenderMode("ON_SCREEN", 0);
    ON_SCREEN = localRenderMode1;
    RenderMode localRenderMode2 = new RenderMode("OFF_SCREEN", 1);
    OFF_SCREEN = localRenderMode2;
    $VALUES = new RenderMode[] { localRenderMode1, localRenderMode2 };
  }
  
  private RenderMode() {}
  
  public final boolean isOffscreen()
  {
    int i = RenderMode.WhenMappings.a[ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      throw new NoWhenBranchMatchedException();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.render.RenderMode
 * JD-Core Version:    0.7.0.1
 */