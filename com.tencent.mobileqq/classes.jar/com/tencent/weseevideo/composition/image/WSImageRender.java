package com.tencent.weseevideo.composition.image;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
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
    if (this.imageGenerator != null)
    {
      this.imageGenerator.release();
      this.imageGenerator = null;
    }
  }
  
  public void render(WSImageRender.ImageRenderCallback paramImageRenderCallback)
  {
    DurationUtil.start("image render");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(CMTime.CMTimeZero);
    this.imageGenerator.generateCGImagesAsynchronouslyForTimes(localArrayList, new WSImageRender.1(this, paramImageRenderCallback));
  }
  
  public void update(Asset paramAsset, CGSize paramCGSize)
  {
    if (this.imageGenerator != null) {
      this.imageGenerator.updateAsset(paramAsset, paramCGSize);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.image.WSImageRender
 * JD-Core Version:    0.7.0.1
 */