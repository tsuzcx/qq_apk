package com.tencent.mobileqq.theme.effect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SuppressLint({"AppCompatCustomView"})
public class QEffectLottieImageView
  extends DiniFlyAnimationView
  implements IQEffect<QEffectData, Drawable>, GravitySensor.GravitySensorListener
{
  private OnCompositionLoadedListener jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener = new QEffectLottieImageView.1(this);
  private QEffectData jdField_a_of_type_ComTencentQqEffectEngineQEffectData;
  protected SensorParams a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public QEffectLottieImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static QEffectData a(String paramString, int paramInt)
  {
    QEffectData localQEffectData = new QEffectData();
    localQEffectData.h = -1.0F;
    localQEffectData.w = -1.0F;
    localQEffectData.resType = 1;
    localQEffectData.type = 3;
    localQEffectData.src = paramString;
    localQEffectData.repeat = paramInt;
    return localQEffectData;
  }
  
  public void a(Drawable paramDrawable) {}
  
  public void draw(Canvas paramCanvas)
  {
    if (!paramCanvas.isHardwareAccelerated()) {
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean isGravityEnable()
  {
    return (this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData != null) && (this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData.gravity);
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData = paramQEffectData;
    this.jdField_a_of_type_ComTencentQqEffectSensorSensorParams = new SensorParams(getContext(), this.jdField_a_of_type_ComTencentQqEffectEngineQEffectData);
    if ((paramQEffectData.resType == 3) && (paramQEffectData.resId > 0)) {}
    while ((paramQEffectData.resType != 1) || (paramQEffectData.images == null)) {
      return;
    }
    setImageAssetsFolder(paramQEffectData.images);
    try
    {
      paramContext = new FileInputStream(paramQEffectData.src);
      paramQEffectView = new Bundle();
      paramQEffectView.putString("key", paramQEffectData.images + paramQEffectData.effectId);
      paramQEffectView.putString("path", paramQEffectData.images);
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(getContext(), paramContext, getLottieDrawable(), this.jdField_a_of_type_ComTencentMobileqqDiniflyOnCompositionLoadedListener, paramQEffectView, GlobalImageCache.a);
      setImageAssetDelegate(new QEffectLottieImageView.QEffectImageAssetDelegate());
      return;
    }
    catch (FileNotFoundException paramContext)
    {
      for (;;)
      {
        QLog.e("QEffectLottieImageView", 1, "QEffectLottieImageView", paramContext);
      }
    }
  }
  
  public void pause()
  {
    pauseAnimation();
  }
  
  public void play()
  {
    this.b = false;
  }
  
  public void resume()
  {
    resumeAnimation();
  }
  
  public void stop()
  {
    if ((QLog.isColorLevel()) && (!this.b)) {
      QLog.i("QEffectLottieImageView", 1, "lottie stop");
    }
    this.b = true;
    endAnimation();
  }
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.jdField_a_of_type_ComTencentQqEffectSensorSensorParams, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.effect.QEffectLottieImageView
 * JD-Core Version:    0.7.0.1
 */