package com.tencent.mtt.hippy.views.audioview;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mtt.hippy.utils.ContextHolder;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.ref.WeakReference;

public class AudioPlayManager
{
  private static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
  public static final int AUDIO_STREAM_TYPE = 3;
  public static final int PALY_START_POS = 0;
  public static final long PROGRESS_UPDATE_TIME = 1000L;
  private static final String TAG = "AudioPlayManager";
  private static Object afChangeListener;
  private static final AudioManager audioManager = (AudioManager)ContextHolder.getAppContext().getSystemService("audio");
  public static int gUniqPlayId;
  private static AudioPlayManager sInstance;
  private final SparseArray<Integer> mAudioPlayPositionList = new SparseArray();
  private final SparseArray<String> mAudioPlayUrlList = new SparseArray();
  private int mCurrentPlayID;
  private String mCurrentPlayUrl;
  private final Handler mHandler;
  private final HandlerThread mHandlerThread = new HandlerThread("HippyAudioPlayThread");
  private final SparseArray<AudioPlayManager.AudioManagerListener> mPlayCallbackListener = new SparseArray();
  private final Runnable mRunnable;
  private MediaPlayer mSysMediaPlayer = new MediaPlayer();
  
  public AudioPlayManager()
  {
    this.mSysMediaPlayer.setAudioStreamType(3);
    this.mSysMediaPlayer.setOnBufferingUpdateListener(new AudioPlayManager.1(this));
    this.mSysMediaPlayer.setOnPreparedListener(new AudioPlayManager.2(this));
    this.mSysMediaPlayer.setOnErrorListener(new AudioPlayManager.3(this));
    this.mSysMediaPlayer.setOnCompletionListener(new AudioPlayManager.4(this));
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
    this.mRunnable = new AudioPlayManager.5(this);
  }
  
  public static void abandonAudioFocus()
  {
    try
    {
      if (audioManager != null)
      {
        audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)afChangeListener);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("abandonAudioFocus: ");
      localStringBuilder.append(localThrowable.getMessage());
      LogUtils.d("AudioPlayManager", localStringBuilder.toString());
    }
  }
  
  private void fireProgressChange()
  {
    this.mHandler.post(this.mRunnable);
  }
  
  public static AudioPlayManager getInstance()
  {
    if (sInstance == null) {
      sInstance = new AudioPlayManager();
    }
    return sInstance;
  }
  
  public static int globalUiqPlayId()
  {
    int i = gUniqPlayId + 1;
    gUniqPlayId = i;
    return i;
  }
  
  public static int requestAudioFocus()
  {
    return requestAudioFocus(null);
  }
  
  public static int requestAudioFocus(AudioPlayManager.OnAudioStateChange paramOnAudioStateChange)
  {
    paramOnAudioStateChange = new WeakReference(paramOnAudioStateChange);
    try
    {
      afChangeListener = new AudioPlayManager.6(paramOnAudioStateChange);
      int i = audioManager.requestAudioFocus((AudioManager.OnAudioFocusChangeListener)afChangeListener, 3, 1);
      return i;
    }
    catch (Throwable paramOnAudioStateChange)
    {
      label37:
      break label37;
    }
    return 0;
  }
  
  public int currentPlayAudioDuration()
  {
    return this.mSysMediaPlayer.getDuration();
  }
  
  public int currentPlayAudioPosition()
  {
    return this.mSysMediaPlayer.getCurrentPosition();
  }
  
  public boolean pauseAudio(int paramInt)
  {
    Object localObject = (String)this.mAudioPlayUrlList.get(paramInt);
    if ((!TextUtils.isEmpty(this.mCurrentPlayUrl)) && (this.mCurrentPlayUrl.equals(localObject)) && (paramInt == this.mCurrentPlayID) && (this.mSysMediaPlayer.isPlaying()))
    {
      this.mSysMediaPlayer.pause();
      this.mAudioPlayPositionList.put(this.mCurrentPlayID, Integer.valueOf(this.mSysMediaPlayer.getCurrentPosition()));
      localObject = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
      if (localObject != null) {
        ((AudioPlayManager.AudioManagerListener)localObject).onPlayPause(this.mCurrentPlayUrl);
      }
      return true;
    }
    return false;
  }
  
  public boolean playAudio(int paramInt)
  {
    try
    {
      Object localObject1 = (String)this.mAudioPlayUrlList.get(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return false;
      }
      if ((this.mCurrentPlayID == paramInt) && (((String)localObject1).equals(this.mCurrentPlayUrl)))
      {
        if (!this.mSysMediaPlayer.isPlaying())
        {
          this.mSysMediaPlayer.start();
          localObject1 = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
          if (localObject1 != null) {
            if (((Integer)this.mAudioPlayPositionList.get(this.mCurrentPlayID, Integer.valueOf(0))).intValue() == 0) {
              ((AudioPlayManager.AudioManagerListener)localObject1).onPlayStart(this.mCurrentPlayUrl);
            } else {
              ((AudioPlayManager.AudioManagerListener)localObject1).onPlayResume(this.mCurrentPlayUrl);
            }
          }
          fireProgressChange();
        }
      }
      else
      {
        if (this.mSysMediaPlayer.isPlaying())
        {
          this.mSysMediaPlayer.pause();
          this.mAudioPlayPositionList.put(this.mCurrentPlayID, Integer.valueOf(this.mSysMediaPlayer.getCurrentPosition()));
          localObject2 = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
          if (localObject2 != null) {
            ((AudioPlayManager.AudioManagerListener)localObject2).onPlayPause(this.mCurrentPlayUrl);
          }
        }
        this.mCurrentPlayID = paramInt;
        this.mCurrentPlayUrl = ((String)localObject1);
        this.mSysMediaPlayer.reset();
        this.mSysMediaPlayer.setDataSource(this.mCurrentPlayUrl);
        this.mSysMediaPlayer.prepareAsync();
        this.mSysMediaPlayer.setDisplay(null);
      }
      return true;
    }
    catch (Exception localException)
    {
      this.mSysMediaPlayer.reset();
      this.mCurrentPlayUrl = null;
      this.mCurrentPlayID = -1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("play audio exception");
      ((StringBuilder)localObject2).append(localException.getMessage());
      LogUtils.d("AudioPlayManager", ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  public void release()
  {
    MediaPlayer localMediaPlayer = this.mSysMediaPlayer;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.stop();
      this.mSysMediaPlayer.reset();
      this.mSysMediaPlayer.release();
      this.mSysMediaPlayer = null;
      this.mPlayCallbackListener.clear();
      this.mAudioPlayUrlList.clear();
      this.mAudioPlayPositionList.clear();
      this.mCurrentPlayUrl = null;
      this.mCurrentPlayID = -1;
      this.mHandler.removeCallbacks(this.mRunnable);
    }
  }
  
  public boolean releaseAudio(int paramInt)
  {
    String str = (String)this.mAudioPlayUrlList.get(paramInt);
    if ((!TextUtils.isEmpty(this.mCurrentPlayUrl)) && (this.mCurrentPlayUrl.equals(str)) && (paramInt == this.mCurrentPlayID))
    {
      this.mSysMediaPlayer.stop();
      this.mSysMediaPlayer.reset();
      this.mCurrentPlayID = -1;
      this.mCurrentPlayUrl = "";
    }
    this.mAudioPlayUrlList.delete(paramInt);
    this.mPlayCallbackListener.delete(paramInt);
    this.mAudioPlayPositionList.delete(paramInt);
    return true;
  }
  
  public boolean seekTo(int paramInt1, int paramInt2)
  {
    String str = (String)this.mAudioPlayUrlList.get(paramInt1);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ((this.mCurrentPlayID == paramInt1) && (str.equals(this.mCurrentPlayUrl))) {
      this.mSysMediaPlayer.seekTo(paramInt2);
    }
    return true;
  }
  
  public boolean setAudioPlayUrl(int paramInt, String paramString, AudioPlayManager.AudioManagerListener paramAudioManagerListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.mAudioPlayUrlList.put(paramInt, paramString);
    if (paramAudioManagerListener != null) {
      this.mPlayCallbackListener.put(paramInt, paramAudioManagerListener);
    }
    return true;
  }
  
  public boolean stopAudio(int paramInt)
  {
    Object localObject = (String)this.mAudioPlayUrlList.get(paramInt);
    if ((!TextUtils.isEmpty(this.mCurrentPlayUrl)) && (this.mCurrentPlayUrl.equals(localObject)) && (paramInt == this.mCurrentPlayID) && (this.mSysMediaPlayer.isPlaying()))
    {
      this.mSysMediaPlayer.stop();
      this.mAudioPlayPositionList.put(this.mCurrentPlayID, Integer.valueOf(this.mSysMediaPlayer.getCurrentPosition()));
      localObject = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
      if (localObject != null) {
        ((AudioPlayManager.AudioManagerListener)localObject).onPlayPause(this.mCurrentPlayUrl);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager
 * JD-Core Version:    0.7.0.1
 */