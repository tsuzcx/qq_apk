package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.Display.Mode;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
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
  private static List<TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener> listeners = new LinkedList();
  private static WeakReference<Context> mContext;
  private static float mCurScreenRefreshRate = 60.0F;
  private static DisplayManager.DisplayListener mDisplayListener = new TPScreenRefreshRateDetector.2();
  private static DisplayManager mDisplayManager = null;
  private static Handler mHandler;
  private static WindowManager mWindowManager;
  
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
      if ((isInitted) && (mContext != null))
      {
        mContext.clear();
        isInitted = false;
        TPNativeLog.printLog(2, TAG, "TPScreenRefreshRateDetector deinit succeed!");
        return;
      }
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
    Object localObject1 = mContext;
    if (localObject1 == null)
    {
      TPNativeLog.printLog(4, TAG, "Current mContext is null, set default.");
      return mCurScreenRefreshRate;
    }
    localObject1 = (Context)((WeakReference)localObject1).get();
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
      localObject1 = mWindowManager;
      if (localObject1 != null)
      {
        Object localObject2 = ((WindowManager)localObject1).getDefaultDisplay();
        localObject1 = ((Display)localObject2).getSupportedModes();
        localObject2 = ((Display)localObject2).getMode();
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMode width:");
        localStringBuilder.append(((Display.Mode)localObject2).getPhysicalWidth());
        localStringBuilder.append(" height:");
        localStringBuilder.append(((Display.Mode)localObject2).getPhysicalHeight());
        localStringBuilder.append(" refreshRate:");
        localStringBuilder.append(((Display.Mode)localObject2).getRefreshRate());
        localStringBuilder.append(" ModeId:");
        localStringBuilder.append(((Display.Mode)localObject2).getModeId());
        TPNativeLog.printLog(2, str, localStringBuilder.toString());
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSupportedModes length:");
        localStringBuilder.append(localObject1.length);
        TPNativeLog.printLog(2, str, localStringBuilder.toString());
        int i = 0;
        while (i < localObject1.length)
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getSupportedModes width:");
          localStringBuilder.append(localObject1[i].getPhysicalWidth());
          localStringBuilder.append(" height:");
          localStringBuilder.append(localObject1[i].getPhysicalHeight());
          localStringBuilder.append(" refreshRate:");
          localStringBuilder.append(localObject1[i].getRefreshRate());
          localStringBuilder.append(" ModeId:");
          localStringBuilder.append(localObject1[i].getModeId());
          TPNativeLog.printLog(2, str, localStringBuilder.toString());
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
    Object localObject1;
    int i;
    if (Math.abs(paramFloat - mCurScreenRefreshRate) >= 1.0F)
    {
      localObject1 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyScreenRefreshRateChange Change From ");
      localStringBuilder.append(mCurScreenRefreshRate);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramFloat);
      TPNativeLog.printLog(2, (String)localObject1, localStringBuilder.toString());
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    mCurScreenRefreshRate = paramFloat;
    try
    {
      localObject1 = listeners.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((TPScreenRefreshRateDetector.ScreenRefreshRateChangedListener)((Iterator)localObject1).next()).onScreenRefreshRateChanged(paramFloat);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector
 * JD-Core Version:    0.7.0.1
 */