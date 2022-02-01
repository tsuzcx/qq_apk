package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

public class Collision$ClipVertex
{
  public final ContactID id = new ContactID();
  public final Vec2 v = new Vec2();
  
  public void set(ClipVertex paramClipVertex)
  {
    Vec2 localVec2 = paramClipVertex.v;
    this.v.x = localVec2.x;
    this.v.y = localVec2.y;
    paramClipVertex = paramClipVertex.id;
    this.id.indexA = paramClipVertex.indexA;
    this.id.indexB = paramClipVertex.indexB;
    this.id.typeA = paramClipVertex.typeA;
    this.id.typeB = paramClipVertex.typeB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Collision.ClipVertex
 * JD-Core Version:    0.7.0.1
 */