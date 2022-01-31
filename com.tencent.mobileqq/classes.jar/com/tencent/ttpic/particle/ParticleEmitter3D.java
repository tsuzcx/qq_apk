package com.tencent.ttpic.particle;

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
  private static final String TAG = ParticleEmitter3D.class.getSimpleName();
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
      paramString = new FileInputStream(paramString + File.separator + this.particlePath);
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
    Object localObject1;
    Object localObject2;
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
        int j = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject2).row;
        j = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject2).column * j;
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
    for (;;)
    {
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
      localObject1 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
      ((Vector4)localObject1).r = (this.startColor.r + this.startColorVariance.r * ParticleUtil.randomMinus1to1());
      ((Vector4)localObject1).g = (this.startColor.g + this.startColorVariance.g * ParticleUtil.randomMinus1to1());
      ((Vector4)localObject1).b = (this.startColor.b + this.startColorVariance.b * ParticleUtil.randomMinus1to1());
      ((Vector4)localObject1).a = (this.startColor.a + this.startColorVariance.a * ParticleUtil.randomMinus1to1());
      localObject2 = new Vector4(0.0F, 0.0F, 0.0F, 0.0F);
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
      return;
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
  }
  
  public void loadTexture(String paramString, ParticleConfig paramParticleConfig)
  {
    paramParticleConfig = paramParticleConfig.getParticleEmitterConfig();
    if (paramParticleConfig == null) {}
    for (;;)
    {
      return;
      if (paramParticleConfig.sprites != null)
      {
        this.textures = new int[paramParticleConfig.sprites.size()];
        int i = 0;
        while (i < paramParticleConfig.sprites.size())
        {
          Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString + File.separator + ((ParticleConfig.ParticleEmitterConfigBean.Sprite)paramParticleConfig.sprites.get(i)).path, 1);
          if ((localBitmap != null) && (!localBitmap.isRecycled()))
          {
            int[] arrayOfInt = new int[1];
            GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
            this.textures[i] = arrayOfInt[0];
            GlUtil.loadTexture(this.textures[i], localBitmap);
            localBitmap.recycle();
          }
          i += 1;
        }
      }
    }
  }
  
  public void updateWithDelta(float paramFloat, boolean paramBoolean)
  {
    this.particleIndex = 0;
    LogUtils.e(TAG, "updateWithDelta() - particleCount = " + this.particleCount);
    label294:
    float f1;
    if (this.particleIndex < this.particleCount)
    {
      Particle localParticle = this.particles[this.particleIndex];
      this.particleSpriteIndex[this.particleIndex] = localParticle.spriteIndex;
      localParticle.timeToLive -= paramFloat;
      int k = this.particleIndex * 18;
      Object localObject1;
      label419:
      float f2;
      float f3;
      label569:
      float f4;
      float f5;
      label1412:
      int j;
      if (localParticle.timeToLive > 0.0F) {
        if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRadial.value)
        {
          localObject1 = this.emission3DVector;
          ((Vector3)localObject1).x += localParticle.degreesPerSecond * paramFloat;
          localObject1 = this.emission3DVector;
          ((Vector3)localObject1).y += localParticle.degreesPerSecond * paramFloat;
          localObject1 = this.emission3DVector;
          ((Vector3)localObject1).z += 1.2F;
          localParticle.radius += localParticle.radiusDelta * paramFloat;
          localObject1 = new Vector3();
          ((Vector3)localObject1).x = ((float)(this.sourcePosition.x - Math.cos(this.emission3DVector.x) * localParticle.radius));
          ((Vector3)localObject1).y = ((float)(this.sourcePosition.y - Math.sin(this.emission3DVector.y) * localParticle.radius));
          ((Vector3)localObject1).z = this.emission3DVector.z;
          localParticle.position = ((Vector3)localObject1);
          if (this.audioColorDelta <= 0.0F) {
            break label2350;
          }
          localParticle.color.r = (this.startColor.r + localParticle.deltaColor.r * this.audioColorDelta);
          localParticle.color.g = (this.startColor.g + localParticle.deltaColor.g * this.audioColorDelta);
          localParticle.color.b = (this.startColor.b + localParticle.deltaColor.b * this.audioColorDelta);
          localParticle.color.a = (this.startColor.a + localParticle.deltaColor.a * this.audioColorDelta);
          localParticle.particleSize += localParticle.particleSizeDelta * paramFloat;
          localParticle.particleSize = Math.max(0.0F, localParticle.particleSize);
          localParticle.rotation += localParticle.rotationDelta * paramFloat;
          f2 = 0.5F * localParticle.particleSize;
          if ((this.item.particleConfig.getParticleEmitterConfig() == null) || (this.item.particleConfig.getParticleEmitterConfig().getSprite() == null)) {
            break label2485;
          }
          localObject1 = (ParticleConfig.ParticleEmitterConfigBean.Sprite)this.item.particleConfig.getParticleEmitterConfig().getSprite().get(0);
          if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width >= ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height) {
            break label2465;
          }
          f3 = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height * f2;
          f1 = f2;
          f2 = f3;
          float f7 = localParticle.rotation + this.baseRotation;
          if (f7 == 0.0F) {
            break label2491;
          }
          f3 = -f2;
          f4 = -f1;
          f5 = localParticle.position.x;
          float f6 = localParticle.position.y;
          float f8 = (float)Math.toRadians(f7);
          f7 = (float)Math.cos(f8);
          f8 = (float)Math.sin(f8);
          this.quads[this.particleIndex].bl.vertex.x = (f3 * f7 - f4 * f8 + f5);
          this.quads[this.particleIndex].bl.vertex.y = (f3 * f8 + f4 * f7 + f6);
          this.quads[this.particleIndex].bl.color = localParticle.color;
          this.quads[this.particleIndex].br.vertex.x = (f2 * f7 - f4 * f8 + f5);
          this.quads[this.particleIndex].br.vertex.y = (f4 * f7 + f2 * f8 + f6);
          this.quads[this.particleIndex].br.color = localParticle.color;
          this.quads[this.particleIndex].tl.vertex.x = (f5 + (f3 * f7 - f1 * f8));
          this.quads[this.particleIndex].tl.vertex.y = (f1 * f7 + f8 * f3 + f6);
          this.quads[this.particleIndex].tl.color = localParticle.color;
          this.quads[this.particleIndex].tr.vertex.x = (f2 * f7 - f1 * f8 + f5);
          this.quads[this.particleIndex].tr.vertex.y = (f2 * f8 + f1 * f7 + f6);
          this.quads[this.particleIndex].tr.color = localParticle.color;
          this.particleVertices[k] = this.quads[this.particleIndex].bl.vertex.x;
          this.particleVertices[(k + 1)] = this.quads[this.particleIndex].bl.vertex.y;
          this.particleVertices[(k + 2)] = localParticle.position.z;
          this.particleVertices[(k + 3)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(k + 4)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(k + 5)] = localParticle.position.z;
          this.particleVertices[(k + 6)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(k + 7)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(k + 8)] = localParticle.position.z;
          this.particleVertices[(k + 9)] = this.quads[this.particleIndex].br.vertex.x;
          this.particleVertices[(k + 10)] = this.quads[this.particleIndex].br.vertex.y;
          this.particleVertices[(k + 11)] = localParticle.position.z;
          this.particleVertices[(k + 12)] = this.quads[this.particleIndex].tl.vertex.x;
          this.particleVertices[(k + 13)] = this.quads[this.particleIndex].tl.vertex.y;
          this.particleVertices[(k + 14)] = localParticle.position.z;
          this.particleVertices[(k + 15)] = this.quads[this.particleIndex].tr.vertex.x;
          this.particleVertices[(k + 16)] = this.quads[this.particleIndex].tr.vertex.y;
          this.particleVertices[(k + 17)] = localParticle.position.z;
          if (this.item.particleConfig.getParticleEmitterConfig().getSprite() == null) {
            break label3830;
          }
          j = 0;
          label1431:
          if ((j < this.item.particleConfig.getParticleEmitterConfig().getSprite().size()) && (this.particleIndex < this.particleCount)) {
            break label3238;
          }
        }
      }
      for (;;)
      {
        Log.e("ParticleCount", "ParticleCount] " + this.particleIndex);
        break;
        if (this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypeRest.value)
        {
          localParticle.position = new Vector3(this.sourcePosition.x + localParticle.startPos.x, this.sourcePosition.y + localParticle.startPos.y, this.sourcePosition.z + localParticle.startPos.z);
          break label294;
        }
        int i;
        if ((this.emitterType == BasePaticleEmitter.kParticleTypes.kParticleTypePath.value) && (this.particlePathModel != null))
        {
          j = (int)((1.0F - localParticle.timeToLive / localParticle.lifespan) * this.particlePathModel.path.size());
          i = j;
          if (j < 0) {
            i = 0;
          }
          if (this.particleIndex >= this.particlePathModel.path.size()) {
            i = this.particlePathModel.path.size() - 1;
          }
          localObject1 = (ArrayList)this.particlePathModel.path.get(i);
          localObject2 = this.particlePathModel.anchorPoint;
          localObject1 = new Vector3(((Float)((ArrayList)localObject1).get(0)).floatValue() - ((Float)((ArrayList)localObject2).get(0)).floatValue(), ((Float)((ArrayList)localObject1).get(1)).floatValue() - ((Float)((ArrayList)localObject2).get(1)).floatValue(), ((Float)((ArrayList)localObject1).get(2)).floatValue() - ((Float)((ArrayList)localObject2).get(2)).floatValue());
          localObject2 = new float[16];
          Matrix.setIdentityM((float[])localObject2, 0);
          Matrix.rotateM((float[])localObject2, 0, -this.baseRotation, 0.0F, 0.0F, 1.0F);
          localObject3 = new float[4];
          Matrix.multiplyMV((float[])localObject3, (float[])localObject2, new float[] { ((Vector3)localObject1).x, ((Vector3)localObject1).y, ((Vector3)localObject1).z, 1.0F });
          localObject1 = new Vector3(localObject3[0], localObject3[1], localObject3[2]);
          f1 = this.sourcePosition.x;
          f2 = ((Vector3)localObject1).x;
          f3 = this.sourcePosition.y;
          f4 = ((Vector3)localObject1).y;
          f5 = this.sourcePosition.z;
          localParticle.position = new Vector3(f1 + f2, f3 - f4, ((Vector3)localObject1).z + f5);
          break label294;
        }
        localObject1 = new Vector3(0.0F, 0.0F, 0.0F);
        Object localObject2 = ParticleUtil.vectorSubtract(localParticle.startPos, new Vector3(0.0F, 0.0F, 0.0F));
        localParticle.position = ParticleUtil.vectorSubtract(localParticle.position, (Vector3)localObject2);
        if ((localParticle.position.x != 0.0F) || (localParticle.position.y != 0.0F) || (localParticle.position.z != 0.0F)) {
          localObject1 = ParticleUtil.vectorNormalize(localParticle.position);
        }
        Object localObject3 = ParticleUtil.vectorMultiplyScalar((Vector3)localObject1, localParticle.radialAcceleration);
        f1 = ((Vector3)localObject1).x;
        ((Vector3)localObject1).x = (-((Vector3)localObject1).y);
        ((Vector3)localObject1).y = f1;
        Vector3 localVector3 = ParticleUtil.vectorMultiplyScalar((Vector3)localObject1, localParticle.tangentialAcceleration);
        if (Math.abs(this.baseRotation) == 90.0F) {
          localObject1 = new Vector3(this.gravity.y, this.gravity.x, this.gravity.z);
        }
        for (;;)
        {
          localObject1 = ParticleUtil.vectorMultiplyScalar(ParticleUtil.vectorAdd(ParticleUtil.vectorAdd((Vector3)localObject3, localVector3), (Vector3)localObject1), paramFloat);
          localParticle.direction = ParticleUtil.vectorAdd(localParticle.direction, new Vector3(((Vector3)localObject1).x, ((Vector3)localObject1).y, ((Vector3)localObject1).z));
          localObject1 = ParticleUtil.vectorMultiplyScalar(localParticle.direction, paramFloat);
          localParticle.position = ParticleUtil.vectorAdd(localParticle.position, (Vector3)localObject1);
          localParticle.position = ParticleUtil.vectorAdd(localParticle.position, (Vector3)localObject2);
          break;
          if (Math.abs(this.baseRotation) == 180.0F) {
            localObject1 = new Vector3(-this.gravity.x, -this.gravity.y, this.gravity.z);
          } else if (Math.abs(this.baseRotation) == 270.0F) {
            localObject1 = new Vector3(-this.gravity.y, -this.gravity.x, this.gravity.z);
          } else {
            localObject1 = new Vector3(this.gravity.x, this.gravity.y, this.gravity.z);
          }
        }
        label2350:
        localObject1 = localParticle.color;
        ((Vector4)localObject1).r += localParticle.deltaColor.r * paramFloat;
        localObject1 = localParticle.color;
        ((Vector4)localObject1).g += localParticle.deltaColor.g * paramFloat;
        localObject1 = localParticle.color;
        ((Vector4)localObject1).b += localParticle.deltaColor.b * paramFloat;
        localObject1 = localParticle.color;
        ((Vector4)localObject1).a += localParticle.deltaColor.a * paramFloat;
        break label419;
        label2465:
        f1 = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width * f2;
        break label569;
        label2485:
        f1 = f2;
        break label569;
        label2491:
        this.quads[this.particleIndex].bl.vertex.x = (localParticle.position.x - f2);
        this.quads[this.particleIndex].bl.vertex.y = (localParticle.position.y - f1);
        this.quads[this.particleIndex].bl.color = localParticle.color;
        this.quads[this.particleIndex].br.vertex.x = (localParticle.position.x + f2);
        this.quads[this.particleIndex].br.vertex.y = (localParticle.position.y - f1);
        this.quads[this.particleIndex].br.color = localParticle.color;
        this.quads[this.particleIndex].tl.vertex.x = (localParticle.position.x - f2);
        this.quads[this.particleIndex].tl.vertex.y = (localParticle.position.y + f1);
        this.quads[this.particleIndex].tl.color = localParticle.color;
        this.quads[this.particleIndex].tr.vertex.x = (f2 + localParticle.position.x);
        this.quads[this.particleIndex].tr.vertex.y = (f1 + localParticle.position.y);
        this.quads[this.particleIndex].tr.color = localParticle.color;
        this.particleVertices[k] = this.quads[this.particleIndex].bl.vertex.x;
        this.particleVertices[(k + 1)] = this.quads[this.particleIndex].bl.vertex.y;
        this.particleVertices[(k + 2)] = localParticle.position.z;
        this.particleVertices[(k + 3)] = this.quads[this.particleIndex].br.vertex.x;
        this.particleVertices[(k + 4)] = this.quads[this.particleIndex].br.vertex.y;
        this.particleVertices[(k + 5)] = localParticle.position.z;
        this.particleVertices[(k + 6)] = this.quads[this.particleIndex].tl.vertex.x;
        this.particleVertices[(k + 7)] = this.quads[this.particleIndex].tl.vertex.y;
        this.particleVertices[(k + 8)] = localParticle.position.z;
        this.particleVertices[(k + 9)] = this.quads[this.particleIndex].br.vertex.x;
        this.particleVertices[(k + 10)] = this.quads[this.particleIndex].br.vertex.y;
        this.particleVertices[(k + 11)] = localParticle.position.z;
        this.particleVertices[(k + 12)] = this.quads[this.particleIndex].tl.vertex.x;
        this.particleVertices[(k + 13)] = this.quads[this.particleIndex].tl.vertex.y;
        this.particleVertices[(k + 14)] = localParticle.position.z;
        this.particleVertices[(k + 15)] = this.quads[this.particleIndex].tr.vertex.x;
        this.particleVertices[(k + 16)] = this.quads[this.particleIndex].tr.vertex.y;
        this.particleVertices[(k + 17)] = localParticle.position.z;
        break label1412;
        label3238:
        int m = this.particleIndex * 12;
        localObject1 = (ParticleConfig.ParticleEmitterConfigBean.Sprite)this.item.particleConfig.getParticleEmitterConfig().getSprite().get(j);
        k = (int)((localParticle.lifespan - localParticle.timeToLive) * 1000.0D / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).frameDuration) + localParticle.frameIndex;
        int n = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).row * ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).column;
        if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).looped == -1)
        {
          i = localParticle.frameIndex;
          k = i % ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).column;
          i /= ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).column;
          n = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).width;
          int i1 = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).height;
          f3 = 1.0F - i * i1 / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageHeight;
          f4 = 1.0F - (i + 1) * i1 / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageHeight;
          if (k != 0) {
            break label3774;
          }
          f1 = 0.0F;
          label3408:
          if (k != 0) {
            break label3793;
          }
        }
        label3774:
        label3793:
        for (f2 = n / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageWidth;; f2 = k * n / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageWidth)
        {
          this.particleTextureCoordinates[m] = f1;
          this.particleTextureCoordinates[(m + 1)] = f4;
          this.particleTextureCoordinates[(m + 2)] = f2;
          this.particleTextureCoordinates[(m + 3)] = f4;
          this.particleTextureCoordinates[(m + 4)] = f1;
          this.particleTextureCoordinates[(m + 5)] = f3;
          this.particleTextureCoordinates[(m + 6)] = this.particleTextureCoordinates[(m + 2)];
          this.particleTextureCoordinates[(m + 7)] = this.particleTextureCoordinates[(m + 3)];
          this.particleTextureCoordinates[(m + 8)] = this.particleTextureCoordinates[(m + 4)];
          this.particleTextureCoordinates[(m + 9)] = this.particleTextureCoordinates[(m + 5)];
          this.particleTextureCoordinates[(m + 10)] = f2;
          this.particleTextureCoordinates[(m + 11)] = f3;
          i = 0;
          while (i < 6)
          {
            k = this.particleIndex * 24 + i * 4;
            this.particleColors[k] = localParticle.color.r;
            this.particleColors[(k + 1)] = localParticle.color.g;
            this.particleColors[(k + 2)] = localParticle.color.b;
            this.particleColors[(k + 3)] = localParticle.color.a;
            i += 1;
          }
          if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).looped == 1)
          {
            i = k % n;
            break;
          }
          if (((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).looped == 2)
          {
            k %= n * 2;
            i = k;
            if (k < n) {
              break;
            }
            i = n * 2 - k - 1;
            break;
          }
          i = k;
          if (k < ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).frameCount) {
            break;
          }
          i = ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).frameCount - 1;
          break;
          f1 = (k - 1) * n / ((ParticleConfig.ParticleEmitterConfigBean.Sprite)localObject1).imageWidth;
          break label3408;
        }
        this.particleIndex += 1;
        j += 1;
        break label1431;
        label3830:
        this.particleIndex += 1;
        continue;
        if (this.particleIndex != this.particleCount - 1) {
          this.particles[this.particleIndex].copy(this.particles[(this.particleCount - 1)]);
        }
        this.particleCount -= 1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleEmitter3D
 * JD-Core Version:    0.7.0.1
 */