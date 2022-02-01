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
    sInstance.mAudioPlayer = paramAudioPlayer;
    return sInstance;
  }
  
  @Nullable
  public MediaPlayer applyMediaPlayer(String paramString, MediaPlayer.OnPreparedListener paramOnPreparedListener, MediaPlayer.OnErrorListener paramOnErrorListener, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    MediaPlayer localMediaPlayer;
    if (!this.mIdleList.isEmpty()) {
      localMediaPlayer = (MediaPlayer)this.mIdleList.remove(0);
    }
    for (;;)
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(QGRenderer.dataBundle))
      {
        localObject1 = localObject2;
        if (isFileExists(QGRenderer.dataBundle + "/" + paramString)) {
          localObject1 = QGRenderer.dataBundle + "/" + paramString;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(QGRenderer.extResPath))
      {
        localObject2 = localObject1;
        if (isFileExists(QGRenderer.extResPath + "/" + paramString)) {
          localObject2 = QGRenderer.extResPath + "/" + paramString;
        }
      }
      try
      {
        localMediaPlayer.reset();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localMediaPlayer.setDataSource((String)localObject2);
        }
        for (;;)
        {
          localMediaPlayer.setOnPreparedListener(paramOnPreparedListener);
          localMediaPlayer.setOnErrorListener(paramOnErrorListener);
          localMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
          localMediaPlayer.prepare();
          this.mRunningList.add(localMediaPlayer);
          return localMediaPlayer;
          if (this.mRunningList.size() < 10)
          {
            localMediaPlayer = new MediaPlayer();
            break;
          }
          Log.e("MediaPlayerPool", "all player are playing.");
          return null;
          paramString = QGRenderer.assetManager.openFd("www/" + paramString);
          localMediaPlayer.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
        }
        return null;
      }
      catch (Exception paramString)
      {
        Log.e("MediaPlayerPool", paramString.toString());
        if (localMediaPlayer != null) {
          localMediaPlayer.release();
        }
      }
    }
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
      for (;;)
      {
        GLog.e("MediaPlayerPool", "recycleMediaPlayer, Exception:%s", localException);
      }
    }
    this.mRunningList.remove(paramMediaPlayer);
    this.mIdleList.add(paramMediaPlayer);
  }
  
  public void releaseAll()
  {
    int j = 0;
    Object[] arrayOfObject = this.mRunningList.toArray();
    int k = arrayOfObject.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        MediaPlayer localMediaPlayer1 = (MediaPlayer)arrayOfObject[i];
        try
        {
          localMediaPlayer1.stop();
          localMediaPlayer1.release();
          i += 1;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          for (;;)
          {
            GLog.e("MediaPlayerPool", "releaseAll, runningList IllegalStateException:%s", localIllegalStateException1);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            GLog.e("MediaPlayerPool", "releaseAll, runningList Exception:%s", localException1);
          }
        }
      }
    }
    this.mRunningList.clear();
    arrayOfObject = this.mIdleList.toArray();
    k = arrayOfObject.length;
    i = j;
    for (;;)
    {
      if (i < k)
      {
        MediaPlayer localMediaPlayer2 = (MediaPlayer)arrayOfObject[i];
        try
        {
          localMediaPlayer2.release();
          i += 1;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          for (;;)
          {
            GLog.e("MediaPlayerPool", "releaseAll, idleList IllegalStateException:%s", localIllegalStateException2);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            GLog.e("MediaPlayerPool", "releaseAll, idleList Exception:%s", localException2);
          }
        }
      }
    }
    this.mIdleList.clear();
    if (this.mAudioPlayer != null)
    {
      this.mAudioPlayer.releaseThread();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.sdk.audio.MediaPlayerPool
 * JD-Core Version:    0.7.0.1
 */