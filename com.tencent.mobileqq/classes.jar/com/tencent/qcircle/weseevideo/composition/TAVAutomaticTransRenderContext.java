package com.tencent.qcircle.weseevideo.composition;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.GestureModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFramePAGItem;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameVisibleRegion;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerSolidItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGImage;
import org.libpag.PAGLayer;
import org.libpag.PAGRenderer;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/composition/TAVAutomaticTransRenderContext;", "Lcom/tencent/autotemplate/TAVAutomaticRenderContext;", "mediaModel", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "(Lcom/tencent/qcircle/weseevideo/model/MediaModel;)V", "TAG", "", "imgInScrPoints", "", "Landroid/graphics/PointF;", "getImgInScrPoints", "()Ljava/util/List;", "setImgInScrPoints", "(Ljava/util/List;)V", "getMediaModel", "()Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "pagFillMode", "", "getPagFillMode", "()I", "setPagFillMode", "(I)V", "screenSize", "Lcom/tencent/tav/coremedia/CGSize;", "getScreenSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setScreenSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "getScreenRect", "Landroid/graphics/RectF;", "renderStickerChainWithTexture", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "presentationTimeMs", "", "sourceImages", "", "Lcom/tencent/tavsticker/model/TAVSourceImage;", "replaceLayerAndTrans", "", "source", "layer", "Lorg/libpag/PAGLayer;", "replaceLayerColor", "renderer", "Lorg/libpag/PAGRenderer;", "sticker", "Lcom/tencent/tavsticker/model/TAVSticker;", "replaceLayerPhoto", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVAutomaticTransRenderContext
  extends TAVAutomaticRenderContext
{
  private final String TAG;
  @NotNull
  private List<? extends PointF> imgInScrPoints;
  @NotNull
  private final MediaModel mediaModel;
  private int pagFillMode;
  @NotNull
  private CGSize screenSize;
  
  public TAVAutomaticTransRenderContext(@NotNull MediaModel paramMediaModel)
  {
    this.mediaModel = paramMediaModel;
    this.TAG = "TAVAutomaticTransRenderContext";
    this.imgInScrPoints = CollectionsKt.emptyList();
    this.screenSize = new CGSize();
  }
  
  private final RectF getScreenRect()
  {
    return new RectF(0.0F, 0.0F, this.screenSize.width, this.screenSize.height);
  }
  
  private final void replaceLayerAndTrans(TAVSourceImage paramTAVSourceImage, PAGLayer paramPAGLayer)
  {
    float f3 = paramTAVSourceImage.getPagImage().width();
    float f4 = paramTAVSourceImage.getPagImage().height();
    float f1 = 0.0F;
    float f2 = 0.0F;
    Object localObject5 = new RectF(0.0F, 0.0F, f3, f4);
    Object localObject3 = getScreenRect();
    Object localObject4 = paramPAGLayer.getBounds();
    Object localObject2 = paramPAGLayer.getBounds();
    Object localObject1 = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mediaModel.mediaTemplate…tomaticMediaTemplateModel");
    Object localObject6 = ((AutomaticMediaTemplateModel)localObject1).getAEFrameModel();
    int i;
    if (localObject6 != null)
    {
      localObject1 = (Collection)((AEFrameModel)localObject6).getPagItems();
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        i = 0;
      } else {
        i = 1;
      }
      f1 = f2;
      localObject1 = localObject2;
      if (i == 0)
      {
        Object localObject7 = ((Iterable)((AEFrameModel)localObject6).getPagItems()).iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject1 = ((Iterator)localObject7).next();
          AEFramePAGItem localAEFramePAGItem = (AEFramePAGItem)localObject1;
          if (((CharSequence)((AEFrameModel)localObject6).getSelectedPAGName()).length() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if ((i == 0) && (!Intrinsics.areEqual(((AEFrameModel)localObject6).getSelectedPAGName(), localAEFramePAGItem.getPagName()))) {
            i = 0;
          } else {
            i = 1;
          }
          if (i != 0) {
            break label248;
          }
        }
        localObject1 = null;
        label248:
        localObject7 = (AEFramePAGItem)localObject1;
        f1 = f2;
        localObject1 = localObject2;
        if (localObject7 != null)
        {
          localObject2 = ((AEFramePAGItem)localObject7).getVisibleRegion();
          f1 = ((AEFrameVisibleRegion)localObject2).getWidth();
          f2 = paramPAGLayer.getBounds().width();
          f3 = ((AEFrameVisibleRegion)localObject2).getHeight();
          f4 = paramPAGLayer.getBounds().height();
          f5 = paramPAGLayer.getBounds().left + ((AEFrameVisibleRegion)localObject2).getOffsetX() * paramPAGLayer.getBounds().width();
          f6 = paramPAGLayer.getBounds().top + ((AEFrameVisibleRegion)localObject2).getOffsetY() * paramPAGLayer.getBounds().height();
          localObject1 = new RectF(f5, f6, f1 * f2 + f5, f3 * f4 + f6);
          f1 = ((AEFrameVisibleRegion)localObject2).getRotation();
        }
      }
      i = ((AEFrameModel)localObject6).getImageFillMode();
    }
    else
    {
      i = 0;
      localObject1 = localObject2;
    }
    f2 = ((RectF)localObject5).left;
    f3 = ((RectF)localObject5).top;
    f4 = ((RectF)localObject5).right;
    float f5 = ((RectF)localObject5).top;
    float f6 = ((RectF)localObject5).right;
    float f7 = ((RectF)localObject5).bottom;
    float f8 = ((RectF)localObject5).left;
    float f9 = ((RectF)localObject5).bottom;
    paramPAGLayer = new Matrix();
    float f10 = ((RectF)localObject5).width();
    float f11 = 2;
    paramPAGLayer.setRotate(f1, f10 / f11, ((RectF)localObject5).height() / f11);
    localObject2 = new Matrix();
    if (i != 0)
    {
      if (i != 1)
      {
        ((Matrix)localObject2).setRectToRect((RectF)localObject5, (RectF)localObject1, Matrix.ScaleToFit.CENTER);
      }
      else
      {
        localObject6 = new Matrix();
        ((Matrix)localObject6).setRectToRect((RectF)localObject1, (RectF)localObject5, Matrix.ScaleToFit.CENTER);
        ((Matrix)localObject6).invert((Matrix)localObject2);
      }
    }
    else {
      ((Matrix)localObject2).setRectToRect((RectF)localObject5, (RectF)localObject1, Matrix.ScaleToFit.CENTER);
    }
    localObject1 = new RectF();
    ((Matrix)localObject2).mapRect((RectF)localObject1, (RectF)localObject5);
    localObject5 = new Matrix();
    if (this.pagFillMode == 1) {
      ((Matrix)localObject5).setRectToRect((RectF)localObject1, (RectF)localObject3, Matrix.ScaleToFit.CENTER);
    } else {
      ((Matrix)localObject5).setRectToRect((RectF)localObject4, (RectF)localObject3, Matrix.ScaleToFit.CENTER);
    }
    localObject4 = new Matrix();
    localObject3 = new RectF();
    ((Matrix)localObject5).mapRect((RectF)localObject3, (RectF)localObject1);
    ((Matrix)localObject4).setRectToRect((RectF)localObject1, (RectF)localObject3, Matrix.ScaleToFit.FILL);
    localObject1 = new Matrix();
    ((Matrix)localObject4).invert((Matrix)localObject1);
    localObject3 = new Matrix();
    localObject5 = new float[8];
    ((Matrix)localObject3).set((Matrix)localObject2);
    ((Matrix)localObject3).preConcat(paramPAGLayer);
    ((Matrix)localObject3).postConcat((Matrix)localObject4);
    ((Matrix)localObject3).postConcat(this.mediaModel.getMediaEffectModel().getGestureModel().getGMatrix());
    ((Matrix)localObject3).mapPoints((float[])localObject5, new float[] { f2, f3, f4, f5, f6, f7, f8, f9 });
    localObject2 = (Iterable)CollectionsKt.chunked((Iterable)ArraysKt.asList((float[])localObject5), 2);
    paramPAGLayer = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (List)((Iterator)localObject2).next();
      paramPAGLayer.add(new PointF(((Number)((List)localObject4).get(0)).floatValue(), ((Number)((List)localObject4).get(1)).floatValue()));
    }
    this.imgInScrPoints = ((List)paramPAGLayer);
    ((Matrix)localObject3).postConcat((Matrix)localObject1);
    paramTAVSourceImage.setMatrix((Matrix)localObject3);
  }
  
  private final void replaceLayerColor(PAGRenderer paramPAGRenderer, TAVSourceImage paramTAVSourceImage, TAVSticker paramTAVSticker)
  {
    paramPAGRenderer = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    Intrinsics.checkExpressionValueIsNotNull(paramPAGRenderer, "mediaModel.mediaTemplate…tomaticMediaTemplateModel");
    paramPAGRenderer = paramPAGRenderer.getAEFrameModel();
    Object localObject2 = null;
    if (paramPAGRenderer != null) {
      paramPAGRenderer = paramPAGRenderer.getFrameColorLayerName();
    } else {
      paramPAGRenderer = null;
    }
    paramTAVSourceImage = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    Intrinsics.checkExpressionValueIsNotNull(paramTAVSourceImage, "mediaModel.mediaTemplate…tomaticMediaTemplateModel");
    paramTAVSourceImage = paramTAVSourceImage.getAEFrameModel();
    if (paramTAVSourceImage != null) {
      paramTAVSourceImage = Integer.valueOf(paramTAVSourceImage.getFrameColor());
    } else {
      paramTAVSourceImage = null;
    }
    Object localObject1 = (CharSequence)paramPAGRenderer;
    int i;
    if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (paramTAVSourceImage != null))
    {
      localObject1 = paramTAVSticker.getStickerSolidItems();
      if (localObject1 != null)
      {
        Iterator localIterator = ((Iterable)localObject1).iterator();
        TAVStickerSolidItem localTAVStickerSolidItem;
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = localIterator.next();
          localTAVStickerSolidItem = (TAVStickerSolidItem)localObject1;
          Intrinsics.checkExpressionValueIsNotNull(localTAVStickerSolidItem, "solidItem");
        } while (!Intrinsics.areEqual(localTAVStickerSolidItem.getLayerName(), paramPAGRenderer));
        paramPAGRenderer = (TAVStickerSolidItem)localObject1;
        if ((paramPAGRenderer != null) && (paramPAGRenderer.getColor() != paramTAVSourceImage.intValue()))
        {
          paramPAGRenderer.setColor(paramTAVSourceImage.intValue());
          paramTAVSticker.updateLayerColor();
        }
      }
    }
  }
  
  private final void replaceLayerPhoto(PAGRenderer paramPAGRenderer, TAVSourceImage paramTAVSourceImage, TAVSticker paramTAVSticker)
  {
    Object localObject1 = null;
    Object localObject2 = (PAGLayer)null;
    paramTAVSticker = this.mediaModel.getMediaTemplateModel().getAutomaticMediaTemplateModel();
    Intrinsics.checkExpressionValueIsNotNull(paramTAVSticker, "mediaModel.mediaTemplate…tomaticMediaTemplateModel");
    paramTAVSticker = paramTAVSticker.getAEFrameModel();
    if (paramTAVSticker != null)
    {
      paramTAVSticker = paramTAVSticker.getImageLayerName();
      if (paramTAVSticker != null) {}
    }
    else
    {
      paramTAVSticker = "mid_photo";
    }
    PAGLayer[] arrayOfPAGLayer = paramPAGRenderer.getRootComposition().getLayersByName(paramTAVSticker);
    int j = 1;
    int i = j;
    if (arrayOfPAGLayer != null)
    {
      if (arrayOfPAGLayer.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = j;
      } else {
        i = 0;
      }
    }
    paramTAVSticker = (TAVSticker)localObject2;
    if (i == 0) {
      paramTAVSticker = arrayOfPAGLayer[0];
    }
    if (paramTAVSticker == null)
    {
      paramTAVSticker = (TAVAutomaticTransRenderContext)this;
      paramTAVSticker = paramPAGRenderer.getRootComposition().getLayerAt(paramTAVSourceImage.getIndex());
      paramPAGRenderer = Unit.INSTANCE;
    }
    localObject2 = this.TAG;
    paramPAGRenderer = localObject1;
    if (paramTAVSticker != null) {
      paramPAGRenderer = paramTAVSticker.getBounds();
    }
    Logger.e((String)localObject2, String.valueOf(paramPAGRenderer));
    if (paramTAVSticker != null)
    {
      paramTAVSourceImage.setIndex(paramTAVSticker.editableIndex());
      replaceLayerAndTrans(paramTAVSourceImage, paramTAVSticker);
    }
  }
  
  @NotNull
  public final List<PointF> getImgInScrPoints()
  {
    return this.imgInScrPoints;
  }
  
  @NotNull
  public final MediaModel getMediaModel()
  {
    return this.mediaModel;
  }
  
  public final int getPagFillMode()
  {
    return this.pagFillMode;
  }
  
  @NotNull
  public final CGSize getScreenSize()
  {
    return this.screenSize;
  }
  
  @NotNull
  public CMSampleBuffer renderStickerChainWithTexture(long paramLong, @NotNull List<TAVSourceImage> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "sourceImages");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      TAVSourceImage localTAVSourceImage = (TAVSourceImage)localIterator.next();
      Object localObject = this.stickers;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "stickers");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)((Iterator)localObject).next();
        PAGRenderer localPAGRenderer = new PAGRenderer();
        Intrinsics.checkExpressionValueIsNotNull(localTAVSticker, "sticker");
        localPAGRenderer.setFile(localTAVSticker.getPagFile());
        replaceLayerColor(localPAGRenderer, localTAVSourceImage, localTAVSticker);
        replaceLayerPhoto(localPAGRenderer, localTAVSourceImage, localTAVSticker);
      }
    }
    paramList = super.renderStickerChainWithTexture(paramLong, paramList);
    Intrinsics.checkExpressionValueIsNotNull(paramList, "super.renderStickerChain…tionTimeMs, sourceImages)");
    return paramList;
  }
  
  public final void setImgInScrPoints(@NotNull List<? extends PointF> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.imgInScrPoints = paramList;
  }
  
  public final void setPagFillMode(int paramInt)
  {
    this.pagFillMode = paramInt;
  }
  
  public final void setScreenSize(@NotNull CGSize paramCGSize)
  {
    Intrinsics.checkParameterIsNotNull(paramCGSize, "<set-?>");
    this.screenSize = paramCGSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.TAVAutomaticTransRenderContext
 * JD-Core Version:    0.7.0.1
 */