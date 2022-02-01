package com.tencent.mobileqq.surfaceviewaction.nv;

import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;
import com.tencent.mobileqq.surfaceviewaction.Point;

public class Node
  extends BaseNode
{
  protected Point a;
  protected SpriteNativeView a;
  
  public Node()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionPoint = new Point(0.0F, 0.0F);
  }
  
  public ISpriteView<Node> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView;
  }
  
  public void b() {}
  
  public void c() {}
  
  public boolean c()
  {
    this.e = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getWidth();
    this.f = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionNvSpriteNativeView.getHeight();
    return b();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.Node
 * JD-Core Version:    0.7.0.1
 */