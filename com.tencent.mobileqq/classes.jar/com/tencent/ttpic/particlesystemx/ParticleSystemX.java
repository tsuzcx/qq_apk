package com.tencent.ttpic.particlesystemx;

import android.content.Context;
import com.tencent.ttpic.model.Transition;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public final class ParticleSystemX
{
  private static final String TAG = "ParticleSystemX";
  private static ParticleSystemX mInstance;
  private List<ParticleTemplateX> mClouds = new ArrayList();
  private Context mContext = null;
  private long mNativeCtx;
  
  public static ParticleSystemX getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ParticleSystemX();
      }
      ParticleSystemX localParticleSystemX = mInstance;
      return localParticleSystemX;
    }
    finally {}
  }
  
  private void loadFinish()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mClouds.size(); j = k)
    {
      ParticleTemplateX localParticleTemplateX = (ParticleTemplateX)this.mClouds.get(i);
      k = localParticleTemplateX.mMaxCount;
      k = j;
      if (localParticleTemplateX.mMaxCount > j) {
        k = localParticleTemplateX.mMaxCount;
      }
      i += 1;
    }
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
  }
  
  public static native int nativeAdvance(long paramLong, int paramInt, float paramFloat1, float paramFloat2, FloatBuffer paramFloatBuffer, float paramFloat3, boolean paramBoolean);
  
  public static native int nativeClearParticles(long paramLong, int paramInt);
  
  public static native long nativeEmitAt(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native long nativeInit();
  
  public static native void nativeRegisterTemplate(long paramLong, Object[] paramArrayOfObject);
  
  public static native void nativeRelease(long paramLong);
  
  public static native int nativeReset(long paramLong);
  
  public void addParticle(Transition paramTransition)
  {
    paramTransition = new ParticleTemplateX(paramTransition.particleCountMax, paramTransition.emissionRate, paramTransition.life, paramTransition.positionX, paramTransition.positionY, paramTransition.scale, paramTransition.rotate, paramTransition.p0, paramTransition.p1, paramTransition.p2);
    this.mClouds.add(paramTransition);
  }
  
  public int advance(float paramFloat1, float paramFloat2, FloatBuffer paramFloatBuffer, float paramFloat3)
  {
    return advanceByTemplate(-1, paramFloat1, paramFloat2, paramFloatBuffer, paramFloat3, true);
  }
  
  public int advanceByTemplate(int paramInt, float paramFloat1, float paramFloat2, FloatBuffer paramFloatBuffer, float paramFloat3, boolean paramBoolean)
  {
    return nativeAdvance(this.mNativeCtx, paramInt, paramFloat1, paramFloat2, paramFloatBuffer, paramFloat3, paramBoolean);
  }
  
  public int clearParticles(int paramInt)
  {
    return nativeClearParticles(this.mNativeCtx, paramInt);
  }
  
  public void createParticles(Transition paramTransition)
  {
    paramTransition = new ParticleTemplateX(300, paramTransition.emissionRate, paramTransition.life, paramTransition.positionX, paramTransition.positionY, paramTransition.scale, paramTransition.rotate, paramTransition.p0, paramTransition.p1, paramTransition.p2);
    this.mClouds.add(paramTransition);
    loadFinish();
  }
  
  public long emitImmediately(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return nativeEmitAt(this.mNativeCtx, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void init(Context paramContext)
  {
    if ((this.mContext == null) || (this.mNativeCtx == 0L))
    {
      this.mContext = paramContext;
      this.mNativeCtx = nativeInit();
    }
  }
  
  public void registerTemplate()
  {
    nativeRegisterTemplate(this.mNativeCtx, this.mClouds.toArray());
  }
  
  public void release()
  {
    long l = this.mNativeCtx;
    if (l != 0L)
    {
      nativeRelease(l);
      this.mNativeCtx = 0L;
      this.mContext = null;
    }
  }
  
  public int reset()
  {
    return nativeReset(this.mNativeCtx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.particlesystemx.ParticleSystemX
 * JD-Core Version:    0.7.0.1
 */