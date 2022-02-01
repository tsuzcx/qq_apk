package com.tencent.ttpic.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class ParticleEmitter3D
  extends BasePaticleEmitter
{
  private static final String TAG = "ParticleEmitter3D";
  private StickerItem item;
  private Bitmap[] mTextureBitmaps;
  ParticlePathModel particlePathModel;
  
  public ParticleEmitter3D(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  public void clear()
  {
    super.clear();
  }
  
  public void initEmitter(String paramString, ParticleConfig paramParticleConfig)
  {
    super.initEmitter(paramString, paramParticleConfig);
    try
    {
      paramParticleConfig = new StringBuilder();
      paramParticleConfig.append(paramString);
      paramParticleConfig.append(File.separator);
      paramParticleConfig.append(this.particlePath);
      paramString = new FileInputStream(paramParticleConfig.toString());
      paramParticleConfig = new byte[paramString.available()];
      paramString.read(paramParticleConfig);
      this.particlePathModel = ((ParticlePathModel)GsonUtils.json2Obj(new String(paramParticleConfig), ParticlePathModel.class));
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void initParticle(Particle paramParticle)
  {
    if ((this.item.particleConfig.getParticleEmitterConfig() != null) && (this.item.particleConfig.getParticleEmitterConfig().getSprite() != null))
    {
      localObject1 = new Random();
      if (this.textures != null) {
        paramParticle.spriteIndex = (((Random)localObject1).nextInt(this.textures.length) % this.textures.length);
      }
      int i = 0;
      while (i < this.item.particleConfig.getParticleEmitterConfig().getSprite().size())
      {
        localObject2 = (ParticleConfig.ParticleEmitterConfigBean.Sprite)this.item.particleConfig.getParticleEmitterConfig().getSprite().get(i);
        int j = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject2).row * ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject2).column;
        paramParticle.frameIndex = (((Random)localObject1).nextInt(j) % j);
        i += 1;
      }
    }
    if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRest.value)
    {
      paramParticle.startPos.x = (this.originSourcePositionForRest.x + this.sourcePositionVariance.x * ParticleUtil.randomMinus1to1());
      paramParticle.startPos.y = (this.originSourcePositionForRest.y + this.sourcePositionVariance.y * ParticleUtil.randomMinus1to1());
      paramParticle.startPos.z = (this.originSourcePositionForRest.z + this.sourcePositionVariance.z * ParticleUtil.randomMinus1to1());
    }
    else
    {
      paramParticle.position.x = (this.sourcePosition.x + this.sourcePositionVariance.x * ParticleUtil.randomMinus1to1());
      paramParticle.position.y = (this.sourcePosition.y + this.sourcePositionVariance.y * ParticleUtil.randomMinus1to1());
      paramParticle.position.z = (this.sourcePosition.z + this.sourcePositionVariance.z * ParticleUtil.randomMinus1to1());
      paramParticle.startPos.x = this.sourcePosition.x;
      paramParticle.startPos.y = this.sourcePosition.y;
      paramParticle.startPos.z = this.sourcePosition.z;
      paramParticle.angle3d = new Vector3(this.emission3DVector.x + ParticleUtil.randomMinus1to1() * this.emission3DVectorVariance.x, this.emission3DVector.y + ParticleUtil.randomMinus1to1() * this.emission3DVectorVariance.y, this.emission3DVector.z + ParticleUtil.randomMinus1to1() * this.emission3DVectorVariance.z);
      localObject1 = new float[16];
      MatrixUtil.setRotateEulerM((float[])localObject1, 0, (float)Math.toDegrees(-this.rotateX), (float)Math.toDegrees(this.rotateY), (float)Math.toDegrees(this.rotateZ));
      f1 = paramParticle.angle3d.x;
      f2 = paramParticle.angle3d.y;
      f3 = paramParticle.angle3d.z;
      localObject2 = new float[4];
      Matrix.multiplyMV((float[])localObject2, (float[])localObject1, new float[] { f1, f2, f3, 1.0F });
      paramParticle.angle3d = new Vector3(localObject2[0], localObject2[1], localObject2[2]);
      paramParticle.direction = ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorNormalize(new Vector3(paramParticle.angle3d.x, paramParticle.angle3d.y, paramParticle.angle3d.z)), this.speed + this.speedVariance * ParticleUtil.randomMinus1to1());
    }
    paramParticle.lifespan = Math.max(0.0F, this.particleLifespan + this.particleLifespanVariance * ParticleUtil.randomMinus1to1());
    paramParticle.timeToLive = paramParticle.lifespan;
    float f1 = this.maxRadius + this.maxRadiusVariance * ParticleUtil.randomMinus1to1();
    float f2 = this.minRadius;
    float f3 = this.minRadiusVariance;
    float f4 = ParticleUtil.randomMinus1to1();
    paramParticle.radius = f1;
    paramParticle.radiusDelta = ((f2 + f3 * f4 - f1) / paramParticle.timeToLive);
    paramParticle.degreesPerSecond = ((float)Math.toRadians(this.rotatePerSecond + this.rotatePerSecondVariance * ParticleUtil.randomMinus1to1()));
    paramParticle.radialAcceleration = (this.radialAcceleration + this.radialAccelVariance * ParticleUtil.randomMinus1to1());
    paramParticle.tangentialAcceleration = (this.tangentialAcceleration + this.tangentialAccelVariance * ParticleUtil.randomMinus1to1());
    f1 = this.startParticleSize + this.startParticleSizeVariance * ParticleUtil.randomMinus1to1();
    paramParticle.particleSizeDelta = ((this.finishParticleSize + this.finishParticleSizeVariance * ParticleUtil.randomMinus1to1() - f1) / paramParticle.timeToLive);
    paramParticle.particleSize = Math.max(0.0F, f1);
    Object localObject1 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    ((Vector4)localObject1).r = (this.startColor.r + this.startColorVariance.r * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject1).g = (this.startColor.g + this.startColorVariance.g * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject1).b = (this.startColor.b + this.startColorVariance.b * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject1).a = (this.startColor.a + this.startColorVariance.a * ParticleUtil.randomMinus1to1());
    Object localObject2 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
    ((Vector4)localObject2).r = (this.finishColor.r + this.finishColorVariance.r * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject2).g = (this.finishColor.g + this.finishColorVariance.g * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject2).b = (this.finishColor.b + this.finishColorVariance.b * ParticleUtil.randomMinus1to1());
    ((Vector4)localObject2).a = (this.finishColor.a + this.finishColorVariance.a * ParticleUtil.randomMinus1to1());
    paramParticle.color = ((Vector4)localObject1);
    paramParticle.deltaColor.r = ((((Vector4)localObject2).r - ((Vector4)localObject1).r) / paramParticle.timeToLive);
    paramParticle.deltaColor.g = ((((Vector4)localObject2).g - ((Vector4)localObject1).g) / paramParticle.timeToLive);
    paramParticle.deltaColor.b = ((((Vector4)localObject2).b - ((Vector4)localObject1).b) / paramParticle.timeToLive);
    paramParticle.deltaColor.a = ((((Vector4)localObject2).a - ((Vector4)localObject1).a) / paramParticle.timeToLive);
    f1 = this.rotationStart + this.rotationStartVariance * ParticleUtil.randomMinus1to1();
    f2 = this.rotationEnd;
    f3 = this.rotationEndVariance;
    f4 = ParticleUtil.randomMinus1to1();
    paramParticle.rotation = f1;
    paramParticle.rotationDelta = ((f2 + f3 * f4 - f1) / paramParticle.timeToLive);
  }
  
  public void loadTexture(String paramString, ParticleConfig paramParticleConfig)
  {
    paramParticleConfig = paramParticleConfig.getParticleEmitterConfig();
    if (paramParticleConfig == null) {
      return;
    }
    if (paramParticleConfig.sprites != null)
    {
      this.textures = new int[paramParticleConfig.sprites.size()];
      int i = 0;
      while (i < paramParticleConfig.sprites.size())
      {
        Object localObject1 = AEModule.getContext();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(((ParticleConfig.ParticleEmitterConfigBean.Sprite)paramParticleConfig.sprites.get(i)).path);
        localObject1 = BitmapUtils.decodeSampleBitmap((Context)localObject1, ((StringBuilder)localObject2).toString(), 1);
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
        {
          localObject2 = new int[1];
          GLES20.glGenTextures(localObject2.length, (int[])localObject2, 0);
          this.textures[i] = localObject2[0];
          GlUtil.loadTexture(this.textures[i], (Bitmap)localObject1);
          ((Bitmap)localObject1).recycle();
        }
        i += 1;
      }
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
      this.particleSpriteIndex[this.particleIndex] = ((Particle)localObject2).spriteIndex;
      ((Particle)localObject2).timeToLive -= paramFloat;
      int k = this.particleIndex * 18;
      if (((Particle)localObject2).timeToLive > 0.0F)
      {
        double d1;
        double d2;
        int j;
        int i;
        if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRadial.value)
        {
          localObject1 = this.emission3DVector;
          ((Vector3)localObject1).x += ((Particle)localObject2).degreesPerSecond * paramFloat;
          localObject1 = this.emission3DVector;
          ((Vector3)localObject1).y += ((Particle)localObject2).degreesPerSecond * paramFloat;
          localObject1 = this.emission3DVector;
          ((Vector3)localObject1).z += 1.2F;
          ((Particle)localObject2).radius += ((Particle)localObject2).radiusDelta * paramFloat;
          localObject1 = new Vector3();
          d1 = this.sourcePosition.x;
          d2 = Math.cos(this.emission3DVector.x);
          double d3 = ((Particle)localObject2).radius;
          Double.isNaN(d3);
          Double.isNaN(d1);
          ((Vector3)localObject1).x = ((float)(d1 - d2 * d3));
          d1 = this.sourcePosition.y;
          d2 = Math.sin(this.emission3DVector.y);
          d3 = ((Particle)localObject2).radius;
          Double.isNaN(d3);
          Double.isNaN(d1);
          ((Vector3)localObject1).y = ((float)(d1 - d2 * d3));
          ((Vector3)localObject1).z = this.emission3DVector.z;
          ((Particle)localObject2).position = ((Vector3)localObject1);
        }
        else if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRest.value)
        {
          ((Particle)localObject2).position = new Vector3(this.sourcePosition.x + ((Particle)localObject2).startPos.x, this.sourcePosition.y + ((Particle)localObject2).startPos.y, this.sourcePosition.z + ((Particle)localObject2).startPos.z);
        }
        else
        {
          Object localObject3;
          Object localObject4;
          if ((this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypePath.value) && (this.particlePathModel != null))
          {
            j = (int)((1.0F - ((Particle)localObject2).timeToLive / ((Particle)localObject2).lifespan) * this.particlePathModel.path.size());
            i = j;
            if (j < 0) {
              i = 0;
            }
            if (this.particleIndex >= this.particlePathModel.path.size()) {
              i = this.particlePathModel.path.size() - 1;
            }
            localObject1 = (ArrayList)this.particlePathModel.path.get(i);
            localObject3 = this.particlePathModel.anchorPoint;
            localObject1 = new Vector3(((Float)((ArrayList)localObject1).get(0)).floatValue() - ((Float)((ArrayList)localObject3).get(0)).floatValue(), ((Float)((ArrayList)localObject1).get(1)).floatValue() - ((Float)((ArrayList)localObject3).get(1)).floatValue(), ((Float)((ArrayList)localObject1).get(2)).floatValue() - ((Float)((ArrayList)localObject3).get(2)).floatValue());
            localObject3 = new float[16];
            Matrix.setIdentityM((float[])localObject3, 0);
            Matrix.rotateM((float[])localObject3, 0, -this.baseRotation, 0.0F, 0.0F, 1.0F);
            localObject4 = new float[4];
            Matrix.multiplyMV((float[])localObject4, (float[])localObject3, new float[] { ((Vector3)localObject1).x, ((Vector3)localObject1).y, ((Vector3)localObject1).z, 1.0F });
            localObject1 = new Vector3(localObject4[0], localObject4[1], localObject4[2]);
            ((Particle)localObject2).position = new Vector3(this.sourcePosition.x + ((Vector3)localObject1).x, this.sourcePosition.y - ((Vector3)localObject1).y, this.sourcePosition.z + ((Vector3)localObject1).z);
          }
          else
          {
            localObject1 = new Vector3(0.0F, 0.0F, 0.0F);
            localObject3 = ParticleUtil.vectorSubtract(((Particle)localObject2).startPos, new Vector3(0.0F, 0.0F, 0.0F));
            ((Particle)localObject2).position = ParticleUtil.vectorSubtract(((Particle)localObject2).position, (Vector3)localObject3);
            if ((((Particle)localObject2).position.x != 0.0F) || (((Particle)localObject2).position.y != 0.0F) || (((Particle)localObject2).position.z != 0.0F)) {
              localObject1 = ParticleUtil.vectorNormalize(((Particle)localObject2).position);
            }
            localObject4 = ParticleUtil.vectorMultiplyScalar((Vector3)localObject1, ((Particle)localObject2).radialAcceleration);
            f1 = ((Vector3)localObject1).x;
            ((Vector3)localObject1).x = (-((Vector3)localObject1).y);
            ((Vector3)localObject1).y = f1;
            Vector3 localVector3 = ParticleUtil.vectorMultiplyScalar((Vector3)localObject1, ((Particle)localObject2).tangentialAcceleration);
            if (Math.abs(this.baseRotation) == 90.0F) {
              localObject1 = new Vector3(this.gravity.y, this.gravity.x, this.gravity.z);
            } else if (Math.abs(this.baseRotation) == 180.0F) {
              localObject1 = new Vector3(-this.gravity.x, -this.gravity.y, this.gravity.z);
            } else if (Math.abs(this.baseRotation) == 270.0F) {
              localObject1 = new Vector3(-this.gravity.y, -this.gravity.x, this.gravity.z);
            } else {
              localObject1 = new Vector3(this.gravity.x, this.gravity.y, this.gravity.z);
            }
            localObject1 = ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorAdd(ParticleUtil.vectorAdd((Vector3)localObject4, localVector3), (Vector3)localObject1), paramFloat);
            ((Particle)localObject2).direction = ParticleUtil.vectorAdd(((Particle)localObject2).direction, new Vector3(((Vector3)localObject1).x, ((Vector3)localObject1).y, ((Vector3)localObject1).z));
            localObject1 = ParticleUtil.vectorMultiplyScalar(((Particle)localObject2).direction, paramFloat);
            ((Particle)localObject2).position = ParticleUtil.vectorAdd(((Particle)localObject2).position, (Vector3)localObject1);
            ((Particle)localObject2).position = ParticleUtil.vectorAdd(((Particle)localObject2).position, (Vector3)localObject3);
          }
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
        float f2 = ((Particle)localObject2).particleSize * 0.5F;
        float f3;
        if ((this.item.particleConfig.getParticleEmitterConfig() != null) && (this.item.particleConfig.getParticleEmitterConfig().getSprite() != null))
        {
          localObject1 = (ParticleConfig.ParticleEmitterConfigBean.Sprite)this.item.particleConfig.getParticleEmitterConfig().getSprite().get(0);
          if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width < ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height)
          {
            f3 = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height;
            f1 = f2;
            f2 *= f3;
          }
          else
          {
            f1 = f2 * (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width);
          }
        }
        else
        {
          f1 = f2;
        }
        float f5 = ((Particle)localObject2).rotation + this.baseRotation;
        float f4;
        if (f5 != 0.0F)
        {
          float f8 = -f2;
          float f10 = -f1;
          f3 = ((Particle)localObject2).position.x;
          f4 = ((Particle)localObject2).position.y;
          d1 = (float)Math.toRadians(f5);
          float f7 = (float)Math.cos(d1);
          float f9 = (float)Math.sin(d1);
          f5 = f8 * f7;
          float f6 = f10 * f9;
          f8 *= f9;
          f10 *= f7;
          float f11 = f2 * f7;
          f2 *= f9;
          f9 *= f1;
          f1 *= f7;
          this.quads[this.particleIndex].bl.vertex.x = (f5 - f6 + f3);
          this.quads[this.particleIndex].bl.vertex.y = (f8 + f10 + f4);
          localObject1 = this.quads[this.particleIndex].bl;
          ((TexturedColoredVertex)localObject1).color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].br.vertex.x = (f11 - f6 + f3);
          this.quads[this.particleIndex].br.vertex.y = (f10 + f2 + f4);
          this.quads[this.particleIndex].br.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tl.vertex.x = (f5 - f9 + f3);
          this.quads[this.particleIndex].tl.vertex.y = (f8 + f1 + f4);
          this.quads[this.particleIndex].tl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tr.vertex.x = (f11 - f9 + f3);
          this.quads[this.particleIndex].tr.vertex.y = (f2 + f1 + f4);
          this.quads[this.particleIndex].tr.color = ((Particle)localObject2).color;
          this.particleVertices[k] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(k + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(k + 2)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(k + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(k + 5)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(k + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(k + 8)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(k + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(k + 11)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(k + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(k + 14)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(k + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(k + 17)] = ((Particle)localObject2).position.z;
        }
        else
        {
          this.quads[this.particleIndex].bl.vertex.x = (((Particle)localObject2).position.x - f2);
          this.quads[this.particleIndex].bl.vertex.y = (((Particle)localObject2).position.y - f1);
          this.quads[this.particleIndex].bl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].br.vertex.x = (((Particle)localObject2).position.x + f2);
          this.quads[this.particleIndex].br.vertex.y = (((Particle)localObject2).position.y - f1);
          this.quads[this.particleIndex].br.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tl.vertex.x = (((Particle)localObject2).position.x - f2);
          this.quads[this.particleIndex].tl.vertex.y = (((Particle)localObject2).position.y + f1);
          this.quads[this.particleIndex].tl.color = ((Particle)localObject2).color;
          this.quads[this.particleIndex].tr.vertex.x = (((Particle)localObject2).position.x + f2);
          this.quads[this.particleIndex].tr.vertex.y = (((Particle)localObject2).position.y + f1);
          this.quads[this.particleIndex].tr.color = ((Particle)localObject2).color;
          this.particleVertices[k] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(k + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(k + 2)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(k + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(k + 5)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(k + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(k + 8)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(k + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(k + 11)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(k + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(k + 14)] = ((Particle)localObject2).position.z;
          this.particleVertices[(k + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(k + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(k + 17)] = ((Particle)localObject2).position.z;
        }
        if (this.item.particleConfig.getParticleEmitterConfig().getSprite() != null)
        {
          j = 0;
          while ((j < this.item.particleConfig.getParticleEmitterConfig().getSprite().size()) && (this.particleIndex < this.particleCount))
          {
            int m = this.particleIndex * 12;
            localObject1 = (ParticleConfig.ParticleEmitterConfigBean.Sprite)this.item.particleConfig.getParticleEmitterConfig().getSprite().get(j);
            d1 = ((Particle)localObject2).lifespan - ((Particle)localObject2).timeToLive;
            Double.isNaN(d1);
            d2 = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).frameDuration;
            Double.isNaN(d2);
            i = (int)(d1 * 1000.0D / d2);
            k = ((Particle)localObject2).frameIndex + i;
            int n = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).row * ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).column;
            if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).looped == -1) {
              i = ((Particle)localObject2).frameIndex;
            }
            for (;;)
            {
              break;
              if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).looped == 1)
              {
                i = k % n;
              }
              else if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).looped == 2)
              {
                i1 = n * 2;
                k %= i1;
                i = k;
                if (k >= n) {
                  i = i1 - k - 1;
                }
              }
              else
              {
                i = k;
                if (k >= ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).frameCount) {
                  i = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).frameCount - 1;
                }
              }
            }
            k = i % ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).column;
            i /= ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).column;
            n = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width;
            int i1 = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height;
            f3 = 1.0F - i * i1 / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageHeight;
            f4 = 1.0F - (i + 1) * i1 / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageHeight;
            if (k == 0) {
              f1 = 0.0F;
            } else {
              f1 = (k - 1) * n / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageWidth;
            }
            if (k == 0) {
              f2 = n;
            } else {
              f2 = k * n;
            }
            f2 /= ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageWidth;
            this.particleTextureCoordinates[m] = f1;
            this.particleTextureCoordinates[(m + 1)] = f4;
            localObject1 = this.particleTextureCoordinates;
            i = m + 2;
            localObject1[i] = f2;
            localObject1 = this.particleTextureCoordinates;
            k = m + 3;
            localObject1[k] = f4;
            localObject1 = this.particleTextureCoordinates;
            n = m + 4;
            localObject1[n] = f1;
            localObject1 = this.particleTextureCoordinates;
            i1 = m + 5;
            localObject1[i1] = f3;
            this.particleTextureCoordinates[(m + 6)] = this.particleTextureCoordinates[i];
            this.particleTextureCoordinates[(m + 7)] = this.particleTextureCoordinates[k];
            this.particleTextureCoordinates[(m + 8)] = this.particleTextureCoordinates[n];
            this.particleTextureCoordinates[(m + 9)] = this.particleTextureCoordinates[i1];
            this.particleTextureCoordinates[(m + 10)] = f2;
            this.particleTextureCoordinates[(m + 11)] = f3;
            i = 0;
            while (i < 6)
            {
              k = this.particleIndex * 24 + i * 4;
              this.particleColors[k] = ((Particle)localObject2).color.r;
              this.particleColors[(k + 1)] = ((Particle)localObject2).color.g;
              this.particleColors[(k + 2)] = ((Particle)localObject2).color.b;
              this.particleColors[(k + 3)] = ((Particle)localObject2).color.a;
              i += 1;
            }
            this.particleIndex += 1;
            j += 1;
          }
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ParticleCount] ");
      ((StringBuilder)localObject1).append(this.particleIndex);
      Log.e("ParticleCount", ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && (this.active) && (this.emissionRate > 0.0F))
    {
      f1 = 1.0F / this.emissionRate;
      if (this.particleCount < this.maxParticles) {}
      for (this.emitCounter += paramFloat; (this.particleCount < this.maxParticles) && (this.emitCounter > f1); this.emitCounter -= f1) {
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
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter3D
 * JD-Core Version:    0.7.0.1
 */