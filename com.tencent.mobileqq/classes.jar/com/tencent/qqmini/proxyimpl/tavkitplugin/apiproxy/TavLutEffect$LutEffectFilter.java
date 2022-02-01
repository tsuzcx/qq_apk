package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class TavLutEffect$LutEffectFilter
  implements BaseEffectNode.Filter
{
  private BaseEffect b;
  private TextureInfo c;
  
  TavLutEffect$LutEffectFilter(TavLutEffect paramTavLutEffect)
  {
    if ((TavLutEffect.a(paramTavLutEffect) != null) && (!TavLutEffect.a(paramTavLutEffect).isRecycled()))
    {
      this.b = new LookupFilter(TavLutEffect.a(paramTavLutEffect), TavLutEffect.b(paramTavLutEffect));
      return;
    }
    b();
  }
  
  @NonNull
  private TAVTextureInfo a(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(TavLutEffect.c(this.a))) {
      return;
    }
    TavLutEffect localTavLutEffect = this.a;
    TavLutEffect.a(localTavLutEffect, BitmapFactory.decodeFile(TavLutEffect.c(localTavLutEffect)));
    if (TavLutEffect.a(this.a) != null) {
      this.b = new LookupFilter(TavLutEffect.a(this.a));
    }
  }
  
  @NonNull
  TextureInfo a(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((BaseEffect)localObject).release();
      this.b = null;
    }
    localObject = this.c;
    if ((localObject != null) && (!((TextureInfo)localObject).isReleased())) {
      this.c.release();
    }
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    if (this.b == null) {
      return;
    }
    if ((TavLutEffect.d(this.a) != null) && (!TavLutEffect.d(this.a).containsTime(paramRenderInfo.getTime()))) {
      return;
    }
    paramRenderInfo = paramRenderInfo.getCiContext();
    int i = 0;
    while (i < paramImageParams.a.size())
    {
      ImageParams.ImageTrackPair localImageTrackPair = (ImageParams.ImageTrackPair)paramImageParams.a.get(i);
      Object localObject = localImageTrackPair.b();
      int j = (int)((CIImage)localObject).getSize().width;
      int k = (int)((CIImage)localObject).getSize().height;
      this.b.setRendererWidth(j);
      this.b.setRendererHeight(k);
      if (this.c == null)
      {
        paramRenderInfo.getRenderContext().makeCurrent();
        this.c = CIContext.newTextureInfo(j, k);
      }
      if ((this.c.width != j) || (this.c.height != k))
      {
        paramRenderInfo.getRenderContext().makeCurrent();
        this.c.release();
        this.c = CIContext.newTextureInfo(j, k);
      }
      paramRenderInfo.convertImageToTexture((CIImage)localObject, this.c);
      localObject = a(this.c);
      localObject = a(this.b.applyFilter((TAVTextureInfo)localObject));
      ((TextureInfo)localObject).setTextureMatrix(this.c.getTextureMatrix());
      localImageTrackPair.a(new CIImage((TextureInfo)localObject));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavLutEffect.LutEffectFilter
 * JD-Core Version:    0.7.0.1
 */