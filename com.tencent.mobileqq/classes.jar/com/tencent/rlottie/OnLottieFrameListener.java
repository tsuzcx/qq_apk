package com.tencent.rlottie;

import android.os.Handler;
import android.os.Looper;

public class OnLottieFrameListener
  implements AXrLottieDrawable.OnFrameChangedListener
{
  private static final Handler uiHandler = new Handler(Looper.getMainLooper());
  
  public void onFrameChanged(AXrLottieDrawable paramAXrLottieDrawable, int paramInt) {}
  
  public void onRecycle()
  {
    uiHandler.post(new OnLottieFrameListener.4(this));
  }
  
  public void onRecycleOnUi() {}
  
  public void onRepeat(int paramInt, boolean paramBoolean)
  {
    uiHandler.post(new OnLottieFrameListener.1(this, paramInt, paramBoolean));
  }
  
  public void onRepeatOnUi(int paramInt, boolean paramBoolean) {}
  
  public void onStart()
  {
    uiHandler.post(new OnLottieFrameListener.3(this));
  }
  
  public void onStartOnUi() {}
  
  public void onStop(boolean paramBoolean)
  {
    uiHandler.post(new OnLottieFrameListener.2(this, paramBoolean));
  }
  
  public void onStopOnUi(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.OnLottieFrameListener
 * JD-Core Version:    0.7.0.1
 */