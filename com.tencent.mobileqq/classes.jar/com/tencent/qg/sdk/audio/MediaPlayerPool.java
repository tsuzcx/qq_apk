package com.tencent.qg.sdk.audio;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qg.sdk.QGRenderer;
import com.tencent.qg.sdk.log.GLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaPlayerPool
{
  private static final int MAX_SIZE = 10;
  private static final String TAG = "MediaPlayerPool";
  private static MediaPlayerPool sInstance = new MediaPlayerPool();
  private AudioPlayer mAudioPlayer;
  private final List<MediaPlayer> mIdleList = Collections.synchronizedList(new ArrayList(10));
  private final List<MediaPlayer> mRunningList = Collections.synchronizedList(new ArrayList(10));
  
  public static MediaPlayerPool getInstance()
  {
    return sInstance;
  }
  
  public static MediaPlayerPool getInstance(AudioPlayer paramAudioPlayer)
  {
    MediaPlayerPool localMediaPlayerPool = sInstance;
    localMediaPlayerPool.mAudioPlayer = paramAudioPlayer;
    return localMediaPlayerPool;
  }
  
  @Nullable
  public MediaPlayer applyMediaPlayer(String paramString, MediaPlayer.OnPreparedListener paramOnPreparedListener, MediaPlayer.OnErrorListener paramOnErrorListener, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    Object localObject2;
    if (!this.mIdleList.isEmpty())
    {
      localObject2 = (MediaPlayer)this.mIdleList.remove(0);
    }
    else
    {
      if (this.mRunningList.size() >= 10) {
        break label398;
      }
      localObject2 = new ReportMediaPlayer();
    }
    if (!TextUtils.isEmpty(QGRenderer.dataBundle))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(QGRenderer.dataBundle);
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append(paramString);
      if (isFileExists(((StringBuilder)localObject1).toString()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(QGRenderer.dataBundle);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
        break label154;
      }
    }
    Object localObject1 = "";
    label154:
    Object localObject3 = localObject1;
    if (!TextUtils.isEmpty(QGRenderer.extResPath))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(QGRenderer.extResPath);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      localObject3 = localObject1;
      if (isFileExists(localStringBuilder.toString()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(QGRenderer.extResPath);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(paramString);
        localObject3 = ((StringBuilder)localObject1).toString();
      }
    }
    try
    {
      ((MediaPlayer)localObject2).reset();
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        ((MediaPlayer)localObject2).setDataSource((String)localObject3);
      }
      else
      {
        localObject1 = QGRenderer.assetManager;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("www/");
        ((StringBuilder)localObject3).append(paramString);
        paramString = ((AssetManager)localObject1).openFd(((StringBuilder)localObject3).toString());
        ((MediaPlayer)localObject2).setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      }
      ((MediaPlayer)localObject2).setOnPreparedListener(paramOnPreparedListener);
      ((MediaPlayer)localObject2).setOnErrorListener(paramOnErrorListener);
      ((MediaPlayer)localObject2).setOnCompletionListener(paramOnCompletionListener);
      ((MediaPlayer)localObject2).prepare();
      this.mRunningList.add(localObject2);
      return localObject2;
    }
    catch (Exception paramString)
    {
      Log.e("MediaPlayerPool", paramString.toString());
      if (localObject2 != null) {
        ((MediaPlayer)localObject2).release();
      }
      return null;
    }
    label398:
    Log.e("MediaPlayerPool", "all player are playing.");
    return null;
  }
  
  public boolean isFileExists(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public void recycleMediaPlayer(@NonNull MediaPlayer paramMediaPlayer)
  {
    if (!this.mRunningList.contains(paramMediaPlayer))
    {
      Log.e("MediaPlayerPool", "running list not contains player");
      return;
    }
    try
    {
      if (paramMediaPlayer.isPlaying()) {
        paramMediaPlayer.stop();
      }
      paramMediaPlayer.reset();
      paramMediaPlayer.setOnPreparedListener(null);
      paramMediaPlayer.setOnErrorListener(null);
      paramMediaPlayer.setOnCompletionListener(null);
    }
    catch (Exception localException)
    {
      GLog.e("MediaPlayerPool", "recycleMediaPlayer, Exception:%s", localException);
    }
    this.mRunningList.remove(paramMediaPlayer);
    this.mIdleList.add(paramMediaPlayer);
  }
  
  public void releaseAll()
  {
    Object localObject = this.mRunningList.toArray();
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      MediaPlayer localMediaPlayer1 = (MediaPlayer)localObject[i];
      try
      {
        localMediaPlayer1.stop();
        localMediaPlayer1.release();
      }
      catch (Exception localException1)
      {
        GLog.e("MediaPlayerPool", "releaseAll, runningList Exception:%s", localException1);
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        GLog.e("MediaPlayerPool", "releaseAll, runningList IllegalStateException:%s", localIllegalStateException1);
      }
      i += 1;
    }
    this.mRunningList.clear();
    localObject = this.mIdleList.toArray();
    k = localObject.length;
    i = j;
    while (i < k)
    {
      MediaPlayer localMediaPlayer2 = (MediaPlayer)localObject[i];
      try
      {
        localMediaPlayer2.release();
      }
      catch (Exception localException2)
      {
        GLog.e("MediaPlayerPool", "releaseAll, idleList Exception:%s", localException2);
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        GLog.e("MediaPlayerPool", "releaseAll, idleList IllegalStateException:%s", localIllegalStateException2);
      }
      i += 1;
    }
    this.mIdleList.clear();
    localObject = this.mAudioPlayer;
    if (localObject != null)
    {
      ((AudioPlayer)localObject).releaseThread();
      this.mAudioPlayer = null;
    }
  }
  
  public void releaseMediaPlayer(@NonNull MediaPlayer paramMediaPlayer)
  {
    if (!this.mRunningList.contains(paramMediaPlayer)) {
      Log.e("MediaPlayerPool", "running list not contains player");
    }
    try
    {
      paramMediaPlayer.release();
      return;
    }
    catch (Exception paramMediaPlayer) {}
    this.mRunningList.remove(paramMediaPlayer);
    try
    {
      if (paramMediaPlayer.isPlaying()) {
        paramMediaPlayer.stop();
      }
      paramMediaPlayer.setOnPreparedListener(null);
      paramMediaPlayer.setOnErrorListener(null);
      paramMediaPlayer.setOnCompletionListener(null);
      paramMediaPlayer.release();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      GLog.e("MediaPlayerPool", "releaseMediaPlayer, Exception:%s", paramMediaPlayer);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.audio.MediaPlayerPool
 * JD-Core Version:    0.7.0.1
 */