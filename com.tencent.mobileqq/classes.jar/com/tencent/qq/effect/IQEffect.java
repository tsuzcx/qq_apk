package com.tencent.qq.effect;

import android.content.Context;
import com.tencent.qq.effect.engine.QEffectData;

public abstract interface IQEffect<T extends QEffectData, K>
{
  public abstract void complete(K paramK);
  
  public abstract boolean isGravityEnable();
  
  public abstract void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, T paramT);
  
  public abstract void pause();
  
  public abstract void play();
  
  public abstract void resume();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.IQEffect
 * JD-Core Version:    0.7.0.1
 */