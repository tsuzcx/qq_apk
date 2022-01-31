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
  private static final String TAG = ParticleEmitter.class.getSimpleName();
  
  public void initParticle(Particle paramParticle)
  {
    paramParticle.position.x = (this.sourcePosition.x + this.sourcePositionVariance.x * ParticleUtil.randomMinus1to1());
    paramParticle.position.y = (this.sourcePosition.y + this.sourcePositionVariance.y * ParticleUtil.randomMinus1to1());
    paramParticle.startPos.x = this.sourcePosition.x;
    paramParticle.startPos.y = this.sourcePosition.y;
    if (useFaceAnglesRotate()) {
      this.angle = ParticleUtil.getRotateAngle(this.rotateX, this.rotateY);
    }
    float f1 = (float)Math.toRadians(this.angle + this.angleVariance * ParticleUtil.randomMinus1to1()) + this.rotateZ;
    Object localObject = ParticleUtil.vectorMultiplyScalar(new Vector2((float)Math.cos(f1), (float)Math.sin(f1)), this.speed + this.speedVariance * ParticleUtil.randomMinus1to1());
    paramParticle.direction = new Vector3(((Vector2)localObject).x, ((Vector2)localObject).y, ParticleUtil.randomMinus1to1());
    paramParticle.timeToLive = Math.max(0.0F, this.particleLifespan + this.particleLifespanVariance * ParticleUtil.randomMinus1to1());
    f1 = this.maxRadius + this.maxRadiusVariance * ParticleUtil.randomMinus1to1();
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
    Object localObject = null;
    paramParticleConfig = paramParticleConfig.getParticleEmitterConfig();
    if (paramParticleConfig == null) {
      return;
    }
    String str1;
    if (paramParticleConfig.texture != null)
    {
      str1 = paramParticleConfig.texture.name;
      label28:
      if (paramParticleConfig.texture == null) {
        break label149;
      }
    }
    label149:
    for (String str2 = paramParticleConfig.texture.data;; str2 = null)
    {
      paramParticleConfig = localObject;
      if (!TextUtils.isEmpty(str1)) {
        paramParticleConfig = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString + File.separator + str1, 1);
      }
      paramString = paramParticleConfig;
      if (!BitmapUtils.isLegal(paramParticleConfig)) {
        paramString = base64ToBitmap(str2);
      }
      if ((paramString == null) || (paramString.isRecycled())) {
        break;
      }
      paramParticleConfig = new int[1];
      GLES20.glGenTextures(paramParticleConfig.length, paramParticleConfig, 0);
      this.texture = paramParticleConfig[0];
      GlUtil.loadTexture(this.texture, paramString);
      paramString.recycle();
      return;
      str1 = null;
      break label28;
    }
  }
  
  public void updateWithDelta(float paramFloat, boolean paramBoolean)
  {
    this.particleIndex = 0;
    LogUtils.e(TAG, "updateWithDelta() - particleCount = " + this.particleCount);
    label339:
    float f1;
    while (this.particleIndex < this.particleCount)
    {
      Particle localParticle = this.particles[this.particleIndex];
      localParticle.timeToLive -= paramFloat;
      int i = this.particleIndex * 18;
      if (localParticle.timeToLive > 0.0F)
      {
        Object localObject;
        if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRadial.value)
        {
          localParticle.angle += localParticle.degreesPerSecond * paramFloat;
          localParticle.radius += localParticle.radiusDelta * paramFloat;
          localObject = new Vector3();
          ((Vector3)localObject).x = ((float)(this.sourcePosition.x - Math.cos(localParticle.angle) * localParticle.radius));
          ((Vector3)localObject).y = ((float)(this.sourcePosition.y - Math.sin(localParticle.angle) * localParticle.radius));
          localParticle.position = ((Vector3)localObject);
          if (this.audioColorDelta <= 0.0F) {
            break label1788;
          }
          localParticle.color.r = (this.startColor.r + localParticle.deltaColor.r * this.audioColorDelta);
          localParticle.color.g = (this.startColor.g + localParticle.deltaColor.g * this.audioColorDelta);
          localParticle.color.b = (this.startColor.b + localParticle.deltaColor.b * this.audioColorDelta);
          localParticle.color.a = (this.startColor.a + localParticle.deltaColor.a * this.audioColorDelta);
          localParticle.particleSize += localParticle.particleSizeDelta * paramFloat;
          localParticle.particleSize = Math.max(0.0F, localParticle.particleSize);
          localParticle.rotation += localParticle.rotationDelta * paramFloat;
          f1 = localParticle.particleSize * 0.5F * this.scaleParticle;
          localObject = localParticle.position;
          ((Vector3)localObject).x *= this.canvasScaleForTakeLargePicture;
          localObject = localParticle.position;
          ((Vector3)localObject).y *= this.canvasScaleForTakeLargePicture;
          float f6 = localParticle.rotation + this.baseRotation;
          if (f6 == 0.0F) {
            break label1903;
          }
          float f2 = -f1;
          float f3 = -f1;
          float f4 = localParticle.position.x;
          float f5 = localParticle.position.y;
          float f7 = (float)Math.toRadians(f6);
          f6 = (float)Math.cos(f7);
          f7 = (float)Math.sin(f7);
          this.quads[this.particleIndex].bl.vertex.x = (f2 * f6 - f3 * f7 + f4);
          this.quads[this.particleIndex].bl.vertex.y = (f2 * f7 + f3 * f6 + f5);
          this.quads[this.particleIndex].bl.color = localParticle.color;
          this.quads[this.particleIndex].br.vertex.x = (f1 * f6 - f3 * f7 + f4);
          this.quads[this.particleIndex].br.vertex.y = (f3 * f6 + f1 * f7 + f5);
          this.quads[this.particleIndex].br.color = localParticle.color;
          this.quads[this.particleIndex].tl.vertex.x = (f4 + (f2 * f6 - f1 * f7));
          this.quads[this.particleIndex].tl.vertex.y = (f1 * f6 + f7 * f2 + f5);
          this.quads[this.particleIndex].tl.color = localParticle.color;
          this.quads[this.particleIndex].tr.vertex.x = (f1 * f6 - f1 * f7 + f4);
          this.quads[this.particleIndex].tr.vertex.y = (f1 * f7 + f1 * f6 + f5);
          this.quads[this.particleIndex].tr.color = localParticle.color;
          this.particleVertices[i] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(i + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(i + 2)] = localParticle.position.z;
          this.particleVertices[(i + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 5)] = localParticle.position.z;
          this.particleVertices[(i + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 8)] = localParticle.position.z;
          this.particleVertices[(i + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 11)] = localParticle.position.z;
          this.particleVertices[(i + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 14)] = localParticle.position.z;
          this.particleVertices[(i + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(i + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(i + 17)] = localParticle.position.z;
        }
        for (;;)
        {
          i = this.particleIndex * 12;
          this.particleTextureCoordinates[i] = 0.0F;
          this.particleTextureCoordinates[(i + 1)] = 0.0F;
          this.particleTextureCoordinates[(i + 2)] = 1.0F;
          this.particleTextureCoordinates[(i + 3)] = 0.0F;
          this.particleTextureCoordinates[(i + 4)] = 0.0F;
          this.particleTextureCoordinates[(i + 5)] = 1.0F;
          this.particleTextureCoordinates[(i + 6)] = this.particleTextureCoordinates[(i + 2)];
          this.particleTextureCoordinates[(i + 7)] = this.particleTextureCoordinates[(i + 3)];
          this.particleTextureCoordinates[(i + 8)] = this.particleTextureCoordinates[(i + 4)];
          this.particleTextureCoordinates[(i + 9)] = this.particleTextureCoordinates[(i + 5)];
          this.particleTextureCoordinates[(i + 10)] = 1.0F;
          this.particleTextureCoordinates[(i + 11)] = 1.0F;
          i = 0;
          while (i < 6)
          {
            int j = this.particleIndex * 24 + i * 4;
            this.particleColors[j] = localParticle.color.r;
            this.particleColors[(j + 1)] = localParticle.color.g;
            this.particleColors[(j + 2)] = localParticle.color.b;
            this.particleColors[(j + 3)] = localParticle.color.a;
            i += 1;
          }
          localObject = new Vector2(0.0F, 0.0F);
          Vector3 localVector3 = ParticleUtil.vectorSubtract(localParticle.startPos, new Vector3(0.0F, 0.0F, 0.0F));
          localParticle.position = ParticleUtil.vectorSubtract(localParticle.position, localVector3);
          if ((localParticle.position.x != 0.0F) || (localParticle.position.y != 0.0F)) {
            localObject = ParticleUtil.vectorNormalize(localParticle.position.xy());
          }
          Vector2 localVector2 = ParticleUtil.vectorMultiplyScalar((Vector2)localObject, localParticle.radialAcceleration);
          f1 = ((Vector2)localObject).x;
          ((Vector2)localObject).x = (-((Vector2)localObject).y);
          ((Vector2)localObject).y = f1;
          localObject = ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorAdd(ParticleUtil.vectorAdd(localVector2, ParticleUtil.vectorMultiplyScalar((Vector2)localObject, localParticle.tangentialAcceleration)), this.gravity.xy()), paramFloat);
          localParticle.direction = ParticleUtil.vectorAdd(localParticle.direction, new Vector3(((Vector2)localObject).x, ((Vector2)localObject).y, 0.0F));
          localObject = ParticleUtil.vectorMultiplyScalar(localParticle.direction, paramFloat);
          localParticle.position = ParticleUtil.vectorAdd(localParticle.position, (Vector3)localObject);
          localParticle.position = ParticleUtil.vectorAdd(localParticle.position, localVector3);
          ParticleUtil.saturateZ(localParticle.position, -1.0F, 1.0F);
          break;
          label1788:
          localObject = localParticle.color;
          ((Vector4)localObject).r += localParticle.deltaColor.r * paramFloat;
          localObject = localParticle.color;
          ((Vector4)localObject).g += localParticle.deltaColor.g * paramFloat;
          localObject = localParticle.color;
          ((Vector4)localObject).b += localParticle.deltaColor.b * paramFloat;
          localObject = localParticle.color;
          ((Vector4)localObject).a += localParticle.deltaColor.a * paramFloat;
          break label339;
          label1903:
          this.quads[this.particleIndex].bl.vertex.x = (localParticle.position.x - f1);
          this.quads[this.particleIndex].bl.vertex.y = (localParticle.position.y - f1);
          this.quads[this.particleIndex].bl.color = localParticle.color;
          this.quads[this.particleIndex].br.vertex.x = (localParticle.position.x + f1);
          this.quads[this.particleIndex].br.vertex.y = (localParticle.position.y - f1);
          this.quads[this.particleIndex].br.color = localParticle.color;
          this.quads[this.particleIndex].tl.vertex.x = (localParticle.position.x - f1);
          this.quads[this.particleIndex].tl.vertex.y = (localParticle.position.y + f1);
          this.quads[this.particleIndex].tl.color = localParticle.color;
          this.quads[this.particleIndex].tr.vertex.x = (localParticle.position.x + f1);
          this.quads[this.particleIndex].tr.vertex.y = (f1 + localParticle.position.y);
          this.quads[this.particleIndex].tr.color = localParticle.color;
          this.particleVertices[i] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(i + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(i + 2)] = localParticle.position.z;
          this.particleVertices[(i + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 5)] = localParticle.position.z;
          this.particleVertices[(i + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 8)] = localParticle.position.z;
          this.particleVertices[(i + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(i + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(i + 11)] = localParticle.position.z;
          this.particleVertices[(i + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(i + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(i + 14)] = localParticle.position.z;
          this.particleVertices[(i + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(i + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(i + 17)] = localParticle.position.z;
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
    Log.e("ParticleCount", "ParticleCount] " + this.particleIndex);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter
 * JD-Core Version:    0.7.0.1
 */