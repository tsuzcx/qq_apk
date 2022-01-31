package com.tencent.mobileqq.triton.touch;

import android.view.MotionEvent;
import com.tencent.mobileqq.triton.engine.TTEngine;
import java.util.ArrayList;

public class TouchEventManager
{
  private ArrayList<TTTouchEvents> mCurTouchList = new ArrayList();
  private long mGameBeginTime;
  private float mScreenScale;
  private TTTouchEvents mTTTouchEvents = new TTTouchEvents();
  private TTEngine mTritonEngine;
  
  public TouchEventManager(TTEngine paramTTEngine, float paramFloat)
  {
    this.mTritonEngine = paramTTEngine;
    this.mScreenScale = paramFloat;
  }
  
  private ArrayList<TTTouchEvents> getCurTouchListCopy()
  {
    ArrayList localArrayList = null;
    try
    {
      if (!this.mCurTouchList.isEmpty())
      {
        localArrayList = new ArrayList(this.mCurTouchList);
        this.mCurTouchList.clear();
      }
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void onTouch(int paramInt)
  {
    this.mTTTouchEvents.action = paramInt;
    TTTouchEvents localTTTouchEvents = this.mTTTouchEvents.copy();
    if (localTTTouchEvents.action == 5) {
      localTTTouchEvents.action = 0;
    }
    for (;;)
    {
      handleTouchEvent(localTTTouchEvents);
      return;
      if (localTTTouchEvents.action == 6) {
        localTTTouchEvents.action = 1;
      }
    }
  }
  
  public void flushTouchEvents()
  {
    ArrayList localArrayList = getCurTouchListCopy();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      nativeOnTouch(this.mTritonEngine.getNativeTTAppHandle(), localArrayList);
    }
  }
  
  public void handleTouchEvent(TTTouchEvents paramTTTouchEvents)
  {
    try
    {
      paramTTTouchEvents.timeStamp = (System.currentTimeMillis() - this.mGameBeginTime);
      this.mCurTouchList.add(paramTTTouchEvents);
      return;
    }
    finally
    {
      paramTTTouchEvents = finally;
      throw paramTTTouchEvents;
    }
  }
  
  public native void nativeOnTouch(long paramLong, ArrayList<TTTouchEvents> paramArrayList);
  
  public void onDestroy()
  {
    this.mTTTouchEvents.touches.clear();
    this.mTTTouchEvents.changedTouches.clear();
    this.mCurTouchList.clear();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int k = paramMotionEvent.getActionIndex();
    int n = paramMotionEvent.getPointerId(k);
    float f1 = paramMotionEvent.getX(k) / this.mScreenScale;
    float f2 = paramMotionEvent.getY(k) / this.mScreenScale;
    int m = paramMotionEvent.getActionMasked();
    this.mTTTouchEvents.changedTouches.clear();
    switch (m)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
    case 1: 
      for (;;)
      {
        return true;
        paramMotionEvent = new Touch(n, f1, f2);
        this.mTTTouchEvents.touches.add(paramMotionEvent);
        this.mTTTouchEvents.changedTouches.add(paramMotionEvent);
        onTouch(m);
        continue;
        i = 0;
        while (i < paramMotionEvent.getPointerCount())
        {
          k = paramMotionEvent.getPointerId(i);
          j = 0;
          while (j < this.mTTTouchEvents.touches.size())
          {
            Touch localTouch = (Touch)this.mTTTouchEvents.touches.get(j);
            if (localTouch.identifier == k)
            {
              f1 = paramMotionEvent.getX(i) / this.mScreenScale;
              f2 = paramMotionEvent.getY(i) / this.mScreenScale;
              if ((Math.abs(localTouch.screenX - f1) >= 0.01F) || (Math.abs(localTouch.screenY - f2) >= 0.01F))
              {
                localTouch.setLocation(f1, f2);
                this.mTTTouchEvents.changedTouches.add(localTouch);
              }
            }
            j += 1;
          }
          i += 1;
        }
        if (this.mTTTouchEvents.changedTouches.size() > 0)
        {
          onTouch(m);
          continue;
          do
          {
            j += 1;
            if (j >= this.mTTTouchEvents.touches.size()) {
              break;
            }
            paramMotionEvent = (Touch)this.mTTTouchEvents.touches.get(j);
          } while (paramMotionEvent.identifier != n);
          this.mTTTouchEvents.changedTouches.add(paramMotionEvent);
          this.mTTTouchEvents.touches.clear();
          onTouch(m);
        }
      }
    case 6: 
      do
      {
        i += 1;
        if (i >= this.mTTTouchEvents.touches.size()) {
          break;
        }
        paramMotionEvent = (Touch)this.mTTTouchEvents.touches.get(i);
      } while (paramMotionEvent.identifier != n);
      this.mTTTouchEvents.changedTouches.add(paramMotionEvent);
    }
    for (;;)
    {
      if ((this.mTTTouchEvents.touches.size() > 0) && (this.mTTTouchEvents.touches.size() > i)) {
        this.mTTTouchEvents.touches.remove(i);
      }
      onTouch(m);
      break;
      this.mTTTouchEvents.changedTouches.addAll(this.mTTTouchEvents.touches);
      this.mTTTouchEvents.touches.clear();
      onTouch(m);
      break;
      i = k;
    }
  }
  
  public void setBeginTime(long paramLong)
  {
    this.mGameBeginTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.touch.TouchEventManager
 * JD-Core Version:    0.7.0.1
 */