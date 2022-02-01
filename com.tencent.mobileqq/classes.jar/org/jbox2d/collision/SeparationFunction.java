package org.jbox2d.collision;

import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

class SeparationFunction
{
  private final Vec2 axisA = new Vec2();
  private final Vec2 axisB = new Vec2();
  private final Vec2 localPointA = new Vec2();
  private final Vec2 localPointA1 = new Vec2();
  private final Vec2 localPointA2 = new Vec2();
  private final Vec2 localPointB = new Vec2();
  private final Vec2 localPointB1 = new Vec2();
  private final Vec2 localPointB2 = new Vec2();
  public final Vec2 m_axis = new Vec2();
  public final Vec2 m_localPoint = new Vec2();
  public Distance.DistanceProxy m_proxyA;
  public Distance.DistanceProxy m_proxyB;
  public Sweep m_sweepA;
  public Sweep m_sweepB;
  public Type m_type;
  private final Vec2 normal = new Vec2();
  private final Vec2 pointA = new Vec2();
  private final Vec2 pointB = new Vec2();
  private final Vec2 temp = new Vec2();
  private final Transform xfa = new Transform();
  private final Transform xfb = new Transform();
  
  public float evaluate(int paramInt1, int paramInt2, float paramFloat)
  {
    this.m_sweepA.getTransform(this.xfa, paramFloat);
    this.m_sweepB.getTransform(this.xfb, paramFloat);
    int i = SeparationFunction.1.$SwitchMap$org$jbox2d$collision$Type[this.m_type.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 0.0F;
        }
        Rot.mulToOutUnsafe(this.xfb.q, this.m_axis, this.normal);
        Transform.mulToOutUnsafe(this.xfb, this.m_localPoint, this.pointB);
        Rot.mulTransUnsafe(this.xfa.q, this.normal.negateLocal(), this.axisA);
        this.normal.negateLocal();
        this.localPointA.set(this.m_proxyA.getVertex(paramInt1));
        Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
        return Vec2.dot(this.pointA.subLocal(this.pointB), this.normal);
      }
      Rot.mulToOutUnsafe(this.xfa.q, this.m_axis, this.normal);
      Transform.mulToOutUnsafe(this.xfa, this.m_localPoint, this.pointA);
      Rot.mulTransUnsafe(this.xfb.q, this.normal.negateLocal(), this.axisB);
      this.normal.negateLocal();
      this.localPointB.set(this.m_proxyB.getVertex(paramInt2));
      Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
      return Vec2.dot(this.pointB.subLocal(this.pointA), this.normal);
    }
    Rot.mulTransUnsafe(this.xfa.q, this.m_axis, this.axisA);
    Rot.mulTransUnsafe(this.xfb.q, this.m_axis.negateLocal(), this.axisB);
    this.m_axis.negateLocal();
    this.localPointA.set(this.m_proxyA.getVertex(paramInt1));
    this.localPointB.set(this.m_proxyB.getVertex(paramInt2));
    Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
    Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
    return Vec2.dot(this.pointB.subLocal(this.pointA), this.m_axis);
  }
  
  public float findMinSeparation(int[] paramArrayOfInt, float paramFloat)
  {
    this.m_sweepA.getTransform(this.xfa, paramFloat);
    this.m_sweepB.getTransform(this.xfb, paramFloat);
    int i = SeparationFunction.1.$SwitchMap$org$jbox2d$collision$Type[this.m_type.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          paramArrayOfInt[0] = -1;
          paramArrayOfInt[1] = -1;
          return 0.0F;
        }
        Rot.mulToOutUnsafe(this.xfb.q, this.m_axis, this.normal);
        Transform.mulToOutUnsafe(this.xfb, this.m_localPoint, this.pointB);
        Rot.mulTransUnsafe(this.xfa.q, this.normal.negateLocal(), this.axisA);
        this.normal.negateLocal();
        paramArrayOfInt[1] = -1;
        paramArrayOfInt[0] = this.m_proxyA.getSupport(this.axisA);
        this.localPointA.set(this.m_proxyA.getVertex(paramArrayOfInt[0]));
        Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
        return Vec2.dot(this.pointA.subLocal(this.pointB), this.normal);
      }
      Rot.mulToOutUnsafe(this.xfa.q, this.m_axis, this.normal);
      Transform.mulToOutUnsafe(this.xfa, this.m_localPoint, this.pointA);
      Rot.mulTransUnsafe(this.xfb.q, this.normal.negateLocal(), this.axisB);
      this.normal.negateLocal();
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = this.m_proxyB.getSupport(this.axisB);
      this.localPointB.set(this.m_proxyB.getVertex(paramArrayOfInt[1]));
      Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
      return Vec2.dot(this.pointB.subLocal(this.pointA), this.normal);
    }
    Rot.mulTransUnsafe(this.xfa.q, this.m_axis, this.axisA);
    Rot.mulTransUnsafe(this.xfb.q, this.m_axis.negateLocal(), this.axisB);
    this.m_axis.negateLocal();
    paramArrayOfInt[0] = this.m_proxyA.getSupport(this.axisA);
    paramArrayOfInt[1] = this.m_proxyB.getSupport(this.axisB);
    this.localPointA.set(this.m_proxyA.getVertex(paramArrayOfInt[0]));
    this.localPointB.set(this.m_proxyB.getVertex(paramArrayOfInt[1]));
    Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
    Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
    return Vec2.dot(this.pointB.subLocal(this.pointA), this.m_axis);
  }
  
  public float initialize(Distance.SimplexCache paramSimplexCache, Distance.DistanceProxy paramDistanceProxy1, Sweep paramSweep1, Distance.DistanceProxy paramDistanceProxy2, Sweep paramSweep2, float paramFloat)
  {
    this.m_proxyA = paramDistanceProxy1;
    this.m_proxyB = paramDistanceProxy2;
    int i = paramSimplexCache.count;
    this.m_sweepA = paramSweep1;
    this.m_sweepB = paramSweep2;
    this.m_sweepA.getTransform(this.xfa, paramFloat);
    this.m_sweepB.getTransform(this.xfb, paramFloat);
    if (i == 1)
    {
      this.m_type = Type.POINTS;
      this.localPointA.set(this.m_proxyA.getVertex(paramSimplexCache.indexA[0]));
      this.localPointB.set(this.m_proxyB.getVertex(paramSimplexCache.indexB[0]));
      Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
      Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
      this.m_axis.set(this.pointB).subLocal(this.pointA);
      return this.m_axis.normalize();
    }
    if (paramSimplexCache.indexA[0] == paramSimplexCache.indexA[1])
    {
      this.m_type = Type.FACE_B;
      this.localPointB1.set(this.m_proxyB.getVertex(paramSimplexCache.indexB[0]));
      this.localPointB2.set(this.m_proxyB.getVertex(paramSimplexCache.indexB[1]));
      this.temp.set(this.localPointB2).subLocal(this.localPointB1);
      Vec2.crossToOutUnsafe(this.temp, 1.0F, this.m_axis);
      this.m_axis.normalize();
      Rot.mulToOutUnsafe(this.xfb.q, this.m_axis, this.normal);
      this.m_localPoint.set(this.localPointB1).addLocal(this.localPointB2).mulLocal(0.5F);
      Transform.mulToOutUnsafe(this.xfb, this.m_localPoint, this.pointB);
      this.localPointA.set(paramDistanceProxy1.getVertex(paramSimplexCache.indexA[0]));
      Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
      this.temp.set(this.pointA).subLocal(this.pointB);
      f = Vec2.dot(this.temp, this.normal);
      paramFloat = f;
      if (f < 0.0F)
      {
        this.m_axis.negateLocal();
        paramFloat = -f;
      }
      return paramFloat;
    }
    this.m_type = Type.FACE_A;
    this.localPointA1.set(this.m_proxyA.getVertex(paramSimplexCache.indexA[0]));
    this.localPointA2.set(this.m_proxyA.getVertex(paramSimplexCache.indexA[1]));
    this.temp.set(this.localPointA2).subLocal(this.localPointA1);
    Vec2.crossToOutUnsafe(this.temp, 1.0F, this.m_axis);
    this.m_axis.normalize();
    Rot.mulToOutUnsafe(this.xfa.q, this.m_axis, this.normal);
    this.m_localPoint.set(this.localPointA1).addLocal(this.localPointA2).mulLocal(0.5F);
    Transform.mulToOutUnsafe(this.xfa, this.m_localPoint, this.pointA);
    this.localPointB.set(this.m_proxyB.getVertex(paramSimplexCache.indexB[0]));
    Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
    this.temp.set(this.pointB).subLocal(this.pointA);
    float f = Vec2.dot(this.temp, this.normal);
    paramFloat = f;
    if (f < 0.0F)
    {
      this.m_axis.negateLocal();
      paramFloat = -f;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.SeparationFunction
 * JD-Core Version:    0.7.0.1
 */