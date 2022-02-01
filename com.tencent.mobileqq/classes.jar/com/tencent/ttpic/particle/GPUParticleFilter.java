package com.tencent.ttpic.particle;

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
  private static final String TAG = GPUParticleFilter.class.getSimpleName();
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
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + ((GPUParticleConfig.Sprite)this.item.gpuParticleConfig.sprites.get(0)).path, 1);
    if (BitmapUtils.isLegal(localBitmap))
    {
      this.pdSystem.setImage(((GPUParticleConfig.Sprite)this.item.gpuParticleConfig.sprites.get(0)).path, BitmapUtils.bitmap2RGBA(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
      BitmapUtils.recycle(localBitmap);
    }
    if ((!TextUtils.isEmpty(this.item.gpuParticleConfig.startColorReference)) && (!"*".equals(this.item.gpuParticleConfig.startColorReference)))
    {
      localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.gpuParticleConfig.startColorReference, 1);
      if (localBitmap != null)
      {
        this.pdSystem.setTextureImage(BitmapUtils.bitmap2RGBA(localBitmap), this.item.gpuParticleConfig.startColorReference, localBitmap.getWidth(), localBitmap.getHeight());
        BitmapUtils.recycle(localBitmap);
      }
    }
    if (this.item.gpuParticleConfig.backgroundConfig != null)
    {
      localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.item.gpuParticleConfig.backgroundConfig.texture, 1);
      if (localBitmap != null) {
        this.pdBackground.setTexture(BitmapUtils.bitmap2RGBA(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
      }
    }
    this.pdSystem.loadAllTextures();
  }
  
  private GPUParticleFilter.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    GPUParticleFilter.ParticleEmitterParam localParticleEmitterParam = new GPUParticleFilter.ParticleEmitterParam();
    Vector3 localVector31 = new Vector3();
    switch (this.item.type)
    {
    case 3: 
    default: 
      paramList = localVector31;
    }
    for (;;)
    {
      localParticleEmitterParam.emitPosition = paramList;
      localParticleEmitterParam.extraScale *= this.audioScaleFactor;
      localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
      return localParticleEmitterParam;
      paramArrayOfFloat = new Vector3(0.0F, 0.0F, 0.0F);
      paramList = paramArrayOfFloat;
      float f;
      double d;
      int j;
      int i;
      if (this.item.gpuParticleConfig.sourcePositionPath != null)
      {
        paramList = paramArrayOfFloat;
        if (this.needRender)
        {
          paramList = this.item.gpuParticleConfig.sourcePositionPath.path;
          f = this.item.gpuParticleConfig.sourcePositionPath.duration;
          d = (System.currentTimeMillis() - this.triggerStartTime) / 1000.0D;
          j = (int)((d / f - Math.floor(d / f)) * paramList.length);
          i = j;
          if (j >= paramList.length) {
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
          paramArrayOfFloat.x *= i;
          paramArrayOfFloat.y -= this.item.gpuParticleConfig.sourcePositionPath.anchorPoint[1];
          paramArrayOfFloat.y /= paramList[1];
          paramArrayOfFloat.y *= i;
          paramList = paramArrayOfFloat;
        }
      }
      paramList.x = ((float)(paramList.x + this.item.position[0]));
      paramList.y = ((float)(paramList.y + this.item.position[1]));
      if (this.width / this.height >= 0.75D)
      {
        j = (int)(this.width / 0.75D);
        int k = (int)(j * paramList.y);
        f = this.width;
        i = (int)(paramList.x * f);
        j = k - (j - this.height) / 2;
        label522:
        localVector31.x = i;
        localVector31.y = j;
        localParticleEmitterParam.extraScale = 1.0F;
        f = (float)Math.pow(4.0D, -0.5D);
        if (f <= 0.25D) {
          break label640;
        }
      }
      for (;;)
      {
        localVector31.z = ((1.0F - f) * this.height);
        paramList = localVector31;
        break;
        i = (int)(this.height * 0.75D);
        j = (int)(this.height * paramList.y);
        f = i;
        i = (int)(paramList.x * f) - (i - this.width) / 2;
        break label522;
        label640:
        f = 0.25F;
      }
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
      Object localObject1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
      if (this.item.alignFacePoints.length == 1)
      {
        i = this.item.alignFacePoints[0];
        label704:
        Object localObject2 = (PointF)paramList.get(i);
        PointF localPointF = new PointF((((PointF)localObject1).x + ((PointF)localObject2).x) / 2.0F, (((PointF)localObject1).y + ((PointF)localObject2).y) / 2.0F);
        if (VideoMaterial.isFaceItem(this.item))
        {
          localPointF.x = ((float)(localPointF.x / this.mFaceDetScale));
          localPointF.y = ((float)(localPointF.y / this.mFaceDetScale));
        }
        if ((this.item.gpuParticleConfig.sourcePositionPath != null) && (this.needRender))
        {
          localObject1 = this.item.gpuParticleConfig.sourcePositionPath.path;
          f = this.item.gpuParticleConfig.sourcePositionPath.duration;
          d = (System.currentTimeMillis() - this.triggerStartTime) / 1000.0D;
          j = (int)((d / f - Math.floor(d / f)) * localObject1.length);
          i = j;
          if (j >= localObject1.length) {
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
          localVector32.x *= i;
          localVector32.y -= this.item.gpuParticleConfig.sourcePositionPath.anchorPoint[1];
          localVector32.y /= localObject1[1];
          localVector32.y *= i;
          localPointF.x += localVector32.x;
          localPointF.y += localVector32.y;
        }
        localVector31.x = localPointF.x;
        localVector31.y = localPointF.y;
        localObject1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
        if (VideoMaterial.isFaceItem(this.item))
        {
          ((PointF)localObject1).x = ((float)(((PointF)localObject1).x / this.mFaceDetScale));
          ((PointF)localObject1).y = ((float)(((PointF)localObject1).y / this.mFaceDetScale));
        }
        paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
        if (VideoMaterial.isFaceItem(this.item))
        {
          paramList.x = ((float)(paramList.x / this.mFaceDetScale));
          paramList.y = ((float)(paramList.y / this.mFaceDetScale));
        }
        d = Math.pow(((PointF)localObject1).x - paramList.x, 2.0D);
        d = Math.sqrt(Math.pow(((PointF)localObject1).y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
        if ((this.item.type == 2) || (this.item.type == 4))
        {
          localParticleEmitterParam.extraScale = ((float)d);
          f = (float)Math.pow(4.0D, 0.5D - d);
          if (f <= 0.25D) {
            break label1574;
          }
        }
      }
      for (;;)
      {
        localVector31.z = ((1.0F - f) * this.height);
        if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 3))
        {
          localParticleEmitterParam.rotateX = paramArrayOfFloat[0];
          localParticleEmitterParam.rotateY = paramArrayOfFloat[1];
          localParticleEmitterParam.rotateZ = (paramArrayOfFloat[2] - (float)Math.toRadians(360.0F - this.phoneAngles));
          if ((this.phoneAngles == 90.0F) || (this.phoneAngles == 270.0F))
          {
            f = localParticleEmitterParam.rotateX;
            localParticleEmitterParam.rotateX = (-localParticleEmitterParam.rotateY);
            localParticleEmitterParam.rotateY = (-f);
          }
        }
        paramList = localVector31;
        break;
        i = this.item.alignFacePoints[1];
        break label704;
        label1574:
        f = 0.25F;
      }
      if ((paramList == null) || (paramList.isEmpty())) {
        break;
      }
      paramList = (PointF)paramList.get(Math.min(this.item.alignFacePoints[0], paramList.size() - 1));
      paramList = new Vector3(paramList.x, paramList.y, 1.0F);
      paramList.x *= this.width;
      paramList.y *= this.height;
      localParticleEmitterParam.extraScale = 1.0F;
      localParticleEmitterParam.rotateZ = 0.0F;
    }
  }
  
  private void updateParticle(GPUParticleFilter.ParticleEmitterParam paramParticleEmitterParam)
  {
    Vector3 localVector3 = paramParticleEmitterParam.emitPosition;
    localVector3.y = (this.height - localVector3.y);
    if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender)) {
      this.pdSystem.setBaseRotation(0.0F);
    }
    while ((this.pdSystem.totalFinished()) || ((!this.needRender) && ((this.item.gpuParticleConfig.emitterType == 2) || (this.item.gpuParticleConfig.emitterType == 3))))
    {
      this.pdSystem.reset();
      this.pdSystem.setSourcePosition(localVector3);
      this.pdSystem.setRotateZ(0.0F);
      return;
      this.pdSystem.setBaseRotation(360.0F - this.phoneAngles);
    }
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
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    this.copyFilter.clearGLSLSelf();
    this.pdSystem.destroy();
    if (this.copyedFrame != null) {
      this.copyedFrame.clear();
    }
    if (this.pdBackground != null) {
      this.pdBackground.destroy();
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
    Frame localFrame = this.copyedFrame;
    FrameUtil.clearFrame(this.copyedFrame, 0.0F, 0.0F, 0.0F, 0.0F, this.copyedFrame.width, this.copyedFrame.height);
    localFrame.setNeedDepth(true);
    localFrame.bindDepthBuffer(localFrame.width, localFrame.height);
    this.pdSystem.updateFboSize(paramFrame.getTextureId(), localFrame.getFBO(), this.width, this.height);
    if (!this.pdSystem.render(System.currentTimeMillis(), this.needRender))
    {
      this.pdSystem.destroy();
      if (this.pdBackground != null) {
        this.pdBackground.destroy();
      }
      init();
      return paramFrame;
    }
    GlUtil.setBlendMode(true);
    this.copyFilter.RenderProcess(localFrame.getTextureId(), this.width, this.height, -1, 0.0D, paramFrame);
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
    if (this.pdBackground != null) {
      this.pdBackground.reset();
    }
  }
  
  public void setDynamicColorReference(Bitmap paramBitmap)
  {
    byte[] arrayOfByte = null;
    if (paramBitmap != null) {
      arrayOfByte = BitmapUtils.bitmap2RGBA(paramBitmap);
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
    if ((this.item.gpuParticleConfig.backgroundConfig != null) && (this.needRender)) {
      this.pdBackground.setTimeDelta((System.currentTimeMillis() - this.triggerStartTime) / 1000.0D);
    }
  }
  
  public void updatePreview(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject instanceof PTDetectInfo))
    {
      paramObject = (PTDetectInfo)paramObject;
      this.phoneAngles = paramObject.phoneAngle;
      this.needRender = paramObject.needRender;
      this.audioScaleFactor = ((float)paramObject.audioScaleFactor);
      if ((this.lastNeedRender) || (!this.needRender)) {
        break label150;
      }
      bool1 = true;
      this.fromUnTrigger2Trigger = bool1;
      if (this.fromUnTrigger2Trigger) {
        this.triggerStartTime = System.currentTimeMillis();
      }
      if (!VideoMaterial.isGestureItem(this.item)) {
        break label165;
      }
      if ((!this.needRender) || (CollectionUtils.isEmpty(paramObject.handPoints))) {
        break label155;
      }
      bool1 = true;
      label103:
      this.needRender = bool1;
      if ((this.lastNeedRender) || (!this.needRender)) {
        break label160;
      }
      bool1 = bool2;
      label124:
      this.fromUnTrigger2Trigger = bool1;
      update(paramObject.handPoints, paramObject.faceAngles);
    }
    for (;;)
    {
      this.lastNeedRender = this.needRender;
      return;
      label150:
      bool1 = false;
      break;
      label155:
      bool1 = false;
      break label103;
      label160:
      bool1 = false;
      break label124;
      label165:
      if (VideoMaterial.isBodyDetectItem(this.item)) {
        update(paramObject.bodyPoints, paramObject.faceAngles);
      } else if (VideoMaterial.isStarItem(this.item)) {
        update(paramObject.starPoints, paramObject.faceAngles);
      } else {
        update(paramObject.facePoints, paramObject.faceAngles);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.GPUParticleFilter
 * JD-Core Version:    0.7.0.1
 */