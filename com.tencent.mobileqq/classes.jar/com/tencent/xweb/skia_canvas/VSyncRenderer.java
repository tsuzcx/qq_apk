package com.tencent.xweb.skia_canvas;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class VSyncRenderer
  implements VSyncWaiter.VSyncWaiterCallback
{
  private static ThreadLocal<VSyncRenderer> sRendererList = new ThreadLocal();
  private final Map<Long, VSyncRenderer.AnimationCallback> mAnimationCallbackIdMap;
  private long mAnimationCallbackUniqueId;
  private final List<VSyncRenderer.PresentCallback> mPresentCallbackList;
  private final long mStartFrameTimeNanos;
  private final IXWebWorkingHandler mThreadHandler;
  private boolean mWaitingForNextVSync;
  
  VSyncRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    this.mThreadHandler = paramIXWebWorkingHandler;
    this.mPresentCallbackList = new LinkedList();
    this.mAnimationCallbackIdMap = new HashMap();
    this.mStartFrameTimeNanos = SystemClock.elapsedRealtimeNanos();
  }
  
  private void checkAndPost(Runnable paramRunnable)
  {
    if (this.mThreadHandler.isRunOnWorkingThread())
    {
      paramRunnable.run();
      return;
    }
    this.mThreadHandler.post(paramRunnable);
  }
  
  private long generateAnimationCallbackUniqueId()
  {
    long l = this.mAnimationCallbackUniqueId;
    this.mAnimationCallbackUniqueId = (1L + l);
    return l;
  }
  
  static VSyncRenderer getInstance()
  {
    return (VSyncRenderer)sRendererList.get();
  }
  
  static void initRenderer(IXWebWorkingHandler paramIXWebWorkingHandler)
  {
    if (sRendererList.get() == null) {
      sRendererList.set(new VSyncRenderer(paramIXWebWorkingHandler));
    }
  }
  
  private void schedulerNextVSync()
  {
    this.mWaitingForNextVSync = true;
    VSyncWaiter.getInstance().asyncWaitForVSync(this);
  }
  
  long addAnimationCallback(VSyncRenderer.AnimationCallback paramAnimationCallback)
  {
    long l = generateAnimationCallbackUniqueId();
    this.mAnimationCallbackIdMap.put(Long.valueOf(l), paramAnimationCallback);
    triggerNextVSync();
    return l;
  }
  
  void addPresentCallback(VSyncRenderer.PresentCallback paramPresentCallback)
  {
    this.mPresentCallbackList.add(paramPresentCallback);
    triggerNextVSync();
  }
  
  public void doFrame(long paramLong)
  {
    checkAndPost(new VSyncRenderer.1(this));
  }
  
  void removeAnimationCallback(long paramLong)
  {
    this.mAnimationCallbackIdMap.remove(Long.valueOf(paramLong));
  }
  
  void removePresentCallback(VSyncRenderer.PresentCallback paramPresentCallback)
  {
    this.mPresentCallbackList.remove(paramPresentCallback);
  }
  
  void triggerNextVSync()
  {
    if (!this.mWaitingForNextVSync) {
      schedulerNextVSync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.VSyncRenderer
 * JD-Core Version:    0.7.0.1
 */