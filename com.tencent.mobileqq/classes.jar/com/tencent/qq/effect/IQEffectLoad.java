package com.tencent.qq.effect;

import android.content.Context;
import com.tencent.qq.effect.engine.QEffectData;

public abstract interface IQEffectLoad<T extends QEffectData>
{
  public static final int HTTP_TYPE = 2;
  public static final int LOCAL_TYPE = 1;
  public static final int NO_TYPE = 0;
  public static final int RESID_TYPE = 3;
  
  public abstract void load(Context paramContext, IQEffect paramIQEffect, T paramT);
  
  public abstract void loadFromAsset(Context paramContext, IQEffect paramIQEffect, String paramString);
  
  public abstract void loadFromFile(Context paramContext, IQEffect paramIQEffect, String paramString);
  
  public abstract void loadFromResource(Context paramContext, IQEffect paramIQEffect, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.IQEffectLoad
 * JD-Core Version:    0.7.0.1
 */