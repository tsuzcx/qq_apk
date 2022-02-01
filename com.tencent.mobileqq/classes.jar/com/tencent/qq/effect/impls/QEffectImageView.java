package com.tencent.qq.effect.impls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

@SuppressLint({"AppCompatCustomView"})
public class QEffectImageView
  extends ImageView
  implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener
{
  protected QEffectData mEffectData;
  protected SensorParams mSensorParams;
  
  public QEffectImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QEffectImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QEffectImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void complete(Drawable paramDrawable)
  {
    setImageDrawable(paramDrawable);
  }
  
  public boolean isGravityEnable()
  {
    return (this.mEffectData != null) && (this.mEffectData.gravity);
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.mEffectData = paramQEffectData;
    this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramIQEffectLoad.load(paramContext, this, paramQEffectData);
  }
  
  public void pause() {}
  
  public void play() {}
  
  public void resume() {}
  
  public void stop()
  {
    setImageDrawable(null);
  }
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.mSensorParams, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.impls.QEffectImageView
 * JD-Core Version:    0.7.0.1
 */