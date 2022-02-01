package com.tencent.ttpic.particle;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;

public class ParticleEmitter
  extends BasePaticleEmitter
{
  private static final String TAG = "ParticleEmitter";
  
  public void initParticle(Particle paramParticle)
  {
    paramParticle.position.x = (this.sourcePosition.x + this.sourcePositionVariance.x * ParticleUtil.randomMinus1to1());
    paramParticle.position.y = (this.sourcePosition.y + this.sourcePositionVariance.y * ParticleUtil.randomMinus1to1());
    paramParticle.startPos.x = this.sourcePosition.x;
    paramParticle.startPos.y = this.sourcePosition.y;
    if (useFaceAnglesRotate()) {
      this.angle = ParticleUtil.getRotateAngle(this.rotateX, this.rotateY);
    }
    double d = (float)Math.toRadians(this.angle + this.angleVariance * ParticleUtil.randomMinus1to1()) + this.rotateZ;
    Object localObject = ParticleUtil.vectorMultiplyScalar(new Vector2((float)Math.cos(d), (float)Math.sin(d)), this.speed + this.speedVariance * ParticleUtil.randomMinus1to1());
    paramParticle.direction = new Vector3(((Vector2)localObject).x, ((Vector2)localObject).y, ParticleUtil.randomMinus1to1());
    paramParticle.timeToLive = Math.max(0.0F, this.particleLifespan + this.particleLifespanVariance * ParticleUtil.randomMinus1to1());
    float f1 = this.maxRadius + this.maxRadiusVariance * ParticleUtil.randomMinus1to1();
    float f2 = this.minRadius;
    float f3 = this.minRadiusVariance;
    float f4 = ParticleUtil.randomMinus1to1();
    paramParticle.radius = f1;
    paramParticle.radiusDelta = ((f2 + f3 * f4 - f1) / paramParticle.timeToLive);
    paramParticle.angle = ((float)Math.toRadians(this.angle + this.angleVariance * ParticleUtil.randomMinus1to1()) + this.rotateZ);
    paramParticle.degreesPerSecond = ((float)Math.toRadians(this.rotatePerSecond + this.rotatePerSecondVariance * ParticleUtil.randomMinus1to1()));
    paramParticle.radialAcceleration = (this.radialAcceleration + this.radialAccelVariance * ParticleUtil.randomMinus1to1());
    paramParticle.tangentialAcceleration = (this.tangentialAcceleration + this.tangentialAccelVariance * ParticleUtil.randomMinus1to1());
    f1 = this.startParticleSize + this.startParticleSizeVariance * ParticleUtil.randomMinus1to1();
    paramParticle.particleSizeDelta = ((this.finishParticleSize + this.finishParticleSizeVariance * ParticleUtil.randomMinus1to1() - f1) / paramParticle.timeToLive);
    paramParticle.particleSize = Math.max(0.0F, f1);
    localObject = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    ((Vector4)localObject).r = (this.startColor.r + this.startColorVariance.r * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject).g = (this.startColor.g + this.startColorVariance.g * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject).b = (this.startColor.b + this.startColorVariance.b * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject).a = (this.startColor.a + this.startColorVariance.a * ParticleUtil.randomMinus1to1());
    Vector4 localVector4 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    localVector4.r = (this.finishColor.r + this.finishColorVariance.r * ParticleUtil.randomMinus1to1());
    localVector4.g = (this.finishColor.g + this.finishColorVariance.g * ParticleUtil.randomMinus1to1());
    localVector4.b = (this.finishColor.b + this.finishColorVariance.b * ParticleUtil.randomMinus1to1());
    localVector4.a = (this.finishColor.a + this.finishColorVariance.a * ParticleUtil.randomMinus1to1());
    paramParticle.color = ((Vector4)localObject);
    paramParticle.deltaColor.r = ((localVector4.r - ((Vector4)localObject).r) / paramParticle.timeToLive);
    paramParticle.deltaColor.g = ((localVector4.g - ((Vector4)localObject).g) / paramParticle.timeToLive);
    paramParticle.deltaColor.b = ((localVector4.b - ((Vector4)localObject).b) / paramParticle.timeToLive);
    paramParticle.deltaColor.a = ((localVector4.a - ((Vector4)localObject).a) / paramParticle.timeToLive);
    f1 = this.rotationStart + this.rotationStartVariance * ParticleUtil.randomMinus1to1();
    f2 = this.rotationEnd;
    f3 = this.rotationEndVariance;
    f4 = ParticleUtil.randomMinus1to1();
    paramParticle.rotation = f1;
    paramParticle.rotationDelta = ((f2 + f3 * f4 - f1) / paramParticle.timeToLive);
  }
  
  public void loadTexture(String paramString, ParticleConfig paramParticleConfig)
  {
    Object localObject2 = paramParticleConfig.getParticleEmitterConfig();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = ((ParticleConfig.ParticleEmitterConfigBean)localObject2).texture;
    paramParticleConfig = null;
    if (localObject1 != null) {
      localObject1 = ((ParticleConfig.ParticleEmitterConfigBean)localObject2).texture.name;
    } else {
      localObject1 = null;
    }
    if (((ParticleConfig.ParticleEmitterConfigBean)localObject2).texture != null) {
      localObject2 = ((ParticleConfig.ParticleEmitterConfigBean)localObject2).texture.data;
    } else {
      localObject2 = null;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramParticleConfig = AEModule.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      localStringBuilder.append((String)localObject1);
      paramParticleConfig = BitmapUtils.decodeSampleBitmap(paramParticleConfig, localStringBuilder.toString(), 1);
    }
    paramString = paramParticleConfig;
    if (!BitmapUtils.isLegal(paramParticleConfig)) {
      paramString = base64ToBitmap((String)localObject2);
    }
    if ((paramString != null) && (!paramString.isRecycled()))
    {
      paramParticleConfig = new int[1];
      GLES20.glGenTextures(paramParticleConfig.length, paramParticleConfig, 0);
      this.texture = paramParticleConfig[0];
      GlUtil.loadTexture(this.texture, paramString);
      paramString.recycle();
    }
  }
  
  public void updateWithDelta(float paramFloat, boolean paramBoolean)
  {
    this.particleIndex = 0;
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateWithDelta() - particleCount = ");
    ((StringBuilder)localObject2).append(this.particleCount);
    LogUtils.e((String)localObject1, ((StringBuilder)localObject2).toString());
    float f1;
    while (this.particleIndex < this.particleCount)
    {
      localObject2 = this.particles[this.particleIndex];
      ((Particle)localObject2).timeToLive -= paramFloat;
      int i = this.particleIndex * 18;
      if (((Particle)localObject2).timeToLive > 0.0F)
      {
        double d1;
        if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRadial.value)
        {
          ((Particle)localObject2).angle += ((Particle)localObject2).degreesPerSecond * paramFloat;
          ((Particle)localObject2).radius += ((Particle)localObject2).radiusDelta * paramFloat;
          localObject1 = new Vector3();
          d1 = this.sourcePosition.x;
          double d2 = Math.cos(((Particle)localObject2).angle);
          double d3 = ((Particle)localObject2).radius;
          Double.isNaN(d3);
          Double.isNaN(d1);
          ((Vector3)localObject1).x = ((float)(d1 - d2 * d3));
          d1 = this.sourcePosition.y;
          d2 = Math.sin(((Particle)localObject2).angle);
          d3 = ((Particle)localObject2).radius;
          Double.isNaN(d3);
          Double.isNaN(d1);
          ((Vector3)localObject1).y = ((float)(d1 - d2 * d3));
          ((Particle)localObject2).position = ((Vector3)localObject1);
        }
        else
        {
          localObject1 = new Vector2(0.0F, 0.0F);
          Vector3 localVector3 = ParticleUtil.vectorSubtract(((Particle)localObject2).startPos, new Vector3(0.0F, 0.0F, 0.0F));
          ((Particle)localObject2).position = ParticleUtil.vectorSubtract(((Particle)localObject2).position, localVector3);
          if ((((Particle)localObject2).position.x != 0.0F) || (((Particle)localObject2).position.y != 0.0F)) {
            localObject1 = ParticleUtil.vectorNormalize(((Particle)localObject2).position.xy());
          }
          Vector2 localVector2 = ParticleUtil.vectorMultiplyScalar((Vector2)localObject1, ((Particle)localObject2).radialAcceleration);
          f1 = ((Vector2)localObject1).x;
          ((Vector2)localObject1).x = (-((Vector2)localObject1).y);
          ((Vector2)localObject1).y = f1;
          localObject1 = ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorAdd(ParticleUtil.vectorAdd(localVector2, ParticleUtil.vectorMultiplyScalar((Vector2)localObject1, ((Particle)localObject2).tangentialAcceleration)), this.gravity.xy()), paramFloat);
          ((Particle)localObject2).direction = ParticleUtil.vectorAdd(((Particle)localObject2).direction, new Vector3(((Vector2)localObject1).x, ((Vector2)localObject1).y, 0.0F));
          localObject1 = ParticleUtil.vectorMultiplyScalar(((Particle)localObject2).direction, paramFloat);
          ((Particle)localObject2).position = ParticleUtil.vectorAdd(((Particle)localObject2).position, (Vector3)localObject1);
          ((Particle)localObject2).position = ParticleUtil.vectorAdd(((Particle)localObject2).position, localVector3);
          ParticleUtil.saturateZ(((Particle)localObject2).position, -1.0F, 1.0F);
        }
        if (this.audioColorDelta > 0.0F)
        {
          ((Particle)localObject2).color.r = (this.startColor.r + ((Particle)localObject2).deltaColor.r * this.audioColorDelta);
          ((Particle)localObject2).color.g = (this.startColor.g + ((Particle)localObject2).deltaColor.g * this.audioColorDelta);
          ((Particle)localObject2).color.b = (this.startColor.b + ((Particle)localObject2).deltaColor.b * this.audioColorDelta);
          ((Particle)localObject2).color.a = (this.startColor.a + ((Particle)localObject2).deltaColor.a * this.audioColorDelta);
        }
        else
        {
          localObject1 = ((Particle)localObject2).color;
          ((Vector4)localObject1).r += ((Particle)localObject2).deltaColor.r * paramFloat;
          localObject1 = ((Particle)localObject2).color;
          ((Vector4)localObject1).g += ((Particle)localObject2).deltaColor.g * paramFloat;
          localObject1 = ((Particle)localObject2).color;
          ((Vector4)localObject1).b += ((Particle)localObject2).deltaColor.b * paramFloat;
          localObject1 = ((Particle)localObject2).color;
          ((Vector4)localObject1).a += ((Particle)localObject2).deltaColor.a * paramFloat;
        }
        ((Particle)localObject2).particleSize += ((Particle)localObject2).particleSizeDelta * paramFloat;
        ((Particle)localObject2).particleSize = Math.max(0.0F, ((Particle)localObject2).particleSize);
        ((Particle)localObject2).rotation += ((Particle)localObject2).rotationDelta * paramFloat;
        float f3 = ((Particle)localObject2).particleSize * 0.5F * this.scaleParticle;
        localObject1 = ((Particle)localObject2).position;
        ((Vector3)localObject1).x *= this.canvasScaleForTakeLargePicture;
        localObject1 = ((Particle)localObject2).position;
        ((Vector3)localObject1).y *= this.canvasScaleForTakeLargePicture;
        float f4 = ((Particle)localObject2).rotation + this.baseRotation;
        if (f4 != 0.0F)
        {
          float f6 = -f3;
          f1 = ((Particle)localObject2).position.x;
          float f2 = ((Particle)localObject2).position.y;
          d1 = (float)Math.toRadians(f4);
          float f7 = (float)Math.cos(d1);
          float f5 = (float)Math.sin(d1);
          f4 = f6 * f7;
          f6 *= f5;
          f7 *= f3;
          f3 *= f5;
          this.quads[this.particleIndex].bl.vertex.x = (f4 - f6 + f1);
          this.quads[this.particleIndex].bl.vertex.y = (f6 + f4 + f2);
          this.quads[this.particleIndex].bl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].br.vertex.x = (f7 - f6 + f1);
          this.quads[this.particleIndex].br.vertex.y = (f3 + f4 + f2);
          this.quads[this.particleIndex].br.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tl.vertex.x = (f4 - f3 + f1);
          this.quads[this.particleIndex].tl.vertex.y = (f6 + f7 + f2);
          this.quads[this.particleIndex].tl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tr.vertex.x = (f7 - f3 + f1);
          this.quads[this.particleIndex].tr.vertex.y = (f3 + f7 + f2);
          this.quads[this.particleIndex].tr.color = ((Particle)localObject2).color;
          this.particleVertices[i] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(i + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(i + 2)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 5)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 8)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 11)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 14)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(i + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(i + 17)] = ((Particle)localObject2).position.z;
        }
        else
        {
          this.quads[this.particleIndex].bl.vertex.x = (((Particle)localObject2).position.x - f3);
          this.quads[this.particleIndex].bl.vertex.y = (((Particle)localObject2).position.y - f3);
          this.quads[this.particleIndex].bl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].br.vertex.x = (((Particle)localObject2).position.x + f3);
          this.quads[this.particleIndex].br.vertex.y = (((Particle)localObject2).position.y - f3);
          this.quads[this.particleIndex].br.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tl.vertex.x = (((Particle)localObject2).position.x - f3);
          this.quads[this.particleIndex].tl.vertex.y = (((Particle)localObject2).position.y + f3);
          this.quads[this.particleIndex].tl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tr.vertex.x = (((Particle)localObject2).position.x + f3);
          this.quads[this.particleIndex].tr.vertex.y = (((Particle)localObject2).position.y + f3);
          this.quads[this.particleIndex].tr.color = ((Particle)localObject2).color;
          this.particleVertices[i] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(i + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(i + 2)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 5)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 8)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 11)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 14)] = ((Particle)localObject2).position.z;
          this.particleVertices[(i + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(i + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(i + 17)] = ((Particle)localObject2).position.z;
        }
        i = this.particleIndex * 12;
        this.particleTextureCoordinates[i] = 0.0F;
        this.particleTextureCoordinates[(i + 1)] = 0.0F;
        localObject1 = this.particleTextureCoordinates;
        int j = i + 2;
        localObject1[j] = 1.0F;
        localObject1 = this.particleTextureCoordinates;
        int k = i + 3;
        localObject1[k] = 0.0F;
        localObject1 = this.particleTextureCoordinates;
        int m = i + 4;
        localObject1[m] = 0.0F;
        localObject1 = this.particleTextureCoordinates;
        int n = i + 5;
        localObject1[n] = 1.0F;
        this.particleTextureCoordinates[(i + 6)] = this.particleTextureCoordinates[j];
        this.particleTextureCoordinates[(i + 7)] = this.particleTextureCoordinates[k];
        this.particleTextureCoordinates[(i + 8)] = this.particleTextureCoordinates[m];
        this.particleTextureCoordinates[(i + 9)] = this.particleTextureCoordinates[n];
        this.particleTextureCoordinates[(i + 10)] = 1.0F;
        this.particleTextureCoordinates[(i + 11)] = 1.0F;
        i = 0;
        while (i < 6)
        {
          j = this.particleIndex * 24 + i * 4;
          this.particleColors[j] = ((Particle)localObject2).color.r;
          this.particleColors[(j + 1)] = ((Particle)localObject2).color.g;
          this.particleColors[(j + 2)] = ((Particle)localObject2).color.b;
          this.particleColors[(j + 3)] = ((Particle)localObject2).color.a;
          i += 1;
        }
        this.particleIndex += 1;
      }
      else
      {
        if (this.particleIndex != this.particleCount - 1) {
          this.particles[this.particleIndex].copy(this.particles[(this.particleCount - 1)]);
        }
        this.particleCount -= 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ParticleCount] ");
    ((StringBuilder)localObject1).append(this.particleIndex);
    Log.e("ParticleCount", ((StringBuilder)localObject1).toString());
    if ((paramBoolean) && (this.active) && (this.emissionRate > 0.0F))
    {
      f1 = 1.0F / this.emissionRate;
      if (this.particleCount < this.maxParticles) {
        this.emitCounter += paramFloat;
      }
      if ((this.particleCount == 0) && (this.particleLifespanVariance < 0.01D) && (this.emitCounter >= this.maxParticles * f1)) {}
      for (this.emitCounter = (this.maxParticles * f1 * ParticleUtil.random0to1()); (this.particleCount < this.maxParticles) && (this.emitCounter > f1); this.emitCounter -= f1) {
        addParticle();
      }
      this.elapsedTime += paramFloat;
      if ((this.duration != -1.0F) && (this.duration < this.elapsedTime)) {
        stopParticleEmitter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter
 * JD-Core Version:    0.7.0.1
 */