package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RequiresApi(api=17)
public class TPScreenRefreshRateDetector
{
  public static final int DISPLAY_CHANGE = 10001;
  private static String TAG = "TPScreenRefreshRateDetector";
  private static boolean isInitted = false;
  private static List<TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener> listeners;
  private static WeakReference<Context> mContext = null;
  private static float mCurScreenRefreshRate;
  private static DisplayManager.DisplayListener mDisplayListener = new TPScreenRefreshRateDetector.2();
  private static DisplayManager mDisplayManager;
  private static Handler mHandler;
  private static WindowManager mWindowManager = null;
  
  static
  {
    listeners = new LinkedList();
    mCurScreenRefreshRate = 60.0F;
    mDisplayManager = null;
  }
  
  public static void addListener(TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener paramScreenRefreshRateChangedListener)
  {
    try
    {
      listeners.add(paramScreenRefreshRateChangedListener);
      return;
    }
    finally {}
  }
  
  public static void deinit()
  {
    try
    {
      if ((!isInitted) || (mContext == null)) {
        return;
      }
      mContext.clear();
      isInitted = false;
      TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector deinit succeed!");
      return;
    }
    finally {}
  }
  
  private static Looper getLooper()
  {
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {
      return localLooper;
    }
    return Looper.getMainLooper();
  }
  
  public static float getScreenRefreshRate()
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      TPNativeLog.printLog(4, TAG, "Current version can not get screen refresh rate, set default.");
      return mCurScreenRefreshRate;
    }
    if (mContext == null)
    {
      TPNativeLog.printLog(4, TAG, "Current mContext is null, set default.");
      return mCurScreenRefreshRate;
    }
    Object localObject1 = (Context)mContext.get();
    if (localObject1 != null)
    {
      if (mWindowManager == null) {
        mWindowManager = (WindowManager)((Context)localObject1).getSystemService("window");
      }
      if (mDisplayManager == null)
      {
        mDisplayManager = (DisplayManager)((Context)localObject1).getSystemService("display");
        mDisplayManager.registerDisplayListener(mDisplayListener, mHandler);
      }
      if (mWindowManager != null)
      {
        Object localObject2 = mWindowManager.getDefaultDisplay();
        localObject1 = ((Display)localObject2).getSupportedModes();
        localObject2 = ((Display)localObject2).getMode();
        TPNativeLog.printLog(2, TAG, "getMode width:" + ((Display.Mode)localObject2).getPhysicalWidth() + " height:" + ((Display.Mode)localObject2).getPhysicalHeight() + " refreshRate:" + ((Display.Mode)localObject2).getRefreshRate() + " ModeId:" + ((Display.Mode)localObject2).getModeId());
        TPNativeLog.printLog(2, TAG, "getSupportedModes length:" + localObject1.length);
        int i = 0;
        while (i < localObject1.length)
        {
          TPNativeLog.printLog(2, TAG, "getSupportedModes width:" + localObject1[i].getPhysicalWidth() + " height:" + localObject1[i].getPhysicalHeight() + " refreshRate:" + localObject1[i].getRefreshRate() + " ModeId:" + localObject1[i].getModeId());
          i += 1;
        }
        mCurScreenRefreshRate = ((Display.Mode)localObject2).getRefreshRate();
      }
    }
    return mCurScreenRefreshRate;
  }
  
  public static void init(Context paramContext)
  {
    try
    {
      TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init enter!");
      if (isInitted) {
        return;
      }
      mContext = new WeakReference(paramContext.getApplicationContext());
      isInitted = true;
      initHandleMsg();
      TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector init succeed!");
      return;
    }
    finally {}
  }
  
  public static void initHandleMsg()
  {
    mHandler = new TPScreenRefreshRateDetector.1(getLooper());
  }
  
  private static void notifyScreenRefreshRateChange(float paramFloat)
  {
    int i = 0;
    if (Math.abs(paramFloat - mCurScreenRefreshRate) >= 1.0F)
    {
      TPNativeLog.printLog(2, TAG, "notifyScreenRefreshRateChange Change From " + mCurScreenRefreshRate + " to " + paramFloat);
      i = 1;
    }
    if (i == 0) {
      return;
    }
    mCurScreenRefreshRate = paramFloat;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener)localIterator.next()).onScreenRefreshRateChanged(paramFloat);
      }
    }
    finally {}
  }
  
  public static void removeListener(TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener paramScreenRefreshRateChangedListener)
  {
    try
    {
      listeners.remove(paramScreenRefreshRateChangedListener);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector
 * JD-Core Version:    0.7.0.1
 */