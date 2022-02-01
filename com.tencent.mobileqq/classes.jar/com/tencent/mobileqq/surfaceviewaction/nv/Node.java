package com.tencent.mobileqq.surfaceviewaction.nv;

import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;
import com.tencent.mobileqq.surfaceviewaction.Point;

public class Node
  extends BaseNode
{
  protected SpriteNativeView t;
  protected Point u = new Point(0.0F, 0.0F);
  
  public void g() {}
  
  public void h() {}
  
  public ISpriteView<Node> j()
  {
    return this.t;
  }
  
  public boolean k()
  {
    this.q = this.t.getWidth();
    this.r = this.t.getHeight();
    return i();
  }
  
  public void l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.Node
 * JD-Core Version:    0.7.0.1
 */