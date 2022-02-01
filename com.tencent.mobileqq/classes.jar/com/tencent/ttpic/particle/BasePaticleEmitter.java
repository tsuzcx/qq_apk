package com.tencent.ttpic.particle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.util.Base64;

public abstract class BasePaticleEmitter
{
  public boolean active;
  public float angle;
  public Vector3 angle3d;
  public float angleVariance;
  protected float audioColorDelta;
  protected float baseRotation = 0.0F;
  public int blendFuncDestination;
  public int blendFuncSource;
  protected float canvasScaleForTakeLargePicture = 1.0F;
  public float duration;
  public float elapsedTime;
  public Vector3 emission3DVector;
  public Vector3 emission3DVectorVariance;
  public float emissionRate;
  public float emitCounter;
  public int emitterType;
  public Vector4 finishColor;
  public Vector4 finishColorVariance;
  public float finishParticleSize;
  public float finishParticleSizeVariance;
  public Vector3 gravity;
  public int maxParticles;
  public float maxRadius;
  public float maxRadiusVariance;
  public float minRadius;
  public float minRadiusVariance;
  public boolean opacityModifyRGB;
  public int originEmissionRate;
  public Vector3 originSourcePositionForRest;
  public float[] particleColors;
  public int particleCount;
  protected int particleIndex;
  public int[] particleIndices;
  public float particleLifespan;
  public float particleLifespanVariance;
  public String particlePath;
  public int[] particleSpriteIndex;
  public float[] particleTextureCoordinates;
  public float[] particleVertices;
  protected Particle[] particles;
  protected ParticleQuad[] quads;
  public float radialAccelVariance;
  public float radialAcceleration;
  public float radiusSpeed;
  public float rotatePerSecond;
  public float rotatePerSecondVariance;
  protected int[] rotateType;
  protected float rotateX;
  protected float rotateY;
  protected float rotateZ;
  public float rotationEnd;
  public float rotationEndVariance;
  public float rotationStart;
  public float rotationStartVariance;
  protected float scaleParticle = 1.0F;
  public Vector3 sourcePosition;
  public Vector3 sourcePositionVariance;
  public float speed;
  public float speedVariance;
  public Vector4 startColor;
  public Vector4 startColorVariance;
  public float startParticleSize;
  public float startParticleSizeVariance;
  public long startTime;
  public float tangentialAccelVariance;
  public float tangentialAcceleration;
  public int texture;
  public int[] textures;
  int totalTime = 0;
  
  private void setParticleConfig(String paramString, ParticleConfig paramParticleConfig)
  {
    ParticleConfig.ParticleEmitterConfigBean localParticleEmitterConfigBean = paramParticleConfig.getParticleEmitterConfig();
    if (localParticleEmitterConfigBean == null) {
      return;
    }
    paramString = localParticleEmitterConfigBean.emission3DVector;
    paramParticleConfig = null;
    if (paramString != null) {
      paramString = new Vector3(localParticleEmitterConfigBean.emission3DVector.x, localParticleEmitterConfigBean.emission3DVector.y, localParticleEmitterConfigBean.emission3DVector.z);
    } else {
      paramString = null;
    }
    this.emission3DVector = paramString;
    if (localParticleEmitterConfigBean.emission3DVectorVariance != null) {
      paramString = new Vector3(localParticleEmitterConfigBean.emission3DVectorVariance.x, localParticleEmitterConfigBean.emission3DVectorVariance.y, localParticleEmitterConfigBean.emission3DVectorVariance.z);
    } else {
      paramString = null;
    }
    this.emission3DVectorVariance = paramString;
    if (localParticleEmitterConfigBean.particlePath != null) {
      paramString = localParticleEmitterConfigBean.particlePath.path;
    } else {
      paramString = "";
    }
    this.particlePath = paramString;
    if (localParticleEmitterConfigBean.emitterType != null) {
      i = localParticleEmitterConfigBean.emitterType.getValue();
    } else {
      i = 0;
    }
    this.emitterType = i;
    if (localParticleEmitterConfigBean.sourcePosition != null) {
      paramString = new Vector3(localParticleEmitterConfigBean.sourcePosition.x, localParticleEmitterConfigBean.sourcePosition.y, localParticleEmitterConfigBean.sourcePosition.z);
    } else {
      paramString = null;
    }
    this.sourcePosition = paramString;
    paramString = this.sourcePosition;
    if (paramString != null) {
      paramString = new Vector3(paramString.x, this.sourcePosition.y, this.sourcePosition.z);
    } else {
      paramString = null;
    }
    this.originSourcePositionForRest = paramString;
    if (localParticleEmitterConfigBean.sourcePositionVariance != null) {
      paramString = new Vector3(localParticleEmitterConfigBean.sourcePositionVariance.x, localParticleEmitterConfigBean.sourcePositionVariance.y, localParticleEmitterConfigBean.sourcePositionVariance.z);
    } else {
      paramString = null;
    }
    this.sourcePositionVariance = paramString;
    float f;
    if (localParticleEmitterConfigBean.speed != null) {
      f = localParticleEmitterConfigBean.speed.getValue();
    } else {
      f = 0.0F;
    }
    this.speed = f;
    if (localParticleEmitterConfigBean.speedVariance != null) {
      f = localParticleEmitterConfigBean.speedVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.speedVariance = f;
    if (localParticleEmitterConfigBean.particleLifeSpan != null) {
      f = localParticleEmitterConfigBean.particleLifeSpan.getValue();
    } else {
      f = 0.0F;
    }
    this.particleLifespan = f;
    if (localParticleEmitterConfigBean.particleLifespanVariance != null) {
      f = localParticleEmitterConfigBean.particleLifespanVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.particleLifespanVariance = f;
    if (localParticleEmitterConfigBean.angle != null) {
      f = localParticleEmitterConfigBean.angle.getValue();
    } else {
      f = 0.0F;
    }
    this.angle = f;
    if (localParticleEmitterConfigBean.angle3d != null) {
      paramString = new Vector3(localParticleEmitterConfigBean.angle3d.x, localParticleEmitterConfigBean.angle3d.y, localParticleEmitterConfigBean.angle3d.z);
    } else {
      paramString = null;
    }
    this.angle3d = paramString;
    if (localParticleEmitterConfigBean.angleVariance != null) {
      f = localParticleEmitterConfigBean.angleVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.angleVariance = f;
    if (localParticleEmitterConfigBean.gravity != null) {
      paramString = new Vector3(localParticleEmitterConfigBean.gravity.x, localParticleEmitterConfigBean.gravity.y, localParticleEmitterConfigBean.gravity.z);
    } else {
      paramString = null;
    }
    this.gravity = paramString;
    if (localParticleEmitterConfigBean.radialAcceleration != null) {
      f = localParticleEmitterConfigBean.radialAcceleration.getValue();
    } else {
      f = 0.0F;
    }
    this.radialAcceleration = f;
    if (localParticleEmitterConfigBean.tangentialAcceleration != null) {
      f = localParticleEmitterConfigBean.tangentialAcceleration.getValue();
    } else {
      f = 0.0F;
    }
    this.tangentialAcceleration = f;
    if (localParticleEmitterConfigBean.tangentialAccelVariance != null) {
      f = localParticleEmitterConfigBean.tangentialAccelVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.tangentialAccelVariance = f;
    if (localParticleEmitterConfigBean.startColor != null) {
      paramString = new Vector4(localParticleEmitterConfigBean.startColor.red, localParticleEmitterConfigBean.startColor.green, localParticleEmitterConfigBean.startColor.blue, localParticleEmitterConfigBean.startColor.alpha);
    } else {
      paramString = null;
    }
    this.startColor = paramString;
    if (localParticleEmitterConfigBean.startColorVariance != null) {
      paramString = new Vector4(localParticleEmitterConfigBean.startColorVariance.red, localParticleEmitterConfigBean.startColorVariance.green, localParticleEmitterConfigBean.startColorVariance.blue, localParticleEmitterConfigBean.startColorVariance.alpha);
    } else {
      paramString = null;
    }
    this.startColorVariance = paramString;
    if (localParticleEmitterConfigBean.finishColor != null) {
      paramString = new Vector4(localParticleEmitterConfigBean.finishColor.red, localParticleEmitterConfigBean.finishColor.green, localParticleEmitterConfigBean.finishColor.blue, localParticleEmitterConfigBean.finishColor.alpha);
    } else {
      paramString = null;
    }
    this.finishColor = paramString;
    paramString = paramParticleConfig;
    if (localParticleEmitterConfigBean.finishColorVariance != null) {
      paramString = new Vector4(localParticleEmitterConfigBean.finishColorVariance.red, localParticleEmitterConfigBean.finishColorVariance.green, localParticleEmitterConfigBean.finishColorVariance.blue, localParticleEmitterConfigBean.finishColorVariance.alpha);
    }
    this.finishColorVariance = paramString;
    if (localParticleEmitterConfigBean.maxParticles != null) {
      i = localParticleEmitterConfigBean.maxParticles.getValue();
    } else {
      i = 0;
    }
    this.maxParticles = i;
    if (localParticleEmitterConfigBean.startParticleSize != null) {
      f = localParticleEmitterConfigBean.startParticleSize.getValue();
    } else {
      f = 0.0F;
    }
    this.startParticleSize = f;
    if (localParticleEmitterConfigBean.startParticleSizeVariance != null) {
      f = localParticleEmitterConfigBean.startParticleSizeVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.startParticleSizeVariance = f;
    if (localParticleEmitterConfigBean.finishParticleSize != null) {
      f = localParticleEmitterConfigBean.finishParticleSize.getValue();
    } else {
      f = 0.0F;
    }
    this.finishParticleSize = f;
    if (localParticleEmitterConfigBean.finishParticleSizeVariance != null) {
      f = localParticleEmitterConfigBean.finishParticleSizeVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.finishParticleSizeVariance = f;
    if (localParticleEmitterConfigBean.duration != null) {
      f = localParticleEmitterConfigBean.duration.getValue();
    } else {
      f = 0.0F;
    }
    this.duration = f;
    if (localParticleEmitterConfigBean.blendFuncSource != null) {
      i = localParticleEmitterConfigBean.blendFuncSource.getValue();
    } else {
      i = 0;
    }
    this.blendFuncSource = i;
    if (localParticleEmitterConfigBean.blendFuncDestination != null) {
      i = localParticleEmitterConfigBean.blendFuncDestination.getValue();
    } else {
      i = 0;
    }
    this.blendFuncDestination = i;
    int i = this.blendFuncSource;
    boolean bool = true;
    if ((i != 1) || (this.blendFuncDestination != 771)) {
      bool = false;
    }
    this.opacityModifyRGB = bool;
    if (localParticleEmitterConfigBean.maxRadius != null) {
      f = localParticleEmitterConfigBean.maxRadius.getValue();
    } else {
      f = 0.0F;
    }
    this.maxRadius = f;
    if (localParticleEmitterConfigBean.maxRadiusVariance != null) {
      f = localParticleEmitterConfigBean.maxRadiusVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.maxRadiusVariance = f;
    if (localParticleEmitterConfigBean.minRadius != null) {
      f = localParticleEmitterConfigBean.minRadius.getValue();
    } else {
      f = 0.0F;
    }
    this.minRadius = f;
    if (localParticleEmitterConfigBean.minRadiusVariance != null) {
      f = localParticleEmitterConfigBean.minRadiusVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.minRadiusVariance = f;
    if (localParticleEmitterConfigBean.rotatePerSecond != null) {
      f = localParticleEmitterConfigBean.rotatePerSecond.getValue();
    } else {
      f = 0.0F;
    }
    this.rotatePerSecond = f;
    if (localParticleEmitterConfigBean.rotatePerSecondVariance != null) {
      f = localParticleEmitterConfigBean.rotatePerSecondVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.rotatePerSecondVariance = f;
    if (localParticleEmitterConfigBean.rotationStart != null) {
      f = localParticleEmitterConfigBean.rotationStart.getValue();
    } else {
      f = 0.0F;
    }
    this.rotationStart = f;
    if (localParticleEmitterConfigBean.rotationStartVariance != null) {
      f = localParticleEmitterConfigBean.rotationStartVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.rotationStartVariance = f;
    if (localParticleEmitterConfigBean.rotationEnd != null) {
      f = localParticleEmitterConfigBean.rotationEnd.getValue();
    } else {
      f = 0.0F;
    }
    this.rotationEnd = f;
    if (localParticleEmitterConfigBean.rotationEndVariance != null) {
      f = localParticleEmitterConfigBean.rotationEndVariance.getValue();
    } else {
      f = 0.0F;
    }
    this.rotationEndVariance = f;
    this.originEmissionRate = localParticleEmitterConfigBean.emissionRate;
    this.emissionRate = this.originEmissionRate;
    if (this.emissionRate <= 0.0F) {}
    try
    {
      this.emissionRate = (this.maxParticles / this.particleLifespan);
    }
    catch (Exception paramString)
    {
      label1467:
      break label1467;
    }
    this.emissionRate = 1.0F;
    this.emitCounter = 0.0F;
  }
  
  int activeParticleCount()
  {
    return this.particleCount;
  }
  
  public boolean addParticle()
  {
    int i = this.particleCount;
    if (i == this.maxParticles) {
      return false;
    }
    initParticle(this.particles[i]);
    this.particleCount += 1;
    return true;
  }
  
  public Bitmap base64ToBitmap(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      label16:
      break label16;
    }
    return null;
  }
  
  public void clear()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.texture;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    arrayOfInt = this.textures;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    }
  }
  
  public void clearPositionLossTrigger()
  {
    this.particleVertices = new float[this.maxParticles * 18];
  }
  
  public int[] getRotateType()
  {
    return this.rotateType;
  }
  
  public void initEmitter(String paramString, ParticleConfig paramParticleConfig)
  {
    setParticleConfig(paramString, paramParticleConfig);
    setupArrays();
    loadTexture(paramString, paramParticleConfig);
  }
  
  public abstract void initParticle(Particle paramParticle);
  
  public abstract void loadTexture(String paramString, ParticleConfig paramParticleConfig);
  
  public void reset()
  {
    this.active = true;
    this.elapsedTime = 0.0F;
    int i = 0;
    while (i < this.particleCount)
    {
      this.particles[i].timeToLive = 0.0F;
      i += 1;
    }
    this.emitCounter = 0.0F;
    this.emissionRate = this.originEmissionRate;
    if (this.emissionRate <= 0.0F) {}
    try
    {
      this.emissionRate = (this.maxParticles / this.particleLifespan);
      return;
    }
    catch (Exception localException)
    {
      label75:
      break label75;
    }
    this.emissionRate = 1.0F;
  }
  
  void setBaseRotation(float paramFloat)
  {
    this.baseRotation = paramFloat;
  }
  
  void setCanvasScaleForTakeLargePicture(float paramFloat)
  {
    this.canvasScaleForTakeLargePicture = paramFloat;
  }
  
  public void setExtraScale(float paramFloat)
  {
    this.scaleParticle = paramFloat;
  }
  
  public void setRotateType(int[] paramArrayOfInt)
  {
    this.rotateType = paramArrayOfInt;
  }
  
  void setRotateX(float paramFloat)
  {
    if (this.rotateType[0] == 1) {
      this.rotateX = paramFloat;
    }
  }
  
  void setRotateY(float paramFloat)
  {
    if (this.rotateType[1] == 1) {
      this.rotateY = paramFloat;
    }
  }
  
  public void setRotateZ(float paramFloat)
  {
    this.rotateZ = paramFloat;
  }
  
  public void setSourcePosition(Vector2 paramVector2)
  {
    this.sourcePosition.x = paramVector2.x;
    this.sourcePosition.y = paramVector2.y;
    this.sourcePosition.z = 0.0F;
  }
  
  public void setSourcePosition(Vector3 paramVector3)
  {
    this.sourcePosition.x = paramVector3.x;
    this.sourcePosition.y = paramVector3.y;
    this.sourcePosition.z = paramVector3.z;
  }
  
  public void setupArrays()
  {
    this.particles = new Particle[this.maxParticles];
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.particles;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = new Particle();
      i += 1;
    }
    this.quads = new ParticleQuad[this.maxParticles];
    i = 0;
    for (;;)
    {
      localObject = this.quads;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = new ParticleQuad();
      i += 1;
    }
    i = this.maxParticles;
    this.particleIndices = new int[i * 6];
    this.particleVertices = new float[i * 18];
    this.particleTextureCoordinates = new float[i * 12];
    this.particleColors = new float[i * 24];
    this.particleSpriteIndex = new int[i];
    i = 0;
    while (i < this.maxParticles)
    {
      this.quads[i].bl.texture.x = 0.0F;
      this.quads[i].bl.texture.y = 0.0F;
      this.quads[i].br.texture.x = 1.0F;
      this.quads[i].br.texture.y = 0.0F;
      this.quads[i].tl.texture.x = 0.0F;
      this.quads[i].tl.texture.y = 1.0F;
      this.quads[i].tr.texture.x = 1.0F;
      this.quads[i].tr.texture.y = 1.0F;
      i += 1;
    }
    i = 0;
    while (i < this.maxParticles)
    {
      localObject = this.particleIndices;
      int j = i * 6;
      int k = i * 4;
      localObject[(j + 0)] = (k + 0);
      int m = k + 1;
      localObject[(j + 1)] = m;
      int n = k + 2;
      localObject[(j + 2)] = n;
      localObject[(j + 5)] = n;
      localObject[(j + 4)] = (k + 3);
      localObject[(j + 3)] = m;
      i += 1;
    }
    this.active = true;
    this.particleCount = 0;
    this.elapsedTime = 0.0F;
  }
  
  void stopParticleEmitter()
  {
    this.active = false;
    this.elapsedTime = 0.0F;
    this.emitCounter = 0.0F;
  }
  
  boolean totalFinished()
  {
    return (!this.active) && (this.particleCount == 0);
  }
  
  public void updateWithCurrentTime(long paramLong, boolean paramBoolean)
  {
    long l2 = this.startTime;
    long l1 = 0L;
    if (l2 > 0L)
    {
      l1 = paramLong - l2;
      this.totalTime = ((int)(this.totalTime + l1));
    }
    this.startTime = paramLong;
    updateWithDelta((float)l1 * 1.0F / 1000.0F, paramBoolean);
  }
  
  public abstract void updateWithDelta(float paramFloat, boolean paramBoolean);
  
  protected boolean useFaceAnglesRotate()
  {
    int[] arrayOfInt = this.rotateType;
    boolean bool = false;
    if (arrayOfInt[0] + arrayOfInt[1] > 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.particle.BasePaticleEmitter
 * JD-Core Version:    0.7.0.1
 */