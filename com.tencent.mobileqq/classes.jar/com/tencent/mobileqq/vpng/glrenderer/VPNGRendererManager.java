package com.tencent.mobileqq.vpng.glrenderer;

import java.util.ArrayList;
import java.util.LinkedList;

public class VPNGRendererManager
{
  private static VPNGRendererManager jdField_a_of_type_ComTencentMobileqqVpngGlrendererVPNGRendererManager;
  private ArrayList<VPNGRenderer> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private LinkedList<Renderable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  private VPNGRenderer a(int paramInt1, int paramInt2)
  {
    return new VPNGRenderer(paramInt1, paramInt2);
  }
  
  public static VPNGRendererManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVpngGlrendererVPNGRendererManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqVpngGlrendererVPNGRendererManager == null) {
          jdField_a_of_type_ComTencentMobileqqVpngGlrendererVPNGRendererManager = new VPNGRendererManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqVpngGlrendererVPNGRendererManager;
  }
  
  public VPNGRenderer a(Renderable paramRenderable, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 5)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramRenderable);
      return null;
    }
    VPNGRenderer localVPNGRenderer = a(paramInt1, paramInt2);
    localVPNGRenderer.a(paramRenderable);
    this.jdField_a_of_type_JavaUtilArrayList.add(localVPNGRenderer);
    return localVPNGRenderer;
  }
  
  public void a(VPNGRenderer paramVPNGRenderer)
  {
    if (paramVPNGRenderer != null)
    {
      paramVPNGRenderer.c();
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramVPNGRenderer);
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() < 5) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()))
      {
        paramVPNGRenderer = (Renderable)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
        VPNGRenderer localVPNGRenderer = a(paramVPNGRenderer.getRenderWidth(), paramVPNGRenderer.getRenderHeight());
        localVPNGRenderer.a(paramVPNGRenderer);
        this.jdField_a_of_type_JavaUtilArrayList.add(localVPNGRenderer);
        paramVPNGRenderer.onSetRenderer(localVPNGRenderer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.VPNGRendererManager
 * JD-Core Version:    0.7.0.1
 */