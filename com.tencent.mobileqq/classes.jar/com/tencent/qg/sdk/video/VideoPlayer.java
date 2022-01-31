package com.tencent.qg.sdk.video;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qg.sdk.log.GLog;
import java.lang.ref.WeakReference;
import java.util.Stack;

public class VideoPlayer
{
  private static final int MSG_PAUSE = 3;
  private static final int MSG_PLAY = 1;
  private static final int MSG_SEEK = 4;
  private static final int MSG_STOP = 2;
  public static final String TAG = "QGVideoPlayer";
  private static Stack<WeakReference<IMediaPlayer>> sMediaPlayerWeakRefStack = new Stack();
  private final Context mContext;
  private int mCurrentPos = -1;
  private int mHeight;
  private boolean mIsLoop = false;
  private VideoPlayer.PlayHandler mPlayHandler;
  private HandlerThread mPlayThread;
  private IMediaPlayer mPlayer;
  public long mPlayerHandle;
  private String mSrc;
  private int mTextureId;
  private float mVolume = 1.0F;
  private int mWidth;
  
  public VideoPlayer(Context paramContext, long paramLong)
  {
    this.mContext = paramContext;
    this.mPlayerHandle = paramLong;
    if (!sMediaPlayerWeakRefStack.isEmpty())
    {
      paramContext = (IMediaPlayer)((WeakReference)sMediaPlayerWeakRefStack.peek()).get();
      if (paramContext != null) {
        this.mPlayer = paramContext;
      }
    }
    if (this.mPlayer == null) {
      throw new IllegalStateException("on create error , not found media player!");
    }
    this.mPlayer.create(paramLong);
    GLog.d("QGVideoPlayer", "on create , play handle = %d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static void activeMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    sMediaPlayerWeakRefStack.push(new WeakReference(paramIMediaPlayer));
  }
  
  private void checkThread()
  {
    if (this.mPlayThread == null)
    {
      this.mPlayThread = new HandlerThread("play_thread");
      this.mPlayThread.start();
      this.mPlayHandler = new VideoPlayer.PlayHandler(this, this.mPlayThread.getLooper());
    }
  }
  
  private void handlePause()
  {
    if (this.mPlayer == null)
    {
      GLog.e("QGVideoPlayer", "pause failed : player is null? why??");
      return;
    }
    this.mCurrentPos = this.mPlayer.getCurrentPosition();
    this.mPlayer.pause();
    nativeEvent(this.mPlayerHandle, "pause");
  }
  
  private void handlePlay()
  {
    if (TextUtils.isEmpty(this.mSrc))
    {
      GLog.e("QGVideoPlayer", "play failed : please set src first!");
      return;
    }
    this.mPlayer.setSrc(this.mSrc);
    this.mPlayer.setLooping(this.mIsLoop);
    this.mPlayer.setVolume(this.mVolume, this.mVolume);
    if (this.mCurrentPos > 0) {
      this.mPlayer.seekTo(this.mCurrentPos);
    }
    this.mPlayer.play(this.mTextureId, this.mWidth, this.mHeight);
    nativeEvent(this.mPlayerHandle, "play");
  }
  
  private void handleSeekTo(int paramInt)
  {
    if (this.mPlayer == null)
    {
      GLog.e("QGVideoPlayer", "seek failed : player is null");
      return;
    }
    this.mPlayer.seekTo(paramInt);
  }
  
  private void handleStop()
  {
    if (this.mPlayer == null)
    {
      GLog.e("QGVideoPlayer", "stop failed : player is null? why??");
      return;
    }
    this.mCurrentPos = -1;
    this.mPlayer.stop();
    nativeEvent(this.mPlayerHandle, "ended");
  }
  
  public static native void nativeEvent(long paramLong, String paramString);
  
  public static void unActiveMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    if (sMediaPlayerWeakRefStack.isEmpty()) {
      GLog.d("QGVideoPlayer", "unactive error ! no data in cache ,class = %s", new Object[] { paramIMediaPlayer.getClass() });
    }
    IMediaPlayer localIMediaPlayer;
    for (;;)
    {
      return;
      while (!sMediaPlayerWeakRefStack.isEmpty())
      {
        localIMediaPlayer = (IMediaPlayer)((WeakReference)sMediaPlayerWeakRefStack.peek()).get();
        if (localIMediaPlayer != null) {
          break label74;
        }
        sMediaPlayerWeakRefStack.pop();
        GLog.d("QGVideoPlayer", "unactive found useless player , remove it");
      }
    }
    label74:
    if (localIMediaPlayer == paramIMediaPlayer)
    {
      sMediaPlayerWeakRefStack.pop();
      GLog.d("QGVideoPlayer", "unactive success , class :%s , remove it", new Object[] { localIMediaPlayer.getClass() });
      return;
    }
    GLog.d("QGVideoPlayer", "unactive error , class not match ,need class :%s , rear class :%s", new Object[] { paramIMediaPlayer.getClass(), localIMediaPlayer.getClass() });
  }
  
  public int getCurrentTime()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.getDuration();
    }
    return 0;
  }
  
  public boolean isEnd()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.isEnd();
    }
    return false;
  }
  
  public boolean isMuted()
  {
    if (this.mPlayer != null) {
      this.mPlayer.isMuted();
    }
    return false;
  }
  
  public void pause()
  {
    if (this.mPlayHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 3;
      this.mPlayHandler.sendMessage(localMessage);
    }
  }
  
  public void play(int paramInt1, int paramInt2, int paramInt3)
  {
    checkThread();
    this.mTextureId = paramInt1;
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    this.mPlayHandler.sendMessage(localMessage);
  }
  
  public void release()
  {
    GLog.w("QGVideoPlayer", "onRelease!");
    if (this.mPlayer != null) {
      this.mPlayer.destroy();
    }
    this.mPlayer = null;
    this.mPlayThread.getLooper().quit();
    this.mPlayThread = null;
    this.mPlayHandler = null;
  }
  
  public void seek(int paramInt)
  {
    if (this.mPlayHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 4;
      localMessage.obj = Integer.valueOf(paramInt);
      this.mPlayHandler.sendMessage(localMessage);
    }
  }
  
  public void setLoop(boolean paramBoolean)
  {
    GLog.d("QGVideoPlayer", "setLoop:" + paramBoolean);
    this.mIsLoop = paramBoolean;
  }
  
  public void setMuted(boolean paramBoolean)
  {
    if (this.mPlayer != null) {
      this.mPlayer.setMuted(paramBoolean);
    }
  }
  
  public void setSrc(String paramString)
  {
    this.mSrc = paramString;
    GLog.d("QGVideoPlayer", " setSrc:" + paramString);
  }
  
  public void setVolume(float paramFloat)
  {
    GLog.d("QGVideoPlayer", "setVolume:" + paramFloat);
    this.mVolume = paramFloat;
  }
  
  public void stop()
  {
    if (this.mPlayHandler != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      this.mPlayHandler.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qg.sdk.video.VideoPlayer
 * JD-Core Version:    0.7.0.1
 */