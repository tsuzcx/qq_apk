package com.tencent.mobileqq.triton.render.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.render.RenderContext.ISwapListener;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FPSMonitor
  implements RenderContext.ISwapListener
{
  private TextView mFPS_tv;
  private CopyOnWriteArrayList<FPSCallback> mFpsCallbacks = new CopyOnWriteArrayList();
  private int mFpsCount = 0;
  private long mLastTime = 0L;
  private TTEngine mTritonEngine;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public FPSMonitor(TTEngine paramTTEngine, ViewGroup paramViewGroup, Context paramContext)
  {
    this.mTritonEngine = paramTTEngine;
    if (this.mTritonEngine.getQQEnv().isDebug())
    {
      this.mFPS_tv = new TextView(paramContext);
      this.mFPS_tv.setText("60.0");
      this.mFPS_tv.setTextColor(-16711936);
      paramTTEngine = new RelativeLayout.LayoutParams(-2, -2);
      paramTTEngine.addRule(11);
      paramTTEngine.setMargins(0, 50, 50, 0);
      paramViewGroup.addView(this.mFPS_tv, paramTTEngine);
    }
  }
  
  private void calculateFPS()
  {
    this.mFpsCount += 1;
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mLastTime;
    if (l2 >= 1000L)
    {
      float f = this.mFpsCount;
      onFPSChange(1000.0F / (float)l2 * f);
      this.mFpsCount = 0;
      this.mLastTime = l1;
    }
  }
  
  private void onFPSChange(float paramFloat)
  {
    if ((this.mTritonEngine.getQQEnv().isDebug()) && (this.mUIHandler != null)) {
      this.mUIHandler.post(new FPSMonitor.1(this, paramFloat));
    }
    if ((this.mFpsCallbacks != null) && (!this.mFpsCallbacks.isEmpty()))
    {
      Iterator localIterator = this.mFpsCallbacks.iterator();
      while (localIterator.hasNext()) {
        ((FPSCallback)localIterator.next()).onFPSChange(paramFloat);
      }
    }
  }
  
  public void addFPSCallback(FPSCallback paramFPSCallback)
  {
    this.mFpsCallbacks.add(paramFPSCallback);
  }
  
  public void onSwap()
  {
    calculateFPS();
  }
  
  public void removeFPSCallback(FPSCallback paramFPSCallback)
  {
    this.mFpsCallbacks.remove(paramFPSCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.monitor.FPSMonitor
 * JD-Core Version:    0.7.0.1
 */