package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TPAudioPassThroughPluginDetector
{
  private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
  private static final String TAG = "TPAudioPassThroughPluginDetector";
  private static boolean hasRegisterReceiver = false;
  private static boolean isInitted = false;
  private static List<TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener> listeners = new LinkedList();
  private static TPAudioPassThroughCapabilities mAudioPassThroughCapabilities = null;
  private static WeakReference<Context> mContextRef;
  private static Handler mHandler;
  private static boolean mIsAudioPassThroughPlugin = false;
  private static BroadcastReceiver mReceiver;
  
  public static void addListener(TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener paramAudioPassThroughPluginListener)
  {
    try
    {
      if ((listeners.add(paramAudioPassThroughPluginListener)) && (!hasRegisterReceiver))
      {
        registerReceiver();
        hasRegisterReceiver = true;
      }
      return;
    }
    finally {}
  }
  
  public static void deinit()
  {
    try
    {
      if ((isInitted) && (mContextRef != null))
      {
        mContextRef.clear();
        isInitted = false;
        TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "TPAudioPassThroughPluginDetector deinit succeed!");
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
  
  public static void init(Context paramContext)
  {
    try
    {
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "TPAudioPassThroughPluginDetector init enter!");
      if (isInitted) {
        return;
      }
      mContextRef = new WeakReference(paramContext.getApplicationContext());
      isInitted = true;
      mHandler = new Handler(getLooper());
      registerReceiver();
      hasRegisterReceiver = true;
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "TPAudioPassThroughPluginDetector init succeed!");
      return;
    }
    finally {}
  }
  
  public static boolean isAudioPassThroughPlugin()
  {
    try
    {
      boolean bool = mIsAudioPassThroughPlugin;
      return bool;
    }
    finally {}
  }
  
  public static boolean isAudioPassThroughSupport(int paramInt1, int paramInt2)
  {
    TPAudioPassThroughCapabilities localTPAudioPassThroughCapabilities = mAudioPassThroughCapabilities;
    boolean bool2 = false;
    if (localTPAudioPassThroughCapabilities != null)
    {
      boolean bool1 = bool2;
      if (localTPAudioPassThroughCapabilities.supportsEncoding(paramInt1))
      {
        bool1 = bool2;
        if (paramInt2 <= mAudioPassThroughCapabilities.getMaxChannelCount()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "isAudioPassThroughSupport failed, mAudioPassThroughCapabilities is not init yet!");
    return false;
  }
  
  private static void notifyAudioPassThroughStateChange(boolean paramBoolean)
  {
    int i;
    if (mIsAudioPassThroughPlugin == paramBoolean) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
    mIsAudioPassThroughPlugin = paramBoolean;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener)localIterator.next()).onAudioPassThroughPlugin(paramBoolean);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private static void onUpdateAudioCapabilities(TPAudioPassThroughCapabilities paramTPAudioPassThroughCapabilities)
  {
    if (!paramTPAudioPassThroughCapabilities.equals(mAudioPassThroughCapabilities))
    {
      mAudioPassThroughCapabilities = paramTPAudioPassThroughCapabilities;
      paramTPAudioPassThroughCapabilities = new StringBuilder();
      paramTPAudioPassThroughCapabilities.append("onUpdateAudioCapabilities AudioCapabilities:");
      paramTPAudioPassThroughCapabilities.append(mAudioPassThroughCapabilities.toString());
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", paramTPAudioPassThroughCapabilities.toString());
    }
  }
  
  private static void registerReceiver()
  {
    TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "registerReceiver enter");
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    if ((isInitted) && (mContextRef != null))
    {
      Object localObject2 = mReceiver;
      Object localObject1 = null;
      if (localObject2 == null) {
        mReceiver = new TPAudioPassThroughPluginDetector.HdmiAudioPlugBroadcastReceiver(null);
      }
      localObject2 = (Context)mContextRef.get();
      if (localObject2 == null)
      {
        TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
        return;
      }
      if (mReceiver != null)
      {
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("android.media.action.HDMI_AUDIO_PLUG");
        localObject1 = ((Context)localObject2).registerReceiver(mReceiver, (IntentFilter)localObject1, null, mHandler);
      }
      mAudioPassThroughCapabilities = TPAudioPassThroughCapabilities.getCapabilities((Context)localObject2, (Intent)localObject1);
      TPNativeLog.printLog(2, "TPAudioPassThroughPluginDetector", "registerReceiver leave");
      return;
    }
    TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
  }
  
  public static void removeListener(TPAudioPassThroughPluginDetector.AudioPassThroughPluginListener paramAudioPassThroughPluginListener)
  {
    try
    {
      listeners.remove(paramAudioPassThroughPluginListener);
      if ((listeners.isEmpty()) && (hasRegisterReceiver))
      {
        unregisterReceiver();
        hasRegisterReceiver = false;
      }
      return;
    }
    finally {}
  }
  
  private static void unregisterReceiver()
  {
    if (isInitted)
    {
      Object localObject = mContextRef;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if (localObject == null)
        {
          TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
          return;
        }
        ((Context)localObject).unregisterReceiver(mReceiver);
        return;
      }
    }
    TPNativeLog.printLog(4, "TPAudioPassThroughPluginDetector", "registerReceiver failed, TPAudioPassThroughPluginDetector is not init yet!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughPluginDetector
 * JD-Core Version:    0.7.0.1
 */