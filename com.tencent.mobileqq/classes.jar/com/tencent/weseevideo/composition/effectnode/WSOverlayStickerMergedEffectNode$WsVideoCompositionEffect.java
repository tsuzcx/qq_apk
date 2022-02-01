package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.weseevideo.editor.sticker.IBlurStickerRenderContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class WSOverlayStickerMergedEffectNode$WsVideoCompositionEffect
  implements TAVVideoEffect.Filter, IReportable
{
  long applyEffectStartTime;
  @Nullable
  private TAVStickerRenderContext cloneStickerContext;
  private CMTime currentTime = CMTime.CMTimeZero;
  private GaosiBlurFilter horizontalBlurFilter = new GaosiBlurFilter(true, 20);
  private ScaleTextureFilter scaleBigTextureFilter = new ScaleTextureFilter();
  private ScaleTextureFilter scaleSmallTextureFilter = new ScaleTextureFilter();
  @Nullable
  private TAVStickerRenderContext stickerContext;
  private HashMap<String, TextureInfo> textureMap = new HashMap();
  private GaosiBlurFilter verticalBlurFilter = new GaosiBlurFilter(false, 20);
  
  private WSOverlayStickerMergedEffectNode$WsVideoCompositionEffect(WSOverlayStickerMergedEffectNode paramWSOverlayStickerMergedEffectNode, @NotNull TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  private CIImage applyEffectHard(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, CIImage paramCIImage, CMTime paramCMTime, CIContext paramCIContext)
  {
    if ((WSOverlayStickerMergedEffectNode.access$300(this.this$0) == null) || (WSOverlayStickerMergedEffectNode.access$400(this.this$0).isEmpty())) {
      return paramCIImage;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = WSOverlayStickerMergedEffectNode.access$500(this.this$0).iterator();
    TAVSticker localTAVSticker;
    while (localIterator.hasNext())
    {
      localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker.getTimeRange().containsTime(paramCMTime)) {
        localArrayList.add(localTAVSticker);
      }
    }
    if (localArrayList.isEmpty()) {
      releaseCloneRenderContext();
    }
    if ((WSOverlayStickerMergedEffectNode.access$600(this.this$0)) && (this.cloneStickerContext != null) && (localArrayList.size() < this.cloneStickerContext.getStickerCount())) {
      releaseCloneRenderContext();
    }
    localIterator = localArrayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localTAVSticker = (TAVSticker)localIterator.next();
    } while ((this.cloneStickerContext == null) || (this.cloneStickerContext.containSticker(localTAVSticker)));
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (WSOverlayStickerMergedEffectNode.access$700(this.this$0))) {
        releaseCloneRenderContext();
      }
      renderByCloneContext(paramTAVStickerRenderContext, localArrayList, paramCIImage, paramCMTime, paramCIContext);
      return paramCIImage;
    }
  }
  
  private CIImage applyWithBlurStickerRenderContext(TAVStickerRenderContext paramTAVStickerRenderContext, TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    this.applyEffectStartTime = System.currentTimeMillis();
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    if (paramTAVStickerRenderContext == null) {}
    CMSampleBuffer localCMSampleBuffer;
    do
    {
      do
      {
        return paramCIImage;
        this.currentTime = paramRenderInfo.getTime();
        if (WSOverlayStickerMergedEffectNode.access$200(this.this$0)) {
          return applyEffectHard(paramTAVStickerRenderContext, paramCIImage, paramRenderInfo.getTime(), paramTAVVideoEffect);
        }
        this.stickerContext.setRenderSize(paramCIImage.getSize());
        localCMSampleBuffer = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, null, paramTAVVideoEffect.getRenderContext().eglContext());
        paramTAVVideoEffect.getRenderContext().makeCurrent();
      } while (noStickerRender(paramRenderInfo.getTime(), paramTAVStickerRenderContext.getStickers()));
      this.applyEffectStartTime = System.currentTimeMillis();
    } while (localCMSampleBuffer == null);
    if (localCMSampleBuffer.isNewFrame()) {
      this.stickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    paramTAVVideoEffect = localCMSampleBuffer.getTextureInfo();
    paramTAVVideoEffect.setMixAlpha(false);
    paramTAVVideoEffect = new CIImage(paramTAVVideoEffect);
    if (((IBlurStickerRenderContext)paramTAVStickerRenderContext).shouldRenderBlurSticker())
    {
      insertBlurCIImage(paramCIImage, paramRenderInfo, paramTAVVideoEffect);
      return paramCIImage;
    }
    paramTAVVideoEffect.imageByCompositingOverImage(paramCIImage);
    Log.d("blur_cost", String.format("------------------无马赛克渲染总耗时：%d%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.applyEffectStartTime), "------------------" }));
    return paramCIImage;
  }
  
  private CIImage applyWithTAVStickerRenderContext(TAVStickerRenderContext paramTAVStickerRenderContext, TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    if (paramTAVStickerRenderContext == null) {}
    CMSampleBuffer localCMSampleBuffer;
    do
    {
      return paramCIImage;
      this.currentTime = paramRenderInfo.getTime();
      if (WSOverlayStickerMergedEffectNode.access$100(this.this$0)) {
        return applyEffectHard(paramTAVStickerRenderContext, paramCIImage, paramRenderInfo.getTime(), paramTAVVideoEffect);
      }
      this.stickerContext.setRenderSize(paramCIImage.getSize());
      localCMSampleBuffer = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, null, paramTAVVideoEffect.getRenderContext().eglContext());
      paramTAVVideoEffect.getRenderContext().makeCurrent();
    } while ((noStickerRender(paramRenderInfo.getTime(), paramTAVStickerRenderContext.getStickers())) || (localCMSampleBuffer == null));
    if (localCMSampleBuffer.isNewFrame()) {
      this.stickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    paramTAVStickerRenderContext = localCMSampleBuffer.getTextureInfo();
    paramTAVStickerRenderContext.setMixAlpha(false);
    new CIImage(paramTAVStickerRenderContext).imageByCompositingOverImage(paramCIImage);
    return paramCIImage;
  }
  
  @NotNull
  private TextureInfo getBlurredTextureInfo(TextureInfo paramTextureInfo, RenderInfo paramRenderInfo, int paramInt1, int paramInt2, float paramFloat)
  {
    int i;
    if (paramInt1 == 0)
    {
      i = paramRenderInfo.getRenderWidth();
      if (paramInt1 != 0) {
        break label344;
      }
    }
    label344:
    for (paramInt1 = paramRenderInfo.getRenderHeight();; paramInt1 = paramRenderInfo.getRenderWidth())
    {
      this.horizontalBlurFilter.setRadius(paramInt2);
      this.verticalBlurFilter.setRadius(paramInt2);
      paramRenderInfo = getTavTextureInfo(paramTextureInfo, i, paramInt1);
      paramInt2 = (int)Math.floor(i * paramFloat);
      int j = (int)Math.floor(paramInt1 * paramFloat);
      Log.d("black_line", "w: " + i);
      Log.d("black_line", "h: " + paramInt1);
      Log.d("black_line", "w*scale: " + paramInt2);
      Log.d("black_line", "h*scale: " + j);
      this.horizontalBlurFilter.setRendererWidth(paramInt2);
      this.horizontalBlurFilter.setRendererHeight(j);
      this.verticalBlurFilter.setRendererWidth(paramInt2);
      this.verticalBlurFilter.setRendererHeight(j);
      this.scaleSmallTextureFilter.setRendererWidth(paramInt2);
      this.scaleSmallTextureFilter.setRendererHeight(j);
      this.scaleBigTextureFilter.setRendererWidth(i);
      this.scaleBigTextureFilter.setRendererHeight(paramInt1);
      this.scaleSmallTextureFilter.scale(paramFloat, 0.0F, 0.0F);
      paramRenderInfo = this.scaleSmallTextureFilter.applyFilter(paramRenderInfo);
      paramRenderInfo = this.verticalBlurFilter.applyFilter(this.horizontalBlurFilter.applyFilter(paramRenderInfo));
      this.scaleBigTextureFilter.scale(Math.max(paramInt1 * 1.0F / j, i * 1.0F / paramInt2), 0.0F, 0.0F);
      return getTextureInfo(paramTextureInfo, i, paramInt1, this.scaleBigTextureFilter.applyFilter(paramRenderInfo));
      i = paramRenderInfo.getRenderHeight();
      break;
    }
  }
  
  private TextureInfo getCacheTextureInfo(int paramInt1, int paramInt2)
  {
    String str = paramInt1 + "_" + paramInt2;
    TextureInfo localTextureInfo1 = null;
    if (this.textureMap.containsKey(str)) {
      localTextureInfo1 = (TextureInfo)this.textureMap.get(str);
    }
    TextureInfo localTextureInfo2 = localTextureInfo1;
    if (localTextureInfo1 == null)
    {
      localTextureInfo2 = CIContext.newTextureInfo(paramInt1, paramInt2);
      this.textureMap.put(str, localTextureInfo2);
    }
    return localTextureInfo2;
  }
  
  @NotNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo, int paramInt1, int paramInt2)
  {
    if (paramTextureInfo.getTextureMatrix() != null)
    {
      float[] arrayOfFloat = new float[9];
      paramTextureInfo.getTextureMatrix().getValues(arrayOfFloat);
      return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramInt1, paramInt2, arrayOfFloat, paramTextureInfo.preferRotation);
    }
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramInt1, paramInt2, null, paramTextureInfo.preferRotation);
  }
  
  @NotNull
  private TextureInfo getTextureInfo(TextureInfo paramTextureInfo, int paramInt1, int paramInt2, TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramInt1, paramInt2, paramTextureInfo.getTextureMatrix(), paramTextureInfo.preferRotation);
  }
  
  private void insertBlurCIImage(CIImage paramCIImage1, RenderInfo paramRenderInfo, CIImage paramCIImage2)
  {
    Object localObject2 = ((IBlurStickerRenderContext)this.stickerContext).getBlurStickers();
    Object localObject1 = paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage1, getCacheTextureInfo((int)paramCIImage1.getSize().width, (int)paramCIImage1.getSize().height));
    int i = ((TextureInfo)localObject1).preferRotation;
    localObject1 = new CIImage(getBlurredTextureInfo((TextureInfo)localObject1, paramRenderInfo, i, 10, 0.25F));
    ((CIImage)localObject1).applyPreferRotation(0);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (TAVSticker)((Iterator)localObject2).next();
      if (((TAVSticker)localObject3).getMode() != TAVStickerMode.INACTIVE)
      {
        if (isRenderNormalSticker()) {
          paramCIImage2.imageByCompositingOverImage((CIImage)localObject1);
        }
        ((CIImage)localObject1).imageByCompositingOverImage(paramCIImage1);
      }
      else
      {
        CIImage localCIImage = new CIImage(((CIImage)localObject1).getDrawTextureInfo().clone());
        localCIImage.applyPreferRotation(0);
        localCIImage.applyFillInFrame(new CGRect(new PointF(0.0F, 0.0F), paramRenderInfo.getRenderSize()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        localObject3 = TAVStickerUtil.computeRectanglePoints(WsStickerUtil.getRatioChangeMatrix((TAVSticker)localObject3, (int)localCIImage.getSize().width, (int)localCIImage.getSize().height), ((TAVSticker)localObject3).getWidth(), ((TAVSticker)localObject3).getHeight());
        CGRect localCGRect = new CGRect();
        Object localObject4 = localCGRect.size;
        if (i == 1)
        {
          f = localObject3[1].x - localObject3[0].x;
          label276:
          ((CGSize)localObject4).height = f;
          localObject4 = localCGRect.size;
          if (i != 1) {
            break label457;
          }
          f = localObject3[3].y - localObject3[0].y;
          label313:
          ((CGSize)localObject4).width = f;
          localObject4 = localCGRect.origin;
          if (i != 1) {
            break label477;
          }
          f = localCIImage.getSize().height - localObject3[1].y - localCGRect.size.width;
          label360:
          ((PointF)localObject4).x = f;
          localObject4 = localCGRect.origin;
          if (i != 1) {
            break label489;
          }
        }
        label457:
        label477:
        label489:
        for (float f = localCIImage.getSize().width - localObject3[1].x;; f = localCIImage.getSize().height - localObject3[1].y - localCGRect.size.height)
        {
          ((PointF)localObject4).y = f;
          localCIImage.setFrame(localCGRect);
          if (isRenderNormalSticker()) {
            paramCIImage2.imageByCompositingOverImage(localCIImage);
          }
          localCIImage.imageByCompositingOverImage((CIImage)localObject1);
          break;
          f = localObject3[3].y - localObject3[0].y;
          break label276;
          f = localObject3[1].x - localObject3[0].x;
          break label313;
          f = localObject3[0].x;
          break label360;
        }
      }
    }
    ((CIImage)localObject1).imageByCompositingOverImage(paramCIImage1);
    ((CIImage)localObject1).clearSelfTexture();
  }
  
  private boolean isRenderNormalSticker()
  {
    if (this.stickerContext.getStickers().size() > ((IBlurStickerRenderContext)this.stickerContext).getBlurStickers().size())
    {
      Iterator localIterator = this.stickerContext.getStickers().iterator();
      while (localIterator.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
        if ((!((IBlurStickerRenderContext)this.stickerContext).getBlurStickers().contains(localTAVSticker)) && (localTAVSticker.getMode() == TAVStickerMode.INACTIVE)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean noStickerRender(CMTime paramCMTime, List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      CMTimeRange localCMTimeRange = localTAVSticker.getTimeRange();
      if (((localCMTimeRange == null) || (localCMTimeRange.containsTime(paramCMTime))) && (localTAVSticker.getMode() == TAVStickerMode.INACTIVE)) {
        return false;
      }
    }
    return true;
  }
  
  private void releaseCloneRenderContext()
  {
    if (this.cloneStickerContext != null)
    {
      this.cloneStickerContext.release();
      this.cloneStickerContext.removeAllStickers();
      this.cloneStickerContext = null;
    }
  }
  
  private void renderByCloneContext(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, List<TAVSticker> paramList, CIImage paramCIImage, CMTime paramCMTime, CIContext paramCIContext)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        if (this.cloneStickerContext == null) {
          this.cloneStickerContext = paramTAVStickerRenderContext.copy();
        }
      } while (this.cloneStickerContext == null);
      paramTAVStickerRenderContext = paramList.iterator();
      while (paramTAVStickerRenderContext.hasNext())
      {
        paramList = (TAVSticker)paramTAVStickerRenderContext.next();
        if (!this.cloneStickerContext.containSticker(paramList)) {
          this.cloneStickerContext.loadSticker(paramList);
        }
      }
      this.cloneStickerContext.setRenderSize(paramCIImage.getSize());
      paramTAVStickerRenderContext = this.cloneStickerContext.renderSticker(paramCMTime.getTimeUs() / 1000L, null, paramCIContext.getRenderContext().eglContext());
      paramCIContext.getRenderContext().makeCurrent();
    } while (paramTAVStickerRenderContext == null);
    if (paramTAVStickerRenderContext.isNewFrame()) {
      this.cloneStickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    new CIImage(paramTAVStickerRenderContext.getTextureInfo()).imageByCompositingOverImage(paramCIImage);
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if ((this.stickerContext instanceof IBlurStickerRenderContext)) {
      return applyWithBlurStickerRenderContext(this.stickerContext, paramTAVVideoEffect, paramCIImage, paramRenderInfo);
    }
    return applyWithTAVStickerRenderContext(this.stickerContext, paramTAVVideoEffect, paramCIImage, paramRenderInfo);
  }
  
  public String getReportKey()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.stickerContext != null) {
      synchronized (this.stickerContext.getStickers())
      {
        Iterator localIterator = this.stickerContext.getStickers().iterator();
        while (localIterator.hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
          if ((localTAVSticker != null) && ((localTAVSticker.getTimeRange() == null) || (localTAVSticker.getTimeRange().containsTime(this.currentTime)))) {
            localArrayList.add(localTAVSticker.getStickerId());
          }
        }
      }
    }
    if (!localCollection.isEmpty()) {
      return WSOverlayStickerMergedEffectNode.access$800(this.this$0) + ":[" + MemoryReportHelper.appendKeys(localCollection) + "]";
    }
    return null;
  }
  
  public void release()
  {
    releaseCloneRenderContext();
    if ((this.stickerContext != null) && (this.this$0.getStickerContext() != this.stickerContext))
    {
      this.stickerContext.release();
      this.stickerContext = null;
    }
    if (this.verticalBlurFilter != null)
    {
      this.verticalBlurFilter.release();
      this.verticalBlurFilter = null;
    }
    if (this.horizontalBlurFilter != null)
    {
      this.horizontalBlurFilter.release();
      this.horizontalBlurFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode.WsVideoCompositionEffect
 * JD-Core Version:    0.7.0.1
 */