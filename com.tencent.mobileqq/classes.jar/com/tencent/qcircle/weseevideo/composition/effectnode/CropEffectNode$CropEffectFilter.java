package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;

class CropEffectNode$CropEffectFilter
  implements TAVVideoEffect.Filter, IReportable
{
  private TextureInfo cachedCropOutputTextureInfo;
  private TextureInfo cachedSourceTextureInfo;
  private CropEffectNode.CropFilter cropFilter;
  
  public CropEffectNode$CropEffectFilter(CropEffectNode paramCropEffectNode)
  {
    this.cropFilter = new CropEffectNode.CropFilter(paramCropEffectNode);
  }
  
  @NonNull
  private TextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  @NonNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    int i = (int)paramCIImage.getSize().width;
    int j = (int)paramCIImage.getSize().height;
    if (this.cachedSourceTextureInfo == null) {
      this.cachedSourceTextureInfo = CIContext.newTextureInfo(i, j);
    }
    if ((this.cachedSourceTextureInfo.width != i) || (this.cachedSourceTextureInfo.height != j))
    {
      this.cachedSourceTextureInfo.release();
      this.cachedSourceTextureInfo = CIContext.newTextureInfo(i, j);
    }
    paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.cachedSourceTextureInfo);
    i = (int)(paramCIImage.getSize().width * this.this$0.getCropModel().getCropConfig().getWidth() + 0.5F);
    j = (int)(paramCIImage.getSize().height * this.this$0.getCropModel().getCropConfig().getHeight() + 0.5F);
    paramTAVVideoEffect = new Matrix();
    paramTAVVideoEffect.postTranslate(this.this$0.getCropModel().getCropConfig().getX(), 1.0F - this.this$0.getCropModel().getCropConfig().getHeight() - this.this$0.getCropModel().getCropConfig().getY());
    if (this.cachedCropOutputTextureInfo == null) {
      this.cachedCropOutputTextureInfo = CIContext.newTextureInfo(i, j);
    }
    if ((this.cachedCropOutputTextureInfo.width != i) || (this.cachedCropOutputTextureInfo.height != j))
    {
      this.cachedCropOutputTextureInfo.release();
      this.cachedCropOutputTextureInfo = CIContext.newTextureInfo(i, j);
    }
    this.cropFilter.setOutputTextureInfo(this.cachedCropOutputTextureInfo);
    this.cropFilter.applyFilter(this.cachedSourceTextureInfo, new Matrix(), paramTAVVideoEffect, 1.0F, new CGRect(0.0F, 0.0F, i, j));
    return new CIImage(this.cachedCropOutputTextureInfo);
  }
  
  public String getReportKey()
  {
    return this.this$0.reportKey;
  }
  
  public void release()
  {
    Object localObject = this.cropFilter;
    if (localObject != null) {
      ((CropEffectNode.CropFilter)localObject).release();
    }
    localObject = this.cachedSourceTextureInfo;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
    localObject = this.cachedCropOutputTextureInfo;
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.CropEffectNode.CropEffectFilter
 * JD-Core Version:    0.7.0.1
 */