package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.weishi.module.publisher.data.AbilityPresetData;
import com.tencent.weishi.module.publisher.data.AiModelInfo;
import com.tencent.weishi.module.publisher.model.AIModelConfig;
import com.tencent.weishi.module.publisher.utils.AIUtils;
import com.tencent.weseevideo.composition.interfaces.OnNodeRenderListener;
import com.tencent.weseevideo.model.utils.CollectionUtils;
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
  private TextureInfo jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
  private OnNodeRenderListener jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener;
  private LightAsset jdField_a_of_type_OrgLightLightAsset;
  private LightEngine jdField_a_of_type_OrgLightLightEngine;
  private LightSurface jdField_a_of_type_OrgLightLightSurface;
  private VideoOutput jdField_a_of_type_OrgLightVideoOutput;
  
  LightVideoRenderNote$LightVideoRenderFilter(LightEngine paramLightEngine, OnNodeRenderListener paramOnNodeRenderListener, LightAsset paramLightAsset)
  {
    this.jdField_a_of_type_OrgLightLightEngine = paramLightEngine;
    this.jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener = paramOnNodeRenderListener;
    this.jdField_a_of_type_OrgLightLightAsset = paramLightAsset;
  }
  
  private void a(RenderInfo paramRenderInfo)
  {
    this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(paramRenderInfo.getRenderSize());
    this.jdField_a_of_type_OrgLightLightSurface = LightSurface.FromTexture(this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.textureID, this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.width, this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.height, true);
    this.jdField_a_of_type_OrgLightLightEngine.setSurface(this.jdField_a_of_type_OrgLightLightSurface);
    a(this.jdField_a_of_type_OrgLightLightEngine);
    this.jdField_a_of_type_OrgLightVideoOutput = this.jdField_a_of_type_OrgLightLightEngine.videoOutput();
  }
  
  private boolean a(RenderInfo paramRenderInfo)
  {
    return (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo == null) || (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.width != paramRenderInfo.getRenderWidth()) || (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.height != paramRenderInfo.getRenderHeight());
  }
  
  public void a(LightEngine paramLightEngine)
  {
    CameraConfig localCameraConfig = CameraConfig.make();
    paramLightEngine.setConfig(localCameraConfig);
    paramLightEngine = AIUtils.getAiModelPath(new AbilityPresetData(this.jdField_a_of_type_OrgLightLightAsset), AIModelConfig.getAIModelPathMap(), true);
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
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if ((this.jdField_a_of_type_OrgLightVideoOutput == null) || (a(paramRenderInfo))) {
      a(paramRenderInfo);
    }
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_OrgLightVideoOutput.readSample(paramRenderInfo.getTime().getTimeUs());
    Logger.i("lightsdkcost", "[light sdk]每帧渲染耗时：" + (System.currentTimeMillis() - l));
    if (this.jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener != null) {
      this.jdField_a_of_type_ComTencentWeseevideoCompositionInterfacesOnNodeRenderListener.a();
    }
    return new CIImage(this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo);
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_OrgLightVideoOutput != null) {
      this.jdField_a_of_type_OrgLightVideoOutput.release();
    }
    if (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo != null) {
      this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.release();
    }
    if (this.jdField_a_of_type_OrgLightLightEngine != null) {
      this.jdField_a_of_type_OrgLightLightEngine.release();
    }
    if (this.jdField_a_of_type_OrgLightLightSurface != null)
    {
      this.jdField_a_of_type_OrgLightLightSurface.freeCache();
      this.jdField_a_of_type_OrgLightLightSurface.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.LightVideoRenderNote.LightVideoRenderFilter
 * JD-Core Version:    0.7.0.1
 */