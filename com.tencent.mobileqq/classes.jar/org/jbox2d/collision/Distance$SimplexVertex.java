package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

class Distance$SimplexVertex
{
  public float a;
  public int indexA;
  public int indexB;
  public final Vec2 w = new Vec2();
  public final Vec2 wA = new Vec2();
  public final Vec2 wB = new Vec2();
  
  private Distance$SimplexVertex(Distance paramDistance) {}
  
  public void set(SimplexVertex paramSimplexVertex)
  {
    this.wA.set(paramSimplexVertex.wA);
    this.wB.set(paramSimplexVertex.wB);
    this.w.set(paramSimplexVertex.w);
    this.a = paramSimplexVertex.a;
    this.indexA = paramSimplexVertex.indexA;
    this.indexB = paramSimplexVertex.indexB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Distance.SimplexVertex
 * JD-Core Version:    0.7.0.1
 */