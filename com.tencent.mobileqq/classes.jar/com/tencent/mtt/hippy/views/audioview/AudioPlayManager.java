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
  private static int AUDIOFOCUS_LOSS_TRANSIENT = -2;
  public static final int AUDIO_STREAM_TYPE = 3;
  public static final int PALY_START_POS = 0;
  public static final long PROGRESS_UPDATE_TIME = 1000L;
  private static final String TAG = "AudioPlayManager";
  private static Object afChangeListener;
  private static AudioManager audioManager;
  public static int gUniqPlayId = 0;
  private static AudioPlayManager sInstance = null;
  private SparseArray<Integer> mAudioPlayPositionList = new SparseArray();
  private SparseArray<String> mAudioPlayUrlList = new SparseArray();
  private int mCurrentPlayID;
  private String mCurrentPlayUrl;
  private Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread("HippyAudioPlayThread");
  private SparseArray<AudioPlayManager.AudioManagerListener> mPlayCallbackListener = new SparseArray();
  private Runnable mRunnable;
  private MediaPlayer mSysMediaPlayer = new MediaPlayer();
  
  static
  {
    audioManager = (AudioManager)ContextHolder.getAppContext().getSystemService("audio");
  }
  
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
      if (audioManager != null) {
        audioManager.abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)afChangeListener);
      }
      return;
    }
    catch (Throwable localThrowable) {}
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
    catch (Throwable paramOnAudioStateChange) {}
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
    if ((TextUtils.isEmpty(this.mCurrentPlayUrl)) || (!this.mCurrentPlayUrl.equals(localObject)) || (paramInt != this.mCurrentPlayID) || (!this.mSysMediaPlayer.isPlaying())) {
      return false;
    }
    this.mSysMediaPlayer.pause();
    this.mAudioPlayPositionList.put(this.mCurrentPlayID, Integer.valueOf(this.mSysMediaPlayer.getCurrentPosition()));
    localObject = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
    if (localObject != null) {
      ((AudioPlayManager.AudioManagerListener)localObject).onPlayPause(this.mCurrentPlayUrl);
    }
    return true;
  }
  
  public boolean playAudio(int paramInt)
  {
    try
    {
      Object localObject = (String)this.mAudioPlayUrlList.get(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return false;
      }
      if ((this.mCurrentPlayID == paramInt) && (((String)localObject).equals(this.mCurrentPlayUrl)))
      {
        if (this.mSysMediaPlayer.isPlaying()) {
          break label292;
        }
        this.mSysMediaPlayer.start();
        localObject = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
        if (localObject != null)
        {
          if (((Integer)this.mAudioPlayPositionList.get(this.mCurrentPlayID, Integer.valueOf(0))).intValue() != 0) {
            break label117;
          }
          ((AudioPlayManager.AudioManagerListener)localObject).onPlayStart(this.mCurrentPlayUrl);
        }
        for (;;)
        {
          fireProgressChange();
          break;
          label117:
          ((AudioPlayManager.AudioManagerListener)localObject).onPlayResume(this.mCurrentPlayUrl);
        }
      }
      if (!this.mSysMediaPlayer.isPlaying()) {
        break label246;
      }
    }
    catch (Exception localException)
    {
      this.mSysMediaPlayer.reset();
      this.mCurrentPlayUrl = null;
      this.mCurrentPlayID = -1;
      LogUtils.d("AudioPlayManager", "play audio exception" + localException.getMessage());
      return false;
    }
    this.mSysMediaPlayer.pause();
    this.mAudioPlayPositionList.put(this.mCurrentPlayID, Integer.valueOf(this.mSysMediaPlayer.getCurrentPosition()));
    AudioPlayManager.AudioManagerListener localAudioManagerListener = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
    if (localAudioManagerListener != null) {
      localAudioManagerListener.onPlayPause(this.mCurrentPlayUrl);
    }
    label246:
    this.mCurrentPlayID = paramInt;
    this.mCurrentPlayUrl = localException;
    this.mSysMediaPlayer.reset();
    this.mSysMediaPlayer.setDataSource(this.mCurrentPlayUrl);
    this.mSysMediaPlayer.prepareAsync();
    this.mSysMediaPlayer.setDisplay(null);
    label292:
    return true;
  }
  
  public void release()
  {
    if (this.mSysMediaPlayer != null)
    {
      this.mSysMediaPlayer.stop();
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
    if ((TextUtils.isEmpty(this.mCurrentPlayUrl)) || (!this.mCurrentPlayUrl.equals(localObject)) || (paramInt != this.mCurrentPlayID) || (!this.mSysMediaPlayer.isPlaying())) {
      return false;
    }
    this.mSysMediaPlayer.stop();
    this.mAudioPlayPositionList.put(this.mCurrentPlayID, Integer.valueOf(this.mSysMediaPlayer.getCurrentPosition()));
    localObject = (AudioPlayManager.AudioManagerListener)this.mPlayCallbackListener.get(this.mCurrentPlayID);
    if (localObject != null) {
      ((AudioPlayManager.AudioManagerListener)localObject).onPlayPause(this.mCurrentPlayUrl);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.audioview.AudioPlayManager
 * JD-Core Version:    0.7.0.1
 */