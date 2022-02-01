package com.tencent.mobileqq.vas.theme.effect;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.engine.QEffectData;

public class QEffectLoad
  implements IQEffectLoad
{
  public void load(Context paramContext, IQEffect paramIQEffect, QEffectData paramQEffectData)
  {
    int i = paramQEffectData.resType;
    if (i != 1)
    {
      if (i != 3) {
        return;
      }
      loadFromResource(paramContext, paramIQEffect, paramQEffectData.resId);
      return;
    }
    loadFromFile(paramContext, paramIQEffect, paramQEffectData.src);
  }
  
  public void loadFromAsset(Context paramContext, IQEffect paramIQEffect, String paramString) {}
  
  public void loadFromFile(Context paramContext, IQEffect paramIQEffect, String paramString)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mLoadingDrawable = ApngOptions.a;
    paramContext.mFailedDrawable = ApngOptions.a;
    paramIQEffect.complete(URLDrawable.getFileDrawable(paramString, paramContext));
  }
  
  public void loadFromResource(Context paramContext, IQEffect paramIQEffect, int paramInt)
  {
    if (paramContext != null) {
      paramIQEffect.complete(paramContext.getResources().getDrawable(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.effect.QEffectLoad
 * JD-Core Version:    0.7.0.1
 */