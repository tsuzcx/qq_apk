package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weishi.module.publisher.data.AbilityPresetData;
import com.tencent.qcircle.weishi.module.publisher.data.AiModelInfo;
import com.tencent.qcircle.weishi.module.publisher.model.AIModelConfig;
import com.tencent.qcircle.weishi.module.publisher.utils.AIUtils;
import com.tencent.qcircle.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.qcircle.weseevideo.model.utils.CollectionUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import java.util.Iterator;
import java.util.List;
import org.light.CameraConfig;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.VideoOutput;

class LightVideoRenderNote$LightVideoRenderFilter
  implements TAVVideoEffect.Filter
{
  private LightAsset mLightAsset;
  private LightEngine mLightEngine;
  private LightSurface mLightSurface;
  private OnNodeRenderListener mOnNodeRenderListener;
  private TextureInfo mTextureInfo;
  private VideoOutput mVideoOutput;
  
  LightVideoRenderNote$LightVideoRenderFilter(LightEngine paramLightEngine, OnNodeRenderListener paramOnNodeRenderListener, LightAsset paramLightAsset)
  {
    this.mLightEngine = paramLightEngine;
    this.mOnNodeRenderListener = paramOnNodeRenderListener;
    this.mLightAsset = paramLightAsset;
  }
  
  private void initReader(RenderInfo paramRenderInfo)
  {
    this.mTextureInfo = CIContext.newTextureInfo(paramRenderInfo.getRenderSize());
    this.mLightSurface = LightSurface.FromTexture(this.mTextureInfo.textureID, this.mTextureInfo.width, this.mTextureInfo.height, true);
    this.mLightEngine.setSurface(this.mLightSurface);
    setAIForEngine(this.mLightEngine);
    this.mVideoOutput = this.mLightEngine.videoOutput();
  }
  
  private boolean isTextureChanged(RenderInfo paramRenderInfo)
  {
    TextureInfo localTextureInfo = this.mTextureInfo;
    return (localTextureInfo == null) || (localTextureInfo.width != paramRenderInfo.getRenderWidth()) || (this.mTextureInfo.height != paramRenderInfo.getRenderHeight());
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if ((this.mVideoOutput == null) || (isTextureChanged(paramRenderInfo))) {
      initReader(paramRenderInfo);
    }
    long l = System.currentTimeMillis();
    this.mVideoOutput.readSample(paramRenderInfo.getTime().getTimeUs());
    paramTAVVideoEffect = new StringBuilder();
    paramTAVVideoEffect.append("[light sdk]每帧渲染耗时：");
    paramTAVVideoEffect.append(System.currentTimeMillis() - l);
    Logger.i("lightsdkcost", paramTAVVideoEffect.toString());
    paramTAVVideoEffect = this.mOnNodeRenderListener;
    if (paramTAVVideoEffect != null) {
      paramTAVVideoEffect.onNodeRender();
    }
    return new CIImage(this.mTextureInfo);
  }
  
  public void release()
  {
    Object localObject = this.mVideoOutput;
    if (localObject != null) {
      ((VideoOutput)localObject).release();
    }
    localObject = this.mTextureInfo;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    localObject = this.mLightEngine;
    if (localObject != null) {
      ((LightEngine)localObject).release();
    }
    localObject = this.mLightSurface;
    if (localObject != null)
    {
      ((LightSurface)localObject).freeCache();
      this.mLightSurface.release();
    }
  }
  
  public void setAIForEngine(LightEngine paramLightEngine)
  {
    CameraConfig localCameraConfig = CameraConfig.make();
    paramLightEngine.setConfig(localCameraConfig);
    paramLightEngine = AIUtils.getAiModelPath(new AbilityPresetData(this.mLightAsset), AIModelConfig.getAIModelPathMap(), true);
    if (!CollectionUtils.isEmpty(paramLightEngine))
    {
      paramLightEngine = paramLightEngine.iterator();
      while (paramLightEngine.hasNext())
      {
        AiModelInfo localAiModelInfo = (AiModelInfo)paramLightEngine.next();
        localCameraConfig.setLightAIModelPath(localAiModelInfo.modelPath, localAiModelInfo.modelAgent);
      }
    }
    localCameraConfig.setDetectShorterEdgeLength(180, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.LightVideoRenderNote.LightVideoRenderFilter
 * JD-Core Version:    0.7.0.1
 */