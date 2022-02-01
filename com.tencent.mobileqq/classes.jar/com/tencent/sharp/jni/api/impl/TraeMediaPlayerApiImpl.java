package com.tencent.sharp.jni.api.impl;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import com.tencent.sharp.jni.callback.OnCompletionListener;
import java.util.Timer;
import java.util.TimerTask;
import mqq.os.MqqHandler;

public class TraeMediaPlayerApiImpl
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, ITraeMediaPlayerApi
{
  static final String TAG = "TraeMediaPlayerImpl";
  private OnCompletionListener mCallback;
  private Context mContext;
  private int mDurationMs = -1;
  private boolean mHasCall = false;
  private boolean mLoop = false;
  int mLoopCount = 0;
  private MediaPlayer mMediaPlay = null;
  boolean mRingMode = false;
  private int mStreamType = 0;
  private Timer mWatchTimer = null;
  private TimerTask mWatchTimerTask = null;
  private int prevVolume = -1;
  
  private boolean initMediaPlayer(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString)
  {
    this.mMediaPlay = new MediaPlayer();
    this.mMediaPlay.setOnCompletionListener(this);
    this.mMediaPlay.setOnErrorListener(this);
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          this.mMediaPlay.release();
          this.mMediaPlay = null;
          return false;
        }
        this.mMediaPlay.setDataSource(paramString);
        return true;
      }
      this.mMediaPlay.setDataSource(this.mContext, paramUri);
      return true;
    }
    try
    {
      paramString = this.mContext.getResources().openRawResourceFd(paramInt2);
      try
      {
        this.mMediaPlay.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      }
      catch (Throwable localThrowable1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Throwable localThrowable2)
    {
      paramString = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("playRing exception: ");
    localStringBuilder.append(localThrowable2.getMessage());
    QLog.i("TraeMediaPlayerImpl", 1, localStringBuilder.toString(), localThrowable2);
    if (paramString != null)
    {
      paramString.close();
      return true;
    }
    paramString = new StringBuilder();
    paramString.append("playRing fail, res[");
    paramString.append(paramUri);
    paramString.append("], seq[");
    paramString.append(paramLong);
    paramString.append("]");
    QLog.w("TraeMediaPlayerImpl", 1, paramString.toString());
    this.mMediaPlay.release();
    this.mMediaPlay = null;
    if (this.mCallback != null)
    {
      if (QQAudioHelper.b())
      {
        ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(getClass()).postDelayed(new TraeMediaPlayerApiImpl.1(this, paramLong), 4000L);
        return false;
      }
      this.mCallback.a(paramLong);
    }
    return false;
  }
  
  private void loopMediaPlayer(long paramLong, boolean paramBoolean, int paramInt)
  {
    this.mLoop = paramBoolean;
    if (this.mLoop)
    {
      this.mLoopCount = 1;
      this.mDurationMs = -1;
    }
    else
    {
      this.mLoopCount = paramInt;
      this.mDurationMs = (this.mLoopCount * this.mMediaPlay.getDuration());
    }
    this.mLoopCount -= 1;
    if (this.mDurationMs > 0)
    {
      this.mWatchTimer = new Timer();
      this.mWatchTimerTask = new TraeMediaPlayerApiImpl.2(this, paramLong);
      this.mWatchTimer.schedule(this.mWatchTimerTask, this.mDurationMs + 1000);
    }
  }
  
  /* Error */
  private boolean resetMediaPlayer()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mMediaPlay	Landroid/media/MediaPlayer;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +46 -> 52
    //   9: aload_1
    //   10: invokevirtual 227	android/media/MediaPlayer:isPlaying	()Z
    //   13: ifeq +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 39	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mMediaPlay	Landroid/media/MediaPlayer;
    //   22: invokevirtual 82	android/media/MediaPlayer:release	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 39	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mMediaPlay	Landroid/media/MediaPlayer;
    //   30: goto +22 -> 52
    //   33: astore_1
    //   34: goto +11 -> 45
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   42: goto -17 -> 25
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 39	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mMediaPlay	Landroid/media/MediaPlayer;
    //   50: aload_1
    //   51: athrow
    //   52: aload_0
    //   53: getfield 55	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mWatchTimer	Ljava/util/Timer;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +17 -> 75
    //   61: aload_1
    //   62: invokevirtual 233	java/util/Timer:cancel	()V
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield 55	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mWatchTimer	Ljava/util/Timer;
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 57	com/tencent/sharp/jni/api/impl/TraeMediaPlayerApiImpl:mWatchTimerTask	Ljava/util/TimerTask;
    //   75: iconst_1
    //   76: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	TraeMediaPlayerApiImpl
    //   4	6	1	localMediaPlayer	MediaPlayer
    //   33	1	1	localObject	Object
    //   37	14	1	localException	Exception
    //   56	6	1	localTimer	Timer
    // Exception table:
    //   from	to	target	type
    //   18	25	33	finally
    //   38	42	33	finally
    //   18	25	37	java/lang/Exception
  }
  
  private void volumeUndo()
  {
    if ((this.mMediaPlay != null) && (this.mRingMode) && (this.mStreamType != 2))
    {
      if (this.prevVolume == -1) {
        return;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TraeMediaPlay volumeUndo prevVolume:");
          localStringBuilder.append(this.prevVolume);
          QLog.e("TraeMediaPlayerImpl", 2, localStringBuilder.toString());
        }
        ((AudioManager)this.mContext.getSystemService("audio")).setStreamVolume(this.mStreamType, this.prevVolume, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public int getDuration()
  {
    return this.mDurationMs;
  }
  
  public int getStreamType()
  {
    return this.mStreamType;
  }
  
  public boolean hasCall()
  {
    return this.mHasCall;
  }
  
  public void init(Context paramContext, OnCompletionListener paramOnCompletionListener)
  {
    this.mContext = paramContext;
    this.mCallback = paramOnCompletionListener;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.mLoop)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TraeMediaPlayerImpl", 2, "loop play, continue...");
      }
      return;
    }
    try
    {
      if (this.mLoopCount <= 0)
      {
        volumeUndo();
        if (this.mMediaPlay.isPlaying()) {
          this.mMediaPlay.stop();
        }
        this.mMediaPlay.reset();
        this.mMediaPlay.release();
        this.mMediaPlay = null;
        if (this.mCallback != null) {
          this.mCallback.a(-1024L);
        }
      }
      else
      {
        this.mMediaPlay.start();
        this.mLoopCount -= 1;
        return;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      this.mMediaPlay.release();
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
    this.mMediaPlay = null;
    paramMediaPlayer = this.mCallback;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.a(-1029L);
    }
    return false;
  }
  
  public boolean playRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("playRing, dataSource[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], rid[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], res[");
      ((StringBuilder)localObject).append(paramUri);
      ((StringBuilder)localObject).append("], strFilePath[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], loop[");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("], loopCount[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], ringMode[");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("], hasCall[");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append("], callStreamType[");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append("], devicesInfo[");
      ((StringBuilder)localObject).append(AppSetting.c);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeMediaPlayerImpl", 1, ((StringBuilder)localObject).toString());
    }
    if ((!paramBoolean1) && (paramInt3 <= 0)) {
      return false;
    }
    try
    {
      if (!resetMediaPlayer()) {
        return false;
      }
      localObject = (AudioManager)this.mContext.getSystemService("audio");
      if (!initMediaPlayer(paramLong, paramInt1, paramInt2, paramUri, paramString)) {
        return false;
      }
      this.mRingMode = paramBoolean2;
      paramBoolean2 = this.mRingMode;
      paramInt1 = 2;
      if (paramBoolean2)
      {
        this.mStreamType = 2;
        paramInt1 = 1;
      }
      else if ((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("MI 3")) && (!paramBoolean3))
      {
        this.mStreamType = 2;
      }
      else
      {
        this.mStreamType = 0;
        paramInt1 = 3;
      }
      this.mHasCall = paramBoolean3;
      if (this.mHasCall) {
        this.mStreamType = paramInt4;
      }
      this.mMediaPlay.setAudioStreamType(this.mStreamType);
      this.mMediaPlay.prepare();
      this.mMediaPlay.setLooping(paramBoolean1);
      this.mMediaPlay.start();
      if (!this.mHasCall) {
        ((AudioManager)localObject).setMode(paramInt1);
      }
      loopMediaPlayer(paramLong, paramBoolean1, paramInt3);
      if (QLog.isColorLevel())
      {
        paramUri = new StringBuilder();
        paramUri.append("playRing end, info, mLoopCount[");
        paramUri.append(this.mLoopCount);
        paramUri.append("], mMediaPlay.getDuration()[");
        paramUri.append(this.mMediaPlay.getDuration());
        paramUri.append("], durationMs[");
        paramUri.append(this.mDurationMs);
        paramUri.append("], seq[");
        paramUri.append(paramLong);
        paramUri.append("]");
        QLog.w("TraeMediaPlayerImpl", 1, paramUri.toString());
      }
      return true;
    }
    catch (Exception paramUri)
    {
      paramString = new StringBuilder();
      paramString.append("playRing, Exception, seq[");
      paramString.append(paramLong);
      paramString.append("]");
      QLog.w("TraeMediaPlayerImpl", 1, paramString.toString(), paramUri);
      try
      {
        this.mMediaPlay.release();
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
      }
      this.mMediaPlay = null;
    }
    return false;
  }
  
  public void stopRing(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopRing, mMediaPlay[");
      ((StringBuilder)localObject).append(this.mMediaPlay);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeMediaPlayerImpl", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mMediaPlay;
    if (localObject == null) {
      return;
    }
    if (((MediaPlayer)localObject).isPlaying()) {
      this.mMediaPlay.stop();
    }
    this.mMediaPlay.reset();
    try
    {
      if (this.mWatchTimer != null)
      {
        this.mWatchTimer.cancel();
        this.mWatchTimer = null;
        this.mWatchTimerTask = null;
      }
      this.mMediaPlay.release();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.mMediaPlay = null;
    this.mDurationMs = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.api.impl.TraeMediaPlayerApiImpl
 * JD-Core Version:    0.7.0.1
 */