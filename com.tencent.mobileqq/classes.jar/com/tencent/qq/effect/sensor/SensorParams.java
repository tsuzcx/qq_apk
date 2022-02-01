package com.tencent.qq.effect.sensor;

import android.content.Context;
import com.tencent.qq.effect.engine.Layout;
import com.tencent.qq.effect.engine.QEffectData;

public class SensorParams
{
  public boolean isInit;
  public int layerOffsetX;
  public int layerOffsetY;
  public int[] offsetX = new int[1];
  public int[] offsetY = new int[1];
  public float speed;
  
  public SensorParams(Context paramContext, QEffectData paramQEffectData)
  {
    this.layerOffsetX = Layout.getLayoutPx(paramContext, paramQEffectData.offsetX);
    this.layerOffsetY = Layout.getLayoutPx(paramContext, paramQEffectData.offsetY);
    this.speed = paramQEffectData.gravitySpeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.sensor.SensorParams
 * JD-Core Version:    0.7.0.1
 */