package org.jbox2d.collision;

import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;

public class Distance$DistanceProxy
{
  public final Vec2[] m_buffer;
  public int m_count;
  public float m_radius;
  public final Vec2[] m_vertices = new Vec2[8];
  
  public Distance$DistanceProxy()
  {
    int i = 0;
    for (;;)
    {
      Vec2[] arrayOfVec2 = this.m_vertices;
      if (i >= arrayOfVec2.length) {
        break;
      }
      arrayOfVec2[i] = new Vec2();
      i += 1;
    }
    this.m_buffer = new Vec2[2];
    this.m_count = 0;
    this.m_radius = 0.0F;
  }
  
  public final int getSupport(Vec2 paramVec2)
  {
    Vec2[] arrayOfVec2 = this.m_vertices;
    int j = 0;
    float f1 = Vec2.dot(arrayOfVec2[0], paramVec2);
    int i = 1;
    while (i < this.m_count)
    {
      float f3 = Vec2.dot(this.m_vertices[i], paramVec2);
      float f2 = f1;
      if (f3 > f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
      f1 = f2;
    }
    return j;
  }
  
  public final Vec2 getSupportVertex(Vec2 paramVec2)
  {
    Vec2[] arrayOfVec2 = this.m_vertices;
    int j = 0;
    float f1 = Vec2.dot(arrayOfVec2[0], paramVec2);
    int i = 1;
    while (i < this.m_count)
    {
      float f3 = Vec2.dot(this.m_vertices[i], paramVec2);
      float f2 = f1;
      if (f3 > f1)
      {
        j = i;
        f2 = f3;
      }
      i += 1;
      f1 = f2;
    }
    return this.m_vertices[j];
  }
  
  public final Vec2 getVertex(int paramInt)
  {
    return this.m_vertices[paramInt];
  }
  
  public final int getVertexCount()
  {
    return this.m_count;
  }
  
  public final void set(Shape paramShape, int paramInt)
  {
    int j = Distance.1.$SwitchMap$org$jbox2d$collision$shapes$ShapeType[paramShape.getType().ordinal()];
    int i = 0;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            return;
          }
          paramShape = (EdgeShape)paramShape;
          this.m_vertices[0].set(paramShape.m_vertex1);
          this.m_vertices[1].set(paramShape.m_vertex2);
          this.m_count = 2;
          this.m_radius = paramShape.m_radius;
          return;
        }
        paramShape = (ChainShape)paramShape;
        this.m_buffer[0] = paramShape.m_vertices[paramInt];
        paramInt += 1;
        if (paramInt < paramShape.m_count) {
          this.m_buffer[1] = paramShape.m_vertices[paramInt];
        } else {
          this.m_buffer[1] = paramShape.m_vertices[0];
        }
        this.m_vertices[0].set(this.m_buffer[0]);
        this.m_vertices[1].set(this.m_buffer[1]);
        this.m_count = 2;
        this.m_radius = paramShape.m_radius;
        return;
      }
      paramShape = (PolygonShape)paramShape;
      this.m_count = paramShape.m_count;
      this.m_radius = paramShape.m_radius;
      paramInt = i;
      while (paramInt < this.m_count)
      {
        this.m_vertices[paramInt].set(paramShape.m_vertices[paramInt]);
        paramInt += 1;
      }
    }
    paramShape = (CircleShape)paramShape;
    this.m_vertices[0].set(paramShape.m_p);
    this.m_count = 1;
    this.m_radius = paramShape.m_radius;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Distance.DistanceProxy
 * JD-Core Version:    0.7.0.1
 */