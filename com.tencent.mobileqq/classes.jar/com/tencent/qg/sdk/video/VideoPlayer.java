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
    paramContext = this.mPlayer;
    if (paramContext != null)
    {
      paramContext.create(paramLong);
      GLog.d("QGVideoPlayer", "on create , play handle = %d", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    throw new IllegalStateException("on create error , not found media player!");
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
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer == null)
    {
      GLog.e("QGVideoPlayer", "pause failed : player is null? why??");
      return;
    }
    this.mCurrentPos = localIMediaPlayer.getCurrentPosition();
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
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    float f = this.mVolume;
    localIMediaPlayer.setVolume(f, f);
    int i = this.mCurrentPos;
    if (i > 0) {
      this.mPlayer.seekTo(i);
    }
    this.mPlayer.play(this.mTextureId, this.mWidth, this.mHeight);
    nativeEvent(this.mPlayerHandle, "play");
  }
  
  private void handleSeekTo(int paramInt)
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer == null)
    {
      GLog.e("QGVideoPlayer", "seek failed : player is null");
      return;
    }
    localIMediaPlayer.seekTo(paramInt);
  }
  
  private void handleStop()
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer == null)
    {
      GLog.e("QGVideoPlayer", "stop failed : player is null? why??");
      return;
    }
    this.mCurrentPos = -1;
    localIMediaPlayer.stop();
    nativeEvent(this.mPlayerHandle, "ended");
  }
  
  public static native void nativeEvent(long paramLong, String paramString);
  
  public static void unActiveMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    if (sMediaPlayerWeakRefStack.isEmpty())
    {
      GLog.d("QGVideoPlayer", "unactive error ! no data in cache ,class = %s", new Object[] { paramIMediaPlayer.getClass() });
      return;
    }
    while (!sMediaPlayerWeakRefStack.isEmpty())
    {
      IMediaPlayer localIMediaPlayer = (IMediaPlayer)((WeakReference)sMediaPlayerWeakRefStack.peek()).get();
      if (localIMediaPlayer == null)
      {
        sMediaPlayerWeakRefStack.pop();
        GLog.d("QGVideoPlayer", "unactive found useless player , remove it");
      }
      else
      {
        if (localIMediaPlayer == paramIMediaPlayer)
        {
          sMediaPlayerWeakRefStack.pop();
          GLog.d("QGVideoPlayer", "unactive success , class :%s , remove it", new Object[] { localIMediaPlayer.getClass() });
          return;
        }
        GLog.d("QGVideoPlayer", "unactive error , class not match ,need class :%s , rear class :%s", new Object[] { paramIMediaPlayer.getClass(), localIMediaPlayer.getClass() });
      }
    }
  }
  
  public int getCurrentTime()
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer != null) {
      return localIMediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer != null) {
      return localIMediaPlayer.getDuration();
    }
    return 0;
  }
  
  public boolean isEnd()
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer != null) {
      return localIMediaPlayer.isEnd();
    }
    return false;
  }
  
  public boolean isMuted()
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.isMuted();
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
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.destroy();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoop:");
    localStringBuilder.append(paramBoolean);
    GLog.d("QGVideoPlayer", localStringBuilder.toString());
    this.mIsLoop = paramBoolean;
  }
  
  public void setMuted(boolean paramBoolean)
  {
    IMediaPlayer localIMediaPlayer = this.mPlayer;
    if (localIMediaPlayer != null) {
      localIMediaPlayer.setMuted(paramBoolean);
    }
  }
  
  public void setSrc(String paramString)
  {
    this.mSrc = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" setSrc:");
    localStringBuilder.append(paramString);
    GLog.d("QGVideoPlayer", localStringBuilder.toString());
  }
  
  public void setVolume(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVolume:");
    localStringBuilder.append(paramFloat);
    GLog.d("QGVideoPlayer", localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.video.VideoPlayer
 * JD-Core Version:    0.7.0.1
 */