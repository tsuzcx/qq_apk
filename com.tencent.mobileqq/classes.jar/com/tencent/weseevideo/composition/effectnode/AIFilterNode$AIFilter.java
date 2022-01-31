package com.tencent.weseevideo.composition.effectnode;

import android.support.annotation.NonNull;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.aifilter.AIFilterModel;
import com.tencent.tavcut.aifilter.TavAIFilter;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

class AIFilterNode$AIFilter
  implements TAVVideoEffect.Filter
{
  private TextureInfo inTextureInfo;
  TavAIFilter mEffect;
  private TextureInfo outTextureInfo;
  
  public AIFilterNode$AIFilter(AIFilterNode paramAIFilterNode)
  {
    Logger.i("TAVAIFilter", "constructing");
    this.mEffect = new TavAIFilter();
    if (AIFilterNode.access$000(paramAIFilterNode) != null) {
      this.mEffect.setParams(AIFilterNode.access$000(paramAIFilterNode).getConfig());
    }
  }
  
  @NonNull
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    Logger.i("TAVAIFilter", "applying");
    if (this.mEffect == null) {}
    do
    {
      long l;
      do
      {
        do
        {
          return paramCIImage;
          paramTAVVideoEffect = paramRenderInfo.getCiContext();
        } while ((paramTAVVideoEffect == null) || (paramTAVVideoEffect.getRenderContext() == null));
        l = paramRenderInfo.getTime().getTimeUs() / 1000L;
      } while ((AIFilterNode.access$000(this.this$0) != null) && ((l < AIFilterNode.access$000(this.this$0).getStartTime()) || (l > AIFilterNode.access$000(this.this$0).getStartTime() + AIFilterNode.access$000(this.this$0).getDuration())));
      int i = (int)paramCIImage.getSize().width;
      int j = (int)paramCIImage.getSize().height;
      if (this.inTextureInfo == null)
      {
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.inTextureInfo = CIContext.newTextureInfo(i, j);
      }
      if ((this.inTextureInfo.width != i) || (this.inTextureInfo.height != j))
      {
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.inTextureInfo.release();
        this.inTextureInfo = CIContext.newTextureInfo(i, j);
      }
      paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.inTextureInfo);
      paramTAVVideoEffect = new Frame();
    } while (this.inTextureInfo == null);
    paramTAVVideoEffect.setSizedTexture(this.inTextureInfo.textureID, this.inTextureInfo.width, this.inTextureInfo.height);
    return new CIImage(this.outTextureInfo);
  }
  
  public void release()
  {
    Logger.i("TAVAIFilter", "releasing");
    if (this.mEffect != null) {
      this.mEffect.release();
    }
    if ((this.inTextureInfo != null) && (!this.inTextureInfo.isReleased())) {
      this.inTextureInfo.release();
    }
    if ((this.outTextureInfo != null) && (!this.outTextureInfo.isReleased())) {
      this.outTextureInfo.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.AIFilterNode.AIFilter
 * JD-Core Version:    0.7.0.1
 */