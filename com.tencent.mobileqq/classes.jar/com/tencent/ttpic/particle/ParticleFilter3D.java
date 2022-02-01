package com.tencent.ttpic.particle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.ar.sensor.representation.Matrix;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
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
  private static final String TAG = "ParticleFilter3D";
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
    if ((paramPTDetectInfo.bodyPoints != null) && (!paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = true;
      this.mHasSeenValid = true;
      this.mPreviousLostTime = System.currentTimeMillis();
      this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
      return;
    }
    this.mHasBodyDetected = false;
    if (this.mHasSeenValid)
    {
      if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
        paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
      }
    }
    else {
      this.mHasSeenValid = false;
    }
  }
  
  private float[] normalizePosition(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < arrayOfFloat.length / 3)
    {
      int j = i * 3;
      arrayOfFloat[j] = (paramArrayOfFloat[j] / paramInt1 * 2.0F - 1.0F);
      int k = j + 1;
      arrayOfFloat[k] = (paramArrayOfFloat[k] / paramInt2 * 2.0F - 1.0F);
      j += 2;
      arrayOfFloat[j] = paramArrayOfFloat[j];
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
      paramInt2 = paramInt1 * 3;
      float f1 = paramArrayOfFloat[paramInt2];
      int i = paramInt2 + 1;
      float f2 = paramArrayOfFloat[i];
      int j = paramInt2 + 2;
      float f3 = paramArrayOfFloat[j];
      arrayOfFloat3 = new float[4];
      Matrix.multiplyMV(arrayOfFloat3, arrayOfFloat1, new float[] { f1, f2, f3, 1.0F });
      arrayOfFloat2[paramInt2] = (arrayOfFloat3[0] / arrayOfFloat3[3]);
      arrayOfFloat2[i] = (arrayOfFloat3[1] / arrayOfFloat3[3]);
      arrayOfFloat2[j] = (arrayOfFloat3[2] / arrayOfFloat3[3]);
      paramInt1 += 1;
    }
    return arrayOfFloat2;
  }
  
  private void resetParams()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private ParticleFilter3D.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    ParticleFilter3D.ParticleEmitterParam localParticleEmitterParam = new ParticleFilter3D.ParticleEmitterParam(this, null);
    Vector3 localVector3 = new Vector3();
    int i = this.item.type;
    Object localObject;
    double d1;
    double d2;
    if (i != 1)
    {
      if ((i != 2) && (i != 4) && (i != 5))
      {
        if (i != 6)
        {
          localObject = localVector3;
        }
        else
        {
          localObject = localVector3;
          if (paramList != null)
          {
            localObject = localVector3;
            if (!paramList.isEmpty())
            {
              paramList = (PointF)paramList.get(Math.min(this.item.alignFacePoints[0], paramList.size() - 1));
              localObject = new Vector3(paramList.x, paramList.y, 0.0F);
              ((Vector3)localObject).x *= this.width;
              ((Vector3)localObject).y *= this.height;
              localParticleEmitterParam.extraScale = 1.0F;
              localParticleEmitterParam.rotateZ = 0.0F;
            }
          }
        }
      }
      else
      {
        localObject = localVector3;
        if (paramList != null)
        {
          localObject = localVector3;
          if (!paramList.isEmpty())
          {
            localObject = (PointF)paramList.get(this.item.alignFacePoints[0]);
            if (this.item.alignFacePoints.length == 1) {
              i = this.item.alignFacePoints[0];
            } else {
              i = this.item.alignFacePoints[1];
            }
            PointF localPointF = (PointF)paramList.get(i);
            localObject = new PointF((((PointF)localObject).x + localPointF.x) / 2.0F, (((PointF)localObject).y + localPointF.y) / 2.0F);
            if (VideoMaterial.isFaceItem(this.item))
            {
              d1 = ((PointF)localObject).x;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              ((PointF)localObject).x = ((float)(d1 / d2));
              d1 = ((PointF)localObject).y;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              ((PointF)localObject).y = ((float)(d1 / d2));
            }
            localVector3.x = ((PointF)localObject).x;
            localVector3.y = ((PointF)localObject).y;
            localPointF = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
            if (VideoMaterial.isFaceItem(this.item))
            {
              d1 = localPointF.x;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              localPointF.x = ((float)(d1 / d2));
              d1 = localPointF.y;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              localPointF.y = ((float)(d1 / d2));
            }
            paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
            if (VideoMaterial.isFaceItem(this.item))
            {
              d1 = paramList.x;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              paramList.x = ((float)(d1 / d2));
              d1 = paramList.y;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              paramList.y = ((float)(d1 / d2));
            }
            d1 = Math.sqrt(Math.pow(localPointF.x - paramList.x, 2.0D) + Math.pow(localPointF.y - paramList.y, 2.0D));
            d2 = this.item.scaleFactor;
            Double.isNaN(d2);
            d1 /= d2;
            float f;
            if ((this.item.type != 2) && (this.item.type != 4))
            {
              paramList = localVector3;
            }
            else
            {
              localParticleEmitterParam.extraScale = ((float)d1);
              f = (float)Math.pow(4.0D, 0.5D - d1);
              if (f <= 0.25D) {
                f = 0.25F;
              }
              paramList = new Vector3((((PointF)localObject).x - this.width / 2.0F) * f, this.height - (((PointF)localObject).y - this.height / 2.0F) * f, this.height * (1.0F - f));
            }
            if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3))
            {
              localParticleEmitterParam.rotateX = paramArrayOfFloat[0];
              localParticleEmitterParam.rotateY = paramArrayOfFloat[1];
              localParticleEmitterParam.rotateZ = paramArrayOfFloat[2];
              f = this.phoneAngles;
              if ((f == 270.0F) || (f == 180.0F)) {
                localParticleEmitterParam.rotateX = (-localParticleEmitterParam.rotateX);
              }
              f = this.phoneAngles;
              if (f != 90.0F)
              {
                localObject = paramList;
                if (f != 180.0F) {}
              }
              else
              {
                localParticleEmitterParam.rotateY = (-localParticleEmitterParam.rotateY);
                localObject = paramList;
              }
            }
            else
            {
              localParticleEmitterParam.rotateZ = ((float)Math.toRadians((360.0F - this.phoneAngles) % 360.0F));
              localObject = paramList;
            }
          }
        }
      }
    }
    else
    {
      d1 = this.width;
      d2 = this.height;
      Double.isNaN(d1);
      Double.isNaN(d2);
      int j;
      if (d1 / d2 >= 0.75D)
      {
        d1 = this.width;
        Double.isNaN(d1);
        int k = (int)(d1 / 0.75D);
        d1 = k;
        d2 = this.item.position[1];
        Double.isNaN(d1);
        i = (int)(d1 * d2);
        d1 = this.width;
        d2 = this.item.position[0];
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        k = (k - this.height) / 2;
        localVector3.x = j;
        localVector3.y = (i - k);
        localObject = localVector3;
      }
      else
      {
        d1 = this.height;
        Double.isNaN(d1);
        i = (int)(d1 * 0.75D);
        d1 = this.height;
        d2 = this.item.position[1];
        Double.isNaN(d1);
        j = (int)(d1 * d2);
        d1 = i;
        d2 = this.item.position[0];
        Double.isNaN(d1);
        localVector3.x = ((int)(d1 * d2) - (i - this.width) / 2);
        localVector3.y = j;
        localObject = localVector3;
      }
    }
    this.particleEmitter.clearPositionLossTrigger();
    localParticleEmitterParam.emitPosition = ((Vector3)localObject);
    localParticleEmitterParam.extraScale *= (float)this.audioScaleFactor;
    localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
    return localParticleEmitterParam;
  }
  
  private void updateHotArea(ArrayList<RedPacketPosition> paramArrayList)
  {
    ArrayList localArrayList = this.hotAreaPositions;
    if ((localArrayList != null) && (paramArrayList != null)) {
      localArrayList.addAll(paramArrayList);
    }
  }
  
  private void updateParticle(ParticleFilter3D.ParticleEmitterParam paramParticleEmitterParam)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    if (((paramObject instanceof PTDetectInfo)) && (!CollectionUtils.isEmpty(((PTDetectInfo)paramObject).handPoints)))
    {
      paramObject = this.particleEmitter;
      if (paramObject != null) {
        paramObject.clearPositionLossTrigger();
      }
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
      if (VideoMaterial.isGestureItem(this.item))
      {
        update(paramObject.handPoints, paramObject.faceAngles);
        return;
      }
      if (VideoMaterial.isBodyDetectItem(this.item))
      {
        update(paramObject.bodyPoints, paramObject.faceAngles);
        if (!this.mHasBodyDetected) {
          paramObject.bodyPoints = null;
        }
      }
      else
      {
        if (VideoMaterial.isStarItem(this.item))
        {
          update(paramObject.starPoints, paramObject.faceAngles);
          return;
        }
        update(paramObject.facePoints, paramObject.faceAngles);
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    paramInt2 = this.lastCanvasWidth;
    if ((paramInt1 > paramInt2) && (this.canvasScale < 0.0F)) {
      this.canvasScale = (paramInt1 * 1.0F / paramInt2);
    }
    this.lastCanvasWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleFilter3D
 * JD-Core Version:    0.7.0.1
 */