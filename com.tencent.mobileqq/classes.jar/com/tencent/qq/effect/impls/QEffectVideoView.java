package com.tencent.qq.effect.impls;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.sensor.GravitySensor.GravitySensorListener;
import com.tencent.qq.effect.sensor.SensorParams;
import com.tencent.qq.effect.utils.QEffectUtils;

public class QEffectVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener, IQEffect<QEffectData, String>, GravitySensor.GravitySensorListener
{
  private static final String TAG = "QEffectVideoView";
  private QEffectData mEffectData;
  private String mFilePath;
  private MediaPlayer mMediaPlayer;
  private Thread mPlayThread;
  protected SensorParams mSensorParams;
  private Surface mSurface;
  
  public QEffectVideoView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QEffectVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QEffectVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    setSurfaceTextureListener(this);
  }
  
  public void complete(String paramString)
  {
    if ((!QEffectUtils.isEmpty(this.mFilePath)) && (this.mSurface != null) && (this.mPlayThread == null))
    {
      this.mPlayThread = new QEffectVideoView.PlayerVideo(this, null);
      this.mPlayThread.start();
    }
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
      this.mFilePath = paramQEffectData.src;
    }
    complete(this.mFilePath);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.v("QEffectVideoView", "onSurfaceTextureAvailable");
    this.mSurface = new Surface(paramSurfaceTexture);
    complete(this.mFilePath);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurface = null;
    this.mMediaPlayer.stop();
    this.mMediaPlayer.release();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.v("QEffectVideoView", "onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void pause()
  {
    this.mMediaPlayer.pause();
  }
  
  public void play() {}
  
  public void resume()
  {
    this.mMediaPlayer.start();
  }
  
  public void stop()
  {
    MediaPlayer localMediaPlayer = this.mMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.mMediaPlayer = null;
      this.mPlayThread = null;
    }
  }
  
  public void updateGravityData(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    QEffectUtils.updateGravityData(this, paramArrayOfFloat, this.mSensorParams, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.impls.QEffectVideoView
 * JD-Core Version:    0.7.0.1
 */