package com.tencent.thumbplayer.core.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TPHeadsetPluginDetector
{
  private static final int AUDIO_TYPE_BLUETOOTH_A2DP = 2;
  private static final int AUDIO_TYPE_BUILTIN_OTHERS = 99;
  private static final int AUDIO_TYPE_BUILTIN_SPEAKER = 0;
  private static final int AUDIO_TYPE_HEADPHONES = 1;
  private static final String TAG = "TPHeadsetPluginDetector";
  private static boolean hasRegisterReceiver = false;
  private static boolean isInitted = false;
  private static List<TPHeadsetPluginDetector.HeadsetPluginListener> listeners = new LinkedList();
  private static WeakReference<Context> mContextRef;
  private static Set<Integer> mCurOutputs = null;
  private static BroadcastReceiver mReceiver;
  
  public static void addHeadsetPluginListener(TPHeadsetPluginDetector.HeadsetPluginListener paramHeadsetPluginListener)
  {
    try
    {
      if ((listeners.add(paramHeadsetPluginListener)) && (!hasRegisterReceiver))
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
        TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "HeadsetPluginDetector deinit succeed!");
        return;
      }
      return;
    }
    finally {}
  }
  
  private static AudioManager getAudioManager()
  {
    if (isInitted)
    {
      Object localObject = mContextRef;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if (localObject == null)
        {
          TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "getAudioManager failed, context is null, maybe is invalid!");
          return null;
        }
        localObject = (AudioManager)((Context)localObject).getApplicationContext().getSystemService("audio");
        if (localObject == null)
        {
          TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "getAudioManager failed, audioMgr is null!");
          return null;
        }
        return localObject;
      }
    }
    TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "getAudioManager failed, HeadsetPluginDetector is not init yet!");
    return null;
  }
  
  private static Set<Integer> getAudioOutputs()
  {
    HashSet localHashSet = new HashSet();
    Object localObject1 = getAudioManager();
    if (localObject1 == null) {
      return localHashSet;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = ((AudioManager)localObject1).getDevices(2);
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getType() == 2) {
            localHashSet.add(Integer.valueOf(0));
          } else if (localObject2.getType() == 8) {
            localHashSet.add(Integer.valueOf(2));
          } else if (localObject2.getType() == 3) {
            localHashSet.add(Integer.valueOf(1));
          }
          i += 1;
        }
      }
    }
    else
    {
      localHashSet.add(Integer.valueOf(0));
      if (isHeadsetPlugin()) {
        localHashSet.add(Integer.valueOf(1));
      }
      if (isBluetoothPlugin()) {
        localHashSet.add(Integer.valueOf(2));
      }
    }
    return localHashSet;
  }
  
  @TPMethodCalledByNative
  public static Set<Integer> getCurrentRoutes()
  {
    return mCurOutputs;
  }
  
  public static void init(Context paramContext)
  {
    try
    {
      if (isInitted) {
        return;
      }
      mContextRef = new WeakReference(paramContext.getApplicationContext());
      isInitted = true;
      initCurrentOutputs();
      TPNativeLog.printLog(2, "TPHeadsetPluginDetector", "HeadsetPluginDetector init succeed!");
      return;
    }
    finally {}
  }
  
  private static void initCurrentOutputs()
  {
    mCurOutputs = getAudioOutputs();
  }
  
  @TPMethodCalledByNative
  public static boolean isAudioRouteTypeOn(int paramInt)
  {
    Set localSet = mCurOutputs;
    if (localSet == null) {
      return false;
    }
    return localSet.contains(Integer.valueOf(paramInt));
  }
  
  @TPMethodCalledByNative
  public static boolean isBluetoothPlugin()
  {
    AudioManager localAudioManager = getAudioManager();
    if (localAudioManager == null) {
      return false;
    }
    return localAudioManager.isBluetoothA2dpOn();
  }
  
  @TPMethodCalledByNative
  public static boolean isHeadsetPlugin()
  {
    AudioManager localAudioManager = getAudioManager();
    if (localAudioManager == null) {
      return false;
    }
    return localAudioManager.isWiredHeadsetOn();
  }
  
  private static void notifyAudioOutputStateChange(Set<Integer> paramSet1, Set<Integer> paramSet2)
  {
    int i;
    if ((paramSet1 != null) && (paramSet2 != null) && (paramSet1.size() == paramSet2.size()) && (paramSet2.containsAll(paramSet1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
    mCurOutputs = paramSet2;
    try
    {
      Iterator localIterator = listeners.iterator();
      while (localIterator.hasNext()) {
        ((TPHeadsetPluginDetector.HeadsetPluginListener)localIterator.next()).onHeadsetPlugin(paramSet1, paramSet2);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramSet1;
    }
  }
  
  @RequiresApi(api=23)
  private static boolean registerDeviceCallback()
  {
    AudioManager localAudioManager = getAudioManager();
    if (localAudioManager == null) {
      return false;
    }
    localAudioManager.registerAudioDeviceCallback(new TPHeadsetPluginDetector.1(), null);
    return true;
  }
  
  private static void registerReceiver()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (registerDeviceCallback())) {
      return;
    }
    if (mReceiver == null) {
      mReceiver = new TPHeadsetPluginDetector.HeadsetPluginReceiver(null);
    }
    if (isInitted)
    {
      Object localObject = mContextRef;
      if (localObject != null)
      {
        localObject = (Context)((WeakReference)localObject).get();
        if (localObject == null)
        {
          TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
          return;
        }
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        ((Context)localObject).registerReceiver(mReceiver, localIntentFilter);
        return;
      }
    }
    TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, TPHeadsetPluginDetector is not init yet!");
  }
  
  public static void removeHeadsetPluginListener(TPHeadsetPluginDetector.HeadsetPluginListener paramHeadsetPluginListener)
  {
    try
    {
      listeners.remove(paramHeadsetPluginListener);
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
          TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, context is null, maybe is invalid!");
          return;
        }
        ((Context)localObject).unregisterReceiver(mReceiver);
        return;
      }
    }
    TPNativeLog.printLog(4, "TPHeadsetPluginDetector", "registerReceiver failed, HeadsetPluginDetector is not init yet!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPHeadsetPluginDetector
 * JD-Core Version:    0.7.0.1
 */