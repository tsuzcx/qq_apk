package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.tav.core.CGMathFunctions;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/composition/effectnode/GestureNode$GestureFilter;", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect$Filter;", "(Lcom/tencent/qcircle/weseevideo/composition/effectnode/GestureNode;)V", "matrixFilter", "Lcom/tencent/tav/decoder/Filter;", "srcTextureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect;", "sourceImage", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "getRect2DisplayMatrix", "Landroid/graphics/Matrix;", "sourceSize", "Lcom/tencent/tav/coremedia/CGSize;", "targetSize", "readInputCIImage", "", "release", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class GestureNode$GestureFilter
  implements TAVVideoEffect.Filter
{
  private final Filter matrixFilter;
  private TextureInfo srcTextureInfo;
  
  public GestureNode$GestureFilter()
  {
    Filter localFilter = new Filter();
    localFilter.setRenderForScreen(false);
    this.matrixFilter = localFilter;
  }
  
  private final Matrix getRect2DisplayMatrix(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    paramCGSize1 = CGMathFunctions.transformBySourceRectFit(new CGRect(new PointF(), paramCGSize1), new CGRect(new PointF(), paramCGSize2));
    Intrinsics.checkExpressionValueIsNotNull(paramCGSize1, "CGMathFunctions.transfor…t(sourceRect, targetRect)");
    return paramCGSize1;
  }
  
  private final void readInputCIImage(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramRenderInfo = paramRenderInfo.getCiContext();
    Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "renderInfo.ciContext");
    int i = (int)paramCIImage.getSize().width;
    int j = (int)paramCIImage.getSize().height;
    if (this.srcTextureInfo == null) {
      this.srcTextureInfo = CIContext.newTextureInfo(i, j);
    }
    TextureInfo localTextureInfo = this.srcTextureInfo;
    if ((localTextureInfo != null) && (localTextureInfo.width == i))
    {
      localTextureInfo = this.srcTextureInfo;
      if ((localTextureInfo != null) && (localTextureInfo.height == j)) {}
    }
    else
    {
      localTextureInfo = this.srcTextureInfo;
      if (localTextureInfo != null) {
        localTextureInfo.release();
      }
      this.srcTextureInfo = CIContext.newTextureInfo(i, j);
    }
    paramRenderInfo.convertImageToTexture(paramCIImage, this.srcTextureInfo);
  }
  
  @NotNull
  public CIImage apply(@NotNull TAVVideoEffect paramTAVVideoEffect, @NotNull CIImage paramCIImage, @NotNull RenderInfo paramRenderInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVVideoEffect, "effect");
    Intrinsics.checkParameterIsNotNull(paramCIImage, "sourceImage");
    Intrinsics.checkParameterIsNotNull(paramRenderInfo, "renderInfo");
    paramCIImage.applyFlip(false, true);
    readInputCIImage(paramCIImage, paramRenderInfo);
    paramTAVVideoEffect = this.this$0.getGestureModel().getScreenSize();
    if (paramTAVVideoEffect == null) {
      paramTAVVideoEffect = new CGSize(paramCIImage.getSize().width, paramCIImage.getSize().height);
    }
    paramRenderInfo = paramCIImage.getSize();
    Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "sourceImage.size");
    paramTAVVideoEffect = getRect2DisplayMatrix(paramRenderInfo, paramTAVVideoEffect);
    paramRenderInfo = new Matrix();
    paramTAVVideoEffect.invert(paramRenderInfo);
    paramTAVVideoEffect.postConcat(this.this$0.getGestureModel().getGMatrix());
    new Matrix(paramTAVVideoEffect);
    paramTAVVideoEffect.postConcat(paramRenderInfo);
    this.matrixFilter.setRendererWidth((int)paramCIImage.getSize().width);
    this.matrixFilter.setRendererHeight((int)paramCIImage.getSize().height);
    paramTAVVideoEffect = new CIImage(this.matrixFilter.applyFilter(this.srcTextureInfo, paramTAVVideoEffect, new Matrix()));
    paramTAVVideoEffect.applyFlip(false, true);
    return paramTAVVideoEffect;
  }
  
  public void release()
  {
    this.matrixFilter.release();
    TextureInfo localTextureInfo = this.srcTextureInfo;
    if (localTextureInfo != null) {
      localTextureInfo.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.GestureNode.GestureFilter
 * JD-Core Version:    0.7.0.1
 */