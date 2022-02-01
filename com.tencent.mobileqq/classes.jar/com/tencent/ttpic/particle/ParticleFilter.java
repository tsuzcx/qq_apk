package com.tencent.ttpic.particle;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.AEOpenRenderConfig.DRAW_MODE;
import com.tencent.aekit.openrender.AttributeParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.ParticleParam;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.RedPacketPosition;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import java.util.ArrayList;
import java.util.List;

public class ParticleFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n\n varying vec4 vColor;\n varying vec2 vTexCoords;\n\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n\n uniform int isPartical2;\n uniform int u_opacityModifyRGB;\n\n\n vec4 color;\n\n void main() {\n\n     if (isPartical2 == 0) {\n         gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0);//texture2D(inputImageTexture2, vTexCoords);\n         return;\n     }\n     else {\n\n         if (u_opacityModifyRGB == 1) {\n             color = vec4(vColor.r * vColor.a,\n                          vColor.g * vColor.a,\n                          vColor.b * vColor.a,\n                          vColor.a);\n         } else {\n             color = vColor;\n         }\n\n         vec4 texColor = texture2D(inputImageTexture2, vTexCoords);\n         gl_FragColor = vec4(texColor) * vColor;\n\n     }\n\n\n }";
  private static final String TAG = ParticleFilter.class.getSimpleName();
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
  
  private ParticleFilter.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    ParticleFilter.ParticleEmitterParam localParticleEmitterParam = new ParticleFilter.ParticleEmitterParam(this, null);
    PointF localPointF2 = null;
    PointF localPointF1 = localPointF2;
    switch (this.item.type)
    {
    default: 
      localPointF1 = localPointF2;
    }
    for (;;)
    {
      localParticleEmitterParam.emitPosition = localPointF1;
      localParticleEmitterParam.extraScale *= (float)this.audioScaleFactor;
      localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
      return localParticleEmitterParam;
      localPointF1 = new PointF();
      int i;
      int j;
      if (this.width / this.height >= 0.75D)
      {
        int k = (int)(this.width / 0.75D);
        i = (int)(k * this.item.position[1]);
        j = (int)(this.width * this.item.position[0]);
        k = (k - this.height) / 2;
        localPointF1.x = j;
        localPointF1.y = (i - k);
      }
      else
      {
        i = (int)(this.height * 0.75D);
        j = (int)(this.height * this.item.position[1]);
        localPointF1.x = ((int)(i * this.item.position[0]) - (i - this.width) / 2);
        localPointF1.y = j;
        continue;
        localPointF1 = localPointF2;
        if (paramList != null)
        {
          localPointF1 = localPointF2;
          if (!paramList.isEmpty())
          {
            localPointF1 = new PointF();
            localPointF2 = (PointF)paramList.get(this.item.alignFacePoints[0]);
            if (this.item.alignFacePoints.length == 1) {}
            for (i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
            {
              PointF localPointF3 = (PointF)paramList.get(i);
              localPointF2 = new PointF((localPointF2.x + localPointF3.x) / 2.0F, (localPointF2.y + localPointF3.y) / 2.0F);
              if (VideoMaterialUtil.isFaceItem(this.item))
              {
                localPointF2.x = ((float)(localPointF2.x / this.mFaceDetScale));
                localPointF2.y = ((float)(localPointF2.y / this.mFaceDetScale));
              }
              localPointF1.x = localPointF2.x;
              localPointF1.y = localPointF2.y;
              localPointF2 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
              if (VideoMaterialUtil.isFaceItem(this.item))
              {
                localPointF2.x = ((float)(localPointF2.x / this.mFaceDetScale));
                localPointF2.y = ((float)(localPointF2.y / this.mFaceDetScale));
              }
              paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
              if (VideoMaterialUtil.isFaceItem(this.item))
              {
                paramList.x = ((float)(paramList.x / this.mFaceDetScale));
                paramList.y = ((float)(paramList.y / this.mFaceDetScale));
              }
              double d = Math.pow(localPointF2.x - paramList.x, 2.0D);
              d = Math.sqrt(Math.pow(localPointF2.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
              if (this.item.type == 2) {
                localParticleEmitterParam.extraScale = ((float)d);
              }
              if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3))
              {
                localParticleEmitterParam.rotateX = paramArrayOfFloat[0];
                localParticleEmitterParam.rotateY = paramArrayOfFloat[1];
                localParticleEmitterParam.rotateZ = paramArrayOfFloat[2];
              }
              break;
            }
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
      }
    }
  }
  
  private void updateHotArea(ArrayList<RedPacketPosition> paramArrayList)
  {
    if ((this.hotAreaPositions != null) && (paramArrayList != null)) {
      this.hotAreaPositions.addAll(paramArrayList);
    }
  }
  
  private void updateParticle(ParticleFilter.ParticleEmitterParam paramParticleEmitterParam)
  {
    Object localObject2 = paramParticleEmitterParam.emitPosition;
    float f1 = paramParticleEmitterParam.extraScale;
    if (this.item.followPhoneAngle) {
      this.particleEmitter.setBaseRotation(-this.phoneAngles);
    }
    Object localObject1;
    int i4;
    int n;
    int j;
    int m;
    int k;
    int i2;
    int i1;
    if (this.particleEmitter.totalFinished())
    {
      this.particleEmitter.reset();
      this.particleEmitter.startTime = -1L;
      localObject1 = this.particleEmitter;
      if (localObject2 != null)
      {
        paramParticleEmitterParam = new Vector2(((PointF)localObject2).x, this.height - ((PointF)localObject2).y);
        ((ParticleEmitter)localObject1).setSourcePosition(paramParticleEmitterParam);
        this.particleEmitter.setRotateZ(0.0F);
        this.particleEmitter.setExtraScale(1.0F);
        this.particleEmitter.startTime = System.currentTimeMillis();
        i4 = this.particleEmitter.activeParticleCount();
        if (i4 <= 0) {
          break label1094;
        }
        paramParticleEmitterParam = new float[i4 * 18];
        localObject1 = new float[i4 * 12];
        localObject2 = new float[i4 * 24];
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
    Object localObject3;
    for (;;)
    {
      if (i1 >= this.particleEmitter.activeParticleCount()) {
        break label710;
      }
      int i3 = 0;
      for (;;)
      {
        if (i3 < 24)
        {
          localObject2[(k + i3)] = this.particleEmitter.particleColors[(i2 + i3)];
          i3 += 1;
          continue;
          paramParticleEmitterParam = new Vector2();
          break;
          float f2 = (float)this.audioScaleFactor;
          LogUtils.e(TAG, "AudioScaleFactor = " + f2);
          this.particleEmitter.setExtraScale(f2);
          localObject3 = this.particleEmitter;
          if (localObject2 != null)
          {
            localObject1 = new Vector2(((PointF)localObject2).x, this.height - ((PointF)localObject2).y);
            label333:
            ((ParticleEmitter)localObject3).setSourcePosition((Vector2)localObject1);
            this.particleEmitter.setExtraScale(f1);
            this.particleEmitter.setRotateX(paramParticleEmitterParam.rotateX);
            this.particleEmitter.setRotateY(paramParticleEmitterParam.rotateY);
            this.particleEmitter.setRotateZ(paramParticleEmitterParam.rotateZ);
            if (this.canvasScale <= 0.0F) {
              break label479;
            }
            this.particleEmitter.setCanvasScaleForTakeLargePicture(this.canvasScale);
            paramParticleEmitterParam = this.particleEmitter;
            l = this.particleEmitter.startTime;
            if (localObject2 == null) {
              break label473;
            }
          }
          label473:
          for (boolean bool = true;; bool = false)
          {
            paramParticleEmitterParam.updateWithCurrentTime(l, bool);
            this.particleEmitter.setCanvasScaleForTakeLargePicture(1.0F);
            this.canvasScale = -1.0F;
            BenchUtil.benchStart("updateWithCurrentTime");
            BenchUtil.benchEnd("updateWithCurrentTime");
            break;
            localObject1 = new Vector2();
            break label333;
          }
          label479:
          paramParticleEmitterParam = this.particleEmitter;
          long l = System.currentTimeMillis();
          if (localObject2 != null) {}
          for (bool = true;; bool = false)
          {
            paramParticleEmitterParam.updateWithCurrentTime(l, bool);
            break;
          }
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
    label710:
    BenchUtil.benchEnd("setValue");
    setCoordNum(i4 * 6);
    addParam(new UniformParam.TextureParam("inputImageTexture2", this.particleEmitter.texture, 33986));
    addParam(new UniformParam.IntParam("isPartical2", 1));
    addAttribParam(new AttributeParam("aColor", (float[])localObject2, 4));
    addAttribParam(new AttributeParam("position", normalizePosition(paramParticleEmitterParam, this.width, this.height), 3));
    setTexCords((float[])localObject1);
    if (this.particleEmitter.opacityModifyRGB)
    {
      i = 1;
      addParam(new UniformParam.IntParam("u_opacityModifyRGB", i));
      if ((VideoMaterialUtil.isBodyDetectItem(this.item)) || (VideoMaterialUtil.isStarItem(this.item)))
      {
        if (this.particleParam == null) {
          this.particleParam = new ParticleParam();
        }
        this.particleParam.id = (this.item.id + this.item.alignFacePoints[0]);
        this.particleParam.needRender = true;
        this.particleParam.coordNum = (i4 * 6);
        this.particleParam.blendFuncSrc = this.particleEmitter.blendFuncSource;
        this.particleParam.blendFuncDst = this.particleEmitter.blendFuncDestination;
        this.particleParam.texture = this.particleEmitter.texture;
        this.particleParam.isPartical2 = 1;
        localObject3 = this.particleParam;
        if (!this.particleEmitter.opacityModifyRGB) {
          break label1088;
        }
      }
    }
    label1088:
    for (int i = 1;; i = 0)
    {
      ((ParticleParam)localObject3).uOpacityModifyRGB = i;
      this.particleParam.maxParticleNum = this.item.particleConfig.getParticleEmitterConfig().getMaxParticles().getValue();
      this.particleParam.aColor = ((float[])localObject2);
      this.particleParam.position = normalizePosition(paramParticleEmitterParam, this.width, this.height);
      this.particleParam.inputTextureCoordinate = ((float[])localObject1);
      return;
      i = 0;
      break;
    }
    label1094:
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
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
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
    boolean bool1 = GlUtil.curBlendModeEnabled;
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(this.particleEmitter.blendFuncSource, this.particleEmitter.blendFuncDestination);
    boolean bool2 = super.renderTexture(paramInt1, paramInt2, paramInt3);
    GlUtil.setBlendMode(bool1);
    return bool2;
  }
  
  public void resetParams()
  {
    int i = 1;
    addParam(new UniformParam.IntParam("isPartical2", 1));
    if (this.particleEmitter.opacityModifyRGB) {}
    for (;;)
    {
      addParam(new UniformParam.IntParam("u_opacityModifyRGB", i));
      addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
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
      if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
        avoidBodyPointsShake(paramObject);
      }
      this.phoneAngles = paramObject.phoneAngle;
      this.frameInedx = paramObject.frameIndex;
      this.audioScaleFactor = paramObject.audioScaleFactor;
      updateHotArea(paramObject.redPacketPositions);
      if (!VideoMaterialUtil.isGestureItem(this.item)) {
        break label82;
      }
      update(paramObject.handPoints, paramObject.faceAngles);
    }
    label82:
    do
    {
      return;
      if (!VideoMaterialUtil.isBodyDetectItem(this.item)) {
        break;
      }
      update(paramObject.bodyPoints, paramObject.faceAngles);
    } while (this.mHasBodyDetected);
    paramObject.bodyPoints = null;
    return;
    if (VideoMaterialUtil.isStarItem(this.item))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleFilter
 * JD-Core Version:    0.7.0.1
 */