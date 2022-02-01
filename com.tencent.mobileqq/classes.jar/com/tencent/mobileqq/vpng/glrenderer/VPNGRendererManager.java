package com.tencent.mobileqq.vpng.glrenderer;

import java.util.ArrayList;
import java.util.LinkedList;

public class VPNGRendererManager
{
  private static VPNGRendererManager a;
  private LinkedList<Renderable> b = new LinkedList();
  private ArrayList<VPNGRenderer> c = new ArrayList(5);
  
  private VPNGRenderer a(int paramInt1, int paramInt2)
  {
    return new VPNGRenderer(paramInt1, paramInt2);
  }
  
  public static VPNGRendererManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VPNGRendererManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public VPNGRenderer a(Renderable paramRenderable, int paramInt1, int paramInt2)
  {
    if (this.c.size() == 5)
    {
      this.b.add(paramRenderable);
      return null;
    }
    VPNGRenderer localVPNGRenderer = a(paramInt1, paramInt2);
    localVPNGRenderer.a(paramRenderable);
    this.c.add(localVPNGRenderer);
    return localVPNGRenderer;
  }
  
  public void a(VPNGRenderer paramVPNGRenderer)
  {
    if (paramVPNGRenderer != null)
    {
      paramVPNGRenderer.c();
      this.c.remove(paramVPNGRenderer);
      if ((this.c.size() < 5) && (!this.b.isEmpty()))
      {
        paramVPNGRenderer = (Renderable)this.b.getFirst();
        VPNGRenderer localVPNGRenderer = a(paramVPNGRenderer.getRenderWidth(), paramVPNGRenderer.getRenderHeight());
        localVPNGRenderer.a(paramVPNGRenderer);
        this.c.add(localVPNGRenderer);
        paramVPNGRenderer.onSetRenderer(localVPNGRenderer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRendererManager
 * JD-Core Version:    0.7.0.1
 */