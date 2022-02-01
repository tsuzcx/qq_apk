package com.tencent.mobileqq.surfaceviewaction.gl;

import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;

public class Node
  extends BaseNode
{
  protected SpriteGLView v;
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat)
  {
    this.q = paramInt1;
    this.r = paramInt2;
    i();
  }
  
  public ISpriteView j()
  {
    return this.v;
  }
  
  protected void k() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Node
 * JD-Core Version:    0.7.0.1
 */