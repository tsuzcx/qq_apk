package com.tencent.ttpic.particle;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.GLCapabilities;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.io.File;
import java.util.List;

public class GPUParticleFilter
  extends VideoFilterBase
{
  private static final String TAG = GPUParticleFilter.class.getSimpleName();
  private float audioScaleFactor = 1.0F;
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame copyedFrame = new Frame();
  private String dataPath;
  private final StickerItem item;
  private boolean needRender;
  private PDSystem pdSystem;
  private float phoneAngles;
  
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
    this.pdSystem = PDSystem.create(GLCapabilities.isSupportFramebufferFetch(), this.dataPath, this.item.gpuParticleConfig.jsonBytes);
    Bitmap localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + ((GPUParticleConfig.Sprite)this.item.gpuParticleConfig.sprites.get(0)).path, 1);
    this.pdSystem.setImage(((GPUParticleConfig.Sprite)this.item.gpuParticleConfig.sprites.get(0)).path, BitmapUtils.bitmap2RGBA(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
    BitmapUtils.recycle(localBitmap);
    this.pdSystem.loadAllTextures();
  }
  
  private GPUParticleFilter.ParticleEmitterParam updateEmitterParam(List<PointF> paramList, float[] paramArrayOfFloat)
  {
    GPUParticleFilter.ParticleEmitterParam localParticleEmitterParam = new GPUParticleFilter.ParticleEmitterParam();
    Vector3 localVector3 = new Vector3();
    switch (this.item.type)
    {
    case 3: 
    default: 
      paramList = localVector3;
    }
    for (;;)
    {
      localParticleEmitterParam.emitPosition = paramList;
      localParticleEmitterParam.extraScale *= this.audioScaleFactor;
      localParticleEmitterParam.extraScale *= this.width * 1.0F / 720.0F;
      return localParticleEmitterParam;
      int i;
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
        continue;
        if ((paramList == null) || (paramList.isEmpty())) {
          break;
        }
        PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
        label342:
        float f;
        if (this.item.alignFacePoints.length == 1)
        {
          i = this.item.alignFacePoints[0];
          PointF localPointF2 = (PointF)paramList.get(i);
          localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
          if (VideoMaterialUtil.isFaceItem(this.item))
          {
            localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
            localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
          }
          localVector3.x = localPointF1.x;
          localVector3.y = localPointF1.y;
          localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
          if (VideoMaterialUtil.isFaceItem(this.item))
          {
            localPointF1.x = ((float)(localPointF1.x / this.mFaceDetScale));
            localPointF1.y = ((float)(localPointF1.y / this.mFaceDetScale));
          }
          paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
          if (VideoMaterialUtil.isFaceItem(this.item))
          {
            paramList.x = ((float)(paramList.x / this.mFaceDetScale));
            paramList.y = ((float)(paramList.y / this.mFaceDetScale));
          }
          double d = Math.pow(localPointF1.x - paramList.x, 2.0D);
          d = Math.sqrt(Math.pow(localPointF1.y - paramList.y, 2.0D) + d) / this.item.scaleFactor;
          if ((this.item.type == 2) || (this.item.type == 4))
          {
            localParticleEmitterParam.extraScale = ((float)d);
            f = (float)Math.pow(4.0D, 0.5D - d);
            if (f <= 0.25D) {
              break label872;
            }
          }
        }
        for (;;)
        {
          localVector3.z = ((1.0F - f) * this.height);
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
          paramList = localVector3;
          break;
          i = this.item.alignFacePoints[1];
          break label342;
          label872:
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
  }
  
  private void updateParticle(GPUParticleFilter.ParticleEmitterParam paramParticleEmitterParam)
  {
    Vector3 localVector3 = paramParticleEmitterParam.emitPosition;
    localVector3.y = (this.height - localVector3.y);
    this.pdSystem.setBaseRotation(360.0F - this.phoneAngles);
    if ((this.pdSystem.totalFinished()) || ((!this.needRender) && ((this.item.gpuParticleConfig.emitterType == 2) || (this.item.gpuParticleConfig.emitterType == 3))))
    {
      this.pdSystem.reset();
      this.pdSystem.setSourcePosition(localVector3);
      this.pdSystem.setRotateZ(0.0F);
      return;
    }
    this.pdSystem.setSourcePosition(localVector3);
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
  }
  
  public Frame render(Frame paramFrame)
  {
    if (!GLCapabilities.isSupportFramebufferFetch()) {
      this.copyFilter.RenderProcess(paramFrame.getTextureId(), this.width, this.height, -1, 0.0D, this.copyedFrame);
    }
    for (Frame localFrame = this.copyedFrame;; localFrame = paramFrame)
    {
      localFrame.setNeedDepth(true);
      localFrame.bindDepthBuffer(localFrame.width, localFrame.height);
      this.pdSystem.updateFboSize(paramFrame.getTextureId(), localFrame.getFBO(), this.width, this.height);
      this.pdSystem.render(System.currentTimeMillis(), this.needRender);
      if (!GLCapabilities.isSupportFramebufferFetch())
      {
        GlUtil.setBlendMode(true);
        this.copyFilter.RenderProcess(localFrame.getTextureId(), this.width, this.height, -1, 0.0D, paramFrame);
      }
      return paramFrame;
    }
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
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
      this.phoneAngles = paramObject.phoneAngle;
      this.needRender = paramObject.needRender;
      this.audioScaleFactor = ((float)paramObject.audioScaleFactor);
      if (!VideoMaterialUtil.isGestureItem(this.item)) {
        break label89;
      }
      if ((!this.needRender) || (CollectionUtils.isEmpty(paramObject.handPoints))) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      this.needRender = bool;
      update(paramObject.handPoints, paramObject.faceAngles);
      return;
    }
    label89:
    if (VideoMaterialUtil.isBodyDetectItem(this.item))
    {
      update(paramObject.bodyPoints, paramObject.faceAngles);
      return;
    }
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
    this.pdSystem.updateFboSize(0, 0, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.particle.GPUParticleFilter
 * JD-Core Version:    0.7.0.1
 */