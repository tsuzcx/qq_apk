package com.tencent.tavmovie.filter;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.CanyingEffect;
import com.tencent.taveffect.effects.ChongdieEffect;
import com.tencent.taveffect.effects.GanraoEffect;
import com.tencent.taveffect.effects.HuanjueEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.taveffect.effects.LvdongEffect;
import com.tencent.taveffect.effects.RGBEffect;
import com.tencent.taveffect.effects.ShanbaiEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class TAVMovieFilterProxy
  implements TAVVideoEffect
{
  private static final String TAG = "TAVMovieFilterProxy";
  public static final int TYPE_CAN_YING = 2;
  public static final int TYPE_CHONG_DIE = 3;
  public static final int TYPE_GAN_RAO = 4;
  public static final int TYPE_HUAN_JUE = 5;
  public static final int TYPE_LOOK_UP = 0;
  public static final int TYPE_LV_DONG = 6;
  public static final int TYPE_RGB = 1;
  public static final int TYPE_SHAN_BAI = 7;
  private Bitmap bitmap;
  private int effectID;
  
  public TAVMovieFilterProxy(int paramInt)
  {
    this.effectID = paramInt;
  }
  
  public TAVMovieFilterProxy(int paramInt, Bitmap paramBitmap)
  {
    this.effectID = paramInt;
    this.bitmap = paramBitmap;
  }
  
  @NonNull
  private BaseEffect createEffect()
  {
    switch (this.effectID)
    {
    default: 
      return new RGBEffect();
    case 7: 
      return new ShanbaiEffect();
    case 6: 
      return new LvdongEffect();
    case 5: 
      return new HuanjueEffect();
    case 4: 
      return new GanraoEffect();
    case 3: 
      return new ChongdieEffect();
    case 2: 
      return new CanyingEffect();
    case 1: 
      return new RGBEffect();
    }
    Bitmap localBitmap = this.bitmap;
    if (localBitmap == null) {
      return null;
    }
    return new LookupFilter(localBitmap);
  }
  
  @NonNull
  private TextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  @NonNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new TAVMovieFilterProxy.TAVMovieFilterEffect(this);
  }
  
  public String effectId()
  {
    return "TAVMovieFilterProxy";
  }
  
  public void release()
  {
    Bitmap localBitmap = this.bitmap;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.bitmap.recycle();
      this.bitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVMovieFilterProxy
 * JD-Core Version:    0.7.0.1
 */