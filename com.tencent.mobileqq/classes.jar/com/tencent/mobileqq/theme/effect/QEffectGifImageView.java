package com.tencent.mobileqq.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

@SuppressLint({"AppCompatCustomView"})
public class QEffectGifImageView
  extends ImageView
  implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener
{
  private QEffectData jdField_a_of_type_ComTencentQqEffectEngineQEffectData;
  protected SensorParams a;
  private final String jdField_a_of_type_JavaLangString = "QEffectGifImageView";
  
  public QEffectGifImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(Drawable paramDrawable)
  {
    setImageDrawable(paramDrawable);
  }
  
  public boolean isGravityEnable()
  {
    return (this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData != null) && (this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData.gravity);
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData = paramQEffectData;
    this.jdField_a_of_type_ComTencentQqEffectSensorSensorParams = new SensorParams(getContext(), this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData);
    if (QEffectUtils.isEmpty(paramQEffectData.src))
    {
      Log.e("QEffectGifImageView", " load data.src is null");
      return;
    }
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mPlayGifImage = true;
    a(URLDrawable.getFileDrawable(paramQEffectData.src, paramContext));
    AbstractGifImage.resumeAll();
  }
  
  public void pause() {}
  
  public void play() {}
  
  public void resume() {}
  
  public void stop() {}
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.jdField_a_of_type_ComTencentQqEffectSensorSensorParams, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.effect.QEffectGifImageView
 * JD-Core Version:    0.7.0.1
 */