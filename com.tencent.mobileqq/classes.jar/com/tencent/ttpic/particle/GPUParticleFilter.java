package com.tencent.ttpic.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FrameUtil;
import java.io.File;
import java.util.List;
import java.util.List<Landroid.graphics.PointF;>;

public class GPUParticleFilter
  extends VideoFilterBase
{
  private static final String TAG = "GPUParticleFilter";
  private float audioScaleFactor = 1.0F;
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame copyedFrame = new Frame();
  private String dataPath;
  private boolean fromUnTrigger2Trigger = false;
  private final StickerItem item;
  private boolean lastNeedRender;
  private boolean needRender;
  private PDBackground pdBackground;
  private PDSystem pdSystem;
  private float phoneAngles;
  private long triggerStartTime;
  
  public GPUParticleFilter(String paramString, StickerItem paramStickerItem)
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.dataPath = paramString;
    this.item = paramStickerItem;
    init();
  }
  
  private void init()
  {
    this.copyFilter.apply();
    this.pdSystem = PDSystem.create(false, this.dataPath, this.item.gpuParticleConfig.jsonBytes);
    if (this.item.gpuParticleConfig.backgroundConfig != null)
    {
      this.pdBackground = new PDBackground();
      this.pdBackground.setUniform(this.item.gpuParticleConfig.backgroundConfig.type, this.item.gpuParticleConfig.backgroundConfig.duration, this.item.gpuParticleConfig.backgroundConfig.startSide, this.item.gpuParticleConfig.backgroundConfig.strokeWidth);
    }
    Object localObject = AEModule.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.dataPath);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(((GPUParticleConfig.Sprite)this.item.gpuParticleConfig.sprites.get(0)).path);
    localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
    if (BitmapUtils.isLegal((Bitmap)localObject))
    {
      this.pdSystem.setImage(((GPUParticleConfig.Sprite)this.item.gpuParticleConfig.sprites.get(0)).path, BitmapUtils.bitmap2RGBA((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      BitmapUtils.recycle((Bitmap)localObject);
    }
    if ((!TextUtils.isEmpty(this.item.gpuParticleConfig.startColorReference)) && (!"*".equals(this.item.gpuParticleConfig.startColorReference)))
    {
      localObject = AEModule.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dataPath);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.item.gpuParticleConfig.startColorReference);
      localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
      if (localObject != null)
      {
        this.pdSystem.setTextureImage(BitmapUtils.bitmap2RGBA((Bitmap)localObject), this.item.gpuParticleConfig.startColorReference, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        BitmapUtils.recycle((Bitmap)localObject);
      }
    }
    if (this.item.gpuParticleConfig.backgroundConfig != null)
    {
      localObject = AEModule.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.dataPath);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(this.item.gpuParticleConfig.backgroundConfig.texture);
      localObject = BitmapUtils.decodeSampleBitmap((Context)localObject, localStringBuilder.toString(), 1);
      if (localObject != null) {
        this.pdBackground.setTexture(BitmapUtils.bitmap2RGBA((Bitmap)localObject), ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
    this.pdSystem.loadAllTextures();
  }
  
  private GPUParticleFilter.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    GPUParticleFilter.ParticleEmitterParam localParticleEmitterParam = new GPUParticleFilter.ParticleEmitterParam();
    Vector3 localVector31 = new Vector3();
    int i = this.item.type;
    Object localObject1;
    double d1;
    double d2;
    float f1;
    double d3;
    float f2;
    if (i != 1)
    {
      if ((i != 2) && (i != 4) && (i != 5))
      {
        if (i != 6)
        {
          localObject1 = localVector31;
        }
        else
        {
          localObject1 = localVector31;
          if (paramList != null)
          {
            localObject1 = localVector31;
            if (!paramList.isEmpty())
            {
              paramList = (PointF)paramList.get(Math.min(this.item.alignFacePoints[0], paramList.size() - 1));
              localObject1 = new Vector3(paramList.x, paramList.y, 1.0F);
              ((Vector3)localObject1).x *= this.width;
              ((Vector3)localObject1).y *= this.height;
              localParticleEmitterParam.extraScale = 1.0F;
              localParticleEmitterParam.rotateZ = 0.0F;
            }
          }
        }
      }
      else
      {
        localObject1 = localVector31;
        if (paramList != null)
        {
          localObject1 = localVector31;
          if (!paramList.isEmpty())
          {
            localObject1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
            if (this.item.alignFacePoints.length == 1) {
              i = this.item.alignFacePoints[0];
            } else {
              i = this.item.alignFacePoints[1];
            }
            Object localObject2 = (PointF)paramList.get(i);
            PointF localPointF = new PointF((((PointF)localObject1).x + ((PointF)localObject2).x) / 2.0F, (((PointF)localObject1).y + ((PointF)localObject2).y) / 2.0F);
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
            if ((this.item.gpuParticleConfig.sourcePositionPath != null) && (this.needRender))
            {
              localObject1 = this.item.gpuParticleConfig.sourcePositionPath.path;
              f1 = this.item.gpuParticleConfig.sourcePositionPath.duration;
              d1 = System.currentTimeMillis() - this.triggerStartTime;
              Double.isNaN(d1);
              d1 /= 1000.0D;
              d2 = f1;
              Double.isNaN(d2);
              d1 /= d2;
              d2 = Math.floor(d1);
              d3 = localObject1.length;
              Double.isNaN(d3);
              i = (int)((d1 - d2) * d3);
              if (i >= localObject1.length) {
                i = localObject1.length - 1;
              }
              Vector3 localVector32 = new Vector3(localObject1[i][0], localObject1[i][1], localObject1[i][2]);
              i = this.item.gpuParticleConfig.sourcePositionPath.scale;
              localObject2 = this.item.gpuParticleConfig.sourcePositionPath.canvas;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = new float[2];
                localObject1[0] = this.width;
                localObject1[1] = this.height;
              }
              localVector32.x -= this.item.gpuParticleConfig.sourcePositionPath.anchorPoint[0];
              localVector32.x /= localObject1[0];
              f1 = localVector32.x;
              f2 = i;
              localVector32.x = (f1 * f2);
              localVector32.y -= this.item.gpuParticleConfig.sourcePositionPath.anchorPoint[1];
              localVector32.y /= localObject1[1];
              localVector32.y *= f2;
              localPointF.x += localVector32.x;
              localPointF.y += localVector32.y;
            }
            localVector31.x = localPointF.x;
            localVector31.y = localPointF.y;
            localObject1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
            if (VideoMaterial.isFaceItem(this.item))
            {
              d1 = ((PointF)localObject1).x;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              ((PointF)localObject1).x = ((float)(d1 / d2));
              d1 = ((PointF)localObject1).y;
              d2 = this.mFaceDetScale;
              Double.isNaN(d1);
              ((PointF)localObject1).y = ((float)(d1 / d2));
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
            d1 = Math.sqrt(Math.pow(((PointF)localObject1).x - paramList.x, 2.0D) + Math.pow(((PointF)localObject1).y - paramList.y, 2.0D));
            d2 = this.item.scaleFactor;
            Double.isNaN(d2);
            d1 /= d2;
            if ((this.item.type == 2) || (this.item.type == 4))
            {
              localParticleEmitterParam.extraScale = ((float)d1);
              f1 = (float)Math.pow(4.0D, 0.5D - d1);
              if (f1 <= 0.25D) {
                f1 = 0.25F;
              }
              localVector31.z = (this.height * (1.0F - f1));
            }
            localObject1 = localVector31;
            if (paramArrayOfFloat != null)
            {
              localObject1 = localVector31;
              if (paramArrayOfFloat.length >= 3)
              {
                localParticleEmitterParam.rotateX = paramArrayOfFloat[0];
                localParticleEmitterParam.rotateY = paramArrayOfFloat[1];
                localParticleEmitterParam.rotateZ = (paramArrayOfFloat[2] - (float)Math.toRadians(360.0F - this.phoneAngles));
                f1 = this.phoneAngles;
                if (f1 != 90.0F)
                {
                  localObject1 = localVector31;
                  if (f1 != 270.0F) {}
                }
                else
                {
                  f1 = localParticleEmitterParam.rotateX;
                  localParticleEmitterParam.rotateX = (-localParticleEmitterParam.rotateY);
                  localParticleEmitterParam.rotateY = (-f1);
                  localObject1 = localVector31;
                }
              }
            }
          }
        }
      }
    }
    else
    {
      paramArrayOfFloat = new Vector3(0.0F, 0.0F, 0.0F);
      paramList = paramArrayOfFloat;
      if (this.item.gpuParticleConfig.sourcePositionPath != null)
      {
        paramList = paramArrayOfFloat;
        if (this.needRender)
        {
          paramList = this.item.gpuParticleConfig.sourcePositionPath.path;
          f1 = this.item.gpuParticleConfig.sourcePositionPath.duration;
          d1 = System.currentTimeMillis() - this.triggerStartTime;
          Double.isNaN(d1);
          d1 /= 1000.0D;
          d2 = f1;
          Double.isNaN(d2);
          d1 /= d2;
          d2 = Math.floor(d1);
          d3 = paramList.length;
          Double.isNaN(d3);
          i = (int)((d1 - d2) * d3);
          if (i >= paramList.length) {
            i = paramList.length - 1;
          }
          paramArrayOfFloat = new Vector3(paramList[i][0], paramList[i][1], paramList[i][2]);
          i = this.item.gpuParticleConfig.sourcePositionPath.scale;
          localObject1 = this.item.gpuParticleConfig.sourcePositionPath.canvas;
          paramList = (List<PointF>)localObject1;
          if (localObject1 == null)
          {
            paramList = new float[2];
            paramList[0] = this.width;
            paramList[1] = this.height;
          }
          paramArrayOfFloat.x -= this.item.gpuParticleConfig.sourcePositionPath.anchorPoint[0];
          paramArrayOfFloat.x /= paramList[0];
          f1 = paramArrayOfFloat.x;
          f2 = i;
          paramArrayOfFloat.x = (f1 * f2);
          paramArrayOfFloat.y -= this.item.gpuParticleConfig.sourcePositionPath.anchorPoint[1];
          paramArrayOfFloat.y /= paramList[1];
          paramArrayOfFloat.y *= f2;
          paramList = paramArrayOfFloat;
        }
      }
      d1 = paramList.x;
      d2 = this.item.position[0];
      Double.isNaN(d1);
      paramList.x = ((float)(d1 + d2));
      d1 = paramList.y;
      d2 = this.item.position[1];
      Double.isNaN(d1);
      paramList.y = ((float)(d1 + d2));
      d1 = this.width;
      d2 = this.height;
      Double.isNaN(d1);
      Double.isNaN(d2);
      int j;
      if (d1 / d2 >= 0.75D)
      {
        d1 = this.width;
        Double.isNaN(d1);
        j = (int)(d1 / 0.75D);
        int k = (int)(j * paramList.y);
        i = (int)(this.width * paramList.x);
        j = k - (j - this.height) / 2;
      }
      else
      {
        d1 = this.height;
        Double.isNaN(d1);
        i = (int)(d1 * 0.75D);
        j = (int)(this.height * paramList.y);
        i = (int)(i * paramList.x) - (i - this.width) / 2;
      }
      localVector31.x = i;
      localVector31.y = j;
      localParticleEmitterParam.extraScale = 1.0F;
      f1 = (float)Math.pow(4.0D, -0.5D);
      if (f1 <= 0.25D) {
        f1 = 0.25F;
      }
      localVector31.z = (this.height * (1.0F - f1));
      localObject1 = localVector31;
    }
    localParticleEmitterParam.emitPosition = ((Vector3)localObject1);
    localParticleEmitterParam.extraScale *= this.audioScaleFactor;
    localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
    return localParticleEmitterParam;
  }
  
  private void updateParticle(GPUParticleFilter.ParticleEmitterParam paramParticleEmitterParam)
  {
    Vector3 localVector3 = paramParticleEmitterParam.emitPosition;
    localVector3.y = (this.height - localVector3.y);
    if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender)) {
      this.pdSystem.setBaseRotation(0.0F);
    } else {
      this.pdSystem.setBaseRotation(360.0F - this.phoneAngles);
    }
    if ((!this.pdSystem.totalFinished()) && ((this.needRender) || ((this.item.gpuParticleConfig.emitterType != 2) && (this.item.gpuParticleConfig.emitterType != 3))))
    {
      this.pdSystem.setSourcePosition(localVector3);
      if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender))
      {
        this.pdSystem.setRotateX(0.0F);
        this.pdSystem.setRotateY(0.0F);
        this.pdSystem.setRotateZ(0.0F);
        return;
      }
      this.pdSystem.setRotateX(paramParticleEmitterParam.rotateX);
      this.pdSystem.setRotateY(paramParticleEmitterParam.rotateY);
      this.pdSystem.setRotateZ(paramParticleEmitterParam.rotateZ);
      return;
    }
    this.pdSystem.reset();
    this.pdSystem.setSourcePosition(localVector3);
    this.pdSystem.setRotateZ(0.0F);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.pdSystem.destroy();
    Object localObject = this.copyedFrame;
    if (localObject != null) {
      ((Frame)localObject).clear();
    }
    localObject = this.pdBackground;
    if (localObject != null) {
      ((PDBackground)localObject).destroy();
    }
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender)) {
      FrameUtil.clearFrame(paramFrame, 0.0F, 0.0F, 0.0F, 0.0F, paramFrame.width, paramFrame.height);
    }
    if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender))
    {
      this.pdBackground.updateFboSize(paramFrame.getFBO(), this.width, this.height);
      this.pdBackground.render();
    }
    this.copyFilter.RenderProcess(paramFrame.getTextureId(), this.width, this.height, -1, 0.0D, this.copyedFrame);
    Object localObject = this.copyedFrame;
    FrameUtil.clearFrame((Frame)localObject, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject).width, this.copyedFrame.height);
    ((Frame)localObject).setNeedDepth(true);
    ((Frame)localObject).bindDepthBuffer(((Frame)localObject).width, ((Frame)localObject).height);
    this.pdSystem.updateFboSize(paramFrame.getTextureId(), ((Frame)localObject).getFBO(), this.width, this.height);
    if (!this.pdSystem.render(System.currentTimeMillis(), this.needRender))
    {
      this.pdSystem.destroy();
      localObject = this.pdBackground;
      if (localObject != null) {
        ((PDBackground)localObject).destroy();
      }
      init();
      return paramFrame;
    }
    GlUtil.setBlendMode(true);
    this.copyFilter.RenderProcess(((Frame)localObject).getTextureId(), this.width, this.height, -1, 0.0D, paramFrame);
    GlUtil.setBlendMode(false);
    return paramFrame;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void reset()
  {
    this.pdSystem.reset();
    PDBackground localPDBackground = this.pdBackground;
    if (localPDBackground != null) {
      localPDBackground.reset();
    }
  }
  
  public void setDynamicColorReference(Bitmap paramBitmap)
  {
    byte[] arrayOfByte;
    if (paramBitmap != null) {
      arrayOfByte = BitmapUtils.bitmap2RGBA(paramBitmap);
    } else {
      arrayOfByte = null;
    }
    if ((this.fromUnTrigger2Trigger) && (arrayOfByte != null) && ("*".equals(this.item.gpuParticleConfig.startColorReference)))
    {
      this.pdSystem.setTextureImage(arrayOfByte, this.item.gpuParticleConfig.startColorReference, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.pdSystem.loadAllTextures();
    }
    if ((this.fromUnTrigger2Trigger) && (arrayOfByte != null) && (this.item.gpuParticleConfig.backgroundConfig != null) && ("*".equals(this.item.gpuParticleConfig.backgroundConfig.texture))) {
      this.pdBackground.setTexture(arrayOfByte, paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    BitmapUtils.recycle(paramBitmap);
  }
  
  protected void update(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    updateParticle(updateEmitterParam(paramList, paramArrayOfFloat));
    if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender))
    {
      paramList = this.pdBackground;
      double d = System.currentTimeMillis() - this.triggerStartTime;
      Double.isNaN(d);
      paramList.setTimeDelta(d / 1000.0D);
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      this.phoneAngles = paramObject.phoneAngle;
      this.needRender = paramObject.needRender;
      this.audioScaleFactor = ((float)paramObject.audioScaleFactor);
      boolean bool1 = this.lastNeedRender;
      boolean bool2 = true;
      if ((!bool1) && (this.needRender)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.fromUnTrigger2Trigger = bool1;
      if (this.fromUnTrigger2Trigger) {
        this.triggerStartTime = System.currentTimeMillis();
      }
      if (VideoMaterial.isGestureItem(this.item))
      {
        if ((this.needRender) && (!CollectionUtils.isEmpty(paramObject.handPoints))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.needRender = bool1;
        if ((!this.lastNeedRender) && (this.needRender)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        this.fromUnTrigger2Trigger = bool1;
        update(paramObject.handPoints, paramObject.faceAngles);
      }
      else if (VideoMaterial.isBodyDetectItem(this.item))
      {
        update(paramObject.bodyPoints, paramObject.faceAngles);
      }
      else if (VideoMaterial.isStarItem(this.item))
      {
        update(paramObject.starPoints, paramObject.faceAngles);
      }
      else
      {
        update(paramObject.facePoints, paramObject.faceAngles);
      }
      this.lastNeedRender = this.needRender;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    if (this.item.gpuParticleConfig.backgroundConfig != null) {
      this.pdBackground.updateFboSize(0, paramInt1, paramInt2);
    }
    this.pdSystem.updateFboSize(0, 0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.particle.GPUParticleFilter
 * JD-Core Version:    0.7.0.1
 */