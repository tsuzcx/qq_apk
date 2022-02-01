package com.tencent.mobileqq.vas.theme.effect;

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
  protected SensorParams a;
  private QEffectData b;
  private boolean c = false;
  private boolean d = false;
  private OnCompositionLoadedListener e = new QEffectLottieImageView.1(this);
  
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
    QEffectData localQEffectData = this.b;
    return (localQEffectData != null) && (localQEffectData.gravity);
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.b = paramQEffectData;
    this.a = new SensorParams(getContext(), this.b);
    if ((paramQEffectData.resType == 3) && (paramQEffectData.resId > 0)) {
      return;
    }
    if ((paramQEffectData.resType == 1) && (paramQEffectData.images != null))
    {
      setImageAssetsFolder(paramQEffectData.images);
      try
      {
        paramContext = new FileInputStream(paramQEffectData.src);
        paramQEffectView = new Bundle();
        paramIQEffectLoad = new StringBuilder();
        paramIQEffectLoad.append(paramQEffectData.images);
        paramIQEffectLoad.append(paramQEffectData.effectId);
        paramQEffectView.putString("key", paramIQEffectLoad.toString());
        paramQEffectView.putString("path", paramQEffectData.images);
        LottieComposition.Factory.fromInputStreamWithCacheBitmap(getContext(), paramContext, getLottieDrawable(), this.e, paramQEffectView, GlobalImageCache.a);
      }
      catch (FileNotFoundException paramContext)
      {
        QLog.e("QEffectLottieImageView", 1, "QEffectLottieImageView", paramContext);
      }
      setImageAssetDelegate(new QEffectLottieImageView.QEffectImageAssetDelegate());
    }
  }
  
  public void pause()
  {
    pauseAnimation();
  }
  
  public void play()
  {
    this.d = false;
  }
  
  public void resume()
  {
    resumeAnimation();
  }
  
  public void stop()
  {
    if ((QLog.isColorLevel()) && (!this.d)) {
      QLog.i("QEffectLottieImageView", 1, "lottie stop");
    }
    this.d = true;
    endAnimation();
  }
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.effect.QEffectLottieImageView
 * JD-Core Version:    0.7.0.1
 */