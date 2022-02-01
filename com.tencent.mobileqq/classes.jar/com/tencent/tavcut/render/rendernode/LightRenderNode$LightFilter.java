package com.tencent.tavcut.render.rendernode;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.VideoOutput;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/rendernode/LightRenderNode$LightFilter;", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode$Filter;", "lightEngine", "Lorg/light/LightEngine;", "lightAsset", "Lorg/light/LightAsset;", "(Lorg/light/LightEngine;Lorg/light/LightAsset;)V", "lightSurface", "Lorg/light/LightSurface;", "textureInfo", "Lcom/tencent/tav/coremedia/TextureInfo;", "videoOutput", "Lorg/light/VideoOutput;", "apply", "", "imageParams", "Lcom/tencent/tavcut/render/rendernode/ImageParams;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "initReader", "isNeedApply", "", "isTextureChanged", "release", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightRenderNode$LightFilter
  implements BaseEffectNode.Filter
{
  private VideoOutput a;
  private TextureInfo b;
  private LightSurface c;
  private final LightEngine d;
  private final LightAsset e;
  
  public LightRenderNode$LightFilter(@Nullable LightEngine paramLightEngine, @Nullable LightAsset paramLightAsset)
  {
    this.d = paramLightEngine;
    this.e = paramLightAsset;
  }
  
  private final void b(RenderInfo paramRenderInfo)
  {
    paramRenderInfo = CIContext.newTextureInfo(paramRenderInfo.getRenderSize());
    Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "CIContext.newTextureInfo(renderInfo.renderSize)");
    this.b = paramRenderInfo;
    paramRenderInfo = this.b;
    if (paramRenderInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
    }
    int i = paramRenderInfo.textureID;
    paramRenderInfo = this.b;
    if (paramRenderInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
    }
    int j = paramRenderInfo.width;
    paramRenderInfo = this.b;
    if (paramRenderInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
    }
    this.c = LightSurface.FromTexture(i, j, paramRenderInfo.height, true);
    paramRenderInfo = this.d;
    if (paramRenderInfo != null) {
      paramRenderInfo.setSurface(this.c);
    }
    paramRenderInfo = this.d;
    if (paramRenderInfo != null) {
      paramRenderInfo = paramRenderInfo.videoOutput();
    } else {
      paramRenderInfo = null;
    }
    this.a = paramRenderInfo;
  }
  
  private final boolean c(RenderInfo paramRenderInfo)
  {
    TextureInfo localTextureInfo = this.b;
    if (localTextureInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
    }
    if (localTextureInfo.width == paramRenderInfo.getRenderWidth())
    {
      localTextureInfo = this.b;
      if (localTextureInfo == null) {
        Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
      }
      if (localTextureInfo.height == paramRenderInfo.getRenderHeight()) {
        return false;
      }
    }
    return true;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((VideoOutput)localObject).release();
    }
    localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
    }
    if (localObject != null) {
      ((TextureInfo)localObject).release();
    }
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramImageParams, "imageParams");
    Intrinsics.checkParameterIsNotNull(paramRenderInfo, "renderInfo");
    if ((this.a == null) || (c(paramRenderInfo))) {
      b(paramRenderInfo);
    }
    VideoOutput localVideoOutput = this.a;
    if (localVideoOutput != null)
    {
      paramRenderInfo = paramRenderInfo.getTime();
      Intrinsics.checkExpressionValueIsNotNull(paramRenderInfo, "renderInfo.time");
      localVideoOutput.readSample(paramRenderInfo.getTimeUs());
    }
    paramImageParams.a().clear();
    paramImageParams = paramImageParams.a();
    paramRenderInfo = this.b;
    if (paramRenderInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("textureInfo");
    }
    paramImageParams.add(new ImageParams.ImageTrackPair(new CIImage(paramRenderInfo), null));
  }
  
  public boolean a(@Nullable RenderInfo paramRenderInfo)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.rendernode.LightRenderNode.LightFilter
 * JD-Core Version:    0.7.0.1
 */