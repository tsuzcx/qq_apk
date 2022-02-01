package com.tencent.weseevideo.composition.image;

import android.opengl.EGLContext;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.weseevideo.composition.TAVAutomaticTransRenderContext;
import java.util.ArrayList;
import java.util.List;

public class WSImageRender
{
  private AssetImageGenerator imageGenerator;
  
  public void init(TAVComposition paramTAVComposition, CGSize paramCGSize)
  {
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    this.imageGenerator = new AssetImageGenerator(paramTAVComposition.getAsset());
    this.imageGenerator.setMaximumSize(paramCGSize);
    this.imageGenerator.setAppliesPreferredTrackTransform(true);
    this.imageGenerator.setVideoComposition(paramTAVComposition.getVideoComposition());
  }
  
  public void release()
  {
    AssetImageGenerator localAssetImageGenerator = this.imageGenerator;
    if (localAssetImageGenerator != null)
    {
      localAssetImageGenerator.release();
      this.imageGenerator = null;
    }
  }
  
  public void render(WSImageRender.ImageRenderCallback paramImageRenderCallback, EGLContext paramEGLContext, AssetImageGenerator.ImageGeneratorThread paramImageGeneratorThread, RenderContext paramRenderContext)
  {
    if (this.imageGenerator != null)
    {
      DurationUtil.start("image render");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(CMTime.CMTimeZero);
      this.imageGenerator.generateCGImagesAsynchronouslyForTimes(localArrayList, new WSImageRender.1(this, paramImageRenderCallback), paramEGLContext, paramImageGeneratorThread, paramRenderContext);
    }
  }
  
  public void setTansRenderContext(TAVAutomaticTransRenderContext paramTAVAutomaticTransRenderContext)
  {
    AssetImageGenerator localAssetImageGenerator = this.imageGenerator;
    if (localAssetImageGenerator != null) {
      localAssetImageGenerator.setTansRenderContext(paramTAVAutomaticTransRenderContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.WSImageRender
 * JD-Core Version:    0.7.0.1
 */