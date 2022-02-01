package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class PagMixerEffect$MyFilter
  implements BaseEffectNode.Filter
{
  private final PagAutomaticRenderContext a = new PagAutomaticRenderContext();
  private HashMap<String, Integer> b = new HashMap();
  private HashMap<String, TextureInfo> c = new HashMap();
  private RenderContext d;
  
  public PagMixerEffect$MyFilter(List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      this.a.loadSticker(localTAVSticker);
    }
  }
  
  public void a()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((RenderContext)localObject).makeCurrent();
    }
    localObject = this.a;
    if (localObject != null) {
      ((PagAutomaticRenderContext)localObject).release();
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TextureInfo)((Iterator)localObject).next()).release();
      }
      this.c.clear();
    }
    localObject = this.b;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release cache.");
    ((StringBuilder)localObject).append(Log.getStackTraceString(new RuntimeException()));
    Logger.d("PagMixerEffect", ((StringBuilder)localObject).toString());
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    if (!BaseFilter.a(paramRenderInfo.getTime(), this.a.getStickers())) {
      return;
    }
    this.a.setRenderSize(paramRenderInfo.getRenderSize());
    ArrayList localArrayList = new ArrayList();
    this.d = paramRenderInfo.getCiContext().getRenderContext();
    this.b.clear();
    if (!paramImageParams.a.isEmpty())
    {
      int i = 0;
      while (i < paramImageParams.a.size())
      {
        Object localObject1 = (ImageParams.ImageTrackPair)paramImageParams.a.get(i);
        if (localObject1 != null)
        {
          Object localObject2 = ((ImageParams.ImageTrackPair)localObject1).a().getExtraTrackInfo("layerIndex");
          int j;
          if ((localObject2 instanceof Integer)) {
            j = ((Integer)localObject2).intValue();
          } else {
            j = i;
          }
          CIImage localCIImage = ((ImageParams.ImageTrackPair)localObject1).b();
          int k = (int)localCIImage.getSize().width;
          int m = (int)localCIImage.getSize().height;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append("_");
          ((StringBuilder)localObject1).append(m);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = (Integer)this.b.get(localObject1);
          if (localObject2 == null) {
            this.b.put(localObject1, Integer.valueOf(1));
          } else {
            this.b.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + 1));
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("_");
          ((StringBuilder)localObject2).append(this.b.get(localObject1));
          String str = ((StringBuilder)localObject2).toString();
          localObject2 = (TextureInfo)this.c.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            this.d.makeCurrent();
            localObject1 = CIContext.newTextureInfo(k, m);
            this.c.put(str, localObject1);
          }
          paramRenderInfo.getCiContext().convertImageToTexture(localCIImage, (TextureInfo)localObject1);
          localArrayList.add(new TAVSourceImage((TextureInfo)localObject1, true, j));
        }
        i += 1;
      }
    }
    long l = paramRenderInfo.getTime().getTimeUs() / 1000L;
    paramRenderInfo = this.a.a(l, localArrayList);
    this.d.makeCurrent();
    if (paramRenderInfo != null)
    {
      paramRenderInfo = paramRenderInfo.getTextureInfo();
      paramImageParams.a.clear();
      paramRenderInfo = new ImageParams.ImageTrackPair(new CIImage(paramRenderInfo), null);
      paramImageParams.a.add(paramRenderInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagMixerEffect.MyFilter
 * JD-Core Version:    0.7.0.1
 */