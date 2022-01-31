package com.tencent.ttpic.filament;

import com.tencent.oscarcamera.particlesystem.FrameParticleData;
import com.tencent.ttpic.ar.sensor.representation.Vector3f;
import com.tencent.ttpic.ar.sensor.representation.Vector4f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilamentParticleUtil
{
  public static final float MAX_POINT_SIZE = 128.0F;
  public static final float MIN_POINT_SIZE = 12.0F;
  public static final int NUM_POINTS = 100;
  private static final int STRIDE_COLOR = 24;
  private static final int STRIDE_POSITION = 18;
  private static final int STRIDE_SIZE = 12;
  public static final int TEXTURE_SIZE = 128;
  
  public static List<FilamentParticleUtil.Particle> getParticles(List<FrameParticleData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FrameParticleData localFrameParticleData = (FrameParticleData)paramList.next();
      int i = 0;
      while (i < localFrameParticleData.particleCount)
      {
        FilamentParticleUtil.Particle localParticle = new FilamentParticleUtil.Particle();
        localParticle.position = new Vector3f(localFrameParticleData.particleCenter[(i * 18)], localFrameParticleData.particleCenter[(i * 18 + 1)], localFrameParticleData.particleCenter[(i * 18 + 2)]);
        localParticle.color = new Vector4f(localFrameParticleData.particleColor[(i * 24)], localFrameParticleData.particleColor[(i * 24 + 1)], localFrameParticleData.particleColor[(i * 24 + 2)], localFrameParticleData.particleColor[(i * 24 + 3)]);
        localParticle.size = new FilamentParticleUtil.SizeF(localFrameParticleData.particleSize[(i * 12)], localFrameParticleData.particleSize[(i * 12 + 1)]);
        localArrayList.add(localParticle);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static double[] toDoubleMat(float[] paramArrayOfFloat)
  {
    double[] arrayOfDouble = new double[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfDouble[i] = paramArrayOfFloat[i];
      i += 1;
    }
    return arrayOfDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filament.FilamentParticleUtil
 * JD-Core Version:    0.7.0.1
 */