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
    boolean bool2 = false;
    Object localObject = null;
    paramParticleConfig = paramParticleConfig.getParticleEmitterConfig();
    if (paramParticleConfig == null) {
      return;
    }
    if (paramParticleConfig.emission3DVector != null) {
      paramString = new Vector3(paramParticleConfig.emission3DVector.x, paramParticleConfig.emission3DVector.y, paramParticleConfig.emission3DVector.z);
    }
    for (;;)
    {
      this.emission3DVector = paramString;
      label93:
      label113:
      int i;
      label134:
      label176:
      label217:
      float f;
      if (paramParticleConfig.emission3DVectorVariance != null)
      {
        paramString = new Vector3(paramParticleConfig.emission3DVectorVariance.x, paramParticleConfig.emission3DVectorVariance.y, paramParticleConfig.emission3DVectorVariance.z);
        this.emission3DVectorVariance = paramString;
        if (paramParticleConfig.particlePath == null) {
          break label1177;
        }
        paramString = paramParticleConfig.particlePath.path;
        this.particlePath = paramString;
        if (paramParticleConfig.emitterType == null) {
          break label1184;
        }
        i = paramParticleConfig.emitterType.getValue();
        this.emitterType = i;
        if (paramParticleConfig.sourcePosition == null) {
          break label1190;
        }
        paramString = new Vector3(paramParticleConfig.sourcePosition.x, paramParticleConfig.sourcePosition.y, paramParticleConfig.sourcePosition.z);
        this.sourcePosition = paramString;
        if (this.sourcePosition == null) {
          break label1195;
        }
        paramString = new Vector3(this.sourcePosition.x, this.sourcePosition.y, this.sourcePosition.z);
        this.originSourcePositionForRest = paramString;
        if (paramParticleConfig.sourcePositionVariance == null) {
          break label1200;
        }
        paramString = new Vector3(paramParticleConfig.sourcePositionVariance.x, paramParticleConfig.sourcePositionVariance.y, paramParticleConfig.sourcePositionVariance.z);
        label258:
        this.sourcePositionVariance = paramString;
        if (paramParticleConfig.speed == null) {
          break label1205;
        }
        f = paramParticleConfig.speed.getValue();
        label278:
        this.speed = f;
        if (paramParticleConfig.speedVariance == null) {
          break label1210;
        }
        f = paramParticleConfig.speedVariance.getValue();
        label298:
        this.speedVariance = f;
        if (paramParticleConfig.particleLifeSpan == null) {
          break label1215;
        }
        f = paramParticleConfig.particleLifeSpan.getValue();
        label318:
        this.particleLifespan = f;
        if (paramParticleConfig.particleLifespanVariance == null) {
          break label1220;
        }
        f = paramParticleConfig.particleLifespanVariance.getValue();
        label338:
        this.particleLifespanVariance = f;
        if (paramParticleConfig.angle == null) {
          break label1225;
        }
        f = paramParticleConfig.angle.getValue();
        label358:
        this.angle = f;
        if (paramParticleConfig.angle3d == null) {
          break label1230;
        }
        paramString = new Vector3(paramParticleConfig.angle3d.x, paramParticleConfig.angle3d.y, paramParticleConfig.angle3d.z);
        label399:
        this.angle3d = paramString;
        if (paramParticleConfig.angleVariance == null) {
          break label1235;
        }
        f = paramParticleConfig.angleVariance.getValue();
        label419:
        this.angleVariance = f;
        if (paramParticleConfig.gravity == null) {
          break label1240;
        }
        paramString = new Vector3(paramParticleConfig.gravity.x, paramParticleConfig.gravity.y, paramParticleConfig.gravity.z);
        label460:
        this.gravity = paramString;
        if (paramParticleConfig.radialAcceleration == null) {
          break label1245;
        }
        f = paramParticleConfig.radialAcceleration.getValue();
        label480:
        this.radialAcceleration = f;
        if (paramParticleConfig.tangentialAcceleration == null) {
          break label1250;
        }
        f = paramParticleConfig.tangentialAcceleration.getValue();
        label500:
        this.tangentialAcceleration = f;
        if (paramParticleConfig.tangentialAccelVariance == null) {
          break label1255;
        }
        f = paramParticleConfig.tangentialAccelVariance.getValue();
        label520:
        this.tangentialAccelVariance = f;
        if (paramParticleConfig.startColor == null) {
          break label1260;
        }
        paramString = new Vector4(paramParticleConfig.startColor.red, paramParticleConfig.startColor.green, paramParticleConfig.startColor.blue, paramParticleConfig.startColor.alpha);
        label568:
        this.startColor = paramString;
        if (paramParticleConfig.startColorVariance == null) {
          break label1265;
        }
        paramString = new Vector4(paramParticleConfig.startColorVariance.red, paramParticleConfig.startColorVariance.green, paramParticleConfig.startColorVariance.blue, paramParticleConfig.startColorVariance.alpha);
        label616:
        this.startColorVariance = paramString;
        if (paramParticleConfig.finishColor == null) {
          break label1270;
        }
        paramString = new Vector4(paramParticleConfig.finishColor.red, paramParticleConfig.finishColor.green, paramParticleConfig.finishColor.blue, paramParticleConfig.finishColor.alpha);
        label664:
        this.finishColor = paramString;
        paramString = localObject;
        if (paramParticleConfig.finishColorVariance != null) {
          paramString = new Vector4(paramParticleConfig.finishColorVariance.red, paramParticleConfig.finishColorVariance.green, paramParticleConfig.finishColorVariance.blue, paramParticleConfig.finishColorVariance.alpha);
        }
        this.finishColorVariance = paramString;
        if (paramParticleConfig.maxParticles == null) {
          break label1275;
        }
        i = paramParticleConfig.maxParticles.getValue();
        label736:
        this.maxParticles = i;
        if (paramParticleConfig.startParticleSize == null) {
          break label1281;
        }
        f = paramParticleConfig.startParticleSize.getValue();
        label757:
        this.startParticleSize = f;
        if (paramParticleConfig.startParticleSizeVariance == null) {
          break label1286;
        }
        f = paramParticleConfig.startParticleSizeVariance.getValue();
        label777:
        this.startParticleSizeVariance = f;
        if (paramParticleConfig.finishParticleSize == null) {
          break label1291;
        }
        f = paramParticleConfig.finishParticleSize.getValue();
        label797:
        this.finishParticleSize = f;
        if (paramParticleConfig.finishParticleSizeVariance == null) {
          break label1296;
        }
        f = paramParticleConfig.finishParticleSizeVariance.getValue();
        label817:
        this.finishParticleSizeVariance = f;
        if (paramParticleConfig.duration == null) {
          break label1301;
        }
        f = paramParticleConfig.duration.getValue();
        label837:
        this.duration = f;
        if (paramParticleConfig.blendFuncSource == null) {
          break label1306;
        }
        i = paramParticleConfig.blendFuncSource.getValue();
        label858:
        this.blendFuncSource = i;
        if (paramParticleConfig.blendFuncDestination == null) {
          break label1312;
        }
        i = paramParticleConfig.blendFuncDestination.getValue();
        label880:
        this.blendFuncDestination = i;
        boolean bool1 = bool2;
        if (this.blendFuncSource == 1)
        {
          bool1 = bool2;
          if (this.blendFuncDestination == 771) {
            bool1 = true;
          }
        }
        this.opacityModifyRGB = bool1;
        if (paramParticleConfig.maxRadius == null) {
          break label1318;
        }
        f = paramParticleConfig.maxRadius.getValue();
        label936:
        this.maxRadius = f;
        if (paramParticleConfig.maxRadiusVariance == null) {
          break label1323;
        }
        f = paramParticleConfig.maxRadiusVariance.getValue();
        label956:
        this.maxRadiusVariance = f;
        if (paramParticleConfig.minRadius == null) {
          break label1328;
        }
        f = paramParticleConfig.minRadius.getValue();
        label976:
        this.minRadius = f;
        if (paramParticleConfig.minRadiusVariance == null) {
          break label1333;
        }
        f = paramParticleConfig.minRadiusVariance.getValue();
        label996:
        this.minRadiusVariance = f;
        if (paramParticleConfig.rotatePerSecond == null) {
          break label1338;
        }
        f = paramParticleConfig.rotatePerSecond.getValue();
        label1016:
        this.rotatePerSecond = f;
        if (paramParticleConfig.rotatePerSecondVariance == null) {
          break label1343;
        }
        f = paramParticleConfig.rotatePerSecondVariance.getValue();
        label1036:
        this.rotatePerSecondVariance = f;
        if (paramParticleConfig.rotationStart == null) {
          break label1348;
        }
        f = paramParticleConfig.rotationStart.getValue();
        label1056:
        this.rotationStart = f;
        if (paramParticleConfig.rotationStartVariance == null) {
          break label1353;
        }
        f = paramParticleConfig.rotationStartVariance.getValue();
        label1076:
        this.rotationStartVariance = f;
        if (paramParticleConfig.rotationEnd == null) {
          break label1358;
        }
        f = paramParticleConfig.rotationEnd.getValue();
        label1096:
        this.rotationEnd = f;
        if (paramParticleConfig.rotationEndVariance == null) {
          break label1363;
        }
        f = paramParticleConfig.rotationEndVariance.getValue();
        this.rotationEndVariance = f;
        this.originEmissionRate = paramParticleConfig.emissionRate;
        this.emissionRate = this.originEmissionRate;
        if (this.emissionRate > 0.0F) {}
      }
      try
      {
        this.emissionRate = (this.maxParticles / this.particleLifespan);
        this.emitCounter = 0.0F;
        return;
        paramString = null;
        continue;
        paramString = null;
        break label93;
        label1177:
        paramString = "";
        break label113;
        label1184:
        i = 0;
        break label134;
        label1190:
        paramString = null;
        break label176;
        label1195:
        paramString = null;
        break label217;
        label1200:
        paramString = null;
        break label258;
        label1205:
        f = 0.0F;
        break label278;
        label1210:
        f = 0.0F;
        break label298;
        label1215:
        f = 0.0F;
        break label318;
        label1220:
        f = 0.0F;
        break label338;
        label1225:
        f = 0.0F;
        break label358;
        label1230:
        paramString = null;
        break label399;
        label1235:
        f = 0.0F;
        break label419;
        label1240:
        paramString = null;
        break label460;
        label1245:
        f = 0.0F;
        break label480;
        label1250:
        f = 0.0F;
        break label500;
        label1255:
        f = 0.0F;
        break label520;
        label1260:
        paramString = null;
        break label568;
        label1265:
        paramString = null;
        break label616;
        label1270:
        paramString = null;
        break label664;
        label1275:
        i = 0;
        break label736;
        label1281:
        f = 0.0F;
        break label757;
        label1286:
        f = 0.0F;
        break label777;
        label1291:
        f = 0.0F;
        break label797;
        label1296:
        f = 0.0F;
        break label817;
        label1301:
        f = 0.0F;
        break label837;
        label1306:
        i = 0;
        break label858;
        label1312:
        i = 0;
        break label880;
        label1318:
        f = 0.0F;
        break label936;
        label1323:
        f = 0.0F;
        break label956;
        label1328:
        f = 0.0F;
        break label976;
        label1333:
        f = 0.0F;
        break label996;
        label1338:
        f = 0.0F;
        break label1016;
        label1343:
        f = 0.0F;
        break label1036;
        label1348:
        f = 0.0F;
        break label1056;
        label1353:
        f = 0.0F;
        break label1076;
        label1358:
        f = 0.0F;
        break label1096;
        label1363:
        f = 0.0F;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          this.emissionRate = 1.0F;
        }
      }
    }
  }
  
  int activeParticleCount()
  {
    return this.particleCount;
  }
  
  public boolean addParticle()
  {
    if (this.particleCount == this.maxParticles) {
      return false;
    }
    initParticle(this.particles[this.particleCount]);
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
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public void clear()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.texture;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    if (this.textures != null) {
      GLES20.glDeleteTextures(this.textures.length, this.textures, 0);
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
      this.emissionRate = 1.0F;
    }
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
    while (i < this.particles.length)
    {
      this.particles[i] = new Particle();
      i += 1;
    }
    this.quads = new ParticleQuad[this.maxParticles];
    i = 0;
    while (i < this.quads.length)
    {
      this.quads[i] = new ParticleQuad();
      i += 1;
    }
    this.particleIndices = new int[this.maxParticles * 6];
    this.particleVertices = new float[this.maxParticles * 18];
    this.particleTextureCoordinates = new float[this.maxParticles * 12];
    this.particleColors = new float[this.maxParticles * 24];
    this.particleSpriteIndex = new int[this.maxParticles];
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
      this.particleIndices[(i * 6 + 0)] = (i * 4 + 0);
      this.particleIndices[(i * 6 + 1)] = (i * 4 + 1);
      this.particleIndices[(i * 6 + 2)] = (i * 4 + 2);
      this.particleIndices[(i * 6 + 5)] = (i * 4 + 2);
      this.particleIndices[(i * 6 + 4)] = (i * 4 + 3);
      this.particleIndices[(i * 6 + 3)] = (i * 4 + 1);
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
    long l = 0L;
    if (this.startTime > 0L)
    {
      l = paramLong - this.startTime;
      this.totalTime = ((int)(this.totalTime + l));
    }
    this.startTime = paramLong;
    updateWithDelta((float)l * 1.0F / 1000.0F, paramBoolean);
  }
  
  public abstract void updateWithDelta(float paramFloat, boolean paramBoolean);
  
  protected boolean useFaceAnglesRotate()
  {
    return this.rotateType[0] + this.rotateType[1] > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.BasePaticleEmitter
 * JD-Core Version:    0.7.0.1
 */