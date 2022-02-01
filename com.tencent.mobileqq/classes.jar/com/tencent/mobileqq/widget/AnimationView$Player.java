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
  final int b = 0;
  final int c = 1;
  final int d = 2;
  int e = 0;
  int f = 0;
  int g = 0;
  boolean h = false;
  protected WeakReference<AnimationView> i;
  protected Handler j;
  
  public AnimationView$Player(AnimationView paramAnimationView)
  {
    this.i = new WeakReference(paramAnimationView);
    this.j = new Handler(this);
  }
  
  protected void a()
  {
    Object localObject = (AnimationView)this.i.get();
    if (localObject != null)
    {
      if (this.e == 2) {
        return;
      }
      Drawable localDrawable = b((AnimationView)localObject);
      if (localDrawable != null) {
        ((AnimationView)localObject).setImageDrawable(localDrawable);
      }
      if (((AnimationView)localObject).c != null) {
        if ((this.f == 1) && (this.g > 0)) {
          ((AnimationView)localObject).c.onAnimationRepeat((AnimationView)localObject);
        } else if ((this.f == 1) && (this.g == 0))
        {
          if (!this.h)
          {
            this.h = true;
            ((AnimationView)localObject).c.onAnimationStart((AnimationView)localObject);
          }
        }
        else if (this.e == 2) {
          ((AnimationView)localObject).c.onAnimationEnd((AnimationView)localObject);
        }
      }
      int k = getNextFrameDelay((AnimationView)localObject);
      localObject = this.j.obtainMessage(1);
      this.j.sendMessageDelayed((Message)localObject, k);
    }
  }
  
  protected Drawable b(AnimationView paramAnimationView)
  {
    if ((paramAnimationView != null) && (paramAnimationView.a != null))
    {
      paramAnimationView = paramAnimationView.a;
      if (this.e == 2) {
        return null;
      }
      if (paramAnimationView.mOneCycleFrames.size() <= 0)
      {
        this.e = 2;
        return null;
      }
      int k = this.f;
      if ((k >= 0) && (k <= paramAnimationView.mOneCycleFrames.size()))
      {
        int n = this.f + 1;
        int i1 = 0;
        k = n;
        int m = i1;
        if (paramAnimationView.mInfiniteFromInOnCycle > 0)
        {
          k = n;
          m = i1;
          if (paramAnimationView.mInfiniteToInOnCycle > 0)
          {
            k = n;
            m = i1;
            if (paramAnimationView.mInfiniteToInOnCycle > paramAnimationView.mInfiniteFromInOnCycle)
            {
              k = n;
              if (this.f == paramAnimationView.mInfiniteToInOnCycle) {
                k = paramAnimationView.mInfiniteFromInOnCycle;
              }
              m = 1;
            }
          }
        }
        if (k > paramAnimationView.mOneCycleFrames.size())
        {
          if (paramAnimationView.mCycle < 0) {
            this.e = 2;
          } else if ((paramAnimationView.mCycle != 0) && (this.g >= paramAnimationView.mCycle)) {
            this.e = 2;
          }
          if (this.e == 2) {
            return null;
          }
          n = 1;
        }
        else
        {
          n = k;
          if (k == paramAnimationView.mOneCycleFrames.size())
          {
            n = k;
            if (m == 0)
            {
              this.g += 1;
              n = k;
            }
          }
        }
        this.f = n;
        k = ((Integer)paramAnimationView.mOneCycleFrames.get(n - 1)).intValue();
        return (Drawable)paramAnimationView.mFrames.get(k);
      }
      this.e = 2;
      return null;
    }
    this.e = 2;
    return null;
  }
  
  public int getNextFrameDelay(AnimationView paramAnimationView)
  {
    if ((paramAnimationView != null) && (paramAnimationView.a != null))
    {
      if (this.f >= paramAnimationView.a.mOneCycleFrames.size()) {
        return paramAnimationView.a.mDelay;
      }
      return paramAnimationView.a.mInterval;
    }
    return 100;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      a();
    }
    return false;
  }
  
  public void pause()
  {
    stop();
  }
  
  public void play()
  {
    reset();
    this.e = 1;
    a();
  }
  
  public void reset()
  {
    this.f = 0;
    this.g = 0;
    this.e = 0;
    this.h = false;
  }
  
  public void resume()
  {
    AnimationView localAnimationView = (AnimationView)this.i.get();
    if (this.e != 1)
    {
      if (localAnimationView == null) {
        return;
      }
      this.e = 1;
      a();
      if (localAnimationView.c != null) {
        localAnimationView.c.onAnimationStart(localAnimationView);
      }
    }
  }
  
  public void stop()
  {
    this.e = 2;
    this.j.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.Player
 * JD-Core Version:    0.7.0.1
 */