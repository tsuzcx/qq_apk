package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AnimationView$Player
  implements Handler.Callback
{
  public static final int MSG_PLAY = 1;
  final int STATE_PLAYING = 1;
  final int STATE_READY = 0;
  final int STATE_STOP = 2;
  int mCurCycle = 0;
  int mCurFrame = 0;
  protected Handler mHandler;
  boolean mInvokeAnimStartEvent = false;
  int mState = 0;
  protected WeakReference<AnimationView> playViewRef;
  
  public AnimationView$Player(AnimationView paramAnimationView)
  {
    this.playViewRef = new WeakReference(paramAnimationView);
    this.mHandler = new Handler(this);
  }
  
  protected void autoPlay()
  {
    Object localObject = (AnimationView)this.playViewRef.get();
    if ((localObject == null) || (this.mState == 2)) {
      return;
    }
    Drawable localDrawable = getNextFrame((AnimationView)localObject);
    if (localDrawable != null) {
      ((AnimationView)localObject).setImageDrawable(localDrawable);
    }
    if (((AnimationView)localObject).mListener != null)
    {
      if ((this.mCurFrame != 1) || (this.mCurCycle <= 0)) {
        break label98;
      }
      ((AnimationView)localObject).mListener.onAnimationRepeat((AnimationView)localObject);
    }
    for (;;)
    {
      int i = getNextFrameDelay((AnimationView)localObject);
      localObject = this.mHandler.obtainMessage(1);
      this.mHandler.sendMessageDelayed((Message)localObject, i);
      return;
      label98:
      if ((this.mCurFrame == 1) && (this.mCurCycle == 0))
      {
        if (!this.mInvokeAnimStartEvent)
        {
          this.mInvokeAnimStartEvent = true;
          ((AnimationView)localObject).mListener.onAnimationStart((AnimationView)localObject);
        }
      }
      else if (this.mState == 2) {
        ((AnimationView)localObject).mListener.onAnimationEnd((AnimationView)localObject);
      }
    }
  }
  
  protected Drawable getNextFrame(AnimationView paramAnimationView)
  {
    if ((paramAnimationView == null) || (paramAnimationView.mAnimationInfo == null))
    {
      this.mState = 2;
      return null;
    }
    paramAnimationView = paramAnimationView.mAnimationInfo;
    if (this.mState == 2) {
      return null;
    }
    if (paramAnimationView.mOneCycleFrames.size() <= 0)
    {
      this.mState = 2;
      return null;
    }
    if ((this.mCurFrame < 0) || (this.mCurFrame > paramAnimationView.mOneCycleFrames.size()))
    {
      this.mState = 2;
      return null;
    }
    int k = this.mCurFrame + 1;
    int m = 0;
    int j = m;
    int i = k;
    if (paramAnimationView.mInfiniteFromInOnCycle > 0)
    {
      j = m;
      i = k;
      if (paramAnimationView.mInfiniteToInOnCycle > 0)
      {
        j = m;
        i = k;
        if (paramAnimationView.mInfiniteToInOnCycle > paramAnimationView.mInfiniteFromInOnCycle)
        {
          if (this.mCurFrame != paramAnimationView.mInfiniteToInOnCycle) {
            break label285;
          }
          i = paramAnimationView.mInfiniteFromInOnCycle;
          j = 1;
        }
      }
    }
    for (;;)
    {
      if (i > paramAnimationView.mOneCycleFrames.size())
      {
        if (paramAnimationView.mCycle < 0) {}
        for (this.mState = 2; this.mState == 2; this.mState = 2)
        {
          label173:
          return null;
          if ((paramAnimationView.mCycle == 0) || (this.mCurCycle < paramAnimationView.mCycle)) {
            break label173;
          }
        }
        k = 1;
      }
      for (;;)
      {
        this.mCurFrame = k;
        i = ((Integer)paramAnimationView.mOneCycleFrames.get(k - 1)).intValue();
        return (Drawable)paramAnimationView.mFrames.get(i);
        k = i;
        if (i == paramAnimationView.mOneCycleFrames.size())
        {
          k = i;
          if (j == 0)
          {
            this.mCurCycle += 1;
            k = i;
          }
        }
      }
      label285:
      j = 1;
      i = k;
    }
  }
  
  public int getNextFrameDelay(AnimationView paramAnimationView)
  {
    if ((paramAnimationView == null) || (paramAnimationView.mAnimationInfo == null)) {
      return 100;
    }
    if (this.mCurFrame >= paramAnimationView.mAnimationInfo.mOneCycleFrames.size()) {
      return paramAnimationView.mAnimationInfo.mDelay;
    }
    return paramAnimationView.mAnimationInfo.mInterval;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      autoPlay();
    }
  }
  
  public void pause()
  {
    stop();
  }
  
  public void play()
  {
    reset();
    this.mState = 1;
    autoPlay();
  }
  
  public void reset()
  {
    this.mCurFrame = 0;
    this.mCurCycle = 0;
    this.mState = 0;
    this.mInvokeAnimStartEvent = false;
  }
  
  public void resume()
  {
    AnimationView localAnimationView = (AnimationView)this.playViewRef.get();
    if ((this.mState == 1) || (localAnimationView == null)) {}
    do
    {
      return;
      this.mState = 1;
      autoPlay();
    } while (localAnimationView.mListener == null);
    localAnimationView.mListener.onAnimationStart(localAnimationView);
  }
  
  public void stop()
  {
    this.mState = 2;
    this.mHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.Player
 * JD-Core Version:    0.7.0.1
 */