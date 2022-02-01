package com.tencent.qcircle.weseevideo.composition.effectnode;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSOverLayBlurManager$SourceImageObserver;", "", "onSourceImageUpdated", "", "sourceImage", "Lcom/tencent/tavkit/ciimage/CIImage;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public abstract interface WSOverLayBlurManager$SourceImageObserver
{
  public abstract void onSourceImageUpdated(@Nullable CIImage paramCIImage, @Nullable RenderInfo paramRenderInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager.SourceImageObserver
 * JD-Core Version:    0.7.0.1
 */