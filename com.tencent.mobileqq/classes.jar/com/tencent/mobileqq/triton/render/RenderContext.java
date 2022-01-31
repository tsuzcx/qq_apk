package com.tencent.mobileqq.triton.render;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.view.Surface;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.JNICaller.RenderContext;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.render.monitor.BlackScreenMonitor;
import com.tencent.mobileqq.triton.render.monitor.FPSMonitor;
import com.tencent.mobileqq.triton.render.monitor.FirstScreenMonitor;
import com.tencent.mobileqq.triton.render.monitor.ScreenShootMonitor;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.touch.TouchEventManager;
import com.tencent.mobileqq.triton.views.GameUserInfoBtnManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JNIModule
@TTNativeModule(name="RenderContext")
public class RenderContext
{
  private static final String TAG = "RenderContext";
  private boolean bSupportES3;
  private int mCanvasHeight;
  private int mCanvasWidth;
  private Context mContext;
  private WeakReference<RenderContext.IFixedSizeListener> mFixedSizeListener;
  private GameGlobalView mGameGlobalView;
  private float mScale;
  private int mScreenHeight;
  private int mScreenWidth;
  private ArrayList<RenderContext.ISwapListener> mSwapListeners;
  private volatile TouchEventManager mTouchEventManager;
  private TTEngine mTritonEngine;
  
  public RenderContext(TTEngine paramTTEngine, Context paramContext)
  {
    this.mTritonEngine = paramTTEngine;
    this.mContext = paramContext.getApplicationContext();
    this.bSupportES3 = checkOpenGLES30(this.mContext);
    this.mSwapListeners = new ArrayList();
    TTLog.e("RenderContext", "initialize:" + this);
  }
  
  private boolean checkOpenGLES30(Context paramContext)
  {
    for (;;)
    {
      try
      {
        i = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
        if (i < 196608) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        TTLog.e("RenderContext", "get support ES3 error! " + paramContext.getMessage());
        int i = 0;
        continue;
      }
      if ((!this.mTritonEngine.getQQEnv().enableOpengles3()) || (i == 0)) {
        break label84;
      }
      return true;
      i = 0;
    }
    label84:
    return false;
  }
  
  @TTNativeCall
  private void onRenderContextInit()
  {
    ITTEngine.IListener localIListener = this.mTritonEngine.getEngineListener();
    if (localIListener != null) {
      localIListener.onInitFinish();
    }
  }
  
  @TTNativeCall
  private void onSwapBuffer()
  {
    if (this.mTritonEngine.getRenderContext() == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mTritonEngine.getRenderContext().getSwapListeners().iterator();
      while (localIterator.hasNext()) {
        ((RenderContext.ISwapListener)localIterator.next()).onSwap();
      }
    }
  }
  
  private void setFixedInternal(int paramInt1, int paramInt2)
  {
    this.mCanvasWidth = paramInt1;
    this.mCanvasHeight = paramInt2;
    if ((this.mFixedSizeListener != null) && (this.mFixedSizeListener.get() != null)) {
      ((RenderContext.IFixedSizeListener)this.mFixedSizeListener.get()).onFixedSize(paramInt1, paramInt2);
    }
    TTLog.i("RenderContext", "setFixedSize mCanvasWidth=" + paramInt1 + ", mCanvasHeight=" + paramInt2);
  }
  
  public void addSwapListener(RenderContext.ISwapListener paramISwapListener)
  {
    this.mSwapListeners.add(paramISwapListener);
  }
  
  public GameGlobalView createGameView(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat)
  {
    initScreenInfo(paramInt1, paramInt2, paramFloat);
    this.mTouchEventManager = new TouchEventManager(this.mTritonEngine, paramFloat);
    this.mGameGlobalView = new GameGlobalView(paramActivity, this);
    this.mTritonEngine.getUserInfoBtnManager().init(paramActivity, this.mGameGlobalView, paramFloat);
    addSwapListener(new FPSMonitor(this.mTritonEngine, this.mGameGlobalView, this.mContext));
    addSwapListener(new BlackScreenMonitor(this.mTritonEngine));
    addSwapListener(new FirstScreenMonitor(this.mTritonEngine));
    addSwapListener(new ScreenShootMonitor(this.mTritonEngine));
    return this.mGameGlobalView;
  }
  
  public void destroyRenderContext()
  {
    JNICaller.RenderContext.nSurfaceDestroyed(this, this.mTritonEngine.getNativeTTAppHandle());
  }
  
  public int getCanvasHeight()
  {
    return this.mCanvasHeight;
  }
  
  public int getCanvasWidth()
  {
    return this.mCanvasWidth;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeight;
  }
  
  public float getScreenScale()
  {
    return this.mScale;
  }
  
  public int getScreenWidth()
  {
    return this.mScreenWidth;
  }
  
  public <T extends RenderContext.ISwapListener> T getSwapListener(Class<T> paramClass)
  {
    if (paramClass != null)
    {
      Iterator localIterator = new ArrayList(this.mSwapListeners).iterator();
      while (localIterator.hasNext())
      {
        RenderContext.ISwapListener localISwapListener = (RenderContext.ISwapListener)localIterator.next();
        if (paramClass.isInstance(localISwapListener)) {
          return localISwapListener;
        }
      }
    }
    return null;
  }
  
  public List<RenderContext.ISwapListener> getSwapListeners()
  {
    return this.mSwapListeners;
  }
  
  public TouchEventManager getTouchEventManager()
  {
    return this.mTouchEventManager;
  }
  
  public void initRenderContext(Surface paramSurface)
  {
    JNICaller.RenderContext.nInitRenderContext(this, this.mTritonEngine.getNativeTTAppHandle(), paramSurface, this.bSupportES3, (int)(this.mScreenWidth / this.mScale), (int)(this.mScreenHeight / this.mScale), this.mScale);
  }
  
  public void initScreenInfo(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mScreenWidth = paramInt1;
    this.mScreenHeight = paramInt2;
    this.mScale = paramFloat;
  }
  
  public native void nExit(long paramLong);
  
  public native void nInitRenderContext(long paramLong, Surface paramSurface, boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat);
  
  public native void nOnPause(long paramLong);
  
  public native void nOnResume(long paramLong);
  
  public native void nSurfaceChanged(long paramLong, Surface paramSurface);
  
  public native void nSurfaceDestroyed(long paramLong);
  
  public native void nUpdateRenderContext(long paramLong);
  
  public void onDestroy()
  {
    JNICaller.RenderContext.nExit(this, this.mTritonEngine.getNativeTTAppHandle());
    this.mSwapListeners.clear();
    this.mGameGlobalView = null;
    if (this.mTouchEventManager != null)
    {
      this.mTouchEventManager.onDestroy();
      this.mTouchEventManager = null;
    }
    this.mContext = null;
  }
  
  public void rmSwapListener(RenderContext.ISwapListener paramISwapListener)
  {
    this.mSwapListeners.remove(paramISwapListener);
  }
  
  @TTNativeCall
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    setFixedInternal(paramInt1, paramInt2);
  }
  
  public void setFixedSizeListener(RenderContext.IFixedSizeListener paramIFixedSizeListener)
  {
    this.mFixedSizeListener = new WeakReference(paramIFixedSizeListener);
  }
  
  public void surfaceChanged(Surface paramSurface)
  {
    JNICaller.RenderContext.nSurfaceChanged(this, this.mTritonEngine.getNativeTTAppHandle(), paramSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.RenderContext
 * JD-Core Version:    0.7.0.1
 */