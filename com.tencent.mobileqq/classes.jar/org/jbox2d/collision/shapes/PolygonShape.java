package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.arrays.IntArray;
import org.jbox2d.pooling.arrays.Vec2Array;

public class PolygonShape
  extends Shape
{
  private static final boolean m_debug = false;
  public final Vec2 m_centroid = new Vec2();
  public int m_count;
  public final Vec2[] m_normals;
  public final Vec2[] m_vertices;
  private final Vec2 pool1 = new Vec2();
  private final Vec2 pool2 = new Vec2();
  private final Vec2 pool3 = new Vec2();
  private final Vec2 pool4 = new Vec2();
  private Transform poolt1 = new Transform();
  
  public PolygonShape()
  {
    super(ShapeType.POLYGON);
    int j = 0;
    this.m_count = 0;
    this.m_vertices = new Vec2[8];
    int i = 0;
    Vec2[] arrayOfVec2;
    for (;;)
    {
      arrayOfVec2 = this.m_vertices;
      if (i >= arrayOfVec2.length) {
        break;
      }
      arrayOfVec2[i] = new Vec2();
      i += 1;
    }
    this.m_normals = new Vec2[8];
    i = j;
    for (;;)
    {
      arrayOfVec2 = this.m_normals;
      if (i >= arrayOfVec2.length) {
        break;
      }
      arrayOfVec2[i] = new Vec2();
      i += 1;
    }
    setRadius(0.01F);
    this.m_centroid.setZero();
  }
  
  public Vec2 centroid(Transform paramTransform)
  {
    return Transform.mul(paramTransform, this.m_centroid);
  }
  
  public Vec2 centroidToOut(Transform paramTransform, Vec2 paramVec2)
  {
    Transform.mulToOutUnsafe(paramTransform, this.m_centroid, paramVec2);
    return paramVec2;
  }
  
  public final Shape clone()
  {
    PolygonShape localPolygonShape = new PolygonShape();
    localPolygonShape.m_centroid.set(this.m_centroid);
    int i = 0;
    for (;;)
    {
      Vec2[] arrayOfVec2 = localPolygonShape.m_normals;
      if (i >= arrayOfVec2.length) {
        break;
      }
      arrayOfVec2[i].set(this.m_normals[i]);
      localPolygonShape.m_vertices[i].set(this.m_vertices[i]);
      i += 1;
    }
    localPolygonShape.setRadius(getRadius());
    localPolygonShape.m_count = this.m_count;
    return localPolygonShape;
  }
  
  public final void computeAABB(AABB paramAABB, Transform paramTransform, int paramInt)
  {
    Vec2 localVec21 = paramAABB.lowerBound;
    paramAABB = paramAABB.upperBound;
    Vec2 localVec22 = this.m_vertices[0];
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    localVec21.x = (localRot.c * localVec22.x - localRot.s * localVec22.y + paramTransform.x);
    localVec21.y = (localRot.s * localVec22.x + localRot.c * localVec22.y + paramTransform.y);
    paramAABB.x = localVec21.x;
    paramAABB.y = localVec21.y;
    paramInt = 1;
    while (paramInt < this.m_count)
    {
      localVec22 = this.m_vertices[paramInt];
      float f2 = localRot.c * localVec22.x - localRot.s * localVec22.y + paramTransform.x;
      float f1 = localRot.s * localVec22.x + localRot.c * localVec22.y + paramTransform.y;
      if (localVec21.x < f2) {
        f3 = localVec21.x;
      } else {
        f3 = f2;
      }
      localVec21.x = f3;
      if (localVec21.y < f1) {
        f3 = localVec21.y;
      } else {
        f3 = f1;
      }
      localVec21.y = f3;
      float f3 = f2;
      if (paramAABB.x > f2) {
        f3 = paramAABB.x;
      }
      paramAABB.x = f3;
      f2 = f1;
      if (paramAABB.y > f1) {
        f2 = paramAABB.y;
      }
      paramAABB.y = f2;
      paramInt += 1;
    }
    localVec21.x -= this.m_radius;
    localVec21.y -= this.m_radius;
    paramAABB.x += this.m_radius;
    paramAABB.y += this.m_radius;
  }
  
  public final void computeCentroidToOut(Vec2[] paramArrayOfVec2, int paramInt, Vec2 paramVec2)
  {
    paramVec2.set(0.0F, 0.0F);
    Vec2 localVec22 = this.pool1;
    localVec22.setZero();
    Vec2 localVec23 = this.pool2;
    Vec2 localVec24 = this.pool3;
    int i = 0;
    float f1 = 0.0F;
    while (i < paramInt)
    {
      Vec2 localVec25 = paramArrayOfVec2[i];
      i += 1;
      Vec2 localVec21;
      if (i < paramInt) {
        localVec21 = paramArrayOfVec2[i];
      } else {
        localVec21 = paramArrayOfVec2[0];
      }
      localVec23.set(localVec25).subLocal(localVec22);
      localVec24.set(localVec21).subLocal(localVec22);
      float f2 = Vec2.cross(localVec23, localVec24) * 0.5F;
      f1 += f2;
      localVec23.set(localVec22).addLocal(localVec25).addLocal(localVec21).mulLocal(f2 * 0.3333333F);
      paramVec2.addLocal(localVec23);
    }
    paramVec2.mulLocal(1.0F / f1);
  }
  
  public void computeMass(MassData paramMassData, float paramFloat)
  {
    Vec2 localVec22 = this.pool1;
    localVec22.setZero();
    Vec2 localVec23 = this.pool2;
    localVec23.setZero();
    int i = 0;
    int j;
    for (;;)
    {
      j = this.m_count;
      if (i >= j) {
        break;
      }
      localVec23.addLocal(this.m_vertices[i]);
      i += 1;
    }
    localVec23.mulLocal(1.0F / j);
    Vec2 localVec24 = this.pool3;
    Vec2 localVec25 = this.pool4;
    i = 0;
    float f2 = 0.0F;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    for (float f1 = 0.0F; i < this.m_count; f1 += f3 * 0.08333334F * (f4 * f4 + f4 * f6 + f6 * f6 + (f5 * f5 + f5 * f7 + f7 * f7)))
    {
      localVec24.set(this.m_vertices[i]).subLocal(localVec23);
      Vec2 localVec26 = localVec25.set(localVec23).negateLocal();
      i += 1;
      Vec2 localVec21;
      if (i < this.m_count) {
        localVec21 = this.m_vertices[i];
      } else {
        localVec21 = this.m_vertices[0];
      }
      localVec26.addLocal(localVec21);
      f3 = Vec2.cross(localVec24, localVec25);
      f4 = 0.5F * f3;
      f2 += f4;
      f5 = localVec22.x;
      f4 *= 0.3333333F;
      localVec22.x = (f5 + (localVec24.x + localVec25.x) * f4);
      localVec22.y += f4 * (localVec24.y + localVec25.y);
      f4 = localVec24.x;
      f5 = localVec24.y;
      f6 = localVec25.x;
      f7 = localVec25.y;
    }
    paramMassData.mass = (paramFloat * f2);
    localVec22.mulLocal(1.0F / f2);
    paramMassData.center.set(localVec22).addLocal(localVec23);
    paramMassData.I = (f1 * paramFloat);
    paramMassData.I += paramMassData.mass * Vec2.dot(paramMassData.center, paramMassData.center);
  }
  
  public int getChildCount()
  {
    return 1;
  }
  
  public Vec2[] getNormals()
  {
    return this.m_normals;
  }
  
  public final Vec2 getVertex(int paramInt)
  {
    return this.m_vertices[paramInt];
  }
  
  public final int getVertexCount()
  {
    return this.m_count;
  }
  
  public Vec2[] getVertices()
  {
    return this.m_vertices;
  }
  
  public final boolean raycast(RayCastOutput paramRayCastOutput, RayCastInput paramRayCastInput, Transform paramTransform, int paramInt)
  {
    Rot localRot = paramTransform.q;
    paramTransform = paramTransform.p;
    float f1 = paramRayCastInput.p1.x - paramTransform.x;
    float f2 = paramRayCastInput.p1.y - paramTransform.y;
    float f5 = localRot.c * f1 + localRot.s * f2;
    float f6 = -localRot.s * f1 + localRot.c * f2;
    float f7 = paramRayCastInput.p2.x - paramTransform.x;
    float f8 = paramRayCastInput.p2.y - paramTransform.y;
    float f9 = localRot.c;
    float f10 = localRot.s;
    float f11 = -localRot.s;
    float f12 = localRot.c;
    f1 = paramRayCastInput.maxFraction;
    paramInt = 0;
    f2 = 0.0F;
    int i = -1;
    while (paramInt < this.m_count)
    {
      paramRayCastInput = this.m_normals[paramInt];
      paramTransform = this.m_vertices[paramInt];
      float f3 = paramTransform.x;
      float f4 = paramTransform.y;
      float f13 = paramRayCastInput.x * (f3 - f5) + paramRayCastInput.y * (f4 - f6);
      float f14 = paramRayCastInput.x * (f9 * f7 + f10 * f8 - f5) + paramRayCastInput.y * (f11 * f7 + f12 * f8 - f6);
      int j;
      if (f14 == 0.0F)
      {
        f3 = f2;
        j = i;
        f4 = f1;
        if (f13 < 0.0F) {
          return false;
        }
      }
      else if ((f14 < 0.0F) && (f13 < f2 * f14))
      {
        f3 = f13 / f14;
        j = paramInt;
        f4 = f1;
      }
      else
      {
        f3 = f2;
        j = i;
        f4 = f1;
        if (f14 > 0.0F)
        {
          f3 = f2;
          j = i;
          f4 = f1;
          if (f13 < f1 * f14)
          {
            f4 = f13 / f14;
            j = i;
            f3 = f2;
          }
        }
      }
      if (f4 < f3) {
        return false;
      }
      paramInt += 1;
      f2 = f3;
      i = j;
      f1 = f4;
    }
    if (i >= 0)
    {
      paramRayCastOutput.fraction = f2;
      paramRayCastInput = this.m_normals[i];
      paramRayCastOutput = paramRayCastOutput.normal;
      paramRayCastOutput.x = (localRot.c * paramRayCastInput.x - localRot.s * paramRayCastInput.y);
      paramRayCastOutput.y = (localRot.s * paramRayCastInput.x + localRot.c * paramRayCastInput.y);
      return true;
    }
    return false;
  }
  
  public final void set(Vec2[] paramArrayOfVec2, int paramInt)
  {
    set(paramArrayOfVec2, paramInt, null, null);
  }
  
  public final void set(Vec2[] paramArrayOfVec2, int paramInt, Vec2Array paramVec2Array, IntArray paramIntArray)
  {
    if (paramInt < 3)
    {
      setAsBox(1.0F, 1.0F);
      return;
    }
    int i1 = MathUtils.min(paramInt, 8);
    if (paramVec2Array != null) {
      paramVec2Array = paramVec2Array.get(i1);
    } else {
      paramVec2Array = new Vec2[i1];
    }
    int i = 0;
    while (i < i1)
    {
      paramVec2Array[i] = paramArrayOfVec2[i];
      i += 1;
    }
    float f1 = paramVec2Array[0].x;
    i = 1;
    int k;
    for (int j = 0; i < paramInt; j = k)
    {
      float f3 = paramVec2Array[i].x;
      float f2;
      if (f3 <= f1)
      {
        f2 = f1;
        k = j;
        if (f3 == f1)
        {
          f2 = f1;
          k = j;
          if (paramVec2Array[i].y >= paramVec2Array[j].y) {}
        }
      }
      else
      {
        k = i;
        f2 = f3;
      }
      i += 1;
      f1 = f2;
    }
    if (paramIntArray != null) {
      paramArrayOfVec2 = paramIntArray.get(8);
    } else {
      paramArrayOfVec2 = new int[8];
    }
    int n = j;
    int m = 0;
    for (;;)
    {
      paramArrayOfVec2[m] = n;
      paramInt = 1;
      i = 0;
      while (paramInt < i1)
      {
        if (i != n)
        {
          paramIntArray = this.pool1.set(paramVec2Array[i]).subLocal(paramVec2Array[paramArrayOfVec2[m]]);
          Vec2 localVec2 = this.pool2.set(paramVec2Array[paramInt]).subLocal(paramVec2Array[paramArrayOfVec2[m]]);
          f1 = Vec2.cross(paramIntArray, localVec2);
          k = i;
          if (f1 < 0.0F) {
            k = paramInt;
          }
          i = k;
          if (f1 == 0.0F)
          {
            i = k;
            if (localVec2.lengthSquared() <= paramIntArray.lengthSquared()) {}
          }
        }
        else
        {
          i = paramInt;
        }
        paramInt += 1;
      }
      m += 1;
      if (i == j)
      {
        this.m_count = m;
        paramInt = 0;
        while (paramInt < this.m_count)
        {
          paramIntArray = this.m_vertices;
          if (paramIntArray[paramInt] == null) {
            paramIntArray[paramInt] = new Vec2();
          }
          this.m_vertices[paramInt].set(paramVec2Array[paramArrayOfVec2[paramInt]]);
          paramInt += 1;
        }
        paramArrayOfVec2 = this.pool1;
        for (paramInt = 0;; paramInt = i)
        {
          j = this.m_count;
          if (paramInt >= j) {
            break;
          }
          i = paramInt + 1;
          if (i < j) {
            j = i;
          } else {
            j = 0;
          }
          paramArrayOfVec2.set(this.m_vertices[j]).subLocal(this.m_vertices[paramInt]);
          Vec2.crossToOutUnsafe(paramArrayOfVec2, 1.0F, this.m_normals[paramInt]);
          this.m_normals[paramInt].normalize();
        }
        computeCentroidToOut(this.m_vertices, j, this.m_centroid);
        return;
      }
      n = i;
    }
  }
  
  public final void setAsBox(float paramFloat1, float paramFloat2)
  {
    this.m_count = 4;
    Vec2 localVec2 = this.m_vertices[0];
    float f1 = -paramFloat1;
    float f2 = -paramFloat2;
    localVec2.set(f1, f2);
    this.m_vertices[1].set(paramFloat1, f2);
    this.m_vertices[2].set(paramFloat1, paramFloat2);
    this.m_vertices[3].set(f1, paramFloat2);
    this.m_normals[0].set(0.0F, -1.0F);
    this.m_normals[1].set(1.0F, 0.0F);
    this.m_normals[2].set(0.0F, 1.0F);
    this.m_normals[3].set(-1.0F, 0.0F);
    this.m_centroid.setZero();
  }
  
  public final void setAsBox(float paramFloat1, float paramFloat2, Vec2 paramVec2, float paramFloat3)
  {
    this.m_count = 4;
    Object localObject = this.m_vertices;
    int i = 0;
    localObject = localObject[0];
    float f1 = -paramFloat1;
    float f2 = -paramFloat2;
    ((Vec2)localObject).set(f1, f2);
    this.m_vertices[1].set(paramFloat1, f2);
    this.m_vertices[2].set(paramFloat1, paramFloat2);
    this.m_vertices[3].set(f1, paramFloat2);
    this.m_normals[0].set(0.0F, -1.0F);
    this.m_normals[1].set(1.0F, 0.0F);
    this.m_normals[2].set(0.0F, 1.0F);
    this.m_normals[3].set(-1.0F, 0.0F);
    this.m_centroid.set(paramVec2);
    localObject = this.poolt1;
    ((Transform)localObject).p.set(paramVec2);
    ((Transform)localObject).q.set(paramFloat3);
    while (i < this.m_count)
    {
      paramVec2 = this.m_vertices;
      Transform.mulToOut((Transform)localObject, paramVec2[i], paramVec2[i]);
      paramVec2 = ((Transform)localObject).q;
      Vec2[] arrayOfVec2 = this.m_normals;
      Rot.mulToOut(paramVec2, arrayOfVec2[i], arrayOfVec2[i]);
      i += 1;
    }
  }
  
  public final boolean testPoint(Transform paramTransform, Vec2 paramVec2)
  {
    Rot localRot = paramTransform.q;
    float f1 = paramVec2.x - paramTransform.p.x;
    float f2 = paramVec2.y - paramTransform.p.y;
    float f3 = localRot.c;
    float f4 = localRot.s;
    float f5 = -localRot.s;
    float f6 = localRot.c;
    int i = 0;
    while (i < this.m_count)
    {
      paramTransform = this.m_vertices[i];
      paramVec2 = this.m_normals[i];
      float f7 = paramTransform.x;
      float f8 = paramTransform.y;
      if (paramVec2.x * (f3 * f1 + f4 * f2 - f7) + paramVec2.y * (f5 * f1 + f6 * f2 - f8) > 0.0F) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean validate()
  {
    int i = 0;
    for (;;)
    {
      int j = this.m_count;
      if (i >= j) {
        break;
      }
      if (i < j - 1) {
        j = i + 1;
      } else {
        j = 0;
      }
      Object localObject = this.m_vertices;
      Vec2 localVec2 = localObject[i];
      localObject = this.pool1.set(localObject[j]).subLocal(localVec2);
      int k = 0;
      while (k < this.m_count)
      {
        if ((k != i) && (k != j) && (Vec2.cross((Vec2)localObject, this.pool2.set(this.m_vertices[k]).subLocal(localVec2)) < 0.0F)) {
          return false;
        }
        k += 1;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.shapes.PolygonShape
 * JD-Core Version:    0.7.0.1
 */