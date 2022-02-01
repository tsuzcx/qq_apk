package com.tencent.mobileqq.qqaudio.audioplayer;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class AudioDeviceHelper
{
  public static final List<Integer> a = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
  public static boolean b = true;
  public static int c = -1;
  public static volatile boolean d = false;
  
  public static void a(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getString(2131892709));
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("setLoudSpeakerState:");
      paramAppRuntime.append(paramBoolean);
      QLog.d("AudioDeviceHelper", 2, paramAppRuntime.toString());
    }
  }
  
  public static boolean a()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBluetoothAdapter != null)
    {
      if (!localBluetoothAdapter.isEnabled()) {
        return false;
      }
      bool1 = bool2;
      if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(2) == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      boolean bool = Boolean.parseBoolean(paramContext.getClass().getMethod("isWiredHeadsetOn", new Class[0]).invoke(paramContext, (Object[])null).toString());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  @TargetApi(14)
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!b) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null) {
      return false;
    }
    if (!localBluetoothAdapter.isEnabled()) {
      return false;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2) {
      return false;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2) {
      return false;
    }
    if (a.contains(Integer.valueOf(c))) {
      return false;
    }
    if (d) {
      return false;
    }
    if (paramAudioManager.isBluetoothScoOn()) {
      return false;
    }
    return paramAudioManager.isBluetoothScoAvailableOffCall();
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return true;
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getString(2131892709));
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static boolean b(Context paramContext)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "isBluetoothHeadsetOn(), isBluetoothA2dpOn = true");
      }
      return true;
    }
    return c(paramContext);
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    boolean bool1 = paramContext.isBluetoothScoOn();
    boolean bool2 = a(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isBluetoothScoOn(), isSCOOn = ");
      paramContext.append(bool1);
      paramContext.append(" | isNeedWaitOpenSCO = ");
      paramContext.append(bool2);
      QLog.d("AudioPlayer", 2, paramContext.toString());
    }
    return (bool1) || (bool2);
  }
  
  public static boolean d(Context paramContext)
  {
    return ((AudioManager)paramContext.getSystemService("audio")).isBluetoothScoOn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper
 * JD-Core Version:    0.7.0.1
 */