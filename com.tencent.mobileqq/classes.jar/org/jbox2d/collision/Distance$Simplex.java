package org.jbox2d.collision;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

class Distance$Simplex
{
  private final Vec2 case2 = new Vec2();
  private final Vec2 case22 = new Vec2();
  private final Vec2 case3 = new Vec2();
  private final Vec2 case33 = new Vec2();
  private final Vec2 e12 = new Vec2();
  private final Vec2 e13 = new Vec2();
  private final Vec2 e23 = new Vec2();
  public int m_count;
  public final Distance.SimplexVertex m_v1 = new Distance.SimplexVertex(this.this$0, null);
  public final Distance.SimplexVertex m_v2 = new Distance.SimplexVertex(this.this$0, null);
  public final Distance.SimplexVertex m_v3 = new Distance.SimplexVertex(this.this$0, null);
  public final Distance.SimplexVertex[] vertices = { this.m_v1, this.m_v2, this.m_v3 };
  private final Vec2 w1 = new Vec2();
  private final Vec2 w2 = new Vec2();
  private final Vec2 w3 = new Vec2();
  
  private Distance$Simplex(Distance paramDistance) {}
  
  public void getClosestPoint(Vec2 paramVec2)
  {
    int i = this.m_count;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            paramVec2.setZero();
            return;
          }
          paramVec2.setZero();
          return;
        }
        this.case22.set(this.m_v2.w).mulLocal(this.m_v2.a);
        this.case2.set(this.m_v1.w).mulLocal(this.m_v1.a).addLocal(this.case22);
        paramVec2.set(this.case2);
        return;
      }
      paramVec2.set(this.m_v1.w);
      return;
    }
    paramVec2.setZero();
  }
  
  public float getMetric()
  {
    int i = this.m_count;
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if (i != 3) {
          return 0.0F;
        }
        this.case3.set(this.m_v2.w).subLocal(this.m_v1.w);
        this.case33.set(this.m_v3.w).subLocal(this.m_v1.w);
        return Vec2.cross(this.case3, this.case33);
      }
      return MathUtils.distance(this.m_v1.w, this.m_v2.w);
    }
    return 0.0F;
  }
  
  public final void getSearchDirection(Vec2 paramVec2)
  {
    int i = this.m_count;
    if (i != 1)
    {
      if (i != 2)
      {
        paramVec2.setZero();
        return;
      }
      this.e12.set(this.m_v2.w).subLocal(this.m_v1.w);
      paramVec2.set(this.m_v1.w).negateLocal();
      if (Vec2.cross(this.e12, paramVec2) > 0.0F)
      {
        Vec2.crossToOutUnsafe(1.0F, this.e12, paramVec2);
        return;
      }
      Vec2.crossToOutUnsafe(this.e12, 1.0F, paramVec2);
      return;
    }
    paramVec2.set(this.m_v1.w).negateLocal();
  }
  
  public void getWitnessPoints(Vec2 paramVec21, Vec2 paramVec22)
  {
    int i = this.m_count;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          paramVec21.set(this.m_v1.wA).mulLocal(this.m_v1.a);
          this.case3.set(this.m_v2.wA).mulLocal(this.m_v2.a);
          this.case33.set(this.m_v3.wA).mulLocal(this.m_v3.a);
          paramVec21.addLocal(this.case3).addLocal(this.case33);
          paramVec22.set(paramVec21);
          return;
        }
        this.case2.set(this.m_v1.wA).mulLocal(this.m_v1.a);
        paramVec21.set(this.m_v2.wA).mulLocal(this.m_v2.a).addLocal(this.case2);
        this.case2.set(this.m_v1.wB).mulLocal(this.m_v1.a);
        paramVec22.set(this.m_v2.wB).mulLocal(this.m_v2.a).addLocal(this.case2);
        return;
      }
      paramVec21.set(this.m_v1.wA);
      paramVec22.set(this.m_v1.wB);
    }
  }
  
  public void readCache(Distance.SimplexCache paramSimplexCache, Distance.DistanceProxy paramDistanceProxy1, Transform paramTransform1, Distance.DistanceProxy paramDistanceProxy2, Transform paramTransform2)
  {
    this.m_count = paramSimplexCache.count;
    int i = 0;
    int j;
    for (;;)
    {
      j = this.m_count;
      if (i >= j) {
        break;
      }
      Distance.SimplexVertex localSimplexVertex = this.vertices[i];
      localSimplexVertex.indexA = paramSimplexCache.indexA[i];
      localSimplexVertex.indexB = paramSimplexCache.indexB[i];
      Vec2 localVec21 = paramDistanceProxy1.getVertex(localSimplexVertex.indexA);
      Vec2 localVec22 = paramDistanceProxy2.getVertex(localSimplexVertex.indexB);
      Transform.mulToOutUnsafe(paramTransform1, localVec21, localSimplexVertex.wA);
      Transform.mulToOutUnsafe(paramTransform2, localVec22, localSimplexVertex.wB);
      localSimplexVertex.w.set(localSimplexVertex.wB).subLocal(localSimplexVertex.wA);
      localSimplexVertex.a = 0.0F;
      i += 1;
    }
    if (j > 1)
    {
      float f1 = paramSimplexCache.metric;
      float f2 = getMetric();
      if ((f2 < 0.5F * f1) || (f1 * 2.0F < f2) || (f2 < 1.192093E-007F)) {
        this.m_count = 0;
      }
    }
    if (this.m_count == 0)
    {
      paramSimplexCache = this.vertices[0];
      paramSimplexCache.indexA = 0;
      paramSimplexCache.indexB = 0;
      paramDistanceProxy1 = paramDistanceProxy1.getVertex(0);
      paramDistanceProxy2 = paramDistanceProxy2.getVertex(0);
      Transform.mulToOutUnsafe(paramTransform1, paramDistanceProxy1, paramSimplexCache.wA);
      Transform.mulToOutUnsafe(paramTransform2, paramDistanceProxy2, paramSimplexCache.wB);
      paramSimplexCache.w.set(paramSimplexCache.wB).subLocal(paramSimplexCache.wA);
      this.m_count = 1;
    }
  }
  
  public void solve2()
  {
    Object localObject = this.m_v1.w;
    Vec2 localVec2 = this.m_v2.w;
    this.e12.set(localVec2).subLocal((Vec2)localObject);
    float f1 = -Vec2.dot((Vec2)localObject, this.e12);
    if (f1 <= 0.0F)
    {
      this.m_v1.a = 1.0F;
      this.m_count = 1;
      return;
    }
    float f2 = Vec2.dot(localVec2, this.e12);
    if (f2 <= 0.0F)
    {
      localObject = this.m_v2;
      ((Distance.SimplexVertex)localObject).a = 1.0F;
      this.m_count = 1;
      this.m_v1.set((Distance.SimplexVertex)localObject);
      return;
    }
    float f3 = 1.0F / (f2 + f1);
    this.m_v1.a = (f2 * f3);
    this.m_v2.a = (f1 * f3);
    this.m_count = 2;
  }
  
  public void solve3()
  {
    this.w1.set(this.m_v1.w);
    this.w2.set(this.m_v2.w);
    this.w3.set(this.m_v3.w);
    this.e12.set(this.w2).subLocal(this.w1);
    float f2 = Vec2.dot(this.w1, this.e12);
    float f1 = Vec2.dot(this.w2, this.e12);
    f2 = -f2;
    this.e13.set(this.w3).subLocal(this.w1);
    float f4 = Vec2.dot(this.w1, this.e13);
    float f3 = Vec2.dot(this.w3, this.e13);
    f4 = -f4;
    this.e23.set(this.w3).subLocal(this.w2);
    float f6 = Vec2.dot(this.w2, this.e23);
    float f5 = Vec2.dot(this.w3, this.e23);
    f6 = -f6;
    float f9 = Vec2.cross(this.e12, this.e13);
    float f7 = Vec2.cross(this.w2, this.w3) * f9;
    float f8 = Vec2.cross(this.w3, this.w1) * f9;
    f9 *= Vec2.cross(this.w1, this.w2);
    if ((f2 <= 0.0F) && (f4 <= 0.0F))
    {
      this.m_v1.a = 1.0F;
      this.m_count = 1;
      return;
    }
    if ((f1 > 0.0F) && (f2 > 0.0F) && (f9 <= 0.0F))
    {
      f3 = 1.0F / (f1 + f2);
      this.m_v1.a = (f1 * f3);
      this.m_v2.a = (f2 * f3);
      this.m_count = 2;
      return;
    }
    Distance.SimplexVertex localSimplexVertex;
    if ((f3 > 0.0F) && (f4 > 0.0F) && (f8 <= 0.0F))
    {
      f1 = 1.0F / (f3 + f4);
      this.m_v1.a = (f3 * f1);
      localSimplexVertex = this.m_v3;
      localSimplexVertex.a = (f4 * f1);
      this.m_count = 2;
      this.m_v2.set(localSimplexVertex);
      return;
    }
    if ((f1 <= 0.0F) && (f6 <= 0.0F))
    {
      localSimplexVertex = this.m_v2;
      localSimplexVertex.a = 1.0F;
      this.m_count = 1;
      this.m_v1.set(localSimplexVertex);
      return;
    }
    if ((f3 <= 0.0F) && (f5 <= 0.0F))
    {
      localSimplexVertex = this.m_v3;
      localSimplexVertex.a = 1.0F;
      this.m_count = 1;
      this.m_v1.set(localSimplexVertex);
      return;
    }
    if ((f5 > 0.0F) && (f6 > 0.0F) && (f7 <= 0.0F))
    {
      f1 = 1.0F / (f5 + f6);
      this.m_v2.a = (f5 * f1);
      localSimplexVertex = this.m_v3;
      localSimplexVertex.a = (f6 * f1);
      this.m_count = 2;
      this.m_v1.set(localSimplexVertex);
      return;
    }
    f1 = 1.0F / (f7 + f8 + f9);
    this.m_v1.a = (f7 * f1);
    this.m_v2.a = (f8 * f1);
    this.m_v3.a = (f9 * f1);
    this.m_count = 3;
  }
  
  public void writeCache(Distance.SimplexCache paramSimplexCache)
  {
    paramSimplexCache.metric = getMetric();
    paramSimplexCache.count = this.m_count;
    int i = 0;
    while (i < this.m_count)
    {
      paramSimplexCache.indexA[i] = this.vertices[i].indexA;
      paramSimplexCache.indexB[i] = this.vertices[i].indexB;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Distance.Simplex
 * JD-Core Version:    0.7.0.1
 */