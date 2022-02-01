package com.tencent.tavcut.render;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.render.rendernode.BaseEffectNode.Filter;
import com.tencent.tavcut.render.rendernode.ImageParams;
import com.tencent.tavcut.render.rendernode.ImageParams.ImageTrackPair;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/EffectDispatcher$DispatcherFilter;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectNodes", "", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode;", "effectDispatchListener", "Lcom/tencent/tavcut/render/EffectDispatcher$EffectDispatchListener;", "(Ljava/util/List;Lcom/tencent/tavcut/render/EffectDispatcher$EffectDispatchListener;)V", "backImage", "Lcom/tencent/tavkit/ciimage/CIImage;", "imageParams", "Lcom/tencent/tavcut/render/rendernode/ImageParams;", "mFilters", "", "Lcom/tencent/tavcut/render/rendernode/BaseEffectNode$Filter;", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "showCanvas", "", "apply", "effect", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "imageCollection", "Lcom/tencent/tavkit/composition/video/ImageCollection;", "renderInfo", "Lcom/tencent/tavkit/composition/video/RenderInfo;", "checkFillInRenderSize", "", "imagePair", "Lcom/tencent/tavkit/composition/video/ImageCollection$TrackImagePair;", "sourceImage", "checkRenderTime", "defaultApply", "initBackColorImage", "release", "setRenderTimeRange", "setRenderTimeRange$lib_tavcut_release", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class EffectDispatcher$DispatcherFilter
  implements TAVVideoMixEffect.Filter
{
  private final ImageParams a;
  private List<BaseEffectNode.Filter> b;
  private CIImage c;
  private boolean d;
  private CMTimeRange e;
  private final EffectDispatcher.EffectDispatchListener f;
  
  public EffectDispatcher$DispatcherFilter(@NotNull List<? extends BaseEffectNode> paramList, @Nullable EffectDispatcher.EffectDispatchListener paramEffectDispatchListener)
  {
    this.f = paramEffectDispatchListener;
    this.a = new ImageParams();
    this.b = ((List)new ArrayList());
    paramList = new ArrayList((Collection)paramList);
    if ((((Collection)paramList).isEmpty() ^ true)) {
      CollectionsKt.sortWith((List)paramList, (Comparator)EffectDispatcher.DispatcherFilter.1.a);
    }
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      paramEffectDispatchListener = (BaseEffectNode)paramList.next();
      this.b.add(paramEffectDispatchListener.c());
    }
  }
  
  private final CIImage a(ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    CIImage localCIImage1 = new CIImage(paramRenderInfo.getRenderSize());
    Object localObject1 = paramImageCollection.getVideoChannelImages().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageCollection.TrackImagePair)((Iterator)localObject1).next();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "trackImage");
      CIImage localCIImage2 = ((ImageCollection.TrackImagePair)localObject2).getImage();
      Intrinsics.checkExpressionValueIsNotNull(localCIImage2, "trackImage.image");
      a(paramRenderInfo, (ImageCollection.TrackImagePair)localObject2, localCIImage2);
      localCIImage2.imageByCompositingOverImage(localCIImage1);
    }
    paramImageCollection = paramImageCollection.getOverlayImages().iterator();
    while (paramImageCollection.hasNext())
    {
      localObject1 = (ImageCollection.TrackImagePair)paramImageCollection.next();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "overlay");
      localObject2 = ((ImageCollection.TrackImagePair)localObject1).getImage();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "overlay.image");
      a(paramRenderInfo, (ImageCollection.TrackImagePair)localObject1, (CIImage)localObject2);
      ((CIImage)localObject2).imageByCompositingOverImage(localCIImage1);
    }
    return localCIImage1;
  }
  
  private final RenderInfo a(RenderInfo paramRenderInfo)
  {
    CMTimeRange localCMTimeRange = this.e;
    if (localCMTimeRange != null)
    {
      CMTime localCMTime = (CMTime)null;
      if (paramRenderInfo.getTime().bigThan(localCMTimeRange.getEnd())) {
        localCMTime = localCMTimeRange.getEnd();
      }
      if (paramRenderInfo.getTime().smallThan(localCMTimeRange.getStart())) {
        localCMTime = localCMTimeRange.getStart();
      }
      if (localCMTime != null) {
        return new RenderInfo(localCMTime, paramRenderInfo.getRenderSize(), paramRenderInfo.getCiContext());
      }
    }
    return paramRenderInfo;
  }
  
  private final void a(RenderInfo paramRenderInfo, ImageCollection.TrackImagePair paramTrackImagePair, CIImage paramCIImage)
  {
    if (!(paramTrackImagePair.getTrack() instanceof TAVClip)) {
      return;
    }
    paramTrackImagePair = paramTrackImagePair.getTrack();
    if (paramTrackImagePair != null)
    {
      paramTrackImagePair = ((TAVClip)paramTrackImagePair).getVideoConfiguration();
      if (paramTrackImagePair.frameEnable()) {
        return;
      }
      paramRenderInfo = new CGRect(new PointF(0.0F, 0.0F), paramRenderInfo.getRenderSize());
      Intrinsics.checkExpressionValueIsNotNull(paramTrackImagePair, "config");
      paramCIImage.applyFillInFrame(paramRenderInfo, paramTrackImagePair.getContentMode());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavkit.composition.TAVClip");
  }
  
  private final void b(RenderInfo paramRenderInfo)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (localObject != null) {
        localObject = ((CIImage)localObject).getSize();
      } else {
        localObject = null;
      }
      if (!(Intrinsics.areEqual(localObject, paramRenderInfo.getRenderSize()) ^ true)) {}
    }
    else
    {
      localObject = new ColorDrawable(-16711936);
      paramRenderInfo = Bitmap.createBitmap(paramRenderInfo.getRenderWidth(), paramRenderInfo.getRenderHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramRenderInfo);
      ((ColorDrawable)localObject).setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      ((ColorDrawable)localObject).draw(localCanvas);
      this.c = new CIImage(paramRenderInfo);
    }
  }
  
  @NotNull
  public CIImage apply(@NotNull TAVVideoMixEffect paramTAVVideoMixEffect, @NotNull ImageCollection paramImageCollection, @NotNull RenderInfo paramRenderInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVVideoMixEffect, "effect");
    Intrinsics.checkParameterIsNotNull(paramImageCollection, "imageCollection");
    Intrinsics.checkParameterIsNotNull(paramRenderInfo, "renderInfo");
    System.currentTimeMillis();
    this.a.a().clear();
    paramTAVVideoMixEffect = paramImageCollection.getVideoChannelImages().iterator();
    Object localObject;
    while (paramTAVVideoMixEffect.hasNext())
    {
      localObject = (ImageCollection.TrackImagePair)paramTAVVideoMixEffect.next();
      List localList = this.a.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "trackImagePair");
      CIImage localCIImage = ((ImageCollection.TrackImagePair)localObject).getImage();
      Intrinsics.checkExpressionValueIsNotNull(localCIImage, "trackImagePair.image");
      localList.add(new ImageParams.ImageTrackPair(localCIImage, ((ImageCollection.TrackImagePair)localObject).getTrack()));
    }
    paramTAVVideoMixEffect = a(paramRenderInfo);
    paramRenderInfo = this.f;
    if (paramRenderInfo != null) {
      paramRenderInfo.a();
    }
    paramRenderInfo = this.b.iterator();
    while (paramRenderInfo.hasNext())
    {
      localObject = (BaseEffectNode.Filter)paramRenderInfo.next();
      if (((BaseEffectNode.Filter)localObject).a(paramTAVVideoMixEffect)) {
        ((BaseEffectNode.Filter)localObject).a(this.a, paramTAVVideoMixEffect);
      }
    }
    if (this.d)
    {
      b(paramTAVVideoMixEffect);
      paramRenderInfo = (ImageParams.ImageTrackPair)this.a.a().get(0);
      localObject = ((ImageParams.ImageTrackPair)this.a.a().get(0)).a().imageByCompositingOverImage(this.c);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "imageParams.videoChannel…itingOverImage(backImage)");
      paramRenderInfo.a((CIImage)localObject);
    }
    paramRenderInfo = this.f;
    if (paramRenderInfo != null) {
      paramRenderInfo.b();
    }
    if (this.a.a().size() > 0) {
      return ((ImageParams.ImageTrackPair)this.a.a().get(0)).a();
    }
    return a(paramImageCollection, paramTAVVideoMixEffect);
  }
  
  public void release()
  {
    Object localObject = ((Iterable)this.b).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BaseEffectNode.Filter)((Iterator)localObject).next()).a();
    }
    localObject = this.f;
    if (localObject != null) {
      ((EffectDispatcher.EffectDispatchListener)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.EffectDispatcher.DispatcherFilter
 * JD-Core Version:    0.7.0.1
 */