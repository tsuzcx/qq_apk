package com.tencent.ttpic.particle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.Mat4Param;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.List;

public class ParticleFilter3D
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n\nvarying vec4 vColor;\nvarying vec2 vTexCoords;\nvarying float vSpriteIndex;\n\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nuniform int isPartical2;\nuniform int u_opacityModifyRGB;\n\n\nvec4 color;\n\nvoid main() {\n\n    if (isPartical2 == 0) {\n        gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);//texture2D(inputImageTexture2, vTexCoords);\n        return;\n    }\n    else {\n\n        if (u_opacityModifyRGB == 1) {\n            color = vec4(vColor.r * vColor.a,\n            vColor.g * vColor.a,\n            vColor.b * vColor.a,\n            vColor.a);\n        } else {\n            color = vColor;\n        }\n\n        vec4 texColor;\n\n        texColor = texture2D(inputImageTexture0, vTexCoords);\n\n        gl_FragColor = vec4(texColor) * color;\n\n    }\n\n\n}";
  public static final String PARTICLE_3D_FLAG = "json";
  private static final String TAG = ParticleFilter3D.class.getSimpleName();
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec4 aColor;\n attribute float spriteIndex;\n\n varying vec2 vTexCoords;\n varying vec4 vColor;\n varying float vSpriteIndex;\n uniform mat4 u_MVPMatrix;\n\n\n void main() {\n     gl_Position = u_MVPMatrix * position;\n     vTexCoords  = inputTextureCoordinate;\n     vColor = aColor;\n     vSpriteIndex = spriteIndex;\n }";
  private double audioScaleFactor = 1.0D;
  private float canvasScale = -1.0F;
  private int frameInedx = 0;
  private ArrayList<RedPacketPosition> hotAreaPositions;
  protected StickerItem item;
  private int lastCanvasWidth = 2147483647;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  private List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  private long mTimesForLostProtect = 2000L;
  private float[] mvpMat = new float[16];
  private boolean needRender;
  private BasePaticleEmitter particleEmitter;
  private ParticleParam particleParam = new ParticleParam();
  private float phoneAngles;
  
  public ParticleFilter3D(String paramString, StickerItem paramStickerItem)
  {
    super(BaseFilter.nativeDecrypt("attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec4 aColor;\n attribute float spriteIndex;\n\n varying vec2 vTexCoords;\n varying vec4 vColor;\n varying float vSpriteIndex;\n uniform mat4 u_MVPMatrix;\n\n\n void main() {\n     gl_Position = u_MVPMatrix * position;\n     vTexCoords  = inputTextureCoordinate;\n     vColor = aColor;\n     vSpriteIndex = spriteIndex;\n }"), BaseFilter.nativeDecrypt("precision highp float;\n\nvarying vec4 vColor;\nvarying vec2 vTexCoords;\nvarying float vSpriteIndex;\n\nuniform sampler2D inputImageTexture0;\nuniform sampler2D inputImageTexture1;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform sampler2D inputImageTexture5;\nuniform sampler2D inputImageTexture6;\nuniform sampler2D inputImageTexture7;\n\nuniform int isPartical2;\nuniform int u_opacityModifyRGB;\n\n\nvec4 color;\n\nvoid main() {\n\n    if (isPartical2 == 0) {\n        gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);//texture2D(inputImageTexture2, vTexCoords);\n        return;\n    }\n    else {\n\n        if (u_opacityModifyRGB == 1) {\n            color = vec4(vColor.r * vColor.a,\n            vColor.g * vColor.a,\n            vColor.b * vColor.a,\n            vColor.a);\n        } else {\n            color = vColor;\n        }\n\n        vec4 texColor;\n\n        texColor = texture2D(inputImageTexture0, vTexCoords);\n\n        gl_FragColor = vec4(texColor) * color;\n\n    }\n\n\n}"));
    this.item = paramStickerItem;
    this.particleEmitter = new ParticleEmitter3D(paramStickerItem);
    this.particleEmitter.initEmitter(paramString, paramStickerItem.particleConfig);
    this.particleEmitter.setRotateType(paramStickerItem.rotateType);
    initParams();
    setDrawMode(AEOpenRenderConfig.DRAW_MODE.TRIANGLES);
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo.bodyPoints == null) || (paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = false;
      if (this.mHasSeenValid)
      {
        if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
          paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        }
        return;
      }
      this.mHasSeenValid = false;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
  }
  
  private float[] normalizePosition(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < arrayOfFloat.length / 3)
    {
      arrayOfFloat[(i * 3)] = (paramArrayOfFloat[(i * 3)] / paramInt1 * 2.0F - 1.0F);
      arrayOfFloat[(i * 3 + 1)] = (paramArrayOfFloat[(i * 3 + 1)] / paramInt2 * 2.0F - 1.0F);
      arrayOfFloat[(i * 3 + 2)] = paramArrayOfFloat[(i * 3 + 2)];
      i += 1;
    }
    return arrayOfFloat;
  }
  
  private float[] normalizePosition3D(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat2 = MatrixUtil.genProjectionMatrix(paramInt1, paramInt2);
    float[] arrayOfFloat3 = MatrixUtil.genLookAtMatrix(paramInt1, paramInt2);
    float[] arrayOfFloat1 = new float[16];
    Matrix.multiplyMM(arrayOfFloat1, arrayOfFloat2, arrayOfFloat3);
    arrayOfFloat2 = new float[paramArrayOfFloat.length];
    paramInt1 = 0;
    while (paramInt1 < arrayOfFloat2.length / 3)
    {
      float f1 = paramArrayOfFloat[(paramInt1 * 3)];
      float f2 = paramArrayOfFloat[(paramInt1 * 3 + 1)];
      float f3 = paramArrayOfFloat[(paramInt1 * 3 + 2)];
      arrayOfFloat3 = new float[4];
      Matrix.multiplyMV(arrayOfFloat3, arrayOfFloat1, new float[] { f1, f2, f3, 1.0F });
      arrayOfFloat2[(paramInt1 * 3)] = (arrayOfFloat3[0] / arrayOfFloat3[3]);
      arrayOfFloat2[(paramInt1 * 3 + 1)] = (arrayOfFloat3[1] / arrayOfFloat3[3]);
      arrayOfFloat2[(paramInt1 * 3 + 2)] = (arrayOfFloat3[2] / arrayOfFloat3[3]);
      paramInt1 += 1;
    }
    return arrayOfFloat2;
  }
  
  private void resetParams()
  {
    int i = 1;
    addParam(new UniformParam.IntParam("isPartical2", 1));
    if (this.particleEmitter.opacityModifyRGB) {}
    for (;;)
    {
      addParam(new UniformParam.IntParam("u_opacityModifyRGB", i));
      addParam(new UniformParam.TextureParam("inputImageTexture0", 0, 33985));
      addParam(new UniformParam.TextureParam("inputImageTexture1", 0, 33986));
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33987));
      addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33988));
      addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33989));
      addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33990));
      addParam(new UniformParam.TextureParam("inputImageTexture6", 0, 33991));
      addParam(new UniformParam.TextureParam("inputImageTexture7", 0, 33992));
      setCoordNum(6);
      addAttribParam(new AttributeParam("position", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
      addAttribParam(new AttributeParam("inputTextureCoordinate", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 2));
      addAttribParam(new AttributeParam("aColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 4));
      this.mHasSeenValid = false;
      this.mPreviousBodyPoints = null;
      this.particleParam.needRender = false;
      return;
      i = 0;
    }
  }
  
  private ParticleFilter3D.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    ParticleFilter3D.ParticleEmitterParam localParticleEmitterParam = new ParticleFilter3D.ParticleEmitterParam(this, null);
    Vector3 localVector3 = new Vector3();
    label67:
    int i;
    label351:
    float f;
    switch (this.item.type)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
      do
      {
        paramList = localVector3;
        for (;;)
        {
          this.particleEmitter.clearPositionLossTrigger();
          localParticleEmitterParam.emitPosition = paramList;
          localParticleEmitterParam.extraScale *= (float)this.audioScaleFactor;
          localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
          return localParticleEmitterParam;
          int j;
          if (this.width / this.height >= 0.75D)
          {
            int k = (int)(this.width / 0.75D);
            i = (int)(k * this.item.position[1]);
            j = (int)(this.width * this.item.position[0]);
            k = (k - this.height) / 2;
            localVector3.x = j;
            localVector3.y = (i - k);
            paramList = localVector3;
          }
          else
          {
            i = (int)(this.height * 0.75D);
            j = (int)(this.height * this.item.position[1]);
            localVector3.x = ((int)(i * this.item.position[0]) - (i - this.width) / 2);
            localVector3.y = j;
            paramList = localVector3;
          }
        }
      } while ((paramList == null) || (paramList.isEmpty()));
      PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      if (this.item.alignFacePoints.length == 1)
      {
        i = this.item.alignFacePoints[0];
        PointF localPointF2 = (PointF)paramList.get(i);
        localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
        if (VideoMaterial.isFaceItem(this.item))
        {
          localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
          localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
        }
        localVector3.x = localPointF1.x;
        localVector3.y = localPointF1.y;
        localPointF2 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
        if (VideoMaterial.isFaceItem(this.item))
        {
          localPointF2.x = ((float)(localPointF2.x / this.mFaceDetScale));
          localPointF2.y = ((float)(localPointF2.y / this.mFaceDetScale));
        }
        paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
        if (VideoMaterial.isFaceItem(this.item))
        {
          paramList.x = ((float)(paramList.x / this.mFaceDetScale));
          paramList.y = ((float)(paramList.y / this.mFaceDetScale));
        }
        double d = Math.pow(localPointF2.x - paramList.x, 2.0D);
        d = Math.sqrt(Math.pow(localPointF2.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
        if ((this.item.type != 2) && (this.item.type != 4)) {
          break label1070;
        }
        localParticleEmitterParam.extraScale = ((float)d);
        f = (float)Math.pow(4.0D, 0.5D - d);
        if (f <= 0.25D) {
          break label931;
        }
        label751:
        localVector3 = new Vector3((localPointF1.x - this.width / 2.0F) * f, this.height - (localPointF1.y - this.height / 2.0F) * f, (1.0F - f) * this.height);
      }
      break;
    }
    label931:
    label1070:
    for (;;)
    {
      if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3))
      {
        localParticleEmitterParam.rotateX = paramArrayOfFloat[0];
        localParticleEmitterParam.rotateY = paramArrayOfFloat[1];
        localParticleEmitterParam.rotateZ = paramArrayOfFloat[2];
        if ((this.phoneAngles == 270.0F) || (this.phoneAngles == 180.0F)) {
          localParticleEmitterParam.rotateX = (-localParticleEmitterParam.rotateX);
        }
        if (this.phoneAngles != 90.0F)
        {
          paramList = localVector3;
          if (this.phoneAngles != 180.0F) {
            break label67;
          }
        }
        localParticleEmitterParam.rotateY = (-localParticleEmitterParam.rotateY);
        paramList = localVector3;
        break label67;
        i = this.item.alignFacePoints[1];
        break label351;
        f = 0.25F;
        break label751;
      }
      localParticleEmitterParam.rotateZ = ((float)Math.toRadians((360.0F - this.phoneAngles) % 360.0F));
      paramList = localVector3;
      break label67;
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
      paramList = (PointF)paramList.get(Math.min(this.item.alignFacePoints[0], paramList.size() - 1));
      paramList = new Vector3(paramList.x, paramList.y, 0.0F);
      paramList.x *= this.width;
      paramList.y *= this.height;
      localParticleEmitterParam.extraScale = 1.0F;
      localParticleEmitterParam.rotateZ = 0.0F;
      break label67;
    }
  }
  
  private void updateHotArea(ArrayList<RedPacketPosition> paramArrayList)
  {
    if ((this.hotAreaPositions != null) && (paramArrayList != null)) {
      this.hotAreaPositions.addAll(paramArrayList);
    }
  }
  
  private void updateParticle(ParticleFilter3D.ParticleEmitterParam paramParticleEmitterParam)
  {
    Object localObject1 = paramParticleEmitterParam.emitPosition;
    float f1 = paramParticleEmitterParam.extraScale;
    this.particleEmitter.setBaseRotation(-this.phoneAngles);
    int i = this.item.particleConfig.getParticleEmitterConfig().emitterType.value;
    int i4;
    float[] arrayOfFloat;
    Object localObject2;
    int n;
    int j;
    int m;
    int k;
    int i2;
    int i1;
    if ((this.particleEmitter.totalFinished()) || ((!this.needRender) && ((i == BasePaticleEmitter.kParticleTypes.kParticleTypeRest.value) || (i == BasePaticleEmitter.kParticleTypes.kParticleTypePath.value))))
    {
      this.particleEmitter.startTime = 0L;
      this.particleEmitter.reset();
      this.particleEmitter.setupArrays();
      i4 = this.particleEmitter.activeParticleCount();
      if (i4 > 0)
      {
        paramParticleEmitterParam = new float[i4 * 18];
        localObject1 = new float[i4 * 12];
        arrayOfFloat = new float[i4 * 24];
        localObject2 = new float[i4];
        i = 0;
        n = 0;
        j = 0;
        m = 0;
        k = 0;
        i2 = 0;
        BenchUtil.benchStart("setValue");
        i1 = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i1 >= this.particleEmitter.activeParticleCount()) {
          break label624;
        }
        if (this.particleEmitter.textures != null) {
          localObject2[i1] = this.particleEmitter.particleSpriteIndex[i1];
        }
        int i3 = 0;
        while (i3 < 24)
        {
          arrayOfFloat[(k + i3)] = this.particleEmitter.particleColors[(i2 + i3)];
          i3 += 1;
          continue;
          float f2 = (float)this.audioScaleFactor;
          LogUtils.e(TAG, "AudioScaleFactor = " + f2);
          this.particleEmitter.setExtraScale(f2);
          this.particleEmitter.setSourcePosition((Vector3)localObject1);
          this.particleEmitter.setExtraScale(f1);
          this.particleEmitter.setRotateX(paramParticleEmitterParam.rotateX);
          this.particleEmitter.setRotateY(paramParticleEmitterParam.rotateY);
          this.particleEmitter.setRotateZ(paramParticleEmitterParam.rotateZ);
          if (this.canvasScale > 0.0F)
          {
            this.particleEmitter.setCanvasScaleForTakeLargePicture(this.canvasScale);
            this.particleEmitter.updateWithCurrentTime(this.particleEmitter.startTime, this.needRender);
            this.particleEmitter.setCanvasScaleForTakeLargePicture(1.0F);
            this.canvasScale = -1.0F;
          }
          for (;;)
          {
            BenchUtil.benchStart("updateWithCurrentTime");
            BenchUtil.benchEnd("updateWithCurrentTime");
            break;
            this.particleEmitter.updateWithCurrentTime(System.currentTimeMillis(), this.needRender);
          }
        }
        i3 = 0;
        if (i3 < 18)
        {
          if ((i3 + 2) % 3 == 0) {
            paramParticleEmitterParam[(i + i3)] = (this.height - this.particleEmitter.particleVertices[(n + i3)]);
          }
          for (;;)
          {
            i3 += 1;
            break;
            paramParticleEmitterParam[(i + i3)] = this.particleEmitter.particleVertices[(n + i3)];
          }
        }
        i3 = 0;
        if (i3 < 12)
        {
          if (i3 % 2 != 0) {}
          for (f1 = 1.0F - this.particleEmitter.particleTextureCoordinates[(m + i3)];; f1 = this.particleEmitter.particleTextureCoordinates[(m + i3)])
          {
            localObject1[(j + i3)] = f1;
            i3 += 1;
            break;
          }
        }
        i2 += 24;
        n += 18;
        m += 12;
        k += 24;
        i += 18;
        j += 12;
        i1 += 1;
      }
      label624:
      BenchUtil.benchEnd("setValue");
      setCoordNum(i4 * 6);
      addAttribParam(new AttributeParam("spriteIndex", (float[])localObject2, 1));
      i = 33985;
      j = 0;
      while (j < this.particleEmitter.textures.length)
      {
        addParam(new UniformParam.TextureParam("inputImageTexture" + j, this.particleEmitter.textures[j], i));
        j += 1;
        i += 1;
      }
      addParam(new UniformParam.IntParam("isPartical2", 1));
      addAttribParam(new AttributeParam("aColor", arrayOfFloat, 4));
      MatrixUtil.getMVPMatrix(this.mvpMat, this.width, this.height);
      addParam(new UniformParam.Mat4Param("u_MVPMatrix", this.mvpMat));
      addAttribParam(new AttributeParam("position", paramParticleEmitterParam, 3));
      setTexCords((float[])localObject1);
      if (this.particleEmitter.opacityModifyRGB)
      {
        i = 1;
        addParam(new UniformParam.IntParam("u_opacityModifyRGB", i));
        if ((VideoMaterial.isBodyDetectItem(this.item)) || (VideoMaterial.isStarItem(this.item)))
        {
          if (this.particleParam == null) {
            this.particleParam = new ParticleParam();
          }
          this.particleParam.id = (this.item.id + this.item.alignFacePoints[0]);
          this.particleParam.needRender = true;
          this.particleParam.coordNum = (i4 * 6);
          this.particleParam.blendFuncSrc = this.particleEmitter.blendFuncSource;
          this.particleParam.blendFuncDst = this.particleEmitter.blendFuncDestination;
          localObject2 = this.particleParam;
          if ((this.particleEmitter.textures == null) || (this.particleEmitter.textures.length <= 0)) {
            break label1123;
          }
          i = this.particleEmitter.textures[0];
          label1014:
          ((ParticleParam)localObject2).texture = i;
          this.particleParam.isPartical2 = 1;
          localObject2 = this.particleParam;
          if (!this.particleEmitter.opacityModifyRGB) {
            break label1129;
          }
        }
      }
      label1123:
      label1129:
      for (i = 1;; i = 0)
      {
        ((ParticleParam)localObject2).uOpacityModifyRGB = i;
        this.particleParam.maxParticleNum = this.item.particleConfig.getParticleEmitterConfig().getMaxParticles().getValue();
        this.particleParam.aColor = arrayOfFloat;
        this.particleParam.position = normalizePosition(paramParticleEmitterParam, this.width, this.height);
        this.particleParam.inputTextureCoordinate = ((float[])localObject1);
        return;
        i = 0;
        break;
        i = 0;
        break label1014;
      }
    }
    resetParams();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.particleEmitter.clear();
  }
  
  public ParticleParam getParticleParam()
  {
    return this.particleParam;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    addAttribParam(new AttributeParam("position", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 3));
    addAttribParam(new AttributeParam("inputTextureCoordinate", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("aColor", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 4));
  }
  
  public void initParams()
  {
    int i = 1;
    addParam(new UniformParam.IntParam("isPartical2", 1));
    if (this.particleEmitter.opacityModifyRGB) {}
    for (;;)
    {
      addParam(new UniformParam.IntParam("u_opacityModifyRGB", i));
      addParam(new UniformParam.TextureParam("inputImageTexture0", 0, 33985));
      addParam(new UniformParam.TextureParam("inputImageTexture1", 0, 33986));
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33987));
      addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33988));
      addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33989));
      addParam(new UniformParam.TextureParam("inputImageTexture5", 0, 33990));
      addParam(new UniformParam.TextureParam("inputImageTexture6", 0, 33991));
      addParam(new UniformParam.TextureParam("inputImageTexture7", 0, 33992));
      setCoordNum(6);
      this.particleParam.needRender = false;
      return;
      i = 0;
    }
  }
  
  public boolean isBodyNeeded()
  {
    return this.item.type == VideoFilterFactory.POSITION_TYPE.BODY.type;
  }
  
  public boolean isStatic()
  {
    return (this.item.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (this.item.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glClear(256);
    boolean bool1 = GlUtil.curBlendModeEnabled;
    GLES20.glEnable(3042);
    GLES20.glEnable(2929);
    GLES20.glBlendFunc(this.particleEmitter.blendFuncSource, this.particleEmitter.blendFuncDestination);
    boolean bool2 = super.renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(bool1);
    return bool2;
  }
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  public void stopParticle3D(Object paramObject)
  {
    if (((paramObject instanceof PTDetectInfo)) && (!CollectionUtils.isEmpty(((PTDetectInfo)paramObject).handPoints)) && (this.particleEmitter != null)) {
      this.particleEmitter.clearPositionLossTrigger();
    }
  }
  
  protected void update(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    try
    {
      updateParticle(updateEmitterParam(paramList, paramArrayOfFloat));
      return;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      if (VideoMaterial.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      this.phoneAngles = paramObject.phoneAngle;
      this.needRender = paramObject.needRender;
      this.frameInedx = paramObject.frameIndex;
      this.audioScaleFactor = paramObject.audioScaleFactor;
      updateHotArea(paramObject.redPacketPositions);
      if (!VideoMaterial.isGestureItem(this.item)) {
        break label90;
      }
      update(paramObject.handPoints, paramObject.faceAngles);
    }
    label90:
    do
    {
      return;
      if (!VideoMaterial.isBodyDetectItem(this.item)) {
        break;
      }
      update(paramObject.bodyPoints, paramObject.faceAngles);
    } while (this.mHasBodyDetected);
    paramObject.bodyPoints = null;
    return;
    if (VideoMaterial.isStarItem(this.item))
    {
      update(paramObject.starPoints, paramObject.faceAngles);
      return;
    }
    update(paramObject.facePoints, paramObject.faceAngles);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if ((paramInt1 > this.lastCanvasWidth) && (this.canvasScale < 0.0F)) {
      this.canvasScale = (paramInt1 * 1.0F / this.lastCanvasWidth);
    }
    this.lastCanvasWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleFilter3D
 * JD-Core Version:    0.7.0.1
 */