package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public class ChainShape
  extends Shape
{
  public int m_count = 0;
  public boolean m_hasNextVertex = false;
  public boolean m_hasPrevVertex = false;
  public final Vec2 m_nextVertex = new Vec2();
  public final Vec2 m_prevVertex = new Vec2();
  public Vec2[] m_vertices = null;
  private final EdgeShape pool0 = new EdgeShape();
  
  public ChainShape()
  {
    super(ShapeType.CHAIN);
    this.m_radius = 0.01F;
  }
  
  public Shape clone()
  {
    ChainShape localChainShape = new ChainShape();
    localChainShape.createChain(this.m_vertices, this.m_count);
    localChainShape.m_prevVertex.set(this.m_prevVertex);
    localChainShape.m_nextVertex.set(this.m_nextVertex);
    localChainShape.m_hasPrevVertex = this.m_hasPrevVertex;
    localChainShape.m_hasNextVertex = this.m_hasNextVertex;
    return localChainShape;
  }
  
  public void computeAABB(AABB paramAABB, Transform paramTransform, int paramInt)
  {
    Vec2 localVec2 = paramAABB.lowerBound;
    paramAABB = paramAABB.upperBound;
    int j = paramInt + 1;
    int i = j;
    if (j == this.m_count) {
      i = 0;
    }
    Object localObject2 = this.m_vertices;
    Object localObject1 = localObject2[paramInt];
    localObject2 = localObject2[i];
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    float f2 = localRot.c * localObject1.x - localRot.s * localObject1.y + paramTransform.x;
    float f1 = localRot.s * localObject1.x + localRot.c * localObject1.y + paramTransform.y;
    float f3 = localRot.c * ((Vec2)localObject2).x - localRot.s * ((Vec2)localObject2).y + paramTransform.x;
    float f4 = localRot.s;
    float f5 = ((Vec2)localObject2).x;
    float f6 = localRot.c;
    float f7 = ((Vec2)localObject2).y;
    f4 = paramTransform.y + (f4 * f5 + f6 * f7);
    if (f2 < f3) {
      f5 = f2;
    } else {
      f5 = f3;
    }
    localVec2.x = f5;
    if (f1 < f4) {
      f5 = f1;
    } else {
      f5 = f4;
    }
    localVec2.y = f5;
    f5 = f3;
    if (f2 > f3) {
      f5 = f2;
    }
    paramAABB.x = f5;
    f2 = f4;
    if (f1 > f4) {
      f2 = f1;
    }
    paramAABB.y = f2;
  }
  
  public void computeMass(MassData paramMassData, float paramFloat)
  {
    paramMassData.mass = 0.0F;
    paramMassData.center.setZero();
    paramMassData.I = 0.0F;
  }
  
  public void createChain(Vec2[] paramArrayOfVec2, int paramInt)
  {
    this.m_count = paramInt;
    this.m_vertices = new Vec2[this.m_count];
    paramInt = 1;
    while (paramInt < this.m_count) {
      if (MathUtils.distanceSquared(paramArrayOfVec2[(paramInt - 1)], paramArrayOfVec2[paramInt]) >= 2.5E-005F) {
        paramInt += 1;
      } else {
        throw new RuntimeException("Vertices of chain shape are too close together");
      }
    }
    paramInt = 0;
    while (paramInt < this.m_count)
    {
      this.m_vertices[paramInt] = new Vec2(paramArrayOfVec2[paramInt]);
      paramInt += 1;
    }
    this.m_hasPrevVertex = false;
    this.m_hasNextVertex = false;
  }
  
  public void createLoop(Vec2[] paramArrayOfVec2, int paramInt)
  {
    this.m_count = (paramInt + 1);
    this.m_vertices = new Vec2[this.m_count];
    int i = 1;
    while (i < paramInt) {
      if (MathUtils.distanceSquared(paramArrayOfVec2[(i - 1)], paramArrayOfVec2[i]) >= 2.5E-005F) {
        i += 1;
      } else {
        throw new RuntimeException("Vertices of chain shape are too close together");
      }
    }
    i = 0;
    while (i < paramInt)
    {
      this.m_vertices[i] = new Vec2(paramArrayOfVec2[i]);
      i += 1;
    }
    paramArrayOfVec2 = this.m_vertices;
    paramArrayOfVec2[paramInt] = new Vec2(paramArrayOfVec2[0]);
    this.m_prevVertex.set(this.m_vertices[(this.m_count - 2)]);
    this.m_nextVertex.set(this.m_vertices[1]);
    this.m_hasPrevVertex = true;
    this.m_hasNextVertex = true;
  }
  
  public int getChildCount()
  {
    return this.m_count - 1;
  }
  
  public void getChildEdge(EdgeShape paramEdgeShape, int paramInt)
  {
    paramEdgeShape.m_radius = this.m_radius;
    Object localObject = this.m_vertices;
    Vec2 localVec2 = localObject[(paramInt + 0)];
    localObject = localObject[(paramInt + 1)];
    paramEdgeShape.m_vertex1.x = localVec2.x;
    paramEdgeShape.m_vertex1.y = localVec2.y;
    paramEdgeShape.m_vertex2.x = ((Vec2)localObject).x;
    paramEdgeShape.m_vertex2.y = ((Vec2)localObject).y;
    if (paramInt > 0)
    {
      localVec2 = this.m_vertices[(paramInt - 1)];
      paramEdgeShape.m_vertex0.x = localVec2.x;
      paramEdgeShape.m_vertex0.y = localVec2.y;
      paramEdgeShape.m_hasVertex0 = true;
    }
    else
    {
      paramEdgeShape.m_vertex0.x = this.m_prevVertex.x;
      paramEdgeShape.m_vertex0.y = this.m_prevVertex.y;
      paramEdgeShape.m_hasVertex0 = this.m_hasPrevVertex;
    }
    if (paramInt < this.m_count - 2)
    {
      localVec2 = this.m_vertices[(paramInt + 2)];
      paramEdgeShape.m_vertex3.x = localVec2.x;
      paramEdgeShape.m_vertex3.y = localVec2.y;
      paramEdgeShape.m_hasVertex3 = true;
      return;
    }
    paramEdgeShape.m_vertex3.x = this.m_nextVertex.x;
    paramEdgeShape.m_vertex3.y = this.m_nextVertex.y;
    paramEdgeShape.m_hasVertex3 = this.m_hasNextVertex;
  }
  
  public boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, Transform paramTransform, int paramInt)
  {
    EdgeShape localEdgeShape = this.pool0;
    int j = paramInt + 1;
    int i = j;
    if (j == this.m_count) {
      i = 0;
    }
    Vec2 localVec2 = this.m_vertices[paramInt];
    localEdgeShape.m_vertex1.x = localVec2.x;
    localEdgeShape.m_vertex1.y = localVec2.y;
    localVec2 = this.m_vertices[i];
    localEdgeShape.m_vertex2.x = localVec2.x;
    localEdgeShape.m_vertex2.y = localVec2.y;
    return localEdgeShape.raycast(paramRayCastOutput, paramRayCastInput, paramTransform, 0);
  }
  
  public void setNextVertex(Vec2 paramVec2)
  {
    this.m_nextVertex.set(paramVec2);
    this.m_hasNextVertex = true;
  }
  
  public void setPrevVertex(Vec2 paramVec2)
  {
    this.m_prevVertex.set(paramVec2);
    this.m_hasPrevVertex = true;
  }
  
  public boolean testPoint(Transform paramTransform, Vec2 paramVec2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.shapes.ChainShape
 * JD-Core Version:    0.7.0.1
 */