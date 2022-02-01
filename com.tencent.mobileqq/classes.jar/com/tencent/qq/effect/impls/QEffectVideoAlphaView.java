package com.tencent.qq.effect.impls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

@SuppressLint({"AppCompatCustomView"})
public class QEffectVideoAlphaView
  extends PlayTextureView
  implements IQEffect<QEffectData, String>, GravitySensor.GravitySensorListener
{
  private String TAG = "QEffectVideoAlphaView";
  private QEffectData mEffectData;
  private String mFilepath;
  private boolean mPlay;
  protected SensorParams mSensorParams;
  
  public QEffectVideoAlphaView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QEffectVideoAlphaView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void complete(String paramString)
  {
    if (QEffectUtils.isEmpty(this.mFilepath))
    {
      Log.e(this.TAG, "complete filepath is null");
      return;
    }
    setOpaque(false);
    setLoopState(true);
    setPlayListener(new QEffectVideoAlphaView.1(this));
    setContentVisible(true);
    playFile(this.mFilepath);
    this.mPlay = true;
  }
  
  public boolean isGravityEnable()
  {
    QEffectData localQEffectData = this.mEffectData;
    return (localQEffectData != null) && (localQEffectData.gravity);
  }
  
  public void load(Context paramContext, QEffectView paramQEffectView, IQEffectLoad paramIQEffectLoad, QEffectData paramQEffectData)
  {
    this.mEffectData = paramQEffectData;
    this.mSensorParams = new SensorParams(getContext(), this.mEffectData);
    if (paramQEffectData.resType == 1) {
      this.mFilepath = paramQEffectData.src;
    }
    complete(paramQEffectData.src);
  }
  
  public void pause()
  {
    stop();
  }
  
  public void play() {}
  
  public void resume()
  {
    playFile(this.mFilepath);
  }
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.mSensorParams, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.impls.QEffectVideoAlphaView
 * JD-Core Version:    0.7.0.1
 */