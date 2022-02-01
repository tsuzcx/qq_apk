package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

class Collision$TempPolygon
{
  int count;
  final Vec2[] normals = new Vec2[8];
  final Vec2[] vertices = new Vec2[8];
  
  public Collision$TempPolygon()
  {
    int i = 0;
    for (;;)
    {
      Vec2[] arrayOfVec2 = this.vertices;
      if (i >= arrayOfVec2.length) {
        break;
      }
      arrayOfVec2[i] = new Vec2();
      this.normals[i] = new Vec2();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Collision.TempPolygon
 * JD-Core Version:    0.7.0.1
 */