package org.jbox2d.collision;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.pooling.IWorldPool;

public class TimeOfImpact
{
  public static final int MAX_ITERATIONS = 1000;
  public static int toiCalls;
  public static int toiIters;
  public static int toiMaxIters;
  public static int toiMaxRootIters;
  public static int toiRootIters;
  private final Distance.SimplexCache cache = new Distance.SimplexCache();
  private final DistanceInput distanceInput = new DistanceInput();
  private final DistanceOutput distanceOutput = new DistanceOutput();
  private final SeparationFunction fcn = new SeparationFunction();
  private final int[] indexes = new int[2];
  private final IWorldPool pool;
  private final Sweep sweepA = new Sweep();
  private final Sweep sweepB = new Sweep();
  private final Transform xfA = new Transform();
  private final Transform xfB = new Transform();
  
  public TimeOfImpact(IWorldPool paramIWorldPool)
  {
    this.pool = paramIWorldPool;
  }
  
  public final void timeOfImpact(TimeOfImpact.TOIOutput paramTOIOutput, TimeOfImpact.TOIInput paramTOIInput)
  {
    Object localObject = this;
    toiCalls += 1;
    paramTOIOutput.state = TimeOfImpact.TOIOutputState.UNKNOWN;
    paramTOIOutput.t = paramTOIInput.tMax;
    Distance.DistanceProxy localDistanceProxy1 = paramTOIInput.proxyA;
    Distance.DistanceProxy localDistanceProxy2 = paramTOIInput.proxyB;
    ((TimeOfImpact)localObject).sweepA.set(paramTOIInput.sweepA);
    ((TimeOfImpact)localObject).sweepB.set(paramTOIInput.sweepB);
    ((TimeOfImpact)localObject).sweepA.normalize();
    ((TimeOfImpact)localObject).sweepB.normalize();
    float f9 = paramTOIInput.tMax;
    float f10 = MathUtils.max(0.005F, localDistanceProxy1.m_radius + localDistanceProxy2.m_radius - 0.015F);
    ((TimeOfImpact)localObject).cache.count = 0;
    ((TimeOfImpact)localObject).distanceInput.proxyA = paramTOIInput.proxyA;
    ((TimeOfImpact)localObject).distanceInput.proxyB = paramTOIInput.proxyB;
    ((TimeOfImpact)localObject).distanceInput.useRadii = false;
    float f1 = 0.0F;
    int i = 0;
    paramTOIInput = this;
    paramTOIInput.sweepA.getTransform(paramTOIInput.xfA, f1);
    paramTOIInput.sweepB.getTransform(paramTOIInput.xfB, f1);
    localObject = paramTOIInput.distanceInput;
    ((DistanceInput)localObject).transformA = paramTOIInput.xfA;
    ((DistanceInput)localObject).transformB = paramTOIInput.xfB;
    paramTOIInput.pool.getDistance().distance(paramTOIInput.distanceOutput, paramTOIInput.cache, paramTOIInput.distanceInput);
    float f11;
    if (paramTOIInput.distanceOutput.distance <= 0.0F)
    {
      paramTOIOutput.state = TimeOfImpact.TOIOutputState.OVERLAPPED;
      paramTOIOutput.t = 0.0F;
    }
    else
    {
      f2 = paramTOIInput.distanceOutput.distance;
      f11 = f10 + 0.00125F;
      if (f2 >= f11) {
        break label294;
      }
      paramTOIOutput.state = TimeOfImpact.TOIOutputState.TOUCHING;
      paramTOIOutput.t = f1;
    }
    break label716;
    label294:
    localObject = paramTOIInput.fcn;
    Distance.SimplexCache localSimplexCache = paramTOIInput.cache;
    Sweep localSweep = paramTOIInput.sweepA;
    paramTOIInput = paramTOIInput.sweepB;
    float f3 = f1;
    ((SeparationFunction)localObject).initialize(localSimplexCache, localDistanceProxy1, localSweep, localDistanceProxy2, paramTOIInput, f1);
    float f2 = f9;
    int k = 0;
    label343:
    int j = 1;
    paramTOIInput = this;
    float f4 = paramTOIInput.fcn.findMinSeparation(paramTOIInput.indexes, f2);
    if (f4 > f11)
    {
      paramTOIOutput.state = TimeOfImpact.TOIOutputState.SEPARATED;
      paramTOIOutput.t = f9;
      f2 = f3;
    }
    for (;;)
    {
      f1 = f2;
      break label674;
      f5 = f10 - 0.00125F;
      if (f4 <= f5) {
        break;
      }
      j = 0;
    }
    localObject = paramTOIInput.fcn;
    paramTOIInput = paramTOIInput.indexes;
    int m = paramTOIInput[0];
    int n = paramTOIInput[1];
    f1 = f3;
    float f7 = ((SeparationFunction)localObject).evaluate(m, n, f1);
    if (f7 < f5) {
      paramTOIOutput.state = TimeOfImpact.TOIOutputState.FAILED;
    }
    for (paramTOIOutput.t = f1;; paramTOIOutput.t = f1)
    {
      break;
      if (f7 > f11) {
        break label497;
      }
      paramTOIOutput.state = TimeOfImpact.TOIOutputState.TOUCHING;
    }
    label497:
    float f6 = f1;
    float f5 = f2;
    j = 0;
    f3 = f1;
    for (;;)
    {
      paramTOIInput = this;
      if ((j & 0x1) == 1) {
        f1 = (f10 - f7) * (f5 - f6) / (f4 - f7) + f6;
      } else {
        f1 = 0.5F * (f6 + f5);
      }
      localObject = paramTOIInput.fcn;
      paramTOIInput = paramTOIInput.indexes;
      float f8 = ((SeparationFunction)localObject).evaluate(paramTOIInput[0], paramTOIInput[1], f1);
      if (MathUtils.abs(f8 - f10) >= 0.00125F)
      {
        if (f8 > f10)
        {
          f7 = f8;
          f6 = f1;
        }
        else
        {
          f4 = f8;
          f5 = f1;
        }
        j += 1;
        toiRootIters += 1;
        if (j == 50) {
          f1 = f2;
        }
      }
      else
      {
        toiMaxRootIters = MathUtils.max(toiMaxRootIters, j);
        k += 1;
        if (k == 8)
        {
          f1 = f3;
          j = 0;
          label674:
          i += 1;
          toiIters += 1;
          if (j == 0)
          {
            if (i == 1000)
            {
              paramTOIOutput.state = TimeOfImpact.TOIOutputState.FAILED;
              paramTOIOutput.t = f1;
            }
          }
          else
          {
            label716:
            toiMaxIters = MathUtils.max(toiMaxIters, i);
            return;
          }
          break;
        }
        f2 = f1;
        break label343;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.TimeOfImpact
 * JD-Core Version:    0.7.0.1
 */