package com.tencent.ttpic.particle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.List;

public class ParticleFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n\n varying vec4 vColor;\n varying vec2 vTexCoords;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n uniform int isPartical2;\n uniform int u_opacityModifyRGB;\n\n\n vec4 color;\n\n void main() {\n\n     if (isPartical2 == 0) {\n         gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);//texture2D(inputImageTexture2, vTexCoords);\n         return;\n     }\n     else {\n\n         if (u_opacityModifyRGB == 1) {\n             color = vec4(vColor.r * vColor.a,\n                          vColor.g * vColor.a,\n                          vColor.b * vColor.a,\n                          vColor.a);\n         } else {\n             color = vColor;\n         }\n\n         vec4 texColor = texture2D(inputImageTexture2, vTexCoords);\n         gl_FragColor = vec4(texColor) * vColor;\n\n     }\n\n\n }";
  private static final String TAG = "ParticleFilter";
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec4 aColor;\n\n varying vec2 vTexCoords;\n varying vec4 vColor;\n\n void main() {\n     gl_Position = position;\n     vTexCoords  = inputTextureCoordinate;\n     vColor = aColor;\n }";
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
  private ParticleEmitter particleEmitter;
  private ParticleParam particleParam = new ParticleParam();
  private float phoneAngles;
  
  public ParticleFilter(String paramString, StickerItem paramStickerItem)
  {
    super(BaseFilter.nativeDecrypt("attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n attribute vec4 aColor;\n\n varying vec2 vTexCoords;\n varying vec4 vColor;\n\n void main() {\n     gl_Position = position;\n     vTexCoords  = inputTextureCoordinate;\n     vColor = aColor;\n }"), BaseFilter.nativeDecrypt("precision highp float;\n\n varying vec4 vColor;\n varying vec2 vTexCoords;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n uniform int isPartical2;\n uniform int u_opacityModifyRGB;\n\n\n vec4 color;\n\n void main() {\n\n     if (isPartical2 == 0) {\n         gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);//texture2D(inputImageTexture2, vTexCoords);\n         return;\n     }\n     else {\n\n         if (u_opacityModifyRGB == 1) {\n             color = vec4(vColor.r * vColor.a,\n                          vColor.g * vColor.a,\n                          vColor.b * vColor.a,\n                          vColor.a);\n         } else {\n             color = vColor;\n         }\n\n         vec4 texColor = texture2D(inputImageTexture2, vTexCoords);\n         gl_FragColor = vec4(texColor) * vColor;\n\n     }\n\n\n }"));
    this.item = paramStickerItem;
    this.particleEmitter = new ParticleEmitter();
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
  
  private ParticleFilter.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    PointF localPointF2 = null;
    ParticleFilter.ParticleEmitterParam localParticleEmitterParam = new ParticleFilter.ParticleEmitterParam(this, null);
    int i = this.item.type;
    PointF localPointF1;
    double d1;
    double d2;
    if (i != 1)
    {
      if ((i != 2) && (i != 4) && (i != 5))
      {
        if (i != 6)
        {
          localPointF1 = localPointF2;
        }
        else
        {
          localPointF1 = localPointF2;
          if (paramList != null)
          {
            localPointF1 = localPointF2;
            if (!paramList.isEmpty())
            {
              paramList = (PointF)paramList.get(Math.min(this.item.alignFacePoints[0], paramList.size() - 1));
              localPointF1 = new PointF(paramList.x, paramList.y);
              localPointF1.x *= this.width;
              localPointF1.y *= this.height;
              localParticleEmitterParam.extraScale = 1.0F;
              localParticleEmitterParam.rotateZ = 0.0F;
            }
          }
        }
      }
      else
      {
        localPointF1 = localPointF2;
        if (paramList != null)
        {
          localPointF1 = localPointF2;
          if (!paramList.isEmpty())
          {
            localPointF2 = new PointF();
            localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
            if (this.item.alignFacePoints.length == 1) {
              i = this.item.alignFacePoints[0];
            } else {
              i = this.item.alignFacePoints[1];
            }
            PointF localPointF3 = (PointF)paramList.get(i);
            localPointF1 = new PointF((localPointF1.x + localPointF3.x) / 2.0F, (localPointF1.y + localPointF3.y) / 2.0F);
            if (VideoMaterial.isFaceItem(this.item))
            {
              d1 = localPointF1.x;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              localPointF1.x = ((float)(d1 / d2));
              d1 = localPointF1.y;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              localPointF1.y = ((float)(d1 / d2));
            }
            localPointF2.x = localPointF1.x;
            localPointF2.y = localPointF1.y;
            localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
            if (VideoMaterial.isFaceItem(this.item))
            {
              d1 = localPointF1.x;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              localPointF1.x = ((float)(d1 / d2));
              d1 = localPointF1.y;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              localPointF1.y = ((float)(d1 / d2));
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
            d1 = Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D));
            d2 = this.item.scaleFactor;
            Double.isNaN(d2);
            d1 /= d2;
            if (this.item.type == 2) {
              localParticleEmitterParam.extraScale = ((float)d1);
            }
            localPointF1 = localPointF2;
            if (paramArrayOfFloat != null)
            {
              localPointF1 = localPointF2;
              if (paramArrayOfFloat.length >= 3)
              {
                localParticleEmitterParam.rotateX = paramArrayOfFloat[0];
                localParticleEmitterParam.rotateY = paramArrayOfFloat[1];
                localParticleEmitterParam.rotateZ = paramArrayOfFloat[2];
                localPointF1 = localPointF2;
              }
            }
          }
        }
      }
    }
    else
    {
      localPointF1 = new PointF();
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
        localPointF1.x = j;
        localPointF1.y = (i - k);
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
        localPointF1.x = ((int)(d1 * d2) - (i - this.width) / 2);
        localPointF1.y = j;
      }
    }
    localParticleEmitterParam.emitPosition = localPointF1;
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
  
  private void updateParticle(ParticleFilter.ParticleEmitterParam paramParticleEmitterParam)
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
    boolean bool1 = GlUtil.curBlendModeEnabled;
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(this.particleEmitter.blendFuncSource, this.particleEmitter.blendFuncDestination);
    boolean bool2 = super.renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(bool1);
    return bool2;
  }
  
  public void resetParams()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setHotAreaPosition(ArrayList<RedPacketPosition> paramArrayList)
  {
    this.hotAreaPositions = paramArrayList;
  }
  
  protected void update(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    updateParticle(updateEmitterParam(paramList, paramArrayOfFloat));
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
 * Qualified Name:     com.tencent.ttpic.particle.ParticleFilter
 * JD-Core Version:    0.7.0.1
 */