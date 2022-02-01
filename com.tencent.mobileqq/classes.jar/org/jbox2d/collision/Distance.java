package org.jbox2d.collision;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

public class Distance
{
  public static int GJK_CALLS = 0;
  public static int GJK_ITERS = 0;
  public static int GJK_MAX_ITERS = 20;
  private Vec2 closestPoint = new Vec2();
  private Vec2 d = new Vec2();
  private Vec2 normal = new Vec2();
  private int[] saveA = new int[3];
  private int[] saveB = new int[3];
  private Distance.Simplex simplex = new Distance.Simplex(this, null);
  private Vec2 temp = new Vec2();
  
  public final void distance(DistanceOutput paramDistanceOutput, Distance.SimplexCache paramSimplexCache, DistanceInput paramDistanceInput)
  {
    GJK_CALLS += 1;
    Distance.DistanceProxy localDistanceProxy1 = paramDistanceInput.proxyA;
    Distance.DistanceProxy localDistanceProxy2 = paramDistanceInput.proxyB;
    Transform localTransform1 = paramDistanceInput.transformA;
    Transform localTransform2 = paramDistanceInput.transformB;
    this.simplex.readCache(paramSimplexCache, localDistanceProxy1, localTransform1, localDistanceProxy2, localTransform2);
    Distance.SimplexVertex[] arrayOfSimplexVertex = this.simplex.vertices;
    this.simplex.getClosestPoint(this.closestPoint);
    this.closestPoint.lengthSquared();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= GJK_MAX_ITERS) {
        break;
      }
      int k = this.simplex.m_count;
      j = 0;
      while (j < k)
      {
        this.saveA[j] = arrayOfSimplexVertex[j].indexA;
        this.saveB[j] = arrayOfSimplexVertex[j].indexB;
        j += 1;
      }
      j = this.simplex.m_count;
      if (j != 1) {
        if (j != 2)
        {
          if (j == 3) {
            this.simplex.solve3();
          }
        }
        else {
          this.simplex.solve2();
        }
      }
      if (this.simplex.m_count == 3)
      {
        j = i;
        break;
      }
      this.simplex.getClosestPoint(this.closestPoint);
      this.closestPoint.lengthSquared();
      this.simplex.getSearchDirection(this.d);
      if (this.d.lengthSquared() < 1.421086E-014F)
      {
        j = i;
        break;
      }
      Object localObject = arrayOfSimplexVertex[this.simplex.m_count];
      Rot.mulTransUnsafe(localTransform1.q, this.d.negateLocal(), this.temp);
      ((Distance.SimplexVertex)localObject).indexA = localDistanceProxy1.getSupport(this.temp);
      Transform.mulToOutUnsafe(localTransform1, localDistanceProxy1.getVertex(((Distance.SimplexVertex)localObject).indexA), ((Distance.SimplexVertex)localObject).wA);
      Rot.mulTransUnsafe(localTransform2.q, this.d.negateLocal(), this.temp);
      ((Distance.SimplexVertex)localObject).indexB = localDistanceProxy2.getSupport(this.temp);
      Transform.mulToOutUnsafe(localTransform2, localDistanceProxy2.getVertex(((Distance.SimplexVertex)localObject).indexB), ((Distance.SimplexVertex)localObject).wB);
      ((Distance.SimplexVertex)localObject).w.set(((Distance.SimplexVertex)localObject).wB).subLocal(((Distance.SimplexVertex)localObject).wA);
      i += 1;
      GJK_ITERS += 1;
      j = 0;
      while (j < k)
      {
        if ((((Distance.SimplexVertex)localObject).indexA == this.saveA[j]) && (((Distance.SimplexVertex)localObject).indexB == this.saveB[j]))
        {
          j = 1;
          break label476;
        }
        j += 1;
      }
      j = 0;
      label476:
      if (j != 0)
      {
        j = i;
        break;
      }
      localObject = this.simplex;
      ((Distance.Simplex)localObject).m_count += 1;
    }
    GJK_MAX_ITERS = MathUtils.max(GJK_MAX_ITERS, j);
    this.simplex.getWitnessPoints(paramDistanceOutput.pointA, paramDistanceOutput.pointB);
    paramDistanceOutput.distance = MathUtils.distance(paramDistanceOutput.pointA, paramDistanceOutput.pointB);
    paramDistanceOutput.iterations = j;
    this.simplex.writeCache(paramSimplexCache);
    if (paramDistanceInput.useRadii)
    {
      float f1 = localDistanceProxy1.m_radius;
      float f2 = localDistanceProxy2.m_radius;
      float f3 = paramDistanceOutput.distance;
      float f4 = f1 + f2;
      if ((f3 > f4) && (paramDistanceOutput.distance > 1.192093E-007F))
      {
        paramDistanceOutput.distance -= f4;
        this.normal.set(paramDistanceOutput.pointB).subLocal(paramDistanceOutput.pointA);
        this.normal.normalize();
        this.temp.set(this.normal).mulLocal(f1);
        paramDistanceOutput.pointA.addLocal(this.temp);
        this.temp.set(this.normal).mulLocal(f2);
        paramDistanceOutput.pointB.subLocal(this.temp);
        return;
      }
      paramDistanceOutput.pointA.addLocal(paramDistanceOutput.pointB).mulLocal(0.5F);
      paramDistanceOutput.pointB.set(paramDistanceOutput.pointA);
      paramDistanceOutput.distance = 0.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Distance
 * JD-Core Version:    0.7.0.1
 */