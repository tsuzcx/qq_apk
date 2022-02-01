package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
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
import com.tencent.weseevideo.model.effect.GestureModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/composition/effectnode/GestureNode$GestureFilter;", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect$Filter;", "(Lcom/tencent/weseevideo/composition/effectnode/GestureNode;)V", "matrixFilter", "Lcom/tencent/tav/decoder/Filter;", "srcTextureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "apply", "Lcom/tencent/tavkit/ciimage/CIImage;", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoEffect;", "sourceImage", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "getRect2DisplayMatrix", "Landroid/graphics/Matrix;", "sourceSize", "Lcom/tencent/tav/coremedia/CGSize;", "targetSize", "readInputCIImage", "", "release", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class GestureNode$GestureFilter
  implements TAVVideoEffect.Filter
{
  private TextureInfo jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
  private final Filter jdField_a_of_type_ComTencentTavDecoderFilter;
  
  public GestureNode$GestureFilter()
  {
    Filter localFilter = new Filter();
    localFilter.setRenderForScreen(false);
    this.jdField_a_of_type_ComTencentTavDecoderFilter = localFilter;
  }
  
  private final Matrix a(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    paramCGSize1 = CGMathFunctions.transformBySourceRectFit(new CGRect(new PointF(), paramCGSize1), new CGRect(new PointF(), paramCGSize2));
    Intrinsics.checkExpressionValueIsNotNull(paramCGSize1, "CGMathFunctions.transfor…t(sourceRect, targetRect)");
    return paramCGSize1;
  }
  
  private final void a(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramRenderInfo = paramRenderInfo.getCiContext();
    Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "renderInfo.ciContext");
    int i = (int)paramCIImage.getSize().width;
    int j = (int)paramCIImage.getSize().height;
    if (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo == null) {
      this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(i, j);
    }
    TextureInfo localTextureInfo = this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
    if ((localTextureInfo != null) && (localTextureInfo.width == i))
    {
      localTextureInfo = this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
      if ((localTextureInfo != null) && (localTextureInfo.height == j)) {}
    }
    else
    {
      localTextureInfo = this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
      if (localTextureInfo != null) {
        localTextureInfo.release();
      }
      this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(i, j);
    }
    paramRenderInfo.convertImageToTexture(paramCIImage, this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo);
  }
  
  @NotNull
  public CIImage apply(@NotNull TAVVideoEffect paramTAVVideoEffect, @NotNull CIImage paramCIImage, @NotNull RenderInfo paramRenderInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVVideoEffect, "effect");
    Intrinsics.checkParameterIsNotNull(paramCIImage, "sourceImage");
    Intrinsics.checkParameterIsNotNull(paramRenderInfo, "renderInfo");
    paramCIImage.applyFlip(false, true);
    a(paramCIImage, paramRenderInfo);
    paramTAVVideoEffect = this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeGestureNode.a().getScreenSize();
    if (paramTAVVideoEffect == null) {
      paramTAVVideoEffect = new CGSize(paramCIImage.getSize().width, paramCIImage.getSize().height);
    }
    paramRenderInfo = paramCIImage.getSize();
    Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "sourceImage.size");
    paramTAVVideoEffect = a(paramRenderInfo, paramTAVVideoEffect);
    paramRenderInfo = new Matrix();
    paramTAVVideoEffect.invert(paramRenderInfo);
    paramTAVVideoEffect.postConcat(this.jdField_a_of_type_ComTencentWeseevideoCompositionEffectnodeGestureNode.a().getGMatrix());
    new Matrix(paramTAVVideoEffect);
    paramTAVVideoEffect.postConcat(paramRenderInfo);
    this.jdField_a_of_type_ComTencentTavDecoderFilter.setRendererWidth((int)paramCIImage.getSize().width);
    this.jdField_a_of_type_ComTencentTavDecoderFilter.setRendererHeight((int)paramCIImage.getSize().height);
    paramTAVVideoEffect = new CIImage(this.jdField_a_of_type_ComTencentTavDecoderFilter.applyFilter(this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo, paramTAVVideoEffect, new Matrix()));
    paramTAVVideoEffect.applyFlip(false, true);
    return paramTAVVideoEffect;
  }
  
  public void release()
  {
    this.jdField_a_of_type_ComTencentTavDecoderFilter.release();
    TextureInfo localTextureInfo = this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
    if (localTextureInfo != null) {
      localTextureInfo.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.GestureNode.GestureFilter
 * JD-Core Version:    0.7.0.1
 */